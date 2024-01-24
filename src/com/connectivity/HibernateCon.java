package com.connectivity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class HibernateCon {
	public static Session getCon() {
		Configuration Con = new AnnotationConfiguration().configure("hibernate.cfg.xml");
		SessionFactory sf = Con.buildSessionFactory();
		Session s=  sf.openSession();
		return s;
	}
}
