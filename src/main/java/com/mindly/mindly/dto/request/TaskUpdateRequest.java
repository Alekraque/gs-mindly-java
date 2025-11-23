package com.mindly.mindly.dto.request;

public record TaskUpdateRequest(
        String titulo,
        String descricao,
        String status,
        Integer tempoEstimadoMin
) {}

