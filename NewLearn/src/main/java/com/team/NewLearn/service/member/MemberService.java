package com.team.NewLearn.service.member;

import com.team.NewLearn.dto.member.MemberDTO;
import com.team.NewLearn.dto.paging.Criteria;

import java.util.List;

public interface MemberService {

    // 관리자 : 회원 전체 조회
    List<MemberDTO> selectAllMember(Criteria cri);

    // 회원 : 로그인 해당 계정 정보 조회
    List<MemberDTO> selectMember(String email);

    //전체 글 수량 조회
    int getTotal();

    // 회원 상세 조회
    MemberDTO selectDetailMember(int id);

    //회원 수정
    int memberUpdate(MemberDTO memberDTO);

    // 회원 삭제
    int memberDelete(int id);


    //회원 email로 id 찾기
    int selectMemberId(String email);






}
