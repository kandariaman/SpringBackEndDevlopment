package com.gfg.jbdll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.naming.NoPermissionException;

@Configuration
public class SecurityConfiguration {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security.csrf().disable().authorizeRequests()
                .requestMatchers(request -> {
                    return "/movie".equals(request.getServletPath()) && HttpMethod.GET.matches(request.getMethod());
                }).hasAuthority("user")
                .requestMatchers(request -> {
                    return "/movie".equals(request.getServletPath()) && HttpMethod.POST.matches(request.getMethod());
                }).hasAuthority("admin")
                .requestMatchers("/movie/**").hasAnyAuthority("user","OAUTH2_USER")
                .requestMatchers("/greet/**").hasAnyAuthority("user","OAUTH2_USER")
                .requestMatchers("/signup/**").permitAll()
                .requestMatchers("**").permitAll()
                .and()
                .formLogin(new Customizer<FormLoginConfigurer<HttpSecurity>>() {
                    @Override
                    public void customize(FormLoginConfigurer<HttpSecurity> httpSecurityFormLoginConfigurer) {

                    }
                }).oauth2Login();

        return security.build();
    }
}
