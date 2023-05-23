package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.ICustomerDAO;
import in.ineuron.model.Customer;

/**
 * Implementation class of ICustomerService
 * 
 * @author safvan
 *
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDAO customerDAO;

	/**
	 * @return List<Customer> - all the availble Customer Objects from Database.
	 */
	@Override
	public List<Customer> getCustomers() {

		return (List<Customer>) customerDAO.findAll();
	}

	/**
	 * @param customer object for saving to DB
	 */
	@Override
	public void saveCustomer(Customer customer) {
		Customer savedCustomer = customerDAO.save(customer);
		System.out.println("Saved Object is: " + savedCustomer);
	}

	/**
	 * @param customerId - for retreiving from DB
	 * @return Customer object based on ID supplied
	 */
	@Override
	public Customer getCustomer(Integer customerId) {
		Optional<Customer> customer = customerDAO.findById(customerId);
		return customer.get();
	}
}
