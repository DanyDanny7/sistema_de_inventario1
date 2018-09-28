package sci.mantenimientos;

import com.myapp.struts.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sci.actionforms.ActionFormProductos;
import sci.persistencia.Empresa;
import sci.persistencia.Productos;

/**
 *
 * @author guillermo.bermudes
 */
public class Extraer {

    int variable;
    List<Integer> lista;

    ; 
    public List consultarTodo() {
        List<Productos> listaProductos = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        try {
            Query q = session.createQuery("select max(idProducto) from Productos");
            listaProductos = (List<Productos>) q.list();
            System.out.println(listaProductos.get(0));
            System.out.println("Consultar todo Correcto extraer");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en consultarTodo extraer. " + e);
        } finally {

        }

        return listaProductos;
    }

    public List maxIdEmpresa() {
        List<Empresa> lista = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        try {
            Query q = session.createQuery("select max(idEmpresa) from Empresa");
            lista = (List<Empresa>) q.list();
            System.out.println(lista.get(0));
            System.out.println("Extraccion idEmpresa correcta.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en extraer idEmpresa. " + e);
        } finally {

        }

        return lista;
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

}
