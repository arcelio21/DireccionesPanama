package com.project.dao.district;

import com.project.model.Tdistrict;
import com.project.model.Tprovince;
import com.project.model.Tvillage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@EnableTransactionManagement
@Repository
public class DistrictDAOImpl implements ITdistrictDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<Tdistrict> listAll() {

        try{
            Session session=sessionFactory.getCurrentSession();

            Query<Tdistrict> query=session.createQuery("SELECT new Tdistrict (d.id,d.name,p) FROM Tdistrict  d INNER JOIN Tprovince p ON d.idProvincefk.id=p.id ORDER BY d.id ASC ",Tdistrict.class);

            List<Tdistrict> tdistricts=query.getResultList();

            return tdistricts;
        }catch (Exception e){
            e.printStackTrace(System.out);
            return null;
        }

    }

    @Transactional
    @Override
    public Tdistrict searchBydId(Tdistrict tdistrict) {

        try{
            Session session=sessionFactory.getCurrentSession();

            Tdistrict tdistrict1=session.get(Tdistrict.class,tdistrict.getId());

            return tdistrict1;

        }catch (Exception e){
           e.printStackTrace(System.out);
           return null;
        }

    }

    @Transactional
    @Override
    public boolean save(Tdistrict tdistrict) {

        try{
            Session session=sessionFactory.getCurrentSession();
            session.persist(tdistrict);

            return true;
        }catch (Exception e){
            e.printStackTrace(System.out);
            return false;
        }

    }

    @Transactional
    @Override
    public boolean update(Tdistrict tdistrict) {

        try{
            Session session=sessionFactory.getCurrentSession();
            session.saveOrUpdate(tdistrict);
            return true;
        }catch (Exception e){
            e.printStackTrace(System.out);
            return false;
        }
    }

    @Transactional
    @Override
    public boolean delete(Tdistrict tdistrict) {

        try{
            Session session=sessionFactory.getCurrentSession();
            Query query = session.createQuery("DELETE FROM  Tdistrict  WHERE id=:idDist");
            query.setParameter("idDist",tdistrict.getId());

            int result=query.executeUpdate();

            return result==1;

        }catch (Exception e){
            e.printStackTrace(System.out);
            return  false;
        }
    }

    @Transactional
    @Override
    public Tdistrict searchByName(Tdistrict tdistrict) {
        return null;
    }

    @Transactional
    @Override
    public List<Tdistrict> searchByProvinces(Tdistrict tdistrict) {

        try{
            Session session=sessionFactory.getCurrentSession();

            String select="SELECT new Tdistrict (d.id,d.name,p)FROM Tdistrict  d INNER JOIN Tprovince p ON d.idProvincefk.id=p.id WHERE d.idProvincefk.id=:idProv ORDER BY  d.id ASC";

            Query<Tdistrict> query=session.createQuery(select,Tdistrict.class);
            query.setParameter("idProv",tdistrict.getIdProvincefk().getId());

            List<Tdistrict> tdistricts=query.getResultList();


            return tdistricts;
        }catch (Exception e){
            e.printStackTrace(System.out);
            return null;
        }

    }

    @Transactional
    @Override
    public List<Tdistrict> listAllByName() {

        try {
            Session session=sessionFactory.getCurrentSession();

            String query="SELECT new Tdistrict(d.id,d.name)FROM Tdistrict d ORDER BY d.name ASC";

            List<Tdistrict> tdistricts=session.createQuery(query,Tdistrict.class).getResultList();

            return tdistricts;

        }catch (Exception e){
            e.printStackTrace(System.out);
            return null;
        }
    }

    @Transactional
    @Override
    public List<Tdistrict> listAllExceptById(Tdistrict tdistrict) {
        try{
            Session session=sessionFactory.getCurrentSession();
            Query<Tdistrict> query=session.createQuery("SELECT new Tdistrict (d.id,d.name) FROM Tdistrict d WHERE d.id<>:idDist",Tdistrict.class);
            query.setParameter("idDist",tdistrict.getId());

            List<Tdistrict> tdistricts=query.getResultList();

            return tdistricts;
        }catch (Exception e){
            e.printStackTrace(System.out);
            return  null;
        }
    }
}
