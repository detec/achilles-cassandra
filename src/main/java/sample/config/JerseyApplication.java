package sample.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;
import sample.rest.CustomerEndpoint;

/**
 * Jersey configuration
 *
 * @author Andrii Duplyk
 *
 */
@ApplicationPath("/")
public class JerseyApplication extends Application {

	public JerseyApplication() {
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0.2");
		beanConfig.setSchemes(new String[] { "http" });
		beanConfig.setHost("localhost:8080");
		beanConfig.setBasePath("/api");
		beanConfig.setResourcePackage("io.swagger.resources");
		beanConfig.setScan(true);
	}

	@Override
	public Set<Class<?>> getClasses() {
		HashSet<Class<?>> set = new HashSet<>();
		set.add(CustomerEndpoint.class);

		// swagger
		set.add(io.swagger.jaxrs.listing.ApiListingResource.class);
		set.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

		return set;
	}

}
