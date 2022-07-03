package com.project.controllers;


import com.project.model.Tprovince;
import com.project.service.province.ITprovinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/provinces")
public class ProvinceController {

    @Autowired
    ITprovinceService tprovinceService;

    @RequestMapping("/list")
    public String listProvinces(Model model){

        List<Tprovince> tprovinces=tprovinceService.listAll();

        model.addAttribute("provinces",tprovinces);

        return "listProvinces" ;
    }

    @RequestMapping("/nuevo")
    public String newProvince(Model model){

        Tprovince province= new Tprovince();

        model.addAttribute("prov",province);

        return "insertProvince";
    }


    @PostMapping("/insert") //CUANDO SE HACER UNA PETICION POST POR UN FORM
    public String insertProvince(@ModelAttribute("prov") Tprovince prov){

        //LOGICA DE INSERCION
        boolean validate=false;
        if(prov.getId()==null){
             validate=tprovinceService.save(prov);
        }else {
            validate=tprovinceService.update(prov);
        }



        return "redirect:/provinces/list";
    }

    @GetMapping(value = "/update") //CUANDO SE HACER UNA PETICION GET POR UN FORM o LINK
    public String updateProvince(@RequestParam("id") String id, Model model ){

        int idProvince=Integer.parseInt(id);
        Tprovince province= new Tprovince();
        province.setId(idProvince);

        province= tprovinceService.searchBydId(province);

        //System.out.println(province.getName());

        model.addAttribute("prov",province);
        return "insertProvince";
    }

    @RequestMapping("/delete")
    public String validDelete(@RequestParam("id") String id){

        Integer idProv=Integer.valueOf(id);

        Tprovince tprovince= new Tprovince();
        tprovince.setId(idProv);

        //boolean validate=tprovinceService.delete(tprovince);

        return "redirect:/provinces/list";
    }

}
