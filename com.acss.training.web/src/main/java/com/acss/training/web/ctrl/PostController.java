/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.acss.training.web.ctrl;

import com.acss.training.web.beans.FullName;
import com.acss.training.web.validator.FullNameValidator;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping(value={"/postsample1.htm"})
@SessionAttributes(value={"name"})
public class PostController {
    
    @Autowired
    private FullNameValidator fullNameValidator;
    
    @RequestMapping(method={RequestMethod.GET})
    public String showForm(ModelMap map){
        
        map.put("name", new FullName());
        
        //ipopoint natin sa JSP na may laman  nung form natin
        return "postjsp";
    }
    
    @RequestMapping(method={RequestMethod.POST})
    public String processForm(@ModelAttribute(value="name") FullName name, BindingResult result){
        
        
        ValidationUtils.invokeValidator(fullNameValidator, name, result);
        
        System.out.format("First name: %s\n", name.getFirstName());
        System.out.format("Last name: %s\n", name.getLastName());
        
//        //eto na ung name nung input galing sa FORM
//        String firstName = request.getParameter("first");
//        String lastName = request.getParameter("last");
//        
//        FullName name = new FullName();
//        name.setFirstName(firstName);
//        name.setLastName(lastName);
//        
//        
//        //ilalagay sa modelmap para maaccess ng presentation
//        map.put("name", name);
//        
        //ipopoint sa next jsp na magdidisplay ng result
        
       if(result.hasErrors()){
            System.out.print("a");
            return "error";
       }else{
           System.out.print("b");
            return "success";
       }
       
    }

}
