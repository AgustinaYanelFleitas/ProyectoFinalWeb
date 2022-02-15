package com.proyectofinalweb.proyectofinalweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Primary
    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Gestor de Campo")
                .description("Control de proyecto de cultivos")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .termsOfServiceUrl("")
                .version("1.0.0")
                .contact(new Contact("Nicolas", "", "enzonicolasreinaldo234@gmail.com"))
                .build();
    }

    @Bean
    public Docket customImplementation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //Aqui se agrega la ruta del proyecto
                .apis(RequestHandlerSelectors.basePackage("com.proyectofinalweb.proyectofinalweb"))
                .build()
                .apiInfo(apiInfo());
    }


}
