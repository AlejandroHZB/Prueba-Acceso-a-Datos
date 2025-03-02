package dao;

import database.HibernateUtil;
import model.Autor;
import model.Editorial;
import model.Libro;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LibroDAO {

    private Session session;

    public void altaLibro(Libro libro, Editorial editorial, Autor autor){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        libro.setEditorial(editorial);
        libro.setAutor(autor);
        session.merge(libro);
        session.getTransaction().commit();
        session.close();
    }

    public List<Libro>listLibrosAutores() {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String query = "SELECT l FROM Libro l JOIN FETCH l.autor JOIN FETCH l.editorial";
        Query<Libro> querys = session.createQuery(query, Libro.class);
        List<Libro> libros = querys.getResultList();
        session.getTransaction().commit();
        session.close();

        return libros;
    }

    public List<Libro>listLibrosLibrerias() {
        Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "SELECT l FROM Libro l JOIN FETCH l.librerias";
        Query<Libro> query = session.createQuery(hql, Libro.class);
        List<Libro> librosL = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return librosL;
    }

    public List<Libro> ListaLibros() {
        Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Libro> query = session.createQuery("FROM Libro", Libro.class);
        List<Libro> libros = query.list();
        session.getTransaction().commit();
        return libros;
    }
}
