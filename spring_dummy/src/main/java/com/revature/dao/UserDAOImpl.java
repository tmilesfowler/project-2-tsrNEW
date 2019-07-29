package com.revature.dao;


import java.util.ArrayList;
import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.entity.Car;
import com.revature.entity.User;
import com.revature.mail.SendEmail;


@Repository("userDAO")
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	SessionFactory sessionFact;
	
	@Override
	public List<User> getAllUsers(){
		ArrayList<User> userList = new ArrayList<>();
		Query query = sessionFact.getCurrentSession().createQuery("from User");
		//query.setMaxResults(3);
		userList = (ArrayList<User>) query.list();
		System.out.println("list in dao "+ userList);
		return userList;
	}
	
	@Override
		public User fetchUserbyId(int uid) {
			Session currentSession = sessionFact.getCurrentSession();
			User theUser = currentSession.get(User.class, uid);
			return theUser;
		}
	
	@Override
		public void deleteUserById(Integer uid) {
			Session session = sessionFact.getCurrentSession();
			User user = session.byId(User.class).load(uid);
			System.out.println("Delete Called from dao" + user);
			session.delete(user);
		}
	
	@Override
		public void addUser(User user) {
		sessionFact.getCurrentSession().saveOrUpdate(user);
		System.out.println("Data saved");
	}
	
	@Override
	public void sendJMail(String email) {	
		System.out.println("DAO sending to: " + email);
		List <User> lu= getAllUsers();
		String fPassword = null;
		
		for(User user: lu) {
			if(user.getEmail().equals(email)) {
				System.out.println("Found user " + email);
				fPassword = user.getPassword();
			}
				
		}
		SendEmail jMail = new SendEmail(email, fPassword, null);
	}
	
	@Override
	public void recallJMail(String email) {
		//email = the dummy email
		SendEmail recall = new SendEmail(email, null, "Recall");
	}
	
}
