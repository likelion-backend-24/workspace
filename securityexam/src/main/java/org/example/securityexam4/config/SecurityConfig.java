package org.example.securityexam4.config;

import lombok.RequiredArgsConstructor;
import org.example.securityexam4.security.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {
    private final CustomUserDetailsService customUserDetailsService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
                .csrf(csrf->csrf.disable());
//        http
//                .authorizeHttpRequests(auth->auth
//                        .anyRequest().permitAll()
//                )
//                .formLogin(Customizer.withDefaults());

        http
                .authorizeHttpRequests(auth->auth
                        .requestMatchers("/login","/register","/","/myinfo").permitAll()
                        .requestMatchers("/welcome").hasRole("USER")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                )
                .formLogin(form->form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/welcome")
                        .permitAll()
                )
                .logout(logout->logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                )
                .userDetailsService(customUserDetailsService);


        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
