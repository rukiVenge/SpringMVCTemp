/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.acss.training.web.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Mark Kelvin DG. Pineda
 * @date created: 02 18, 13
 *
 */
public class DateConverter {
    
    
    private String pattern;
    
    /**
     * Default constructor
     */
    public DateConverter() {}

    
    public DateConverter(String pattern) {
        this.pattern = pattern;
    }
    
    
    /**
     * Converts an input string to a calendar object
     * @param strDate the date in <code>String</code> format to be converted
     * @param pattern the format of the string date to be converted
     * @return a new instance of <code>Calendar</code> object
     */
    
   
    public Calendar convertToCalendar(String strDate){
        Calendar retVal;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date newDate = sdf.parse(strDate);
            
            retVal= new GregorianCalendar();
            retVal.setTime(newDate);
            
            
        } catch(ParseException ep){
            System.out.format("Cannot convert %s", ep.getMessage());
            return null;
        }
      
     return retVal;   
    }
    
    
    
    
    public String convertToString(Calendar calDate){
        String retVal;
        
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date newDate = calDate.getTime();
            
            retVal= sdf.format(newDate);

      
     return retVal;   
    }
    

}
