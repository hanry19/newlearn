package com.team.NewLearn.security.handler;

import com.team.NewLearn.dto.login.LoginLogDTO;
import com.team.NewLearn.service.login.SecurityService;
import com.team.NewLearn.util.CommonUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
@RequiredArgsConstructor
public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(AuthSuccessHandler.class);

    private final SecurityService securityServiceMapper;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {




        String ip = CommonUtil.getClientIp(request);

        logger.info("# AuthSuccessHandler 3번"+ip);
        logger.info("로그인 아이피  "+ip);
        logger.info("::::::::::::::: 로그인 성공 !!! ::::::::::::::::");
        LoginLogDTO loginLogDTO = new LoginLogDTO();
        String email = "";

        try {
            email = authentication.getName().toString();
            String getDetails = authentication.getDetails().toString();
            String getAuthorities = authentication.getAuthorities().toString();
            String s = authentication.getPrincipal().toString();

            System.out.println("email = " + email);
            System.out.println("a = " + getDetails);
            System.out.println("b = " + getAuthorities);
            System.out.println("s = " + s);

            securityServiceMapper.resetPasswordFailCnt(email);

            loginLogDTO.setLoginIp(ip);
            loginLogDTO.setEmail(email);
            loginLogDTO.setState("success");
            securityServiceMapper.AddLoginLog(loginLogDTO);

        } catch (Exception e) {
            e.printStackTrace();
        }

        super.setDefaultTargetUrl("/main");
        super.onAuthenticationSuccess(request, response, authentication);


    }
}
