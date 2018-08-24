package br.eng.rafaelpsouza;

import java.io.IOException;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;

/**
 *
 * @author Rafael Souza
 */
@EnableAutoConfiguration
@ComponentScan
public class Application {

    public static void main(String[] args) throws IOException {
        new SpringApplicationBuilder(Application.class)
                .properties("management.contextPath:/resources")
                .properties("spring.application.name:example-service")
                .properties("info.version:1.0")
                .listeners(new ApplicationPidFileWriter()).run();
    }

}
