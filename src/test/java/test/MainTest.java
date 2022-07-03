package test;

import com.project.dao.CRUD;
import com.project.dao.province.ProvinceDAOImpl;
import com.project.model.Tprovince;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class MainTest  {

        private CRUD<Tprovince> provinces =new ProvinceDAOImpl();;

        @Test
        public void test(){
            System.out.println("TEST UNITARIA");

            List<Tprovince> provincias = provinces.listAll();
            provincias.forEach(System.out::println);
        }
}
