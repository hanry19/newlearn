package com.team.NewLearn.mapper.community;

import com.team.NewLearn.dto.community.CommunityDTO;
import com.team.NewLearn.dto.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudyBoardMapper {

    // 커뮤니티 스터디 게시판 글 불러오기
    List<CommunityDTO> getStudyBoardList(Criteria cri);


    // 글 상세 조회
    CommunityDTO studyBoardDetail(int id); //게시글 세부내용 보기
    // 글 작성
    int studyBoardInsert(CommunityDTO communityDTO); //게시글 생성
    // 글 수정
    int studyBoardUpdate(CommunityDTO CommunityDTO); //게시글 수정
    // 글 삭제
    int studyBoardDelete(int id); //게시글 삭제

    // 작성된 총 글 수
    int getTotal(Criteria cri);


//    //동적 검색을 위한것
//    List<CommunityDTO> searchTest(Map<String, Map<String, String>> map);



}
