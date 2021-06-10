package com.team.NewLearn.dto.lecture;

import lombok.Data;

@Data
public class AttachFileDTO {

    private int class_id;
    private String fileName;
    private String uuid;
    private boolean image;

}
