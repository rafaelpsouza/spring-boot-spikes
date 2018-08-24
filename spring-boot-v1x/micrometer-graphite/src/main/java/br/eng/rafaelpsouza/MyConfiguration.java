package br.eng.rafaelpsouza;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import io.micrometer.graphite.GraphiteConfig;
import io.micrometer.graphite.GraphiteMeterRegistry;
import io.micrometer.spring.async.ThreadPoolTaskExecutorMetrics;
import io.micrometer.spring.autoconfigure.MeterRegistryCustomizer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executor;

@Configuration
public class MyConfiguration {

    @Bean
    public MeterRegistryCustomizer<GraphiteMeterRegistry> myCommonTags() {
        return registry -> registry.config().commonTags("rafael", "rafael", "production", "production");
    }

    /**
     * Needed becouse GraphiteMeterRegistry post bean processing is called before MeterRegistryCustomizer myCommonTags,
     * probably a Bug
     */
    @Bean
    public GraphiteMeterRegistry graphiteMeterRegistry(GraphiteConfig config, Clock clock,
                                                       MeterRegistryCustomizer myCommonTags) {
        return new GraphiteMeterRegistry(config, clock);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

    @Bean
    public ExampleService asyncService(RestTemplate restTemplate, JdbcTemplate jdbcTemplate) {
        return new ExampleService(restTemplate, jdbcTemplate);
    }
    /*
     *   I don't know why you need to registry tags in order to get ThreadPoolTaskExecutorMetrics exporting
     */
    @Bean
    Executor appPool(MeterRegistry registry) {
        ThreadPoolTaskExecutor executor = ThreadPoolTaskExecutorMetrics.monitor(registry, "appPool",
                Tags.of("t1", "v1"));
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(10);
        return executor;
    }

    @Bean
    public TimedAspect timedAspect(MeterRegistry registry) {
        return new TimedAspect(registry);
    }

}
