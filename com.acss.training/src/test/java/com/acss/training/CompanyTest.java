/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acss.training;

import com.acss.training.util.OrmTestUtil;
import java.math.BigInteger;
import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
public class CompanyTest {

    private Company testData;
    private SessionFactory sessionFactory;

    public CompanyTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Address address = new Address();

        testData = new Company();
        testData.setCompanyId(new BigInteger("107"));
        testData.setCompanyName("ACSS Philippines Inc. 6");
        address.setStreet("TD3");
        address.setDistrict("BCG");
        address.setCity("Taguig");
        address.setProvince("NCR");
        address.setPostalCode("1634");
        testData.setAddress(address);

        sessionFactory = OrmTestUtil.getSessionFactory();

    }

    @After
    public void tearDown() {
        testData = null;
        sessionFactory = null;
    }

    //@Test
    public void testCRUD() {

        //Test creation of a company record
        //assertTrue(testCompanyCreate());

        //Test READ function
       // assertTrue(testCompanyRead());

        //Test UPDATE function
      //  assertTrue(testCompanyUpdate());

        //Test DELETE function
        //assertTrue(testCompanyDelete());

    }

    public boolean testCompanyCreate() {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try {

            tx.begin();

            session.saveOrUpdate(testData);

            tx.commit();

            session.close();

            return true;

        } catch (Exception ex) {
            tx.rollback();

            ex.printStackTrace(System.out);

            return false;
        }


    }

    public boolean testCompanyRead() {

        Session session = sessionFactory.openSession();
        try {
            Company acquired = (Company) session.get(Company.class, testData.getCompanyId(), LockOptions.READ);

            assertEquals(acquired.getCompanyId(), testData.getCompanyId());
            assertEquals(acquired.getCompanyName(), testData.getCompanyName());
            assertEquals(acquired.getAddress().getCity(), testData.getAddress().getCity());

            return true;
            
        } catch (Exception ex) {
            ex.printStackTrace(System.out);

            return false;
        }

    }

    public boolean testCompanyUpdate() {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Company newData;
        BigInteger compIdU = new BigInteger("107");
        String newCompanyName = "ACTS Philippines Inc 7";

        try {

            testData = (Company) session.get(Company.class, compIdU, LockOptions.UPGRADE);
            testData.setCompanyName(newCompanyName);

            tx.begin();

            session.saveOrUpdate(testData);

            tx.commit();
            
            newData = (Company) session.get(Company.class, compIdU, LockOptions.UPGRADE);
            String recordedCompanyName = newData.getCompanyName();
            if(recordedCompanyName.equalsIgnoreCase(newCompanyName)){
                session.close();
                return true;

            }else{
                session.close();
                return false;
            }
            
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return false;

        }

    }

    public boolean testCompanyDelete() {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        BigInteger compIdD = new BigInteger("109");

        testData = (Company) session.get(Company.class, compIdD, LockOptions.NONE);

        try {
            tx.begin();
            
            session.delete(testData);
            
            tx.commit();
            
            session.close();
            
            return true;
            
        } catch (Exception ex) {
            ex.printStackTrace(System.out);

            session.close();
            
            return false;
        }

    }
}
