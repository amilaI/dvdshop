package com.dvd.hibernate.repo;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dvd.domain.Dvd;
import com.dvd.hibernate.config.MySQLHibernateConfig;
import com.dvd.hibernate.doa.DVDCopyDao;
import com.dvd.hibernate.doa.DvdDao;
import com.dvd.hibernate.domain.DVD;

public class DVDRepository {

	private Session session;

	public DVDRepository() {
		SessionFactory sessionFactory = MySQLHibernateConfig
				.getSessionFactory();
		session = sessionFactory.openSession();

	}

	public void createDVD(DVD dvd) {
		SessionFactory sessionFactory = MySQLHibernateConfig
				.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		DvdDao dvdDao = new DvdDao(dvd.getTitle(), dvd.getActors(),
				dvd.getRating(), dvd.getDefiniiton(), dvd.getYear());

		session.save(dvdDao);
		session.getTransaction().commit();

		session.close();

	}
	
	public void createCopyDVD(DVDCopyDao dvd) {
		SessionFactory sessionFactory = MySQLHibernateConfig
				.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(dvd);
		session.getTransaction().commit();

		session.close();

	}
	public void updateCopyDVD(DVDCopyDao dvd) {
		SessionFactory sessionFactory = MySQLHibernateConfig
				.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.update(dvd);
		session.getTransaction().commit();

		session.close();

	}
	public List<DVDCopyDao> getCopyDVDList(int id) {

		List<DVDCopyDao> copyList = null;
		SessionFactory sessionFactory = MySQLHibernateConfig
				.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();

		/*
		 * DVDCopyDao copyDao = new DVDCopyDao(202, "tesyt", "sdasdas", 200,
		 * "1"); session.save(copyDao); session.getTransaction().commit();
		 */

		List<DVDCopyDao> dvdList = session.createCriteria(DVDCopyDao.class)
				.list();

		if (dvdList != null && !dvdList.isEmpty()) {
			copyList = new ArrayList<DVDCopyDao>();
			for (DVDCopyDao dvdCopyDao : dvdList) {
				if (dvdCopyDao.getDvdCode() == id) {
					copyList.add(dvdCopyDao);
				}
			}
		}
		session.close();
		return copyList;

	}

	public List<Dvd> getDVDList() {

		SessionFactory sessionFactory = MySQLHibernateConfig
				.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();

		List<Dvd> returnDvdLsit = null;

		List<DvdDao> dvdList = session.createCriteria(DvdDao.class).list();

		if (dvdList != null) {
			returnDvdLsit = new ArrayList<Dvd>();

			for (DvdDao dvdDao : dvdList) {
				System.out.println(decodeValues(dvdDao.getTitle()));
				Dvd dvd = new Dvd(dvdDao.getDvdID(),
						decodeValues(dvdDao.getTitle()),
						decodeValues(dvdDao.getActors()), dvdDao.getRating(),
						dvdDao.getDefinition(), dvdDao.getYear());
				returnDvdLsit.add(dvd);
			}
		}
		session.close();
		return returnDvdLsit;

	}

	public List<DVDCopyDao> getCopyList(int copyId) {

		List<DVDCopyDao> copyList = null;
		SessionFactory sessionFactory = MySQLHibernateConfig
				.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();

		/*
		 * DVDCopyDao copyDao = new DVDCopyDao(202, "tesyt", "sdasdas", 200,
		 * "1"); session.save(copyDao); session.getTransaction().commit();
		 */

		List<DVDCopyDao> dvdList = session.createCriteria(DVDCopyDao.class)
				.list();
		if (dvdList != null && !dvdList.isEmpty()) {
			copyList = new ArrayList<DVDCopyDao>();
			for (DVDCopyDao dvdCopyDao : dvdList) {
				if (dvdCopyDao.getCopyNumber() == copyId) {
					copyList.add(dvdCopyDao);
					break;
				}
			}
		}
		session.close();
		return copyList;

	}

	public String decodeValues(String value) {
		return URLDecoder.decode(value);
	}
}
