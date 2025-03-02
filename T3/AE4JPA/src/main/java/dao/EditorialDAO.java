package dao;

import database.HibernateUtil;
import model.Editorial;
import model.Libro;
import org.hibernate.Session;

public class EditorialDAO {

    private Session session;

    public void altaEditorial(Editorial editorial){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(editorial);
        session.getTransaction().commit();
        session.close();
    }
}
