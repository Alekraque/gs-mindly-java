package com.mindly.mindly.domains;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "SESSAO_FOCO")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FocusSection {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User usuario;

    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    private Integer pausasRealizadas;

    private LocalDateTime criadoEm;
}
