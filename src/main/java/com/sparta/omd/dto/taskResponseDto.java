package com.sparta.omd.dto;

import com.sparta.omd.entity.task;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class taskResponseDto {
    private Long taskId;
    private String title;
    private String content;
    private String manager;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public taskResponseDto(task t){
        this.taskId = t.getTaskId();
        this.title = t.getTitle();
        this.content = t.getContent();
        this.manager = t.getManager();
        this.password = t.getPassword();
        this.createdAt = t.getCreatedAt();
        this.modifiedAt = t.getModifiedAt();
    }
}
