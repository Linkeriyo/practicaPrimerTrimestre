package models;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Articulos implements java.io.Serializable {

     private String referencia;
     private String descripcion;
     private BigDecimal precio;
     private BigDecimal porciva;
     private BigDecimal stock;
     private Set facturasLins = new HashSet(0);

    public Articulos() {
    }

    public Articulos(String referencia, String descripcion, BigDecimal precio, BigDecimal iva, BigDecimal stock) {
        this.referencia = referencia;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }
    
    public Articulos(String referencia, String descripcion, BigDecimal precio, BigDecimal porciva, BigDecimal stock, Set facturasLins) {
       this.referencia = referencia;
       this.descripcion = descripcion;
       this.precio = precio;
       this.porciva = porciva;
       this.stock = stock;
       this.facturasLins = facturasLins;
    }
   
    public String getReferencia() {
        return this.referencia;
    }
    
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public BigDecimal getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public BigDecimal getPorciva() {
        return this.porciva;
    }
    
    public void setPorciva(BigDecimal porciva) {
        this.porciva = porciva;
    }
    public BigDecimal getStock() {
        return this.stock;
    }
    
    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }
    public Set getFacturasLins() {
        return this.facturasLins;
    }
    
    public void setFacturasLins(Set facturasLins) {
        this.facturasLins = facturasLins;
    }




}


