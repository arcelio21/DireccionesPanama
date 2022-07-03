package com.project.service.district;

import com.project.dao.CRUD;
import com.project.model.Tdistrict;

import java.util.List;

public interface ITdistrictService extends CRUD<Tdistrict> {

    List<Tdistrict> searchByProvinces(Tdistrict tdistrict);
    List<Tdistrict> listAllByName();
    List<Tdistrict> listAllExceptById(Tdistrict tdistrict);
}
