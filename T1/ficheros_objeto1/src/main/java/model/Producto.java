package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Producto implements Serializable {

    private static final long serialVersionUID= 1234L;
    private int id;
    private String title;
    private double price;
    private int stock;

    public Producto(int id, String title, double price, int stock) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.stock = stock;
    }

    public Producto(String title, double price, int stock) {
        this.title = title;
        this.price = price;
        this.stock = stock;
    }
    public void mostrarDatos(){
        System.out.println("serialVersionUID = " + serialVersionUID);
        System.out.println("id = " + id);
        System.out.println("title = " + title);
        System.out.println("price = " + price);
        System.out.println("stock = " + stock);
    }
}
