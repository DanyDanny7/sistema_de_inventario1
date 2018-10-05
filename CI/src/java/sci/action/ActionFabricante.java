
package sci.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import sci.actionforms.ActionFormFabricante;
import sci.mantenimientos.Extraer;
import sci.mantenimientos.FabricantesMantenimiento;
import sci.mantenimientos.ProductosMantenimiento;
import sci.persistencia.Fabricantes;
import sci.persistencia.Productos;

/**
 *
 * @author guillermo.bermudes
 */
public class ActionFabricante extends org.apache.struts.action.Action {

    
    private static final String AGREGAR = "irAgregarFabricantes";
    private static final String INICIO = "irInicioFabricantes";
    private static final String LISTA = "irListaFabricantes";
    private static final String MODIFICAR = "irModificarFabricantes";
    private static final String LISTA2 = "irListaFabricantes2";

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws java.lang.Exception {

        ActionFormFabricante formBean = (ActionFormFabricante) form;
        Integer idFabricante = formBean.getIdFabricante();
        Integer numeroProductos = formBean.getNumeroProductos();
        String nombreFabricante = formBean.getNombreFabricante();
        String descripcionFabricante = formBean.getDescripcionFabricante();

        String fechaRegistroFabricante = formato.format(new Date());
        String action = formBean.getAction();
        String IR = null;

        if (formBean == null || action == null) {
            System.out.println("Error entre formBean o action null");
            return mapping.findForward(INICIO);
        }
//--------------------------------------------------------

//------------------------------------------------------
        if (action.equals("Agregar")) {
            String advertencia = "";

            if (nombreFabricante == null || nombreFabricante.equals("")) {
                advertencia = "*Nombre del fabricante es requerido<br>";
            }
            if (descripcionFabricante == null || descripcionFabricante.equals("")) {
                advertencia += "*descripcion es requerido<br>";
            }
            if (numeroProductos == null || numeroProductos.equals("")) {
                advertencia += "*numero de productos es requerido<br>";
            }

            if (!advertencia.equals("")) {
                formBean.setError("<span style='color:red'>Por favor complete los espacios vacios" + "<br>" + advertencia + "</span>");
                return mapping.findForward(AGREGAR);
            }
            FabricantesMantenimiento fabricantesMantenimiento = new FabricantesMantenimiento();
           
            String mensaje = "<span style='color:red'>Agregado Correcto" + "<br></span>";
            request.setAttribute("mensaje", mensaje);
           
           fabricantesMantenimiento.guardarFabricantes(0, nombreFabricante, descripcionFabricante, numeroProductos, fechaRegistroFabricante);
            List<Fabricantes> listaFabricantes = fabricantesMantenimiento.consultarTodosFabricantes();
            formBean.setListaFabricante(listaFabricantes);
           return mapping.findForward(LISTA);
        }
//----------------------------------------------------------------------
        if (action.equals("Modificar")) {
            FabricantesMantenimiento fabricantesMantenimiento = new FabricantesMantenimiento();

            Fabricantes fabricante = (Fabricantes) fabricantesMantenimiento.consultarFabricantesId(idFabricante );
           
                formBean.setIdFabricante(fabricante.getIdFabricante());
               formBean.setNombreFabricante(fabricante.getNombreFabricante());
                formBean.setNumeroProductos(fabricante.getNumeroProductos());
                formBean.setDescripcionFabricante(fabricante.getDescripcionFabricante());
                formBean.setFechaRegistroFabricante(fabricante.getFechaRegistroFabricante());
               
                return mapping.findForward(MODIFICAR);
            }
        //----------------------------------------------------------------------
           if (action.equals("Eliminar")) {
            FabricantesMantenimiento fabricantesMantenimiento = new FabricantesMantenimiento();
            fabricantesMantenimiento.eliminarFabricante(formBean.getIdFabricante());
            List<Fabricantes> listaFabricantes = fabricantesMantenimiento.consultarTodosFabricantes();
           
            formBean.setListaFabricante(listaFabricantes);
            System.out.println("desde eliminar");
            return mapping.findForward(LISTA);
         }
          //----------------------------------------------------------------------
           if (action.equals("Consultar")) {
            FabricantesMantenimiento fabricantesMantenimiento = new FabricantesMantenimiento();
            //Acceso acceso = new Acceso();
            List<Fabricantes> listaFabricantes = fabricantesMantenimiento.consultarTodosFabricantes();

            
                formBean.setListaFabricante(listaFabricantes);
                return mapping.findForward(LISTA);
            
              }
           if (action.equals("Actualizar")) {
               FabricantesMantenimiento fabricantesMantenimiento = new FabricantesMantenimiento();
               String mensaje = "<span style='color:red'>Actualizado Correcto" + "<br></span>";
            request.setAttribute("mensaje", mensaje);
           
           fabricantesMantenimiento.ActualizarFabricantes(idFabricante, nombreFabricante, numeroProductos, descripcionFabricante, fechaRegistroFabricante);
            List<Fabricantes> listaFabricantes = fabricantesMantenimiento.consultarTodosFabricantes();
            formBean.setListaFabricante(listaFabricantes);
           return mapping.findForward(LISTA);
           }
           //-------------------------------------------------------------------------------
           if (action.equals("irAgregar")) {
            IR = AGREGAR;
        }
//-------------------------------------------------------------------------------------           
             if (action.equals("Consultar2")) {
            Extraer e = new Extraer();
            //Acceso acceso = new Acceso();
            List<Fabricantes> listaFabricante = e.consultarTodosFabricantes2();

            
                formBean.setListaFabricante(listaFabricante);
                return mapping.findForward(LISTA2);
          
              }
              if (action.equals("fproductos")) {
            Extraer e = new Extraer();
            //Acceso acceso = new Acceso();
                  System.out.println(idFabricante);
            List<Productos> listaProductos = e.consultarTodoP(idFabricante);
                  System.out.println("esta es la lista"+listaProductos);
           List<Fabricantes> listaFabricante = e.consultarTodosFabricantes2();
           formBean.setListaFabricante(listaFabricante);
                formBean.setListaProductos(listaProductos);
                
                return mapping.findForward(LISTA2);
            
              }
             
          
return mapping.findForward(IR);
    }
}
