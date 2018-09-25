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
import sci.actionforms.ActionFormContactos;
import sci.mantenimientos.ContactosMantenimiento;
import sci.persistencia.Contactos;

public class ActionContactos extends org.apache.struts.action.Action {

    private static final String LISTA = "listaContactos";
    private static final String MODIFICAR = "irModificarContactos";
    private static final String AGREGAR = "irAgregarContactos";
    private static final String INICIO = "irInicioContactos";

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws java.lang.Exception {

        ActionFormContactos formBean = (ActionFormContactos) form;
        Integer idContacto = formBean.getIdContacto();
        String nombreContacto = formBean.getNombreContacto();
        String direccionContacto = formBean.getDireccionContacto();
        String telefonoContacto = formBean.getTelefonoContacto();
        String encargadoContacto = formBean.getEncargadoContacto();
        String telefonoEncargadoContacto = formBean.getTelefonoEncargadoContacto();
        String tipoContacto = formBean.getTipoContacto();
        String emailContacto = formBean.getEmailContacto();
        String fechaRegistroContacto = formBean.getFechaRegistroContacto();

        String action = formBean.getAction();

        ContactosMantenimiento contactosMantenimiento = new ContactosMantenimiento();

        String IR = null;

        if (formBean == null || action == null) {
            System.out.println("Error entre formBean o action null");
            IR = INICIO;
        }

//------------------------------------------------------
        if (action.equals("Agregar")) {
            String advertencia = "";

            if (nombreContacto == null || nombreContacto.equals("")) {
                advertencia += "*Nombre del Contacto es requerido    <br> ";
            }
            if (direccionContacto == null || direccionContacto.equals("")) {
                advertencia += "*Direccion del Contacto es requerido    <br> ";
            }
            if (telefonoContacto == null || telefonoContacto.equals("")) {
                advertencia += "* Telefono del Contacto es requerido    <br> ";
            }
            if (encargadoContacto == null || encargadoContacto.equals("")) {
                advertencia += "*Nombre del encargado es requerido   <br> ";
            }
            if (telefonoEncargadoContacto == null || telefonoEncargadoContacto.equals("")) {
                advertencia += "*Telefono del encargado es requerido    <br> ";
            }
            if (emailContacto == null || emailContacto.equals("")) {
                advertencia += "*Email del Contacto es requerido    <br> ";
            }
            if (tipoContacto == null || tipoContacto.equals("Seleccionar")) {
                advertencia += "*Es requerido que seleccione un tipo de Contacto    <br> ";
            }
            if (!advertencia.equals("")) {
                IR = AGREGAR;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                request.setAttribute("error", advertencia);
                return mapping.findForward(IR);
            }

            int validacion = contactosMantenimiento.validar(nombreContacto);
            if (validacion != 1) {
                String error = ("<span style='color:red'>El Contacto \"" + nombreContacto + "\" ya esta registrado..." + "<br></span>");
                IR = AGREGAR;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                request.setAttribute("error", error);
                return mapping.findForward(IR);
            }
            fechaRegistroContacto = formato.format(new Date());
            contactosMantenimiento.guardarContacto(nombreContacto, direccionContacto, tipoContacto, telefonoContacto, emailContacto, encargadoContacto, telefonoEncargadoContacto, fechaRegistroContacto);
            List<Contactos> listaContacto = contactosMantenimiento.consultarTodosContactos();
            formBean.setListaContacto(listaContacto);
            String codigo = "<ul class=\"nav nav-tabs\"><li class=\"nav-item \" ><a class=\"nav-link active\"style=\"background-color: #000;color: white \" href=\"contactosMantenimiento.do?action=Consultar\">todo</a>\n"
                    + "</li><li class=\"nav-item\"><a class=\"nav-link\" style=\"color: white;\" href=\"contactosMantenimiento.do?action=ConsultarTipo&tipoContacto=Cliente\">\n"
                    + "Clientes</a></li><li class=\"nav-item\"><a class=\"nav-link\" style=\"color: white;\" href=\"contactosMantenimiento.do?action=ConsultarTipo&tipoContacto=Proveedor\">\n"
                    + "Proveedores</a></li></ul>";
            request.setAttribute("codigo", codigo);
            String mensaje = "El Contacto \""+nombreContacto +"\" se agregó correctamente";
            request.setAttribute("mensaje", mensaje);
            IR = LISTA;
        }

//---------------------------------------------------------------------        
        if (action.equals("ConsultarId")) {
            Contactos contactos = (Contactos) contactosMantenimiento.consultarContactosId(idContacto);

            if (contactos == null) {

                formBean.setError("<span style='color:red'>Nose puede consultar por IdContacto " + "<br></span>");

                return mapping.findForward(AGREGAR);
            } else {
                formBean.setIdContacto(contactos.getIdContacto());
                formBean.setNombreContacto(contactos.getNombreContacto());
                formBean.setDireccionContacto(contactos.getDireccionContacto());
                formBean.setTelefonoContacto(contactos.getTelefonoContacto());
                formBean.setEncargadoContacto(contactos.getEncargadoContacto());
                formBean.setTelefonoEncargadoContacto(contactos.getTelefonoEncargadoContacto());
                formBean.setTipoContacto(contactos.getTipoContacto());
                formBean.setEmailContacto(contactos.getEmailContacto());
                System.out.println("action " + contactos.getFechaRegistroContacto());
                formBean.setFechaRegistroContacto(contactos.getFechaRegistroContacto());

                IR = MODIFICAR;
            }
        }
//--------------------------------------------------------------------        
        if (action.equals("Eliminar")) {
            int n = contactosMantenimiento.eliminarContactos(idContacto);
            String mensaje = "";
            if (n == 0) {
                mensaje = (" Registro (" + idContacto + ") No se Eliminó ");
                request.setAttribute("error", mensaje);
            } else {
                List<Contactos> listaContacto = contactosMantenimiento.consultarTodosContactos();
                formBean.setListaContacto(listaContacto);
                String codigo = "<ul class=\"nav nav-tabs\"><li class=\"nav-item \" ><a class=\"nav-link active\" style=\"background-color: #000;color: white \" href=\"contactosMantenimiento.do?action=Consultar\">Todo</a>\n"
                    + "</li><li class=\"nav-item\"><a class=\"nav-link\" style=\"color: white;\" href=\"contactosMantenimiento.do?action=ConsultarTipo&tipoContacto=Cliente\">\n"
                    + "Clientes</a></li><li class=\"nav-item\"><a class=\"nav-link\" style=\"color: white;\" href=\"contactosMantenimiento.do?action=ConsultarTipo&tipoContacto=Proveedor\">\n"
                    + "Proveedores</a></li></ul>";
            request.setAttribute("codigo", codigo);
                mensaje = (" Registro \"" + idContacto + "\" Eliminado Correctamente ");
                request.setAttribute("mensaje", mensaje);
            }
            IR = LISTA;
        }
//------------------------------------------------------------------------------       
        if (action.equals("Modificar")) {

            String advertencia = "";

            if (nombreContacto == null || nombreContacto.equals("")) {
                advertencia += "*Nombre del Contacto es requerido <br>";
            }
            if (direccionContacto == null || direccionContacto.equals("")) {
                advertencia += "*Direccion del Contacto es requerido <br>";
            }
            if (telefonoContacto == null || telefonoContacto.equals("")) {
                advertencia += "* Telefono del Contacto es requerido <br>";
            }
            if (encargadoContacto == null || encargadoContacto.equals("")) {
                advertencia += "*Nombre del encargado es requerida <br>";
            }
            if (telefonoEncargadoContacto == null || telefonoEncargadoContacto.equals("")) {
                advertencia += "*Telefono del encargado es requerido <br>";
            }
            if (emailContacto == null || emailContacto.equals("")) {
                advertencia += "*Email del Contacto es requerido <br>";
            }
            if (tipoContacto == null || tipoContacto.equals("Seleccionar")) {
                advertencia += "*Es requerido que seleccione un tipo de Contacto <br>";
            }
            if (!advertencia.equals("")) {
                IR = MODIFICAR;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                request.setAttribute("error", advertencia);
                return mapping.findForward(IR);
            }
            contactosMantenimiento.modificarContacto(idContacto, nombreContacto, direccionContacto, tipoContacto, telefonoContacto, emailContacto, encargadoContacto, telefonoEncargadoContacto, fechaRegistroContacto);
            List<Contactos> listaContacto = contactosMantenimiento.consultarTodosContactos();
            formBean.setListaContacto(listaContacto);
            formBean.setError("<spam style='color:blue'>El registro se modificó correctamente" + " <br></span>");
            String codigo = "<ul class=\"nav nav-tabs\"><li class=\"nav-item \" ><a class=\"nav-link active\" style=\"background-color: #000;color: white \" href=\"contactosMantenimiento.do?action=Consultar\">Todo</a>\n"
                    + "</li><li class=\"nav-item\"><a class=\"nav-link\" style=\"color: white;\" href=\"contactosMantenimiento.do?action=ConsultarTipo&tipoContacto=Cliente\">\n"
                    + "Clientes</a></li><li class=\"nav-item\"><a class=\"nav-link\" style=\"color: white;\" href=\"contactosMantenimiento.do?action=ConsultarTipo&tipoContacto=Proveedor\">\n"
                    + "Proveedores</a></li></ul>";
            request.setAttribute("codigo", codigo);
            String mensaje = "El Contacto \""+nombreContacto +"\" se modificó correctamente";
            request.setAttribute("mensaje", mensaje);
            IR = LISTA;

        }
//------------------------------------------------------------------------------
        if (action.equals("Consultar")) {
            List<Contactos> listaContacto = contactosMantenimiento.consultarTodosContactos();
            if (listaContacto == null) {
                formBean.setMensaje("<span style='color:red'>La lista esta vacia." + "<br></span>");
                String codigo = "<ul class=\"nav nav-tabs\"><li class=\"nav-item \" ><a class=\"nav-link active\" style=\"background-color: #000; href=\"contactosMantenimiento.do?action=Consultar\">Todo</a>\n"
                        + "</li><li class=\"nav-item\"><a class=\"nav-link\" style=\"color: black;\" href=\"contactosMantenimiento.do?action=ConsultarTipo&tipoContacto=Cliente\">\n"
                        + " Clientes</a></li><li class=\"nav-item\"><a class=\"nav-link\" style=\"color: black;\" href=\"contactosMantenimiento.do?action=ConsultarTipo&tipoContacto=Proveedor\">\n"
                        + "Proveedores</a></li></ul>";
                request.setAttribute("codigo", codigo);
                IR = LISTA;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                return mapping.findForward(IR);
            } else {
                formBean.setListaContacto(listaContacto);
                String codigo = "<ul class=\"nav nav-tabs\" ><li class=\"nav-item \" ><a class=\"nav-link active\" style=\"background-color: #000; color: white \" href=\"contactosMantenimiento.do?action=Consultar\">"
                        + "Todo</a></li><li class=\"nav-item\"><a class=\"nav-link\" style=\"color: white;\" href=\"contactosMantenimiento.do?action=ConsultarTipo&tipoContacto=Cliente\">\n"
                        + "Clientes</a></li><li class=\"nav-item\"><a class=\"nav-link\" style=\"color: white;\" href=\"contactosMantenimiento.do?action=ConsultarTipo&tipoContacto=Proveedor\">\n"
                        + "Proveedores</a></li></ul>";
                request.setAttribute("codigo", codigo);
                IR = LISTA;
            }
        }
//------------------------------------------------------------------------------       
        if (action.equals("ConsultarTipo")) {
            ContactosMantenimiento cman = new ContactosMantenimiento();
            tipoContacto = request.getParameter("tipoContacto");
            cman.tipos(tipoContacto);
            String codigo = "";
            if (tipoContacto.equals("Cliente")) {
                codigo = "<ul class=\"nav nav-tabs\" ><li class=\"nav-item \" ><a class=\"nav-link \" style=\"color: white;\" href=\"contactosMantenimiento.do?action=Consultar\">Todo</a>\n"
                        + "</li><li class=\"nav-item\"><a class=\"nav-link active\" style=\"background-color: #000; color: white \" href=\"contactosMantenimiento.do?action=ConsultarTipo&tipoContacto=Cliente\">\n"
                        + "Clientes</a></li><li class=\"nav-item\"><a class=\"nav-link\" style=\"color: white;\" href=\"contactosMantenimiento.do?action=ConsultarTipo&tipoContacto=Proveedor\">\n"
                        + "Proveedores</a></li></ul>";
            }
            if (tipoContacto.equals("Proveedor")) {
                codigo = "<ul class=\"nav nav-tabs\"><li class=\"nav-item \" ><a class=\"nav-link\" style=\"color: white;\" href=\"contactosMantenimiento.do?action=Consultar\">Todo</a>\n"
                        + "</li><li class=\"nav-item\"><a class=\"nav-link\" style=\"color: white;\" href=\"contactosMantenimiento.do?action=ConsultarTipo&tipoContacto=Cliente\">\n"
                        + "Clientes</a></li><li class=\"nav-item\"><a class=\"nav-link active\" style=\"background-color: #000; color: white \" href=\"contactosMantenimiento.do?action=ConsultarTipo&tipoContacto=Proveedor\">\n"
                        + "Proveedores</a></li></ul>";
            }

            request.setAttribute("codigo", codigo);
            List<Contactos> listaContacto = cman.tipos(tipoContacto);
            formBean.setListaContacto(listaContacto);

            IR = LISTA;
        }
//--------------------------------------------------------------------------------
        if (action.equals("irAgregar")) {
            IR = AGREGAR;
        }
        request.setAttribute("nombre", Login.nombre);
        request.setAttribute("nAcceso", Login.nAcceso);
        request.setAttribute("id", Login.id);
        return mapping.findForward(IR);

    }

}
