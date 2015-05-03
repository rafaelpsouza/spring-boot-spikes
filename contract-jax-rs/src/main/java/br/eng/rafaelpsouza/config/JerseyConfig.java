package br.eng.rafaelpsouza.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import br.eng.rafaelpsouza.contract.Endpoint;

@Component
@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		packages("com.wordnik.swagger.jaxrs.json","br.eng.rafaelpsouza");
		register(com.wordnik.swagger.jaxrs.listing.ApiListingResource.class);
		register(com.wordnik.swagger.jaxrs.listing.SwaggerSerializers.class);
		register(Endpoint.class);

	}
}