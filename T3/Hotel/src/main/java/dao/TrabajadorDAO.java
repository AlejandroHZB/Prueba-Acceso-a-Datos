package dao;

import database.HibernateUtil;
import model.Habitacion;
import model.Trabajador;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class TrabajadorDAO {
    private Session session;

    public void insertarTrabajador(Trabajador trabajador){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(trabajador);
        session.getTransaction().commit();
        session.close();
    }

    public void seleccionarTodosByProvoincia(String provincia){

        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Trabajador> query = session.createNamedQuery("Trabajador.findAllByProvincia", Trabajador.class);
        query.setParameter("provincia",provincia);
        List<Trabajador> trabajadores = new ArrayList<>();
        for(Trabajador t : trabajadores){
            System.out.println(t);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void insertarTrabajador(Trabajador trabajador,Habitacion habitacion){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        trabajador.setHabitacion(habitacion);
        session.persist(trabajador);
        session.merge(trabajador);
        session.getTransaction().commit();
        session.close();
    }
    public void seleccionHabitacionTrabajador(int id){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Trabajador trabajador = session.get(Trabajador.class,id);
        System.out.println(trabajador.getHabitacion().getNumero());
        session.getTransaction().commit();
        session.close();
    }
}
