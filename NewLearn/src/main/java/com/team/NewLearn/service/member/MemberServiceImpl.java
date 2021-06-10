package com.team.NewLearn.service.member;

import com.team.NewLearn.dto.member.MemberDTO;
import com.team.NewLearn.dto.paging.Criteria;
import com.team.NewLearn.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper boardMemberMapper;

    @Override
    public List<MemberDTO> selectAllMember(Criteria cri) {
        log.info("[관리자 / 서비스] 정보 조회");
        return boardMemberMapper.selectAllMember(cri);
    }

    @Override
    public List<MemberDTO> selectMember(String email) {
        log.info("[회원 / 서비스] 회원정보 " + email +" 정보 조회 ");
        return boardMemberMapper.selectMember(email);
    }

    @Override
    public int getTotal() {
        log.info("여기는 get total 서비스 단!!!! ");
        return boardMemberMapper.getTotal();
    }

    @Override
    public MemberDTO selectDetailMember(int id) {
        log.info("여기는 select detail member  서비스 단!!!");
        return boardMemberMapper.selectDetailMember(id);
    }

    @Override
    public int memberUpdate(MemberDTO memberDTO) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if(memberDTO.getPassword().equals("")){
            memberDTO.setPassword("");
            log.info("::::::: 비밀번호 수정은 없다 :::::");
            return boardMemberMapper.memberUpdate(memberDTO);
        }else{
            memberDTO.setPassword(passwordEncoder.encode(memberDTO.getPassword()));
            log.info("::::::: 비밀번호 수정한다 :::::");
            return boardMemberMapper.memberUpdate(memberDTO);

        }
    }

    @Override
    public int memberDelete(int id) {
        log.info("여기는 memberDelete  서비스 단!!!! ");
        return boardMemberMapper.memberDelete(id);
    }

    @Override
    public int selectMemberId(String email) {
        log.info("여기는 selectIdMember  서비스 단!!!! ");
        return boardMemberMapper.selectMemberId(email);
    }

}
