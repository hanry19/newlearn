package com.team.NewLearn.security.handler;

import com.team.NewLearn.dto.member.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

//현재 로그인한 사용자 객체 저장 DTO

public class MyAuthentication extends UsernamePasswordAuthenticationToken {

    private static final long serialVersionUID = 1L;
    private static Logger logger = LoggerFactory.getLogger(MyAuthentication.class);


    MemberDTO memberDTO;



    public MyAuthentication(String email, String password,
                            List<GrantedAuthority> grantedAuthorityList,
                            MemberDTO member) {
        super(email, password, grantedAuthorityList);

        this.memberDTO = member;

    }
}
