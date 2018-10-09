/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sci.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metodos.Login;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import sci.actionforms.ActionFormIva;
import sci.mantenimientos.IvaMantenimiento;
import sci.persistencia.Iva;

/**
 *
 * @author daniel.bonillausam
 */
public class ActionIva extends org.apache.struts.action.Action {

    private static final String INDEX = "irIndex";
    private static final String PORTADA = "irPortada";
    private static final String INICIO = "irInicioIva";
    private static final String AGREGAR = "irAgregarIva";
    private static final String MODIFICAR = "irModificarIva";
    private static final String LISTA = "irListaIva";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionFormIva formBean = (ActionFormIva) form;
        Integer idIva = formBean.getIdIva();
        Double ivaTasa = formBean.getIvaTasa();
        Double ivaRetenido = formBean.getIvaRetenido();
        Double ivaPagado = formBean.getIvaPagado();
        Double ivaTotal = formBean.getIvaTotal();
        Double totalTransaccion = formBean.getTotalTransaccion();
        Double subTotalTransaccion = formBean.getTotalTransaccion();
        String action = formBean.getAction();

        IvaMantenimiento iman = new IvaMantenimiento();
        String IR = null;
        System.out.println("el valor de la accion es: " + action);

        if (Login.id == 0) {
            String mensaje = "Por Favor Inicie Session";
            request.setAttribute("mensaje", mensaje);
            return mapping.findForward(INDEX);

        }
        if (Login.nAcceso.equals("Solo Consulta") || Login.nAcceso.equals("Consulta e Ingresar")) {
            String error = "No posee Acceso a esta opcion";
            request.setAttribute("error", error);
            IR = PORTADA;
        } else {
//----------------------------------------------------------------------------------

            if (action.equals("Agregar")) {
                String advertencia = "";
                if (ivaTasa < 0) {
                    advertencia = "<spam style = 'color: red' > Es requerido seleccione un iva positivo <br></spam>";
                    formBean.setError(advertencia);
                    IR = AGREGAR;
                } else {
                    iman.guardarIva(ivaTasa, ivaRetenido, ivaPagado, ivaTotal, subTotalTransaccion, totalTransaccion);
                    List<Iva> listaIva = iman.consultarTodosIva();
                    formBean.setListaIva(listaIva);
                    formBean.setMensaje("<spam style = 'color: blue' > Registro IVA " + idIva + " Agregado Correctamente <br></spam>");
                    IR = LISTA;
                }
            }
//----------------------------------------------------------------------------------
            if (action.equalsIgnoreCase("consultar")) {
                List<Iva> listaIva = iman.consultarTodosIva();
                formBean.setListaIva(listaIva);

                IR = LISTA;
            }
//----------------------------------------------------------------------------------
            if (action.equalsIgnoreCase("Detalle")) {

                Iva iva = (Iva) iman.consultarIvaId(idIva);

                formBean.setIdIva(iva.getIdIva());
                formBean.setIvaTasa(iva.getIvaTasa());
                formBean.setIvaRetenido(iva.getIvaRetenido());
                formBean.setIvaPagado(iva.getIvaPagado());
                formBean.setIvaTotal(iva.getIvaTotal());
                IR = MODIFICAR;
            }
//----------------------------------------------------------------------------------
            if (action.equalsIgnoreCase("Modificar")) {
                if (ivaTasa < 0) {
                    String advertencia = "";
                    advertencia = "<spam style = 'color: red' > Es requerido seleccione un iva positivo <br></spam>";
                    formBean.setError(advertencia);
                    IR = MODIFICAR;
                } else {
                    int i = iman.modificarIva(idIva, ivaTasa, ivaRetenido, ivaPagado, ivaTotal, subTotalTransaccion, totalTransaccion);
                    System.out.println("i = " + i);
                    List<Iva> listaIva = iman.consultarTodosIva();
                    formBean.setMensaje("<spam style = 'color: blue' > Registro IVA " + idIva + " Modificado Correctamente <br></spam>");
                    formBean.setListaIva(listaIva);
                    IR = LISTA;
                }
            }
//----------------------------------------------------------------------------------
            if (action.equalsIgnoreCase("eliminar")) {
                iman.eliminarIva(idIva);
                List<Iva> listaIva = iman.consultarTodosIva();
                formBean.setMensaje("<spam style = 'color: blue' > Registro IVA " + idIva + " Eliminado Correctamente <br></spam>");
                formBean.setListaIva(listaIva);
                IR = LISTA;
            }}
//----------------------------------------------------------------------------------        
            request.setAttribute("nombre", Login.nombre);
            request.setAttribute("nAcceso", Login.nAcceso);
            request.setAttribute("id", Login.id);
            request.setAttribute("img", Login.img);

            return mapping.findForward(IR);
        }

    }
