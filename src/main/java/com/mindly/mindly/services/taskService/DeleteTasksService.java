package com.mindly.mindly.services.taskService;

import com.mindly.mindly.domains.Task;
import com.mindly.mindly.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteTasksService {

    private final TaskRepository taskRepository;

    public void delete(String taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task não encontrada"));
        taskRepository.delete(task);
    }


}
