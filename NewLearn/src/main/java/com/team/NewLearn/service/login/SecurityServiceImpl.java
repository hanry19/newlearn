package com.team.NewLearn.service.login;

import com.team.NewLearn.dto.login.LoginLogDTO;
import com.team.NewLearn.dto.member.MemberDTO;
import com.team.NewLearn.dto.paging.Criteria;
import com.team.NewLearn.mapper.login.LoginMapper;
import com.team.NewLearn.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private final MemberMapper boardMemberMapper;
    private final LoginMapper loginMapper;

    @Override
    public List<MemberDTO> selectAllMember(Criteria cri) {
        log.info("여기는 select all member 서비스 단!!!! ");
        return boardMemberMapper.selectAllMember(cri);

    }

    @Override
    public int getTotal() {
        log.info("여기는 get total 서비스 단!!!! ");
        return boardMemberMapper.getTotal();
    }

    @Override
    public int checkPassLock(String email) throws DisabledException {
        log.info("비밀번호 틀린 횟수 조회 중");

        return loginMapper.checkPassLock(email);
    }

    // 시큐리티 사용자 인증
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("::::::::::: 사용자 인증 ::::::::::::::::::");

        MemberDTO member = loginMapper.selectMemberInfo(email);
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (member != null) {
            authorities.add(new SimpleGrantedAuthority(member.getRole()));
            member.setAuthorities(authorities);

        }
        System.out.println("member = " + member);
        System.out.println("authorities = " + authorities);
        return member;
    }


    @Override
    public int memberSignUp(MemberDTO memberDTO) throws Exception {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDTO.setPassword(passwordEncoder.encode(memberDTO.getPassword()));
        log.info(":::::::::::회원가입 서비스 단 ::::::::::::::::::");

        return loginMapper.memberSignUp(memberDTO);
    }



    @Override
    public MemberDTO selectMemberInfo(String email) {
        return loginMapper.selectMemberInfo(email);
    }

    @Override
    public MemberDTO memberIdCheck(String email) throws Exception {
        return loginMapper.selectMemberInfo(email);
    }

    @Override
    public int passwordFailCnt(String email) throws Exception {
        return loginMapper.passwordFailCnt(email);
    }

    @Override
    public int resetPasswordFailCnt(String email) throws Exception {
        return loginMapper.resetPasswordFailCnt(email);
    }

    @Override
    public int AddLoginLog(LoginLogDTO loginLogDTO) throws Exception {
        return loginMapper.AddLoginLog(loginLogDTO);
    }

}
