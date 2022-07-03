package com.project.dao.village;

import com.project.model.Tdistrict;
import com.project.model.Tvillage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@EnableTransactionManagement
@Repository
public class VillageDAOImpl implements ITvillagesDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<Tvillage> listAll() {

        try{
            Session session=sessionFactory.getCurrentSession();

            Query<Tvillage> query=session.createQuery("SELECT new Tvillage (v.id,v.name,d) FROM Tvillage  v INNER JOIN Tdistrict d ON v.idDistrictfk.id=d.id ORDER BY v.id ASC ",Tvillage.class);

            List<Tvillage> tvillages=query.getResultList();

            return tvillages;
        }catch (Exception e){
            e.printStackTrace(System.out);
            return null;
        }
    }

    @Transactional
    @Override
    public Tvillage searchBydId(Tvillage tvillage) {

        try{
            Session session=sessionFactory.getCurrentSession();
            Tvillage tvillage1=session.get(Tvillage.class,tvillage.getId());

            return tvillage1;
        }catch (Exception e){
            e.printStackTrace(System.out);
            return null;
        }
    }

    @Transactional
    @Override
    public boolean save(Tvillage tvillage) {

        try{
            Session session=sessionFactory.getCurrentSession();

            session.save(tvillage);

            return true;
        }catch (Exception e){
            e.printStackTrace(System.out);
            return false;
        }
    }

    @Transactional
    @Override
    public boolean update(Tvillage tvillage) {

        try{
            Session session=sessionFactory.getCurrentSession();

            session.saveOrUpdate(tvillage);

            return true;
        }catch (Exception e){
            e.printStackTrace(System.out);
            return false;
        }
    }

    @Transactional
    @Override
    public boolean delete(Tvillage tvillage) {

        try {
            Session session=sessionFactory.getCurrentSession();

            session.delete(tvillage);
            return true;
        }catch (Exception e){
            e.printStackTrace(System.out);
            return false;
        }
    }

    @Transactional
    @Override
    public Tvillage searchByName(Tvillage tvillage) {

        try {
            Session session=sessionFactory.getCurrentSession();
            String query="SELECT v FROM Tvillage v WHERE v.name=:nameVill";
            Query<Tvillage> tvillageQuery=session.createQuery(query,Tvillage.class);
            tvillageQuery.setParameter("nameVill",tvillage.getName());

            Tvillage tvillageReturn=tvillageQuery.getSingleResult();

            return tvillageReturn;

        }catch (Exception e){
            e.printStackTrace(System.out);
            return null;
        }

    }

    @Transactional
    @Override
    public List<Tvillage> searchByDistrict(Tvillage tvillage) {

        try{
            Session session=sessionFactory.getCurrentSession();

            String select="SELECT new Tvillage (v.id,v.name,d)FROM Tvillage  v INNER JOIN Tdistrict d ON v.idDistrictfk.id=d.id WHERE v.idDistrictfk.id=:idDist ORDER BY  v.id ASC";

            Query<Tvillage> query=session.createQuery(select,Tvillage.class);
            query.setParameter("idDist",tvillage.getIdDistrictfk().getId());

            List<Tvillage> tvillages=query.getResultList();


            return tvillages;
        }catch (Exception e){
            e.printStackTrace(System.out);
            return null;
        }
    }

    @Transactional
    @Override
    public List<Tvillage> listAllByName() {

        try {
            Session session=sessionFactory.getCurrentSession();

            String query="SELECT new Tvillage (v.id,v.name) FROM Tvillage v ORDER BY v.name ASC";

            List<Tvillage> tvillages=session.createQuery(query,Tvillage.class).getResultList();

            return tvillages;

        }catch (Exception e){
            e.printStackTrace(System.out);
            return null;
        }
    }


}
