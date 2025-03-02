package dao;

import database.HibernateUtil;
import model.Jugador;
import model.Posicion;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class JugadorDAO {
    private Session session;

    public void crearJugador(Jugador jugador, Posicion posicion){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        jugador.setPosicion(posicion);
        session.merge(jugador);
        session.getTransaction().commit();
        session.close();
    }
    public void actualizarJugador(Jugador jugador){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.merge(jugador);
        session.getTransaction().commit();
        session.close();
    }

    public Jugador obtenerJugador(int id){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Jugador jugador = session.get(Jugador.class,id);
        session.getTransaction().commit();
        session.close();
        return jugador;
    }
    public List<Jugador> obtenerJugadoresNacionalidad(String nacionalidad){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String querySTR = "FROM Jugador j WHERE j.nacionalidad = :nacionalidad";
        Query<Jugador> query = session.createQuery(querySTR, Jugador.class);
        query.setParameter("nacionalidad",nacionalidad);
        List<Jugador> jugadores = query.list();
        session.getTransaction().commit();
        session.close();
        return jugadores;
    }
}
