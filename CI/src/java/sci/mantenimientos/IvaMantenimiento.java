package sci.mantenimientos;

import com.myapp.struts.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sci.persistencia.Iva;


public class IvaMantenimiento {

    public int guardarIva(
            double ivaTasa,
            double ivaRetenido,
            double ivaPagado,
            double ivaTotal,
            double subTotalTransaccion,
            double totalTransaccion
            ) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Iva iva = new Iva();
        
        iva.setIvaRetenido(ivaRetenido);
        iva.setIvaPagado(ivaPagado);
        iva.setIvaTotal(ivaTotal);
        iva.setIvaTasa(ivaTasa);
        iva.setTotalTransaccion(totalTransaccion);
        iva.setSubTotalTransaccion(subTotalTransaccion);
        try {
            session.beginTransaction();
            session.save(iva);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Guardado Correcto IvaMantenimiento");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
            }
            System.out.println("Error en guardar IvaMantenimiento " + e);
        } finally {
            session.close();
        }
        return flag;

    }

    public int eliminarIva(int idIva) {
        Iva iva;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            iva = (Iva) session.get(Iva.class, idIva);
            session.delete(iva);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Eliminado Correcto IvaMantenimiento ");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
            }
            System.out.println("error en eliminar iva " + e);

        } finally {
            session.close();
        }
        return flag;
    }
    
    public int modificarIva(int idIva,
            double ivaTasa,
            double ivaRetenido,
            double ivaPagado,
            double ivaTotal,
            double subTotalTransaccion,
            double totalTransaccion
            ) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Iva iva = new Iva();
        
        iva.setIdIva(idIva);
        iva.setIvaRetenido(ivaRetenido);
        iva.setIvaPagado(ivaPagado);
        iva.setIvaTotal(ivaTotal);
        iva.setIvaTasa(ivaTasa);
        iva.setTotalTransaccion(totalTransaccion);
        iva.setSubTotalTransaccion(subTotalTransaccion);
        try {
            session.beginTransaction();
            session.update(iva);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Modificado Correcto IvaMantenimiento");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
            }
            System.out.println("Error en modificar IvaMantenimiento " + e);
        } finally {
            session.close();
        }
        return flag;
    }

    public List consultarTodosIva() {
        List<Iva> listaIva = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        try {
            Query q = session.createQuery("from Iva");
            listaIva = (List<Iva>) q.list();
            System.out.println("consultarTodo Correcto IvaMantenimiento");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en consultarTodo IvaMantenimiento " + e);
        } finally {
             session.close();           
        }
        return listaIva;
    }

    public Iva consultarIvaId(int idIva) {
        Iva iva = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            iva = (Iva) session.get(Iva.class, idIva);
            System.out.println("Consultar por Id Correcto IvaMantenimiento");
                        session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("error en consulta por id iva. " + e);
                iva = null;
            }
        } finally {
            session.close();
        }
        return iva;
    }
    public List maxIdIva() {
         List<Iva> listaI = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
       
        session.beginTransaction();
        try {
             Query q   =  session.createQuery("select max(idIva) from Iva");
         listaI = (List<Iva>) q.list();
            System.out.println(listaI.get(0));
            System.out.println("Consultar max Iva Correcto");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error consultar max id Iva. "+e);
        } finally {

        }
        
        return listaI ;
    }
    public int maxIdIv(){
        IvaMantenimiento fam = new IvaMantenimiento();
        int idIva = 0; 
        List<Iva> fe = fam.consultarTodosIva();
        if (fe.size()>0) {
            List<Integer> lista = fam.maxIdIva();
        idIva = lista.get(0);
        }
        
        return idIva;
    }
     
}
