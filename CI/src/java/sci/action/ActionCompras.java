/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sci.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import sci.actionforms.ActionFormCompras;
import sci.mantenimientos.ComprasMantenimiento;
import sci.mantenimientos.InventarioMantenimiento;
import sci.persistencia.Compras;
import sci.persistencia.Inventario;


/**
 *
 * @author guillermo.bermudes
 */
public class ActionCompras extends org.apache.struts.action.Action {

   
    private static final String ERROR = "confirmacionErrorF";
    private static final String IR = "juimonos";
    private static final String MODIFICAR= "modificarF";


    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws java.lang.Exception {

        ActionFormCompras formBean = (ActionFormCompras) form;
        Integer idCompra = formBean.getIdCompra();
        Integer idContacto = formBean.getIdContacto();
        Integer idInventario= formBean.getIdInventario();
        Integer idIva= formBean.getIdIva();
        Integer idProducto = formBean.getIdProducto();
        String fechaCompra = formato.format(new Date());
        Double totalCompra= formBean.getTotalCompra();
        String action = formBean.getAction();

        if (formBean == null || action == null) {
            System.out.println("Error entre formBean o action null");
            return mapping.findForward(ERROR);
        }
//--------------------------------------------------------
            System.out.println(idCompra);
            System.out.println(idContacto);
            System.out.println(idInventario);
            System.out.println(idIva);
            System.out.println(idProducto);
            System.out.println(totalCompra);
//------------------------------------------------------
        if (action.equals("Agregar")) {
            String advertencia = "";

            if (idContacto== null || idContacto.equals("")) {
                advertencia = "id de compras  es requerido<br>";
            }
            if (idInventario == null || idInventario.equals("")) {
                advertencia += "*id inventario es requerido<br>";
            }
            if (idIva== null || idIva.equals("")) {
                advertencia += "id iva  es requerido<br>";
            }
             if (idProducto== null || idProducto.equals("")) {
                advertencia += "*id productos es requerido<br>";
            }
             if (totalCompra== null || totalCompra.equals("")) {
                advertencia += "*id total de compra es requerido<br>";
            }

            

            if (!advertencia.equals("")) {
                formBean.setError("<span style='color:red'>Por favor complete los espacios vacios" + "<br>" + advertencia + "</span>");
                return mapping.findForward(ERROR);
            }
            ComprasMantenimiento comprasMantenimiento = new ComprasMantenimiento();
            InventarioMantenimiento inventario = new InventarioMantenimiento();
            Inventario  inv=   inventario.consultarInventarioId(idInventario);
            
            Double a = ( inv.getExistencia()+totalCompra);
            
           
   comprasMantenimiento.guardarcompras(idCompra, idContacto, idInventario, idIva, idProducto, fechaCompra, totalCompra);
            
   
   List<Compras> listaCompras = comprasMantenimiento.consultarTodoCompras();
            formBean.setListaCompras(listaCompras);
            String mensaje = "<span style='color:red'>Agregado Correcto" + "<br></span>";
            request.setAttribute("mensaje", mensaje);
           return mapping.findForward(IR);
        }
//----------------------------------------------------------------------
        if (action.equals("Modificar")) {
            ComprasMantenimiento comprasMantenimiento = new ComprasMantenimiento();

            Compras compras= (Compras) comprasMantenimiento.consultarComprasId(idCompra);
           
                formBean.setIdCompra(compras.getIdCompra());
               formBean.setIdContacto(compras.getContactos().getIdContacto());
               formBean.setIdInventario(compras.getInventario().getIdInventario());
                formBean.setIdIva(compras.getIva().getIdIva());
                formBean.setIdProducto(compras.getProductos().getIdProducto());
               
                return mapping.findForward(MODIFICAR);
            }
        //----------------------------------------------------------------------
           if (action.equals("Eliminar")) {
            ComprasMantenimiento comprasMantenimiento = new ComprasMantenimiento();
            comprasMantenimiento.eliminarCompras(idCompra);
            List<Compras> listaCompras = comprasMantenimiento.consultarTodoCompras();
           
            formBean.setListaCompras(listaCompras);
            System.out.println("desde eliminar");
            return mapping.findForward(IR);
         }
          //----------------------------------------------------------------------
           if (action.equals("Consultar")) {
           ComprasMantenimiento comprasMantenimiento = new ComprasMantenimiento();
            //Acceso acceso = new Acceso();
            List<Compras> listaCompras = comprasMantenimiento.consultarTodoCompras();

            if (listaCompras == null) {
                formBean.setError("<spam style='color:red'> la lista viene vacia " + "<br></spam>");
                return mapping.findForward(ERROR);
            } else {
                formBean.setListaCompras(listaCompras);
                return mapping.findForward(IR);
            }
              }
           if (action.equals("Actualizar")) {
               ComprasMantenimiento comprasMantenimiento = new ComprasMantenimiento();
               String mensaje = "<span style='color:red'>Actualizado Correcto" + "<br></span>";
            request.setAttribute("mensaje", mensaje);
           
           comprasMantenimiento.ModificarCompras(idCompra,idContacto,idInventario,idIva,idProducto, fechaCompra,totalCompra);
            List<Compras> listaCompras = comprasMantenimiento.consultarTodoCompras();
            formBean.setListaCompras(listaCompras);
           return mapping.findForward(IR);
           }
          
return null;
    }
}
