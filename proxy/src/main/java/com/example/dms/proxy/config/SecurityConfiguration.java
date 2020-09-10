package com.example.dms.proxy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests((authorizeRequests) ->
//                authorizeRequests.antMatchers(HttpMethod.POST, "/oauth/**").permitAll()
//                        .antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
//                        .anyRequest().authenticated()
//        ).oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/oauth/**").permitAll()
                .antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
                .anyRequest().authenticated();
    }
}
