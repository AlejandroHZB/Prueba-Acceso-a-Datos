package dao;

import database.HibernateUtil;
import model.Trabajador;
import org.hibernate.Session;

public class TrabajadorDAO {
    private Session session;

    public void insertarTrabajador(Trabajador trabajador){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(trabajador);
        session.getTransaction().commit();
        session.close();
    }
}
