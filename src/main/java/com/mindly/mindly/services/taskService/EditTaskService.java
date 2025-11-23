package com.mindly.mindly.services.taskService;

import com.mindly.mindly.domains.Task;
import com.mindly.mindly.domains.User;
import com.mindly.mindly.dto.request.TaskUpdateRequest;
import com.mindly.mindly.repositories.TaskRepository;
import com.mindly.mindly.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditTaskService {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public Task updateTask(String taskId, TaskUpdateRequest taskRequest) {

        // Usuário autenticado via token
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User usuario = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));


        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        // ve se a task eh do usuario logado
        if (!task.getUsuario().getId().equals(usuario.getId())) {
            throw new RuntimeException("Você não tem permissão para editar esta tarefa");
        }

//        // atualiza só os campos enviados
//        if (request.titulo() != null) {
//            task.setTitulo(request.titulo());
//        }
//        if (request.descricao() != null) {
//            task.setDescricao(request.descricao());
//        }
//        if (request.status() != null) {
//            task.setStatus(request.status());
//        }
//        if (request.tempoEstimadoMin() != null) {
//            task.setTempoEstimadoMin(request.tempoEstimadoMin());
//        }

        return taskRepository.save(task);
    }
}
