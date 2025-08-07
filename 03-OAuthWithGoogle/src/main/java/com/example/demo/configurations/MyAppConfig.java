package com.example.demo.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MyAppConfig {

	@Bean
	SecurityFilterChain filters(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                (req) -> req.requestMatchers("/home").permitAll()
                        .anyRequest()
                        .authenticated())
                .oauth2Login(auth->auth.defaultSuccessUrl("/profile", true));
		return http.build();
	}
}
