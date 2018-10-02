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
import metodos.SumarTotalFila;
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
import sci.persistencia.FacturaEncabezado;
import sci.persistencia.Iva;
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
        Double totalTransaccion = fb.getTotalTransaccion();
        Double subTotalTransaccion = fb.getSubTotalTransaccion();

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
        SumarTotalFila sumaTF = new SumarTotalFila();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String IR = null;
        String advertencia = "";
        String mensaje = "";
        String error = "";
        System.out.println("el valor de la accion es: " + action);

        //-------------------------------------------------------------------------      
        if (action.equals("irAgregar")) {
//------Para Colocar el numero rojo de factura
            int num = feman.maxIdFacturaEncabezad() + 1;
            request.setAttribute("num", num);
//------Para Colocar la fecha si no hay una registrada
            fechaFactura = formato.format(new Date());
            fb.setFechaFactura(fechaFactura);
//------Para traer datos de la empresa
            String nombreEmpresa = eman.consultarEmpresaId(1).getNombreEmpresa();
            String direccionEmpresa = eman.consultarEmpresaId(1).getDireccionEmpresa();
            request.setAttribute("nombreEmpresa", nombreEmpresa);
            request.setAttribute("direccionEmpresa", direccionEmpresa);
//Traemos lista Contactos   --------------------------------             
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

//------Para Colocar la fecha si no hay una registrada
            if (fechaFactura.equals("")) {
                fechaFactura = formato.format(new Date());
            }
            fb.setFechaFactura(fechaFactura);
//---------------------------------------
            idEmpresa = 1;
            idConfiguracion = 1;
//Validaciones de Ingreso            
            if (idContacto == null || idContacto == 0 || idContacto.equals("Seleccionar")) {
                advertencia = "*Es necesario seleccione un Contacto";
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
//validacion para iva
            List<Iva> i = iman.consultarTodosIva();
                System.out.println("LA LISTA IVA ES "+i.size());
            if (i.size() < 1) {
                int inew = iman.guardarIva(coman.consultarConfiguarionId(1).getIva(), 0, 0, 0, 0, 0);
                System.out.println("Se creaó el Iva porque no Existia");
            }
            idIva = iman.maxIdIv();
            estado = "Activo";
           
// validacon de guardar el encabezado               
            if (i.size() > 0) {
                System.out.println("ENTRÓ EN EL IVA ");
                Iva iva = iman.consultarIvaId(idIva);
                totalTransaccion = iva.getTotalTransaccion();
                System.out.println("LA TOTAL TRANSACCION TRAE "+totalTransaccion);
                if (totalTransaccion > 0 || i.size()<2) {
                    System.out.println("ENTRÓ EN EL IVA 2");
                    iman.guardarIva(coman.consultarConfiguarionId(1).getIva(), 0, 0, 0, 0, 0);
                    int val = feman.guardarFacturaEncabezado(idContacto, idEmpresa, fechaFactura, estado, 0, 0);
                }
            }
            idFacturaEncabezado = feman.maxIdFacturaEncabezad();
            System.out.println("para detalle ");
            List<FacturaDetalle> listaFactura;

            totalFila = pman.consultarProductosId(idProducto).getPrecioUnitario() * cantidad;
            int val2 = fdman.guardarFacuraDetalle(idConfiguracion, idFacturaEncabezado, idIva, idProducto, cantidad, totalFila, 0, 0);

            if (val2 == 1) {
                mensaje = "Registro Agregado";
                request.setAttribute("mensaje", mensaje);
            }
// para calcular el Sub Total del pie de la factura            
                
            subTotalTransaccion = sumaTF.sumarTotalFila(idFacturaEncabezado);
            fb.setSubTotalTransaccion(subTotalTransaccion);
            request.setAttribute("subTotalTransaccion", subTotalTransaccion);
//para calculo del IVA
            System.out.println("ver que trae "+coman.consultarConfiguarionId(1).getIva());
            double ivaRetenido = subTotalTransaccion * coman.consultarConfiguarionId(1).getIva();
            
            request.setAttribute("ivaRetenido", ivaRetenido);
// total transaccion
            totalTransaccion = subTotalTransaccion + ivaRetenido;
            request.setAttribute("totalTransaccion", totalTransaccion);

            String nombreEmpresa = eman.consultarEmpresaId(1).getNombreEmpresa();
            String direccionEmpresa = eman.consultarEmpresaId(1).getDireccionEmpresa();
            request.setAttribute("nombreEmpresa", nombreEmpresa);
            request.setAttribute("direccionEmpresa", direccionEmpresa);

//Traemos lista Contactos  
            idContacto = feman.consultarFacturaEncabezadoId(idFacturaEncabezado).getContactos().getIdContacto();
            fb.setIdContacto(idContacto);
            List<Contactos> listaContactos = cman.tipos("cliente");
            fb.setListaContactos(listaContactos);
            request.setAttribute("listaContactos", listaContactos);
//Traemos lista Productos                
            List<Productos> listaProductos = pman.consultarTodoProductos();
            fb.setListaProductos(listaProductos);
            request.setAttribute("listaProductos", listaProductos);
//Traemos lista FacturaDetalle                
            listaFactura = fdman.consultaFacturaEspecifica(idFacturaEncabezado);
            fb.setListaFacturaDetalle(listaFactura);
            request.setAttribute("listaFactura", listaFactura);
//------Para Colocar el numero rojo de factura
            int maxIdFacturaEncabezado = feman.maxIdFacturaEncabezad();
            request.setAttribute("num", maxIdFacturaEncabezado);
            IR = AGREGAR;

        }
        //-------------------------------------------------------------------------
        if (action.equals("Guardar")) {
            
            
// para calcular el Sub Total del pie de la factura 
            idFacturaEncabezado = feman.maxIdFacturaEncabezad();
            subTotalTransaccion = sumaTF.sumarTotalFila(idFacturaEncabezado);
//para calculo del IVA
            double ivaRetenido = subTotalTransaccion * coman.consultarConfiguarionId(1).getIva();
// total transaccion
            totalTransaccion = subTotalTransaccion + ivaRetenido;
            
 //modificar FacturaEncabezado ya que se creo en agregar.           
            FacturaEncabezado fe = new FacturaEncabezado();
            fe = feman.consultarFacturaEncabezadoId(idFacturaEncabezado);
            idContacto = fe.getContactos().getIdContacto();
            idEmpresa = fe.getEmpresa().getIdEmpresa();
            fechaFactura = fe.getFechaFactura();
            estado = fe.getEstado();
            
            
            System.out.println("idFacturaEncabezado "+idFacturaEncabezado);
            System.out.println("idContacto "+idContacto);
            System.out.println("idEmpresa "+idEmpresa);
            System.out.println("fechaFactura "+fechaFactura);
            System.out.println("estado "+estado);
            System.out.println("subTotalTransaccion "+subTotalTransaccion);
            System.out.println("otalTransaccion "+totalTransaccion);
            
            
            
            feman.modificarFacturaEncabezado(idFacturaEncabezado, idContacto, idEmpresa, fechaFactura, estado, subTotalTransaccion, totalTransaccion);
            
//Modificar iva ya que se creo en agregar            
            idIva = iman.maxIdIv();
            Iva i = new Iva();
            i = iman.consultarIvaId(idIva);
            double ivaTasa = i.getIvaTasa();
            double ivaPagado = i.getIvaPagado();
            double ivaTotal = ivaRetenido;
            
            iman.modificarIva(idIva, ivaTasa, ivaRetenido, ivaPagado, ivaTotal, subTotalTransaccion, totalTransaccion);
            
            
            
            IR = INICIO;
        }
        //-------------------------------------------------------------------------
        if (action.equals("Modificar")) {

        }
        //-------------------------------------------------------------------------      
        if (action.equals("Consultar")) {

            List<FacturaEncabezado> listaFacturaEncabezado = feman.consultarTodosFacturaEncabezado();
            fb.setListaFacturaEncabezado(listaFacturaEncabezado);
            request.setAttribute("listaFacturaEncabezado", listaFacturaEncabezado);
        }
        //-------------------------------------------------------------------------      
        if (action.equals("ConsultarId")) {

        }
        //-------------------------------------------------------------------------      
        if (action.equals("x")) {

            idFacturaEncabezado = feman.maxIdFacturaEncabezad();
            System.out.println("idFacturaEncabezado ver " + idFacturaEncabezado);
            int ver = fdman.eliminarFacturaDetalle(idFacturaDetalle);
            System.out.println("ver ver " + ver);

//------Para Colocar el numero rojo de factura
            int maxIdFacturaEncabezado = feman.maxIdFacturaEncabezad();
            request.setAttribute("num", maxIdFacturaEncabezado);
            //------Para Colocar la fecha si no hay una registrada
            fechaFactura = feman.consultarFacturaEncabezadoId(idFacturaEncabezado).getFechaFactura();
            fb.setFechaFactura(fechaFactura);
            // para calcular el Sub Total del pie de la factura            
            subTotalTransaccion = sumaTF.sumarTotalFila(idFacturaEncabezado);
            fb.setSubTotalTransaccion(subTotalTransaccion);
            request.setAttribute("subTotalTransaccion", subTotalTransaccion);
//para calculo del IVA
            double ivaRetenido = subTotalTransaccion * coman.consultarConfiguarionId(1).getIva();
            request.setAttribute("ivaRetenido", ivaRetenido);
// total transaccion
            totalTransaccion = subTotalTransaccion + ivaRetenido;
            request.setAttribute("totalTransaccion", totalTransaccion);

            String nombreEmpresa = eman.consultarEmpresaId(1).getNombreEmpresa();
            String direccionEmpresa = eman.consultarEmpresaId(1).getDireccionEmpresa();
            request.setAttribute("nombreEmpresa", nombreEmpresa);
            request.setAttribute("direccionEmpresa", direccionEmpresa);

            //Traemos lista Contactos
            idContacto = feman.consultarFacturaEncabezadoId(idFacturaEncabezado).getContactos().getIdContacto();
            fb.setIdContacto(idContacto);
            List<Contactos> listaContactos = cman.tipos("cliente");
            fb.setListaContactos(listaContactos);
            request.setAttribute("listaContactos", listaContactos);
//Traemos lista Productos                
            List<Productos> listaProductos = pman.consultarTodoProductos();
            fb.setListaProductos(listaProductos);
            request.setAttribute("listaProductos", listaProductos);
//Traemos lista FacturaDetalle
            List listaFactura = fdman.consultaFacturaEspecifica(idFacturaEncabezado);
            fb.setListaFacturaDetalle(listaFactura);
            request.setAttribute("listaFactura", listaFactura);
            IR = AGREGAR;
        }
        //-------------------------------------------------------------------------      

        request.setAttribute("nombre", Login.nombre);
        request.setAttribute("nAcceso", Login.nAcceso);
        request.setAttribute("id", Login.id);
        request.setAttribute("img", Login.img);
        return mapping.findForward(IR);
    }

}
