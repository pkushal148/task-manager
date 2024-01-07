package com.example.tmbackend.service;

import com.example.tmbackend.dto.TaskDto;
import com.example.tmbackend.entity.Task;

import java.util.List;

public interface TaskService {
    TaskDto createTask(TaskDto taskDto);

    TaskDto getTaskById(Long id);

    List<TaskDto> getAllTasks();

    TaskDto updateTask(Long id,TaskDto updatedTask);

    void deleteTask(Long taskId);
}
