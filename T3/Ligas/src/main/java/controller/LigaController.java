package controller;

import dao.*;
import database.HibernateUtil;
import model.*;
import org.hibernate.Session;

import java.util.List;

public class LigaController {

       private EntrenadorDAO entrenadorDAO;
       private EquipoDAO equipoDAO;
       private LigasDAO ligasDAO;
       private JugadorDAO jugadorDAO;
       private CompeticionDAO competicionDAO;

       public LigaController(){
           entrenadorDAO = new EntrenadorDAO();
           equipoDAO = new EquipoDAO();
           ligasDAO = new LigasDAO();
           jugadorDAO = new JugadorDAO();
           competicionDAO = new CompeticionDAO();
       }

       public void agregarEntrenador(Entrenador entrenador){
           if(entrenador.getCalificacion()<10){
               System.out.println("No vale para este equipo");
           }else {
               entrenadorDAO.agregarEntrenador(entrenador);
           }
       }

        public void contratarEntrenador(int idEntrenador, int idEquipo){
           Entrenador entrenador = entrenadorDAO.obtenerEntrenador(idEntrenador);
           if(entrenador.getTitulos()>4){
               Equipo equipo = equipoDAO.getEquipo(idEquipo);
               equipo.setEntrenador(entrenador);
               equipoDAO.actualizarEquipo(equipo);
           }else {
               System.out.println("No valido");
           }
        }
    public void darAltaLiga(Liga liga){
        ligasDAO.crearLiga(liga);
    }

    public void inscribirseLiga(int idEquipo, int idLiga){
           Equipo equipo = equipoDAO.getEquipo(idEquipo);
           Liga liga = ligasDAO.getLiga(idLiga);
           equipo.setLiga(liga);
           equipoDAO.actualizarEquipo(equipo);
    }

    public void crearJugador(Jugador jugador, int idPosicion){
        Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Posicion posicion = session.get(Posicion.class,idPosicion);
        session.getTransaction().commit();
        session.close();
        jugadorDAO.crearJugador(jugador,posicion);
    }

    public void contratarJugador(int idJugador, int idEquipo){
           Jugador jugador = jugadorDAO.obtenerJugador(idJugador);
           Equipo equipo = equipoDAO.getEquipo(idEquipo);
           jugador.setEquipo(equipo);
           jugadorDAO.actualizarJugador(jugador);
    }

    public void analizarPlantilla(int id){
          List<Jugador> jugadores =  equipoDAO.obtenerPlantilla(id);
          for(Jugador jugador: jugadores){
              System.out.println(jugador.getNombre());
          }
    }

    public void getEquiposCompeticion(int idComp){
        List<Equipo> equipos = competicionDAO.getEquiposCompeticion(idComp);
        for(Equipo equipo:equipos){
            System.out.println(equipo.getNombre());
        }
    }

    public void obtenerLigas(){
        for(Liga item : ligasDAO.getAllLigas()){
            System.out.println("El nombre de la liga es : " + item.getNombre() + " y sus equipos son : " + item.getEquipos().toString());
        }
    }

    public void buscarPorNacionalida(){
           for(Jugador jugador : jugadorDAO.obtenerJugadoresNacionalidad("Española")){
               System.out.println(jugador.getNombre());
           }
    }

}
