package sci.mantenimientos;

import com.myapp.struts.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sci.persistencia.Compras;
import sci.persistencia.Contactos;
import sci.persistencia.Inventario;
import sci.persistencia.Iva;
import sci.persistencia.Productos;



public class ComprasMantenimiento {

    public int guardarcompras(
            int idCompra,
            String nDocumento,
            int idContactos,
            int idInventario,
            double cantidad,
            int idIva,
            int idProductos,
            String fechaCompra,
            double totalCompra
    ) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Compras com = new Compras();
        com.setIdCompra(idCompra);
        com.setCantidad(cantidad);
        //--
        Contactos contactos = new Contactos();
        contactos.setIdContacto(idContactos);
        com.setContactos(contactos);
        //--
        Inventario inventario = new Inventario();
        inventario.setIdInventario(idInventario);
        com.setInventario(inventario);
        //--
        Iva iva = new Iva();
        iva.setIdIva(idIva);
        com.setIva(iva);
        //--
        Productos productos = new Productos();
        productos.setIdProducto(idProductos);
        com.setProductos(productos);
        //--
        com.setFechaCompra(fechaCompra);
        com.setnDocumento(nDocumento);
        com.setTotalCompra(totalCompra);
        com.setCantidad(cantidad);
        try {
            session.beginTransaction();
            session.save(com);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Guardar Correcto ComprasMantenimiento");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("error en guardar compraMantenimiento "+e);
            }
        } finally {
            session.close();
        }
        return flag;
    }
    public int eliminarCompras(int idCompra) {
        Compras com;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            com = (Compras) session.get(Compras.class, idCompra);
            session.delete(com);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Eliminado Correcto ComprasMantenimiento");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
            }
            System.out.println("error en eliminar comprasMantenimiento "+e);
        } finally {
            session.close();
        }

        return flag;
    }

    public int ModificarCompras(
            int idCompra,
            String nDocumento,
            int idContactos,
            int idInventario,
            double cantidad,
            int idIva,
            int idProductos,
            String fechaCompra,
            double totalCompra
    ) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Compras com = new Compras();
        com.setIdCompra(idCompra);
        com.setnDocumento(nDocumento);
       com.setCantidad(cantidad);
        //--
        Contactos contactos = new Contactos();
        contactos.setIdContacto(idContactos);
        com.setContactos(contactos);
        
        //--
        Inventario inventario = new Inventario();
        inventario.setIdInventario(idInventario);
        com.setInventario(inventario);
        //--
        Iva iva = new Iva();
        iva.setIdIva(idIva);
        com.setIva(iva);
        //--
        Productos productos = new Productos();
        productos.setIdProducto(idProductos);
        com.setProductos(productos);
        //--
        com.setFechaCompra(fechaCompra);
        com.setTotalCompra(totalCompra);
        try {
            session.beginTransaction();
            session.update(com);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Modificado Correcto ComprasMantenimiento");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
            }
            System.out.println("Error en modificar ComprasMantenimiento. "+e);
        } finally {
            session.close();
        }
        return flag;
    }

    

    public List consultarTodoCompras() {
        List<Compras> listaCom = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        try {
            Query q = session.createQuery("from Compras");
            listaCom = (List<Compras>) q.list();
            System.out.println("Consultar todo Correcto ComprasMAntenimiento");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en consultarTodo ComprasMantenimiento. "+e);
        } finally {

        }
        return listaCom;
    }

    
    public Compras consultarComprasId(int idCompra) {
       // List<Compras> listaCompras = null;
        Compras com = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            com = (Compras) session.get(Compras.class, idCompra);
          //  Query q = session.createQuery("from Compras where idCompra= " + idCompra);
         //   listaCompras = (List<Compras>) q.list();
         session.getTransaction().commit();
            System.out.println("Consultar por id correcto ComprasMantenimiento");
          //  return listaCompras;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
               System.out.println("error en consulta por id iva " + e);
            com = null;
        }

    }finally{
            session.close();
        }
        return com;
}
    
}