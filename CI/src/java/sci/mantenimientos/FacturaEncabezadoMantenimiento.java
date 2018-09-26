package sci.mantenimientos;

import com.myapp.struts.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sci.persistencia.Contactos;
import sci.persistencia.Empresa;
import sci.persistencia.FacturaEncabezado;


public class FacturaEncabezadoMantenimiento {

    public int guardarFacturaEncabezado(
            
            int idContacto,
            int idEmpresa,
            String fechaFactura,
            String estado) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        FacturaEncabezado fae = new FacturaEncabezado();
        
        fae.setFechaFactura(fechaFactura);
        fae.setEstado(estado);
        //--
        Empresa empresa = new Empresa();
        empresa.setIdEmpresa(idEmpresa);
        fae.setEmpresa(empresa);
        //--
        Contactos contactos = new Contactos();
        contactos.setIdContacto(idContacto);
        fae.setContactos(contactos);
        //--
        try {
            session.beginTransaction();
            session.save(fae);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Guardado Correcto FacturaEncabezadoMantenimiento");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
            }
            System.out.println("Error en guardar FacturaEncabezadoMantenimiento " + e);
        } finally {
            session.close();
        }
        return flag;
    }

    public int eliminarFacturaEncabezado(int idFacturaEncabezado) {
        FacturaEncabezado fae;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            fae = (FacturaEncabezado) session.get(FacturaEncabezado.class, idFacturaEncabezado);
            session.delete(fae);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Eliminado Correcto FacturaEncabezadoMantenimiento");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
            }
            System.out.println("error en eliminar FacturaEncabezadoMantenimiento " + e);
        } finally {
            session.close();
        }
        return flag;
    }

    public int modificarFacturaEncabezado(
            int idFacturaEncabezado,
            int idContactos,
            int idEmpresa,
            String fechaFactura,
            String vendedor) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        FacturaEncabezado fae = new FacturaEncabezado();
        fae.setIdFacturaEncabezado(idFacturaEncabezado);
        fae.setFechaFactura(fechaFactura);
        fae.setEstado(vendedor);
        //--
        Empresa empresa = new Empresa();
        empresa.setIdEmpresa(idEmpresa);
        fae.setEmpresa(empresa);
        //--
        Contactos contactos = new Contactos();
        contactos.setIdContacto(idContactos);
        fae.setContactos(contactos);
        //--

        try {
            session.beginTransaction();
            session.update(fae);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Modificado Correcto FacturaEncabezadoMantenimiento  ");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
            }
            System.out.println("Error en modificar FacturaEncabezadoMantenimiento " + e);
        } finally {
            session.close();
        }
        return flag;
    }

    public List consultarTodosFacturaEncabezado() {
        List<FacturaEncabezado> listafactE = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        try {
            Query q = session.createQuery("from FacturaEncabezado");
            listafactE = (List<FacturaEncabezado>) q.list();
            System.out.println("Consultar Todo Correcto FacturaEncabezadoMantenimiento");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en Consultar Todo Factura Encabezado " + e);
        } finally {

        }
        return listafactE;
    }

    public FacturaEncabezado consultarFacturaEncabezadoId(int idFacturaEncabezado) {
        //  List<FacturaEncabezado> listaFacturaEncabezado = null;
        FacturaEncabezado fae = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            fae = (FacturaEncabezado) session.get(FacturaEncabezado.class, idFacturaEncabezado);
            //   Query q = session.createQuery("from FacturaEncabezado where idFacturaEncabezado = "+idFacturaEncabezado );
            //   listaFacturaEncabezado = (List<FacturaEncabezado>) q.list();
            System.out.println("Consulta por id correcta FacturaEncabezadoMantenimiento");
                        session.getTransaction().commit();

            // return listaFacturaEncabezado;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("error en consulta por id factura encabezado. " + e);
                fae = null;
            }

        } finally {
            session.close();
        }
        return fae;
    }
}