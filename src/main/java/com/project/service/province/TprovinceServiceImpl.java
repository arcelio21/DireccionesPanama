package com.project.service.province;

import com.project.dao.province.ITprovinceDAO;
import com.project.model.Tprovince;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TprovinceServiceImpl implements ITprovinceService {

    @Autowired
    private ITprovinceDAO iTprovinceDAO;

    @Override
    public List<Tprovince> listAll() {

        return iTprovinceDAO.listAll();
    }

    @Override
    public Tprovince searchBydId(Tprovince tprovince) {

        return iTprovinceDAO.searchBydId(tprovince);
    }

    @Override
    public boolean save(Tprovince tprovince) {
        return iTprovinceDAO.save(tprovince);
    }

    @Override
    public boolean update(Tprovince tprovince) {
        return iTprovinceDAO.update(tprovince);
    }

    @Override
    public boolean delete(Tprovince tprovince) {
        return iTprovinceDAO.delete(tprovince);
    }

    @Override
    public Tprovince searchByName(Tprovince tprovince) {
        return null;
    }

    @Override
    public List<Tprovince> listAllExceptById(Tprovince tprovince) {
        return iTprovinceDAO.listAllExceptById(tprovince);
    }
}
