package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import app.core.auth.JwtUtilImpl;
import app.core.filter.SchoolFilter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootDataJpaMappingaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaMappingaApplication.class, args);
	}
	
	@Bean
	@Order(2)
	FilterRegistrationBean<SchoolFilter> registationBean(JwtUtilImpl jwt){
		FilterRegistrationBean<SchoolFilter> bean = new FilterRegistrationBean<>();
		bean.setFilter(new SchoolFilter(jwt));
		bean.addUrlPatterns("/api/school/*");
		return bean;
	}

}
