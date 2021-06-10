package com.team.NewLearn.dto.community;

import com.team.NewLearn.dto.member.MemberDTO;
import lombok.*;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Alias("communityDTO")
public class CommunityDTO {

    private int id;
    private String name;
    private String email;
    private String typeName;
    private String title;
    private String content;
    private String regDate;
    private int view;


}
