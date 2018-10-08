package sci.actionforms;

import java.util.List;
import sci.persistencia.Inventario;

public class ActionFormInventario extends org.apache.struts.action.ActionForm {
   private Integer idInventario; 
   private Integer idProducto; 
   private Integer existencia; 
   private String estadoExistencia; 
   private int stockMinimo;
   private String estadoFisico; 
   private  List<Inventario> listainventario; 
   private String error;
    private String action;

    public List<Inventario> getListainventario() {
        return listainventario;
    }

    public void setListainventario(List<Inventario> listainventario) {
        this.listainventario = listainventario;
    }

    public Integer getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

 

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

   

   

    public Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }

    public String getEstadoExistencia() {
        return estadoExistencia;
    }

    public void setEstadoExistencia(String estadoExistencia) {
        this.estadoExistencia = estadoExistencia;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public String getEstadoFisico() {
        return estadoFisico;
    }

    public void setEstadoFisico(String estadoFisico) {
        this.estadoFisico = estadoFisico;
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
   
     
}
