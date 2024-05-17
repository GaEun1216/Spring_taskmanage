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

    // Step 4 : 일정 수정
    @PutMapping("/tasks/{id}")
    public Long updateTask(@PathVariable Long id,@RequestBody taskRequestDto requestDto) {
        if(taskList.containsKey(id)) {
            task gettask = taskList.get(id);
            if (gettask.getPassword().equals(requestDto.getPassword())){

                // task update
                gettask.update(requestDto);
                Timestamp time = new Timestamp(System.currentTimeMillis());
                gettask.setTime(time);
                return gettask.getTaskId();
            }else{
                throw new IllegalArgumentException("PWD does not match");
            }
        }else{
            throw new IllegalArgumentException("Task with id " + id + " not found");
        }
    }

    // Step 5 : 일정 삭제
    @DeleteMapping("/tasks/{id}")
    public Long deleteTask(@PathVariable Long id,@RequestBody Map<String,String> pw) {
        if(taskList.containsKey(id)) {
            task gettask = taskList.get(id);
            if (gettask.getPassword().equals(pw.get("pw"))){

                // remove task
                taskList.remove(id);
                return gettask.getTaskId();
            }else{
                throw new IllegalArgumentException("PWD does not match");
            }

        }else{
            throw new IllegalArgumentException("Task with id " + id + " not found");
        }
    }

}
