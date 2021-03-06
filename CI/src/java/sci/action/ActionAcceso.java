package sci.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metodos.Estaticas;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import sci.actionforms.ActionFormAcceso;
import sci.mantenimientos.AccesoMantenimiento;
import sci.mantenimientos.EmpresaMantenimiento;
import metodos.Login;
import sci.mantenimientos.ConfiguracionMantenimiento;
import sci.mantenimientos.MonedaMantenimiento;
import sci.persistencia.Acceso;
import sci.persistencia.Empresa;
import sci.persistencia.Moneda;

public class ActionAcceso extends org.apache.struts.action.Action {
    

    private static final String INDEX = "irIndex";
    private static final String LISTA = "irListaAcceso";
    private static final String PORTADA = "irPortada";
    private static final String INICIO = "irInicioAcceso";
    private static final String AGREGAR = "irAgregarAcceso";
    private static final String MODIFICAR = "irModificarAcceso";
    private static final String PERFIL = "irPerfil";
    private static final String AYUDA = "irAyuda2Acceso";
    private static final String CONF = "viajando";
    private static final String ACCESO2 = "irAcceso2";

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionFormAcceso formBean = (ActionFormAcceso) form;
        Integer idAcceso = formBean.getIdAcceso();
        Integer idEmpresa = formBean.getIdEmpresa();
        String nombreAcceso = formBean.getNombreAcceso();
        String apellidoAcceso = formBean.getApellidoAcceso();
        String usuario = formBean.getUsuario();
        String contrasena = formBean.getContrasena();
        String eMail = formBean.geteMail();
        String tipoAcceso = formBean.getTipoAcceso();
        String fechaRegistroAcceso = formBean.getFechaRegistroAcceso();
        String action = formBean.getAction();

        AccesoMantenimiento aman = new AccesoMantenimiento();
        EmpresaMantenimiento eman = new EmpresaMantenimiento();
        ConfiguracionMantenimiento cman = new ConfiguracionMantenimiento();

        String IR = null;

        //----------------------------------------------------------------------
        if (action.equals("Agregar")) {
            if (!Login.nAcceso.equals("Super Administrador")) {
                String error = "No posee Acceso a esta opcion";
                request.setAttribute("error", error);
                IR = PORTADA;
            } else {
            System.out.println("HOLA MUNDO");
            String advertencia = "";

            if (idEmpresa == null || idEmpresa.equals("") || idEmpresa.equals("Seleccionar")) {
                advertencia += "*Empresa es requerida <br>";
            }
            if (nombreAcceso == null || nombreAcceso.equals("")) {
                advertencia += "*El Nombre es requerido <br>";
            }
            if (apellidoAcceso == null || apellidoAcceso.equals("")) {
                advertencia += "*El Apellido es requerido <br>";
            }
            if (usuario == null || usuario.equals("")) {
                advertencia += "*Es requerido un Usuario <br>";
            }
            if (contrasena == null || contrasena.equals("")) {
                advertencia += "*Es requerido una Contraseña <br>";
            }
            if (eMail == null || eMail.equals("")) {
                advertencia += "*Es requerido un Email <br>";
            }
            if (tipoAcceso == null || tipoAcceso.equals("") || tipoAcceso.equals("Seleccionar")) {
                advertencia += "*Es requerido seleccione un Nivel de Acceso <br>";
            }
            if (!advertencia.equals("")) {
                String error = ("Por favor complete los espacios requeridos " + " <br> " + advertencia );
                List<Empresa> listaEmpresa = eman.consultarTodosEmpresa();
                formBean.setListaEmpresa(listaEmpresa);
                request.setAttribute("listaEmpresa", listaEmpresa);
                IR = AGREGAR;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                request.setAttribute("img", Login.img);
                request.setAttribute("error", error);
                return mapping.findForward(IR);
            }
            int valUsuario = aman.consultarUsuario(usuario);
            if (valUsuario != 1) {
                String error = ("Ya existe un registro con el usuario \"" + usuario + "\", por favor elija otro ");
                List<Empresa> listaEmpresa = eman.consultarTodosEmpresa();
                formBean.setListaEmpresa(listaEmpresa);
                request.setAttribute("listaEmpresa", listaEmpresa);

                IR = AGREGAR;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                request.setAttribute("img", Login.img);
                request.setAttribute("error", error);
                return mapping.findForward(IR);
            }
            fechaRegistroAcceso = formato.format(new Date());

            int val = aman.guardarAcceso(idEmpresa, nombreAcceso, apellidoAcceso, usuario, fechaRegistroAcceso, contrasena, eMail, tipoAcceso);
            if (val != 1) {
                formBean.setError("<spam style='color:red'>Sugio un error No se Guardó el Registro" + " <br></span>");
                List<Empresa> listaEmpresa = eman.consultarTodosEmpresa();
                formBean.setListaEmpresa(listaEmpresa);
                request.setAttribute("listaEmpresa", listaEmpresa);
                IR = AGREGAR;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                request.setAttribute("img", Login.img);
                return mapping.findForward(IR);
            }
            List<Acceso> listaAcceso = aman.consultarTodoAcceso();
            formBean.setListaAcceso(listaAcceso);
            String mensaje = ("El registro \"" + nombreAcceso + "\" se Agregó correctamente ");
            request.setAttribute("mensaje", mensaje);
            IR = LISTA;
        } }
//----------------------------------------------------------------------------------        
        if (action.equals("Siguiente")) {
            System.out.println("HOLA TIERRA");
            String advertencia = "";

            if (idEmpresa == null || idEmpresa.equals("")) {
                advertencia += "*Empresa es requerida <br>";
            }
            if (nombreAcceso == null || nombreAcceso.equals("")) {
                advertencia += "*El Nombre es requerido <br>";
            }
            if (apellidoAcceso == null || apellidoAcceso.equals("")) {
                advertencia += "*El Apellido es requerido <br>";
            }
            if (usuario == null || usuario.equals("")) {
                advertencia += "*Es requerido un Usuario <br>";
            }
            if (contrasena == null || contrasena.equals("")) {
                advertencia += "*Es requerido una Contraseña <br>";
            }
            if (eMail == null || eMail.equals("")) {
                advertencia += "*Es requerido un Email <br>";
            }
            if (tipoAcceso == null || tipoAcceso.equals("") || tipoAcceso.equals("Seleccionar")) {
                advertencia += "*Es requerido seleccione un Nivel de Acceso <br>";
            }
            if (!advertencia.equals("")) {

                IR = ACCESO2;

                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                request.setAttribute("img", Login.img);
                request.setAttribute("idEmpresa", Estaticas.idEmpresa);
                request.setAttribute("nombreEmpresa", Estaticas.nombreEmpresa);
                request.setAttribute("error", advertencia);
                System.out.println("Entra a 2");
                return mapping.findForward(IR);
            }
            int valUsuario = aman.consultarUsuario(usuario);
            if (valUsuario != 1) {
                String error = ("Ya existe un registro con el usuario \"" + usuario + "\", por favor elija otro ");

                IR = ACCESO2;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                request.setAttribute("img", Login.img);
                request.setAttribute("idEmpresa", Estaticas.idEmpresa);
                request.setAttribute("nombreEmpresa", Estaticas.nombreEmpresa);
                request.setAttribute("error", error);
                System.out.println("Entra a 3");
                return mapping.findForward(IR);
            }
            fechaRegistroAcceso = formato.format(new Date());

            int val = aman.guardarAcceso(idEmpresa, nombreAcceso, apellidoAcceso, usuario, fechaRegistroAcceso, contrasena, eMail, tipoAcceso);
            //Login.id=1;
            //Login.nombre=aman.consultarAccesoId(1).getNombreAcceso();
            if (val != 1) {
                String error = ("Sugio un error No se Guardó el Registro" + nombreAcceso);
                IR = ACCESO2;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                request.setAttribute("img", Login.img);
                request.setAttribute("idEmpresa", Estaticas.idEmpresa);
                request.setAttribute("nombreEmpresa", Estaticas.nombreEmpresa);
                request.setAttribute("error", error);
                System.out.println("Entra a 4");
                return mapping.findForward(IR);
            }

            MonedaMantenimiento mman = new MonedaMantenimiento();
            List<Moneda> listaMoneda = mman.consultarTodosMoneda();
            formBean.setListaMoneda(listaMoneda);
            request.setAttribute("listaMoneda", listaMoneda);
            System.out.println("listaMoneda " + listaMoneda.toString());

            request.setAttribute("idEmpresa", Estaticas.idEmpresa);
            request.setAttribute("nombreEmpresa", Estaticas.nombreEmpresa);
            request.setAttribute("nAcceso", Login.id);
            request.setAttribute("nombre", Login.nombre);

            System.out.println("Entra a 5");

            IR = CONF;
        }
        //----------------------------------------------------------------------
        if (action.equals("Detalle")) {
            if (!Login.nAcceso.equals("Super Administrador")) {
                String error = "No posee Acceso a esta opcion";
                request.setAttribute("error", error);
                IR = PORTADA;
            } else {
            Acceso acceso = (Acceso) aman.consultarAccesoId(idAcceso);

            formBean.setIdAcceso(acceso.getIdAcceso());
            formBean.setIdEmpresa(acceso.getEmpresa().getIdEmpresa());
            formBean.setNombreAcceso(acceso.getNombreAcceso());
            formBean.setApellidoAcceso(acceso.getApellidoAcceso());
            formBean.setUsuario(acceso.getUsuario());
            formBean.setContrasena(acceso.getContrasena());
            formBean.seteMail(acceso.getEmail());
            request.setAttribute("tipoAcceso", acceso.getTipoAcceso());
            formBean.setFechaRegistroAcceso(acceso.getFechaRegistroAcceso());
            List<Empresa> listaEmpresa = eman.consultarTodosEmpresa();
            formBean.setListaEmpresa(listaEmpresa);
            request.setAttribute("listaEmpresa", listaEmpresa);
            IR = MODIFICAR;

        }}
        //----------------------------------------------------------------------
        if (action.equals("Eliminar")) {
            if (!Login.nAcceso.equals("Super Administrador")) {
                String error = "No posee Acceso a esta opcion";
                request.setAttribute("error", error);
                IR = PORTADA;
            } else {
            int n = aman.eliminarAcceso(idAcceso);
            String mensaje = "";
            if (n == 0) {
                mensaje = (" Registro (" + idAcceso + ") No se Eliminó ");
                request.setAttribute("error", mensaje);
            } else {
                List<Acceso> listaAcceso = aman.consultarTodoAcceso();
                formBean.setListaAcceso(listaAcceso);

                mensaje = (" Registro \"" + idAcceso + "\" Eliminado Correctamente ");
                request.setAttribute("mensaje", mensaje);
            }
            IR = LISTA;

        }}
        //----------------------------------------------------------------------
        if (action.equals("Login")) {

            Acceso acceso = new Acceso();
            int validar = aman.loginAcceso(usuario, contrasena);
            if (validar != 0) {
                int id = aman.loginId(usuario, contrasena);
                Login.id = aman.consultarAccesoId(id).getIdAcceso();
                Login.nombre = aman.consultarAccesoId(id).getNombreAcceso();
                Login.nAcceso = aman.consultarAccesoId(id).getTipoAcceso();
                Login.user = aman.consultarAccesoId(id).getUsuario();

                String nameImg = cman.consultarConfiguarionId(1).getZonaHoraria();
                //Login.img = "<html:img src=\"img/upload/"+nameImg+"\" width=\"40\" height=\"40\"/>";
                Login.img = "<img src=\"img/upload/" + nameImg + "\" width=\"50\" height=\"50\"/>";

                IR = PORTADA;

            } else {
                formBean.setError("<spam style='color:white'> El Usuario o la contraseña son incorrectos. ");
                String mensaje = "Usuario o Contraseña Incorrectos";

                request.setAttribute("mensaje", mensaje);
                IR = INDEX;
            }
        }
        //-------------------------------------------------------------------------
        if (action.equals("Consultar")) {
            if (!Login.nAcceso.equals("Super Administrador")) {
                String error = "No posee Acceso a esta opcion";
                request.setAttribute("error", error);
                IR = PORTADA;
            } else {
        
            List<Acceso> listaAcceso = aman.consultarTodoAcceso();
            formBean.setListaAcceso(listaAcceso);
            IR = LISTA;

        }}
        //---------------------------------------------------------------------------
        if (action.equals("Cerrar Session")) {
            Login.id = 0;
            Login.nombre = "";
            Login.nAcceso = "";
            Login.user = "";
            Login.img = "";
            IR = INDEX;
            
        }
        //---------------------------------------------------------------------------
        if (action.equalsIgnoreCase("Modificar")) {
            if (!Login.nAcceso.equals("Super Administrador")) {
                String error = "No posee Acceso a esta opcion";
                request.setAttribute("error", error);
                IR = PORTADA;
            } else {
            String advertencia = "";

            if (idEmpresa == null || idEmpresa.equals("") || idEmpresa.equals("Seleccionar")) {
                advertencia += "*Empresa es requerida <br>";
            }
            if (nombreAcceso == null || nombreAcceso.equals("")) {
                advertencia += "*El Nombre es requerido <br>";
            }
            if (apellidoAcceso == null || apellidoAcceso.equals("")) {
                advertencia += "*El Apellido es requerido <br>";
            }
            if (usuario == null || usuario.equals("")) {
                advertencia += "*Es requerido un Usuario <br>";
            }
            if (contrasena == null || contrasena.equals("")) {
                advertencia += "*Es requerido una Contraseña <br>";
            }
            if (eMail == null || eMail.equals("")) {
                advertencia += "*Es requerido un Email <br>";
            }
            if (tipoAcceso == null || tipoAcceso.equals("") || tipoAcceso.equals("Seleccionar")) {
                advertencia += "*Es requerido seleccione un Nivel de Acceso <br>";
            }
            if (!advertencia.equals("")) {
                formBean.setError("<spam style = 'color: red' > Por favor complete los espacios requeridos " + " <br> " + advertencia + "</spam>");
                List<Empresa> listaEmpresa = eman.consultarTodosEmpresa();
                formBean.setListaEmpresa(listaEmpresa);
                request.setAttribute("listaEmpresa", listaEmpresa);

                IR = MODIFICAR;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                request.setAttribute("img", Login.img);
                request.setAttribute("error", advertencia);
                return mapping.findForward(IR);
            }
            aman.modificarAcceso(idAcceso, idEmpresa, nombreAcceso, apellidoAcceso, usuario, fechaRegistroAcceso, contrasena, eMail, tipoAcceso);
            List<Acceso> listaAcceso = aman.consultarTodoAcceso();
            formBean.setListaAcceso(listaAcceso);
            String mensaje = ("El registro \"" + nombreAcceso + "\" se modificó correctamente ");
            request.setAttribute("mensaje", mensaje);
            IR = LISTA;
            
        }}
        //----------------------------------------------------------------------------------
        if (action.equalsIgnoreCase("Restaurar")) {
            tipoAcceso = aman.ayudaUsuario(usuario);
            if (tipoAcceso.equals("Super Administrador")) {

                List<Acceso> listaAcceso = aman.consultarTipo();
                formBean.setListaAcceso(listaAcceso);
                formBean.setUsuario(usuario);
                formBean.setError("BEBo");
                formBean.setMensaje("<spam style='color:black'>Para restauracion de contraseña para usuarios "
                        + "con nivel de acceso de (Super Administrador), se solicita revise el manual del producto "
                        + "para encontrar el usuario (Super Administrador) por defecto; Sí no posee dicho documento a contiuacion "
                        + "se le presenta una lista de los usuarios con nivel de acceso de (Super Administrador) con los que puede "
                        + "ponerse en contacto. " + " <br></span><br><br>");
                IR = AYUDA;
            }
            List<Acceso> listaAcceso = aman.consultarTipo();
            formBean.setListaAcceso(listaAcceso);
            formBean.setMensaje("<spam style='color:black'>Para restauracion de contraseña "
                    + "se le presenta una lista de los usuarios con nivel de acceso suficiente  con los que puede "
                    + "ponerse en contacto. " + " <br></span><br><br>");
            IR = AYUDA;
        }
        //--------------------------------------------------------------------------------
        if (action.equalsIgnoreCase("Agregar Nuevo")) {
            List<Empresa> listaEmpresa = eman.consultarTodosEmpresa();
            formBean.setListaEmpresa(listaEmpresa);
            request.setAttribute("listaEmpresa", listaEmpresa);
            IR = AGREGAR;
        }
        //---------------------------------------------------------------------------
        //----------------------------------------------------------------------
        if (action.equals("Perfil")) {

            Acceso acceso = (Acceso) aman.consultarAccesoId(Login.id);

            formBean.setIdAcceso(acceso.getIdAcceso());
            formBean.setIdEmpresa(acceso.getEmpresa().getIdEmpresa());
            formBean.setNombreAcceso(acceso.getNombreAcceso());
            formBean.setApellidoAcceso(acceso.getApellidoAcceso());
            formBean.setUsuario(acceso.getUsuario());
            formBean.setContrasena(acceso.getContrasena());
            formBean.seteMail(acceso.getEmail());
            request.setAttribute("tipoAcceso", acceso.getTipoAcceso());
            formBean.setFechaRegistroAcceso(acceso.getFechaRegistroAcceso());
            List<Empresa> listaEmpresa = eman.consultarTodosEmpresa();
            formBean.setListaEmpresa(listaEmpresa);
            request.setAttribute("listaEmpresa", listaEmpresa);
            IR = PERFIL;
        }
        //----------------------------------------------------------------------
        if (action.equals("portada")) {
            IR = PORTADA;
        }
        //----------------------------------------------------------------------
        if (action.equals("index")) {
            IR = INDEX;
        }

        if (action.equalsIgnoreCase("modificar ")) {
            if (!Login.nAcceso.equals("Super Administrador")) {
                String error = "No posee Acceso a esta opcion";
                request.setAttribute("error", error);
                IR = PORTADA;
            } else {
            //if (Login.nAcceso == 1 || Login.nAcceso == 2) {
            String advertencia = "";

            if (idEmpresa == null || idEmpresa.equals("") || idEmpresa.equals("Seleccionar")) {
                advertencia += "*Empresa es requerida <br>";
            }
            if (nombreAcceso == null || nombreAcceso.equals("")) {
                advertencia += "*El Nombre es requerido <br>";
            }
            if (apellidoAcceso == null || apellidoAcceso.equals("")) {
                advertencia += "*El Apellido es requerido <br>";
            }
            if (usuario == null || usuario.equals("")) {
                advertencia += "*Es requerido un Usuario <br>";
            }
            if (contrasena == null || contrasena.equals("")) {
                advertencia += "*Es requerido una Contraseña <br>";
            }
            if (eMail == null || eMail.equals("")) {
                advertencia += "*Es requerido un Email <br>";
            }
            if (tipoAcceso == null || tipoAcceso.equals("") || tipoAcceso.equals("Seleccionar")) {
                advertencia += "*Es requerido seleccione un Nivel de Acceso <br>";
            }
            if (!advertencia.equals("")) {
                formBean.setError("<spam style = 'color: red' > Por favor complete los espacios requeridos " + " <br> " + advertencia + "</spam>");
                List<Empresa> listaEmpresa = eman.consultarTodosEmpresa();
                formBean.setListaEmpresa(listaEmpresa);
                request.setAttribute("listaEmpresa", listaEmpresa);

                IR = MODIFICAR;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                request.setAttribute("img", Login.img);
                return mapping.findForward(IR);
            }
            aman.modificarAcceso(idAcceso, idEmpresa, nombreAcceso, apellidoAcceso, usuario, fechaRegistroAcceso, contrasena, eMail, tipoAcceso);
            List<Acceso> listaAcceso = aman.consultarTodoAcceso();
            formBean.setListaAcceso(listaAcceso);
            formBean.setError("<spam style='color:blue'>El registro se modificó correctamente" + " <br></span>");

            Login.nombre = aman.consultarAccesoId(idAcceso).getNombreAcceso();
            IR = PORTADA;

        }}

//----------------------------------------------------------------------------------
        request.setAttribute("nombre", Login.nombre);
        request.setAttribute("nAcceso", Login.nAcceso);
        request.setAttribute("id", Login.id);
        request.setAttribute("img", Login.img);
        return mapping.findForward(IR);

    }

}
