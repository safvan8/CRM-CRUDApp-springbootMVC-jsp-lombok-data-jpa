package in.ineuron.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.ineuron.model.Customer;

/**
 * Interface for performing persistence operations on Customer objects.
 * 
 * This interface extends the PagingAndSortingRepository interface provided by
 * Spring Data JPA. By defining this repository interface, Spring generates a
 * proxy class at runtime that implements the interface and provides the
 * implementation of the repository methods.
 * 
 * The generated proxy class serves as an in-memory Java class that utilizes the
 * JPA EntityManager or Hibernate Session to execute the data access operations
 * defined by the repository interface.
 * 
 * Each method declared in this interface represents a specific persistence
 * operation that can be performed on Customer objects.
 * 
 * For additional information on the Spring Data JPA repository pattern, please
 * refer to the official Spring Data documentation.
 * 
 * @see org.springframework.data.repository.PagingAndSortingRepository
 * @see in.ineuron.model.Customer
 * 
 * @author safvan
 */
public interface ICustomerDAO extends PagingAndSortingRepository<Customer, Integer> {

}
