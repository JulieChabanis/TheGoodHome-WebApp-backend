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
              .requestMatchers("/api/agencies").permitAll()
              .requestMatchers("/api/appartments").permitAll()
              .requestMatchers("/api/pdf").permitAll()
              .requestMatchers("/api/contracts").permitAll()
              .requestMatchers("/api/solde_paiements").permitAll()
              .requestMatchers("/api/rent-receipt").permitAll()
              .requestMatchers("/api/tenants").permitAll()
              .and()
              .authorizeHttpRequests().requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
              .anyRequest().authenticated()
              .and()
              .formLogin()
              .and()
              .httpBasic();

      return httpSecurity.build();
  }

}
