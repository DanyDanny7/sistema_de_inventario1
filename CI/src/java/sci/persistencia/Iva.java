package sci.persistencia;
// Generated 02-sep-2018 16:06:08 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Iva generated by hbm2java
 */
public class Iva  implements java.io.Serializable {


     private Integer idIva;
     private Double ivaTasa;
     private Double ivaRetenido;
     private Double ivaPagado;
     private Double ivaTotal;
     private Double subTotalTransaccion;
     private Double totalTransaccion;
     private Set facturaDetalles = new HashSet(0);
     private Set comprases = new HashSet(0);

    public Iva() {
    }

    public Iva(Double ivaTasa, Double ivaRetenido, Double ivaPagado, Double ivaTotal, Double subTotalTransaccion, Double totalTransaccion, Set facturaDetalles, Set comprases) {
       this.ivaTasa = ivaTasa;
       this.ivaRetenido = ivaRetenido;
       this.ivaPagado = ivaPagado;
       this.ivaTotal = ivaTotal;
       this.subTotalTransaccion = subTotalTransaccion;
       this.totalTransaccion = totalTransaccion;
       this.facturaDetalles = facturaDetalles;
       this.comprases = comprases;
    }
   
    public Integer getIdIva() {
        return this.idIva;
    }
    
    public void setIdIva(Integer idIva) {
        this.idIva = idIva;
    }
    public Double getIvaTasa() {
        return this.ivaTasa;
    }
    
    public void setIvaTasa(Double ivaTasa) {
        this.ivaTasa = ivaTasa;
    }
    public Double getIvaRetenido() {
        return this.ivaRetenido;
    }
    
    public void setIvaRetenido(Double ivaRetenido) {
        this.ivaRetenido = ivaRetenido;
    }
    public Double getIvaPagado() {
        return this.ivaPagado;
    }
    
    public void setIvaPagado(Double ivaPagado) {
        this.ivaPagado = ivaPagado;
    }
    public Double getIvaTotal() {
        return this.ivaTotal;
    }
    
    public void setIvaTotal(Double ivaTotal) {
        this.ivaTotal = ivaTotal;
    }
    public Set getFacturaDetalles() {
        return this.facturaDetalles;
    }
    
    public void setFacturaDetalles(Set facturaDetalles) {
        this.facturaDetalles = facturaDetalles;
    }
    public Set getComprases() {
        return this.comprases;
    }
    
    public void setComprases(Set comprases) {
        this.comprases = comprases;
    }

    public Double getSubTotalTransaccion() {
        return subTotalTransaccion;
    }

    public void setSubTotalTransaccion(Double subTotalTransaccion) {
        this.subTotalTransaccion = subTotalTransaccion;
    }

    public Double getTotalTransaccion() {
        return totalTransaccion;
    }

    public void setTotalTransaccion(Double totalTransaccion) {
        this.totalTransaccion = totalTransaccion;
    }




}


