package com.mindly.mindly.services.taskService;

import com.mindly.mindly.domains.Task;
import com.mindly.mindly.domains.User;
import com.mindly.mindly.dto.request.TaskCreateRequest;
import com.mindly.mindly.repositories.TaskRepository;
import com.mindly.mindly.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateTaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public Task createTask(TaskCreateRequest task) {


        Task taskToSave = Task.builder()
                .titulo(task.titulo())
                .descricao(task.descricao())
                .status(task.status())
                .tempoEstimadoMin(task.tempoEstimadoMin())
                .criadoEm(LocalDateTime.now())
                .build();

        return taskRepository.save(taskToSave);
    }
}
