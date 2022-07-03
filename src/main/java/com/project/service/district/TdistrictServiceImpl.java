package com.project.service.district;

import com.project.dao.district.ITdistrictDAO;
import com.project.model.Tdistrict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TdistrictServiceImpl implements ITdistrictService{


    @Autowired
    private ITdistrictDAO tdistrictDAO;

    @Override
    public List<Tdistrict> listAll() {
        return tdistrictDAO.listAll();
    }

    @Override
    public Tdistrict searchBydId(Tdistrict tdistrict) {
        return tdistrictDAO.searchBydId(tdistrict);
    }

    @Override
    public boolean save(Tdistrict tdistrict) {
        return tdistrictDAO.save(tdistrict);
    }

    @Override
    public boolean update(Tdistrict tdistrict) {
        return tdistrictDAO.update(tdistrict);
    }

    @Override
    public boolean delete(Tdistrict tdistrict) {
        return tdistrictDAO.delete(tdistrict);
    }

    @Override
    public Tdistrict searchByName(Tdistrict tdistrict) {
        return tdistrictDAO.searchByName(tdistrict);
    }

    @Override
    public List<Tdistrict> searchByProvinces(Tdistrict tdistrict) {
        return tdistrictDAO.searchByProvinces(tdistrict);
    }

    @Override
    public List<Tdistrict> listAllByName() {
        return this.tdistrictDAO.listAllByName();
    }

    @Override
    public List<Tdistrict> listAllExceptById(Tdistrict tdistrict) {
        return this.tdistrictDAO.listAllExceptById(tdistrict);
    }
}
