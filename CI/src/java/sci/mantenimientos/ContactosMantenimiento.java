package sci.mantenimientos;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sci.persistencia.Contactos;
import com.myapp.struts.HibernateUtil;

public class ContactosMantenimiento {

    public int guardarContacto(
            String nombreContacto,
            String direccionContacto,
            String tipoContacto,
            String telefonoContacto,
            String emailContacto,
            String encargadoContacto,
            String telefonoEncargadoContacto,
            String fechaRegistroContacto) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Contactos con = new Contactos();
        con.setNombreContacto(nombreContacto);
        con.setDireccionContacto(direccionContacto);
        con.setTipoContacto(tipoContacto);
        con.setTelefonoContacto(telefonoContacto);
        con.setEmailContacto(emailContacto);
        con.setEncargadoContacto(encargadoContacto);
        con.setTelefonoEncargadoContacto(telefonoEncargadoContacto);
        con.setFechaRegistroContacto(fechaRegistroContacto);
        try {
            session.beginTransaction();
            session.save(con);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Guardado Correcto ContactoMantenimiento ");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error en Guardado ContactoMantenimiento " + e);
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public int eliminarContactos(int idContacto) {
        Contactos con = new Contactos();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        session.beginTransaction();
        try {
            con = (Contactos) session.get(Contactos.class, idContacto);
            session.delete(con);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Eliminado Correcto ContactoMantenimiento ");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
            }
            System.out.println("Eliminado Correcto ContactoMantenimiento " + e);

        } finally {
            session.close();
        }

        return flag;
    }

    public int modificarContacto(
            int idContacto,
            String nombreContacto,
            String direccionContacto,
            String tipoContacto,
            String telefonoContacto,
            String emailContacto,
            String encargadoContacto,
            String telefonoEncargadoContacto,
            String fechaRegistroContacto) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Contactos con = new Contactos();
        con.setIdContacto(idContacto);
        con.setNombreContacto(nombreContacto);
        con.setDireccionContacto(direccionContacto);
        con.setTipoContacto(tipoContacto);
        con.setTelefonoContacto(telefonoContacto);
        con.setEmailContacto(emailContacto);
        con.setEncargadoContacto(encargadoContacto);
        con.setTelefonoEncargadoContacto(telefonoEncargadoContacto);
        con.setFechaRegistroContacto(fechaRegistroContacto);
        try {
            session.beginTransaction();
            session.update(con);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Modificado Correcto ContactoMantenimiento ");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error en modificar ContactoMantenimiento " + e);
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public List consultarTodosContactos() {
        List<Contactos> listaContactos = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        try {
            Query q = session.createQuery("from Contactos");
            listaContactos = (List<Contactos>) q.list();
            System.out.println("Consultar Todo Correcto ContactosMantenimiento");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro en consultar Todo ContactosMAntenimiento " + e);
        } finally {
            session.close();
        }
        return listaContactos;
    }

    public Contactos consultarContactosId(int idContacto) {
        //  List<Contactos> listaContactos = null;
        Contactos con = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            con = (Contactos) session.get(Contactos.class, idContacto);
            //   Query q = session.createQuery("from Contactos where idContacto = "+idContacto );
            //    listaContactos = (List<Contactos>) q.list();
            session.getTransaction().commit();
            System.out.println("Consultar por id Correcto ContactoMantenimiento ");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Errro en consultar por id ContactoMantenimiento " + e);
                con = null;
            }
        } finally {
            session.close();
        }
        return con;
    }

    /*public int loginId(String usuario, String contrasena) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Acceso a where a.usuario=:usuario and a.contrasena=:contrasena");
            q.setParameter("usuario", usuario);
            q.setParameter("contrasena", contrasena);
            List<Acceso> list = q.list();
            if (list.size() > 0) {
                int idAcceso = list.get(0).getIdAcceso();
                System.out.println("El idAcceso de usuario es: " + idAcceso);
                return idAcceso;
            }
            session.close();
            return 0;

        } catch (Exception e) {
            session.close();
            System.out.println("Error en login idAcceso " + e);
            return 0;
        }
    }*/
    public int validar(String nombreContacto) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Contactos c where c.nombreContacto=:nombreContacto");
            q.setParameter("nombreContacto", nombreContacto);
            List<Contactos> list = q.list();
            if (list.size() > 0) {
                System.out.println("ya existe un registro");
                session.close();
                return 0;
            }
            if (list.isEmpty()) {
                System.out.println("valido correctamente ");
                session.close();
                return 1;
            }
            return 0;
        } catch (Exception e) {
            System.out.println("error al validar en contactomantenimineto " + e);
            session.close();
            return 0;
        }
    }

    public List<Contactos> tipos(String tipoContacto) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Contactos c where c.tipoContacto=:tipoContacto");
            q.setParameter("tipoContacto", tipoContacto);
            List<Contactos> listaContacto = q.list();
            if (listaContacto.size() > 0) {
                String tipo = listaContacto.get(0).getTipoContacto();
                System.out.println("el tipo de contacto es: " + tipo);
                return listaContacto;
            }

            session.close();
            return null;
            
        } catch (Exception e) {
            System.out.println("error al validar tipo en contactoMantenimiento " + e);
            session.close();
            return null;
        }
    }
}
