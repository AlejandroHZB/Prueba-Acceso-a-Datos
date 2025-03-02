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
@Table(name = "libros")
public class Libro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String titulo;

    @Column
    private float precio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_editorial")
    private Editorial editorial;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_autor")
    private Autor autor;

    @ManyToMany(mappedBy = "librosLibreria")
    private List<Libreria> librerias;

    public Libro(String titulo, float precio, Editorial editorial, Autor autor) {
        this.titulo = titulo;
        this.precio = precio;
        this.editorial = editorial;
        this.autor = autor;
    }

    public Libro(String titulo, float precio) {
        this.titulo = titulo;
        this.precio = precio;
    }
}
