package com.mindly.mindly.domains;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "TAREFA")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User usuario;

    @NotBlank
    @Size(max = 150)
    private String titulo;

    @Size(max = 500)
    private String descricao;

    @NotBlank
    @Column(length = 20)
    private String status; // use enum em versões seguintes

    private Integer tempoEstimadoMin;


    private LocalDateTime criadoEm;
}
