/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.acss.training.web.ctrl;

import com.acss.training.SearchForWeb;
import com.acss.training.TrialCustomerBean;
import com.acss.training.util.OrmTestUtil;
import com.acss.training.web.beans.CustomerBean;
import com.acss.training.web.beans.SearchKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
 * @date created: 02 19, 13
 *
 */

@Controller
@RequestMapping(value={"/showresult.htm"})
@SessionAttributes(value={"search"})
public class GetResultOrmController {

    private SessionFactory sessionFactory =OrmTestUtil.getSessionFactory();

    @RequestMapping(method={RequestMethod.GET})
    public String showForm(ModelMap map){
            
       map.put("search", new SearchKey());
       
        return "showResult";
    }
    
    
    @RequestMapping(method={RequestMethod.POST})
    public String processForm(ModelMap map, @ModelAttribute(value="search")SearchKey searchKey){
                    
        Session session = sessionFactory.openSession();
        
        Criteria criteria = session.createCriteria(TrialCustomerBean.class);
        String criterionKey = "%" + searchKey.getSearchKey() +"%";
        criteria.add(Restrictions.ilike("firstName", criterionKey));
        //criteria.add(Restrictions.or(Restrictions.eq("lastName", "%a%"), Restrictions.eq("firstName0", "%i%")));

        
        List <TrialCustomerBean> resultList = criteria.list();

        map.put("result", resultList);
       
        session.close();
        
        return "showResult";
        
       
        
    }

}
