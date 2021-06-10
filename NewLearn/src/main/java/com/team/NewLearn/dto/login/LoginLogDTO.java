package com.team.NewLearn.dto.login;

import com.team.NewLearn.dto.member.MemberDTO;
import lombok.Data;

@Data
public class LoginLogDTO extends MemberDTO {

    private String loginIp;
    private String loginDate;


}
