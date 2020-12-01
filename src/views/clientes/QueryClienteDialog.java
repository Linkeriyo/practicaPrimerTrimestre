package views.clientes;

import exceptions.RequiredFieldException;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class QueryClienteDialog extends javax.swing.JDialog {
    ClientesDialog parent;

    private static final String[] STRING_COMPARATORS = new String[]{
        "Selecciona un comparador",
        "Expresión regular",
        "Comprobar igual"
    };

    public QueryClienteDialog(ClientesDialog parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        columnComboBox = new javax.swing.JComboBox<>();
        comparatorComboBox = new javax.swing.JComboBox<>();
        acceptButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        filterField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar artículos");
        setModal(true);
        setResizable(false);

        columnComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona la columna", "DNI/NIF", "Nombre" }));
        columnComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                columnComboBoxItemStateChanged(evt);
            }
        });

        comparatorComboBox.setEnabled(false);

        acceptButton.setText("Aceptar");
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Columna");

        jLabel2.setText("Comparador");

        jLabel3.setText("Filtro");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(acceptButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addComponent(filterField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comparatorComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(columnComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 252, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(columnComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comparatorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void columnComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_columnComboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            switch ((String) evt.getItem()) {
                case "DNI/NIF":
                    comparatorComboBox.setModel(new DefaultComboBoxModel<>(STRING_COMPARATORS));
                    comparatorComboBox.setEnabled(true);
                    break;
                case "Nombre":
                    comparatorComboBox.setModel(new DefaultComboBoxModel<>(STRING_COMPARATORS));
                    comparatorComboBox.setEnabled(true);
                    break;
                default:
                    comparatorComboBox.setModel(new DefaultComboBoxModel<>());
                    comparatorComboBox.setEnabled(false);
            }
        }
    }//GEN-LAST:event_columnComboBoxItemStateChanged

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        try {
            if (filterField.getText().isEmpty()) {
                throw new RequiredFieldException("Introduce el filtro.");
            }
            int column = columnComboBox.getSelectedIndex() - 1;
            if (column < 0) {
                throw new RequiredFieldException("Elige una de las columnas.");
            }
            String filter = filterField.getText();

            switch ((String) comparatorComboBox.getSelectedItem()) {
                case "Comprobar igual":
                    parent.updateCliTableWithEqualsFilter(filter, column);
                    break;
                case "Expresión regular":
                    parent.updateCliTableWithRegexFilter(filter, column);
                    break;
                default:
                    throw new RequiredFieldException("Elige uno de los comparadores.");
            }
            setVisible(false);
            parent.resetQueryDialog();
        } catch (RequiredFieldException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Información.",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
        parent.resetQueryDialog();
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> columnComboBox;
    private javax.swing.JComboBox<String> comparatorComboBox;
    private javax.swing.JTextField filterField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
