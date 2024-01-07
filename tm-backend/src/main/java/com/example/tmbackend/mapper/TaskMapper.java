package com.example.tmbackend.mapper;

import com.example.tmbackend.dto.TaskDto;
import com.example.tmbackend.entity.Task;

public class TaskMapper {

    public static TaskDto mapToTaskDto(Task task)
    {
        return new TaskDto(task.getId(), task.getTitle(), task.getDescription(), task.getStatus());
    }


    public static Task mapToTask(TaskDto taskDto)
    {
        return new Task(taskDto.getId(),taskDto.getTitle(),taskDto.getDescription(),taskDto.getStatus());
    }
}
