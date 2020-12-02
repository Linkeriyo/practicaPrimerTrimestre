package views.facturas;

import controllers.CtrlArticulos;
import controllers.CtrlFacturasLin;
import controllers.FacturasProgram;
import exceptions.RequiredFieldException;
import javax.swing.JOptionPane;
import models.Articulos;
import models.FacturasCab;
import models.FacturasLin;
import models.FacturasLinId;

public class DeleteFacturaLinDialog extends javax.swing.JDialog {

    CtrlArticulos cArticulos;
    CtrlFacturasLin cFacturasLin;
    FacturasDialog parent;

    public DeleteFacturaLinDialog(FacturasDialog parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        cFacturasLin = FacturasProgram.cFacturasLin;
        cArticulos = FacturasProgram.cArticulos;
        initComponents();
        if (parent.getSelectedFacturaCab() != null) {
            selectedFacCabLabel.setText("Columna seleccionada: " + parent.getSelectedFacturaCab().getNumfac());
        }

    }

    public void setNumfacTextField(String referenceField) {
        this.idLineaField.setText(referenceField);
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
        idLineaField = new javax.swing.JTextField();
        selectedFacCabLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Eliminar línea de factura");
        setModal(true);
        setResizable(false);

        jLabel1.setText("Nº Línea");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 165, Short.MAX_VALUE)
                        .addComponent(acceptButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(selectedFacCabLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idLineaField)))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectedFacCabLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLineaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
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
            if (idLineaField.getText().isEmpty()) {
                throw new RequiredFieldException("El campo es obligatorio.");
            }
            
            //Encontrar la línea especificada
            FacturasCab facturaCab = parent.getSelectedFacturaCab();
            long idLinea = Long.parseLong(idLineaField.getText());
            FacturasLinId id = new FacturasLinId(facturaCab.getNumfac(), idLinea);
            FacturasLin linea = cFacturasLin.getFacturaLinById(id);
            
            //Eliminar la línea.
            cFacturasLin.removeFacturaLin(linea);
            
            //Sumar la cantidad liberada al stock del artículo.
            Articulos articulo = cArticulos.getArticuloById(linea.getArticulos().getReferencia());
            articulo.setStock(articulo.getStock().add(linea.getCantidad()));
            cArticulos.updateArticulo(articulo);
            
            //Actualizar todo lo modificado.
            cArticulos.updateList();
            cFacturasLin.updateList();
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
        }
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
        parent.resetSelectDialog();
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField idLineaField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel selectedFacCabLabel;
    // End of variables declaration//GEN-END:variables
}
