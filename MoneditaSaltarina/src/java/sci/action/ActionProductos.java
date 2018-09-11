package sci.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import sci.actionforms.ActionFormProductos;
import sci.mantenimientos.FabricantesMantenimiento;
import sci.mantenimientos.ProductosMantenimiento;
import sci.persistencia.Fabricantes;
import sci.persistencia.Productos;

public class ActionProductos extends org.apache.struts.action.Action {

    private static final String LISTA = "listaProducto";
    private static final String AGREGAR = "irProducto";
    private static final String MODIFICAR = "irModificarProducto";
    private static final String IRINICIO = "irInicioProducto";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws java.lang.Exception {

        ActionFormProductos fB = (ActionFormProductos) form;
        Integer idProducto = fB.getIdProducto();
        Integer idFabricantes = fB.getIdFabricantes();
        String nombreProducto = fB.getNombreProducto();
        Double precioUnitario = fB.getPrecioUnitario();
        String descripcionProducto = fB.getDescripcionProducto();
        String modelo = fB.getModelo();
        String action = fB.getAction();

        ProductosMantenimiento pman = new ProductosMantenimiento();
        FabricantesMantenimiento fman = new FabricantesMantenimiento();

        if (fB == null || action == null) {
            System.out.println("Error en null action o fB Productos");
            return mapping.findForward(IRINICIO);
        }
//-------------------------------------------------------------------------------        

        if (action.equals("Agregar")) {
            String ms = "";

            if (idFabricantes <= 0 || idFabricantes == null) {
                ms += "*Es necesario seleccione un fabricante<br>";
            }
            if (nombreProducto == null || nombreProducto.equals("")) {
                ms += "*Nombre del producto es necesario<br>";
            }
            if (precioUnitario == null || precioUnitario <= 0) {
                ms += "*Precio del producto es necesario<br>";
            }

            if (descripcionProducto == null || descripcionProducto.equals("")) {
                ms += "*Descripción del producto es necesario<br>";
            }

            if (modelo == null || modelo.equals("")) {
                ms += "*Modelo del producto es necesario<br>";
            }
            if (!ms.equals("")) {
                fB.setError("<span style='color:red'>Por favor complete los espacios vacios" + "<br>" + ms + "</span>");
                List<Fabricantes> listaFabricantes = fman.consultarTodosFabricantes();
                fB.setListaFabricantes(listaFabricantes);
                request.setAttribute("listaFabricantes", listaFabricantes);
                return mapping.findForward(AGREGAR);
            }
            //----     
            int vali = pman.validar(nombreProducto, idFabricantes);
            System.out.println("la vali es " +vali);
            Fabricantes fab = fman.consultarFabricantesId(idFabricantes);
            if (vali != 2) {
                fB.setError("<span style='color:red'>Ya existe un producto con este nombre: " + nombreProducto + " del fabricante: " + fab.getNombreFabricante() + " <br></span>");
                List<Fabricantes> listaFabricantes = fman.consultarTodosFabricantes();
                fB.setListaFabricantes(listaFabricantes);
                request.setAttribute("listaFabricantes", listaFabricantes);
                return mapping.findForward(AGREGAR);
            }

            pman.guardarProductos(idFabricantes, nombreProducto, precioUnitario, descripcionProducto, modelo);
            System.out.println("despues de guardar");
            List<Productos> listaProductos = pman.consultarTodoProductos();
            fB.setListaProductos(listaProductos);

            return mapping.findForward(LISTA);
        }
//-------------------------------------------------------------------------------

        if (action.equals("ConsultarId")) {
            Productos productos = (Productos) pman.consultarProductosId(idProducto);
            if (productos == null) {
                fB.setError("<span style='color:red'>Nose puede consultar por idProducto " + "<br></span>");
                return mapping.findForward(LISTA);
            } else {
                fB.setIdProducto(productos.getIdProducto());
                fB.setIdFabricantes(productos.getFabricantes().getIdFabricante());
                fB.setNombreProducto(productos.getNombreProducto());
                fB.setPrecioUnitario(productos.getPrecioUnitario());
                fB.setDescripcionProducto(productos.getDescripcionProducto());
                fB.setModelo(productos.getModelo());
                List<Fabricantes> listaFabricantes = fman.consultarTodosFabricantes();
                fB.setListaFabricantes(listaFabricantes);
                request.setAttribute("listaFabricantes", listaFabricantes);
                return mapping.findForward(MODIFICAR);
            }
        }
//-------------------------------------------------------------------------------

        if (action.equals("Eliminar")) {
            pman.eliminarProductos(idProducto);
            List<Productos> listaProductos = pman.consultarTodoProductos();
            fB.setListaProductos(listaProductos);
            fB.setMensaje("<spam style = 'color: blue' > Registro (" + idProducto + ") Eliminado Correctamente <br></spam>");
            return mapping.findForward(LISTA);
        }
//-------------------------------------------------------------------------------
        if (action.equals("Modificar")) {
            String ms = "";
            if (idFabricantes <= 0 || idFabricantes == null) {
                ms += "*Es necesario seleccione un fabricante<br>";
            }
            if (nombreProducto == null || nombreProducto.equals("")) {
                ms += "*Nombre del producto es necesario<br>";
            }
            if (precioUnitario == null || precioUnitario <= 0) {
                ms += "*Precio del producto es necesario<br>";
            }

            if (descripcionProducto == null || descripcionProducto.equals("")) {
                ms += "*Descripción del producto es necesario<br>";
            }

            if (modelo == null || modelo.equals("")) {
                ms += "*Modelo del producto es necesario<br>";
            }
            if (!ms.equals("")) {
                fB.setError("<span style='color:red'>Por favor complete los espacios vacios" + "<br>" + ms + "</span>");
                List<Fabricantes> listaFabricantes = fman.consultarTodosFabricantes();
                fB.setListaFabricantes(listaFabricantes);
                request.setAttribute("listaFabricantes", listaFabricantes);
                return mapping.findForward(MODIFICAR);
            }
            //----     
            int vali = pman.validar(nombreProducto, idFabricantes);
            System.out.println("la vali es " +vali);
            Fabricantes fab = fman.consultarFabricantesId(idFabricantes);
            if (vali != 2) {
                fB.setError("<span style='color:red'>Ya existe un producto con este nombre: " + nombreProducto + " del fabricante: " + fab.getNombreFabricante() + " <br></span>");
                List<Fabricantes> listaFabricantes = fman.consultarTodosFabricantes();
                fB.setListaFabricantes(listaFabricantes);
                request.setAttribute("listaFabricantes", listaFabricantes);
                return mapping.findForward(MODIFICAR);
            }
            pman.modificarProductos(idProducto, idFabricantes, nombreProducto, precioUnitario, descripcionProducto, modelo);
            List<Productos> listaProductos = pman.consultarTodoProductos();
            fB.setListaProductos(listaProductos);
            return mapping.findForward(LISTA);
        }

//-------------------------------------------------------------------------------
        if (action.equals("Consultar")) {
            List<Productos> listaProductos = pman.consultarTodoProductos();
            if (listaProductos == null) {
                fB.setError("<span style='color:red'>La lista esta vacia." + "<br></span>");
                return mapping.findForward(LISTA);
            } else {
                fB.setListaProductos(listaProductos);
                return mapping.findForward(LISTA);
            }

        }
//-------------------------------------------------------------------------------        
        if (action.equalsIgnoreCase("IrAgregar")) {

            List<Fabricantes> listaFabricantes = fman.consultarTodosFabricantes();
            fB.setListaFabricantes(listaFabricantes);
            request.setAttribute("listaFabricantes", listaFabricantes);
            return mapping.findForward(AGREGAR);
        }
        return null;

    }

}
