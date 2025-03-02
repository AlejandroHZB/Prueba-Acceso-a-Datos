import controller.Controller;
import dao.AutorDAO;
import dao.EditorialDAO;
import dao.LibreriaDAO;
import dao.LibroDAO;
import model.Autor;
import model.Editorial;
import model.Libreria;
import model.Libro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Entrada {

    public static void main(String[] args) {

        Controller controller = new Controller();


        // Autor autor1 = new Autor("Brandon","Sanderson","19/12/1975");
        // Autor autor2 = new Autor("Federico","Garcia Lorca","5/06/1898");
        // Autor autor3 = new Autor("George","Orwell","25/06/1903");
        // AutorDAO autorDAO = new AutorDAO();
        // autorDAO.altaAutor(autor1);
        // autorDAO.altaAutor(autor2);
        // autorDAO.altaAutor(autor3);

        // Editorial editorial1 = new Editorial("SCIFI","Calle del pez 12");
        // Editorial editorial2 = new Editorial("CLASICOS","Calle del agua 27");
        // EditorialDAO editorialDAO = new EditorialDAO();
        // editorialDAO.altaEditorial(editorial1);
        // editorialDAO.altaEditorial(editorial2);

        //controller.añadirLibro(new Libro("El archivo de las tormentas", (float)33.50),7,8);
        //controller.añadirLibro(new Libro("El aliento de los dioses", (float)34.50),7,8);
        //controller.añadirLibro(new Libro("Mistborn", (float)32.50),7,8);
        //controller.añadirLibro(new Libro("Elantris", (float)31.50),7,8);
        //controller.añadirLibro(new Libro("La casa de Bernarda Alba", (float)33.50),8,9);
        //controller.añadirLibro(new Libro("Bodas de sangre", (float)33.50),8,9);
        //controller.añadirLibro(new Libro("1984", (float)33.50),8,10);
        //controller.añadirLibro(new Libro("Rebelion en la granja", (float)33.50),8,10);

        //Libreria libreria1 = new Libreria("LIBRERIA CENTRAL","Juan Ortega","Calle del Sol");
        //Libreria libreria2 = new Libreria("LIBRERIA OESTE","Ana Ortega","Calle la Luna");
        //LibreriaDAO libreriaDAO = new LibreriaDAO();
        //libreriaDAO.altaLibreria(libreria1);
        //libreriaDAO.altaLibreria(libreria2);

        //NO SE EN QUE DAO METERLO PARA ACCEDER A LA LISTA DE LIBROS

        // LibroDAO libroDAO = new LibroDAO();
        // List<Libro>libros = libroDAO.ListaLibros();
        // if(libros.size()>=8){
        //     libreria1.setLibrosLibreria(libros.subList(0,4));
        //     libreria2.setLibrosLibreria(libros.subList(4,8));
        // }
        // controller.añadirALibreria(libreria1,libreria1.getLibrosLibreria());
        // controller.añadirALibreria(libreria2,libreria2.getLibrosLibreria());

        //Mostrar todos los libros dados de alta, con su editorial y su autor

        //LibroDAO libroDAO = new LibroDAO();
        //List<Libro> librosAutor = libroDAO.listLibrosAutores();
        //for (Libro libro : librosAutor){
        //    System.out.println(libro.getTitulo());
        //    System.out.println(libro.getAutor().getNombre()+" "+ libro.getAutor().getApellidos());
        //    System.out.println(libro.getEditorial().getNombre());
        //}

        // Mostrar todos los autores dados de alta, con sus libros asociados

        // AutorDAO autorDAO = new AutorDAO();
        // List<Autor>autoresLibros=  autorDAO.listAutoresLibros();
        // for(Autor autor : autoresLibros){
        //     System.out.println(autor.getNombre() + " " + autor.getApellidos() + " Libros: ");
        //     for (Libro libro : autor.getLibrosAutor()){
        //         System.out.println(libro.getTitulo());
        //     }
        // }

        // Mostrar todas las librerías, con solamente sus libros asociados
        // LibreriaDAO libreriaDAO = new LibreriaDAO();
        // List<Libreria> librerias = libreriaDAO.listaLibreriasLibros();
        // for(Libreria libreria : librerias){
        //     System.out.println(libreria.getNombre() + ":");
        //     for (Libro libro : libreria.getLibrosLibreria()){
        //         System.out.println(libro.getTitulo());
        //     }
        // }

        // Mostrar todos los libros dados de alta, y en la librería en la que están.
        // LibroDAO libroDAO = new LibroDAO();
        // List<Libro> libros = libroDAO.listLibrosLibrerias();
        // for(Libro libro : libros){
        //     System.out.println(libro.getTitulo());
        //     for (Libreria libreria : libro.getLibrerias()){
        //         System.out.println(libreria.getNombre());
        //     }
        // }






    }
}
