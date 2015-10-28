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
public class TransactionTest {
    
    private Transactions testData;
    private SessionFactory sessionFactory;
    
    public TransactionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        testData = new Transactions();
        testData.setTxNo("TR002");
        //testData.setCardNo("abcdefg");
        testData.setTxTimestamp(Calendar.getInstance(TimeZone.getDefault()));
        testData.setPointValue(1000);
        testData.setTxType(1);
        
        sessionFactory = OrmTestUtil.getSessionFactory();
        
        
    }
    
    @After
    public void tearDown() {
        testData = null;
        sessionFactory = null;
    }

    
    //@Test
    public void testCRUD(){
        
        //test CREATE function
        //assertTrue(testCreatTransaction());
    }
    
    public boolean testCreatTransaction(){
        
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
