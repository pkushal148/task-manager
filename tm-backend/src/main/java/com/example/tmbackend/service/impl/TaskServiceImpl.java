package com.example.tmbackend.service.impl;

import com.example.tmbackend.dto.TaskDto;
import com.example.tmbackend.entity.Task;
import com.example.tmbackend.exception.ResourceNotFoundException;
import com.example.tmbackend.mapper.TaskMapper;
import com.example.tmbackend.repository.TaskRepository;
import com.example.tmbackend.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Override
    public TaskDto createTask(TaskDto taskDto) {

        Task task= TaskMapper.mapToTask(taskDto);
        Task savedTask=taskRepository.save(task);

        return TaskMapper.mapToTaskDto(savedTask);
    }

    @Override
    public TaskDto getTaskById(Long id) {

        Task task=taskRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("task not found with id:"+id));
        return TaskMapper.mapToTaskDto(task);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> tasks=taskRepository.findAll();
        return tasks.stream().map((task)->TaskMapper.mapToTaskDto(task))
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto updateTask(Long id, TaskDto updatedTask) {
        Task task=taskRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("task not found with id:"+id)
        );

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setStatus(updatedTask.getStatus());

        Task updated=taskRepository.save(task);
        return TaskMapper.mapToTaskDto(updated);
    }

    @Override
    public void deleteTask(Long taskId) {

        Task task=taskRepository.findById(taskId).orElseThrow(
                ()->new ResourceNotFoundException("task not found with id:"+taskId)
        );

        taskRepository.deleteById(taskId);
    }
}
