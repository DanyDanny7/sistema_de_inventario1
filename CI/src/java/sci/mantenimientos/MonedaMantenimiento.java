package sci.mantenimientos;

import com.myapp.struts.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sci.persistencia.Moneda;

public class MonedaMantenimiento {

    public int guardarMoneda(
            String nombreMoneda,
            String simboloMoneda,
            String codigoMoneda,
            double equivalencia,
            String monedaReferencia) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Moneda moneda = new Moneda();
        moneda.setNombreMoneda(nombreMoneda);
        moneda.setSimboloMoneda(simboloMoneda);
        moneda.setCodigoMoneda(codigoMoneda);
        moneda.setEquivalencia(equivalencia);
        moneda.setMonedaReferencia(monedaReferencia);
        try {
            session.beginTransaction();
            session.save(moneda);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Guardado Correcto MonedaMantenimiento");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
            }
            System.out.println("Error en guardar MonedaMantenimiento " + e);
        } finally {
            session.close();
        }
        return flag;

    }

    public int eliminarMoneda(String nombreMoneda) {
        Moneda moneda;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            moneda = (Moneda) session.get(Moneda.class, nombreMoneda);
            session.delete(moneda);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Eliminado Correcto MonedaMantenimiento ");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
            }
            System.out.println("error en eliminar moneda " + e);

        } finally {
            session.close();
        }
        return flag;
    }

    public int modificarMoneda(
            String nombreMoneda,
            String simboloMoneda,
            String codigoMoneda,
            double equivalencia,
            String monedaReferencia) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Moneda moneda = new Moneda();
        moneda.setNombreMoneda(nombreMoneda);
        moneda.setSimboloMoneda(simboloMoneda);
        moneda.setCodigoMoneda(codigoMoneda);
        moneda.setEquivalencia(equivalencia);
        moneda.setMonedaReferencia(monedaReferencia);
        try {
            session.beginTransaction();
            session.update(moneda);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Modificado Correcto MonedaMantenimiento");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
            }
            System.out.println("Error en Modificar MonedaMantenimiento " + e);
        } finally {
            session.close();
        }
        return flag;

    }

    public List consultarTodosMoneda() {
        List<Moneda> listaMoneda = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        try {
            Query q = session.createQuery("from Moneda");
            listaMoneda = (List<Moneda>) q.list();
            System.out.println("consultarTodo Correcto MonedaMantenimiento");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en consultarTodo MonedaMantenimiento " + e);
        } finally {
            session.close();
        }
        return listaMoneda;
    }

    public Moneda consultarMonedaId(String nombreMoneda) {
        Moneda moneda = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            moneda = (Moneda) session.get(Moneda.class, nombreMoneda);
            System.out.println("Consultar por Id Correcto MonedaMantenimiento");
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("error en consulta por id moneda. " + e);
                moneda = null;
            }

        } finally {
            session.close();
        }
        return moneda;
    }

    public List<Moneda> consultaNombreMoneda(String nombreMoneda) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Moneda m "
                    + "where m.nombreMoneda=:nombreMoneda");
            query.setParameter("nombreMoneda", nombreMoneda);
            List<Moneda> listaMoneda = query.list();
            if (listaMoneda.size() > 0) {

                return listaMoneda;
            }
            session.close();
            return null;
        } catch (Exception e) {
            session.close();
            System.out.println("Error en consulta por nombre moneda " + e);
            return null;
        }
    }

    public List<Moneda> consultaCodigoMoneda(String codigoMoneda) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Moneda m "
                    + "where m.codigoMoneda=:codigoMoneda");
            query.setParameter("codigoMoneda", codigoMoneda);
            List<Moneda> listaMoneda = query.list();
            if (listaMoneda.size() > 0) {

                return listaMoneda;
            }
            session.close();
            return null;
        } catch (Exception e) {
            session.close();
            System.out.println("Error en consulta por codigo moneda " + e);
            return null;
        }
    }
}
