package views.facturas;

import controllers.CtrlArticulos;
import controllers.CtrlFacturasCab;
import controllers.CtrlFacturasLin;
import controllers.FacturasProgram;
import exceptions.DeniedException;
import exceptions.RequiredFieldException;
import java.math.BigDecimal;
import java.nio.file.FileAlreadyExistsException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Articulos;
import models.FacturasCab;
import models.FacturasLin;
import models.FacturasLinId;

public class InsertFacturaLinDialog extends javax.swing.JDialog {

    CtrlFacturasCab cFacturasCab;
    CtrlFacturasLin cFacturasLin;
    CtrlArticulos cArticulos;
    FacturasDialog parent;

    public InsertFacturaLinDialog(FacturasDialog parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        cFacturasCab = FacturasProgram.cFacturasCab;
        cFacturasLin = FacturasProgram.cFacturasLin;
        cArticulos = FacturasProgram.cArticulos;
        initComponents();
        if (parent.getSelectedFacturaCab() != null) {
            selectedFacCabLabel.setText("Columna seleccionada: " + parent.getSelectedFacturaCab().getNumfac());
        }

    }

    public void setNumfacTextField(String referenceField) {
        this.artReferenceField.setText(referenceField);
    }

    public void setSelectedFacCabLabel(String selectedFacId) {
        this.selectedFacCabLabel.setText(selectedFacId);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        acceptButton = new javax.swing.JButton();
        artReferenceField = new javax.swing.JTextField();
        selectedFacCabLabel = new javax.swing.JLabel();
        cantField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        selectButton = new javax.swing.JButton();
        ivaField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dtoField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seleccionar factura");
        setModal(true);
        setResizable(false);

        jLabel1.setText("Artículo");

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        acceptButton.setText("Aceptar");
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        selectedFacCabLabel.setText("Factura seleccionada:");

        jLabel3.setText("Cantidad");

        priceField.setEnabled(false);

        jLabel4.setText("Precio");

        selectButton.setText("Seleccionar");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        ivaField.setEnabled(false);

        jLabel7.setText("IVA");

        jLabel8.setText("Descuento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(acceptButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(selectedFacCabLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtoField, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cantField, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(artReferenceField)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(selectButton))
                                .addComponent(priceField, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(ivaField, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectedFacCabLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(artReferenceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(selectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ivaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dtoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(acceptButton))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed

        try {
            if (artReferenceField.getText().isEmpty()
                    || priceField.getText().isEmpty()
                    || dtoField.getText().isEmpty()
                    || ivaField.getText().isEmpty()) {
                throw new RequiredFieldException("Todos los campos son obligatorios.");
            }

            //Formar la nueva línea.
            FacturasCab facturaCab = parent.getSelectedFacturaCab();
            Articulos articulo = cArticulos.getArticuloById(artReferenceField.getText());
            if (articulo == null) {
                throw new NullPointerException("No se ha encontrado el artículo");
            }
            String priceStr = priceField.getText();
            if (priceStr.endsWith("€")) {
                priceStr = priceStr.substring(0, priceStr.length() - 1);
            }
            String dtoStr = dtoField.getText();
            if (dtoStr.endsWith("%")) {
                dtoStr = dtoStr.substring(0, dtoStr.length() - 1);
            }
            String ivaStr = ivaField.getText();
            if (ivaStr.endsWith("%")) {
                ivaStr = ivaStr.substring(0, ivaStr.length() - 1);
            }

            long idLinea = cFacturasCab.getNextAvailableLinId(facturaCab.getNumfac());
            FacturasLinId id = new FacturasLinId(facturaCab.getNumfac(), idLinea);
            BigDecimal cant = BigDecimal.valueOf(Double.parseDouble(cantField.getText()));
            BigDecimal price = BigDecimal.valueOf(Double.parseDouble(priceStr));
            BigDecimal dto = BigDecimal.valueOf(Double.parseDouble(dtoStr));
            BigDecimal iva = BigDecimal.valueOf(Double.parseDouble(ivaStr));

            //Restar la cantidad ocupada al artículo.
            articulo.setStock(articulo.getStock().subtract(cant));
            cArticulos.updateArticulo(articulo);

            //Insertar la línea
            FacturasLin linea = new FacturasLin(id, articulo, facturaCab, cant, price, dto, iva);

            // Buscar si hay alguna línea con el artículo
            cFacturasLin.updateList();
            boolean articuloExists = false;
            for (FacturasLin lf : cFacturasLin.getListaFacturasLin()) {
                if (lf.getId().getNumfac() == linea.getId().getNumfac()) {
                    if (lf.getArticulos().getReferencia().equals(
                            linea.getArticulos().getReferencia())) {
                        articuloExists = true;
                    }
                }
            }
            
            if (articuloExists) {
                boolean confirmed = JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
                        "Ya existe una línea con ese artículo, ¿quieres sumarle la cantidad?",
                        "Confirmación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );

                if (!confirmed) {
                    throw new DeniedException();
                }
            }
            cFacturasLin.insertFacturaLin(linea, articuloExists);

            //Actualizar todo lo modificado.
            cFacturasCab.calculateTotalThenGet(facturaCab.getNumfac());
            cArticulos.updateList();
            cFacturasLin.updateList();
            cFacturasCab.updateList();
            parent.refreshSelectedFacCab();
            parent.fullTableRefresh();
            setVisible(false);

        } catch (NullPointerException | RequiredFieldException ex) {
            JOptionPane.showMessageDialog(null,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null,
                    "El formato de un campo no es válido.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (DeniedException ex) {
        }
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
        parent.resetSelectDialog();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        try {
            Articulos articulo = cArticulos.getArticuloById(artReferenceField.getText());
            if (articulo == null) {
                throw new Exception("No se ha encontrado el artículo");
            }
            String price = FacturasProgram.bigDecimalToString(articulo.getPrecio(), "€");
            String iva = FacturasProgram.bigDecimalToString(articulo.getPorciva(), "%");

            priceField.setText(price);
            ivaField.setText(iva);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "No se ha encontrado el artículo.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            priceField.setText("");
            ivaField.setText("");
        }
    }//GEN-LAST:event_selectButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.JTextField artReferenceField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField cantField;
    private javax.swing.JTextField dtoField;
    private javax.swing.JTextField ivaField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField priceField;
    private javax.swing.JButton selectButton;
    private javax.swing.JLabel selectedFacCabLabel;
    // End of variables declaration//GEN-END:variables
}
