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
import metodos.Estaticas;
import metodos.Login;
import metodos.N_Documento;
import metodos.SumarTotalFila;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import sci.actionforms.ActionFormCompras;
import sci.mantenimientos.ComprasMantenimiento;
import sci.mantenimientos.ConfiguracionMantenimiento;
import sci.mantenimientos.ContactosMantenimiento;
import sci.mantenimientos.InventarioMantenimiento;
import sci.mantenimientos.IvaMantenimiento;
import sci.mantenimientos.ProductosMantenimiento;
import sci.persistencia.Compras;
import sci.persistencia.Contactos;
import sci.persistencia.Empresa;
import sci.persistencia.Inventario;
import sci.persistencia.Iva;
import sci.persistencia.Productos;

public class ActionCompras extends org.apache.struts.action.Action {

    private static final String INICIO = "irInicioCompras";
    private static final String LISTA = "listaCompras";
    private static final String MODIFICAR = "irModificarCompras";
    private static final String AGREGAR = "irAgregarCompras";
    private static final String PORTADA = "irPortada";

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
        IvaMantenimiento iman = new IvaMantenimiento();
        InventarioMantenimiento inman = new InventarioMantenimiento();
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
            List<Contactos> listaContactos = cman.tipos("Proveedor");
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

        System.out.println("El action trae: " + action);
//------------------------------------------------------
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
            //nDocumento = coman.consultarComprasId(coman.maxIdCompras()).getnDocumento();
            if (advertencia.equals("")) {

                List<Iva> i = iman.consultarTodosIva();
                if (i.size() < 1) {
                    int inew = iman.guardarIva(conman.consultarConfiguarionId(1).getIva(), 0, 0, 0, 0, 0);
                    System.out.println("Se creaó el Iva porque no Existia");
                }
                idIva = iman.maxIdIv();
                if (i.size() > 0) {
                    Iva iva = iman.consultarIvaId(idIva);
                    Double totalTransaccion = iva.getTotalTransaccion();
                    Double ivaPagado = iva.getIvaPagado();

                    if ((totalTransaccion > 0 && ivaPagado > 0) || i.size() < 2) {
                        System.out.println("Entró a crear nuevo iva");
                        iman.guardarIva(conman.consultarConfiguarionId(1).getIva(), 0, 0, 0, 0, 0);
                    }
                }
// es necesario realizar de nuevo la consulta max id
// de lo contrario en el primer registro guardará el id anterior
// al que se haya creado es decir el penultimo                
                idIva = iman.maxIdIv();
                System.out.println("VER ID PRODUCTO " + idProducto);
                idInventario = inman.consultarInventarioIdProducto(idProducto);

//Calcular total Compra
                totalCompra = cantidad * pman.consultarProductosId(idProducto).getPrecioUnitario();

                int val = coman.guardarcompras(nDocumento, idContacto, idInventario, cantidad, idIva, idProducto, fechaCompra, totalCompra);

                System.out.println("val ver =" + val);
            }
            fb.setIdContacto(idContacto);
            request.setAttribute("idContacto", idContacto);
// para calcular total saldos del pie de factura
            Double subTotalTransaccion = sumaTF.sumarTotalCompra(nDocumento);
            request.setAttribute("subTotalTransaccion", subTotalTransaccion);
// para calcular total saldos del pie de factura
            Double subTotalTransaccionIva = sumaTF.sumarTotalCompra(nDocumento) / (1 + conman.consultarConfiguarionId(1).getIva());
            request.setAttribute("subTotalTransaccionIva", subTotalTransaccionIva);
// para calculo de IVA
            Double ivaPagado = subTotalTransaccionIva * conman.consultarConfiguarionId(1).getIva();
            request.setAttribute("ivaPagado", ivaPagado);
// para calculo total Transaccion   
            Double totalTransaccion = subTotalTransaccionIva + ivaPagado;
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
//------------------------------------------------------
        if (action.equals("Incluir")) {

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
            //nDocumento = coman.consultarComprasId(coman.maxIdCompras()).getnDocumento();
            if (advertencia.equals("")) {

                System.out.println("Quiero ver el "+idCompra);

                idIva = coman.consultarComprasId(idCompra).getIva().getIdIva();

// es necesario realizar de nuevo la consulta max id
// de lo contrario en el primer registro guardará el id anterior
// al que se haya creado es decir el penultimo                
                idInventario = inman.consultarInventarioIdProducto(idProducto);
                fb.setIdCompra(idCompra);

//Calcular total Compra
                totalCompra = cantidad * pman.consultarProductosId(idProducto).getPrecioUnitario();

                int val = coman.guardarcompras(nDocumento, idContacto, idInventario, cantidad, idIva, idProducto, fechaCompra, totalCompra);

                System.out.println("val ver =" + val);
            }
            fb.setIdContacto(idContacto);
            request.setAttribute("idContacto", idContacto);
// para calcular total saldos del pie de factura
            Double subTotalTransaccion = sumaTF.sumarTotalCompra(nDocumento);
            request.setAttribute("subTotalTransaccion", subTotalTransaccion);
// para calcular total saldos del pie de factura
            Double subTotalTransaccionIva = sumaTF.sumarTotalCompra(nDocumento) / (1 + conman.consultarConfiguarionId(1).getIva());
            request.setAttribute("subTotalTransaccionIva", subTotalTransaccionIva);
// para calculo de IVA
            Double ivaPagado = subTotalTransaccionIva * conman.consultarConfiguarionId(1).getIva();
            request.setAttribute("ivaPagado", ivaPagado);
// para calculo total Transaccion   
            Double totalTransaccion = subTotalTransaccionIva + ivaPagado;
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

            IR = MODIFICAR;
        }
//----------------------------------------------------------------------
        if (action.equals("Detalle")) {

            List<Compras> li = coman.consultaNDocumento(nDocumento);

            fb.setIdCompra(li.get(0).getIdCompra());
            fb.setnDocumento(li.get(0).getnDocumento());
            fb.setIdContacto(li.get(0).getContactos().getIdContacto());
            fb.setIdInventario(li.get(0).getInventario().getIdInventario());
            fb.setCantidad(li.get(0).getCantidad());
            fb.setIdIva(li.get(0).getIva().getIdIva());
            fb.setIdProducto(li.get(0).getProductos().getIdProducto());
            fb.setTotalCompra(li.get(0).getTotalCompra());

// para calcular total saldos del pie de factura
            Double subTotalTransaccion = sumaTF.sumarTotalCompra(nDocumento);
            request.setAttribute("subTotalTransaccion", subTotalTransaccion);
// para calcular total saldos del pie de factura
            Double subTotalTransaccionIva = sumaTF.sumarTotalCompra(nDocumento) / (1 + conman.consultarConfiguarionId(1).getIva());
            request.setAttribute("subTotalTransaccionIva", subTotalTransaccionIva);
// para calculo de IVA
            Double ivaPagado = subTotalTransaccionIva * conman.consultarConfiguarionId(1).getIva();
            request.setAttribute("ivaPagado", ivaPagado);
// para calculo total Transaccion   
            Double totalTransaccion = subTotalTransaccionIva + ivaPagado;
            request.setAttribute("totalTransaccion", totalTransaccion);            

            
//------Para Colocar la fecha si no hay una registrada
            fechaCompra = formato.format(new Date());
            fb.setFechaCompra(fechaCompra);
            //Traemos lista Contactos   --------------------------------             
            List<Contactos> listaContactos = cman.tipos("Proveedor");
            fb.setListaContactos(listaContactos);
            request.setAttribute("listaContactos", listaContactos);
//Traemos lista Productos                
            List<Productos> listaProductos = pman.consultarTodoProductos();
            fb.setListaProductos(listaProductos);
            request.setAttribute("listaProductos", listaProductos);
// Traemos compras por documento
            fb.setListaCompras(li);

            IR = MODIFICAR;
        }
        //----------------------------------------------------------------------
        if (action.equals("Eliminar")) {

            int n = coman.eliminarCompras(idCompra);
            String mensaje = "";
            if (n == 0) {
                mensaje = (" Registro (" + idCompra + ") No se Eliminó ");
                request.setAttribute("error", mensaje);
            } else {
                List<Compras> listaCompras = coman.consultarTodoCompras();
                fb.setListaCompras(listaCompras);
                mensaje = (" Registro \"" + idCompra + "\" Eliminado Correctamente ");
                request.setAttribute("mensaje", mensaje);
            }

            System.out.println("desde eliminar");
            IR = LISTA;
        }
        //----------------------------------------------------------------------
        if (action.equals("Consultar")) {

            N_Documento nd = new N_Documento();
            List<Compras> listaCompras = nd.unirListas();

            if (listaCompras == null) {
                fb.setError("<spam style='color:red'> la lista viene vacia " + "<br></spam>");
                IR = LISTA;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                return mapping.findForward(IR);
            } else {
                fb.setListaCompras(listaCompras);
                Estaticas.nDocumento1 = "";
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
            Double subTotalTransaccionIva = sumaTF.sumarTotalCompra(nDocumento) / (1 + conman.consultarConfiguarionId(1).getIva());
            request.setAttribute("subTotalTransaccionIva", subTotalTransaccionIva);
// para calculo de IVA
            Double ivaPagado = subTotalTransaccionIva * conman.consultarConfiguarionId(1).getIva();
            request.setAttribute("ivaPagado", ivaPagado);
// para calculo total Transaccion   
            Double totalTransaccion = subTotalTransaccionIva + ivaPagado;
            request.setAttribute("totalTransaccion", totalTransaccion);
//..... TRAER DATOS
//Traemos lista Compras
            System.out.println("Ndoc antes de ver lista " + nDocumento);
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
        if (action.equals(" x")) {

            System.out.println("Valor de Statica =" + Estaticas.nDocumento1);

            if (Estaticas.nDocumento1 == null || Estaticas.nDocumento1.equals("")) {
                System.out.println("Entró por nula");
                Estaticas.nDocumento1 = coman.consultarComprasId(idCompra).getnDocumento();
            }
            int val = coman.eliminarCompras(idCompra);
            nDocumento = Estaticas.nDocumento1;
            System.out.println("N doc" + nDocumento);

            

            if (coman.consultaNDocumento(nDocumento).isEmpty()) {
                // PARA LLENAR LA LISTA
                N_Documento nd = new N_Documento();
                List<Compras> listaCompras = nd.unirListas();
                fb.setListaCompras(listaCompras);
                System.out.println("Antes de ir a portada");
                Estaticas.nDocumento1 = "";
                IR = LISTA;

            } else {
                List<Compras> listaCompras = coman.consultaNDocumento(nDocumento);
                idCompra = listaCompras.get(0).getIdCompra();

                Compras com = coman.consultarComprasId(idCompra);
                fb.setIdCompra(idCompra);
                fb.setnDocumento(nDocumento);
                fb.setIdProducto(com.getProductos().getIdProducto());
                fb.setIdContacto(com.getContactos().getIdContacto());
                fb.setFechaCompra(com.getFechaCompra());

// para calcular total saldos del pie de factura
                Double subTotalTransaccion = sumaTF.sumarTotalCompra(nDocumento);
                request.setAttribute("subTotalTransaccion", subTotalTransaccion);
// para calcular total saldos del pie de factura
                Double subTotalTransaccionIva = sumaTF.sumarTotalCompra(nDocumento) / (1 + conman.consultarConfiguarionId(1).getIva());
                request.setAttribute("subTotalTransaccionIva", subTotalTransaccionIva);
// para calculo de IVA
                Double ivaPagado = subTotalTransaccionIva * conman.consultarConfiguarionId(1).getIva();
                request.setAttribute("ivaPagado", ivaPagado);
// para calculo total Transaccion   
                Double totalTransaccion = subTotalTransaccionIva + ivaPagado;
                request.setAttribute("totalTransaccion", totalTransaccion);
//..... TRAER DATOS
//Traemos lista Compras
                System.out.println("Ndoc antes de ver lista " + nDocumento);

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

                IR = MODIFICAR;
            }

        }

//--------------------------------------------------------------------------------        
        if (action.equals("Guardar")) {

            idCompra = coman.maxIdCompras();
            System.out.println("id " + idCompra);
            Compras com = coman.consultarComprasId(idCompra);
            System.out.println("ndoc " + com.getnDocumento());
            nDocumento = com.getnDocumento();
            fb.setnDocumento(nDocumento);
            System.out.println("Antes de calcular iva");
            //int iv = iman.guardarIva(0, 0, 0, 0, 0, 0)

// para calcular total saldos del pie de factura
            Double subTotalTransaccion = sumaTF.sumarTotalCompra(nDocumento);
            request.setAttribute("subTotalTransaccion", subTotalTransaccion);
            System.out.println(" antes de total pie");
// para calcular total saldos del pie de factura
            Double subTotalTransaccionIva = sumaTF.sumarTotalCompra(nDocumento) / (1 + conman.consultarConfiguarionId(1).getIva());
            request.setAttribute("subTotalTransaccionIva", subTotalTransaccionIva);
            System.out.println(" antes de calculo iva");
// para calculo de IVA
            Double ivaPagado = subTotalTransaccionIva * conman.consultarConfiguarionId(1).getIva();
            request.setAttribute("ivaPagado", ivaPagado);
            System.out.println(" antes de totaltransaccion");
// para calculo total Transaccion   
            Double totalTransaccion = subTotalTransaccionIva + ivaPagado;
            request.setAttribute("totalTransaccion", totalTransaccion);
// modificar datos de iva 
            System.out.println(" antes de modificar iva");
            idIva = iman.maxIdIv();
            Iva i = iman.consultarIvaId(idIva);
            double ivaTasa = i.getIvaTasa();
            double ivaRetenido = i.getIvaRetenido();
            double ivaTotal = ivaPagado;

            int ver = iman.modificarIva(idIva, ivaTasa, ivaRetenido, ivaPagado, ivaTotal, subTotalTransaccionIva, totalTransaccion);
            System.out.println("Ver " + ver);

            System.out.println("Antes de ir a portada");
            IR = PORTADA;
        }

//--------------------------------------------------------------------------------        
        if (action.equals("Guardar ")) {

            System.out.println("id " + idCompra);
            Compras com = coman.consultarComprasId(idCompra);
            System.out.println("////-----------------------");
            System.out.println("ndoc " + com.getnDocumento());
            nDocumento = com.getnDocumento();
            fb.setnDocumento(nDocumento);
            System.out.println("Antes de calcular iva");
            //int iv = iman.guardarIva(0, 0, 0, 0, 0, 0)

// para calcular total saldos del pie de factura
            Double subTotalTransaccion = sumaTF.sumarTotalCompra(nDocumento);
            request.setAttribute("subTotalTransaccion", subTotalTransaccion);
            System.out.println(" antes de total pie");
// para calcular total saldos del pie de factura
            Double subTotalTransaccionIva = sumaTF.sumarTotalCompra(nDocumento) / (1 + conman.consultarConfiguarionId(1).getIva());
            request.setAttribute("subTotalTransaccionIva", subTotalTransaccionIva);
            System.out.println(" antes de calculo iva");
// para calculo de IVA
            Double ivaPagado = subTotalTransaccionIva * conman.consultarConfiguarionId(1).getIva();
            request.setAttribute("ivaPagado", ivaPagado);
            System.out.println(" antes de totaltransaccion");
// para calculo total Transaccion   
            Double totalTransaccion = subTotalTransaccionIva + ivaPagado;
            request.setAttribute("totalTransaccion", totalTransaccion);
            System.out.println("Total Trans " + totalTransaccion);
// modificar datos de iva 
            System.out.println(" antes de modificar iva");
            idIva = com.getIva().getIdIva();
            Iva i = iman.consultarIvaId(idIva);
            double ivaTasa = i.getIvaTasa();
            double ivaRetenido = i.getIvaRetenido();
            double ivaTotal = ivaPagado;

            int ver = iman.modificarIva(idIva, ivaTasa, ivaRetenido, ivaPagado, ivaTotal, subTotalTransaccionIva, totalTransaccion);
            System.out.println("Ver4564564 " + ver);

            // PARA LLENAR LA LISTA
            N_Documento nd = new N_Documento();
            List<Compras> listaCompras = nd.unirListas();
            fb.setListaCompras(listaCompras);
            System.out.println("Antes de ir a portada");
            IR = LISTA;
        }

//--------------------------------------------------------------------------------        
        //request.setAttribute("nombre", Login.nombre);
        //request.setAttribute("nAcceso", Login.nAcceso);
        //request.setAttribute("id", Login.id);
        return mapping.findForward(IR);
    }
}
