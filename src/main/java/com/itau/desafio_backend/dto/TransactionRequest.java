package com.itau.desafio_backend.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record TransactionRequest(

        @NotNull
        @Min(0)
        Double valor,

        @NotNull
        @Future
        OffsetDateTime dataHora
) {
}
