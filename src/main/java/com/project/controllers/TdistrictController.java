package com.project.controllers;

import com.project.model.Tdistrict;
import com.project.model.Tprovince;
import com.project.service.district.ITdistrictService;
import com.project.service.province.ITprovinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/districts")
public class TdistrictController {

    @Autowired
    private ITdistrictService tdistrictService;

    @Autowired
    private ITprovinceService tprovinceService;

    @RequestMapping("/list")
    public String begin(Model model){

        List<Tdistrict> tdistricts=tdistrictService.listAll();

        model.addAttribute("districts",tdistricts);

        return "district/listDistrict";
    }

    @RequestMapping("/filterProvince")
    public String filterByProvince(@RequestParam("id") String id, Model model){

        Tdistrict tdistrict=new Tdistrict();

        Integer idProv = Integer.valueOf(id);

        tdistrict.setIdProvincefk(new Tprovince(idProv,""));

        List<Tdistrict> tdistricts= tdistrictService.searchByProvinces(tdistrict);

        model.addAttribute("districts",tdistricts);
        model.addAttribute("idProv",idProv);

        return "district/filterProv";
    }

    @RequestMapping("/new")
    public String nuevo(Model model,@Nullable  @RequestParam("idProv") String id){

        Tdistrict tdistrict=new Tdistrict();
        List<Tprovince> tprovinces=tprovinceService.listAll();

        String url="";

        url=this.urlValidate(id,url);

        model.addAttribute("distritc",tdistrict);
        model.addAttribute("provinces",tprovinces);
        model.addAttribute("url",url);
        model.addAttribute("idProv",id);

        return "district/insertDistrict";
    }

    @PostMapping("/insert")
    public String insert(@ModelAttribute("distritc") Tdistrict tdistrict,@Nullable @RequestParam("idProv") String id){

        Tprovince tprovince=tprovinceService.searchBydId(tdistrict.getIdProvincefk());

        tdistrict.setIdProvincefk(tprovince);

        boolean validate=tdistrictService.save(tdistrict);

        if(!id.equals("")) {
            return validate ?"redirect:/districts/filterProvince?id="+id:"";
        } else{
            return "redirect:/districts/list";
        }
    }

    @RequestMapping("/edit")
    public String edit(Model model, @Nullable @RequestParam("idProv") String idProv,@RequestParam(value = "idDistric",required = false) String idDistric){

        Integer idDis=Integer.valueOf(idDistric);
        Tdistrict tdistrict=new Tdistrict(idDis);
        tdistrict=tdistrictService.searchBydId(tdistrict);

        List<Tprovince> tprovince =tprovinceService.listAllExceptById(tdistrict.getIdProvincefk());

        Map<Integer,String> listProvinces=new HashMap<>();
        tprovince.forEach(province->listProvinces.put(province.getId(),province.getName()));

        String url="";
        url=this.urlValidate(idProv,url);

        model.addAttribute("district",tdistrict);
        model.addAttribute("idProv",idProv);
        model.addAttribute("url",url);
        model.addAttribute("provinces",listProvinces);

        return "district/updateDistrict";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("distritc") Tdistrict tdistrict,@Nullable @RequestParam("idProv") String id){

        Tprovince tprovince=tprovinceService.searchBydId(tdistrict.getIdProvincefk());

        tdistrict.setIdProvincefk(tprovince);

        boolean validate=tdistrictService.update(tdistrict);

        if(!id.equals("")) {
            return validate ?"redirect:/districts/filterProvince?id="+id:"";
        } else{
            return "redirect:/districts/list";
        }
    }

    @RequestMapping("/delete")
    public String validDelete(@RequestParam("idDistric") String id,@Nullable @RequestParam("idProv") String idProv){

        Integer idDist=Integer.valueOf(id);

        Tdistrict tdistrict= new Tdistrict();
        tdistrict.setId(idDist);

        //boolean validate=tdistrictService.delete(tdistrict);

        if(idProv.equals("")) return "redirect:/districts/list";
        else return "redirect:/districts/filterProvince?id="+idProv;

    }

    private String urlValidate(String id,String url){
        if(id==null||id.equals("")) url+="districts/list";
        else url+="districts/filterProvince?id="+id;

        return url;
    }
}
