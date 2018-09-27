/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sci.mantenimientos;
import com.myapp.struts.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sci.actionforms.ActionFormProductos;
import sci.persistencia.Compras;
import sci.persistencia.Contactos;
import sci.persistencia.Inventario;
import sci.persistencia.Iva;
import sci.persistencia.Productos;

/**
 *
 * @author guillermo.bermudes
 */
public class Extraer {
    int variable;
    List <Integer> lista; ; 
    public List consultarTodo() {
         List<Productos> listaProductos = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
       
        session.beginTransaction();
        try {
             Query q   =  session.createQuery("select max(idProducto) from Productos");
         listaProductos = (List<Productos>) q.list();
            System.out.println(listaProductos.get(0));
            System.out.println("Consultar todo Correcto extraer");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en consultarTodo extraer. "+e);
        } finally {

        }
        
        return listaProductos ;
    }

  }