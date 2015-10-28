/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.acss.training.web.ctrl;

import com.acss.training.Profile;
import com.acss.training.TrialCustomerBean;
import com.acss.training.util.OrmTestUtil;
import com.acss.training.web.beans.CustomerBean;
import com.acss.training.web.helpers.DateConverter;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Mark Kelvin DG. Pineda
 * @date created: 02 19, 13
 *
 */




@Controller
@RequestMapping(value={"/updateRecord.htm"})
@SessionAttributes(value={"updrecord"})
public class TrialCustomerUpdateController {
    
    private SessionFactory sessionFactory = OrmTestUtil.getSessionFactory();
    
    
    private DateConverter dateConverter = new DateConverter();

    
    public TrialCustomerUpdateController() {
    }
    
    @RequestMapping(method={RequestMethod.GET})
    public String showForm(ModelMap map, HttpServletRequest request){
        
        Session session = sessionFactory.openSession();
      
        String profileId = request.getParameter("profileId");
        System.out.print("entry post");
        
        TrialCustomerBean tcBean = (TrialCustomerBean) session.get(TrialCustomerBean.class, new BigInteger(profileId), LockOptions.NONE);
     
        CustomerBean cBean = new CustomerBean();
        
        
        cBean.setFirstName(tcBean.getFirstName());
        cBean.setMiddleInitial(tcBean.getMiddleInitial());
        cBean.setLastName(tcBean.getLastName());
        cBean.setAge(tcBean.getAge());
        cBean.setGender(tcBean.getGender());
        String birthDate = dateConverter.convertToString(tcBean.getbDate());
        cBean.setbDate(birthDate);
        cBean.setStatus(tcBean.getStatus());
        cBean.setAddress(tcBean.getAddress());
        cBean.setContactNumber(tcBean.getContactNumber());
        cBean.setEmailAddress(tcBean.getEmailAddress());
            

        map.put("updrecord",cBean);
        
        session.close();
        
        return "recordUpdate";
        
        
        //check getting profileId from request parameter
       // System.out.print("get passed" + profileId);
        
        //ipopoint natin sa JSP na may laman  nung form 

       
    }
    
    
    @RequestMapping(method={RequestMethod.POST})
    public String processForm(@ModelAttribute(value="updrecord") CustomerBean customer, BindingResult result){
        
        UpdateBeanHolder uph = new UpdateBeanHolder();
        
        System.out.println(customer.getFirstName());
        
        uph.setHolder(customer);
        
        return "updateConfirm";
    
//        Session session = sessionFactory.openSession();
//        
//        String retVal = "error";
//         TrialCustomerBean tcb = (TrialCustomerBean) session.get(TrialCustomerBean.class, customer.getProfileId(), LockOptions.NONE);
//         
//        if(customer.getFirstName() != null && customer.getLastName() != null){
//            
//            System.out.format("First name: %s\n", customer.getFirstName());
//            System.out.format("M.I.: %s\n", customer.getMiddleInitial());
//            System.out.format("Last name: %s\n", customer.getLastName());
//            System.out.format("BirthDate: %s\n", customer.getbDate());
//            System.out.format("Gender: %s\n", customer.getGender());
//            System.out.format("Age: %d\n", customer.getAge());
//            System.out.format("Status: %s\n", customer.getStatus());
//            System.out.format("Address: %s\n", customer.getAddress());
//            System.out.format("Contact Number: %s\n", customer.getContactNumber());
//            System.out.format("Email Address: %s\n", customer.getEmailAddress());
//
//            //nagcreate ng new instance, hindi niya alma na update pla ung gagawin mo
////           TrialCustomerBean  tcb = new TrialCustomerBean();
//           
//
//            tcb.setFirstName(customer.getFirstName());
//            tcb.setMiddleInitial(customer.getMiddleInitial());
//            tcb.setLastName(customer.getLastName());
//            System.out.print(customer.getbDate());
//            tcb.setGender(customer.getGender());    
//            Calendar birthDate = dateConverter.convertToCalendar(customer.getbDate());
//            tcb.setbDate(birthDate);
//            tcb.setAge(customer.getAge());
//            tcb.setStatus(customer.getStatus());
//            tcb.setAddress(customer.getAddress());
//            tcb.setContactNumber(customer.getContactNumber());
//            tcb.setEmailAddress(customer.getEmailAddress());
//
//            
//            //creation of transaction
//            Transaction tx = session.beginTransaction();
//
//            try {
//                //begin the transaction first
//                tx.begin();
//
//                //save the information
//                session.saveOrUpdate(tcb);
//
//                //commit the changes
//                tx.commit();
//
//                //close session
//                session.close();
//                             
//                
//               retVal = "successRecord";
//            } catch (Exception ex) {
//                tx.rollback();
//
//                ex.printStackTrace(System.out);
//                
//                session.close();
//
//               retVal="error";
//
//            }
//      
//            return retVal;
//        }
//    
//    return retVal;
    }
    

}

