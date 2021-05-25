package com.team.NewLearn.mapper.login;

import com.team.NewLearn.dto.login.LoginLogDTO;
import com.team.NewLearn.dto.member.MemberDTO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface LoginMapper {

    // 회원정보조회
    MemberDTO selectMemberInfo(String email);
    //회원가입
    int memberSignUp(MemberDTO member);

    // 비밀번호 틀린 횟수 증가
    int passwordFailCnt(String email) ;
    // 비밀번호 틀린 횟수 초기화
    int resetPasswordFailCnt(String email) ;
    // 로그인 로그
    int AddLoginLog(LoginLogDTO loginLogDTO) ;

    int checkPassLock(String email);




}
