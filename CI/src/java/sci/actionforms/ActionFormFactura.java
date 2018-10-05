/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sci.actionforms;

import java.util.List;
import sci.persistencia.Contactos;
import sci.persistencia.FacturaDetalle;
import sci.persistencia.FacturaEncabezado;
import sci.persistencia.Productos;

/**
 *
 * @author daniel.bonillausam
 */
public class ActionFormFactura extends org.apache.struts.action.ActionForm{
    
    //factura Encabezado
    private Integer idFacturaEncabezado;
    private Integer idContacto;
    private Integer idEmpresa;
    private String fechaFactura;
    private String estado;
    private Double totalTransaccion;
    private Double subTotalTransaccion;
    private List<FacturaEncabezado> listaFacturaEncabezado;
    
    //factura Detalle
    private Integer idFacturaDetalle;
    private Integer idConfiguracion;
    private Integer idIva;
    private Integer idProducto;
    private Integer cantidad;
    private Double totalFila;
    private Double totalColumna;
    private Double subtotalColumna;
    private List<FacturaDetalle> listaFacturaDetalle;
    
    //Adicional
    private String action;
    
    private List<Contactos> listaContactos;
    private List<Productos> listaProductos;

    public Integer getIdFacturaEncabezado() {
        return idFacturaEncabezado;
    }

    public void setIdFacturaEncabezado(Integer idFacturaEncabezado) {
        this.idFacturaEncabezado = idFacturaEncabezado;
    }

    public Integer getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getTotalTransaccion() {
        return totalTransaccion;
    }

    public void setTotalTransaccion(Double totalTransaccion) {
        this.totalTransaccion = totalTransaccion;
    }

    public Double getSubTotalTransaccion() {
        return subTotalTransaccion;
    }

    public void setSubTotalTransaccion(Double subTotalTransaccion) {
        this.subTotalTransaccion = subTotalTransaccion;
    }

    public List<FacturaEncabezado> getListaFacturaEncabezado() {
        return listaFacturaEncabezado;
    }

    public void setListaFacturaEncabezado(List<FacturaEncabezado> listaFacturaEncabezado) {
        this.listaFacturaEncabezado = listaFacturaEncabezado;
    }

    public Integer getIdFacturaDetalle() {
        return idFacturaDetalle;
    }

    public void setIdFacturaDetalle(Integer idFacturaDetalle) {
        this.idFacturaDetalle = idFacturaDetalle;
    }

    public Integer getIdConfiguracion() {
        return idConfiguracion;
    }

    public void setIdConfiguracion(Integer idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    public Integer getIdIva() {
        return idIva;
    }

    public void setIdIva(Integer idIva) {
        this.idIva = idIva;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotalFila() {
        return totalFila;
    }

    public void setTotalFila(Double totalFila) {
        this.totalFila = totalFila;
    }

    public Double getTotalColumna() {
        return totalColumna;
    }

    public void setTotalColumna(Double totalColumna) {
        this.totalColumna = totalColumna;
    }

    public Double getSubtotalColumna() {
        return subtotalColumna;
    }

    public void setSubtotalColumna(Double subtotalColumna) {
        this.subtotalColumna = subtotalColumna;
    }

    public List<FacturaDetalle> getListaFacturaDetalle() {
        return listaFacturaDetalle;
    }

    public void setListaFacturaDetalle(List<FacturaDetalle> listaFacturaDetalle) {
        this.listaFacturaDetalle = listaFacturaDetalle;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<Contactos> getListaContactos() {
        return listaContactos;
    }

    public void setListaContactos(List<Contactos> listaContactos) {
        this.listaContactos = listaContactos;
    }

    public List<Productos> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    
}
