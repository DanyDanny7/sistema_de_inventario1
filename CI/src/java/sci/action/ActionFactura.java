/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import sci.actionforms.ActionFormFactura;
import sci.mantenimientos.ConfiguracionMantenimiento;
import sci.mantenimientos.ContactosMantenimiento;
import sci.mantenimientos.EmpresaMantenimiento;
import sci.mantenimientos.FacturaDetalleMantenimiento;
import sci.mantenimientos.FacturaEncabezadoMantenimiento;
import sci.mantenimientos.IvaMantenimiento;
import sci.mantenimientos.ProductosMantenimiento;
import sci.persistencia.Contactos;
import sci.persistencia.Empresa;
import sci.persistencia.Productos;

/**
 *
 * @author daniel.bonillausam
 */
public class ActionFactura extends org.apache.struts.action.Action {

    private static final String INICIO = "irInicioFactura";
    private static final String AGREGAR = "irAgregarFactura";
    private static final String MODIFICAR = "irModificarFactura";
    private static final String LISTA = "irListaFactura";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionFormFactura fb = (ActionFormFactura) form;

        //factura Encabezado
        Integer idFacturaEncabezado = fb.getIdFacturaEncabezado();
        Integer idContacto = fb.getIdContacto();
        Integer idEmpresa = fb.getIdEmpresa();
        String fechaFactura = fb.getFechaFactura();
        String estado = fb.getEstado();

        //factura Detalle
        Integer idFacturaDetalle = fb.getIdFacturaDetalle();
        Integer idConfiguracion = fb.getIdConfiguracion();
        Integer idIva = fb.getIdIva();
        Integer idProducto = fb.getIdProducto();
        Integer cantidad = fb.getCantidad();
        Double totalFila = fb.getTotalFila();
        Double totalColumna = fb.getTotalColumna();
        Double subtotalColumna = fb.getTotalColumna();

        //Adicional
        String action = fb.getAction();

        FacturaEncabezadoMantenimiento feman = new FacturaEncabezadoMantenimiento();
        FacturaDetalleMantenimiento fdman = new FacturaDetalleMantenimiento();
        EmpresaMantenimiento eman = new EmpresaMantenimiento();
        ContactosMantenimiento cman = new ContactosMantenimiento();
        ConfiguracionMantenimiento coman = new ConfiguracionMantenimiento();
        IvaMantenimiento iman = new IvaMantenimiento();
        ProductosMantenimiento pman = new ProductosMantenimiento();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String IR = null;
        String advertencia = "";
        String mensaje = "";
        String error = "";
        System.out.println("el valor de la accion es: " + action);

        
        //-------------------------------------------------------------------------      
        if (action.equals("irAgregar")) {
            System.out.println("Entramos 1");
            fechaFactura = formato.format(new Date());
//Traemos lista Empresa                
            List<Empresa> listaEmpresa = eman.consultarTodosEmpresa();
            request.setAttribute("listaEmpresa", listaEmpresa);
            System.out.println("Entramos 2");
//Traemos lista Contactos                
            List<Contactos> listaContactos = cman.tipos("proveedor");
            request.setAttribute("listaContactos", listaContactos);
            System.out.println("Entramos 3");
//Traemos lista Productos                
            List<Productos> listaProductos = pman.consultarTodoProductos();
            request.setAttribute("listaProductos", listaProductos);
            System.out.println("Entramos 4 antes de ir" );
            IR = AGREGAR;
        }
 //-------------------------------------------------------------------------      
        if (action.equals("Agregar")) {
//Validaciones de Ingreso            
            if (idContacto == null || idContacto == 0) {
                advertencia = "*Es necesario seleccione un Contacto";
            }
            if (idEmpresa == null || idEmpresa == 0) {
                advertencia += "*Es necesario seleccione una Empresa";
            }
            if (idIva == null || idIva == 0) {
                advertencia += "*Es necesario seleccione un valor para IVA";
            }
            if (idProducto == null || idProducto == 0) {
                advertencia += "*Es necesario ingrese un Producto";
            }
            if (cantidad == null || cantidad == 0) {
                advertencia += "*Es necesario ingrese una cantidad";
            }
            if (!advertencia.equals("")) {
                error = "Por favor complete los campos requeridos " + advertencia;

                IR = AGREGAR;
            }
///***************-------- Sesscion para IVA ------------**************////
//Traemos la tasa de Iva a aplicar               
            Double tasaIva = coman.consultarConfiguarionId(1).getIva();
            Double precioUnitario = pman.consultarProductosId(idProducto).getPrecioUnitario();
            
            totalFila = cantidad * precioUnitario;
            
            
            
// validacon de guardar el encabezado
            int val = feman.guardarFacturaEncabezado(idContacto, idEmpresa, fechaFactura, estado);
            int val2 = fdman.guardarFacuraDetalle(1, idFacturaEncabezado, idIva, idProducto, cantidad, totalFila, totalColumna, subtotalColumna);
            if (val != 1 || val2 != 1) {
                error = "Surgío un error, no se guardó el registro ";
                
                IR = AGREGAR;
            }
            if (val==1 && val2==1) {
                mensaje = "Registro Agregado";
                
                IR = AGREGAR;
            }


            
            
            
            
//Traemos lista Empresa                
            List<Empresa> listaEmpresa = eman.consultarTodosEmpresa();
            request.setAttribute("listaEmpresa", listaEmpresa);
//Traemos lista Contactos                
            List<Contactos> listaContactos = cman.tipos("proveedor");
            request.setAttribute("listaContactos", listaContactos);
//Traemos lista Productos                
            List<Productos> listaProductos = pman.consultarTodoProductos();
            request.setAttribute("listaProductos", listaProductos);

        }
        //-------------------------------------------------------------------------
        if (action.equals("Modificar")) {

        }
        //-------------------------------------------------------------------------      
        if (action.equals("Consultar")) {

        }
        //-------------------------------------------------------------------------      
        if (action.equals("ConsultarId")) {

        }
        //-------------------------------------------------------------------------      
        if (action.equals("Eliminar")) {

        }
        //-------------------------------------------------------------------------      

        request.setAttribute("nombre", Login.nombre);
        request.setAttribute("nAcceso", Login.nAcceso);
        request.setAttribute("id", Login.id);
        request.setAttribute("img", Login.img);
        return mapping.findForward(IR);
    }

}
