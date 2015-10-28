/*
 * AEON Credit Technology Systems Inc. (Philippines)
 * Copyright 2013
 */

package com.acss.training.web.ctrl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 *
 * @author Lorenzo D. Malafo Jr.
 * @since February 19, 2013
 */
@Controller
@RequestMapping(value={"/locale.htm"})
public class LanguageController {
    @Autowired
    private SessionLocaleResolver sessionLocaleResolver;
    
    @RequestMapping(method={RequestMethod.GET})
    public String changeLocale(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String redirectPage = request.getParameter("redpage");
        String lang = request.getParameter("lang");
        String cn = request.getParameter("cn");
        
        if(redirectPage == null || (redirectPage != null && redirectPage.trim().isEmpty())) {
            redirectPage = "/main.htm";
        } else {
            redirectPage = URLDecoder.decode(redirectPage, "utf-8");
        }
        
        if(lang == null || (lang != null && lang.trim().isEmpty())) {
            lang = "en";
        }
        
        if(cn == null || (cn != null && cn.trim().isEmpty())) {
            cn = "";
        }
        
        System.out.println("REDIRECT PAGE: " + redirectPage);
        
        sessionLocaleResolver.setLocale(request, response, new Locale(lang, cn));
        
        return "redirect:" + redirectPage;
    }
}
