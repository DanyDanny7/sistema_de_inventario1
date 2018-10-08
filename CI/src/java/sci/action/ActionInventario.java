package sci.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import sci.actionforms.ActionFormAcceso;
import sci.actionforms.ActionFormInventario;
import sci.mantenimientos.AccesoMantenimiento;
import sci.mantenimientos.InventarioMantenimiento;
import sci.persistencia.Inventario;

public class ActionInventario extends org.apache.struts.action.Action {

    private static final String CONFIRMACIONI = "confirmacionNuevoInventario";
    private static final String ERRORI = "confirmacionErrorInventario";
   private static final String MODIFICARI="modificarinventario";
   private static final String CONFIRMACIONII= "existenciacero";
   private static final String CONFIRMACIONIII= "existenciabaja";


    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws java.lang.Exception {

        ActionFormInventario formBean = (ActionFormInventario) form;
        Integer idInventario = formBean.getIdInventario();
        Integer idProducto = formBean.getIdProducto();
        Integer existencia = formBean.getExistencia();
        String estadoExistencia = formBean.getEstadoExistencia();
        Integer stockMinimo = formBean.getStockMinimo();
        String estadoFisico = formBean.getEstadoFisico();
        String action = formBean.getAction();

        if (formBean == null || action == null) {
            System.out.println("Error entre formBean o action null");
            return mapping.findForward(ERRORI);
        }
//--------------------------------------------------------
      
//------------------------------------------------------
        if (action.equals("Agregar")) {
            String advertencia = "";

           
            if (idProducto== null) {
                advertencia += "*ID Productos es requerido<br>";
            }
            if (existencia == null || existencia.equals("")) {
                advertencia = "*existencia es requerido<br>";
            }
            if (estadoExistencia == null || estadoExistencia.equals("")) {
                advertencia += "*estado existencia es requerido<br>";
            }
            if (stockMinimo == null || stockMinimo.equals("")) {
                advertencia += "* stock Minimo es requerido<br>";
            }
            if (estadoFisico == null || estadoFisico.equals("")) {
                advertencia += "*estado fisico es requerida<br>";
            }
            
            if (!advertencia.equals("")) {
                formBean.setError("<span style='color:red'>Por favor complete los espacios vacios" + "<br>" + advertencia + "</span>");
                return mapping.findForward(ERRORI);
            }
          InventarioMantenimiento inventarioMantenimiento = new InventarioMantenimiento();
          
          //inventarioMantenimiento.guardarInventario(0, idProducto, existencia, estadoExistencia, stockMinimo, estadoFisico);
         List<Inventario> listai= inventarioMantenimiento.consultarTodoInventario();
            formBean.setListainventario(listai); 
            
            String mensaje="<span style='color:red'>agregado correcto"+"<br></span>";
            request.setAttribute("mensaje",mensaje);
         
            return mapping.findForward(CONFIRMACIONI);
        
             }
            
//-------------------------------------------------------------------------------            
            if (action.equals("Consultar")) {
            InventarioMantenimiento inventarioMantenimiento = new InventarioMantenimiento();
            //Acceso acceso = new Acceso();
            List<Inventario> listainventario = inventarioMantenimiento.consultarTodoInventario();

            if (listainventario == null) {
                formBean.setError("<spam style='color:red'> la lista viene vacia " + "<br></spam>");
                return mapping.findForward(ERRORI);
            } else {
                formBean.setListainventario(listainventario);
                return mapping.findForward(CONFIRMACIONI);
            }
              }
 //-------------------------------------------------------------------------------      
             if (action.equals("Eliminar")) {
            InventarioMantenimiento inventarioMantenimiento = new InventarioMantenimiento();
            inventarioMantenimiento.eliminarInventario(formBean.getIdInventario());
            List<Inventario> listai = inventarioMantenimiento.consultarTodoInventario();
           
            formBean.setListainventario(listai);
            
            String mensaje="<span style='color:red'>eliminado correcto"+"<br></span>";
            request.setAttribute("mensaje",mensaje);
         
            System.out.println("desde eliminar");
            return mapping.findForward(CONFIRMACIONI);
         }
             
//-------------------------------------------------------------------------------             
              if (action.equals("Detalle")) {
            InventarioMantenimiento inventarioMantenimiento = new InventarioMantenimiento();

            Inventario inventario = (Inventario) inventarioMantenimiento.consultarInventarioId(idInventario);
           
                formBean.setIdInventario(inventario.getIdInventario());
               formBean.setIdProducto(inventario.getProductos().getIdProducto());
                //formBean.setExistencia(inventario.getExistencia());
                formBean.setEstadoExistencia(inventario.getEstadoExistencia());
                formBean.setStockMinimo(inventario.getStockMinimo());
                 formBean.setEstadoFisico(inventario.getEstadoFisico());
                return mapping.findForward(MODIFICARI);
            }
//-------------------------------------------------------------------------------              
              if (action.equals("Modificar")) {
               InventarioMantenimiento inventarioMantenimiento = new InventarioMantenimiento();
               String mensaje = "<span style='color:red'>Actualizado Correcto" + "<br></span>";
            request.setAttribute("mensaje", mensaje);
           
           //inventarioMantenimiento.modificarInventario(idInventario,idProducto, existencia, estadoExistencia, stockMinimo, estadoFisico);
            List<Inventario> listai = inventarioMantenimiento.consultarTodoInventario();
            formBean.setListainventario(listai);
           return mapping.findForward(CONFIRMACIONI);
           }
              if (action.equals("existenciacero")) {
            InventarioMantenimiento inventarioMantenimiento = new InventarioMantenimiento();
            //Acceso acceso = new Acceso();
            List<Inventario> listainventario = inventarioMantenimiento.consultarExistenciacero();
                   System.out.println("lista "+listainventario);
            if (listainventario == null) {
                formBean.setError("<spam style='color:red'> la lista viene vacia " + "<br></spam>");
                return mapping.findForward(ERRORI);
            } else {
                System.out.println("lista llena");
                formBean.setListainventario(listainventario);
                
                request.setAttribute("listainventario", listainventario);
                return mapping.findForward(CONFIRMACIONII);
            }
              }
                  if (action.equals("existenciabajaa")) {
            InventarioMantenimiento inventarioMantenimiento = new InventarioMantenimiento();
            //Acceso acceso = new Acceso();
            List<Inventario> listainventario = inventarioMantenimiento.existenciabaja();
                   System.out.println("lista "+listainventario);
            if (listainventario == null) {
                formBean.setError("<spam style='color:red'> la lista viene vacia " + "<br></spam>");
                return mapping.findForward(ERRORI);
            } else {
                System.out.println("lista llena");
                formBean.setListainventario(listainventario);
                
                request.setAttribute("listainventario", listainventario);
                return mapping.findForward(CONFIRMACIONIII);
            }
              }
//---------------------------------------------------------------------        
    /*     if (action.equals("ConsultarId")) {
            AccesoMantenimiento accesoMantenimiento = new AccesoMantenimiento();
            Acceso acceso = (Acceso) accesoMantenimiento.consultarAccesoId(idAcceso);

            if (acceso == null) {

                formBean.setError("<span style='color:red'>Nose puede consultar" + "<br></span>");
                return mapping.findForward(ERROR);
            } else {
                formBean.setIdAcceso(acceso.getIdAcceso());
                formBean.setIdEmpresa(acceso.getEmpresa().getIdEmpresa());
                formBean.setNombreAcceso(acceso.getNombreAcceso());
                formBean.setApellidoAcceso(acceso.getApellidoAcceso());
                formBean.setUsuario(acceso.getUsuario());
                formBean.setContrasena(acceso.getContrasena());
                formBean.setEmail(acceso.getEmail());
                formBean.setTipoAcceso(acceso.getTipoAcceso());
                return mapping.findForward(VALIDAR);
            }
        }
//--------------------------------------------------------------------        
        if (action.equals("Eliminar")) {
            AccesoMantenimiento accesoMantenimiento = new AccesoMantenimiento();
            accesoMantenimiento.eliminarAcceso(idAcceso);
            return mapping.findForward(ELIMINAR);
        }
//-----------------------------------------------------------        
       if (action.equals("Login")) {
            String advertencia = "";

            if (usuario == null || usuario.equals("")) {
                advertencia = "*Usuario es requerido<br>";
            }
            if (contrasena == null || contrasena.equals("")) {
                advertencia += "*Contraseña es requerida<br>";
            }
            if (!advertencia.equals("")) {
                formBean.setError("<span style='color:red'>Por favor complete los espacios vacios" + "<br>" + advertencia + "</span>");
                return mapping.findForward(ERROR);
            }
            AccesoMantenimiento accesoMantenimiento = new AccesoMantenimiento();
            Acceso acceso = new Acceso();
            int validar = accesoMantenimiento.loginAcceso(usuario, contrasena);

            if (validar == 3) {
                int traerId = accesoMantenimiento.loginId(usuario, contrasena);
                accesoMantenimiento.consultarAccesoId(traerId);
                formBean.setIdAcceso(acceso.getIdAcceso());
                return mapping.findForward(LOGIN);
            }
            if (validar == 2) {
                int traerId = accesoMantenimiento.loginId(usuario, contrasena);
                accesoMantenimiento.consultarAccesoId(traerId);
                formBean.setIdAcceso(acceso.getIdAcceso());
                return mapping.findForward(LOGINAGREGAR);
            }
            if (validar == 1) {
                int traerId = accesoMantenimiento.loginId(usuario, contrasena);
                accesoMantenimiento.consultarAccesoId(traerId);
                formBean.setIdAcceso(acceso.getIdAcceso());
                return mapping.findForward(LOGINVISTA);
            } else {
                formBean.setError("<span style='color:red'>Ingrese contraseña o usuario validos." + "<br></span>");
                return mapping.findForward(ERRORLOGIN);
            }
        }
*/
      return null;

    }
  

}
