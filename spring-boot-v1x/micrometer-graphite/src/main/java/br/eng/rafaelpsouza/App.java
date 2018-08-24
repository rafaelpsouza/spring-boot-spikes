package br.eng.rafaelpsouza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
@RestController
@SpringBootApplication
@EnableScheduling
@EnableAsync
@Import(MyConfiguration.class)
public class App {

    @Autowired
    ExampleService exampleService;

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(App.class, args);
    }

    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String hi() {
        return "Hi!";
    }

    @RequestMapping(value = "async", method = RequestMethod.GET)
    public String restClientCall() throws InterruptedException {
        exampleService.asyncCall();
        return "OK";
    }

    @RequestMapping(value = "query", method = RequestMethod.GET)
    public String dbCall() {
        exampleService.dbQuery();
        return "OK";
    }

    @RequestMapping(value = "timed", method = RequestMethod.GET)
    public String timed() throws InterruptedException {
        exampleService.timedTest();
        return "OK";
    }

}
