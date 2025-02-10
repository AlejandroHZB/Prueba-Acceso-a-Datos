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
 @Table(name = "equipos")
public class Equipo implements Serializable {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     @Column
     private String nombre;
     @Column
     private String ciudad;

     @OneToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "id_entrenador")
     private Entrenador entrenador;

     @OneToMany(mappedBy = "equipo")
     private List<Jugador> jugadores;

     @ManyToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "id_liga")
     private Liga liga;

     public Equipo(String nombre, String ciudad) {
         this.nombre = nombre;
         this.ciudad = ciudad;
     }
 }
