package sci.mantenimientos;

import com.myapp.struts.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sci.persistencia.Inventario;
import sci.persistencia.Productos;

public class InventarioMantenimiento {

    public int guardarInventario(
            int idInventario,
            int idProductos,
            double existencia,
            String estadoExistencia,
            int stockMinimo,
            String estadoFisico) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Inventario inv = new Inventario();
        inv.setIdInventario(idInventario);
        //--
        Productos productos = new Productos();
        productos.setIdProducto(idProductos);
        inv.setProductos(productos);
        //--
        inv.setExistencia(existencia);
        inv.setEstadoExistencia(estadoExistencia);
        inv.setStockMinimo(stockMinimo);
        inv.setEstadoFisico(estadoFisico);

        try {
            session.beginTransaction();
            session.save(inv);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("guardado correcto InventarioMantenimiento");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
                System.out.println("Errro en Guardado InventarioMantenimiento " + e);
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public int eliminarInventario(int idInventario) {
        Inventario inv;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            inv = (Inventario) session.get(Inventario.class, idInventario);
            session.delete(inv);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Eliminado Correcto InventarioMantenimiento");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
            }
            System.out.println("Error en eliminar InventarioMantenimiento " + e);
        } finally {
            session.close();
        }
        return flag;
    }

    public int modificarInventario(
            int idInventario,
            int idProductos,
            double existencia,
            String estadoExistencia,
            int stockMinimo,
            String estadoFisico) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Inventario inv = new Inventario();
        inv.setIdInventario(idInventario);
        //--
        Productos productos = new Productos();
        productos.setIdProducto(idProductos);
        inv.setProductos(productos);
        //--
        inv.setExistencia(existencia);
        inv.setEstadoExistencia(estadoExistencia);
        inv.setStockMinimo(stockMinimo);
        inv.setEstadoFisico(estadoFisico);

        try {
            session.beginTransaction();
            session.update(inv);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Modificado Correcto InventarioMantenimiento ");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
                System.out.println("Error en modificadr InventarioMantenimiento " + e);
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public List consultarTodoInventario() {
        List<Inventario> listaInventario = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        try {
            Query q = session.createQuery("from Inventario");
            listaInventario = (List<Inventario>) q.list();
            System.out.println("Consultar todo Correcto  InventarioMantenimiento");
        } catch (Exception e) {
            System.out.println("Errorr en consultar todo InventarioMantenimiento " + e);
        } finally {
            //session.close();       
        }
        return listaInventario;
    }

    public Inventario consultarInventarioId(int idInventario) {
        //List<Inventario> listaInventario = null;
        Inventario inv = new Inventario();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            inv = (Inventario) session.get(Inventario.class, idInventario);
            // Query q = session.createQuery("from Inventario where idInventario = " + idInventario );
            //  listaInventario = (List<Inventario>) q.list();
            System.out.println("Consulta por id correcto InventarioMantenimiento");
            session.getTransaction().commit();
            // return listaInventario;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("error en consulta por id InventarioMantenimiento. " + e);
                inv = null;
            }
        } finally {
            session.close();
        }
        return inv;
    }
    public int consultarInventarioIdProducto(int idProducto){
        int idInventario = 0;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Inventario i where i.productos.idProducto=:idProducto");
            q.setParameter("idProducto", idProducto);
            List<Inventario> listaInventario = q.list();
            idInventario = listaInventario.get(0).getIdInventario();
            System.out.println("idInventario "+listaInventario.get(0).getIdInventario());
            session.close();
        } catch (Exception e) {
            //session.close();
            System.out.println("Error en consultar inventario por id producto "+e);
            session.close();
        }
        return idInventario;
    }
    public List<Inventario> consultarExistenciacero() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        double numero = 0;
        try {
            Query q = session.createQuery("from Inventario i where i.existencia=:numero");
            q.setParameter("numero", numero);
            List<Inventario> list = q.list();
            System.out.println("consulta por tipo correcto");
            //session.close();
            return list;
        } catch (Exception e) {
            System.out.println("error en consulta tipo de acceso " + e);
            session.close();
            return null;
        }
    }
     public List<Inventario> existenciabaja() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
       
        try {
            Query q = session.createQuery("from Inventario i where i.existencia <i.stockMinimo");
          
            List<Inventario> list = q.list();
            System.out.println("consulta por tipo correcto");
            //session.close();
            return list;
        } catch (Exception e) {
            System.out.println("error en consulta tipo de acceso " + e);
            session.close();
            return null;
        }
    }
    public static void main(String[] args) {
        InventarioMantenimiento i = new InventarioMantenimiento();
        
       List<Inventario> lista = i.consultarTodoInventario();
        System.out.println("La lista: "+lista.toString());
        
    }

}
