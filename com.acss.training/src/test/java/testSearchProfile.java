/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.acss.training.Company;
import com.acss.training.Profile;
import com.acss.training.util.OrmTestUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mpineda
 */
public class testSearchProfile {
    
    private SessionFactory sessionFactory;
    
    public testSearchProfile() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        sessionFactory = OrmTestUtil.getSessionFactory();
        
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void testCriteriaSearch(){
        Session session = sessionFactory.openSession();
        
        Criteria criteria = session.createCriteria(Company.class);
        
        criteria.add(Restrictions.ilike("companyName", "%a%"));
        criteria.add(Restrictions.ilike("companyName", "%i%"));
        

        int startingIndex = 0;
        int resultPerPage = 5;
        criteria.setFirstResult(startingIndex * resultPerPage);
        criteria.setMaxResults(resultPerPage);
        
        List <Company> result = criteria.list();
        
        System.out.format("\n\nResult Size: %d\n\n",result.size());
        
        for(Company com: result){
            System.out.format("ID: %d\n",  com.getCompanyId());
            System.out.format("First Name: %s\n",  com.getCompanyName());
            //System.out.format("Middle Name: %s\n", com.getAddrStreet());
            System.out.format("Last Name: %s\n",  com.hashCode());
            System.out.format("\n\n");
        }
        
        session.close();
    }
    
    
//    public void testHSQLSearch(){
//        Session session = sessionFactory.openSession();
//        
//        Query query = session.createQuery("from Company company where companyName like ?"
//                + "and addrDistrict like ?");
//        query.setString(0, "%a%");
//        query.setString(1, "%i%");
//        
//        List <Company> result = query.list();
//        
//        System.out.format("\n\nResult Size: %d\n\n",result.size());
//        
//        for(Company com: result){
//            System.out.format("ID: %d\n",  com.getCompanyId());
//            System.out.format("First Name: %s\n",  com.getCompanyName());
//            System.out.format("Middle Name: %s\n", com.getAddrStreet());
//            System.out.format("Last Name: %s\n",  com.hashCode());
//            System.out.format("\n\n");
//        }
//        
//        session.close();  
//    }
    
//    @Test
    public void testNativeSQL(){
//        Session session = sessionFactory.openSession();
//        
//        
//        SQLQuery query = session.createSQLQuery("select * from m_company mc " 
//                + "where mc.comp_name ilike ? and mc.addr_province ilike ?");
//        query.addEntity(Company.class);
//        query.setString(0,"%a%");
//        query.setString(1, "B%");
//        
//        List <Company> result = query.list();
//        
//        System.out.format("\n\nResult Size: %d\n\n",result.size());
//        
//        for(Company com: result){
//            System.out.format("ID: %d\n",  com.getCompanyId());
//            System.out.format("First Name: %s\n",  com.getCompanyName());
//            System.out.format("Middle Name: %s\n", com.getAddrStreet());
//            System.out.format("Last Name: %s\n",  com.hashCode());
//            System.out.format("\n\n");
//        }
//        
//        session.close();
//        
     }
}
