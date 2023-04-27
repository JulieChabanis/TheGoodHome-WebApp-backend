package com.webapp.thegoodhomebackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
      httpSecurity
              .csrf().disable()
              .authorizeHttpRequests()
              .requestMatchers("/api/**").permitAll()
              .and()
              .authorizeHttpRequests().requestMatchers(HttpMethod.GET, "/api/**").permitAll()
              .and()
              .authorizeHttpRequests().requestMatchers(HttpMethod.POST, "/api/**").permitAll()
              .and()
              .authorizeHttpRequests().requestMatchers(HttpMethod.PUT, "/api/**").permitAll()
              .and()
              .authorizeHttpRequests().requestMatchers(HttpMethod.DELETE, "/api/**").permitAll()
              .and()
              .authorizeHttpRequests().requestMatchers(HttpMethod.DELETE, "/api/appartments/{id}").permitAll()
              .and()
              .authorizeHttpRequests().requestMatchers(HttpMethod.DELETE, "/api/tenants/{id}").permitAll()
              .and()
              .authorizeHttpRequests().requestMatchers(HttpMethod.DELETE, "/api/contracts/{id}").permitAll()
              .anyRequest().authenticated()
              .and()
              .formLogin()
              .and()
              .httpBasic();

      return httpSecurity.build();
  }

}
