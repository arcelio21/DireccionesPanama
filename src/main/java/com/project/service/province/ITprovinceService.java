package com.project.service.province;

import com.project.dao.CRUD;
import com.project.model.Tprovince;

import java.util.List;

public interface ITprovinceService extends CRUD<Tprovince> {

    List<Tprovince> listAllExceptById(Tprovince tprovince);

}
