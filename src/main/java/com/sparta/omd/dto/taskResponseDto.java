package com.sparta.omd.dto;

import com.sparta.omd.entity.task;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class taskResponseDto {
    private Long taskId;
    private String title;
    private String content;
    private String manager;
    private String password;
    private Timestamp time;

    public taskResponseDto(task t){
        this.taskId = t.getTaskId();
        this.title = t.getTitle();
        this.content = t.getContent();
        this.manager = t.getManager();
        this.password = t.getPassword();
        this.time = t.getTime();
    }
}
