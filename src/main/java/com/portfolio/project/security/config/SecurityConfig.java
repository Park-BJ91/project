package com.portfolio.project.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.portfolio.project.security.handler.LoginFailHandler;
import com.portfolio.project.security.handler.LoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // @Autowired
    // private AuthenticationEntryPointConfig entryPoint;

    // @Autowired 
    // private AccessDeniedHandlerConfig accessDeniedHandler;

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Autowired
    private LoginFailHandler loginFailHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        /* CSRF CORS 중지 */
        http
            .csrf(csrf -> csrf.disable()).cors(cors -> cors.disable());
        /* 사용자 접근 설정 */
        /* permitAll() Role조건 없이 접근 가능  */ 
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/etc/**","login/**").permitAll()
                .requestMatchers("/admin/**").hasRole("Admin-Role")
                .requestMatchers("/user/**","").hasRole("User-Role")
                .anyRequest().authenticated()
            )
            // .exceptionHandling(excpetionConfig -> 
            //     excpetionConfig.authenticationEntryPoint(entryPoint).accessDeniedHandler(accessDeniedHandler)
            // ) 
            .formLogin(login -> login
                .loginPage("/login/page")                           //Login Path
                .usernameParameter("user_id")               //Form Input name
                .passwordParameter("user_pw")               //Form Input name
                .loginProcessingUrl("/login/post")         //Form Action url
                .successHandler(loginSuccessHandler)                          //Login Sucess Handler
                .failureHandler(loginFailHandler)                             //Login Fail Handler
            )
            /* You can also further customize logout. */
            .logout(logout -> logout
                .logoutUrl("/logout/page")
                .logoutSuccessUrl("/login/page")
            );
 
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web) -> web.ignoring()
            .requestMatchers("/css/**","/js/**");
    }
    
}



