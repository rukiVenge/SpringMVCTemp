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
import java.math.BigInteger;
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
@RequestMapping(value = {"/confirmDelete.htm"})

public class ConfirmDeleteController {

    @Autowired
    private CustomerValidator cv;
    private SessionFactory sessionFactory;
    private DateConverter dateConverter;
    private String retVal = "recordDelete";

    @Autowired
    public ConfirmDeleteController(DateConverter dateConverter) {
        this.dateConverter = dateConverter;
    }

    @RequestMapping(method = {RequestMethod.POST})
    public String processForm(HttpServletRequest request, ModelMap map) {
        
        sessionFactory = OrmTestUtil.getSessionFactory();

        String[] profId = request.getParameterValues("delVal");

        System.out.println("Entry POST delrecord");


//        System.out.println(profileId); 
//        System.out.println("Entry");


        for (String tcbean : profId) {
            Session session = sessionFactory.openSession();

            TrialCustomerBean tcb = (TrialCustomerBean) session.get(TrialCustomerBean.class, new BigInteger(tcbean), LockOptions.NONE);

            Transaction tx = session.beginTransaction();

            try {
                tx.begin();
                session.delete(tcb);

                tx.commit();
                session.close();
                
                map.put("successdelete","Record Successfully deleted!");
                

            } catch (Exception ex) {
                ex.printStackTrace(System.out);

                session.close();

            }

        }
        return "main";
    }

    public ConfirmDeleteController() {
    }
}
