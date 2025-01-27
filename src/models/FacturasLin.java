package models;

import java.math.BigDecimal;

public class FacturasLin implements java.io.Serializable {

    private FacturasLinId id;
    private Articulos articulos;
    private FacturasCab facturasCab;
    private BigDecimal cantidad;
    private BigDecimal precio;
    private BigDecimal dtolinea;
    private BigDecimal ivalinea;

    public FacturasLin() {
    }

    public FacturasLin(FacturasLinId id, Articulos articulos, FacturasCab facturasCab, BigDecimal cantidad, BigDecimal precio, BigDecimal dtolinea, BigDecimal ivalinea) {
        this.id = id;
        this.articulos = articulos;
        this.facturasCab = facturasCab;
        this.cantidad = cantidad;
        this.precio = precio;
        this.dtolinea = dtolinea;
        this.ivalinea = ivalinea;
    }

    public FacturasLinId getId() {
        return this.id;
    }

    public void setId(FacturasLinId id) {
        this.id = id;
    }

    public Articulos getArticulos() {
        return this.articulos;
    }

    public void setArticulos(Articulos articulos) {
        this.articulos = articulos;
    }

    public FacturasCab getFacturasCab() {
        return this.facturasCab;
    }

    public void setFacturasCab(FacturasCab facturasCab) {
        this.facturasCab = facturasCab;
    }

    public BigDecimal getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return this.precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getDtolinea() {
        return this.dtolinea;
    }

    public void setDtolinea(BigDecimal dtolinea) {
        this.dtolinea = dtolinea;
    }

    public BigDecimal getIvalinea() {
        return this.ivalinea;
    }

    public void setIvalinea(BigDecimal ivalinea) {
        this.ivalinea = ivalinea;
    }

}
