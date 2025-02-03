package org.edu.projektbootsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity //aktiverar webbsäkerhet i applikationen
@Configuration //konfiguration som ska hanteras av spring
public class WebbSecurityConfig {



    @Bean//returnerar en objekt
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // tar emot ett HttpSecurity-objekt som används för att konfigurera säkerheten
        //varje request måste vara att autentiserad
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/admin/**").hasAnyRole("ADMIN", "MANAGER")
                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN", "MANAGER")
                .requestMatchers("/manager/**").hasRole("MANAGER")
                .anyRequest().authenticated()
        ).httpBasic(Customizer.withDefaults());
//form login istället för httpbasic

        return http.build();
    }







    @Bean
    public PasswordEncoder passwordEncoder (){

        return new BCryptPasswordEncoder();
    }
}
