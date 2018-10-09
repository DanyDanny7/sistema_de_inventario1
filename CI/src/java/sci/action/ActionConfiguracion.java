/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sci.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metodos.Login;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import sci.actionforms.ActionFormConfiguracion;
import sci.actionforms.ActionFormMoneda;
import sci.mantenimientos.ConfiguracionMantenimiento;
import sci.mantenimientos.EmpresaMantenimiento;
import sci.mantenimientos.MonedaMantenimiento;
import sci.persistencia.Configuracion;
import sci.persistencia.Moneda;

/**
 *
 * @author daniel.bonillausam
 */
public class ActionConfiguracion extends org.apache.struts.action.Action {
    
    private static final String INDEX = "irIndex";
    private static final String PORTADA = "irPortada";
    private static final String INICIO = "inicioConfig";
    private static final String MODIFICAR = "modificarConfig";
    private static final String AGREGAR = "agregarConfig";
    private static final String LISTAMONEDA = "irListaMoneda";

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //parametros que vienen del jsp por medio del formConfig
        ActionFormConfiguracion formBean = (ActionFormConfiguracion) form;
        Integer idConfiguracion = formBean.getIdConfiguracion();
        Integer idAcceso = formBean.getIdAcceso();
        Integer idEmpresa = formBean.getIdEmpresa();
        File file = formBean.getFile();
        String nombreMoneda = formBean.getNombreMoneda();
        Double iva = formBean.getIva();
        String zonaHoraria = "";
        String action = formBean.getAction();

        //instanciaciones
        ConfiguracionMantenimiento cman = new ConfiguracionMantenimiento();
        MonedaMantenimiento mman = new MonedaMantenimiento();
        Configuracion config = new Configuracion();
        String IR = null;
        if (Login.id == 0) {
            String mensaje = "Por Favor Inicie Session";
            request.setAttribute("mensaje", mensaje);
            return mapping.findForward(INDEX);
        }
//---------------------------------------------------------------------------
        if (action.equals("Agregar")) {
            //valida campos vacios y nulos && agrega nueva configuracion
            String advertencia = "";
            String error = "";
            if (idAcceso == null || idAcceso.equals("")) {
                advertencia = "*ID Acceso es requerido <br>";
            }
            if (idEmpresa == null || idEmpresa.equals("")) {
                advertencia += "*ID Empresa es requerido <br>";
            }
            if (nombreMoneda == null || nombreMoneda.equals("")) {
                advertencia += "*Nombre de Moneda es requerido <br>";
            }
            if (iva == null || iva.equals("")) {
                advertencia += "*Tasa de Iva es requerido <br>";
            }
            if (zonaHoraria == null || zonaHoraria.equals("")) {
                advertencia += "*Zona Horaria es requerida <br>";
            }
            if (!advertencia.equals("")) {
                error = ("<spam style = 'color: red' > Por favor complete los espacios vacios " + " <br> " + advertencia + "</spam>");
                request.setAttribute("error", error);
                IR = AGREGAR;
            }
            // validacion de existencia

//---------------------------------------------------------------------------        
        byte[] bfile  ; //falta ver como llenar este dato

        // obtenemos el directorio real
        String filePath = getServlet().getServletContext().getRealPath("/") + "img/upload";
        //creamos el folder de descarga si no existe
        File folder = new File(filePath);
        if (!folder.exists()) {
            folder.mkdir();
        }
        String fileName = file.getName();
        if (!("").equals(fileName)) {
            System.out.println("Ruta del Servidor : " + filePath);
            File newFile = new File(filePath, fileName);

            /*if (!newFile.exists()) {
                try (FileOutputStream fos = new FileOutputStream(newFile)) {
                    //fos.write(bfile);
                    //fos.flush();
                    //fos.close();
                    
                } catch (IOException e) {
                    System.out.println("surgio algun error " + e);
                }
                
            }*/
            formBean.setInformacion("el archivo \" "+fileName+" \" no pudo guardarse , por favor "
                            + "guarde la imagen en la siguiente direccion: <br><br> \" "+filePath+" \" ");
        }
    
//---------------------------------------------------------------------------
            String nombreFile = file.getName();
            int ver = cman.guardarConfiguracion(idAcceso, idEmpresa, nombreMoneda, iva, nombreFile);
            System.out.println("Hola 2 " + ver);
            IR = INICIO;
        }
        if (action.equals("ConsultarEmpresa")) {
            //realiza consulta por id y envia los datos para ser recibidos en el jsp

            int validarEmpresa = cman.validarEmpresa(idEmpresa);
            if (validarEmpresa <= 0) {
                formBean.setError("<spam style='color:red'>No la empresa seleccionada. " + " <br></span>");
            }
            // se envia validar empresa ya que trae un id
            config = cman.consultarConfiguarionId(validarEmpresa);

            formBean.setIdConfiguracion(idConfiguracion);
            formBean.setIdAcceso(idAcceso);
            formBean.setIdEmpresa(idEmpresa);
            //formBean.setLogo(logo);
            formBean.setNombreMoneda(nombreMoneda);
            formBean.setIva(iva);
            formBean.setZonaHoraria(zonaHoraria);
            IR = MODIFICAR;
        }
        if (action.equals("Modificar")) {
            //valida campos vacios y nulos && agrega nueva configuracion
            
            cman.modificarConfiguracion(idAcceso, 1, nombreMoneda, iva, zonaHoraria);
            
            
            
            IR = INICIO;
        }
//--------------------------------------------------------------------------------
        if (action.equalsIgnoreCase("irAgregar")) {
            List<Moneda> listaMoneda = mman.consultarTodosMoneda();
            formBean.setListaMoneda(listaMoneda);
            request.setAttribute("listaMoneda", listaMoneda);
            IR = AGREGAR;
        }
//--------------------------------------------------------------------------------
        if (action.equalsIgnoreCase("Detalle")) {
            List<Moneda> listaMoneda = mman.consultarTodosMoneda();
            formBean.setListaMoneda(listaMoneda);
            request.setAttribute("listaMoneda", listaMoneda);
            IR = AGREGAR;
        }
///------------------------------------------------
        if (action.equals("consultaId")) {
            if (!Login.nAcceso.equals("Super Administrador") ) {
                String error = "No posee Acceso a esta opcion";
                request.setAttribute("error", error);
                IR = PORTADA;

            } else {

            Configuracion conf = cman.consultarConfiguarionId(1);
            EmpresaMantenimiento eman = new EmpresaMantenimiento();
            String nombreEmpresa = eman.consultarEmpresaId(1).getNombreEmpresa();
            
            formBean.setIdConfiguracion(conf.getIdConfiguracion());
            formBean.setNombreMoneda(conf.getMoneda().getNombreMoneda());
            formBean.setZonaHoraria(conf.getZonaHoraria());
            formBean.setIva(conf.getIva());
            
            
            
            System.out.println("Nombre "+nombreMoneda);
            request.setAttribute("nombreEmpresa", nombreEmpresa);
            String nameImgP = conf.getZonaHoraria();
            String imgP = "<img src=\"img/upload/" + nameImgP + "\" width=\"200\" height=\"200\"/>";
            request.setAttribute("imgP", imgP);
            
            List<Moneda> listaMoneda = mman.consultarTodosMoneda();
            formBean.setListaMoneda(listaMoneda);
            request.setAttribute("listaMoneda", listaMoneda);
            
            
            IR = MODIFICAR;
        }}
        
///---------------------------------------------------------
    
        request.setAttribute("nombre", Login.nombre);
        request.setAttribute("nAcceso", Login.nAcceso);
        request.setAttribute("id", Login.id);
        request.setAttribute("img", Login.img);        
        return mapping.findForward(IR);
    }

}
