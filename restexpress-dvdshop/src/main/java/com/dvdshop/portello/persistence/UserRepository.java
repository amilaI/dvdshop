package com.dvdshop.portello.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dvdshop.model.User;
import com.dvdshop.model.dao.UserDao;
import com.dvdshop.portello.config.MySQLHibernateConfig;

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

	public User getUser(int userId) {
		SessionFactory sessionFactory = MySQLHibernateConfig
				.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();

		UserDao s = (UserDao) session.get(UserDao.class, userId);
		//System.out.println(s.getUserName());
		session.getTransaction().commit();
		session.close();

		User user = new User(s.getUserName(), s.getUserID(), s.getUserType());
		return user;

	}

}
