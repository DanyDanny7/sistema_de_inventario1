package sci.actionforms;

//import java.text.SimpleDateFormat;

import java.util.List;
import sci.persistencia.Acceso;
import sci.persistencia.Empresa;
import sci.persistencia.Moneda;

public class ActionFormAcceso extends org.apache.struts.action.ActionForm {

    //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    private Integer idAcceso;
    private Integer idEmpresa;
    private String nombreEmpresa;
    private String nombreAcceso;
    private String apellidoAcceso;
    private String usuario;
    private String contrasena;
    private String eMail;
    private String tipoAcceso;
    private String fechaRegistroAcceso;
    private String error;
    private String action;
    private String button;
    private String mensaje;
    private List<Acceso> listaAcceso;
    private List<Empresa> listaEmpresa;
    private List<Moneda> listaMoneda;

    public List<Moneda> getListaMoneda() {
        return listaMoneda;
    }

    public void setListaMoneda(List<Moneda> listaMoneda) {
        this.listaMoneda = listaMoneda;
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

    public String getNombreAcceso() {
        return nombreAcceso;
    }

    public void setNombreAcceso(String nombreAcceso) {
        this.nombreAcceso = nombreAcceso;
    }

    public String getApellidoAcceso() {
        return apellidoAcceso;
    }

    public void setApellidoAcceso(String apellidoAcceso) {
        this.apellidoAcceso = apellidoAcceso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTipoAcceso() {
        return tipoAcceso;
    }

    public void setTipoAcceso(String tipoAcceso) {
        this.tipoAcceso = tipoAcceso;
    }

    public String getFechaRegistroAcceso() {
        return fechaRegistroAcceso;
    }

    public void setFechaRegistroAcceso(String fechaRegistroAcceso) {
        this.fechaRegistroAcceso = fechaRegistroAcceso;
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

    public List<Acceso> getListaAcceso() {
        return listaAcceso;
    }

    public void setListaAcceso(List<Acceso> listaAcceso) {
        this.listaAcceso = listaAcceso;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Empresa> getListaEmpresa() {
        return listaEmpresa;
    }

    public void setListaEmpresa(List<Empresa> listaEmpresa) {
        this.listaEmpresa = listaEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    
}