package ua.thecoon.hotel.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "ua.thecoon.hotel")
public class SpringDataJpaConfig {
}