package com.team.NewLearn.service.community;

import com.team.NewLearn.dto.community.CommunityDTO;
import com.team.NewLearn.dto.paging.Criteria;
import com.team.NewLearn.mapper.community.StudyBoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyBoardServiceImpl implements StudyBoardService {


    private final StudyBoardMapper studyBoardMapper;

    @Override
    public List<CommunityDTO> getStudyBoardList(Criteria cri) {
        return studyBoardMapper.getStudyBoardList(cri);
    }


    @Override
    public CommunityDTO boardDetail(int id) {
        return studyBoardMapper.studyBoardDetail(id);
    }

    @Override
    public int boardInsert(CommunityDTO communityDTO) {
        return studyBoardMapper.studyBoardInsert(communityDTO);
    }

    @Override
    public int boardUpdate(CommunityDTO CommunityDTO) {
        return studyBoardMapper.studyBoardUpdate(CommunityDTO);
    }

    @Override
    public int boardDelete(int id) {
        return studyBoardMapper.studyBoardDelete(id);
    }

    @Override
    public int getTotal(Criteria cri) {
        return studyBoardMapper.getTotal(cri);
    }
}
