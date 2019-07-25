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


@Repository("carDAO")
public class CarDAOImpl implements CarDAO{
	
	@Autowired
	SessionFactory sessionFact;
	
	@Override
	public List<Car> getAllCars(){
		ArrayList<Car> carList = new ArrayList<>();
		Query query = sessionFact.getCurrentSession().createQuery("from Car");
		//query.setMaxResults(3);
		carList = (ArrayList<Car>) query.list();
		System.out.println("list in dao "+ carList);
		return carList;
	}
	
	@Override
		public Car fetchCarbyId(int cid) {
			Session currentSession = sessionFact.getCurrentSession();
			Car theCar = currentSession.get(Car.class, cid);
			return theCar;
		}
	
	@Override
		public void deleteCarById(Integer cid) {
			Session session = sessionFact.getCurrentSession();
			Car car = session.byId(Car.class).load(cid);
			System.out.println("Delete Called from dao" + car);
			session.delete(car);
		}
	
	@Override
		public void addCar(Car car) {
		sessionFact.getCurrentSession().saveOrUpdate(car);
		System.out.println("Data saved");
	}
	
}
