package dao;

import database.HibernateUtil;
import model.Liga;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
}
