package com.mindly.mindly.controllers;


import com.mindly.mindly.domains.Task;
import com.mindly.mindly.dto.request.TaskCreateRequest;
import com.mindly.mindly.dto.request.TaskUpdateRequest;
import com.mindly.mindly.services.taskService.CreateTaskService;
import com.mindly.mindly.services.taskService.EditTaskService;
import com.mindly.mindly.services.taskService.GetTasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final CreateTaskService taskService;
    private final EditTaskService editTaskService;
    private final GetTasksService getTasksService;

    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@RequestBody TaskCreateRequest task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable String id, @RequestBody TaskUpdateRequest request) {
        return ResponseEntity.ok(editTaskService.updateTask(id, request));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Task>> findAllTasks() {
        return ResponseEntity.ok(getTasksService.getTasks());
    }
}
