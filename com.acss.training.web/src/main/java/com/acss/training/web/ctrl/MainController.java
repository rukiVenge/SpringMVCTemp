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
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping(value = {"/main.htm"})

public class MainController {

  
    @RequestMapping(method = {RequestMethod.GET})
    public String showForm() {

        
        return "main";
    }

    public MainController() {
    }

  
}
