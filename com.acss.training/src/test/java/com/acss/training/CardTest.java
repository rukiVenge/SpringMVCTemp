/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acss.training;

import com.acss.training.util.OrmTestUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
public class CardTest {
    
    private Card testData;
    private Transactions tx;
    private SessionFactory sessionFactory;
    
    
    public CardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        
        
        BigInteger profId = new BigInteger("1047");
        testData = new Card();
        testData.setCardNo("234862348234");
        //testData.setProfileId(profId);
        testData.setActivationDate(Calendar.getInstance());
        testData.setExpiryDate(Calendar.getInstance());
        testData.setCardStatus(0);
        
        List<Transactions> listTransaction = new ArrayList();
        Transactions tx1 = new Transactions();
        tx1.setTxNo("TR0080");
        tx1.setTxTimestamp(Calendar.getInstance(TimeZone.getDefault()));
        tx1.setPointValue(300);
        tx1.setTxType(1);
        tx1.setcOwner(testData);
        
        listTransaction.add(tx1);
        
        Transactions tx2 = new Transactions();
        tx2.setTxNo("TR0085");
        tx2.setTxTimestamp(Calendar.getInstance(TimeZone.getDefault()));
        tx2.setPointValue(500);
        tx2.setTxType(0);
        tx2.setcOwner(testData);
        
        listTransaction.add(tx2);
        
        testData.settOwner(listTransaction);
        
        
        sessionFactory = OrmTestUtil.getSessionFactory();
        
    }
    
    @After
    public void tearDown() {
        testData = null;
        sessionFactory = null;
    }
    
    //@Test
    public void testCRUD() {
        
        //test CREATE function
       // assertTrue(testCreateCard());
        
    }
    
    public boolean testCreateCard(){
        

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
