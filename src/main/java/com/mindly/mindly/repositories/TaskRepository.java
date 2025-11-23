package com.mindly.mindly.repositories;


import com.mindly.mindly.domains.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TaskRepository extends JpaRepository<Task, String>, JpaSpecificationExecutor<Task> {
    Page<Task> findByUsuarioId(Long usuarioId, Pageable pageable);

}