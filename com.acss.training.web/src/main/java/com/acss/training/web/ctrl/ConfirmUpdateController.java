/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acss.training.web.ctrl;

import com.acss.training.Profile;
import com.acss.training.util.OrmTestUtil;
import com.acss.training.web.beans.CustomerBean;
import com.acss.training.web.beans.FullName;
import com.acss.training.TrialCustomerBean;
import com.acss.training.web.helpers.DateConverter;
import com.acss.training.web.validator.CustomerValidator;
import java.io.File;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Mark Kelvin DG. Pineda
 * @date created: 02 15, 13
 *
 */
@Controller
@RequestMapping(value = {"/confirmUpdate.htm"})


public class ConfirmUpdateController {

    @Autowired
    private CustomerValidator cv;
    private SessionFactory sessionFactory;
    private DateConverter dateConverter;
    private String retVal = "recordUpdate";

    @Autowired
    public ConfirmUpdateController(DateConverter dateConverter) {
        this.dateConverter = dateConverter;
    }
    
     @RequestMapping(method={RequestMethod.GET})
    public String processNo(){
         return "main";
     }

    
   @RequestMapping(method={RequestMethod.POST})
    public String processForm(ModelMap map){
       
       
       System.out.println("Hey Im in here at POST method");
       
       sessionFactory = OrmTestUtil.getSessionFactory();
       
       UpdateBeanHolder uph = new UpdateBeanHolder();
       
       System.out.println(uph.getHolder().getFirstName());
       CustomerBean cb = uph.getHolder();
       
        Session session = sessionFactory.openSession();


         TrialCustomerBean tcb = (TrialCustomerBean) session.get(TrialCustomerBean.class, uph.getHolder().getProfileId(), LockOptions.NONE);
         
        if(cb.getFirstName() != null && cb.getLastName() != null){
            
            System.out.format("First name: %s\n", cb.getFirstName());
            System.out.format("M.I.: %s\n", cb.getMiddleInitial());
            System.out.format("Last name: %s\n", cb.getLastName());
            System.out.format("BirthDate: %s\n", cb.getbDate());
            System.out.format("Gender: %s\n", cb.getGender());
            System.out.format("Age: %d\n", cb.getAge());
            System.out.format("Status: %s\n", cb.getStatus());
            System.out.format("Address: %s\n", cb.getAddress());
            System.out.format("Contact Number: %s\n", cb.getContactNumber());
            System.out.format("Email Address: %s\n", cb.getEmailAddress());

            //nagcreate ng new instance, hindi niya alma na update pla ung gagawin mo
//           TrialCustomerBean  tcb = new TrialCustomerBean();
           

            tcb.setFirstName(cb.getFirstName());
            tcb.setMiddleInitial(cb.getMiddleInitial());
            tcb.setLastName(cb.getLastName());
            System.out.print(cb.getbDate());
            tcb.setGender(cb.getGender());    
            Calendar birthDate = dateConverter.convertToCalendar(cb.getbDate());
            tcb.setbDate(birthDate);
            tcb.setAge(cb.getAge());
            tcb.setStatus(cb.getStatus());
            tcb.setAddress(cb.getAddress());
            tcb.setContactNumber(cb.getContactNumber());
            tcb.setEmailAddress(cb.getEmailAddress());

            
            //creation of transaction
            Transaction tx = session.beginTransaction();

            try {
                //begin the transaction first
                tx.begin();

                //save the information
                session.saveOrUpdate(tcb);

                //commit the changes
                tx.commit();

                //close session
                session.close();
                             
                map.put("success","Update Succefully committed!");
                
                
               retVal = "main";
            } catch (Exception ex) {
                tx.rollback();

                ex.printStackTrace(System.out);
                
                session.close();

               retVal="error";

            }
      
            return retVal;
        }
    
    return retVal;
    }
    
    
    public ConfirmUpdateController() {
    }

  
}
