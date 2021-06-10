package com.team.NewLearn.security.config;

import com.team.NewLearn.security.handler.AuthFailureHandler;
import com.team.NewLearn.security.handler.AuthSuccessHandler;
import com.team.NewLearn.service.login.SecurityServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final DataSource dataSource;
    private final AuthSuccessHandler authSuccessHandler;
    private final AuthFailureHandler authFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private SecurityServiceImpl securityService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/user/**").access("hasRole('ROLE_USER')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")

                .antMatchers("/mypage/**").access("hasRole('ROLE_USER')or hasRole('ROLE_ADMIN')")

                .antMatchers("/main",
                        "/login",
                        "/sign-Up",
                        "/pwFind",
                        "/login/**",
                        "/reply/**",
                        "/community/**",
                        "/main",
                        "/pwFind",
                        "/css/**","/js/**","/img/**","/plugin/**","/vendor/**",
                        "/logout"

                ).permitAll()

                //기타 /** 의 경로는 인증을 필요로 한다
                .antMatchers("/**").authenticated();



        http.formLogin()
                // 로그인 후 보여줄 페이지
                .loginPage("/login")
                // 로그인 버튼 눌릴 시 진행될 프로세스 연결
                .loginProcessingUrl("/login-process")
                .usernameParameter("email")    //input name 파라미터로 "email"를 받는다.
                .passwordParameter("password") //input name 파라미터로 "password"를 받는다.
                .failureHandler(authFailureHandler) //로그인 실패시 수행하는 클래스
                .successHandler(authSuccessHandler);// 로그인 성공시 수행하는 클래스



        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")  // 이 경로로 리다이렉트 하고
                .invalidateHttpSession(true);   // 세션 초기화

    }


}
