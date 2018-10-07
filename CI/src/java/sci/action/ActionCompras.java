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
import sci.actionforms.ActionFormCompras;
import sci.mantenimientos.ComprasMantenimiento;
import sci.mantenimientos.ConfiguracionMantenimiento;
import sci.mantenimientos.ContactosMantenimiento;
import sci.mantenimientos.InventarioMantenimiento;
import sci.mantenimientos.ProductosMantenimiento;
import sci.persistencia.Compras;
import sci.persistencia.Contactos;
import sci.persistencia.Empresa;
import sci.persistencia.Inventario;
import sci.persistencia.Productos;

public class ActionCompras extends org.apache.struts.action.Action {

    private static final String INICIO = "irInicioCompras";
    private static final String LISTA = "listaCompras";
    private static final String MODIFICAR = "irModificarCompras";
    private static final String AGREGAR = "irAgregarCompras";

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws java.lang.Exception {

        ActionFormCompras fb = (ActionFormCompras) form;
        Integer idCompra = fb.getIdCompra();
        String nDocumento = fb.getnDocumento();
        Integer idContacto = fb.getIdContacto();
        Integer idInventario = fb.getIdInventario();
        Double cantidad = fb.getCantidad();
        Integer idIva = fb.getIdIva();
        Integer idProducto = fb.getIdProducto();
        String fechaCompra = formato.format(new Date());
        Double totalCompra = fb.getTotalCompra();
        String action = fb.getAction();

        ContactosMantenimiento cman = new ContactosMantenimiento();
        ConfiguracionMantenimiento conman = new ConfiguracionMantenimiento();
        ProductosMantenimiento pman = new ProductosMantenimiento();
        ComprasMantenimiento coman = new ComprasMantenimiento();
        SumarTotalFila sumaTF = new SumarTotalFila();
        String IR = null;

        if (fb == null || action == null) {
            System.out.println("Error entre formBean o action null");
            IR = INICIO;
        }
//------------------------------------------------------
        if (action.equals("irAgregar")) {

//------Para Colocar la fecha si no hay una registrada
            fechaCompra = formato.format(new Date());
            fb.setFechaCompra(fechaCompra);
            //Traemos lista Contactos   --------------------------------             
            List<Contactos> listaContactos = cman.tipos("cliente");
            fb.setListaContactos(listaContactos);
            request.setAttribute("listaContactos", listaContactos);
//Traemos lista Productos                
            List<Productos> listaProductos = pman.consultarTodoProductos();
            fb.setListaProductos(listaProductos);
            request.setAttribute("listaProductos", listaProductos);
//Traemos lista Compras               
            /*   List<Compras> listaCompras = coman.consultarTodoCompras();
            fb.setListaCompras(listaCompras);
            request.setAttribute("listaCompras", listaCompras);*/

            IR = AGREGAR;
        }
//------------------------------------------------------

        System.out.println("El action trae: " + action);

        if (action.equals("Agregar")) {

            System.out.println("Entro");
            String advertencia = "";

//------Para Colocar la fecha si no hay una registrada
            if (fechaCompra.equals("")) {
                fechaCompra = formato.format(new Date());
            }
            fb.setFechaCompra(fechaCompra);

// Validaciones de ingreso            
            if (nDocumento.equals("null") || nDocumento.equals("") || nDocumento.equals("0")) {
                advertencia += "*Ingrese el Numero de Documento <br>";
            }
            if (idContacto < 1) {
                advertencia += "*Seleccione un  Proveedor <br>";
            }

            if (idProducto < 1 || idProducto == null) {
                advertencia += "*Seleccione un  Producto <br>";
            }

            if (cantidad == null || cantidad == 0) {
                advertencia += "*Elija una Cantidad<br>";
            }
            System.out.println("el advertencia tiene = " + advertencia);
            if (!advertencia.equals("")) {

                request.setAttribute("error", advertencia);
            }
            if (advertencia.equals("")) {

                idInventario = 1;
                idIva = 2;

//Calcular total Compra
                totalCompra = cantidad * pman.consultarProductosId(idProducto).getPrecioUnitario();

                int val = coman.guardarcompras(nDocumento, idContacto, idInventario, cantidad, idIva, idProducto, fechaCompra, totalCompra);
                System.out.println("val ver =" + val);

            }
// para calcular total saldos del pie de factura
            Double subTotalTransaccion = sumaTF.sumarTotalCompra(nDocumento);
            request.setAttribute("subTotalTransaccion", subTotalTransaccion);
// para calcular total saldos del pie de factura
            Double subTotalTransaccionIva = sumaTF.sumarTotalCompra(nDocumento)/(1+conman.consultarConfiguarionId(1).getIva());
            request.setAttribute("subTotalTransaccionIva", subTotalTransaccionIva);
// para calculo de IVA
            Double ivaPagado = subTotalTransaccion * conman.consultarConfiguarionId(1).getIva();
            request.setAttribute("ivaPagado", ivaPagado);
// para calculo total Transaccion   
            Double totalTransaccion = subTotalTransaccion + ivaPagado;
            request.setAttribute("totalTransaccion", totalTransaccion);

//Traemos lista Compras
            List<Compras> listaCompras = coman.consultaNDocumento(nDocumento);
            fb.setListaCompras(listaCompras);
            System.out.println("ver lsita " + listaCompras.toString());
//Traemos lista Contactos   --------------------------------             
            List<Contactos> listaContactos = cman.tipos("Proveedor");
            fb.setListaContactos(listaContactos);
            request.setAttribute("listaContactos", listaContactos);
//Traemos lista Productos                
            List<Productos> listaProductos = pman.consultarTodoProductos();
            fb.setListaProductos(listaProductos);
            request.setAttribute("listaProductos", listaProductos);

            IR = AGREGAR;
        }
//----------------------------------------------------------------------
        if (action.equals("Detalle")) {

            ComprasMantenimiento comprasMantenimiento = new ComprasMantenimiento();
            Compras compra = comprasMantenimiento.consultarComprasId(idCompra);

            fb.setIdCompra(compra.getIdCompra());
            fb.setnDocumento(compra.getnDocumento());
            fb.setIdContacto(compra.getContactos().getIdContacto());
            fb.setIdInventario(compra.getInventario().getIdInventario());
            fb.setCantidad(compra.getCantidad());
            fb.setIdIva(compra.getIva().getIdIva());
            fb.setIdProducto(compra.getProductos().getIdProducto());
            fb.setTotalCompra(compra.getTotalCompra());

            IR = MODIFICAR;
        }
        //----------------------------------------------------------------------
        if (action.equals("Eliminar")) {
            ComprasMantenimiento comprasMantenimiento = new ComprasMantenimiento();

            int n = comprasMantenimiento.eliminarCompras(idCompra);
            String mensaje = "";
            if (n == 0) {
                mensaje = (" Registro (" + idCompra + ") No se Eliminó ");
                request.setAttribute("error", mensaje);
            } else {
                List<Compras> listaCompras = comprasMantenimiento.consultarTodoCompras();
                fb.setListaCompras(listaCompras);
                mensaje = (" Registro \"" + idCompra + "\" Eliminado Correctamente ");
                request.setAttribute("mensaje", mensaje);
            }

            System.out.println("desde eliminar");
            IR = LISTA;
        }
        //----------------------------------------------------------------------
        if (action.equals("Consultar")) {
            ComprasMantenimiento comprasMantenimiento = new ComprasMantenimiento();

            List<Compras> listaCompras = comprasMantenimiento.consultarTodoCompras();

            if (listaCompras == null) {
                fb.setError("<spam style='color:red'> la lista viene vacia " + "<br></spam>");
                IR = LISTA;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                return mapping.findForward(IR);
            } else {
                fb.setListaCompras(listaCompras);
                IR = LISTA;
            }
        }
        //------------------------------------------------------------------------------
        if (action.equals("Modificar")) {
            ComprasMantenimiento comprasMantenimiento = new ComprasMantenimiento();
            comprasMantenimiento.ModificarCompras(idCompra, nDocumento, idContacto, idInventario, cantidad, idIva, idProducto, fechaCompra, totalCompra);
            List<Compras> listaCompras = comprasMantenimiento.consultarTodoCompras();
            fb.setListaCompras(listaCompras);

            String mensaje = ("El registro \"" + nDocumento + "\" se modificó correctamente ");
            request.setAttribute("mensaje", mensaje);
            IR = LISTA;
        }
        //--------------------------------------------------------------
        if (action.equals("x ")) {
            int val = coman.eliminarCompras(idCompra);
            System.out.println("id " + idCompra);
            idCompra = coman.maxIdCompras();
            System.out.println("id " + idCompra);
            Compras com = coman.consultarComprasId(idCompra);
            System.out.println("ndoc " + com.getnDocumento());
            nDocumento = com.getnDocumento();
            fb.setnDocumento(nDocumento);
            fb.setIdProducto(com.getProductos().getIdProducto());
            fb.setIdContacto(com.getContactos().getIdContacto());
            fb.setFechaCompra(com.getFechaCompra());


// para calcular total saldos del pie de factura
            Double subTotalTransaccion = sumaTF.sumarTotalCompra(nDocumento);
            request.setAttribute("subTotalTransaccion", subTotalTransaccion);
// para calcular total saldos del pie de factura
            Double subTotalTransaccionIva = sumaTF.sumarTotalCompra(nDocumento)/(1+conman.consultarConfiguarionId(1).getIva());
            request.setAttribute("subTotalTransaccionIva", subTotalTransaccionIva);
// para calculo de IVA
            Double ivaPagado = subTotalTransaccion * conman.consultarConfiguarionId(1).getIva();
            request.setAttribute("ivaPagado", ivaPagado);
// para calculo total Transaccion   
            Double totalTransaccion = subTotalTransaccion + ivaPagado;
            request.setAttribute("totalTransaccion", totalTransaccion);            
//..... TRAER DATOS
//Traemos lista Compras
             System.out.println("Ndoc antes de ver lista "+nDocumento);
            List<Compras> listaCompras = coman.consultaNDocumento(nDocumento);
            fb.setListaCompras(listaCompras);
            System.out.println("ver lsita " + listaCompras.toString());
//Traemos lista Contactos   --------------------------------             
            List<Contactos> listaContactos = cman.tipos("Proveedor");
            fb.setListaContactos(listaContactos);
            request.setAttribute("listaContactos", listaContactos);
//Traemos lista Productos                
            List<Productos> listaProductos = pman.consultarTodoProductos();
            fb.setListaProductos(listaProductos);
            request.setAttribute("listaProductos", listaProductos);

            IR = AGREGAR;
        }

//--------------------------------------------------------------------------------        
        //request.setAttribute("nombre", Login.nombre);
        //request.setAttribute("nAcceso", Login.nAcceso);
        //request.setAttribute("id", Login.id);
        return mapping.findForward(IR);
    }
}
