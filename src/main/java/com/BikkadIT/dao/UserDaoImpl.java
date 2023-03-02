package com.BikkadIT.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BikkadIT.entity.User;

@Repository
public class UserDaoImpl implements UserDaoI{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int saveUserToDb(User user) {
		System.out.println("Dao layer method");
		System.out.println(user);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		int save = (int) session.save(user);
		session.getTransaction().commit();
		
		return save;
	}

	@Override
	public List<User> getAllData() {
	    Session s = sessionFactory.openSession();
	    
	    Query query = s.createQuery("from User");
	    List<User> list = query.getResultList();
		return list;
	}

	@Override
	public List<User> getAllDataFromDB() {
		Session s1 = sessionFactory.openSession();
		Query query1 = s1.createQuery("from User");
		List list = query1.getResultList();
		return list;
	}
	@Override
	public User getsingle(int uid) {
		Session session = sessionFactory.openSession();
		User user = session.get(User.class, uid);
		return user;
	}
	
	@Override
	public List<User> updateUser(User user) {
		Session session = sessionFactory.openSession();
		session.update(user);
		session.beginTransaction();
		session.getTransaction().commit();
		
		Session session2 = sessionFactory.openSession();
		Query query = session2.createQuery("from User");
		List list = query.getResultList();
		return list;
	}

	
	@Override
	public User deleteuser(int uid) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = session.get(User.class, uid);
		//if(user!=null) {
		session.delete(user);
		session.getTransaction().commit();
		session.close();
		//}
		return user;
	}

	

	

}
