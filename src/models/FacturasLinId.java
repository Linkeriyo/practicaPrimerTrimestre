package models;

public class FacturasLinId implements java.io.Serializable {

    private long numfac;
    private long lineafac;

    public FacturasLinId() {
    }

    public FacturasLinId(long numfac, long lineafac) {
        this.numfac = numfac;
        this.lineafac = lineafac;
    }

    public long getNumfac() {
        return this.numfac;
    }

    public void setNumfac(long numfac) {
        this.numfac = numfac;
    }

    public long getLineafac() {
        return this.lineafac;
    }

    public void setLineafac(long lineafac) {
        this.lineafac = lineafac;
    }

    @Override
    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof FacturasLinId)) {
            return false;
        }
        FacturasLinId castOther = (FacturasLinId) other;

        return (this.getNumfac() == castOther.getNumfac())
                && (this.getLineafac() == castOther.getLineafac());
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 37 * result + (int) this.getNumfac();
        result = 37 * result + (int) this.getLineafac();
        return result;
    }

}
