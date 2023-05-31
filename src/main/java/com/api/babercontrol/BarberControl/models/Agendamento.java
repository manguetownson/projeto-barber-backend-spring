package com.api.babercontrol.BarberControl.models;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="agendamento")
@Getter
@Setter
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long horario;
    private Long data;
    private String servico;
}
