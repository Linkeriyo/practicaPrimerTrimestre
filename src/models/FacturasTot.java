    package models;

import java.math.BigDecimal;

public class FacturasTot implements java.io.Serializable {

    private long numfac;
    private FacturasCab facturasCab;
    private BigDecimal baseimp;
    private BigDecimal impDto;
    private BigDecimal impIva;
    private BigDecimal totalfac;

    public FacturasTot() {
    }

    public FacturasTot(FacturasCab facturasCab) {
        this.facturasCab = facturasCab;
        this.numfac = facturasCab.getNumfac();
    }

    public FacturasTot(FacturasCab facturasCab, BigDecimal baseimp, BigDecimal impDto, BigDecimal impIva, BigDecimal totalfac) {
        this.facturasCab = facturasCab;
        this.baseimp = baseimp;
        this.impDto = impDto;
        this.impIva = impIva;
        this.totalfac = totalfac;
        this.numfac = facturasCab.getNumfac();
    }

    public long getNumfac() {
        return this.numfac;
    }

    public void setNumfac(long numfac) {
        this.numfac = numfac;
    }

    public FacturasCab getFacturasCab() {
        return this.facturasCab;
    }

    public void setFacturasCab(FacturasCab facturasCab) {
        this.facturasCab = facturasCab;
    }

    public BigDecimal getBaseimp() {
        return this.baseimp;
    }

    public void setBaseimp(BigDecimal baseimp) {
        this.baseimp = baseimp;
    }

    public BigDecimal getImpDto() {
        return this.impDto;
    }

    public void setImpDto(BigDecimal impDto) {
        this.impDto = impDto;
    }

    public BigDecimal getImpIva() {
        return this.impIva;
    }

    public void setImpIva(BigDecimal impIva) {
        this.impIva = impIva;
    }

    public BigDecimal getTotalfac() {
        return this.totalfac;
    }

    public void setTotalfac(BigDecimal totalfac) {
        this.totalfac = totalfac;
    }

}
