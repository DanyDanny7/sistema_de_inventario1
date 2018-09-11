/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sci.actionforms;

import java.util.List;
import sci.persistencia.Fabricantes;

/**
 *
 * @author Admin104
 */
public class ActionFormFabricante extends org.apache.struts.action.ActionForm {

    private Integer idFabricante;
    private String nombreFabricante;
    private Integer numeroProductos;
    private String descripcionFabricante;
    private String fechaRegistroFabricante;
    private String error;
    private String action;
    private List <Fabricantes> listaFabricante;

    public Integer getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(Integer idFabricante) {
        this.idFabricante = idFabricante;
    }

    public String getNombreFabricante() {
        return nombreFabricante;
    }

    public void setNombreFabricante(String nombreFabricante) {
        this.nombreFabricante = nombreFabricante;
    }

    public Integer getNumeroProductos() {
        return numeroProductos;
    }

    public void setNumeroProductos(Integer numeroProductos) {
        this.numeroProductos = numeroProductos;
    }

    public String getDescripcionFabricante() {
        return descripcionFabricante;
    }

    public void setDescripcionFabricante(String descripcionFabricante) {
        this.descripcionFabricante = descripcionFabricante;
    }

    public String getFechaRegistroFabricante() {
        return fechaRegistroFabricante;
    }

    public void setFechaRegistroFabricante(String fechaRegistroFabricante) {
        this.fechaRegistroFabricante = fechaRegistroFabricante;
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

    public List<Fabricantes> getListaFabricante() {
        return listaFabricante;
    }

    public void setListaFabricante(List<Fabricantes> listaFabricante) {
        this.listaFabricante = listaFabricante;
    }

  }