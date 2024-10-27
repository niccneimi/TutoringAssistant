package com.example.demo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
<<<<<<< HEAD
            .csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/register", "/login", "/products", "/products/image/*", "/").permitAll()
=======
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/register", "/login").anonymous()
                .requestMatchers("/products", "/products/image/*", "/").permitAll()
>>>>>>> master
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/products", true)
                .permitAll()
            )
<<<<<<< HEAD
            .logout(logout -> logout.permitAll());

=======
            .logout(logout -> logout
                .logoutSuccessUrl("/products")
                .permitAll());
>>>>>>> master
        return http.build();
    }

  
  @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}

