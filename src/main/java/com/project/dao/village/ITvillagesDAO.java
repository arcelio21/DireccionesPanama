package com.project.dao.village;

import com.project.dao.CRUD;
import com.project.model.Tvillage;

import java.util.List;

public interface ITvillagesDAO extends CRUD<Tvillage> {

    List<Tvillage> searchByDistrict(Tvillage tvillage);

    List<Tvillage> listAllByName();


}
