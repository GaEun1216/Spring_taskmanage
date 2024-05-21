package com.sparta.omd.controller;

import com.sparta.omd.dto.taskRequestDto;
import com.sparta.omd.dto.taskResponseDto;
import com.sparta.omd.entity.password;
import com.sparta.omd.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class taskController {
    private final TaskService taskService;

    public taskController(TaskService taskService){
        this.taskService = taskService;
    }

    // Step 1 : 등록
    @PostMapping("/tasks")
    public taskResponseDto createTask(@RequestBody taskRequestDto requestDto) {
        return taskService.createTask(requestDto);
    }

    // Step 3 : 전체 일정
    @GetMapping("/tasks")
    public List<taskResponseDto> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Step 2 : 선택 일정
    @GetMapping("/tasks/{id}")
    public taskResponseDto getTask(@PathVariable Long id) {
        return taskService.getTask(id);
    }

    // Step 4 : 일정 수정
    @PutMapping("/tasks/{id}")
    public Long updateTask(@PathVariable Long id,@RequestBody taskRequestDto requestDto) {
        return taskService.updateTask(id, requestDto);
    }

    // Step 5 : 일정 삭제
    @DeleteMapping("/tasks/{id}")
    public Long deleteTask(@PathVariable Long id,@RequestBody password pw) {
        return taskService.deleteTask(id, pw);
    }

}
