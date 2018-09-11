package sci.actionforms;

import java.util.List;
import sci.persistencia.Fabricantes;
import sci.persistencia.Productos;

public class ActionFormProductos extends org.apache.struts.action.ActionForm {
    
    private Integer idProducto;
     private Integer idFabricantes;
     private String nombreProducto;
     private Double precioUnitario;
     private String descripcionProducto;
     private String modelo;
     private String error;
     private String action;
     private String mensaje;
     private List<Productos> listaProductos;
     private List<Fabricantes> listaFabricantes;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdFabricantes() {
        return idFabricantes;
    }

    public void setIdFabricantes(Integer idFabricantes) {
        this.idFabricantes = idFabricantes;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
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

    
    public List<Productos> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public List<Fabricantes> getListaFabricantes() {
        return listaFabricantes;
    }

    public void setListaFabricantes(List<Fabricantes> listaFabricantes) {
        this.listaFabricantes = listaFabricantes;
    }
     
     
    
}
