package com.api.babercontrol.BarberControl.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="cliente")
@Getter
@Setter
public class Cliente extends Usuario {

}
