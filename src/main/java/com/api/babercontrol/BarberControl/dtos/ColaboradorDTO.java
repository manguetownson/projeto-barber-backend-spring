package com.api.babercontrol.BarberControl.dtos;

import jakarta.validation.constraints.NotNull;

public record ColaboradorDTO(@NotNull String username,
                             @NotNull String password,
                             @NotNull String firstname,
                             @NotNull String lastname,
                             @NotNull String email) {
}
