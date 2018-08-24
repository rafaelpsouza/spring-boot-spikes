package br.eng.rafaelpsouza.config;

import br.eng.rafaelpsouza.endpoint.RestEndpoint;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("example")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(RestEndpoint.class);
    }

}
