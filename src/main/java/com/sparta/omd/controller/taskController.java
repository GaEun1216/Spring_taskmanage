package com.sparta.omd.controller;


import com.sparta.omd.dto.taskRequestDto;
import com.sparta.omd.dto.taskResponseDto;
import com.sparta.omd.entity.task;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;

@RestController
@RequestMapping("/api")
public class taskController {

    private final Map<Long, task> taskList = new HashMap<>();


    // Step 1 : 등록
    @PostMapping("/tasks")
    public taskResponseDto createTask(@RequestBody taskRequestDto requestDto) {
        task task_new = new task(requestDto);


        // make ID
        Long newId = taskList.size() > 0 ? Collections.max(taskList.keySet()) + 1 : 1;
        // 현재 시간정보 반환
        Timestamp time = new Timestamp(System.currentTimeMillis());
        task_new.setTime(time);
        task_new.setTaskId(newId);


        taskList.put(newId, task_new);

        //Entity -> ResponseDto
        taskResponseDto responseDto = new taskResponseDto(task_new);

        return responseDto;
    }

    // Step 3 : 전체 일정
    @GetMapping("/tasks")
    public List<taskResponseDto> getAllTasks() {
        List<taskResponseDto> responseDtoList = taskList.values().stream().map(taskResponseDto::new).toList();
        return responseDtoList;
    }

    // Step 2 : 선택 일정
    @GetMapping("/tasks/{id}")
    public taskResponseDto getTask(@PathVariable Long id) {
        if(taskList.containsKey(id)) {
            taskResponseDto responseDto = new taskResponseDto(taskList.get(id));
            return responseDto;
        }else{
            throw new IllegalArgumentException("Task with id " + id + " not found");
        }
    }


}
