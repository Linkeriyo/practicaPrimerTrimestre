package views.clientes;

import controllers.CtrlClientes;
import java.util.Set;
import javax.swing.JTable;
import models.Clientes;

public class ModifyClienteDialog extends javax.swing.JDialog {

    ClientesDialog parent;
    CtrlClientes cClientes;

    public ModifyClienteDialog(ClientesDialog parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        cClientes = parent.getCCLientes();
        initComponents();
    }

    public void setNameTextField(String descriptionField) {
        this.nameField.setText(descriptionField);
    }

    public void setDNITextField(String referenceField) {
        this.dniField.setText(referenceField);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        acceptButton = new javax.swing.JButton();
        selectButton = new javax.swing.JButton();
        dniField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar artículo");
        setModal(true);
        setResizable(false);

        jLabel1.setText("DNI/NIF");

        jLabel2.setText("Nombre");

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

        selectButton.setText("Seleccionar");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dniField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectButton))
                            .addComponent(nameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(acceptButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectButton)
                    .addComponent(dniField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(acceptButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
        parent.resetModifyDialog();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        String dni = dniField.getText();
        JTable clientesTable = parent.getClientesTable();
        String[] row = new String[0];

        // Search in the list for the row with this DNI
        for (int i = 0; i < clientesTable.getRowCount(); i++) {
            if (clientesTable.getValueAt(i, 0).equals(dni)) {
                row = new String[]{
                    (String) clientesTable.getValueAt(i, 1)
                };
                break;
            }
        }

        nameField.setText(row[0]);
    }//GEN-LAST:event_selectButtonActionPerformed

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        String dni = dniField.getText();
        String name = nameField.getText();
        Clientes cliente = cClientes.getClienteById(dni);
        Set stats = cliente.getEstadisticasClienteses();
        Set facturas = cliente.getFacturasCabs();

        cClientes.updateCliente(new Clientes(
                dni,
                name,
                stats,
                facturas
        ));

        cClientes.updateList();
        parent.updateCliTable();
        setVisible(false);
        parent.resetRemoveDialog();
    }//GEN-LAST:event_acceptButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField dniField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton selectButton;
    // End of variables declaration//GEN-END:variables
}
