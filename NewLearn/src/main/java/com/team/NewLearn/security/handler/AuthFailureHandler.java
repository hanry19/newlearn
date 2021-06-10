package com.team.NewLearn.security.handler;

import com.team.NewLearn.dto.login.LoginLogDTO;
import com.team.NewLearn.dto.member.MemberDTO;
import com.team.NewLearn.service.login.SecurityService;
import com.team.NewLearn.util.CommonUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AuthFailureHandler implements AuthenticationFailureHandler {

    private final SecurityService securityService;

    private static final Logger logger = LoggerFactory.getLogger(AuthFailureHandler.class);


    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        MemberDTO memberDTO = new MemberDTO();

        String ip = CommonUtil.getClientIp(request);
        logger.info("::::::::: login fail ::::::::::");
        logger.info("@@@ 로그인 실패 아이피  "+ip);
        LoginLogDTO loginLogDTO = new LoginLogDTO();
        String email = "";
        String msg = "";
        System.out.println(memberDTO.getPasswordLock());

        try {
            email = exception.getMessage();

            if (memberDTO.getPasswordLock() > 5){
                msg = "account lock";

            } else if (securityService.selectMemberInfo(email) != null) {
                securityService.passwordFailCnt(email);

                loginLogDTO.setLoginIp(ip);
                loginLogDTO.setEmail(email);
                loginLogDTO.setState("failure");
                securityService.AddLoginLog(loginLogDTO);
                msg = "password miss matching";
            }  else{
                msg = "can not found E-mail";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/login?msg=" + msg);

    }

}
