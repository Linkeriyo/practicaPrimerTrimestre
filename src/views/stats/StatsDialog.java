package views.stats;

import controllers.CtrlClientes;
import controllers.CtrlStats;
import controllers.FacturasProgram;
import javax.swing.JTable;

public class StatsDialog extends javax.swing.JDialog {

    CtrlClientes cClientes;
    CtrlStats cStats;
    
    public StatsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        cClientes = FacturasProgram.cClientes;
        cStats = FacturasProgram.cStats;
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        clientesTable = new javax.swing.JTable();
        menuBar = new javax.swing.JMenuBar();
        generateButton = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes");

        clientesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI/CIF", "Nombre", "Suma Base", "Suma Descuentos", "Suma IVA", "Suma Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        clientesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        clientesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientesTableMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(clientesTable);

        generateButton.setText("Generar");
        generateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                generateButtonMouseReleased(evt);
            }
        });
        menuBar.add(generateButton);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public JTable getClientesTable() {
        return clientesTable;
    }
    
    public void updateStatsTable() {
    }
    
    private void clientesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientesTableMouseClicked

    }//GEN-LAST:event_clientesTableMouseClicked

    private void generateButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generateButtonMouseReleased
        
    }//GEN-LAST:event_generateButtonMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable clientesTable;
    private javax.swing.JMenu generateButton;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
