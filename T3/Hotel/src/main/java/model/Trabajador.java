package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "empleados")
public class Trabajador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private String apellidos;
    @Embedded
    private Direccion direccion;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "localidad",column = @Column(name = "localidad_2")),
            @AttributeOverride(name = "provincia",column = @Column(name = "provincia_2"))
    })
    private Direccion direccion2;
    @Column
    private int telefono;

    public Trabajador(String nombre, String apellidos, Direccion direccion, Direccion direccion2, int telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.direccion2 = direccion2;
        this.telefono = telefono;
    }
}


