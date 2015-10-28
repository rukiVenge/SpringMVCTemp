/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.acss.training;

import com.acss.training.util.OrmTestUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mark Kelvin DG. Pineda
 * @date created: 02 19, 13
 *
 */
public class SearchForWeb {
        
    public SessionFactory sessionFactory;
    
    public List<TrialCustomerBean> CriteriaSearch(){
        

        sessionFactory = OrmTestUtil.getSessionFactory();
        
        Session session = sessionFactory.openSession();
        
        Criteria criteria = session.createCriteria(TrialCustomerBean.class);
        
        criteria.add(Restrictions.ilike("firstName", "%a%"));
        criteria.add(Restrictions.or(Restrictions.eq("lastName", "%a%"), Restrictions.eq("firstName0", "%i%")));
//        int startingIndex = 0;
//        int resultPerPage = 5;
//        criteria.setFirstResult(startingIndex * resultPerPage);
//        criteria.setMaxResults(resultPerPage);
        
        List <TrialCustomerBean> result = criteria.list();
        
        System.out.format("\n\nResult Size: %d\n\n",result.size());
        
        for(TrialCustomerBean tcb: result){

            System.out.format("First Name: %s\n", tcb.getFirstName());       
            System.out.format("Middle Initial: %s\n",  tcb.getMiddleInitial());
            System.out.format("Last Name: %s\n",  tcb.getLastName());
            System.out.format("Age: %s\n",tcb.getAge() );
            System.out.format("Birth date: %s\n",tcb.getbDate());
            System.out.format("Gender: %s\n", tcb.getGender() );
            System.out.format("Marital Status: %s\n", tcb.getStatus());
            System.out.format("Address: %s\n", tcb.getAddress());
            System.out.format("Contact Number: %s\n", tcb.getContactNumber());
            System.out.format("Email Address: %s\n", tcb.getEmailAddress());
            
            System.out.format("\n\n");
        }
        
        session.close();
        
        return result;
    }

}
