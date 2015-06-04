package com.dvdshop.portello.config;

import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;  

public class MySQLHibernateConfig {

	
	 private static final SessionFactory sessionFactory;  
	    private static final ServiceRegistry serviceRegistry;  
	      
	    static {  
	        Configuration conf = new Configuration();  
	        conf.configure();  
	        serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();  
	        try {  
	            sessionFactory = conf.buildSessionFactory(serviceRegistry);  
	        } catch (Exception e) {  
	            System.err.println("Initial SessionFactory creation failed." + e);  
	            throw new ExceptionInInitializerError(e);  
	        }         
	    }  
	      
	    public static SessionFactory getSessionFactory() {  
	        return sessionFactory;  
	    }  
}
