package com.firstbit.utils;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.firstbit.models.Bus;
import com.firstbit.models.Ticket;

public class HibernateUtils {

	public static Session getSession() {
		SessionFactory sessionFactory = new Configuration().setProperties(getMYSQLDatabaseProps())
				.addAnnotatedClass(Bus.class).addAnnotatedClass(Ticket.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		return session;
	}

	public static Properties getMYSQLDatabaseProps() {
		Properties mysqlProperties = new Properties();
		return mysqlProperties;
	}

	public static Transaction startTransaction(Session session) {
		Transaction transaction = session.beginTransaction();
		return transaction;
	}

}
