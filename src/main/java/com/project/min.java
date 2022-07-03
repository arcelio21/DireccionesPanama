package com.project;

import com.project.dao.CRUD;
import com.project.dao.province.ProvinceDAOImpl;
import com.project.model.Tprovince;

import java.util.List;

public class min {

    public static void main(String[] args) {
         CRUD<Tprovince> provinces =new ProvinceDAOImpl();;

            System.out.println("TEST UNITARIA");

            List<Tprovince> provincias = provinces.listAll();
            provincias.forEach(System.out::println);
    }
}
