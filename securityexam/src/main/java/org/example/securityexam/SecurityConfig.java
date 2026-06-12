package org.example.securityexam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
//   1. 기본설정!!  (아무런 설정도 안하면 이렇게 설정됨!!)
//        http
//                .authorizeHttpRequests(auth  -> auth
//                        .anyRequest().authenticated()
//                )
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults())
//                .csrf(Customizer.withDefaults());

//        2.  원하는 설정으로 바꿔 볼까요?
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/","/loginForm","/test/*").permitAll() //인증없이 접근 가능한 페이지 설정
                .anyRequest().authenticated() //나머지 페이지는 모두 인증을 요구하겠다.
        )
                .formLogin(formLogin -> formLogin
                        .loginProcessingUrl("/login_proc")  //기본값은 /login
                        .loginPage("/loginForm") //해당 url을 여러분이 구현해놔야겠죠?
                        .defaultSuccessUrl("/info",true)
                        .usernameParameter("email")
                        .passwordParameter("passwd")
                );




        //.csrf(csrf -> csrf.disable());


        return http.build();
    }
}
