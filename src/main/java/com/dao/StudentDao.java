package com.dao;

import javax.persistence.EntityTransaction;
import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class StudentDao {
	SessionFactory sf;

	public StudentDao() {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		sf = con.buildSessionFactory();
	}

	public boolean storeStuentRecord(Student ss) {
		try {
			Session session =sf.openSession();
			Transaction tran = (Transaction) session.getTransaction();
			 tran.begin();
			session.save(ss);
			tran.commit();
			return true;
			
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
}

