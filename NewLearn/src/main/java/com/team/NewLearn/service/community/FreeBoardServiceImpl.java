package com.team.NewLearn.service.community;

import com.team.NewLearn.dto.community.CommunityDTO;
import com.team.NewLearn.dto.paging.Criteria;
import com.team.NewLearn.mapper.community.FreeBoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FreeBoardServiceImpl implements FreeBoardService {


    private final FreeBoardMapper freeBoardMapper;


    @Override
    public List<CommunityDTO> getFreeBoardList(Criteria cri) {
        return freeBoardMapper.getFreeBoardList(cri);
    }

    @Override
    public CommunityDTO boardDetail(int id) {
        return freeBoardMapper.freeBoardDetail(id);
    }

    @Override
    public int boardInsert(CommunityDTO communityDTO) {
        return freeBoardMapper.freeBoardInsert(communityDTO);
    }

    @Override
    public int boardUpdate(CommunityDTO CommunityDTO) {
        return freeBoardMapper.freeBoardUpdate(CommunityDTO);
    }

    @Override
    public int boardDelete(int id) {
        return freeBoardMapper.freeBoardDelete(id);
    }

    @Override
    public int getTotal(Criteria cri) {
        return freeBoardMapper.getTotal(cri);
    }
}
