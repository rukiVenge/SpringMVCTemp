/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acss.training;

import com.acss.training.util.OrmTestUtil;
import java.util.Calendar;
import java.util.TimeZone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
public class PointBucketTest {
    
    private PointBucket testData;
    private SessionFactory sessionFactory;
    
    public PointBucketTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        testData = new PointBucket();
        testData.setCardNo("abcdefg");
        testData.setRunningBalance(800);
        testData.setLastUpdate(Calendar.getInstance(TimeZone.getDefault()));
        
        
        sessionFactory = OrmTestUtil.getSessionFactory();
    }
    
    @After
    public void tearDown() {
    }
    
   // @Test
    public void testCRUD(){
        
        //Test CREATE function
       // assertTrue(testCreatePointBucket());
        
    }
    
    public boolean testCreatePointBucket(){
        
        
        //creation of session
        Session session = sessionFactory.openSession();

        //creation of transaction
        org.hibernate.Transaction tx = session.beginTransaction();

        try {
            //begin the transaction first
            tx.begin();

            //save the information
            session.saveOrUpdate(testData);

            //commit the changes
            tx.commit();

            //close session
            session.close();
            return true;

        } catch (Exception ex) {
            tx.rollback();

            ex.printStackTrace(System.out);

            return false;
        }
    }
}
