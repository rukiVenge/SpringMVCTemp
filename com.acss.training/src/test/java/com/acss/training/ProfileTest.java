/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acss.training;

import com.acss.training.util.OrmTestUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
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
 * @author Mark Kelvin DG. Pineda
 */
public class ProfileTest {

    
    private Profile testData;
    private SessionFactory sessionFactory;

    public ProfileTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        testData = new Profile();
        //testData.setProfileId(new BigInteger("105"));
        testData.setFirstName("Femie");
        testData.setMiddleName("H");
        testData.setLastName("Mendoza");
        testData.setGender('F');
        testData.setBirthDate(new GregorianCalendar(1992, 4, 10));
        testData.setMaritalStatus('M');
        testData.setMobileNo("09111234567");
        testData.setEmailAddress("emailaddto@emailcom");
        
        AccountSettings account = new AccountSettings();
        account.setExpiryDate(Calendar.getInstance());
        account.setFirstLogin(Calendar.getInstance());
        account.setLastLogin(Calendar.getInstance());
        account.setLastPinChange(Calendar.getInstance());
        account.setPassword("Hi");
        account.setPinCode("654321");
        account.setOwner(testData);
        
        Address address = new Address();
        address.setStreet("G St");
        address.setDistrict("Umuuga");
        address.setCity("Novali");
        address.setProvince("NCR");
        address.setPostalCode("54321");
        testData.setAddress(address);
       
        
        List<Contact> listContact = new ArrayList();
        Contact contact1 = new Contact();
        
        contact1.setValue("123456578990");
        contact1.setContactType(0);
        contact1.setFromDate(Calendar.getInstance());
        contact1.setToDate(Calendar.getInstance());
        contact1.setIsActive(true);
        contact1.setOwner(testData);
        
        listContact.add(contact1);
        
        Contact contact2 = new Contact();
        contact2.setValue("09987654321");
        contact2.setContactType(1);
        contact2.setFromDate(Calendar.getInstance());
        contact2.setToDate(Calendar.getInstance());
        contact2.setIsActive(true);
        contact2.setOwner(testData);
        
        listContact.add(contact2);
        
        Contact contact3 = new Contact();
        contact3.setValue("61029834756");
        contact3.setContactType(3);
        contact3.setFromDate(Calendar.getInstance());
        contact3.setToDate(Calendar.getInstance());
        contact3.setIsActive(false);
        contact3.setOwner(testData);
        
        listContact.add(contact3);
        
        
        List<Card> listCard = new ArrayList();
        Card card1 = new Card();
        
        card1.setCardNo("gfedcba");
        card1.setActivationDate(Calendar.getInstance(TimeZone.getDefault()));
        card1.setExpiryDate(Calendar.getInstance(TimeZone.getDefault()));
        card1.setCardStatus(0);
        card1.setOwner(testData);
        
        listCard.add(card1);
        
        
        Card card2 = new Card();
        
        card2.setCardNo("zxygts");
        card2.setActivationDate(Calendar.getInstance(TimeZone.getDefault()));
        card2.setExpiryDate(Calendar.getInstance(TimeZone.getDefault()));
        card2.setCardStatus(0);
        card2.setOwner(testData);
        
        listCard.add(card2);
        
        //Setting PointBucket to a card
        PointBucket point1 = new PointBucket();
        point1.setCardNo(card1.getCardNo());
        point1.setLastTxType(1);
        point1.setLastUpdate(Calendar.getInstance(TimeZone.getDefault()));
        point1.setRunningBalance(800);
        
        card1.setPointBucket(point1);
        
        
        //Setting PointBucket to a card
        PointBucket point2 = new PointBucket();
        point2.setCardNo(card2.getCardNo());
        point2.setLastTxType(2);
        point2.setLastUpdate(Calendar.getInstance(TimeZone.getDefault()));
        point2.setRunningBalance(500);
        
        card2.setPointBucket(point2);

        
        testData.setContacts(listContact);
        
        testData.setCard(listCard);
   
        testData.setAccountSettings(account);

        sessionFactory = OrmTestUtil.getSessionFactory();
    }

    @After
    public void tearDown() {
        testData = null;
        sessionFactory = null;
    }

    //@Test
    public void testCRUD() {
        //test the create procedure
        //assertTrue(testProfileCreate());

        //make sure that there is a profile id generated
       // assertNotNull(testData.getProfileId());

        //print id in log in file
//        System.out.format("ID generated is %d...", testData.getProfileId());

        //test reading profile
       // assertTrue(testProfileRead());
        
        //test updating profile
        //assertTrue(testProfileUpdate());
        
        //test delete profile
        //assertTrue(testProfileDelete());
        

    }

    public boolean testProfileCreate() {

        //creation of session
        Session session = sessionFactory.openSession();

        //creation of transaction
        Transaction tx = session.beginTransaction();

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

    public boolean testProfileRead() {
        Session session = sessionFactory.openSession();

        try {
            Profile acquired = (Profile) session.get(Profile.class, testData.getProfileId(), LockOptions.NONE);

            assertEquals(acquired.getProfileId(), testData.getProfileId());
            assertEquals(acquired.getFirstName(), testData.getFirstName());
            assertEquals(acquired.getBirthDate(), testData.getBirthDate());
            assertEquals(acquired.getMobileNo(), testData.getMobileNo());

            return true;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);

            return false;
        }


    }

    public boolean testProfileUpdate() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        //may checker sana
        String newFirstName = "Mark Luie";
        boolean returnValue = false;
              
        
        try {
                tx.begin();
                testData.setFirstName(newFirstName);
                
                
                if(testData.getFirstName() == newFirstName){ 
                    session.saveOrUpdate(testData);
                    tx.commit();
                    System.out.println("True ito");
                    returnValue = true;
                    session.close();
                   
                }else{
                    System.out.println("False ito");
                    returnValue = false;
                    session.close();

                }
                
            }catch (Exception ex) {
            ex.printStackTrace(System.out);
            
            session.close();
            return false;
        }
        
        return returnValue;

    }
    
    public boolean testProfileDelete(){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
        try{
            tx.begin();
            session.delete(testData);
            tx.commit();
            session.close();
            return true;
        }catch (Exception ex) {
            ex.printStackTrace(System.out);
            
            session.close();
            return false;
        }
        
        
    }
}

