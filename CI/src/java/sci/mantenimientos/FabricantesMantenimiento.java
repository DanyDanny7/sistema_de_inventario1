package sci.mantenimientos;

import com.myapp.struts.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sci.persistencia.Fabricantes;


public class FabricantesMantenimiento {

    public int guardarFabricantes(
            int idFabricante,
            String nombreFabricante,
            String descripcionFabricante,
            int numeroProductos,
            String fechaRegistroFabricante) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Fabricantes fab = new Fabricantes();
        fab.setIdFabricante(idFabricante);
        fab.setNombreFabricante(nombreFabricante);
        fab.setDescripcionFabricante(descripcionFabricante);
        fab.setNumeroProductos(numeroProductos);
        fab.setFechaRegistroFabricante(fechaRegistroFabricante);
        try {
            session.beginTransaction();
            session.save(fab);
            session.getTransaction().commit();
            System.out.println("Guardado Correcto FabricantesMantenimiento ");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
            }
            System.out.println("Error en Guardado FabricantesMantenimiento " + e);
        } finally {
            session.close();
        }
        return flag;
    }

    

    public int eliminarFabricante(int idFabricante) {
        Fabricantes fab = new Fabricantes();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        
        try {
            session.beginTransaction();
            fab = (Fabricantes) session.get(Fabricantes.class, idFabricante);
            session.delete(fab);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Eliminado correcto FabricantesMantenimiento ");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            System.out.println("Error en Eliminar FabricantesMantenimiento "+e);
            flag = 1;
        } finally {
            session.close();
        }

        return flag;
    }
    public int modificarFabricantes(
            int idFabricante,
            String nombreFabricante,
            String descripcionFabricante,
            int numeroProductos,
            String fechaRegistroFabricante) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Fabricantes fab = new Fabricantes();
        fab.setIdFabricante(idFabricante);
        fab.setNombreFabricante(nombreFabricante);
        fab.setDescripcionFabricante(descripcionFabricante);
        fab.setNumeroProductos(numeroProductos);
        fab.setFechaRegistroFabricante(fechaRegistroFabricante);
        try {
            session.beginTransaction();
            session.update(fab);
            session.getTransaction().commit();
            System.out.println("Modificado Correcto FabricantesMantenimiento ");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
            }
            System.out.println("Error en Modificado FabricantesMantenimiento " + e);
        } finally {
            session.close();
        }
        return flag;
    }

    public List consultarTodosFabricantes() {
        List<Fabricantes> listaFabricantes = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        try {
            Query q = session.createQuery("from Fabricantes");
            listaFabricantes = (List<Fabricantes>) q.list();
            System.out.println("Consultar todo Correcto FabricantesMantenimiento ");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en Consultar todos FabricantesMantenimiento "+e);
        } finally {

        }
        return listaFabricantes;
    }
    public Fabricantes consultarFabricantesId(int idFabricante) {
       // List<Fabricantes> listaFabricantes = null;
        Fabricantes fab = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            fab = (Fabricantes) session.get(Fabricantes.class, idFabricante);
            //Query q = session.createQuery("from Fabricantes where idFabricante = "+idFabricante );
        //    listaFabricantes = (List<Fabricantes>) q.list();
            session.getTransaction().commit();
            System.out.println("Consulta por id Correcta FabricantesMantenimiento ");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            System.out.println("Error en consulta por id FabricantesMantenimiento "+e);
            fab = null;
}
        } finally {
            session.close();
        }
        return fab;
    }
     public int validarFabricantes(String nombreFabricante) {
        List<Fabricantes> listaFabricantes = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        try {
            Query q = session.createQuery("from Fabricantes f where f.nombreFabricante=:nombreFabricante");
            q.setParameter("nombreFabricante",nombreFabricante);
            listaFabricantes = (List<Fabricantes>) q.list();
            if( listaFabricantes.size()>0){
                System.out.println("ya existe un registro");
                return 0; 
            }
            if( listaFabricantes.size()==0){
                System.out.println("validó correctamente");
               session.close();
                return 1;
            }
          
        } catch (Exception e) {
           
            System.out.println("Error en Consultar todos FabricantesMantenimiento "+e);
            return 0;
        } 
        
       return 0;
    }
     public int ActualizarFabricantes(
            int idFabricante,
            String nombreFabricante,
            int numeroProductos,
            String descripcionFabricante,
            String fechaRegistroFabricante) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Fabricantes fab = new Fabricantes();
        fab.setIdFabricante(idFabricante);
        fab.setNombreFabricante(nombreFabricante);
        fab.setDescripcionFabricante(descripcionFabricante);
        fab.setNumeroProductos(numeroProductos);
        fab.setFechaRegistroFabricante(fechaRegistroFabricante);
        try {
            session.beginTransaction();
            session.update(fab);
            session.getTransaction().commit();
            System.out.println("Guardado Correcto FabricantesMantenimiento ");
        } catch (Exception e) {
            System.out.println("problemas al actualizar"+e.getMessage());
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
            }
            System.out.println("Error en Guardado FabricantesMantenimiento " + e);
        } finally {
            session.close();
        }
        return flag;
    }

}
