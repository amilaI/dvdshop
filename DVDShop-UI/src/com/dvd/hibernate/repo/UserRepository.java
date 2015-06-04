package com.dvd.hibernate.repo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dvd.hibernate.config.MySQLHibernateConfig;
import com.dvd.hibernate.doa.UserDao;
import com.dvd.hibernate.domain.User;

public class UserRepository {

	private Session session;

	public UserRepository() {
		

	}

	public void createUser(User user) {
		SessionFactory sessionFactory = MySQLHibernateConfig
				.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();

		UserDao userdao = new UserDao(user.getUserName(),
				user.getUserID(), user.getUserType());

		session.save(userdao);
		session.getTransaction().commit();

		session.close();
	}

	public com.dvd.domain.User getUser(int userId) {
		SessionFactory sessionFactory = MySQLHibernateConfig
				.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();

		UserDao s = (UserDao) session.get(UserDao.class, userId);
		//System.out.println(s.getUserName());
		session.getTransaction().commit();
		session.close();

		com.dvd.domain.User user = new com.dvd.domain.User(s.getUserName(), s.getUserID(), s.getUserType());
		return user;

	}

}
