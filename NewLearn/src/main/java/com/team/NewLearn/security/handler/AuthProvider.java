package com.team.NewLearn.security.handler;

import com.team.NewLearn.dto.member.MemberDTO;
import com.team.NewLearn.service.login.SecurityService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class AuthProvider implements AuthenticationProvider {

    private static final Logger logger = LoggerFactory.getLogger(AuthSuccessHandler.class);

    private final SecurityService securityServiceMapper;

    //로그인 버튼을 누를 경우
    //실행 1

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        return authenticate(email, password);
    }
    //실행 2
    private Authentication authenticate (String email, String password) throws  AuthenticationException {


        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        MemberDTO member = new MemberDTO();

        member = (MemberDTO) securityServiceMapper.loadUserByUsername(email);


        if (member == null) {
            logger.info("::::::::: 회원정보 없다!!!::::::::");
            throw new UsernameNotFoundException(email);
        } else if (member != null && !passwordEncoder.matches(password, member.getPassword())) {
            logger.info(":::::: 비번 틀렷다 ::::::");
            throw new BadCredentialsException(email);
        } else if (member.getPasswordLock() > 5) {
            logger.info("::::: 계정 잠김 ㅅㄱ :::::::::");
            throw new DisabledException(email);
        }

        grantedAuthorities.add(new SimpleGrantedAuthority(member.getRole()));


        return new MyAuthentication(email, password, grantedAuthorities, member);

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
