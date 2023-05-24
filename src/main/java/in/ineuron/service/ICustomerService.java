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

	/**
	 * @param customer object for saving to DB
	 */
	public void saveCustomer(Customer customer);

	/**
	 * @param customerId - for retreiving from DB
	 * @return Customer object based on ID supplied
	 */
	public Customer getCustomer(Integer customerId);

	/**
	 * @param customerId - for deleting from DB
	 */
	public void deleteById(Integer customerId);
}
