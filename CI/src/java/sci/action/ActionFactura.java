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
import sci.persistencia.FacturaDetalle;
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
            
            fechaFactura = formato.format(new Date());
            fb.setFechaFactura(fechaFactura);
            String nombreEmpresa = eman.consultarEmpresaId(1).getNombreEmpresa();
            String direccionEmpresa = eman.consultarEmpresaId(1).getDireccionEmpresa();
            request.setAttribute("nombreEmpresa", nombreEmpresa);
            request.setAttribute("direccionEmpresa", direccionEmpresa);
            
//Traemos lista Contactos                
            List<Contactos> listaContactos = cman.tipos("cliente");
            fb.setListaContactos(listaContactos);
            request.setAttribute("listaContactos", listaContactos);
//Traemos lista Productos                
            List<Productos> listaProductos = pman.consultarTodoProductos();
            fb.setListaProductos(listaProductos);
            request.setAttribute("listaProductos", listaProductos);
           
            
            
            
            IR = AGREGAR;
        }
 //-------------------------------------------------------------------------      
        if (action.equals("Agregar")) {
            
            idEmpresa = 1;
            idConfiguracion = 1;
            
//Validaciones de Ingreso            
            if (idContacto == null || idContacto == 0) {
                advertencia = "*Es necesario seleccione un Contacto";
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
            System.out.println("pasamos filtro 1");
///***************-------- Sesscion para IVA ------------**************////
//Traemos la tasa de Iva a aplicar               
            Double tasaIva = coman.consultarConfiguarionId(idConfiguracion).getIva();
            Double precioUnitario = pman.consultarProductosId(idProducto).getPrecioUnitario();
            
            totalFila = cantidad * precioUnitario;
            
            System.out.println("pasamos filtro 1.1");
            
// validacon de guardar el encabezado
            System.out.println("para encabezado ");
            System.out.println("idContacto " +idContacto);
            System.out.println("idEmpresa " +idEmpresa);
            System.out.println("fechaFactura" +fechaFactura);
            System.out.println("estado " +estado);
            int val = feman.guardarFacturaEncabezado(idContacto, idEmpresa, fechaFactura, estado);
            
            System.out.println("para detalle ");
            idFacturaEncabezado = 5;  //CAMBIAR EL NUMERO QUE LO TRAIGA EL ULTIMO
            System.out.println("idFactu enca " +idFacturaEncabezado);
            idIva = 1 ; //CAMBIAR EL NUMERO QUE LO TRAIGA EL ULTIMO
            System.out.println("idIva " +idIva);
            System.out.println("idProducto " +idProducto);
            System.out.println("cantidad " +cantidad);
            System.out.println("totalfila " +totalFila);
            totalColumna = 10.0;
            System.out.println("totalcolumna " +totalColumna);
            subtotalColumna = 10.0;
            System.out.println("stotalcoluma " +subtotalColumna);
            int val2 = fdman.guardarFacuraDetalle(idConfiguracion, idFacturaEncabezado, idIva, idProducto, cantidad, totalFila, totalColumna, subtotalColumna);
            System.out.println("encabezado "+val + " detalle "+val2);
            if (val != 1 || val2 != 1) {
                error = "Surgío un error, no se guardó el registro ";
                
                IR = AGREGAR;
            }
            System.out.println("pasamos filtro 2");
            if (val==1 && val2==1) {
                mensaje = "Registro Agregado";
                
                IR = AGREGAR;
            }
            System.out.println("pasamos filtro 3");

            
            
            
            
            fb.setFechaFactura(fechaFactura);
            String nombreEmpresa = eman.consultarEmpresaId(1).getNombreEmpresa();
            String direccionEmpresa = eman.consultarEmpresaId(1).getDireccionEmpresa();
            request.setAttribute("nombreEmpresa", nombreEmpresa);
            request.setAttribute("direccionEmpresa", direccionEmpresa);

//Traemos lista Contactos                
            List<Contactos> listaContactos = cman.tipos("cliente");
            fb.setListaContactos(listaContactos);
            request.setAttribute("listaContactos", listaContactos);
//Traemos lista Productos                
            List<Productos> listaProductos = pman.consultarTodoProductos();
            fb.setListaProductos(listaProductos);
            request.setAttribute("listaProductos", listaProductos);
//Traemos lista FacturaDetalle                
            List<FacturaDetalle> listaFactura = fdman.consultarTodosFacturaDetalle();
            fb.setListaFacturaDetalle(listaFactura);
            request.setAttribute("listaFactura", listaFactura);
            
            IR = AGREGAR;

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
