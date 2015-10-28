/*
 * AEON Credit Service Systems Inc. (Philippines)
 * Copyright 2012
 */
package com.acss.training.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is a test utility for JUNIT testing of ORM Entities.
 * 
 * @author Lorenzo D. Malafo Jr.
 * @since November 13, 2012
 */
public final class OrmTestUtil {
    /*
     * Singleton instance of the session factory that is constructed upon
     * initial reference to this class.
     */
    private static final SessionFactory sessionFactory;

//    /*
//     * Debugger Class
//     */
//    private static final Logger debugger = LoggerFactory.getLogger(OrmTestUtil.class);

    static {
        try {
            System.out.println("Starting the creation of SessionFactory from HibernateUtil...");
            
            System.out.println("Creating annotation configuration...");
            AnnotationConfiguration annonConfig = new AnnotationConfiguration();
            
            System.out.println("Setting the Input Stream to use...");
            annonConfig = annonConfig.configure("META-INF/hibernate-bmt.cfg.xml");
            
            System.out.println("Building the Session factory...");
            sessionFactory = annonConfig.buildSessionFactory();
            
            System.out.println("Finished creating the SessionFactory from input stream...");
        } catch (Throwable ex) {
            System.out.println("Initial SessionFactory creation failed with message {}" + ex.getMessage());
            
            StringWriter swriter = new StringWriter();
            PrintWriter pwriter = new PrintWriter(swriter);
            
            ex.printStackTrace(pwriter);
            
            System.out.println("StackTrace of error:\n {}" + swriter.toString());
            
            pwriter.close();
            
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    /**
     * Hidden Constructor.
     */
    private OrmTestUtil(){}

    /**
     * Gets the singleton instance of the configured session factory.
     * 
     * @return the singleton instance of <code>{@link SessionFactory}</code>
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
