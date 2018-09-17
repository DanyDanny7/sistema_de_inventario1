package sci.persistencia;
// Generated 02-sep-2018 16:06:08 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Inventario generated by hbm2java
 */
public class Inventario  implements java.io.Serializable {


     private Integer idInventario;
     private Productos productos;
     private Integer existencia;
     private String estadoExistencia;
     private Integer stockMinimo;
     private String estadoFisico;
     private Set comprases = new HashSet(0);

    public Inventario() {
    }

	
    public Inventario(Productos productos) {
        this.productos = productos;
    }
    public Inventario(Productos productos, Integer existencia, String estadoExistencia, Integer stockMinimo, String estadoFisico, Set comprases) {
       this.productos = productos;
       this.existencia = existencia;
       this.estadoExistencia = estadoExistencia;
       this.stockMinimo = stockMinimo;
       this.estadoFisico = estadoFisico;
       this.comprases = comprases;
    }
   
    public Integer getIdInventario() {
        return this.idInventario;
    }
    
    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }
    public Productos getProductos() {
        return this.productos;
    }
    
    public void setProductos(Productos productos) {
        this.productos = productos;
    }
    public Integer getExistencia() {
        return this.existencia;
    }
    
    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }
    public String getEstadoExistencia() {
        return this.estadoExistencia;
    }
    
    public void setEstadoExistencia(String estadoExistencia) {
        this.estadoExistencia = estadoExistencia;
    }
    public Integer getStockMinimo() {
        return this.stockMinimo;
    }
    
    public void setStockMinimo(Integer stockMinimo) {
        this.stockMinimo = stockMinimo;
    }
    public String getEstadoFisico() {
        return this.estadoFisico;
    }
    
    public void setEstadoFisico(String estadoFisico) {
        this.estadoFisico = estadoFisico;
    }
    public Set getComprases() {
        return this.comprases;
    }
    
    public void setComprases(Set comprases) {
        this.comprases = comprases;
    }




}


