package com.api.babercontrol.BarberControl.models;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;


@Entity
@Table(name="agendamento")
@Getter
@Setter
public class Agendamento implements Serializable {
    private static final long serialVersionUID = 1l;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_agendamento;
    private Long horario;
    private Long data;
    private String servico;
}
