package com.project.dao.province;

import com.project.dao.CRUD;
import com.project.model.Tprovince;

import java.util.List;

public interface ITprovinceDAO extends CRUD<Tprovince> {

    List<Tprovince> listAllExceptById(Tprovince tprovince);
}
