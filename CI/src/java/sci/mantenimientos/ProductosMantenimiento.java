package sci.mantenimientos;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sci.persistencia.Fabricantes;
import sci.persistencia.Productos;
import com.myapp.struts.HibernateUtil;

public class ProductosMantenimiento {

    public int guardarProductos(
            
            int idFabricantes,
            String nombreProducto,
            Double precioUnitario,
            String descripcionProducto,
            String modelo) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Productos pro = new Productos();
        
        //--
        Fabricantes fabricantes = new Fabricantes();
        fabricantes.setIdFabricante(idFabricantes);
        pro.setFabricantes(fabricantes);
        //--
        pro.setNombreProducto(nombreProducto);
        pro.setPrecioUnitario(precioUnitario);
        pro.setDescripcionProducto(descripcionProducto);
        pro.setModelo(modelo);

        try {
            session.beginTransaction();
            session.save(pro);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Guardado correcto ProductosMantenimiento ");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error al guardar ProductosMantenimiento " + e);
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public int eliminarProductos(int idProducto) {
        Productos pro;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            pro = (Productos) session.get(Productos.class, idProducto);
            session.delete(pro);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Eliminado Correcto ProductosMantenimiento ");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Erro en eliminar ProductosMantenimiento " + e);
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public int modificarProductos(
            int idProducto,
            int idFabricantes,
            String nombreProducto,
            Double precioUnitario,
            String descripcionProducto,
            String modelo) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 1;

        Productos pro = new Productos();
        pro.setIdProducto(idProducto);
        //--
        Fabricantes fabricantes = new Fabricantes();
        fabricantes.setIdFabricante(idFabricantes);
        pro.setFabricantes(fabricantes);
        //--
        pro.setNombreProducto(nombreProducto);
        pro.setPrecioUnitario(precioUnitario);
        pro.setDescripcionProducto(descripcionProducto);
        pro.setModelo(modelo);

        try {
            session.beginTransaction();
            session.update(pro);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Modificado Correcto ProductosMantenimiento ");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
            }
            System.out.println("Error al modificar ProductosMantenimiento " + e);
        } finally {
            session.close();
        }
        return flag;
    }

    public List consultarTodoProductos() {
        List<Productos> listaProductos = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        try {
            Query q = session.createQuery("from Productos");
            listaProductos = (List<Productos>) q.list();
            System.out.println("Consultar todo correcto PRoducto Mantenimiento");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en consultar todo producto mantenimiento " + e);
        } finally {
            session.close();            
        }
        return listaProductos;
    }

    public Productos consultarProductosId(int idProducto) {
        
        Productos pro = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            pro = (Productos) session.get(Productos.class, idProducto);
            session.getTransaction().commit();
            System.out.println("Consultar por id correcto producto mantenimiento");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("error en consulta por id productos. " + e);
                pro = null;
            }
        } finally{
            session.close();
        }
        return pro;
    }
    
    
    public static void main(String[] args) {
        ProductosMantenimiento pman = new ProductosMantenimiento();
        Integer idFabricante = 2;
        String nombreProducto = "PRO 2";
        pman.validar(nombreProducto, idFabricante);
    }
          
    
    
    
    public int validar (String nombreProducto, Integer idFabricante){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            Query q = session.createQuery("from Productos p "
                    + "where p.fabricantes.idFabricante=:idFabricante and "
                    + "p.nombreProducto=:nombreProducto");
            q.setParameter("idFabricante", idFabricante);
            q.setParameter("nombreProducto", nombreProducto);
            List<Productos> list = q.list();
            if (list.size()>0) {
                System.out.println("la lista tiene datos");
                return 1;
            }
            System.out.println("la lista no tiene datos");
            return 2;
        } catch (Exception e) {
            session.close();
            System.out.println("error en validar producto idFabricante "+e);
        }
        
    return 0;
    }
    
}
