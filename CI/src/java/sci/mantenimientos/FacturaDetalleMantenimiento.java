package sci.mantenimientos;

import com.myapp.struts.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sci.persistencia.Configuracion;
import sci.persistencia.FacturaDetalle;
import sci.persistencia.FacturaEncabezado;
import sci.persistencia.Iva;
import sci.persistencia.Productos;



public class FacturaDetalleMantenimiento {

    public int guardarFacuraDetalle(
            int idConfiguracion,
            int idFacturaEncabezado,
            int idIva,
            int idProducto,
            int cantidad,
            double totalFila,
            double totalColumna,
            double subtotalColumna) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        FacturaDetalle facdet = new FacturaDetalle();
        //--
        Configuracion configuracion = new Configuracion();
        configuracion.setIdConfiguracion(idConfiguracion);
        facdet.setConfiguracion(configuracion);
        //--
        FacturaEncabezado facturaEncabezado = new FacturaEncabezado();
        facturaEncabezado.setIdFacturaEncabezado(idFacturaEncabezado);
        facdet.setFacturaEncabezado(facturaEncabezado);
        //--
        Iva iva = new Iva();
        iva.setIdIva(idIva);
        facdet.setIva(iva);
        //--
        Productos productos = new Productos();
        productos.setIdProducto(idProducto);
        facdet.setProductos(productos);
        //--
        facdet.setCantidad(cantidad);
        facdet.setTotalFila(totalFila);
        facdet.setTotalColumna(totalColumna);
        facdet.setSubtotalColumna(subtotalColumna);
        try {
            session.beginTransaction();
            session.save(facdet);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Guardado Correcto FacturaDetalleMantenimiento");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
            }
            System.out.println("Error en guardar FacturaDetalleMantenimiento. " + e);
        } finally {
            session.close();
        }
        return flag;
    }

    public int eliminarFacturaDetalle(int idFacturaDetalle) {
        FacturaDetalle factdet;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            factdet = (FacturaDetalle) session.get(FacturaDetalle.class, idFacturaDetalle);
            session.delete(factdet);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Eliminado correcto FacturaDetalleMantenimiento");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
            }
            System.out.println("Error en eliminar FacturaDetalleMantenimiento "+e);
        } finally {
            session.close();
        }

        return flag;
    }

    public int modificarFacturaDetalle(
            int idFacturaDetalle,
            int idConfiguracion,
            int idFacturaEncabezado,
            int idIva,
            int idProductos,
            int cantidad,
            double totalFila,
            double totalColumna,
            double subtotalColumna) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        FacturaDetalle facdet = new FacturaDetalle();
        facdet.setIdFacturaDetalle(idFacturaDetalle);
        //--
        Configuracion configuracion = new Configuracion();
        configuracion.setIdConfiguracion(idConfiguracion);
        facdet.setConfiguracion(configuracion);
        //--
        FacturaEncabezado facturaEncabezado = new FacturaEncabezado();
        facturaEncabezado.setIdFacturaEncabezado(idFacturaEncabezado);
        facdet.setFacturaEncabezado(facturaEncabezado);
        //--
        Iva iva = new Iva();
        iva.setIdIva(idIva);
        facdet.setIva(iva);
        //--
        Productos productos = new Productos();
        productos.setIdProducto(idProductos);
        facdet.setProductos(productos);
        //--
        facdet.setCantidad(cantidad);
        facdet.setTotalFila(totalFila);
        facdet.setTotalColumna(totalColumna);
        facdet.setSubtotalColumna(subtotalColumna);
        try {
            session.beginTransaction();
            session.update(facdet);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Modificado Correcto FacturaDetalleMantenimiento");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
            }
            System.out.println("error en modificar FacturaDetalleMantenimiento " +e);
        } finally {
            session.close();
        }
        return flag;
    }

    public List consultarTodosFacturaDetalle() {
        List<FacturaDetalle> listafactd = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        try {
            Query q = session.createQuery("from FacturaDetalle");
            listafactd = (List<FacturaDetalle>) q.list();
            System.out.println("Consultar Todos correcto FacturaDetalleMantenimiento");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en Consultar Todos FacturaDetalleMantenimiento");
        } finally {

        }
        return listafactd;
    }

    public FacturaDetalle consultarFacturaDetalleId(int idFacturaDetalle) {
      //  List<FacturaDetalle> lista = null;
        FacturaDetalle factdet = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            factdet = (FacturaDetalle) session.get(FacturaDetalle.class, idFacturaDetalle);
         //   Query q = session.createQuery("from FacturaDetalle where idFacturaDetalle =" + idFacturaDetalle);
           // lista = (List<FacturaDetalle>) q.list();
            System.out.println("Consultar por ID correcta FacturaDetalleMantenimiento");
            session.getTransaction().commit();
            //return lista;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
             session.getTransaction().rollback();   
            System.out.println("error en consulta por id factura detalle FacturaDetalleMantenimiento" + e);
            factdet = null;
            }
        }finally{
                       session.close();
 
        }
        return factdet;
    }
    public List consultaFacturaEspecifica (int idFacturaEncabezado){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from FacturaDetalle f where f.facturaEncabezado.idFacturaEncabezado=:idFacturaEncabezado");
            q.setParameter("idFacturaEncabezado", idFacturaEncabezado);
            List<FacturaDetalle> list = q.list();
            if (list.size()>0) {
                return list;
            }
            session.close();
            return null;
        } catch (HibernateException e) {
            session.close();
            System.out.println("Error en consultar Factura "+e);
            return null;
        }
    }
    public static void main(String[] args) {
        FacturaDetalleMantenimiento eman = new FacturaDetalleMantenimiento();
        
        List<FacturaEncabezado> list = eman.consultaFacturaEspecifica(26);
        System.out.println("lis "+list.toString());
    }
    
}
