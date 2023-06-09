package com.api.babercontrol.BarberControl.dtos;

import jakarta.validation.constraints.NotNull;

public record ProdutoDTO(@NotNull String nome, @NotNull String fornecedor) {
}
