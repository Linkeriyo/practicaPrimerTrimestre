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

public class XMLFactura {

    SimpleDateFormat sdf;
    String xmlString;
    FacturasCab factura;

    public XMLFactura(FacturasCab factura) {
        this.xmlString = "";
        this.sdf = FacturasProgram.sdf;
        this.factura = factura;

        beginFile();
        addFacturaCabSimpleAttributes();
        addTotal();
        addLins();
        endFile();
    }

    private void concat(String s) {
        xmlString = xmlString + s;
    }

    private void beginFile() {
        concat("<?xml version=\"1.0\" encoding=\"UTF-8\"?><factura>");
    }

    private void endFile() {
        concat("</factura>");
    }
    
    private void addSimpleItem(String key, String value) {
        concat("<" + key + ">" + value + "</" + key + ">"); 
    }
    
    private void openItem(String key) {
        concat("<" + key + ">");
    }
    
    private void closeItem(String key) {
        concat("</" + key + ">");
    }

    private void addFacturaCabSimpleAttributes() {
        String numfac = String.valueOf(factura.getNumfac());
        String cliente = factura.getClientes().getDnicif();
        String date = sdf.format(factura.getFechafac());
        
        addSimpleItem("numFactura", numfac);
        addSimpleItem("cliente", cliente);
        addSimpleItem("fecha", date);
    }

    private void addTotal() {
        FacturasTot total = factura.getFacturasTot();
        String baseimp = FacturasProgram.bigDecimalToString(total.getBaseimp(), null);
        String impDto = FacturasProgram.bigDecimalToString(total.getImpDto(), null);
        String impiva = FacturasProgram.bigDecimalToString(total.getImpIva(), null);
        String totalFac = FacturasProgram.bigDecimalToString(total.getTotalfac(), null);

        openItem("total");
        addSimpleItem("baseImponible", baseimp);
        addSimpleItem("importeDescuento", impDto);
        addSimpleItem("importeIva", impiva);
        addSimpleItem("totalFactura", totalFac);
        closeItem("total");
    }

    private void addLins() {
        ArrayList<FacturasLin> lineas = new ArrayList<>();
        cFacturasLin.getListaFacturasLin().forEach(lf -> {
            if (lf.getFacturasCab().getNumfac() == factura.getNumfac()) {
                lineas.add(lf);
            }
        });

        openItem("lineas");
        for (int i = 0; i < lineas.size(); i++) {
            FacturasLin lf = lineas.get(i);
            
            String numLin = String.valueOf(lf.getId().getLineafac());
            String articuloRef = lf.getArticulos().getReferencia();
            String articuloDesc = lf.getArticulos().getDescripcion();
            String cant = FacturasProgram.bigDecimalToString(lf.getCantidad(), null);
            String price = FacturasProgram.bigDecimalToString(lf.getPrecio(), null);
            String dtoLin = FacturasProgram.bigDecimalToString(lf.getDtolinea(), null);
            String ivaLin = FacturasProgram.bigDecimalToString(lf.getIvalinea(), null);
            openItem("linea");
            addSimpleItem("numeroLinea", numLin);
            addSimpleItem("articuloRef", articuloRef);
            addSimpleItem("articuloDef", articuloDesc);
            addSimpleItem("cantidad", cant);
            addSimpleItem("precio", price);
            addSimpleItem("descuento", dtoLin);
            addSimpleItem("iva", ivaLin);
            closeItem("linea");
        }
        closeItem("linea");
    }

    public void write(File file) {
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(xmlString);
            fw.flush();
        } catch (IOException ex) {
            Logger.getLogger(XMLFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
