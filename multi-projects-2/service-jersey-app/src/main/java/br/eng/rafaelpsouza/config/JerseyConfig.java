package br.eng.rafaelpsouza.config;

import br.eng.rafaelpsouza.endpoint.RestEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(RestEndpoint.class);
    }

}
