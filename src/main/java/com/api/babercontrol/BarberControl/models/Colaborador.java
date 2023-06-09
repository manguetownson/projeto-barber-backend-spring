package com.api.babercontrol.BarberControl.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Entity
@Table(name="colaborador")
@Getter
@Setter
public class Colaborador extends Usuario {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID idcolaborador;
}
