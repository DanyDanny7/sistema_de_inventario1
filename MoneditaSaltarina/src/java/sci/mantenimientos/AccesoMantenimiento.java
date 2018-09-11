package sci.mantenimientos;

import com.myapp.struts.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sci.persistencia.Acceso;
import sci.persistencia.Empresa;

public class AccesoMantenimiento {

    public int guardarAcceso(
            int idEmpresa,
            String nombreAcceso,
            String apellidoAcceso,
            String usuario,
            String fechaRegistroAcceso,
            String contrasena,
            String email,
            String tipoAcceso) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Acceso ace = new Acceso();
        //--
        Empresa empresa = new Empresa();
        empresa.setIdEmpresa(idEmpresa);
        ace.setEmpresa(empresa);
        //--
        ace.setNombreAcceso(nombreAcceso);
        ace.setApellidoAcceso(apellidoAcceso);
        ace.setUsuario(usuario);
        ace.setEmail(email);
        ace.setFechaRegistroAcceso(fechaRegistroAcceso);
        ace.setTipoAcceso(tipoAcceso);
        ace.setContrasena(contrasena);

        try {
            session.beginTransaction();
            session.save(ace);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Guardado Correcto AccesoMantenimiento");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
                System.out.println("Error en guardar AccesoMantenimiento. " + e);
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public int eliminarAcceso(int idAcceso) {
        Acceso ace;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            ace = (Acceso) session.get(Acceso.class, idAcceso);
            session.delete(ace);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Eliminado Correcto AccesoMantenimiento");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
            }
            System.out.println("Error en eliminar acceso " + e);

        } finally {
            session.close();
        }
        return flag;
    }

    public int modificarAcceso(int idAcceso,
            int idEmpresa,
            String nombreAcceso,
            String apellidoAcceso,
            String usuario,
            String fechaRegistroAcceso,
            String contrasena,
            String email,
            String tipoAcceso) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Acceso ace = new Acceso();
        ace.setIdAcceso(idAcceso);
        //--
        Empresa empresa = new Empresa();
        empresa.setIdEmpresa(idEmpresa);
        ace.setEmpresa(empresa);
        //--
        ace.setNombreAcceso(nombreAcceso);
        ace.setApellidoAcceso(apellidoAcceso);
        ace.setUsuario(usuario);
        ace.setEmail(email);
        ace.setFechaRegistroAcceso(fechaRegistroAcceso);
        ace.setTipoAcceso(tipoAcceso);
        ace.setContrasena(contrasena);

        try {
            session.beginTransaction();
            session.update(ace);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Modificar correcto AccesoMantenimiento");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
            }
            System.out.println("Error en modificar AccesoMantenimiento " + e);
        } finally {
            session.close();
        }
        return flag;
    }

    public List consultarTodoAcceso() {
        List<Acceso> listaAcceso = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        try {
            Query q = session.createQuery("from Acceso");
            listaAcceso = (List<Acceso>) q.list();
            System.out.println("ConsultarTodo correcto AccesoMantenimiento");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en consultarTodo AccesoMantenimiento " + e);
        } finally {
        }
        return listaAcceso;
    }

    public Acceso consultarAccesoId(int idAcceso) {

        Acceso ace = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            ace = (Acceso) session.get(Acceso.class, idAcceso);
            session.getTransaction().commit();
            System.out.println("Consultar por ID correcto AccesoMantenimiento");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("error en consulta por id acceso. " + e);
                ace = null;
            }
            e.printStackTrace();

        } finally {
            session.close();
        }
        return ace;
    }

    public int loginAcceso(String usuario, String contrasena) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Acceso a "
                    + "where a.usuario=:usuario and "
                    + "a.contrasena=:contrasena");
            query.setParameter("usuario", usuario);
            query.setParameter("contrasena", contrasena);
            List<Acceso> list = query.list();
            if (list.size() > 0) {
                String tipoAcceso = list.get(0).getTipoAcceso();
                System.out.println("El tipo de usuario es: " + tipoAcceso);
                if (tipoAcceso.equals("Super Administrador")) {
                    session.close();
                    return 1;
                }
                if (tipoAcceso.equals("Administrador")) {
                    session.close();
                    return 2;
                }
                if (tipoAcceso.equals("Consulta e Ingresar")) {
                    session.close();
                    return 3;
                } else {
                    session.close();
                    return 4;
                }
            }
            session.close();
            return 0;
        } catch (Exception e) {
            session.close();
            System.out.println("Error en login acceso " + e);
            return 0;
        }
    }

    public int loginId(String usuario, String contrasena) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Acceso a "
                    + "where a.usuario=:usuario and "
                    + "a.contrasena=:contrasena");
            query.setParameter("usuario", usuario);
            query.setParameter("contrasena", contrasena);
            List<Acceso> list = query.list();
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
    }

    public int consultarUsuario(String usuario) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Acceso a "
                    + "where a.usuario=:usuario");
            query.setParameter("usuario", usuario);
            List<Acceso> list = query.list();
            if (list.size() > 0) {
                return 0;
            }
            session.close();
            return 1;
        } catch (Exception e) {
            session.close();
            System.out.println("Error en login idAcceso " + e);
            return 0;
        }
    }

    public List<Acceso> consultarTipo() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        String tipoAcceso = "Super Administrador";
        try {
            Query q = session.createQuery("from Acceso a where a.tipoAcceso=:tipoAcceso");
            q.setParameter("tipoAcceso", tipoAcceso);
            List<Acceso> list = q.list();
            System.out.println("consulta por tipo correcto");
            session.close();
            return list;
        } catch (Exception e) {
            System.out.println("error en consulta tipo de acceso " + e);
            session.close();
            return null;
        }
    }

    public String ayudaUsuario(String usuario) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Acceso a "
                    + "where a.usuario=:usuario");
            query.setParameter("usuario", usuario);
            List<Acceso> list = query.list();
            String tipoAcceso = list.get(0).getTipoAcceso();
            System.out.println("El tipo de usuario es: " + tipoAcceso);
            session.close();
            return tipoAcceso;
        } catch (Exception e) {
            session.close();
            System.out.println("Error en login idAcceso " + e);
            return null;
        }
    }
}
