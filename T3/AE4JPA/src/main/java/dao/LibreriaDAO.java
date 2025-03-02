package dao;

import database.HibernateUtil;
import model.Libreria;
import model.Libro;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LibreriaDAO {

    private Session session;

    public void altaLibreria(Libreria libreria) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(libreria);
        session.getTransaction().commit();
        session.close();
    }

    public List<Libreria> listaLibreriasLibros() {
        Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String query = "SELECT l FROM Libreria l JOIN FETCH l.librosLibreria";
        Query<Libreria> querys = session.createQuery(query, Libreria.class);
        List<Libreria> librerias = querys.getResultList();
        session.getTransaction().commit();
        session.close();

        return librerias;
    }
}