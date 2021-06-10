package com.team.NewLearn.mapper.member;

import com.team.NewLearn.dto.member.MemberDTO;
import com.team.NewLearn.dto.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {


    // 관리자 : 회원 전체 조회
    List<MemberDTO> selectAllMember(Criteria cri);

    // 회원 : 로그인 해당 계정 정보 조회
    List<MemberDTO> selectMember(String email);

    //전체 글 갯수 조회
    int getTotal();
    // 회원 상세 조회
    MemberDTO selectDetailMember(int id);

    //회원 수정
    int memberUpdate(MemberDTO memberDTO);

    // 회원 삭제
    int memberDelete(int id);
    // 동적검색
    List<MemberDTO> searchMember(Map<String, Map<String, String>> map);

    //회원 id email로 찾기
    int selectMemberId(String email);

    // 임시 비번
    int tempPw(MemberDTO memberDTO);

    //아이디 존재여부
    String checkId(String email);



}
