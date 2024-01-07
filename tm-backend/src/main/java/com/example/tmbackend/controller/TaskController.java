package com.example.tmbackend.controller;

import com.example.tmbackend.dto.TaskDto;
import com.example.tmbackend.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto)
    {
        TaskDto savedTask=taskService.createTask(taskDto);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable("id") Long taskId)
    {
        TaskDto taskDto=taskService.getTaskById(taskId);
        return ResponseEntity.ok(taskDto);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks()
    {
        List<TaskDto> taskDtos=taskService.getAllTasks();
        return ResponseEntity.ok(taskDtos);
    }

    @PutMapping("{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable("id") Long taskId,@RequestBody TaskDto updatedTask)
    {
        TaskDto taskDto=taskService.updateTask(taskId,updatedTask);
        return ResponseEntity.ok(taskDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long taskId)
    {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok("Task Deleted Successfully");
    }
}
