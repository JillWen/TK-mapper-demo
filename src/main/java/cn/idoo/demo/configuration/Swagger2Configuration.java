package cn.idoo.demo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Configuration {

	@Value(value = "${swagger.basePackage}")
	private String swaggerBasePackage;

	@Bean
	public Docket buildDocket() {
		return 
				new Docket(DocumentationType.SWAGGER_2).
				apiInfo(buildApiInfo()).
				select().
				apis(RequestHandlerSelectors.
				basePackage(swaggerBasePackage)).
				paths(PathSelectors.any()).
				build();
	}

	private ApiInfo buildApiInfo() {
		 return 
				new ApiInfoBuilder().
				title("demo接口").
				description("接口地址: http://127.0.0.1:9999/").
				termsOfServiceUrl("http://127.0.0.1:9999/").
				version("0.0.1").
				build();
	}
	
}
