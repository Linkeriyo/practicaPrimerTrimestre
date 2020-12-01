package views;

import views.articulos.ArticulosDialog;
import views.clientes.ClientesDialog;
import views.export.ExportDialog;
import views.facturas.FacturasDialog;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        facturasButton = new javax.swing.JButton();
        clientesButton = new javax.swing.JButton();
        articulosButton = new javax.swing.JButton();
        statsButton = new javax.swing.JButton();
        exportButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        facturasButton.setText("Gestionar facturas");
        facturasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturasButtonActionPerformed(evt);
            }
        });

        clientesButton.setText("Gestionar clientes");
        clientesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesButtonActionPerformed(evt);
            }
        });

        articulosButton.setText("Gestionar articulos");
        articulosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                articulosButtonActionPerformed(evt);
            }
        });

        statsButton.setText("Consulta de estadísitcas");
        statsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statsButtonActionPerformed(evt);
            }
        });

        exportButton.setText("Exportar");
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(articulosButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clientesButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(facturasButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exportButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(statsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(articulosButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clientesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(facturasButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exportButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void statsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statsButtonActionPerformed
        
    }//GEN-LAST:event_statsButtonActionPerformed

    private void articulosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_articulosButtonActionPerformed
        ArticulosDialog dialog = new ArticulosDialog(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_articulosButtonActionPerformed

    private void clientesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesButtonActionPerformed
        ClientesDialog dialog = new ClientesDialog(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_clientesButtonActionPerformed

    private void facturasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturasButtonActionPerformed
        FacturasDialog dialog = new FacturasDialog(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_facturasButtonActionPerformed

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
        ExportDialog dialog = new ExportDialog(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_exportButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton articulosButton;
    private javax.swing.JButton clientesButton;
    private javax.swing.JButton exportButton;
    private javax.swing.JButton facturasButton;
    private javax.swing.JButton statsButton;
    // End of variables declaration//GEN-END:variables
}
