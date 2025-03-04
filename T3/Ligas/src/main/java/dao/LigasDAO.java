package dao;

import database.HibernateUtil;
import model.Liga;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class LigasDAO {

    Session session;

    //OPCIONES :
    //persist -> guarda
    //merge -> actualiza o inserta por id
    //list -> select por id
    //delete -> borra por id

    //namedQuery -> Query -> HQL

    public void crearLiga(Liga liga){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(liga);
        session.getTransaction().commit();
        session.close();
    }

    public Liga getLiga(int idLiga){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Liga liga = session.get(Liga.class,idLiga);
        session.getTransaction().commit();
        session.close();
        return liga;
    }

    public List<Liga> getAllLigas(){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Liga> query = session.createQuery("FROM Liga ", Liga.class);
        List<Liga> ligas = query.list();
        session.getTransaction().commit();
        session.close();
        return ligas;
    }
}
