package com.gfg.jbdll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.naming.NoPermissionException;

@Configuration
public class SecurityConfiguration {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security.authorizeRequests()
                .requestMatchers("/admin/greet/**")
                .hasAuthority("admin")
                .requestMatchers("/greet/**").hasAuthority("user")
                .and().httpBasic(new Customizer<HttpBasicConfigurer<HttpSecurity>>() {
                    @Override
                    public void customize(HttpBasicConfigurer<HttpSecurity> httpSecurityHttpBasicConfigurer) {

                    }
                });

        return security.build();
    }
}
