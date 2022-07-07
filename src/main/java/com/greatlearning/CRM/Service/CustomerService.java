package com.greatlearning.CRM.Service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.CRM.model.Customer;

@Service
public interface CustomerService {

	Customer getById(int id);

	void deleteCustomerById(int id);

	List<Customer> getAllCustomers();

	void saveCustomer(Customer customer);


}