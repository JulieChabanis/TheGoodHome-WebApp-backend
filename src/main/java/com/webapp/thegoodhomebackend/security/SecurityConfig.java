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

    private static final String AGENCIES_API_URL = "/api/agencies";
    private static final String APPARTMENTS_API_URL = "/api/appartments";
    private static final String PDF_API_URL = "/api/pdf";
    private static final String CONTRACTS_API_URL = "/api/contracts";

  private static final String PAYMENTS_API_URL = "/api/solde_paiements";
  private static final String RENT_RECEIPT_API_URL = "/api/rent-receipt";
  private static final String TENANTS_API_URL = "/api/tenants";


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
              .anyRequest().authenticated()
              .and()
              .formLogin()
              .and()
              .httpBasic();

      return httpSecurity.build();
  }

}
