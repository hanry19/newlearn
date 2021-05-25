package com.team.NewLearn;

import com.team.NewLearn.dto.member.MemberDTO;
import com.team.NewLearn.service.mail.MailService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class test {

    @Autowired
    MailService mailService;

    @Test
    @DisplayName("test for checking ID")
    public void test1(){

        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setEmail("asdasd");
        mailService.checkId(memberDTO);




    }
}
