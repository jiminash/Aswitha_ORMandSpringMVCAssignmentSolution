package com.greatlearning.CRM.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.CRM.Service.CustomerService;
import com.greatlearning.CRM.model.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/list")
	public String listAllCustomers(Model theModel) {

		List<Customer> customers = customerService.getAllCustomers();
		theModel.addAttribute("Customers", customers);

		return "list-customer";
	}

	@RequestMapping("/showFormForAdd")
	public String addCustomer(Model theModel) {

		Customer customer = new Customer();
		theModel.addAttribute("Customer", customer);

		return "Customer-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String updateCustomer(@RequestParam("customerId") int id, Model theModel) {

		Customer customer = customerService.getById(id);
		theModel.addAttribute("Customer", customer);
		return "Customer-form";
	}

	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {

		customerService.deleteCustomerById(id);

		return "redirect:/customer/list";
	}

	@RequestMapping("/save")
	public String saveCustomers(@RequestParam("id") int id, @RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("email") String email) {
		Customer customer;
		if (id != 0) {
			customer = customerService.getById(id);
			customer.setFirstName(firstname);
			customer.setLastName(lastname);
			customer.setEmail(email);
		} else {
			customer = new Customer(firstname, lastname, email);
		}

		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}

}
