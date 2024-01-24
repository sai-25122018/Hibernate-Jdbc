package com.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.HibernateCallback;

import com.connectivity.HibernateCon;

import com.pojo.Person;

public class TestHibernate {
	public void savedata() {
		Session s = HibernateCon.getCon();
		Transaction t = s.beginTransaction();
		Person P = new Person();
		P.setPname("BhagyaSri");
		P.setPage(30);
		P.setQual("Btech");
		s.save(P);
		t.commit();
		s.close();
		
	}
	
	public void getbyid(int pid) {
		Session s = HibernateCon.getCon();
		Person P =  (Person) s.get(Person.class, pid);
		System.out.println(P);
		
	}
	public void getAll() {
		Session s = HibernateCon.getCon();
		Query q =  s.createQuery("From Person");
		List<Person> Per =  q.list();
		for (Person pers : Per) {
			System.out.println(pers);
		}
	}
	public void update(int pid) {
		Session s = HibernateCon.getCon();
		Person P =  (Person) s.get(Person.class, pid);
		P.setPname("K Sambha Siva Rao");
		s.update(P);
		System.out.println(P);
	}
	public void deletedata(int pid) {
		Session s = HibernateCon.getCon();
		Person P =  (Person) s.get(Person.class, pid);
		s.delete(P);
	}
	public static void main(String[] args) {
		TestHibernate T = new TestHibernate();
		
//		T.savedata();
//		T.getbyid(3);
//		T.getAll();
//		T.update(2);
		T.deletedata(3);
	}

}
