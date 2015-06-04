package com.dvdshop.portello.persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dvdshop.model.DVD;
import com.dvdshop.model.dao.BookingDao;
import com.dvdshop.model.dao.DvdDao;
import com.dvdshop.portello.config.MySQLHibernateConfig;

public class BookingRepository {

	private Session session;

	public BookingRepository() {
		SessionFactory sessionFactory = MySQLHibernateConfig
				.getSessionFactory();
		session = sessionFactory.openSession();

	}

	public void addBooking(BookingDao bookingDao) {
		SessionFactory sessionFactory = MySQLHibernateConfig
				.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(bookingDao);
		session.getTransaction().commit();

		session.close();

	}

	public List<BookingDao> getBookingList() {

		SessionFactory sessionFactory = MySQLHibernateConfig
				.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();

		List<DVD> returnDvdLsit = null;

		List<BookingDao> bookingList = session.createCriteria(BookingDao.class)
				.list();
		session.close();
		return bookingList;

	}

}
