package sci.mantenimientos;

import com.myapp.struts.HibernateUtil;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sci.persistencia.Acceso;
import sci.persistencia.Configuracion;
import sci.persistencia.Empresa;
import sci.persistencia.Moneda;

/**
 *
 * @author Admin104
 */
public class ConfiguracionMantenimiento {

    public int guardarConfiguracion(
            int idAcceso,
            int idEmpresa,
            //byte[] logo,
            String nombreMoneda,
            double iva,
            String zonaHoraria) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Configuracion conf = new Configuracion();
        //--
        Acceso acceso = new Acceso();
        acceso.setIdAcceso(idAcceso);
        conf.setAcceso(acceso);
        //--
        Empresa empresa = new Empresa();
        empresa.setIdEmpresa(idEmpresa);
        conf.setEmpresa(empresa);
        //--
        //conf.setLogo(logo);
        Moneda moneda = new Moneda();
        moneda.setNombreMoneda(nombreMoneda);
        conf.setMoneda(moneda);
        //--
        conf.setIva(iva);
        conf.setZonaHoraria(zonaHoraria);
        try {
            session.beginTransaction();
            session.save(conf);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("guardar Correcto ConfiguracionMantenimiento");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
            }
            System.out.println("Error en guardar ConfiguracionMantenimiento " + e);
        } finally {
            session.close();
        }
        return flag;
    }

    public int eliminarConfiguracion(int idConfiguracion) {
        Configuracion conf;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            conf = (Configuracion) session.get(Configuracion.class, idConfiguracion);
            session.delete(conf);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("eliminar Correcto ConfiguracionMantenimiento");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
            }
            System.out.println("Error en eliminar ConfiguracionMantenimiento " + e);
        } finally {
            session.close();
        }

        return flag;
    }

    public int modificarConfiguracion(
            int idAcceso,
            int idEmpresa,
            byte[] logo,
            String nombreMoneda,
            double iva,
            String zonaHoraria) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Configuracion conf = new Configuracion();
        //--
        Acceso acceso = new Acceso();
        acceso.setIdAcceso(idAcceso);
        conf.setAcceso(acceso);
        //--
        Empresa empresa = new Empresa();
        empresa.setIdEmpresa(idEmpresa);
        conf.setEmpresa(empresa);
        //--
        conf.setLogo(logo);
        Moneda moneda = new Moneda();
        moneda.setNombreMoneda(nombreMoneda);
        conf.setMoneda(moneda);
        conf.setIva(iva);
        conf.setZonaHoraria(zonaHoraria);
        try {
            session.beginTransaction();
            session.update(conf);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("modificar Correcto ConfiguracionMantenimiento");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
            }
            System.out.println("Error en guardar MonedaMantenimiento " + e);
        } finally {
            session.close();
        }
        return flag;
    }

    public List consultarTodosConfiguracion() {
        List<Configuracion> listaConf = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        try {
            Query q = session.createQuery("from Configuracion");
            listaConf = (List<Configuracion>) q.list();
            System.out.println("Consultar Todos Correcto ConfiguracionMantenimiento");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en consultar todo ConfiguracionMantenimiento " + e);
        } finally {

        }
        return listaConf;
    }

    public Configuracion consultarConfiguarionId(int idConfiguracion) {
        //  List<Configuracion> listaConf = null;
        Configuracion conf = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            conf = (Configuracion) session.get(Configuracion.class, idConfiguracion);
            //  Query q = session.createQuery("from Configuracion where idConfiguracion =" + idConfiguracion);
            //  listaConf = (List<Configuracion>) q.list();
            System.out.println("Consultar por id correcto ConfiguracionMantenimiento");
            //  return listaConf;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("error en consulta por id configuracionMantenimiento. " + e);
                conf = null;
            }

        } finally {
            session.close();
        }
        return conf;
    }
    public int validarEmpresa (int idEmpresa){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Configuracion c "
                    + "where c.idEmpresa=:idEmpresa");
            q.setParameter("idEmpresa", idEmpresa);
            List<Configuracion> list = q.list();
            if (list.size() > 0) {
                int idConfiguracion = list.get(0).getIdConfiguracion();
                System.out.println("ya existe un registro para esa empresa "+idConfiguracion);
                return idConfiguracion;
            }
            session.close();
            return -1;
        } catch (Exception e) {
            session.close();
            System.out.println("Error en validar ingreso "+e);
            return 0;
        }
    }
}
