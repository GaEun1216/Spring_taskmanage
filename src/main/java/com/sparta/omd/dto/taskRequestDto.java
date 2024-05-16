package com.sparta.omd.dto;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class taskRequestDto {
    private String title;
    private String content;
    private String manager;
    private String password;

}
