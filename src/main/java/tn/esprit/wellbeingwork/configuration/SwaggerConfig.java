package tn.esprit.wellbeingwork.configuration;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author amoujbani on 7/17/2022
 * @project WellBeingWork
 */
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo () {
        return new ApiInfoBuilder()
                .title("Stock Management Swagger Configuration")
                .description("\"Spring Boot Swagger configuration\"")
                .version("1.1.0").build();
    }
}
