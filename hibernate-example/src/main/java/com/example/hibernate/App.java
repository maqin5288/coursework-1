package com.example.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.example.hibernate.domain.Address;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = new Configuration() //
					.configure() //
					.buildSessionFactory();

			session = sessionFactory.openSession();

			runHqlQuery(session);
			runSqlQuery(session);
			runCriteriaQuery(session);

			createNewAddress(session);

			deleteAllAddressesWhoseIdIsGreaterThanSix(session);

		} finally {
			if (session != null)
				session.close();
			if (sessionFactory != null)
				sessionFactory.close();
		}
	}

	private static void createNewAddress(Session session) {
		Address address = new Address();
		address.setApartmentNumber("A1234");
		address.setCity("Livonia");
		address.setState("MI");
		address.setStreetAddress("1234098 somewhere");
		address.setZip(12345);

		Transaction transaction = session.beginTransaction();
		try {
			session.save(address);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("could not save the data...");
			transaction.rollback();
		}
	}

	private static void deleteAllAddressesWhoseIdIsGreaterThanSix(
			Session session) {
		System.out.println("-----------------");
		System.out.println("Deleting the objects whose ID > 6");
		Criteria criteria = session.createCriteria(Address.class);
		criteria.add(Restrictions.gt("id", 6L));
		List<Address> addresses = criteria.list();
		Transaction transaction = session.beginTransaction();
		for (Address address : addresses) {
			session.delete(address);
		}
		transaction.commit();
	}

	private static void runCriteriaQuery(Session session) {
		System.out.println("-----------------");
		System.out.println("Running Criteria Query");
		Criteria criteria = session.createCriteria(Address.class);
		// criteria.add(Restrictions.le("id", 3L));
		criteria.add(Restrictions.sqlRestriction("id <= 3"));
		List<Address> addresses = criteria.list();
		for (Address address : addresses) {
			System.out.println(address.getCity());
		}
	}

	private static void runHqlQuery(Session session) {
		System.out.println("-----------------");
		System.out.println("Running HQL Query");
		Query hqlQuery = session
				.createQuery("from Address address where address.id <= 3"); // HQL
		List<Address> addresses = hqlQuery.list();
		for (Address address : addresses) {
			System.out.println(address.getCity());
		}
	}

	private static void runSqlQuery(Session session) {
		System.out.println("-----------------");
		System.out.println("Running SQL Query");
		Query sqlQuery = session
				.createSQLQuery("select * from address where id <= 3"); // SQL
		List<Object[]> addresses = sqlQuery.list();
		for (Object[] address : addresses) {
			System.out.println(address[3]);
		}
	}

}
