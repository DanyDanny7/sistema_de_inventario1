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
import sci.actionforms.ActionFormProductos;
import sci.mantenimientos.Extraer;
import sci.mantenimientos.FabricantesMantenimiento;
import sci.mantenimientos.InventarioMantenimiento;
import sci.mantenimientos.ProductosMantenimiento;
import sci.persistencia.Fabricantes;
import sci.persistencia.Inventario;
import sci.persistencia.Productos;

public class ActionProductos extends org.apache.struts.action.Action {
private static final String INDEX = "irIndex";
    private static final String PORTADA = "irPortada";
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
        Integer stockMinimo = fB.getStockMinimo();

        String descripcionProducto = fB.getDescripcionProducto();
        String modelo = fB.getModelo();
        String action = fB.getAction();
        System.out.println("aqui");
        ProductosMantenimiento pman = new ProductosMantenimiento();
        FabricantesMantenimiento fman = new FabricantesMantenimiento();
        InventarioMantenimiento iman = new InventarioMantenimiento();
        Extraer e = new Extraer();
        System.out.println("aqui2");
        String IR = null;
        
        if (Login.id == 0) {
            String mensaje = "Por Favor Inicie Session";
            request.setAttribute("mensaje", mensaje);
            return mapping.findForward(INDEX);
        }
//-------------------------------------------------------------------------------        

        if (action.equals("Agregar")) {
                        if (Login.nAcceso.equals("Solo Consulta") ) {
                String error = "No posee Acceso a esta opcion";
                request.setAttribute("error", error);
                IR = PORTADA;
            } else {
            String ms = "";
            System.out.println("hola");
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
                List<Fabricantes> listaFabricantes = fman.consultarTodosFabricantes();
                fB.setListaFabricantes(listaFabricantes);
                request.setAttribute("listaFabricantes", listaFabricantes);
                IR = AGREGAR;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                request.setAttribute("img", Login.img);
                request.setAttribute("error", ms);
                return mapping.findForward(IR);
            }
            System.out.println("LLEGA AKI?");
            //----     
            int vali = pman.validar(nombreProducto, idFabricantes);
            System.out.println("la vali es " + vali);
            Fabricantes fab = fman.consultarFabricantesId(idFabricantes);
            if (vali != 2) {
                String error = ("Ya existe un producto con este nombre: " + nombreProducto + " del fabricante: " + fab.getNombreFabricante());
                List<Fabricantes> listaFabricantes = fman.consultarTodosFabricantes();
                fB.setListaFabricantes(listaFabricantes);
                request.setAttribute("listaFabricantes", listaFabricantes);
                IR = AGREGAR;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                request.setAttribute("img", Login.img);
                request.setAttribute("error", error);
                return mapping.findForward(IR);
            }

            pman.guardarProductos(idFabricantes, nombreProducto, precioUnitario, descripcionProducto, modelo);
            List<Integer> lista = e.consultarTodo();

            int c = lista.get(0);

            System.out.println(c);
            iman.guardarInventario(0, c, 0.0, "sin existencia", stockMinimo, "");

            System.out.println("despues de guardar");
            List<Productos> listaProductos = pman.consultarTodoProductos();
            fB.setListaProductos(listaProductos);

            String mensaje = "El Producto \"" + nombreProducto + "\" se agregó correctamente";
            request.setAttribute("mensaje", mensaje);

            IR = LISTA;
            request.setAttribute("nombre", Login.nombre);
            request.setAttribute("nAcceso", Login.nAcceso);
            request.setAttribute("id", Login.id);
            request.setAttribute("img", Login.img);
            return mapping.findForward(IR);
        }}
//-------------------------------------------------------------------------------

        if (action.equals("Detalle")) {
            if (Login.nAcceso.equals("Solo Consulta") || Login.nAcceso.equals("Consulta e Ingresar")) {
                String error = "No posee Acceso a esta opcion";
                request.setAttribute("error", error);
                IR = PORTADA;
            } else {
            Productos productos = (Productos) pman.consultarProductosId(idProducto);
            System.out.println("este es el id productos " + idProducto);
            int stockMinimo1 = e.extraerStock(idProducto);

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
                fB.setStockMinimo(stockMinimo1);
                List<Fabricantes> listaFabricantes = fman.consultarTodosFabricantes();
                fB.setListaFabricantes(listaFabricantes);
                request.setAttribute("listaFabricantes", listaFabricantes);
                System.out.println("este es 123" + listaFabricantes);
                IR = MODIFICAR;
            }
        }}
//-------------------------------------------------------------------------------

        if (action.equals("Eliminar")) {
                        if (Login.nAcceso.equals("Solo Consulta") || Login.nAcceso.equals("Consulta e Ingresar")) {
                String error = "No posee Acceso a esta opcion";
                request.setAttribute("error", error);
                IR = PORTADA;
            } else {
            int n = pman.eliminarProductos(idProducto);
            String mensaje = "";
            if (n == 0) {
                mensaje = (" Registro (" + idProducto + ") No se Eliminó ");
                request.setAttribute("error", mensaje);

            } else {
                List<Productos> listaProductos = pman.consultarTodoProductos();
                fB.setListaProductos(listaProductos);

                mensaje = (" Registro \"" + idProducto + "\" Eliminado Correctamente ");
                request.setAttribute("mensaje", mensaje);

            }
            IR = LISTA;
        }}
//-------------------------------------------------------------------------------
        if (action.equals("Modificar")) {
                        if (Login.nAcceso.equals("Solo Consulta") || Login.nAcceso.equals("Consulta e Ingresar")) {
                String error = "No posee Acceso a esta opcion";
                request.setAttribute("error", error);
                IR = PORTADA;
            } else {
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
                String error = ("Por favor complete los espacios vacios" + ms);

                List<Fabricantes> listaFabricantes = fman.consultarTodosFabricantes();
                fB.setListaFabricantes(listaFabricantes);
                request.setAttribute("listaFabricantes", listaFabricantes);

                IR = MODIFICAR;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                request.setAttribute("img", Login.img);
                request.setAttribute("error", error);
                return mapping.findForward(IR);
            }
            //----     
            /* int vali = pman.validar(nombreProducto, idFabricantes);
            System.out.println("la vali es " + vali);
            Fabricantes fab = fman.consultarFabricantesId(idFabricantes);
            if (vali != 2) {
                fB.setError("<span style='color:red'>Ya existe un producto con este nombre: " + nombreProducto + " del fabricante: " + fab.getNombreFabricante() + " <br></span>");
                List<Fabricantes> listaFabricantes = fman.consultarTodosFabricantes();
                fB.setListaFabricantes(listaFabricantes);
                IR = MODIFICAR;
                request.setAttribute("listaFabricantes", listaFabricantes);
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);

                return mapping.findForward(IR);
            }*/
            pman.modificarProductos(idProducto, idFabricantes, nombreProducto, precioUnitario, descripcionProducto, modelo);
            List<Productos> listaProductos = pman.consultarTodoProductos();
            fB.setListaProductos(listaProductos);
            String error = ("El registro se" + nombreProducto + " modificó correctamente");
            request.setAttribute("mensaje", error);
            IR = LISTA;
        }}

//-------------------------------------------------------------------------------
        if (action.equals("Consultar")) {
            List<Productos> listaProductos = pman.consultarTodoProductos();
            if (listaProductos == null) {
                fB.setError("<span style='color:red'>La lista esta vacia." + "<br></span>");
                IR = LISTA;
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("id", Login.id);
                request.setAttribute("img", Login.img);
                return mapping.findForward(IR);
            } else {
                fB.setListaProductos(listaProductos);
                IR = LISTA;
            }

        }
//-------------------------------------------------------------------------------        
        if (action.equalsIgnoreCase("IrAgregar")) {
            if (Login.nAcceso.equals("Solo Consulta")) {
                String error = "No posee Acceso a esta opcion";
                request.setAttribute("error", error);
                IR = PORTADA;
            } else {
            List<Fabricantes> listaFabricantes = fman.consultarTodosFabricantes();
            fB.setListaFabricantes(listaFabricantes);
            request.setAttribute("listaFabricantes", listaFabricantes);
            IR = AGREGAR;
        }}

        request.setAttribute("nombre", Login.nombre);
        request.setAttribute("nAcceso", Login.nAcceso);
        request.setAttribute("id", Login.id);
        request.setAttribute("img", Login.img);
        return mapping.findForward(IR);

    }

}
