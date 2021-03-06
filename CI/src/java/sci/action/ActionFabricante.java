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
private static final String INDEX = "irIndex";
    private static final String PORTADA = "irPortada";
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
        String fechaRegistroFabricante = formBean.getFechaRegistroFabricante();
        String action = formBean.getAction();
        String IR = null;
//--------------------------------------------------------
        FabricantesMantenimiento fabricantesMantenimiento = new FabricantesMantenimiento();
         if (Login.id == 0) {
            String mensaje = "Por Favor Inicie Session";
            request.setAttribute("mensaje", mensaje);
            return mapping.findForward(INDEX);
        }


//------------------------------------------------------
        if (action.equals("Agregar")) {
            if (Login.nAcceso.equals("Solo Consulta")) {
                String error = "No posee Acceso a esta opcion";
                request.setAttribute("error", error);
                IR = PORTADA;
            } else {
            String advertencia = "";

            if (nombreFabricante == null || nombreFabricante.equals("")) {
                advertencia = "*Nombre del fabricante es requerido<br>";
            }
            if (descripcionFabricante == null || descripcionFabricante.equals("")) {
                advertencia += "*descripcion es requerido<br>";
            }

            if (!advertencia.equals("")) {
                System.out.println("Entro");
                IR = AGREGAR;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                request.setAttribute("img", Login.img);
                request.setAttribute("error", advertencia);
                return mapping.findForward(IR);
            }

            int valFab = fabricantesMantenimiento.validarFabricantes(nombreFabricante);
            if (valFab != 1) {
                String error = ("Ya existe el fabricante\"" + nombreFabricante + "\",por favor ingrese otro.");

                IR = AGREGAR;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                request.setAttribute("img", Login.img);
                request.setAttribute("error", error);
                return mapping.findForward(IR);
            }
            fechaRegistroFabricante = formato.format(new Date());

            fabricantesMantenimiento.guardarFabricantes(0, nombreFabricante, descripcionFabricante, 0, fechaRegistroFabricante);
            List<Fabricantes> listaFabricantes = fabricantesMantenimiento.consultarTodosFabricantes();
            formBean.setListaFabricante(listaFabricantes);

            String mensaje = "El Contacto \"" + nombreFabricante + "\" se agregó correctamente";
            request.setAttribute("mensaje", mensaje);

            IR = LISTA;
        }}
//----------------------------------------------------------------------
        if (action.equals("Detalle")) {
if (Login.nAcceso.equals("Solo Consulta") || Login.nAcceso.equals("Consulta e Ingresar")) {
                String error = "No posee Acceso a esta opcion";
                request.setAttribute("error", error);
                IR = PORTADA;
            } else {
            Fabricantes fabricante = (Fabricantes) fabricantesMantenimiento.consultarFabricantesId(idFabricante);

            formBean.setIdFabricante(fabricante.getIdFabricante());
            formBean.setNombreFabricante(fabricante.getNombreFabricante());
            formBean.setNumeroProductos(0);
            formBean.setDescripcionFabricante(fabricante.getDescripcionFabricante());
            formBean.setFechaRegistroFabricante(fabricante.getFechaRegistroFabricante());

            IR = MODIFICAR;
        }}
//----------------------------------------------------------------------
        if (action.equals("Eliminar")) {
            if (Login.nAcceso.equals("Solo Consulta") || Login.nAcceso.equals("Consulta e Ingresar")) {
                String error = "No posee Acceso a esta opcion";
                request.setAttribute("error", error);
                IR = PORTADA;
            } else {
            String nombreF = fabricantesMantenimiento.consultarFabricantesId(idFabricante).getNombreFabricante();
            int n = fabricantesMantenimiento.eliminarFabricante(formBean.getIdFabricante());
            if (n == 0) {
                String error = (" Registro (" + nombreF + ") No se Eliminó ");
                request.setAttribute("error", error);
            } else {
                List<Fabricantes> listaFabricantes = fabricantesMantenimiento.consultarTodosFabricantes();
                formBean.setListaFabricante(listaFabricantes);

                String mensaje = (" Registro \"" + nombreF + "\" Eliminado Correctamente ");
                request.setAttribute("mensaje", mensaje);
            }
            List<Fabricantes> listaFabricantes = fabricantesMantenimiento.consultarTodosFabricantes();
            formBean.setListaFabricante(listaFabricantes);
            IR = LISTA;
        }}
//----------------------------------------------------------------------
        if (action.equals("Consultar")) {
            List<Fabricantes> listaFabricantes = fabricantesMantenimiento.consultarTodosFabricantes();
            formBean.setListaFabricante(listaFabricantes);
            IR = LISTA;

        }
//----------------------------------------------------------------------------------
        if (action.equals("Modificar")) {
if (Login.nAcceso.equals("Solo Consulta") || Login.nAcceso.equals("Consulta e Ingresar")) {
                String error = "No posee Acceso a esta opcion";
                request.setAttribute("error", error);
                IR = PORTADA;
            } else {
            String advertencia = "";

            if (nombreFabricante == null || nombreFabricante.equals("")) {
                advertencia = "*Nombre del fabricante es requerido<br>";
            }
            if (descripcionFabricante == null || descripcionFabricante.equals("")) {
                advertencia += "*descripcion es requerido<br>";
            }

            if (!advertencia.equals("")) {
                IR = MODIFICAR;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                request.setAttribute("img", Login.img);
                request.setAttribute("error", advertencia);
                return mapping.findForward(IR);
            }

            fabricantesMantenimiento.ActualizarFabricantes(idFabricante, nombreFabricante, 0, descripcionFabricante, fechaRegistroFabricante);
            List<Fabricantes> listaFabricantes = fabricantesMantenimiento.consultarTodosFabricantes();
            formBean.setListaFabricante(listaFabricantes);
            String mensaje = "<span style='color:red'>Actualizado Correcto" + "<br></span>";
            request.setAttribute("mensaje", mensaje);
            IR = LISTA;
        }}
//-------------------------------------------------------------------------------
        if (action.equals("irAgregar")) {
            if (Login.nAcceso.equals("Solo Consulta") ) {
                String error = "No posee Acceso a esta opcion";
                request.setAttribute("error", error);
                IR = PORTADA;
            } else {
            IR = AGREGAR;
        }}
//-------------------------------------------------------------------------------------           
        if (action.equals("Consultar2")) {
            Extraer e = new Extraer();
            //Acceso acceso = new Acceso();
            List<Fabricantes> listaFabricante = e.consultarTodosFabricantes2();

            formBean.setListaFabricante(listaFabricante);
            IR = LISTA2;

        }
//---------------------------------------------------------------------------------        
        if (action.equals("fproductos")) {
            if (Login.nAcceso.equals("Solo Consulta") || Login.nAcceso.equals("Consulta e Ingresar")) {
                String error = "No posee Acceso a esta opcion";
                request.setAttribute("error", error);
                IR = PORTADA;
            } else {
            Extraer e = new Extraer();
            System.out.println(idFabricante);
            List<Productos> listaProductos = e.consultarTodoP(idFabricante);
            System.out.println("esta es la lista" + listaProductos);
            List<Fabricantes> listaFabricante = e.consultarTodosFabricantes2();
            formBean.setListaFabricante(listaFabricante);
            formBean.setListaProductos(listaProductos);
            request.setAttribute("listaFabricante", listaFabricante);
            request.setAttribute("listaProductos", listaProductos);
            IR = LISTA2;
        }}
//-----------------------------------------------------------------------------------        
        request.setAttribute("nombre", Login.nombre);
        request.setAttribute("nAcceso", Login.nAcceso);
        request.setAttribute("id", Login.id);
        request.setAttribute("img", Login.img);
        return mapping.findForward(IR);

    }
}
