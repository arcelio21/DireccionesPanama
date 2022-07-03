package com.project.dao.province;

import com.project.model.Tprovince;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@EnableTransactionManagement
@Repository //RECONOSCA LA CLASE COMO UN REPOSTIROIO
public class ProvinceDAOImpl implements ITprovinceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional //ESTO ABER Y CIERA LA TRANSACCION SIN TENER QUE HACER DENTRO DEL METODO
    public List<Tprovince> listAll() {

        Session session = sessionFactory.getCurrentSession();


        Query query=  session.createQuery("SELECT p.id,p.name FROM Tprovince p ORDER BY p.id ASC");

        List result=query.getResultList();

        List<Tprovince> tprovinces= new ArrayList<>();
        for(Object obj:result){
            Object[] row=(Object[]) obj;
            tprovinces.add(new Tprovince(Integer.valueOf( row[0].toString()),row[1].toString()));

        }

        return tprovinces;
    }

    @Transactional
    @Override
    public List<Tprovince> listAllExceptById(Tprovince tprovince) {

        try{
            Session session=sessionFactory.getCurrentSession();
            Query<Tprovince> query=session.createQuery("SELECT new Tprovince (p.id,p.name) FROM Tprovince p WHERE p.id<>:idProv",Tprovince.class);
            query.setParameter("idProv",tprovince.getId());

            List<Tprovince> tprovinces=query.getResultList();

            return tprovinces;
        }catch (Exception e){
            e.printStackTrace(System.out);
            return  null;
        }

    }

    @Transactional
    @Override
    public Tprovince searchBydId(Tprovince tprovince) {


        try {
            Session session=sessionFactory.getCurrentSession();
            Tprovince provinceSearch= session.get(Tprovince.class,tprovince.getId());
            return provinceSearch;
        }catch (Exception e){
            e.printStackTrace(System.out);
            return null;
        }

    }

    @Transactional
    @Override
    public boolean save(Tprovince tprovince) {

        try{
            Session miSession=sessionFactory.getCurrentSession();
            miSession.persist(tprovince);
            //miSession.saveOrUpdate(tprovince);
            //
            return true;
        }catch (Exception e){
            e.printStackTrace(System.out);
            return false;
        }

    }

    @Transactional
    @Override
    public boolean update(Tprovince tprovince) {

        try{
            Session miSession=sessionFactory.getCurrentSession();
            miSession.saveOrUpdate(tprovince);
            return true;
        }catch (Exception e){
            e.printStackTrace(System.out);
            return false;
        }

    }

    @Transactional
    @Override
    public boolean delete(Tprovince tprovince) {
        try{
            Session session=sessionFactory.getCurrentSession();
            Query query=session.createQuery("DELETE  FROM Tprovince WHERE  id=:idProv");
            query.setParameter("idProv",tprovince.getId());
            int result=query.executeUpdate();
            return result == 1;
        }catch (Exception e){
            e.printStackTrace(System.out);
            return false;
        }
    }

    @Transactional
    @Override
    public Tprovince searchByName(Tprovince tprovince) {
        return null;
    }


}
