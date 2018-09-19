/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sci.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import sci.actionforms.ActionFormConfiguracion;
import sci.mantenimientos.ConfiguracionMantenimiento;
import sci.mantenimientos.MonedaMantenimiento;
import sci.persistencia.Configuracion;
import sci.persistencia.Moneda;

/**
 *
 * @author daniel.bonillausam
 */
public class ActionConfiguracion extends org.apache.struts.action.Action {

    private static final String INICIO = "inicioConfig";
    private static final String MODIFICAR = "modificarConfig";
    private static final String AGREGAR = "agregarConfig";

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //parametros que vienen del jsp por medio del formConfig
        ActionFormConfiguracion formBean = (ActionFormConfiguracion) form;
        Integer idConfiguracion = formBean.getIdConfiguracion();
        Integer idAcceso = formBean.getIdAcceso();
        Integer idEmpresa = formBean.getIdEmpresa();
        
        String nombreMoneda = formBean.getNombreMoneda();
        Double iva = formBean.getIva();
        String zonaHoraria = "";
        String action = formBean.getAction();

        //instanciaciones
        ConfiguracionMantenimiento cman = new ConfiguracionMantenimiento();
        MonedaMantenimiento mman = new MonedaMantenimiento();
        Configuracion config = new Configuracion();
        String IR = null;

  //----------------------------------------------------------      
        /*
        
        byte[] bfile = new byte[(int) afile.length()];
        
        
        FileInputStream fis = new FileInputStream(afile);
        */
 //-----------------------------------------------------------------
        //lo traemos el ufile del for action
        System.out.println(" prueba 1");
        FormFile ufile = formBean.getUfile();
        File file = formBean.getFile();
        
        System.out.println(" prueba 2");
        // obtenemos el directorio real
        String filePath = getServlet().getServletContext().getRealPath("/")+ "upload";
        System.out.println(" prueba 3");
        //creamos el folder de descarga si no existe
        File folder = new File(filePath);
        if (!folder.exists()) {
            folder.mkdir();
        }
        String fileName = file.getName();
        if (!("").equals(fileName)) {
            System.out.println("Ruta del Servidor : "+filePath);
            File newFile = new File(filePath, fileName);
            
            if (!newFile.exists()) {
                FileOutputStream fos = new FileOutputStream(newFile);
                fos.write(new byte[idEmpresa]);
            }
            
            
        }
        
        
        
        System.out.println("hasta aqui vamos bien");
        
        
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

            //System.out.println("Hola mundo");
            int ver = cman.guardarConfiguracion(idAcceso, idEmpresa, nombreMoneda, iva, zonaHoraria, bfile, fis);
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

            cman.modificarConfiguracion(idAcceso, idEmpresa, nombreMoneda, iva, zonaHoraria);
            IR = INICIO;
        }
//--------------------------------------------------------------------------------
        if (action.equalsIgnoreCase("irAgregar")) {
            List<Moneda> listaMoneda = mman.consultarTodosMoneda();
            formBean.setListaMoneda(listaMoneda);
            request.setAttribute("listaMoneda", listaMoneda);
            IR = AGREGAR;
        }
        return mapping.findForward(IR);
    }

}
