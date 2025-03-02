package dao;

import database.HibernateUtil;
import model.Autor;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AutorDAO {

    private Session session;

    public void altaAutor(Autor autor){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(autor);
        session.getTransaction().commit();
        session.close();
    }

    public List<Autor>listAutoresLibros() {
        Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        String hql = "SELECT a FROM Autor a JOIN FETCH a.librosAutor";
        Query<Autor> query = session.createQuery(hql, Autor.class);
        List<Autor> autores = query.getResultList();

        session.getTransaction().commit();
        session.close();

        return autores;
    }
}
