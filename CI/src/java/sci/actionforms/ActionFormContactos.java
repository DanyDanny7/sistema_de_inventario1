package sci.actionforms;

import java.util.List;
import sci.persistencia.Contactos;

public class ActionFormContactos extends org.apache.struts.action.ActionForm {

    private Integer idContacto;
    private String nombreContacto;
    private String direccionContacto;
    private String telefonoContacto;
    private String encargadoContacto;
    private String telefonoEncargadoContacto;
    private String tipoContacto;
    private String emailContacto;
    private String fechaRegistroContacto ;
    private String error;
    private String action;
    private String mensaje;
    private List<Contactos> listaContacto;

    public Integer getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getDireccionContacto() {
        return direccionContacto;
    }

    public void setDireccionContacto(String direccionContacto) {
        this.direccionContacto = direccionContacto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getEncargadoContacto() {
        return encargadoContacto;
    }

    public void setEncargadoContacto(String encargadoContacto) {
        this.encargadoContacto = encargadoContacto;
    }

    public String getTelefonoEncargadoContacto() {
        return telefonoEncargadoContacto;
    }

    public void setTelefonoEncargadoContacto(String telefonoEncargadoContacto) {
        this.telefonoEncargadoContacto = telefonoEncargadoContacto;
    }

    public String getTipoContacto() {
        return tipoContacto;
    }

    public void setTipoContacto(String tipoContacto) {
        this.tipoContacto = tipoContacto;
    }

    public String getEmailContacto() {
        return emailContacto;
    }

    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }

    public String getFechaRegistroContacto() {
        return fechaRegistroContacto;
    }

    public void setFechaRegistroContacto(String fechaRegistroContacto) {
        this.fechaRegistroContacto = fechaRegistroContacto;
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

    public List<Contactos> getListaContacto() {
        return listaContacto;
    }

    public void setListaContacto(List<Contactos> listaContacto) {
        this.listaContacto = listaContacto;
    }

}
