package sci.mantenimientos;

import com.myapp.struts.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sci.persistencia.Empresa;

public class EmpresaMantenimiento {

    public int guardarEmpresa(
                        String nombreEmpresa,
            String ncr,
            String nit,
            String direccionEmpresa,
            String telefonoEmpresa,
            String encargadoEmpresa,
            String emailEmpresa) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        //Empresa emp = new Empresa();
        Empresa emp = new Empresa();
        //emp.setIdEmpresa(idEmpresa);
        emp.setNcr(ncr);
        emp.setNit(nit);
        emp.setNombreEmpresa(nombreEmpresa);
        emp.setDireccionEmpresa(direccionEmpresa);
        emp.setTelefonoEmpresa(telefonoEmpresa);
        emp.setEncargadoEmpresa(encargadoEmpresa);
        emp.setEmailEmpresa(emailEmpresa);

        try {
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Guardado Correcto EmpresaMantenimiento ");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
            }
            System.out.println("Error en Guardado EmpresaMantenimiento " + e);
        } finally {
            session.close();
        }
        return flag;
    }

    public int eliminarEmpresa(int idEmpresa) {
        Empresa emp = new Empresa();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            emp = (Empresa) session.get(Empresa.class, idEmpresa);
            session.delete(emp);
            session.getTransaction().commit();
            System.out.println("Eliminado Correcto EmpresaMantenimiento ");
            flag = 1;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
            }
            System.out.println("Error en eliminado EmpresaMantenimiento " + e);
        } finally {
            session.close();
        }
        return flag;
    }

    public int modificarEmpresa(
            int idEmpresa,
            String nombreEmpresa,
            String ncr,
            String nit,
            String direccionEmpresa,
            String telefonoEmpresa,
            String encargadoEmpresa,
            String emailEmpresa) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Empresa emp = new Empresa();
        emp.setIdEmpresa(idEmpresa);
        emp.setNcr(ncr);
        emp.setNit(nit);
        emp.setNombreEmpresa(nombreEmpresa);
        emp.setDireccionEmpresa(direccionEmpresa);
        emp.setTelefonoEmpresa(telefonoEmpresa);
        emp.setEncargadoEmpresa(encargadoEmpresa);
        emp.setEmailEmpresa(emailEmpresa);

        try {
            session.beginTransaction();
            session.update(emp);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Modificado Correcto EmpresaMantenimiento ");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
            }
            System.out.println("Error en Modificado EmpresaMantenimiento " + e);
        } finally {
            session.close();
        }
        return flag;
    }

    public List consultarTodosEmpresa() {
        List<Empresa> listaUsuarios = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        try {
            Query q = session.createQuery("from Empresa");
            listaUsuarios = (List<Empresa>) q.list();
            System.out.println("Consultar todo correcto EmpresaMantenimiento ");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en consultar todo EmpresaMantenimiento " + e);
        } finally {

        }
        return listaUsuarios;
    }

    public Empresa consultarEmpresaId(int idEmpresa) {
        // List<Empresa> listaUsuarios = null;
        Empresa emp = new Empresa();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            emp = (Empresa) session.get(Empresa.class, idEmpresa);
            // Query q = session.createQuery("from Empresa where idEmpresa = " + idEmpresa);
            //  listaUsuarios = (List<Empresa>) q.list();
            System.out.println("Consulta por id Correcta ");
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Error en consulta por id EmpresaMantenimiento " + e);
                emp = null;
            }
        } finally {
            session.close();
        }
        return emp;
    }

    public int consultarNombre(String nombreEmpresa) {
        Empresa emp = new Empresa();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            // emp = (Empresa) session.get(Empresa.class, nombreEmpresa);
            Query q = session.createQuery("from Empresa e "
                    + "where e.nombreEmpresa=:nombreEmpresa");
            q.setParameter("nombreEmpresa", nombreEmpresa);
            List<Empresa> list = q.list();
            if (list.size() > 0) {
                return 0;
            }
            session.close();
            return 1;

        } catch (Exception e) {
            session.close();
            return 0;
        }
    }
}
