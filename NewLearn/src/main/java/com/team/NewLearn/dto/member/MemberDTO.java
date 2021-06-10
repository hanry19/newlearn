package com.team.NewLearn.dto.member;


import lombok.*;
import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Alias("memberDTO")
public class MemberDTO implements UserDetails {

    private int id;
    private String email;
    private String password;
    private String name;
    private String role;
    private int passwordLock;
    private String regDate;
    private String state;


    /*UserDetails 기본 상속 변수 */
    private Collection<? extends GrantedAuthority> authorities;
    private boolean isEnabled = true;
    private String username;
    private boolean isCredentialsNonExpired = true;
    private boolean isAccountNonExpired = true;
    private boolean isAccountNonLocked = true;




}
