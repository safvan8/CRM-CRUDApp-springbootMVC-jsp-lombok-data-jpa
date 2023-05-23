package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author safvan The main class that bootstraps the CRM CRUD application using
 *         Spring Boot, MVC, JSP, Lombok, and Data JPA.
 */
@SpringBootApplication
public class CrmCrudAppSpringbootMvcJspLombokDataJpaApplication {

	/**
	 * The main method of the application. It starts the Spring Boot application.
	 *
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(CrmCrudAppSpringbootMvcJspLombokDataJpaApplication.class, args);
	}

}
