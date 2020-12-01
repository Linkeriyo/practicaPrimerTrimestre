package views.facturas;

import controllers.CtrlFacturasCab;
import controllers.FacturasProgram;
import exceptions.RequiredFieldException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import javax.swing.JOptionPane;
import models.Clientes;
import models.FacturasCab;
import org.hibernate.exception.ConstraintViolationException;

public class AddFacturaCabDialog extends javax.swing.JDialog {

    CtrlFacturasCab cFacturasCab;
    FacturasDialog parent;

    public AddFacturaCabDialog(FacturasDialog parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        cFacturasCab = parent.getCFacturasCab();
        initComponents();
    }

    public void setNameTextField(String descriptionField) {
        this.idClienteField.setText(descriptionField);
    }

    public void setDNITextField(String referenceField) {
        this.numFacField.setText(referenceField);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        acceptButton = new javax.swing.JButton();
        numFacField = new javax.swing.JTextField();
        idClienteField = new javax.swing.JTextField();
        dateField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Añadir cliente");
        setModal(true);
        setResizable(false);

        jLabel1.setText("Nº Factura");

        jLabel2.setText("ID Cliente");

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

        jLabel3.setText("Fecha");

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
                            .addComponent(jLabel3))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateField)
                            .addComponent(numFacField)
                            .addComponent(idClienteField))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numFacField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idClienteField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            if (numFacField.getText().isEmpty()
                    || idClienteField.getText().isEmpty()
                    || dateField.getText().isEmpty()) {
                throw new RequiredFieldException("Introduce el filtro.");
            }
            long numfac = Long.parseLong(numFacField.getText());
            Clientes cliente = FacturasProgram.cClientes.getClienteById(idClienteField.getText());
            Date date = FacturasProgram.sdf.parse(dateField.getText());
            cFacturasCab.insertFacturaCab(new FacturasCab(
                    numfac,
                    cliente,
                    date,
                    null,
                    new HashSet(0)
            ));
            cFacturasCab.calculateTotalThenGet(numfac);
            cFacturasCab.updateList();
            parent.updateFacCabTable();
            setVisible(false);
            parent.resetSelectDialog();
        } catch (ConstraintViolationException cve) {
            JOptionPane.showMessageDialog(null,
                    "Ya existe un cliente con ese DNI/NIF",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null,
                    "La fecha no es válida",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (RequiredFieldException ex) {
            JOptionPane.showMessageDialog(null,
                    "Todos los campos son obligatorios",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null,
                    "El formato de un número no es correcto.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
        parent.resetAddDialog();
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField dateField;
    private javax.swing.JTextField idClienteField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField numFacField;
    // End of variables declaration//GEN-END:variables
}
