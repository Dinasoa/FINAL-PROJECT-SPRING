package com.example.project.security;


import com.example.project.security.model.Role;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
@Slf4j

public class SecurityConf extends WebSecurityConfigurerAdapter {

    private CustomAuthenticationProvider authProvider;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers(HttpMethod.GET,"/").permitAll()
                .antMatchers(HttpMethod.GET, "/scholarships").permitAll()
                .antMatchers(HttpMethod.POST, "/scholarships").permitAll()
                .antMatchers(HttpMethod.GET , "/scholarships/univ").permitAll()
                .antMatchers(HttpMethod.GET,"/scholarships/country").permitAll()
                .antMatchers(HttpMethod.DELETE,"/scholarships/**").permitAll()
                .antMatchers(HttpMethod.PUT,"/scholarships/{id_scholarship}").permitAll()
                .antMatchers(HttpMethod.POST , "/scholarships/postCriteriaInScholarship/{id_scholarship}").permitAll()
                .antMatchers(HttpMethod.GET , "/scholarships/id").permitAll()
                .antMatchers(HttpMethod.GET , "/applicants").permitAll()
                .antMatchers(HttpMethod.POST , "/applicants/create").permitAll()
                .antMatchers(HttpMethod.PUT, "/applicants/update").permitAll()
                .antMatchers(HttpMethod.DELETE , "/delete/applicants/{id}").permitAll()
                .antMatchers(HttpMethod.GET , "criterias").permitAll()
                .antMatchers(HttpMethod.GET , "criteria/{id_criteria}").permitAll()
                .antMatchers(HttpMethod.POST , "criterias").permitAll()
                .antMatchers(HttpMethod.POST , "criterias").permitAll()
                .antMatchers(HttpMethod.DELETE , "/criteria/{id_criteria}").permitAll()
                .antMatchers(HttpMethod.PUT , "/criteria/{id_criteria}").permitAll()
                .and()
                .cors()
                .and()
                .formLogin().disable()
                .logout().disable()
                .csrf().disable()
                .httpBasic();
    }
}
