package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
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
    @Column
    private Date fecha_inicio;
    @Column
    private Date fecha_fin;
    
    @OneToMany(mappedBy = "liga",fetch = FetchType.EAGER)
    private List<Equipo> equipos;

    public Liga(String nombre) {
        this.nombre = nombre;
    }

    public Liga(String nombre, Date fecha_inicio, Date fecha_fin) {
        this.nombre = nombre;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }
}
