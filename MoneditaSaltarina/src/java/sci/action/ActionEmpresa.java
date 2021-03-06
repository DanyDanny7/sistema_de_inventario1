package sci.action;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import sci.actionforms.ActionFormEmpresa;
import sci.mantenimientos.EmpresaMantenimiento;
import metodos.Login;
import sci.persistencia.Empresa;

public class ActionEmpresa extends org.apache.struts.action.Action {

    private static final String LISTA = "irLista";
    private static final String INICIO = "irInicio";
    private static final String AGREGAR = "irAgregar";
    private static final String MODIFICAR = "irModificar";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ActionFormEmpresa fB = (ActionFormEmpresa) form;
        Integer idEmpresa = fB.getIdEmpresa();
        String nombreEmpresa = fB.getNombreEmpresa();
        String ncr = fB.getNcr();
        String nit = fB.getNit();
        String direccionEmpresa = fB.getDireccionEmpresa();
        String telefonoEmpresa = fB.getTelefonoEmpresa();
        String encargadoEmpresa = fB.getEncargadoEmpresa();
        String emailEmpresa = fB.getEmailEmpresa();
        String action = fB.getAction();

        EmpresaMantenimiento eman = new EmpresaMantenimiento();

        String IR = null;

        if (fB == null || action == null) {
            System.out.println("Error fromBean o Action estan null");
            IR = INICIO;
        }

//-------------------------------------------------------------------------------
        if (action.equals("Agregar")) {
            String adver = "";

            if (nombreEmpresa == null || nombreEmpresa.equals("")) {
                adver += "*Nombre de la empresa requerido.<br>";
            }
            if (ncr == null || ncr.equals("")) {
                adver += "*NCR de la empresa requerido.<br>";
            }
            if (nit == null || nit.equals("")) {
                adver += "*NIT de la empresa requerido.<br>";
            }
            if (direccionEmpresa == null || direccionEmpresa.equals("")) {
                adver += "*Direccion de la empresa requerido.<br>";
            }
            if (telefonoEmpresa == null || telefonoEmpresa.equals("")) {
                adver += "*Telefono de la empresa requerido.<br>";
            }
            if (encargadoEmpresa == null || encargadoEmpresa.equals("")) {
                adver += "*Encargado de la empresa requerido.<br>";
            }
            if (emailEmpresa == null || emailEmpresa.equals("")) {
                adver += "*Email de la empresa requerido.<br>";
            }
            if (!adver.equals("")) {
                fB.setError("<spam style = 'color: red' > Por favor complete los espacios requeridos " + " <br> " + adver + "</spam>");
                IR = AGREGAR;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("nAcceso", Login.id);
                return mapping.findForward(IR);
            }
            int vali = eman.consultarNombre(nombreEmpresa);
            if (vali != 1) {
                fB.setError("<spam style='color:red'>Ya existe un registro con ese Nombre, por favor ingrese otro" + " <br></span>");
                IR = AGREGAR;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("nAcceso", Login.id);
                return mapping.findForward(IR);
            }
            int val = eman.guardarEmpresa(nombreEmpresa, ncr, nit, direccionEmpresa, telefonoEmpresa, encargadoEmpresa, emailEmpresa);
            if (val != 1) {
                fB.setError("<spam style='color:red'>Sugio un error No se Guardó el Registro" + " <br></span>");
                IR = AGREGAR;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("nAcceso", Login.id);
                return mapping.findForward(IR);
            }
            List<Empresa> listaEmpresa = eman.consultarTodosEmpresa();
            fB.setListaEmpresa(listaEmpresa);
            IR = LISTA;
        }
//-------------------------------------------------------------------------------
        if (action.equals("ConsultarId")) {

            Empresa empresa = (Empresa) eman.consultarEmpresaId(idEmpresa);

            if (empresa == null) {
                fB.setError("<span style='color:red'>Error al consultar por Id " + "<br></span>");
                return mapping.findForward(AGREGAR);
            } else {

                fB.setIdEmpresa(empresa.getIdEmpresa());
                fB.setNombreEmpresa(empresa.getNombreEmpresa());
                fB.setNcr(empresa.getNcr());
                fB.setNit(empresa.getNit());
                fB.setDireccionEmpresa(empresa.getDireccionEmpresa());
                fB.setTelefonoEmpresa(empresa.getTelefonoEmpresa());
                fB.setEncargadoEmpresa(empresa.getEncargadoEmpresa());
                fB.setEmailEmpresa(empresa.getEmailEmpresa());
                IR = MODIFICAR;
            }
        }
//-------------------------------------------------------------------------------
        if (action.equals("Eliminar")) {
            eman.eliminarEmpresa(idEmpresa);
            List<Empresa> listaEmpresa = eman.consultarTodosEmpresa();
            fB.setListaEmpresa(listaEmpresa);
            fB.setError("<spam style = 'color: blue' > Registro (" + idEmpresa + ") Eliminado Correctamente <br></spam>");
            IR = LISTA;
        }
//-------------------------------------------------------------------------------
        if (action.equals("Consultar")) {
            List<Empresa> listaEmpresa = eman.consultarTodosEmpresa();
            fB.setListaEmpresa(listaEmpresa);
            IR = LISTA;
        }
//-------------------------------------------------------------------------------
        if (action.equals("Modificar")) {
            String adver = "";

            if (nombreEmpresa == null || nombreEmpresa.equals("")) {
                adver += "*Nombre de la empresa requerido.<br>";
            }
            if (ncr == null || ncr.equals("")) {
                adver += "*NCR de la empresa requerido.<br>";
            }
            if (nit == null || nit.equals("")) {
                adver += "*NIT de la empresa requerido.<br>";
            }
            if (direccionEmpresa == null || direccionEmpresa.equals("")) {
                adver += "*Direccion de la empresa requerido.<br>";
            }
            if (telefonoEmpresa == null || telefonoEmpresa.equals("")) {
                adver += "*Telefono de la empresa requerido.<br>";
            }
            if (encargadoEmpresa == null || encargadoEmpresa.equals("")) {
                adver += "*Encargado de la empresa requerido.<br>";
            }
            if (emailEmpresa == null || emailEmpresa.equals("")) {
                adver += "*Email de la empresa requerido.<br>";
            }
            if (!adver.equals("")) {
                fB.setError("<spam style = 'color: red' > Por favor complete los espacios requeridos " + " <br> " + adver + "</spam>");
                IR = MODIFICAR;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("nAcceso", Login.id);
                return mapping.findForward(IR);
            }
            eman.modificarEmpresa(idEmpresa, nombreEmpresa, ncr, nit, direccionEmpresa, telefonoEmpresa, encargadoEmpresa, emailEmpresa);
            List<Empresa> listaEmpresa = eman.consultarTodosEmpresa();
            fB.setListaEmpresa(listaEmpresa);
            fB.setError("<spam style='color:blue'>El registro se modificó correctamente" + " <br></span>");
            IR = LISTA;
        }

        request.setAttribute("nombre", Login.nombre);
        request.setAttribute("nAcceso", Login.nAcceso);
        request.setAttribute("id", Login.id);
        return mapping.findForward(IR);
    }
}
