package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "librerias")
public class Libreria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;

    @Column
    private String nombre_dueño;

    @Column
    private String direccion;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "libros_librerias",joinColumns = @JoinColumn(name = "id_libreria"),inverseJoinColumns = @JoinColumn(name = "id_libro"))
    private List<Libro> librosLibreria;

    public Libreria(String nombre, String nombre_dueño, String direccion, List<Libro> libros) {
        this.nombre = nombre;
        this.nombre_dueño = nombre_dueño;
        this.direccion = direccion;
        this.librosLibreria= libros;
    }

    public Libreria(String nombre, String nombre_dueño, String direccion) {
        this.nombre = nombre;
        this.nombre_dueño = nombre_dueño;
        this.direccion = direccion;
    }
}
