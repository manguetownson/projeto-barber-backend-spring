package com.api.babercontrol.BarberControl.dtos;


//public record AgendamentoDTO(@NotBlank Long horario, @NotBlank Long data, @NotNull String servico) {
//}

import jakarta.validation.constraints.NotNull;

public record AgendamentoDTO(@NotNull Long horario, @NotNull Long data, @NotNull String servico) {
}