/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acss.training;

import com.acss.training.util.OrmTestUtil;
import java.math.BigInteger;
import java.util.Calendar;
import org.hibernate.HibernateException;
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
 * @author Mark Kelvin DG. Pineda
 */
public class ContactTest {
    
    
//     contact_id bigint NOT NULL,
//  value_c character varying(20) NOT NULL,
//  contact_type integer NOT NULL, -- 0 - Mobile...
//  is_active boolean NOT NULL, -- t= active...
//  from_date date NOT NULL,
//  to_date date,
//  rec_version integer NOT NULL,
//  profile_id bigint NOT NULL,
//  CONSTRAINT contact_numbers_pkey PRIMARY KEY (contact_id),
//  CONSTRAINT contact_numbers_profile_id_fkey FOREIGN KEY (profile_id)
//      REFERENCES m_profile (profile_id) MATCH SIMPLE
//      ON UPDATE NO ACTION ON DELETE NO ACTION
    
    
    private Contact testData;
    private SessionFactory sessionFactory;
    
    public ContactTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        BigInteger profId = new BigInteger("1038");
        testData = new Contact();
        testData.setValue("113451235");
        testData.setContactType(0);
        testData.setIsActive(Boolean.TRUE);
        testData.setFromDate(Calendar.getInstance());
        testData.setToDate(Calendar.getInstance());
        //testData.setProfileId(profId);
        
        sessionFactory = OrmTestUtil.getSessionFactory();
    }
    
    @After
    public void tearDown() {
    }
   
    //@Test
    public void testContactCRUD(){
        
        //test CREATE functions
        //assertTrue(testCreateContactData());
        
    }
    
    public boolean testCreateContactData(){
        
        Session session = sessionFactory.openSession();
        
        Transaction tx = session.beginTransaction();
     
     try{
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
}
