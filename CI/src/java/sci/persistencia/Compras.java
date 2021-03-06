package sci.persistencia;
// Generated 09-20-2018 02:44:23 PM by Hibernate Tools 4.3.1



/**
 * Compras generated by hbm2java
 */
public class Compras  implements java.io.Serializable {


     private int idCompra;
     private Contactos contactos;
     private Inventario inventario;
     private Iva iva;
     private Productos productos;
     private String nDocumento;
     private String fechaCompra;
     private Double cantidad;
     private Double totalCompra;

    public Compras() {
    }

    public Compras(int idCompra) {
        this.idCompra = idCompra;
    }
    

	
    public Compras(int idCompra, Contactos contactos, Inventario inventario, Iva iva, Productos productos, String nDocumento) {
        this.idCompra = idCompra;
        this.contactos = contactos;
        this.inventario = inventario;
        this.iva = iva;
        this.productos = productos;
        this.nDocumento = nDocumento;
    }
    public Compras(int idCompra, Contactos contactos, Inventario inventario, Iva iva, Productos productos, String nDocumento, String fechaCompra, Double cantidad, Double totalCompra) {
       this.idCompra = idCompra;
       this.contactos = contactos;
       this.inventario = inventario;
       this.iva = iva;
       this.productos = productos;
       this.nDocumento = nDocumento;
       this.fechaCompra = fechaCompra;
       this.cantidad = cantidad;
       this.totalCompra = totalCompra;
    }
   
    public int getIdCompra() {
        return this.idCompra;
    }
    
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }
    public Contactos getContactos() {
        return this.contactos;
    }
    
    public void setContactos(Contactos contactos) {
        this.contactos = contactos;
    }
    public Inventario getInventario() {
        return this.inventario;
    }
    
    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }
    public Iva getIva() {
        return this.iva;
    }
    
    public void setIva(Iva iva) {
        this.iva = iva;
    }
    public Productos getProductos() {
        return this.productos;
    }
    
    public void setProductos(Productos productos) {
        this.productos = productos;
    }
    public String getnDocumento() {
        return this.nDocumento;
    }
    
    public void setnDocumento(String nDocumento) {
        this.nDocumento = nDocumento;
    }
    public String getFechaCompra() {
        return this.fechaCompra;
    }
    
    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    public Double getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
    public Double getTotalCompra() {
        return this.totalCompra;
    }
    
    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }

    




}


