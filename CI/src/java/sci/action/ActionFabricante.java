package sci.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metodos.Login;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import sci.actionforms.ActionFormFabricante;
import sci.mantenimientos.FabricantesMantenimiento;
import sci.persistencia.Fabricantes;

/**
 *
 * @author guillermo.bermudes
 */
public class ActionFabricante extends org.apache.struts.action.Action {

    private static final String AGREGAR = "irAgregarFabricantes";
    private static final String INICIO = "irInicioFabricantes";
    private static final String LISTA = "irListaFabricantes";
    private static final String MODIFICAR = "irModificarFabricantes";

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
        String fechaRegistroFabricante = formBean.getFechaRegistroFabricante();
        String action = formBean.getAction();
        String IR = null;

        FabricantesMantenimiento fabricantesMantenimiento = new FabricantesMantenimiento();

        if (formBean == null || action == null) {
            System.out.println("Error entre formBean o action null");
            IR = INICIO;
        }
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
                IR = AGREGAR;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                request.setAttribute("error", advertencia);
                return mapping.findForward(IR);
            }
            int validar = fabricantesMantenimiento.validarFabricantes(nombreFabricante);
            if (validar != 1) {
                String error = ("El Fabricante \"" + nombreFabricante + "\"Ya esta registrado");
                IR = AGREGAR;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                request.setAttribute("error", error);
                return mapping.findForward(IR);
            }

            fechaRegistroFabricante = formato.format(new Date());
            fabricantesMantenimiento.guardarFabricantes(0, nombreFabricante, descripcionFabricante, numeroProductos, fechaRegistroFabricante);
            List<Fabricantes> listaFabricantes = fabricantesMantenimiento.consultarTodosFabricantes();
            formBean.setListaFabricante(listaFabricantes);

            String mensaje = "El Fabricante \"" + nombreFabricante + "\" se agregó correctamente";
            request.setAttribute("mensaje", mensaje);
            IR = LISTA;
        }
//----------------------------------------------------------------------
        if (action.equals("Modificar")) {

            Fabricantes fabricante = (Fabricantes) fabricantesMantenimiento.consultarFabricantesId(idFabricante);

            formBean.setIdFabricante(fabricante.getIdFabricante());
            formBean.setNombreFabricante(fabricante.getNombreFabricante());
            formBean.setNumeroProductos(fabricante.getNumeroProductos());
            formBean.setDescripcionFabricante(fabricante.getDescripcionFabricante());
            formBean.setFechaRegistroFabricante(fabricante.getFechaRegistroFabricante());
            IR = MODIFICAR;
        }
        //----------------------------------------------------------------------
        if (action.equals("Eliminar")) {
            int n = fabricantesMantenimiento.eliminarFabricante(idFabricante);
            String mensaje = "";
            if (n == 0) {
                mensaje = (" Registro (" + idFabricante + ") No se Eliminó ");
                request.setAttribute("error", mensaje);
            } else {
                mensaje = (" Registro \"" + idFabricante + "\" Eliminado Correctamente ");
                request.setAttribute("mensaje", mensaje);
            }
            List<Fabricantes> listaFabricantes = fabricantesMantenimiento.consultarTodosFabricantes();
            formBean.setListaFabricante(listaFabricantes);
            IR = LISTA;
        }
        //----------------------------------------------------------------------
        if (action.equals("Consultar")) {
            List<Fabricantes> listaFabricantes = fabricantesMantenimiento.consultarTodosFabricantes();

            formBean.setListaFabricante(listaFabricantes);
            IR = LISTA;
        }
//-------------------------------------------------------------------------------------
        if (action.equals("Actualizar")) {
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
                IR = MODIFICAR;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                request.setAttribute("error", advertencia);
                return mapping.findForward(IR);
            }
            
            fabricantesMantenimiento.ActualizarFabricantes(idFabricante, nombreFabricante, numeroProductos, descripcionFabricante, fechaRegistroFabricante);
            List<Fabricantes> listaFabricantes = fabricantesMantenimiento.consultarTodosFabricantes();
            formBean.setListaFabricante(listaFabricantes);
            String mensaje = "El Contacto \""+nombreFabricante +"\" se modificó correctamente";
            request.setAttribute("mensaje", mensaje);
            IR = LISTA;
        }
        //-------------------------------------------------------------------------------
        if (action.equals("irAgregar")) {
            IR = AGREGAR;
        }
        request.setAttribute("nombre", Login.nombre);
        request.setAttribute("nAcceso", Login.nAcceso);
        request.setAttribute("id", Login.id);
        return mapping.findForward(IR);
    }
}
