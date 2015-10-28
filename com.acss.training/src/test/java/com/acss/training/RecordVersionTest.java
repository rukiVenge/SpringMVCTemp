/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acss.training;

import com.acss.training.util.OrmTestUtil;
import java.math.BigInteger;
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
public class RecordVersionTest {
    private SessionFactory sessionFactory;
    Profile testData;
    
    
    public RecordVersionTest() {
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
   
   // @Test 
    public void testRecordVersion(){
  
        Session session = sessionFactory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        
         try {
             
                testData = (Profile) session.get(Profile.class, new BigInteger("1"), LockOptions.NONE);
                Integer currentVersion = new Integer (testData.getRecordVersion());
                System.out.format("Current version: %d",currentVersion);
                testData.setFirstName("Luie");
               
                tx.begin();
                
                session.saveOrUpdate(testData);
                
                tx.commit();
                
                Integer newRecordVersion = testData.getRecordVersion();
                System.out.format("New record Version: %d",newRecordVersion);
                
                assertTrue(newRecordVersion > currentVersion);
            }catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        
    }
}
