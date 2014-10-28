package com.example.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.domain.Address;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration() //
				.configure() //
				.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Address"); // SQL/HQL
		List<Address> list = query.list();
		for (Address address : list) {
			System.out.println(address);
		}
		session.close();
		sessionFactory.close();
	}

}
