/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acss.training.web.ctrl;

import com.acss.training.TrialCustomerBean;
import com.acss.training.util.OrmTestUtil;
import com.acss.training.web.beans.CustomerBean;
import com.acss.training.web.beans.SearchKey;
import com.acss.training.web.helpers.DateConverter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
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
 * @date created: 02 20, 13
 *
 */
@Controller
@RequestMapping(value = {"/deleteRecord.htm"})
public class TrialCustomerDeleteController {

    private SessionFactory sessionFactory = OrmTestUtil.getSessionFactory();
    private DateConverter dateConverter = new DateConverter();

    public TrialCustomerDeleteController() {
    }

    @RequestMapping(method = {RequestMethod.GET})
    public String showForm(ModelMap map) {

        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(TrialCustomerBean.class);
        criteria.add(Restrictions.ilike("firstName", "%" + "" + "%"));
        //criteria.add(Restrictions.or(Restrictions.eq("lastName", "%a%"), Restrictions.eq("firstName0", "%i%"))); 
        List<TrialCustomerBean> resultList = criteria.list();
        map.put("delrecord", resultList);

        session.close();

        return "recordDelete";
    }

    @RequestMapping(method = {RequestMethod.POST})
    public String processForm(HttpServletRequest request, ModelMap map) {

        System.out.println("Entry POST delrecord");

        String[] arrProfileId = request.getParameterValues("checks");
        List idList = new ArrayList();
        
        for (String string : arrProfileId) {
            System.out.println(string+" a");
            idList.add(string);
        }
        
        map.put("ids",idList);
        
       

        return "deleteConfirm";
//        System.out.println(arrProfileId);
//
////        System.out.println(profileId); 
////        System.out.println("Entry");
//
//
//        for (String tcbean : arrProfileId) {
//            Session session = sessionFactory.openSession();
//            TrialCustomerBean tcb = (TrialCustomerBean) session.get(TrialCustomerBean.class, new BigInteger(tcbean), LockOptions.NONE);
//
//            Transaction tx = session.beginTransaction();
//
//            try {
//                tx.begin();
//                session.delete(tcb);
//                
//                tx.commit();
//                session.close();
//                
//            } catch (Exception ex) {
//                ex.printStackTrace(System.out);
//
//                session.close();
//               
//            }
//
//        }
//        return "recordDelete";
//    }
    }
}
