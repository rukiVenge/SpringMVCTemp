/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.acss.training.web.validator;

import com.acss.training.web.beans.CustomerBean;
import com.acss.training.web.beans.FullName;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Mark Kelvin DG. Pineda
 * @date created: 02 20, 13
 *
 */
public class CustomerValidator implements Validator {
    
    @Override
    public boolean supports(Class<?> type) {
        return type.isAssignableFrom(CustomerBean.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CustomerBean cb = (CustomerBean) o;
        
        
        if(cb.getFirstName() == null || cb.getFirstName().trim().isEmpty()) {             
           errors.rejectValue("firstName", "err.invalid.first.name");         } 
        if(cb.getLastName() == null || cb.getLastName().trim().isEmpty()) {             
            errors.rejectValue("lastName","err.invalid.last.name");         }
        if(cb.getAge() == 0) {             
            errors.rejectValue("age", "err.invalid.age"); 
            
            
            }     
    }

}
