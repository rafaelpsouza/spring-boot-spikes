package br.eng.rafaelpsouza;

import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.client.RestTemplate;

public class ExampleService {

    private RestTemplate restTemplate;
    private JdbcTemplate jdbcTemplate;

    private static final Logger log = LoggerFactory.getLogger(ExampleService.class);

    public ExampleService(RestTemplate restTemplate, JdbcTemplate jdbcTemplate) {
        this.restTemplate = restTemplate;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Async("appPool")
    public void asyncCall() throws InterruptedException {
        log.info("Async request ...");
        restTemplate.getForObject("http://demo6613639.mockable.io/test", String.class);

        log.info("Async request done!");
    }

    public void dbQuery() {
        jdbcTemplate.execute("SELECT pg_sleep(10)");
    }

    @Timed("mytimed")
    public void timedTest() throws InterruptedException {
        log.info("Timed");
        Thread.sleep(2000);
    }


}
