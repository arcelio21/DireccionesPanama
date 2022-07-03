package com.project.controllers;

import com.project.model.Tdistrict;
import com.project.model.Tvillage;
import com.project.service.district.ITdistrictService;
import com.project.service.village.ITvillageService;
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
@RequestMapping("/village")
public class VillageController {

    @Autowired
    private ITvillageService tvillageService;

    @Autowired
    private ITdistrictService tdistrictService;

    @RequestMapping("/list")
    public String listVillage(Model model){


        model.addAttribute("villages",this.tvillageService.listAll());


        return "village/listVillage";
    }


    @RequestMapping("/filterDistrict")
    public String filterByProvince(@RequestParam("idDist") String id,@Nullable @RequestParam("idProv") String idProv ,Model model){

        Tvillage tvillage=new Tvillage();

        Integer idDist = Integer.valueOf(id);

        tvillage.setIdDistrictfk(new Tdistrict(idDist));

        List<Tvillage> tvillages= tvillageService.searchByDistrict(tvillage);

        String urlDist="";
        if(idProv==null||idProv.equals("")){
            urlDist="/districts/list";
        }else {
            urlDist="/districts/filterProvince?id="+idProv;
        }


        model.addAttribute("villages",tvillages);
        model.addAttribute("idDist",idDist);
        model.addAttribute("urlDistrict",urlDist);
        model.addAttribute("idProv",idProv);


        return "village/filterVillage";
    }

    @RequestMapping("/new")
    public String newVillage(Model model, @Nullable @RequestParam("idDist") String idDist,@Nullable @RequestParam("idProv") String idProv){

        String urlReturn=this.urlValidate(idDist,idProv);

        List<Tdistrict> tdistricts=this.tdistrictService.listAllByName();

        Map<Integer,String> districtMap=new HashMap<>();

        tdistricts.forEach(x->districtMap.put(x.getId(), x.getName()));

         model.addAttribute("idDist",idDist);
        model.addAttribute("village",new Tvillage());
        model.addAttribute("urlReturn",urlReturn);
        model.addAttribute("districtsMap",districtMap);

        if(idProv!=null&&!idProv.equals("")) model.addAttribute("idProv",idProv);

        return "village/insertVillage";
    }

    @PostMapping("/insert")
    public String insert(@ModelAttribute("village") Tvillage tvillage, @Nullable @RequestParam("idDist") String id,@Nullable @RequestParam("idProv") String idProv){

        Tdistrict tdistrict=tdistrictService.searchBydId(tvillage.getIdDistrictfk());

        tvillage.setIdDistrictfk(tdistrict);

        boolean validate=tvillageService.save(tvillage);

        if(!id.equals("")&&!idProv.equals("")) {
            return validate ?"redirect:/village/filterDistrict?idDist="+id+"&idProv="+idProv:"";
        } else{
            return "redirect:/village/list";
        }
    }

    @RequestMapping("/edit")
    public String edit(Model model,@Nullable @RequestParam("idProv") String idProv , @Nullable @RequestParam("idDist") String idDist,@RequestParam(value = "idVillage",required = false) String idVillage){

        Integer idVill=Integer.valueOf(idVillage);
        Tvillage tvillage=new Tvillage(idVill);
        tvillage=this.tvillageService.searchBydId(tvillage);

        List<Tdistrict> tdistricts =this.tdistrictService.listAllExceptById(tvillage.getIdDistrictfk());

        Map<Integer,String> districtMap=new HashMap<>();
        tdistricts.forEach(distric->districtMap.put(distric.getId(),distric.getName()));

        String url="";
        url=this.urlValidate(idDist,idProv);

        model.addAttribute("village",tvillage);
        model.addAttribute("idDist",idDist);
        model.addAttribute("idProv",idProv);
        model.addAttribute("url",url);
        model.addAttribute("district",districtMap);

        return "village/updateVillage";
    }


    @PostMapping("/update")
    public String update(@ModelAttribute("village") Tvillage tvillage,@Nullable @RequestParam("idDist") String id){

        Tdistrict tdistrict=this.tdistrictService.searchBydId(tvillage.getIdDistrictfk());

        tvillage.setIdDistrictfk(tdistrict);

        boolean validate=this.tvillageService.update(tvillage);

        if(!id.equals("")) {
            return validate ?"redirect:/village/filterDistrict?idDist="+id:"";
        } else{
            return "redirect:/village/list";
        }
    }

    @RequestMapping("/delete")
    public String validDelete( @Nullable @RequestParam("idDist") String idDist, @RequestParam("idVillage") String idVill){

        Integer idVillage=Integer.valueOf(idVill);

        Tvillage tvillage= new Tvillage();
        tvillage.setId(idVillage);

        //boolean validate=this.tvillageService.delete(tvillage);

        if(idDist.equals("")) return "redirect:/village/list";
        else return "redirect:/village/filterDistrict?idDist="+idDist;
    }

    private String urlValidate(String idDist,String idProv){
        String url = "";

        if(idDist==null||idDist.equals("")){
            url+="village/list";
        }else if(idProv==null||idProv.equals("")){
            url+="village/filterDistrict?idDist="+idDist;
        }else {
            url+="village/filterDistrict?idDist="+idDist+"&idProv="+idProv;
        }

        return url;
    }

}
