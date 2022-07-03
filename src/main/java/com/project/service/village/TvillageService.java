package com.project.service.village;

import com.project.dao.village.ITvillagesDAO;
import com.project.model.Tvillage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TvillageService implements ITvillageService{

    @Autowired
    private ITvillagesDAO iTvillagesDAO;

    @Override
    public List<Tvillage> listAll() {
        return this.iTvillagesDAO.listAll();
    }

    @Override
    public Tvillage searchBydId(Tvillage tvillage) {
        return this.iTvillagesDAO.searchBydId(tvillage);
    }

    @Override
    public boolean save(Tvillage tvillage) {
        return this.iTvillagesDAO.save(tvillage);
    }

    @Override
    public boolean update(Tvillage tvillage) {
        return this.iTvillagesDAO.update(tvillage);
    }

    @Override
    public boolean delete(Tvillage tvillage) {
        return this.iTvillagesDAO.delete(tvillage);
    }

    @Override
    public Tvillage searchByName(Tvillage tvillage) {
        return this.iTvillagesDAO.searchByName(tvillage);
    }

    @Override
    public List<Tvillage> searchByDistrict(Tvillage tvillage) {
        return this.iTvillagesDAO.searchByDistrict(tvillage);
    }

    @Override
    public List<Tvillage> listAllByName() {
        return null;
    }
}
