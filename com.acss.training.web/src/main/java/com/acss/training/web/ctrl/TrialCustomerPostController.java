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
@RequestMapping(value = {"/registration1010.htm"})
@SessionAttributes(value = "customerpost")
public class TrialCustomerPostController {

    @Autowired
    private CustomerValidator cv;
    private SessionFactory sessionFactory;
    private DateConverter dateConverter;
    private String retVal = "registration";

    @Autowired
    public TrialCustomerPostController(DateConverter dateConverter) {
        this.dateConverter = dateConverter;
    }

    @RequestMapping(method = {RequestMethod.GET})
    public String showForm(ModelMap map) {

        //need mo na iinstaciate yung bean mo kasi ginagamit na siya dun sa jsp mo
        map.put("customerpost", new CustomerBean());
        
        return "registration";
    }

    public TrialCustomerPostController() {
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processForm(@ModelAttribute(value = "customerpost") CustomerBean customer, BindingResult result, ModelMap map) {

        System.out.println("entered in post method");
        ValidationUtils.invokeValidator(cv, customer, result);

        if (result.hasErrors()) {

        
            return "registration";
        }
        if (customer.getFirstName() != null && customer.getLastName() != null) {
            System.out.println("registering");
            System.out.format("First name: %s\n", customer.getFirstName());
            System.out.format("M.I.: %s\n", customer.getMiddleInitial());
            System.out.format("Last name: %s\n", customer.getLastName());
            System.out.format("BirthDate: %s", customer.getbDate());
            System.out.format("Age: %d\n", customer.getAge());
            System.out.format("Status: %s\n", customer.getStatus());
            System.out.format("Address: %s\n", customer.getAddress());
            System.out.format("Contact Number: %s\n", customer.getContactNumber());
            System.out.format("Email Address: %s\n", customer.getEmailAddress());

            TrialCustomerBean tcb = new TrialCustomerBean();
            tcb.setFirstName(customer.getFirstName());
            tcb.setMiddleInitial(customer.getMiddleInitial());
            tcb.setLastName(customer.getLastName());
            Calendar birthDate = dateConverter.convertToCalendar(customer.getbDate());
            tcb.setGender(customer.getGender());
            tcb.setbDate(birthDate);
            tcb.setAge(customer.getAge());
            tcb.setStatus(customer.getStatus());
            tcb.setAddress(customer.getAddress());
            tcb.setContactNumber(customer.getContactNumber());
            tcb.setEmailAddress(customer.getEmailAddress());


            sessionFactory = OrmTestUtil.getSessionFactory();


            //creation of session
            Session session = sessionFactory.openSession();

            //creation of transaction
            Transaction tx = session.beginTransaction();

            try {
                //begin the transaction first
                tx.begin();

                //save the information
                session.save(tcb);

                //commit the changes
                tx.commit();

                //close session

                session.close();
                map.put("successReg","Record was successfully saved");
                retVal = "main";
            } catch (Exception ex) {
                tx.rollback();

                ex.printStackTrace(System.out);
                session.close();

                //retVal="registration";


            }

            return retVal;
        }
        return retVal;
    }
}
