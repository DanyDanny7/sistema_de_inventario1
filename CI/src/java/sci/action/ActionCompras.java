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
import sci.actionforms.ActionFormCompras;
import sci.mantenimientos.ComprasMantenimiento;
import sci.mantenimientos.InventarioMantenimiento;
import sci.persistencia.Compras;
import sci.persistencia.Empresa;
import sci.persistencia.Inventario;

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

        ActionFormCompras formBean = (ActionFormCompras) form;
        Integer idCompra = formBean.getIdCompra();
        String nDocumento = formBean.getnDocumento();
        Integer idContacto = formBean.getIdContacto();
        Integer idInventario = formBean.getIdInventario();
        Double cantidad = formBean.getCantidad();
        Integer idIva = formBean.getIdIva();
        Integer idProducto = formBean.getIdProducto();
        String fechaCompra = formato.format(new Date());
        Double totalCompra = formBean.getTotalCompra();
        String action = formBean.getAction();

        String IR = null;

        if (formBean == null || action == null) {
            System.out.println("Error entre formBean o action null");
            IR = INICIO;
        }
//------------------------------------------------------
        System.out.println("El action trae: " + action);

        if (action.equals("Agregar")) {
            System.out.println("Entro");
            String advertencia = "";

            if (idContacto == null || idContacto.equals("")) {
                advertencia = "id de compras  es requerido<br>";
            }
            if (idInventario == null || idInventario.equals("")) {
                advertencia += "*id inventario es requerido<br>";
            }
            if (idIva == null || idIva.equals("")) {
                advertencia += "id iva  es requerido<br>";
            }
            if (idProducto == null || idProducto.equals("")) {
                advertencia += "*id productos es requerido<br>";
            }
            if (totalCompra == null || totalCompra.equals("")) {
                advertencia += "*id total de compra es requerido<br>";
            }

            if (!advertencia.equals("")) {
                IR = AGREGAR;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                request.setAttribute("error", advertencia);
                return mapping.findForward(IR);
            }
            ComprasMantenimiento comprasMantenimiento = new ComprasMantenimiento();
            InventarioMantenimiento inventario = new InventarioMantenimiento();
            Inventario inv = inventario.consultarInventarioId(idInventario);

            Double existenciaup;
            existenciaup = (inv.getExistencia() + cantidad);

            int idProductos = (inv.getProductos().getIdProducto());
            Double existencia = (existenciaup);
            String estadoExistencia = (inv.getEstadoExistencia());
            int stockMinimo = (inv.getStockMinimo());
            String estadoFisico = (inv.getEstadoFisico());

            inventario.modificarInventario(idInventario, idProductos, existencia, estadoExistencia, stockMinimo, estadoFisico);

            comprasMantenimiento.guardarcompras(idCompra, nDocumento, idContacto, idInventario, cantidad, idIva, idProducto, fechaCompra, totalCompra);

            List<Compras> listaCompras = comprasMantenimiento.consultarTodoCompras();
            formBean.setListaCompras(listaCompras);
            String mensaje = "La Compra \"" + nDocumento + "\" se agregó correctamente";
            request.setAttribute("mensaje", mensaje);
            IR = LISTA;
        }
//----------------------------------------------------------------------
        if (action.equals("Modificar")) {

            String advertencia = "";

            if (idContacto == null || idContacto.equals("")) {
                advertencia = "id de compras  es requerido<br>";
            }
            if (idInventario == null || idInventario.equals("")) {
                advertencia += "*id inventario es requerido<br>";
            }
            if (idIva == null || idIva.equals("")) {
                advertencia += "id iva  es requerido<br>";
            }
            if (idProducto == null || idProducto.equals("")) {
                advertencia += "*id productos es requerido<br>";
            }
            if (totalCompra == null || totalCompra.equals("")) {
                advertencia += "*id total de compra es requerido<br>";
            }

            if (!advertencia.equals("")) {
                IR = MODIFICAR;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                return mapping.findForward(IR);
            }
            ComprasMantenimiento comprasMantenimiento = new ComprasMantenimiento();
            List<Compras> listaCompras = comprasMantenimiento.consultarTodoCompras();
            formBean.setListaCompras(listaCompras);
            IR = LISTA;
        }
        //----------------------------------------------------------------------
        if (action.equals("Eliminar")) {
            ComprasMantenimiento comprasMantenimiento = new ComprasMantenimiento();
            comprasMantenimiento.eliminarCompras(idCompra);
            List<Compras> listaCompras = comprasMantenimiento.consultarTodoCompras();

            formBean.setListaCompras(listaCompras);
            System.out.println("desde eliminar");
            return mapping.findForward(IR);
        }
        //----------------------------------------------------------------------
        if (action.equals("Consultar")) {
            ComprasMantenimiento comprasMantenimiento = new ComprasMantenimiento();

            List<Compras> listaCompras = comprasMantenimiento.consultarTodoCompras();

            if (listaCompras == null) {
                formBean.setError("<spam style='color:red'> la lista viene vacia " + "<br></spam>");
                IR = LISTA;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                return mapping.findForward(IR);
            } else {
                formBean.setListaCompras(listaCompras);
                IR = LISTA;
            }
        }
        //------------------------------------------------------------------------------
        /*if (action.equals("Actualizar")) {
            ComprasMantenimiento comprasMantenimiento = new ComprasMantenimiento();
            String mensaje = "<span style='color:red'>Actualizado Correcto" + "<br></span>";
            request.setAttribute("mensaje", mensaje);

            comprasMantenimiento.ModificarCompras(idCompra, nDocumento, idContacto, idInventario, cantidad, idIva, idProducto, fechaCompra, totalCompra);
            List<Compras> listaCompras = comprasMantenimiento.consultarTodoCompras();
            formBean.setListaCompras(listaCompras);
            return mapping.findForward(LISTA);
        }
         */
//--------------------------------------------------------------------------------        
        if (action.equals("irAgregar")) {

            IR = AGREGAR;
        }

        request.setAttribute("nombre", Login.nombre);
        request.setAttribute("nAcceso", Login.nAcceso);
        request.setAttribute("id", Login.id);
        return mapping.findForward(IR);
    }
}
