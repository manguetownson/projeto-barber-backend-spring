package com.api.babercontrol.BarberControl.dtos;

import jakarta.validation.constraints.NotNull;

public record ServicoDTO (@NotNull String nome, @NotNull String colaborador) {
}
