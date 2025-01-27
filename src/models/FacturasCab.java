package models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class FacturasCab implements java.io.Serializable {

    private long numfac;
    private Clientes clientes;
    private Date fechafac;
    private FacturasTot facturasTot;
    private Set facturasLins = new HashSet(0);

    public FacturasCab() {
    }

    public FacturasCab(long numfac, Clientes clientes) {
        this.numfac = numfac;
        this.clientes = clientes;
    }

    public FacturasCab(long numfac, Clientes clientes, Date fechafac, FacturasTot facturasTot, Set facturasLins) {
        this.numfac = numfac;
        this.clientes = clientes;
        this.fechafac = fechafac;
        this.facturasTot = facturasTot;
        this.facturasLins = facturasLins;
    }

    public long getNumfac() {
        return this.numfac;
    }

    public void setNumfac(long numfac) {
        this.numfac = numfac;
    }

    public Clientes getClientes() {
        return this.clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public Date getFechafac() {
        return this.fechafac;
    }

    public void setFechafac(Date fechafac) {
        this.fechafac = fechafac;
    }

    public FacturasTot getFacturasTot() {
        return this.facturasTot;
    }

    public void setFacturasTot(FacturasTot facturasTot) {
        this.facturasTot = facturasTot;
    }

    public Set getFacturasLins() {
        return this.facturasLins;
    }

    public void setFacturasLins(Set facturasLins) {
        this.facturasLins = facturasLins;
    }

}
