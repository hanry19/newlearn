package com.team.NewLearn.service.mail;


import com.team.NewLearn.dto.member.MemberDTO;
import com.team.NewLearn.mapper.member.MemberMapper;
import com.team.NewLearn.util.MailHandler;
import com.team.NewLearn.util.TempPw;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class MailService {

    private final MemberMapper memberMapper;
    private final JavaMailSender mailSender;
    private static final String FROM_ADDRESS = "qntkstksmstjdwns2@gmail.com";

    public void checkId(MemberDTO memberDTO){

        log.info("::::::  입력 된 id : "+ memberDTO.getEmail() + " 조회 중::::::");

        if(memberMapper.checkId(memberDTO.getEmail()) == null ) {
            log.info("id가 존재하지 않습니다.");

        }else{
           log.info("::::::: 해당 id 임시 비밀번호 발급 ㄱㄱ ::::::::::");
           mailSend(memberDTO);
        }

    }

    public void mailSend(MemberDTO memberDTO) {

        try {
            MailHandler mailHandler = new MailHandler(mailSender);

            // 받는 사람
            mailHandler.setTo(memberDTO.getEmail());
            // 보내는 사람
            mailHandler.setFrom(FROM_ADDRESS);
            // 제목
            mailHandler.setSubject("NewLearn 임시비밀번호 발급 드립니다.");

            // HTML Layout
            String htmlContent = " <img src='cid:sample-img'> <p> 임시 비밀번호는" + tempPw(memberDTO)  + "<p> 입니다 ";
            mailHandler.setText(htmlContent, true);

            // 이미지 삽입
            mailHandler.setInline("sample-img", "static/img/logo.png");

            mailHandler.send();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public String tempPw(MemberDTO memberDTO) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        TempPw tempPw = new TempPw();

        String tempPW =  tempPw.getTempPW(8);

        memberDTO.setPassword(passwordEncoder.encode(tempPW));
        memberMapper.tempPw(memberDTO);

        return tempPW;
    }



}