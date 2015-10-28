/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.acss.training.web.ctrl;

import com.acss.training.web.beans.FullName;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Mark Kelvin DG. Pineda
 * @date created: 02 15, 13
 *
 */

@Controller
@RequestMapping(value={"/getsample.htm"})
public class GetController {
    
    @RequestMapping(method={RequestMethod.GET})
    public String showPage(ModelMap map,HttpServletRequest request){
        
        String firstName = request.getParameter("first");
        String lastName = request.getParameter("last");
        
        FullName name = new FullName();
        name.setFirstName(firstName);
        name.setLastName(lastName);
        
        map.put("name", name);
        

        return "getjsp";
    }
}
