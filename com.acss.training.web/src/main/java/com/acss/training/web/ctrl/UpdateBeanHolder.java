/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.acss.training.web.ctrl;

import com.acss.training.web.beans.CustomerBean;
import com.acss.training.web.beans.TrialCustomerBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Mark Kelvin DG. Pineda
 * @date created: 02 21, 13
 *
 */



public class UpdateBeanHolder {
    
    private static CustomerBean holder;

    public UpdateBeanHolder() {
    }

    public static CustomerBean getHolder() {
        return holder;
    }

    public static void setHolder(CustomerBean holder) {
        UpdateBeanHolder.holder = holder;
    }
    
    
    

}
