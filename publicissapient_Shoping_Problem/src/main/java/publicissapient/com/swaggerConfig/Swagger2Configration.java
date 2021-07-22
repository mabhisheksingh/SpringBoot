package publicissapient.com.swaggerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Configration {
	
	@Bean
	public Docket swaggerDocumantion() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/clothes/*"))
				.apis(RequestHandlerSelectors.basePackage("publicissapient.com"))
				.build()
				.apiInfo(apiInfo());
	}
	
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Clothes API")
				.description("Sample Api for Swagger tutorial")
				.license("Free to use")
				.version("1.3")
				.contact(new Contact("Abhishek Singh", "abhishekit13006gmail.com", "7271058852"))
				.build();
	}

}
