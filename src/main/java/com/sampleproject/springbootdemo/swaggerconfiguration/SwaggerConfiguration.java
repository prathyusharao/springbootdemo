package com.sampleproject.springbootdemo.swaggerconfiguration;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket employeesApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("SpringBoot Application Demo").apiInfo(apiInfo()).select()
				.paths(regex("/employee.*")).build();
	}

	private ApiInfo apiInfo() {
		
	
			return new ApiInfoBuilder().title("SPRINGBOOT APPLICATION")
					.description("Sample Documentation Generateed Using SWAGGER2 for SpringBootDemo Application")
					.termsOfServiceUrl("https://springbootdemoapplicationofemployee")
					.license("SpringBootDemo")
					.licenseUrl("https://springbootdemoapplicationofemployee").version("1.0").build();
		}
}
