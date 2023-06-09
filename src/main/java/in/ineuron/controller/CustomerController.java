package in.ineuron.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	/**
	 * @param customer object from the spring taglib form
	 * @return - view name : redirecting to the listing page again
	 */
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		System.out.println(customer);

		// sending object for saving to db
		service.saveCustomer(customer);

		// redirecting to the list page after saving automtaically, to check whether it
		// is added to table list
		return "redirect:/customer/list";
	}

	/**
	 * for displaying edit form, Id is accessed through one way binding
	 * 
	 * @param customerId - ID of the customer for updating details, passed as
	 *                   request param.
	 * @param model      - for displying the retrived customer object from db and
	 *                   desplaying.
	 * @return view name - conatins form for saving and updating purpose.
	 */
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam Integer customerId, Map<String, Object> model) {
		Customer customer = service.getCustomer(customerId);
		System.out.println(customer);

		model.put("customer", customer);
		return "customer-form";
	}

	/**
	 * @param customerId - for deleting from DB
	 * @return String -view name : redirecting to the listing page again
	 */
	@GetMapping("/performDelete")
	public String deleteCustomer(@RequestParam Integer customerId) {
		service.deleteById(customerId);
		return "redirect:/customer/list";
	}

}
