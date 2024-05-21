package com.sparta.omd;

import com.sparta.omd.entity.task;
import com.sparta.omd.repository.TaskRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.config.Task;

@SpringBootTest
public class TransactionTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    TaskRepository taskRepository;
    @Test
    @DisplayName("예제 1")
    void test1(){
        task task = new task();
        task.setTitle("제발돼라");
        task.setContent("내용내용내용");
        task.setManager("이가은");
        task.setPassword("0000");
        em.persist(task);
    }
}
