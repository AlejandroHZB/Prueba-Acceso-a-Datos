package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pasajero {

    private int id;
    private String nombre;
    private int edad;
    private int peso;
    private Coche cocheAsoc;

    public Pasajero(String nombre, int edad, int peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
    }

    public Pasajero(String nombre, int edad, int peso, Coche cocheAsoc) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.cocheAsoc = cocheAsoc;
    }

    public Pasajero(int id, String nombre, int edad, int peso) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Pasajero{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                '}';
    }
}
