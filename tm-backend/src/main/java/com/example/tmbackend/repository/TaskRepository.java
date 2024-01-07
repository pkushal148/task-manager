package com.example.tmbackend.repository;

import com.example.tmbackend.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task,Long> {
}
