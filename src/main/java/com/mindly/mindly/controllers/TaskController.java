package com.mindly.mindly.controllers;


import com.mindly.mindly.domains.Task;
import com.mindly.mindly.dto.request.TaskCreateRequest;
import com.mindly.mindly.dto.request.TaskUpdateRequest;
import com.mindly.mindly.services.taskService.CreateTaskService;
import com.mindly.mindly.services.taskService.EditTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final CreateTaskService taskService;
    private final EditTaskService editTaskService;

    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@RequestBody TaskCreateRequest task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable String id, @RequestBody TaskUpdateRequest request) {
        return ResponseEntity.ok(editTaskService.updateTask(id, request));
    }
}
