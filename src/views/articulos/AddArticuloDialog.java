package views.articulos;

import controllers.CtrlArticulos;
import java.math.BigDecimal;
import java.util.HashSet;
import javax.swing.JOptionPane;
import models.Articulos;
import org.hibernate.exception.ConstraintViolationException;

public class AddArticuloDialog extends javax.swing.JDialog {

    CtrlArticulos cArticulos;
    ArticulosDialog parent;

    public AddArticuloDialog(ArticulosDialog parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        cArticulos = parent.getCArticulos();
        initComponents();
    }

    public void setDescriptionFieldText(String descriptionField) {
        this.descriptionField.setText(descriptionField);
    }

    public void setIvaFieldText(String ivaField) {
        this.ivaField.setText(ivaField);
    }

    public void setPriceFieldText(String priceField) {
        this.priceField.setText(priceField);
    }

    public void setReferenceFieldText(String referenceField) {
        this.referenceField.setText(referenceField);
    }

    public void setStockFieldText(String stockField) {
        this.stockField.setText(stockField);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        acceptButton = new javax.swing.JButton();
        referenceField = new javax.swing.JTextField();
        descriptionField = new javax.swing.JTextField();
        priceField = new javax.swing.JTextField();
        ivaField = new javax.swing.JTextField();
        stockField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Añadir artículo");
        setModal(true);
        setResizable(false);

        jLabel1.setText("Referencia");

        jLabel2.setText("Descripción");

        jLabel3.setText("Precio");

        jLabel4.setText("IVA%");

        jLabel5.setText("Stock");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 171, Short.MAX_VALUE)
                        .addComponent(acceptButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stockField)
                            .addComponent(priceField)
                            .addComponent(referenceField)
                            .addComponent(descriptionField)
                            .addComponent(ivaField, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(referenceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(descriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ivaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(stockField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            String priceStr = priceField.getText();
            if (priceStr.endsWith("€")) priceStr = priceStr.substring(0, priceStr.length() - 1);
            String ivaStr = ivaField.getText();
            if (ivaStr.endsWith("%")) ivaStr = ivaStr.substring(0, ivaStr.length() - 1);
            
            String reference = referenceField.getText();
            String description = descriptionField.getText();
            BigDecimal price = BigDecimal.valueOf(Double.parseDouble(priceStr));
            BigDecimal iva = BigDecimal.valueOf(Double.parseDouble(ivaStr));
            BigDecimal stock = BigDecimal.valueOf(Double.parseDouble(stockField.getText()));

            cArticulos.insertArticulo(new Articulos(
                    reference,
                    description,
                    price,
                    iva,
                    stock,
                    new HashSet(0)
            ));
            cArticulos.updateList();
            parent.updateArtTable();
            setVisible(false);
            parent.resetRemoveDialog();
        } catch (ConstraintViolationException cve) {
            JOptionPane.showMessageDialog(null,
                    "Ya existe un artículo con esa referencia o descripción.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
        parent.resetRemoveDialog();
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField descriptionField;
    private javax.swing.JTextField ivaField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField priceField;
    private javax.swing.JTextField referenceField;
    private javax.swing.JTextField stockField;
    // End of variables declaration//GEN-END:variables
}
