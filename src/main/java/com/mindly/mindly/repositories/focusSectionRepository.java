package com.mindly.mindly.repositories;


import com.mindly.mindly.domains.FocusSection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface focusSectionRepository extends JpaRepository<FocusSection, Long>, JpaSpecificationExecutor<FocusSection> {
    Page<FocusSection> findByUsuarioId(Long usuarioId, Pageable pageable);
}