package com.sparta.omd.dto;

import com.sparta.omd.entity.task;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class taskforPrint {
    private Long taskId;
    private String title;
    private String content;
    private String manager;
    private String password;
    private String time;

    public taskforPrint(task t) {
        this.taskId = t.getTaskId();
        this.title = t.getTitle();
        this.content = t.getContent();
        this.manager = t.getManager();
        this.password = t.getPassword();
        this.time = t.getTime().toString().substring(0, 19);
    }

}
