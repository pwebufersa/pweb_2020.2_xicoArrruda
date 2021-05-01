/*
Mudança na versão 3.0.0 do SpringFox:
Acesse a documentação da API por esse link: http://localhost:8080/swagger-ui/index.html

Detalhes aqui:
https://www.treinaweb.com.br/blog/documentando-uma-api-spring-boot-com-o-swagger/
https://stackoverflow.com/questions/62773219/suddenly-springfox-swagger-3-0-is-not-working-with-spring-webflux
*/
	
package br.com.cliente.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.any())
          .paths(PathSelectors.any())
          .build();
    }
}
