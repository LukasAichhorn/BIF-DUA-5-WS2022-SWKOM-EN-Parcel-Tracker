package at.fhtw.swen3.openapitools;

import com.fasterxml.jackson.databind.Module;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableJpaRepositories("at.fhtw.swen3.persistence.repositories")
@EntityScan("at.fhtw.swen3.persistence.entities")
@ComponentScan(basePackages = {"at.fhtw.swen3.openapitools", "at.fhtw.swen3.services", "at.fhtw.swen3" +
        ".configuration", "at.fhtw.swen3.controller", "at.fhtw.swen3.persistence", "at.fhtw.swen3.persistence.entities","at.fhtw.swen3" +
        ".persistence.repositories"})
@EnableAutoConfiguration
public class OpenApiGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenApiGeneratorApplication.class, args);
    }

    @Bean
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

}