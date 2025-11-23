package com.mindly.mindly.dto.request;

public record TaskCreateRequest(
        String titulo,
        String descricao,
        String status,
        Integer tempoEstimadoMin
) {}