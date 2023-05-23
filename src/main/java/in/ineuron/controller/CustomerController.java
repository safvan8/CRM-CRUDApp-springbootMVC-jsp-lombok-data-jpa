package in.ineuron.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.ineuron.model.Customer;
import in.ineuron.service.ICustomerService;

/**
 * @author safvan
 *
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

	// Injecting CustomerService depdendent object.
	@Autowired
	private ICustomerService service;

	/**
	 * @param model - Map object
	 * @return String - view name - displays the list of all availble customers
	 */
	@GetMapping("/list")
	public String listCustomers(Map<String, Object> model) {
		System.out.println("Implementation class is :: " + service.getClass().getName());
		List<Customer> customers = service.getCustomers();
		customers.forEach(System.out::println);
		model.put("customers", customers);
		return "list-customers";
	}

	/**
	 * @param model
	 * @return view name - shows empty form.
	 */
	@GetMapping("/showForm")
	public String showFormForAdd(Map<String, Object> model) {

		// adding empty customer object to map for displaying in Spring Taglib form
		// this will help in enabling 2 way binding
		Customer customer = new Customer();
		model.put("customer", customer);

		// going to form for getting edited customer objects
		// this is 2 way binding
		return "customer-form";
	}

}
