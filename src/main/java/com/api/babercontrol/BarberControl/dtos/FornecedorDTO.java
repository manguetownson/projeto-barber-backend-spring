package com.api.babercontrol.BarberControl.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FornecedorDTO(@NotBlank String nome, @NotBlank String produto, @NotNull Long id) {
}
