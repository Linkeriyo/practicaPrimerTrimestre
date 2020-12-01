package exportmodels;

import controllers.FacturasProgram;
import static controllers.FacturasProgram.cFacturasLin;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.FacturasCab;
import models.FacturasLin;
import models.FacturasTot;

public class JSONFactura {

    SimpleDateFormat sdf;
    String jsonString;
    FacturasCab factura;

    public JSONFactura(FacturasCab factura) {
        this.jsonString = "";
        this.sdf = FacturasProgram.sdf;
        this.factura = factura;

        beginFile();
        addFacturaCabSimpleAttributes(false);
        addTotal(false);
        addLins(true);
        endFile();
    }

    private void concat(String s) {
        jsonString = jsonString + s;
    }

    private void beginFile() {
        concat("{");
    }

    private void endFile() {
        concat("}");
    }

    private void openArray(String key) {
        concat("\"" + key + "\":[");
    }

    private void closeArray(boolean isLast) {
        concat("]");
        if (!isLast) {
            concat(",");
        }
    }

    private void openArrayItem() {
        concat("{");
    }

    private void closeArrayItem(boolean isLast) {
        concat("}");
        if (!isLast) {
            concat(",");
        }
    }

    private void addSimpleItem(String key, String value, boolean isLast) {
        concat("\"" + key + "\":\"" + value + "\"");
        if (!isLast) {
            concat(",");
        }
    }

    private void openComplexItem(String key) {
        concat("\"" + key + "\":{");
    }

    private void closeComplexItem(boolean isLast) {
        concat("}");
        if (!isLast) {
            concat(",");
        }
    }

    private void addFacturaCabSimpleAttributes(boolean isLast) {
        String numfac = String.valueOf(factura.getNumfac());
        String cliente = factura.getClientes().getDnicif();
        String date = sdf.format(factura.getFechafac());

        addSimpleItem("numFactura", numfac, false);
        addSimpleItem("cliente", cliente, false);
        addSimpleItem("fecha", date, isLast);
    }

    private void addTotal(boolean isLast) {
        FacturasTot total = factura.getFacturasTot();
        String baseimp = FacturasProgram.bigDecimalToString(total.getBaseimp(), null);
        String impDto = FacturasProgram.bigDecimalToString(total.getImpDto(), null);
        String impiva = FacturasProgram.bigDecimalToString(total.getImpIva(), null);
        String totalFac = FacturasProgram.bigDecimalToString(total.getTotalfac(), null);

        openComplexItem("total");
        addSimpleItem("baseImponible", baseimp, false);
        addSimpleItem("importeDescuento", impDto, false);
        addSimpleItem("importeIva", impiva, false);
        addSimpleItem("totalFactura", totalFac, true);
        closeComplexItem(isLast);
    }

    private void addLins(boolean isLast) {
        ArrayList<FacturasLin> lineas = new ArrayList<>();
        cFacturasLin.getListaFacturasLin().forEach(lf -> {
            if (lf.getFacturasCab().getNumfac() == factura.getNumfac()) {
                lineas.add(lf);
            }
        });

        openArray("lineas");
        for (int i = 0; i < lineas.size(); i++) {
            FacturasLin lf = lineas.get(i);
            
            String numLin = String.valueOf(lf.getId().getLineafac());
            String articuloRef = lf.getArticulos().getReferencia();
            String articuloDesc = lf.getArticulos().getDescripcion();
            String cant = FacturasProgram.bigDecimalToString(lf.getCantidad(), null);
            String price = FacturasProgram.bigDecimalToString(lf.getPrecio(), null);
            String dtoLin = FacturasProgram.bigDecimalToString(lf.getDtolinea(), null);
            String ivaLin = FacturasProgram.bigDecimalToString(lf.getIvalinea(), null);
            openArrayItem();
            addSimpleItem("numeroLinea", numLin, false);
            addSimpleItem("articuloRef", articuloRef, false);
            addSimpleItem("articuloDef", articuloDesc, false);
            addSimpleItem("cantidad", cant, false);
            addSimpleItem("precio", price, false);
            addSimpleItem("descuento", dtoLin, false);
            addSimpleItem("iva", ivaLin, true);
            closeArrayItem(false);
            
        }
        //Eliminar la última coma.
        jsonString = jsonString.substring(0, jsonString.length() - 1);

        closeArray(isLast);
    }

    public void write(File file) {
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(jsonString);
            fw.flush();
        } catch (IOException ex) {
            Logger.getLogger(JSONFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
