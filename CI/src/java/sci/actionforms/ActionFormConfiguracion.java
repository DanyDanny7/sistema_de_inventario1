/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sci.actionforms;

import java.util.List;
import sci.persistencia.Configuracion;
import sci.persistencia.Moneda;

/**
 *
 * @author daniel.bonillausam
 */
public class ActionFormConfiguracion extends org.apache.struts.action.ActionForm {

    private Integer idConfiguracion;
    private Integer idAcceso;
    private Integer idEmpresa;
    private String nombreMoneda;
    private byte[] logo;
    private String logo1;
    private Double iva;
    private String zonaHoraria;
    private String error;
    private String action;
    private List<Configuracion> listaConfiguracion;
    private List<Moneda> listaMoneda;

    public Integer getIdConfiguracion() {
        return idConfiguracion;
    }

    public void setIdConfiguracion(Integer idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    public Integer getIdAcceso() {
        return idAcceso;
    }

    public void setIdAcceso(Integer idAcceso) {
        this.idAcceso = idAcceso;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public String getZonaHoraria() {
        return zonaHoraria;
    }

    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
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

    public List<Configuracion> getListaConfiguracion() {
        return listaConfiguracion;
    }

    public void setListaConfiguracion(List<Configuracion> listaConfiguracion) {
        this.listaConfiguracion = listaConfiguracion;
    }

    public List<Moneda> getListaMoneda() {
        return listaMoneda;
    }

    public void setListaMoneda(List<Moneda> listaMoneda) {
        this.listaMoneda = listaMoneda;
    }

    public String getLogo1() {
        return logo1;
    }

    public void setLogo1(String logo1) {
        this.logo1 = logo1;
    }

    
    
}
