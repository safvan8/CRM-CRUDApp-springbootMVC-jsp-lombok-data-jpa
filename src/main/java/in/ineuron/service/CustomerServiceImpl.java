package in.ineuron.service;

import java.util.List;

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
	 * @return List<Customer> - all the availble Customer Objects in Database.
	 */
	@Override
	public List<Customer> getCustomers() {

		return (List<Customer>) customerDAO.findAll();
	}

}
