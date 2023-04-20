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
              .requestMatchers(HttpMethod.GET,AGENCIES_API_URL).permitAll()
              .requestMatchers(HttpMethod.POST,AGENCIES_API_URL).permitAll()
              .requestMatchers(HttpMethod.PUT, AGENCIES_API_URL).permitAll()
              .requestMatchers(HttpMethod.DELETE, AGENCIES_API_URL).permitAll()
              .requestMatchers(HttpMethod.GET, APPARTMENTS_API_URL).permitAll()
              .requestMatchers(HttpMethod.POST, APPARTMENTS_API_URL).permitAll()
              .requestMatchers(HttpMethod.PUT, APPARTMENTS_API_URL).permitAll()
              .requestMatchers(HttpMethod.DELETE,APPARTMENTS_API_URL).permitAll()
              .requestMatchers(HttpMethod.GET, PDF_API_URL).permitAll()
              .requestMatchers(HttpMethod.POST, PDF_API_URL).permitAll()
              .requestMatchers(HttpMethod.PUT, PDF_API_URL).permitAll()
              .requestMatchers(HttpMethod.DELETE, PDF_API_URL).permitAll()
              .requestMatchers(HttpMethod.GET, CONTRACTS_API_URL).permitAll()
              .requestMatchers(HttpMethod.POST, CONTRACTS_API_URL).permitAll()
              .requestMatchers(HttpMethod.PUT, CONTRACTS_API_URL).permitAll()
              .requestMatchers(HttpMethod.DELETE, CONTRACTS_API_URL).permitAll()
              .requestMatchers(HttpMethod.GET, PAYMENTS_API_URL).permitAll()
              .requestMatchers(HttpMethod.POST, PAYMENTS_API_URL).permitAll()
              .requestMatchers(HttpMethod.PUT, PAYMENTS_API_URL).permitAll()
              .requestMatchers(HttpMethod.DELETE, PAYMENTS_API_URL).permitAll()
              .requestMatchers(HttpMethod.GET, RENT_RECEIPT_API_URL).permitAll()
              .requestMatchers(HttpMethod.POST, RENT_RECEIPT_API_URL).permitAll()
              .requestMatchers(HttpMethod.PUT, RENT_RECEIPT_API_URL).permitAll()
              .requestMatchers(HttpMethod.DELETE, RENT_RECEIPT_API_URL).permitAll()
              .requestMatchers(HttpMethod.GET, TENANTS_API_URL).permitAll()
              .requestMatchers(HttpMethod.POST, TENANTS_API_URL).permitAll()
              .requestMatchers(HttpMethod.PUT, TENANTS_API_URL).permitAll()
              .requestMatchers(HttpMethod.DELETE, TENANTS_API_URL).permitAll()
              .and()
              .authorizeHttpRequests().requestMatchers(HttpMethod.GET, "/**").permitAll()
              .and()
              .authorizeHttpRequests().requestMatchers(HttpMethod.POST, "/**").permitAll()
              .and()
              .authorizeHttpRequests().requestMatchers(HttpMethod.PUT, "/**").permitAll()
              .and()
              .authorizeHttpRequests().requestMatchers(HttpMethod.DELETE, "/**").permitAll()
              .anyRequest().authenticated()
              .and()
              .formLogin()
              .and()
              .httpBasic();

      return httpSecurity.build();
  }

}
