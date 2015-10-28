/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.acss.training.web.ctrl;

import com.acss.training.web.beans.CustomerBean;
import com.acss.training.web.beans.FullName;
import com.acss.training.web.helpers.DateConverter;
import java.io.File;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
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
 * @date created: 02 15, 13
 *
 */

@Controller
@RequestMapping(value={"/registration.htm"})
@SessionAttributes(value={"customers"})
public class CustomerPostController {
    
    private DateConverter dateConverter;
    
    @Autowired
    public CustomerPostController(DateConverter dateConverter) {
        this.dateConverter = dateConverter;
    }
    
    
    
    @RequestMapping(method={RequestMethod.GET})
    public String showForm(ModelMap map){
        
        map.put("customer", new CustomerBean());
        
        
        //ipopoint natin sa JSP na may laman  nung form natin
        return "registration";
    }

    public CustomerPostController() {
    }
    
    @RequestMapping(method={RequestMethod.POST})
    public String processForm(@ModelAttribute(value="customer") CustomerBean customer, BindingResult result){
        
        System.out.format("First name: %s\n", customer.getFirstName());
        System.out.format("M.I.: %s\n", customer.getMiddleInitial());
        System.out.format("Last name: %s\n", customer.getLastName());
        System.out.format("BirthDate: %s", customer.getbDate());
        System.out.format("Age: %d\n", customer.getAge());
        System.out.format("Status: %s\n", customer.getStatus());
        System.out.format("Address: %s\n", customer.getAddress());
        System.out.format("Contact Number: %s\n", customer.getContactNumber());
        System.out.format("Email Address: %s\n", customer.getEmailAddress());
        
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
        
        File file = new File("C:\\Users\\mpineda\\Documents\\NetBeans Proj\\com.acss.training.web\\src\\main\\customer.txt");
		PrintWriter out = null;
                
                 if(customer.getFirstName() == null || customer.getFirstName().trim().isEmpty()) {
                     result.rejectValue("firstName", null, "Invalid First Name");     } 
                
	if(customer.getFirstName() != "" && customer.getLastName() != ""){
            
		try{
			out = new PrintWriter(file);
                        out.println(customer.getFirstName() + "|" +
                                    customer.getMiddleInitial() + "|" +
                                    customer.getLastName() + "|" +
                                    customer.getGender()  + "|" +
                                    customer.getbDate() + "|" +
                                    customer.getAge() + "|" +
                                    customer.getStatus() + "|" +
                                    customer.getAddress() + "|" +
                                    customer.getContactNumber() + "|" +
                                    customer.getEmailAddress());
		}catch(Exception e){
			e.printStackTrace();
                        }
                finally{
                         if(out != null){
			out.close();
                         }
		}
        
                
                
        return "successRecord";
        }
        else{
            
            return "error";
        }
    }

}
