package com.team.NewLearn.dto.mail;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MailDTO {
    private String address;
    private String title;
    private String message;
}