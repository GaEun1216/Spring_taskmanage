package com.sparta.omd.repository;

import com.sparta.omd.entity.task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<task, Long> {
    List<task> findAllByOrderByModifiedAtDesc();
}
