package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Customer;

/**
 * Interface for all the methods available in CustomerService class.
 * 
 * @author safvan.
 */
public interface ICustomerService {
	/**
	 * @return List<Customer> - all the availble customers from database
	 */
	public List<Customer> getCustomers();

}
