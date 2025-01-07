import dao.TrabajadorDAO;
import database.HibernateUtil;
import model.Direccion;
import model.Trabajador;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class Entrada {
    public static void main(String[] args) {

        TrabajadorDAO trabajadorDAO = new TrabajadorDAO();
        trabajadorDAO.insertarTrabajador(new Trabajador("Laura","Lopez",new Direccion("Madrid","Madrid"),new Direccion("Barcelona","Barcelona"),654545654));


        //Insert
       /* SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.persist(new Trabajador("Pedro","Lopez","Caceres",622622622));
        session.getTransaction().commit();
        session.close();*/

        //Obtener
        /*SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
       Trabajador t =  session.get(Trabajador.class,1);
        System.out.println(t);
        session.getTransaction().commit();
        session.close();*/

        //Actualizar

        /*SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Trabajador t = session.get(Trabajador.class,1);
        t.setDireccion("Sevilla");
        session.merge(t);
        session.getTransaction().commit();
        session.close();*/

        //Borrar

       /* SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Trabajador t = session.get(Trabajador.class,1);
        session.delete(t);
        session.getTransaction().commit();
        session.close();*/

       /* SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<Trabajador> query = session.createQuery("SELECT t FROM Trabajador t", Trabajador.class);
        List<Trabajador> trabajadores = query.list();
        for(Trabajador trabajador:trabajadores){
            System.out.println(trabajador);
        }
        session.getTransaction().commit();
        session.close();*/

    }



}
