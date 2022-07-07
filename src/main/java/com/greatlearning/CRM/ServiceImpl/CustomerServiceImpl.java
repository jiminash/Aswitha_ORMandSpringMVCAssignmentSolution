package com.greatlearning.CRM.ServiceImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.CRM.Service.CustomerService;
import com.greatlearning.CRM.model.Customer;

@Repository
public class CustomerServiceImpl implements CustomerService {

	private SessionFactory sessionFactory;

	// create session
	private Session session;

	@Autowired
	CustomerServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}

	@Transactional
	public List<Customer> getAllCustomers() {

		List<Customer> customers = session.createQuery("from Customer").list();
		return customers;
	}

	@Transactional
	public Customer getById(int id) {
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		tx.commit();
		return customer;
	}

	@Override
	public void deleteCustomerById(int id) {
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		 session.delete(customer);
		tx.commit();
		
		
	}

	@Override
	public void saveCustomer(Customer customer) {
		Transaction tx = session.beginTransaction();
		 session.saveOrUpdate(customer);
		tx.commit();
	}

}
