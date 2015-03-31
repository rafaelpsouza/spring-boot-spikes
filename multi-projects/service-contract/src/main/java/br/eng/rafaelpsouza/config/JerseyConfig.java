package br.eng.rafaelpsouza.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import br.eng.rafaelpsouza.contract.Endpoint;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(Endpoint.class);
    }

}