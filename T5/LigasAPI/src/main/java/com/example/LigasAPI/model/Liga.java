package com.example.LigasAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter

@Entity
@Table(name = "ligas")
public class Liga implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private String fechaFin;

    public Liga(String nombre) {
        this.nombre = nombre;
    }

    public Liga() {
    }

    public Liga(int id, String nombre, LocalDate fechaInicio, String fechaFin) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
}
