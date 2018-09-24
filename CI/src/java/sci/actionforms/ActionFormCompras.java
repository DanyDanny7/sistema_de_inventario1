/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sci.actionforms;

import java.util.List;
import sci.persistencia.Compras;

/**
 *
 * @author memo_
 */
public class ActionFormCompras extends org.apache.struts.action.ActionForm{
    private Integer idCompra;
    private String  nDocumento; 
    private Integer idContacto; 
    private Integer  idInventario; 
    private Double cantidad; 
    private Integer idIva;
    private Integer IdProducto;
    private String fechaCompra; 
    private Double totalCompra;
    private String action ; 
    private String error; 
    
    

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getnDocumento() {
        return nDocumento;
    }

    public void setnDocumento(String nDocumento) {
        this.nDocumento = nDocumento;
    }

    
    private List<Compras> listaCompras; 

    public Integer getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }
    
    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public Integer getIdIva() {
        return idIva;
    }

    public void setIdIva(Integer idIva) {
        this.idIva = idIva;
    }

    public Integer getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(Integer IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Compras> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Compras> listaCompras) {
        this.listaCompras = listaCompras;
    }
    
    
    
    
    
}
