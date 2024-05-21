package com.sparta.omd.service;

import com.sparta.omd.dto.taskRequestDto;
import com.sparta.omd.dto.taskResponseDto;
import com.sparta.omd.entity.password;
import com.sparta.omd.entity.task;
import com.sparta.omd.repository.TaskRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public taskResponseDto createTask(taskRequestDto requestDto){
        // RequestDto -> Entity
        task task = new task(requestDto);
        task savetask = taskRepository.save(task);
        taskResponseDto taskResponseDto = new taskResponseDto(savetask);
        return taskResponseDto;
    }
    public List<taskResponseDto> getAllTasks() {
        return taskRepository.findAllByOrderByModifiedAtDesc().stream().map(taskResponseDto::new).toList();
    }

    public taskResponseDto getTask(Long id){
        task task = findtask(id);
        taskResponseDto taskResponseDto = new taskResponseDto(task);
        return taskResponseDto;
    }

    @Transactional
    public Long updateTask(Long id, taskRequestDto requestDto) {
        task gettask = findtask(id);

        // task update
        gettask.update(requestDto);
        return gettask.getTaskId();
    }

    public Long deleteTask(Long id, password pw) {
        // 해당 메모가 DB에 존재하는지 확인
        task gettask = findtask(id);
        String password = pw.getPassword();
        if (gettask.getPassword().equals(password)){
            // task 삭제
            taskRepository.delete(gettask);
            return gettask.getTaskId();
        }else{
            throw new IllegalArgumentException("PWD does not match");
        }

    }


    private task findtask(Long id){
        return taskRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("선택한 일정은 존재하지 않습니다."));
    }

}
