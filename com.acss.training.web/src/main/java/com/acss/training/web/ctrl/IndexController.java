/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.acss.training.web.ctrl;

import com.acss.training.web.beans.FullName;
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
public class IndexController {
    @RequestMapping(value={"/index.htm","index.htm"}, method={RequestMethod.GET})
    
    public String showIndex(ModelMap map){
        long randomName = (long) (Math.random() * 1000000000);
        
        //map.put("name", "Kelvin #" + randomName);
        
        FullName name = new FullName();
        name.setFirstName("First: Mark Kelvin");
        name.setLastName("Last: Pineda");
        name.setAge("Age: 20");
        name.setFear("Fears: Ghost, cockroach,spiders, dark %] ");
        
        map.put("name",name);
        
        
        
        //kinatch ito ni viewResolver
        return "index";
    }


}
