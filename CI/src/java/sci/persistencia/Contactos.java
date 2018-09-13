package sci.persistencia;
// Generated 02-sep-2018 16:06:08 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Contactos generated by hbm2java
 */
public class Contactos  implements java.io.Serializable {


     private Integer idContacto;
     private String nombreContacto;
     private String direccionContacto;
     private String telefonoContacto;
     private String encargadoContacto;
     private String telefonoEncargadoContacto;
     private String tipoContacto;
     private String emailContacto;
     private String fechaRegistroContacto;
     private Set facturaEncabezados = new HashSet(0);
     private Set comprases = new HashSet(0);

    public Contactos() {
    }

    public Contactos(String nombreContacto, String direccionContacto, String telefonoContacto, String encargadoContacto, String telefonoEncargadoContacto, String tipoContacto, String emailContacto, String fechaRegistroContacto, Set facturaEncabezados, Set comprases) {
       this.nombreContacto = nombreContacto;
       this.direccionContacto = direccionContacto;
       this.telefonoContacto = telefonoContacto;
       this.encargadoContacto = encargadoContacto;
       this.telefonoEncargadoContacto = telefonoEncargadoContacto;
       this.tipoContacto = tipoContacto;
       this.emailContacto = emailContacto;
       this.fechaRegistroContacto = fechaRegistroContacto;
       this.facturaEncabezados = facturaEncabezados;
       this.comprases = comprases;
    }
   
    public Integer getIdContacto() {
        return this.idContacto;
    }
    
    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }
    public String getNombreContacto() {
        return this.nombreContacto;
    }
    
    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }
    public String getDireccionContacto() {
        return this.direccionContacto;
    }
    
    public void setDireccionContacto(String direccionContacto) {
        this.direccionContacto = direccionContacto;
    }
    public String getTelefonoContacto() {
        return this.telefonoContacto;
    }
    
    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }
    public String getEncargadoContacto() {
        return this.encargadoContacto;
    }
    
    public void setEncargadoContacto(String encargadoContacto) {
        this.encargadoContacto = encargadoContacto;
    }
    public String getTelefonoEncargadoContacto() {
        return this.telefonoEncargadoContacto;
    }
    
    public void setTelefonoEncargadoContacto(String telefonoEncargadoContacto) {
        this.telefonoEncargadoContacto = telefonoEncargadoContacto;
    }
    public String getTipoContacto() {
        return this.tipoContacto;
    }
    
    public void setTipoContacto(String tipoContacto) {
        this.tipoContacto = tipoContacto;
    }
    public String getEmailContacto() {
        return this.emailContacto;
    }
    
    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }
    public String getFechaRegistroContacto() {
        return this.fechaRegistroContacto;
    }
    
    public void setFechaRegistroContacto(String fechaRegistroContacto) {
        this.fechaRegistroContacto = fechaRegistroContacto;
    }
    public Set getFacturaEncabezados() {
        return this.facturaEncabezados;
    }
    
    public void setFacturaEncabezados(Set facturaEncabezados) {
        this.facturaEncabezados = facturaEncabezados;
    }
    public Set getComprases() {
        return this.comprases;
    }
    
    public void setComprases(Set comprases) {
        this.comprases = comprases;
    }




}


