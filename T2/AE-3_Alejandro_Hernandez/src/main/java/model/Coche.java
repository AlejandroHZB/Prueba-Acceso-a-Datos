package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Coche {

    private int id;
    private String marca;
    private String modelo;
    private String color;
    private Pasajero pasajeroAsoc;

    public Coche(String marca, String modelo, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }

    public Coche(String marca, String modelo, String color, Pasajero pasajeroAsoc) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.pasajeroAsoc = pasajeroAsoc;
    }

    public Coche(int id, String marca, String modelo, String color) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
