package br.eng.rafaelpsouza.config;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wordnik.swagger.config.ScannerFactory;
import com.wordnik.swagger.jaxrs.config.BeanConfig;

@Configuration
public class SwaggerConfig {

	@Bean
	public BeanConfig swaggerBean(){
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0");
		beanConfig.setHost("localhost:8080");
		beanConfig.setBasePath("/api");
		beanConfig.setResourcePackage("br.eng.rafaelpsouza");
		beanConfig.setScan(true);
		ScannerFactory.setScanner(beanConfig);
		return beanConfig;
	}
	
	@Bean
	public ServletRegistrationBean swaggerServletRegistration() {
		ServletRegistrationBean swaggerBean = new ServletRegistrationBean();
		swaggerBean.setName("Jersey2Config");
		swaggerBean.setServlet(new com.wordnik.swagger.jersey.config.JerseyJaxrsConfig());
		swaggerBean.addInitParameter("api.version", "1.0");
		swaggerBean.addInitParameter("swagger.api.basepath", "/api");
		return swaggerBean;
	}
	
	@Bean
	public FilterRegistrationBean swaggerCORSFilter(){
		FilterRegistrationBean filterBean = new FilterRegistrationBean();
		filterBean.setFilter(new SimpleCORSFilter());
		filterBean.setName("swaggerCORS");
		filterBean.addUrlPatterns("/api/*");
		return filterBean;
	}

}
