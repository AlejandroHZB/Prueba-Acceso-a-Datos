package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
public class Coche {

    private int id;
    private String matricula;
    private String marca;
    private String modelo;
    private String color;

    public Coche(int id, String matricula, String marca, String modelo, String color) {
        this.id = id;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }

    public void mostrarCoches(){
        System.out.println(coches);
    }

    public void añadirCoche(Coche coche){

       coches.add(coche);
        System.out.println("coche añadido con exito");

    }

    public void borrarCoche(int id){

        Coche c1 = new Coche();
        if(c1.id==id){
            coches.remove(c1);
            System.out.println("Coche borrado con exito");
        }
        else {
            System.out.println("Identificador no valido");
        }


        }
    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
    }







