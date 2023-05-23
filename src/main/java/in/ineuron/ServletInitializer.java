package in.ineuron;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Servlet initializer class used for configuring the Spring Boot application to
 * run in a servlet container. Extends the SpringBootServletInitializer class.
 */
public class ServletInitializer extends SpringBootServletInitializer {

	/**
	 * Configures the application builder with the main application class.
	 *
	 * @param application the SpringApplicationBuilder instance
	 * @return the configured SpringApplicationBuilder
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CrmCrudAppSpringbootMvcJspLombokDataJpaApplication.class);
	}

}
