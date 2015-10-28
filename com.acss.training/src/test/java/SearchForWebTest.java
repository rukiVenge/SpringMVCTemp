/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.acss.training.TrialCustomerBean;
import com.acss.training.util.OrmTestUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
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
public class SearchForWebTest {
    public SessionFactory sessionFactory;
    
    public SearchForWebTest() {
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
    public void CriteriaSearch(){
        
        Session session = sessionFactory.openSession();
        
        Criteria criteria = session.createCriteria(TrialCustomerBean.class);
        
        criteria.add(Restrictions.ilike("firstName", "%a%"));
        criteria.add(Restrictions.ilike("lastName", "%i%"));
        criteria.add(Restrictions.ilike("lastName", "%u%"));
        criteria.add(Restrictions.ilike("lastName", "%e%"));
        criteria.add(Restrictions.ilike("lastName", "%o%"));
//        int startingIndex = 0;
//        int resultPerPage = 5;
//        criteria.setFirstResult(startingIndex * resultPerPage);
//        criteria.setMaxResults(resultPerPage);
        
        List <TrialCustomerBean> result = criteria.list();
        
        System.out.format("\n\nResult Size: %d\n\n",result.size());
        
        for(TrialCustomerBean tcb: result){

            System.out.format("First Name: %s\n", tcb.getFirstName());       
            System.out.format("Middle Initial: %s\n",  tcb.getMiddleInitial());
            System.out.format("Last Name: %s\n",  tcb.getLastName());
            System.out.format("Age: %s\n",tcb.getAge() );
            
            System.out.format("Birth date: %s\n",tcb.getbDate());
            System.out.format("Gender: %s\n", tcb.getGender() );
            System.out.format("Marital Status: %s\n", tcb.getStatus());
            System.out.format("Address: %s\n", tcb.getAddress());
            System.out.format("Contact Number: %s\n", tcb.getContactNumber());
            System.out.format("Email Address: %s\n", tcb.getEmailAddress());
            
            System.out.format("\n\n");
        }
        
        session.close();
        
        //return result;
    }

}
