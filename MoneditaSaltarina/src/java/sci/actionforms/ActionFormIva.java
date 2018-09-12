/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sci.actionforms;

import java.util.List;
import sci.persistencia.Iva;

/**
 *
 * @author daniel.bonillausam
 */
public class ActionFormIva extends org.apache.struts.action.ActionForm{
    
    private Integer idIva;
    private Double ivaTasa;
    private Double ivaRetenido;
    private Double ivaPagado;
    private Double ivaTotal;
    private List<Iva> listaIva;
    private String error;
    private String action;
    private String mensaje;

    public Integer getIdIva() {
        return idIva;
    }

    public void setIdIva(Integer idIva) {
        this.idIva = idIva;
    }

    public Double getIvaTasa() {
        return ivaTasa;
    }

    public void setIvaTasa(Double ivaTasa) {
        this.ivaTasa = ivaTasa;
    }

    public Double getIvaRetenido() {
        return ivaRetenido;
    }

    public void setIvaRetenido(Double ivaRetenido) {
        this.ivaRetenido = ivaRetenido;
    }

    public Double getIvaPagado() {
        return ivaPagado;
    }

    public void setIvaPagado(Double ivaPagado) {
        this.ivaPagado = ivaPagado;
    }

    public List<Iva> getListaIva() {
        return listaIva;
    }

    public void setListaIva(List<Iva> listaIva) {
        this.listaIva = listaIva;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Double getIvaTotal() {
        return ivaTotal;
    }

    public void setIvaTotal(Double ivaTotal) {
        this.ivaTotal = ivaTotal;
    }
    
    
    
    
}
