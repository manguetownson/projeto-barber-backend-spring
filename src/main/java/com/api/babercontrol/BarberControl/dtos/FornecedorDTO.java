package com.api.babercontrol.BarberControl.dtos;

import jakarta.validation.constraints.NotNull;

public record FornecedorDTO(@NotNull String nome, @NotNull String produto) {
}
