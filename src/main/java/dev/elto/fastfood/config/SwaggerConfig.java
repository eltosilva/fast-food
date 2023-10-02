package dev.elto.fastfood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI()
        .info(
            new Info()
                .title("Fast Food API - Simulator")
                .description(
                    "Projeto inspirado em [Fast Food - App](https://github.com/florinpop17/app-ideas/blob/master/Projects/3-Advanced/FastFood-App.md)")
                .version("1.0")
                .termsOfService("Termo de uso: Open Source"));
  }
}
