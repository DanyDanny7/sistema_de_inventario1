package sci.persistencia;
// Generated 02-sep-2018 16:06:08 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Configuracion generated by hbm2java
 */
public class Configuracion  implements java.io.Serializable {


     private Integer idConfiguracion;
     private Acceso acceso;
     private Empresa empresa;
     private Moneda moneda;
     private byte[] logo;
     private Double iva;
     private String zonaHoraria;
     private Set facturaDetalles = new HashSet(0);

    public Configuracion() {
    }

	
    public Configuracion(Acceso acceso, Empresa empresa, Moneda moneda) {
        this.acceso = acceso;
        this.empresa = empresa;
        this.moneda = moneda;
    }
    public Configuracion(Acceso acceso, Empresa empresa, Moneda moneda, byte[] logo, Double iva, String zonaHoraria, Set facturaDetalles) {
       this.acceso = acceso;
       this.empresa = empresa;
       this.moneda = moneda;
       this.logo = logo;
       this.iva = iva;
       this.zonaHoraria = zonaHoraria;
       this.facturaDetalles = facturaDetalles;
    }
   
    public Integer getIdConfiguracion() {
        return this.idConfiguracion;
    }
    
    public void setIdConfiguracion(Integer idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }
    public Acceso getAcceso() {
        return this.acceso;
    }
    
    public void setAcceso(Acceso acceso) {
        this.acceso = acceso;
    }
    public Empresa getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    public Moneda getMoneda() {
        return this.moneda;
    }
    
    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }
    public byte[] getLogo() {
        return this.logo;
    }
    
    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
    public Double getIva() {
        return this.iva;
    }
    
    public void setIva(Double iva) {
        this.iva = iva;
    }
    public String getZonaHoraria() {
        return this.zonaHoraria;
    }
    
    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }
    public Set getFacturaDetalles() {
        return this.facturaDetalles;
    }
    
    public void setFacturaDetalles(Set facturaDetalles) {
        this.facturaDetalles = facturaDetalles;
    }




}

