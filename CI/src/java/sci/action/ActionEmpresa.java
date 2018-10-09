package sci.action;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metodos.Estaticas;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import sci.actionforms.ActionFormEmpresa;
import sci.mantenimientos.EmpresaMantenimiento;
import metodos.Login;
import sci.actionforms.ActionFormAcceso;
import sci.mantenimientos.Extraer;
import sci.persistencia.Empresa;

public class ActionEmpresa extends org.apache.struts.action.Action {
private static final String INDEX = "irIndex";
    private static final String PORTADA = "irPortada";
    private static final String LISTA = "irListaEmpresa";
    private static final String INICIO = "irInicioEmpresa";
    private static final String AGREGAR = "irAgregarEmpresa";
    private static final String MODIFICAR = "irModificarEmpresa";
    private static final String ACCESO = "irAcceso";

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

        System.out.println("El Valor de Action es = " + action);

        if (Login.id == 0) {
            String mensaje = "Por Favor Inicie Session";
            request.setAttribute("mensaje", mensaje);
            return mapping.findForward(INDEX);
        }

//-------------------------------------------------------------------------------
        /*List<Empresa> listas = eman.consultarTodosEmpresa();
        if (listas.size()>0) {
            String error = ("YA EXISTE CONFIGURACION CREADA");
            System.out.println("YAAAAA");
            request.setAttribute("error", error);
        IR = PORTADA; 
        request.setAttribute("nombre", Login.nombre);
        request.setAttribute("nAcceso", Login.nAcceso);
        request.setAttribute("id", Login.id);
        return mapping.findForward(IR);
        }     */
        if (action.equals("Siguiente")) {

            Extraer ex = new Extraer();
            List<Integer> lista = ex.maxIdEmpresa();
            idEmpresa = lista.get(0);
            idEmpresa = idEmpresa + 1;

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
                request.setAttribute("id", Login.id);
                request.setAttribute("img", Login.img);
                request.setAttribute("error", adver);
                return mapping.findForward(IR);
            }

            int val = eman.guardarEmpresa(nombreEmpresa, ncr, nit, direccionEmpresa, telefonoEmpresa, encargadoEmpresa, emailEmpresa);
            if (val != 1) {
                String error = ("Surgio un error No se Guardó la empresa\"" + nombreEmpresa);
                IR = AGREGAR;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                request.setAttribute("img", Login.img);
                request.setAttribute("error", error);
                return mapping.findForward(IR);
            }

            Estaticas.idEmpresa = idEmpresa;
            Estaticas.nombreEmpresa = nombreEmpresa;

            request.setAttribute("idEmpresa", Estaticas.idEmpresa);
            request.setAttribute("nombreEmpresa", Estaticas.nombreEmpresa);
            IR = ACCESO;
        }
//-------------------------------------------------------------------------------
        if (action.equals("Detalle")) {

            Empresa empresa = (Empresa) eman.consultarEmpresaId(idEmpresa);

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
//-------------------------------------------------------------------------------
        if (action.equals("Eliminar")) {
            String nombreE = eman.consultarEmpresaId(idEmpresa).getNombreEmpresa();
            int n = eman.eliminarEmpresa(idEmpresa);
            if (n == 0) {
                String error = (" Registro \"" + nombreE + "\" No se ha Eliminado Correctamente ");
                request.setAttribute("error", error);
            } else {
                List<Empresa> listaEmpresas = eman.consultarTodosEmpresa();
                fB.setListaEmpresa(listaEmpresas);

                String mensaje = (" Registro \"" + nombreE + "\" Eliminado Correctamente ");
                request.setAttribute("mensaje", mensaje);
            }
            List<Empresa> listaEmpresas = eman.consultarTodosEmpresa();
            fB.setListaEmpresa(listaEmpresas);

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
                IR = MODIFICAR;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                request.setAttribute("img", Login.img);
                request.setAttribute("error", adver);
                return mapping.findForward(IR);
            }
            eman.modificarEmpresa(idEmpresa, nombreEmpresa, ncr, nit, direccionEmpresa, telefonoEmpresa, encargadoEmpresa, emailEmpresa);
            List<Empresa> listaEmpresa = eman.consultarTodosEmpresa();
            fB.setListaEmpresa(listaEmpresa);
            String mensaje = "La Empresa \"" + nombreEmpresa + "\" se modificó correctamente";
            request.setAttribute("mensaje", mensaje);
            IR = LISTA;
        }
//------------------------------------------------------------------------------------
        if (action.equals("irAgregar")) {

            Empresa empresa = eman.consultarEmpresaId(1);

            if (null != empresa) {
                String info = "Configuracion ya realizada por Favor Inicie Session.";
                request.setAttribute("info", info);
                IR = INDEX;
            } else {
                String info = "Por Favor Inicie Session. ";
                request.setAttribute("info", info);
                IR = AGREGAR;
            }

        }

        request.setAttribute("nombre", Login.nombre);
        request.setAttribute("nAcceso", Login.nAcceso);
        request.setAttribute("id", Login.id);
        request.setAttribute("img", Login.img);
        return mapping.findForward(IR);
    }
}
