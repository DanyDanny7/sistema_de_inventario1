/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sci.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metodos.Estaticas;
import metodos.Login;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import sci.actionforms.ActionFormMoneda;
import sci.mantenimientos.MonedaMantenimiento;
import sci.persistencia.Moneda;

/**
 *
 * @author daniel.bonillausam
 */
public class ActionMoneda extends org.apache.struts.action.Action {

    private static final String INICIO = "irInicioMoneda";
    private static final String AGREGAR = "irAgregarMoneda";
    private static final String MODIFICAR = "irModificarMoneda";
    private static final String LISTA = "irListaMoneda";
    private static final String CONF = "Go";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionFormMoneda formBean = (ActionFormMoneda) form;
        String nombreMoneda = formBean.getNombreMoneda();
        String simboloMoneda = formBean.getSimboloMoneda();
        String codigoMoneda = formBean.getCodigoMoneda();
        Double equivalencia = formBean.getEquivalencia();
        String monedaReferencia = formBean.getMonedaReferencia();
        String action = formBean.getAction();

        MonedaMantenimiento mman = new MonedaMantenimiento();
        String IR = null;

        System.out.println("el action trae valor = " + action);
        if (formBean == null) {
            System.out.println("hola mundo 1");
            System.out.println("Error el formBean null");
            IR = INICIO;
        }
        if (action == null) {
            System.out.println("hola mundo 2");
            System.out.println("Error action están null");
            IR = INICIO;
        }
//-------------------------------------------------------------------
        if (action.equals("Agregar")) {
            System.out.println("antes de validar");
            String advertencia = "";
            if (nombreMoneda == null || nombreMoneda.equals("")) {
                advertencia = "*Es requerido el Nombre de la Moneda <br>";
            }
            if (simboloMoneda == null || simboloMoneda.equals("")) {
                advertencia += "*Es requerido el Simbolo de la Moneda <br>";
            }
            if (codigoMoneda == null || codigoMoneda.equals("")) {
                advertencia += "*Es requerido el Codigo de la Moneda <br>";
            }
            if (equivalencia <= 0) {
                advertencia += "*Es requerido una Equivalencia de Cambio para la Moneda <br>";
            }
            if (monedaReferencia == null || monedaReferencia.equals("") || monedaReferencia.equals("Seleccionar")) {
                advertencia += "*Es requerido una Moneda de Referencia de Cambio <br>";
            }
            System.out.println(advertencia + "esta");
            if (!advertencia.equals("") || equivalencia <= 0) {
                formBean.setError("<spam style = 'color: red' > Por favor complete los espacios vacios  <br> " + advertencia + "</spam>");
                List<Moneda> listaMoneda = mman.consultarTodosMoneda();
                formBean.setListaMoneda(listaMoneda);
                request.setAttribute("listaMoneda", listaMoneda);

                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("nAcceso", Login.id);

                IR = AGREGAR;
                return mapping.findForward(IR);

            }
            System.out.println("luego de validar");
            List<Moneda> porNombre = mman.consultaNombreMoneda(nombreMoneda);
            List<Moneda> porCodigo = mman.consultaCodigoMoneda(codigoMoneda);
            if (porNombre != null || porCodigo != null) {
                if (porNombre != null) {
                    formBean.setError("<spam style='color:red'>Ya existe registrada una moneda con el nombre \" " + nombreMoneda + " \" <br></span>");
                }
                if (porCodigo != null) {
                    formBean.setError("<spam style='color:red'>Ya existe registrada una moneda con el codigo \" " + codigoMoneda + " \" <br></span>");
                }

                List<Moneda> listaMoneda = mman.consultarTodosMoneda();
                formBean.setListaMoneda(listaMoneda);
                request.setAttribute("listaMoneda", listaMoneda);
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("nAcceso", Login.id);

                IR = AGREGAR;
                return mapping.findForward(IR);
            } else {
                System.out.println("luego de ultima validacion");
                mman.guardarMoneda(nombreMoneda, simboloMoneda, codigoMoneda, equivalencia, monedaReferencia);
                List<Moneda> listaMoneda = mman.consultarTodosMoneda();
                formBean.setListaMoneda(listaMoneda);
                formBean.setMensaje("<spam style = 'color: blue' > Moneda ( " + nombreMoneda + " ) Agregada Correctamente <br></spam>");
                IR = LISTA;
            }
        }
//-------------------------------------------------------------------------------------        
        if (action.equals("Siguiente")) {
            System.out.println("antes de validar");
            String advertencia = "";
            if (nombreMoneda == null || nombreMoneda.equals("")) {
                advertencia = "*Es requerido el Nombre de la Moneda <br>";
            }
            if (simboloMoneda == null || simboloMoneda.equals("")) {
                advertencia += "*Es requerido el Simbolo de la Moneda <br>";
            }
            if (codigoMoneda == null || codigoMoneda.equals("")) {
                advertencia += "*Es requerido el Codigo de la Moneda <br>";
            }
            if (equivalencia <= 0) {
                advertencia += "*Es requerido una Equivalencia de Cambio para la Moneda <br>";
            }
            if (monedaReferencia == null || monedaReferencia.equals("") || monedaReferencia.equals("Seleccionar")) {
                advertencia += "*Es requerido una Moneda de Referencia de Cambio <br>";
            }
            Estaticas.nombreMoneda = nombreMoneda;
            Estaticas.simboloMoneda = simboloMoneda;

            System.out.println(advertencia + "esta");
            if (!advertencia.equals("") || equivalencia <= 0) {
                formBean.setError("<spam style = 'color: red' > Por favor complete los espacios vacios  <br> " + advertencia + "</spam>");
                List<Moneda> listaMoneda = mman.consultarTodosMoneda();
                formBean.setListaMoneda(listaMoneda);
                request.setAttribute("listaMoneda", listaMoneda);

                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("nAcceso", Login.id);

                IR = AGREGAR;
                return mapping.findForward(IR);

            }
            System.out.println("luego de validar");
            List<Moneda> porNombre = mman.consultaNombreMoneda(nombreMoneda);
            List<Moneda> porCodigo = mman.consultaCodigoMoneda(codigoMoneda);
            if (porNombre != null || porCodigo != null) {
                if (porNombre != null) {
                    formBean.setError("<spam style='color:red'>Ya existe registrada una moneda con el nombre \" " + nombreMoneda + " \" <br></span>");
                }
                if (porCodigo != null) {
                    formBean.setError("<spam style='color:red'>Ya existe registrada una moneda con el codigo \" " + codigoMoneda + " \" <br></span>");
                }

                List<Moneda> listaMoneda = mman.consultarTodosMoneda();
                formBean.setListaMoneda(listaMoneda);
                request.setAttribute("listaMoneda", listaMoneda);
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("nAcceso", Login.id);

                IR = AGREGAR;
                return mapping.findForward(IR);
            } else {
                System.out.println("luego de ultima validacion");
                mman.guardarMoneda(nombreMoneda, simboloMoneda, codigoMoneda, equivalencia, monedaReferencia);
                List<Moneda> listaMoneda = mman.consultarTodosMoneda();
                formBean.setListaMoneda(listaMoneda);

                request.setAttribute("idEmpresa", Estaticas.idEmpresa);
                request.setAttribute("nombreEmpresa", Estaticas.nombreEmpresa);
                request.setAttribute("nAcceso", Login.id);
                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nombreMoneda", Estaticas.nombreMoneda);
                request.setAttribute("simboloMoneda", Estaticas.simboloMoneda);
                IR = CONF;
            }
        }
//--------------------------------------------------------------------------
        if (action.equalsIgnoreCase("consultar")) {
            List<Moneda> listaMoneda = mman.consultarTodosMoneda();
            formBean.setListaMoneda(listaMoneda);
            IR = LISTA;
        }
//---------------------------------------------------------------------------
        if (action.equalsIgnoreCase("consultarId")) {
            Moneda moneda = (Moneda) mman.consultarMonedaId(nombreMoneda);
            formBean.setNombreMoneda(moneda.getNombreMoneda());
            formBean.setSimboloMoneda(moneda.getSimboloMoneda());
            formBean.setCodigoMoneda(moneda.getCodigoMoneda());
            formBean.setEquivalencia(moneda.getEquivalencia());
            formBean.setMonedaReferencia(moneda.getMonedaReferencia());
            List<Moneda> listaMoneda = mman.consultarTodosMoneda();
            formBean.setListaMoneda(listaMoneda);
            IR = MODIFICAR;
        }
//------------------------------------------------------------------------
        if (action.equals("modificar")) {
            String advertencia = "";
            if (nombreMoneda == null || nombreMoneda.equals("")) {
                advertencia = "*Es requerido el Nombre de la Moneda <br>";
            }
            if (simboloMoneda == null || simboloMoneda.equals("")) {
                advertencia += "*Es requerido el Simbolo de la Moneda <br>";
            }
            if (codigoMoneda == null || codigoMoneda.equals("")) {
                advertencia += "*Es requerido el Codigo de la Moneda <br>";
            }
            if (equivalencia == null || equivalencia.equals("") || equivalencia == 0) {
                advertencia += "*Es requerido una Equivalencia de Cambio para la Moneda <br>";
            }
            if (monedaReferencia == null || monedaReferencia.equals("")) {
                advertencia += "*Es requerido una Moneda de Referencia de Cambio <br>";
            }
            if (!advertencia.equals("")) {
                String error=("<spam style = 'color: red' > Por favor complete los espacios vacios  <br> " + advertencia + "</spam>");

                request.setAttribute("nombre", Login.nombre);
                request.setAttribute("nAcceso", Login.nAcceso);
                request.setAttribute("nAcceso", Login.id);
                request.setAttribute("error", error);

                return mapping.findForward(AGREGAR);
            }
            mman.modificarMoneda(nombreMoneda, simboloMoneda, codigoMoneda, equivalencia, monedaReferencia);
            List<Moneda> listaMoneda = mman.consultarTodosMoneda();
            formBean.setListaMoneda(listaMoneda);
            String Mensaje =(" Moneda ( " + nombreMoneda + " ) Modificada Correctamente");
            request.setAttribute("mensaje", Mensaje);
            IR = LISTA;
        }
//-----------------------------------------------------------------------------
        if (action.equalsIgnoreCase("eliminar")) {
            mman.eliminarMoneda(nombreMoneda);
            List<Moneda> listaMoneda = mman.consultarTodosMoneda();
            formBean.setListaMoneda(listaMoneda);
            String mensaje =("Moneda ( " + nombreMoneda + " ) Eliminada Correctamente");
            request.setAttribute("mensaje", mensaje);
            IR = LISTA;
        }
//------------------------------------------------------------------------------------
        if (action.equalsIgnoreCase("irAgregar")) {
            List<Moneda> listaMoneda = mman.consultarTodosMoneda();
            formBean.setListaMoneda(listaMoneda);
            request.setAttribute("listaMoneda", listaMoneda);
            IR = AGREGAR;
        }
//------------------------------------------------------------------------------------        
        request.setAttribute("nombre", Login.nombre);
        request.setAttribute("nAcceso", Login.nAcceso);
        request.setAttribute("nAcceso", Login.id);

        return mapping.findForward(IR);
    }

}
