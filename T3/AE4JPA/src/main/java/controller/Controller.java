package controller;

import dao.AutorDAO;
import dao.EditorialDAO;
import dao.LibreriaDAO;
import dao.LibroDAO;
import database.HibernateUtil;
import model.Autor;
import model.Editorial;
import model.Libreria;
import model.Libro;
import org.hibernate.Session;

import java.util.List;

public class Controller {

    private AutorDAO autorDAO;
    private LibroDAO libroDAO;
    private EditorialDAO editorialDAO;
    private LibreriaDAO libreriaDao;

    public Controller() {
        autorDAO = new AutorDAO();
        editorialDAO = new EditorialDAO();
        libreriaDao = new LibreriaDAO();
        libroDAO = new LibroDAO();
    }

    public void añadirLibro(Libro libro, int idEditorial,int idAutor){
        Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Editorial editorial = session.get(Editorial.class, idEditorial);
        Autor autor = session.get(Autor.class, idAutor);
        session.getTransaction().commit();
        session.close();
        libroDAO.altaLibro(libro,editorial, autor);
    }

    public void añadirALibreria(Libreria libreria, List<Libro> libros) {
        Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        libreria.setLibrosLibreria(libros);
        session.save(libreria);
        session.getTransaction().commit();
        session.close();
    }
}
