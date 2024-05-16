package com.sparta.omd.controller;


import com.sparta.omd.dto.taskRequestDto;
import com.sparta.omd.dto.taskResponseDto;
import com.sparta.omd.entity.task;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class taskController {

    private final Map<Timestamp, task> taskList = new HashMap<>();


    @PostMapping("/tasks")
    public taskResponseDto createTask(@RequestBody taskRequestDto requestDto) {
        task task_new = new task(requestDto);

        // 현재 시간정보 반환
        Timestamp time = new Timestamp(System.currentTimeMillis());

        task_new.setTime(time);
        taskList.put(time, task_new);

        //Entity -> ResponseDto
        taskResponseDto responseDto = new taskResponseDto(task_new);

        return responseDto;
    }


}
