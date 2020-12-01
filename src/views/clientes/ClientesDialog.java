package views.clientes;

import controllers.CtrlClientes;
import controllers.FacturasProgram;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClientesDialog extends javax.swing.JDialog {

    CtrlClientes cClientes;
    AddClienteDialog addDialog;
    RemoveClienteDialog removeDialog;
    ModifyClienteDialog modifyDialog;
    QueryClienteDialog queryDialog;

    public ClientesDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        cClientes = FacturasProgram.cClientes;

        addDialog = new AddClienteDialog(this, true);
        removeDialog = new RemoveClienteDialog(this, true);
        modifyDialog = new ModifyClienteDialog(this, true);
        queryDialog = new QueryClienteDialog(this, true);
        initComponents();
        updateCliTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        clientesTable = new javax.swing.JTable();
        menuBar = new javax.swing.JMenuBar();
        addButton = new javax.swing.JMenu();
        removeButton = new javax.swing.JMenu();
        modifyButton = new javax.swing.JMenu();
        queryButton = new javax.swing.JMenu();
        refreshButton = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes");

        clientesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI/CIF", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
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

        addButton.setText("Añadir");
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addButtonMouseClicked(evt);
            }
        });
        menuBar.add(addButton);

        removeButton.setText("Eliminar");
        removeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeButtonMouseClicked(evt);
            }
        });
        menuBar.add(removeButton);

        modifyButton.setText("Modificar");
        modifyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifyButtonMouseClicked(evt);
            }
        });
        menuBar.add(modifyButton);

        queryButton.setText("Consulta");
        queryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                queryButtonMouseClicked(evt);
            }
        });
        menuBar.add(queryButton);

        refreshButton.setText("Refrescar");
        refreshButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshButtonMouseClicked(evt);
            }
        });
        menuBar.add(refreshButton);

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
    
    public CtrlClientes getCCLientes() {
        return cClientes;
    }
    
    public void resetAddDialog() {
        addDialog = new AddClienteDialog(this, true);
    }

    public void resetRemoveDialog() {
        removeDialog = new RemoveClienteDialog(this, true);
    }

    public void resetModifyDialog() {
        modifyDialog = new ModifyClienteDialog(this, true);
    }

    public void resetQueryDialog() {
        queryDialog = new QueryClienteDialog(this, true);
    }

    public void updateCliTable() {
        DefaultTableModel model = (DefaultTableModel) clientesTable.getModel();

        //Empty model
        model.setRowCount(0);

        //Fill model
        cClientes.getListaClientes().forEach(c -> {
            String dni = FacturasProgram.nullStringIfNull(c.getDnicif());
            String nombre = FacturasProgram.nullStringIfNull(c.getNombrecli());

            model.addRow(new String[]{
                dni,
                nombre
            });
        });
    }

    public void updateCliTableWithRegexFilter(String filter, int column) {
        DefaultTableModel model = (DefaultTableModel) clientesTable.getModel();

        //Empty model
        model.setRowCount(0);

        //Fill model
        cClientes.getListaClientes().forEach(c -> {
            String dni = FacturasProgram.nullStringIfNull(c.getDnicif());
            String nombre = FacturasProgram.nullStringIfNull(c.getNombrecli());

            switch (column) {
                case 0:
                    if (dni.matches(filter)) {
                        model.addRow(new String[]{
                            dni,
                            nombre
                        });
                    }
                    break;

                case 1:
                    if (nombre.matches(filter)) {
                        model.addRow(new String[]{
                            dni,
                            nombre
                        });
                    }
            }
        });
    }

    public void updateCliTableWithEqualsFilter(String filter, int column) {
        DefaultTableModel model = (DefaultTableModel) clientesTable.getModel();

        //Empty model
        model.setRowCount(0);

        cClientes.getListaClientes().forEach(c -> {
            String dni = FacturasProgram.nullStringIfNull(c.getDnicif());
            String nombre = FacturasProgram.nullStringIfNull(c.getNombrecli());

            switch (column) {
                case 0:
                    if (dni.equals(filter)) {
                        model.addRow(new String[]{
                            dni,
                            nombre
                        });
                    }
                    break;

                case 1:
                    if (nombre.equals(filter)) {
                        model.addRow(new String[]{
                            dni,
                            nombre
                        });
                    }
            }
        });

    }

    public JTable getClientesTable() {
        return clientesTable;
    }

    private void addButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseClicked
        addDialog.pack();
        addDialog.setVisible(true);
    }//GEN-LAST:event_addButtonMouseClicked

    private void removeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeButtonMouseClicked
        removeDialog.pack();
        removeDialog.setVisible(true);
    }//GEN-LAST:event_removeButtonMouseClicked

    private void clientesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientesTableMouseClicked
        int row = clientesTable.getSelectedRow();
        String dni = (String) clientesTable.getValueAt(row, 0);
        String name = (String) clientesTable.getValueAt(row, 1);

        addDialog.setDNITextField(dni);
        removeDialog.setDNITextField(dni);
        modifyDialog.setDNITextField(dni);

        addDialog.setNameTextField(name);
        modifyDialog.setNameTextField(name);
    }//GEN-LAST:event_clientesTableMouseClicked

    private void modifyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyButtonMouseClicked
        modifyDialog.pack();
        modifyDialog.setVisible(true);
    }//GEN-LAST:event_modifyButtonMouseClicked

    private void queryButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_queryButtonMouseClicked
        queryDialog.pack();
        queryDialog.setVisible(true);
    }//GEN-LAST:event_queryButtonMouseClicked

    private void refreshButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMouseClicked
        updateCliTable();
    }//GEN-LAST:event_refreshButtonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu addButton;
    private javax.swing.JTable clientesTable;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu modifyButton;
    private javax.swing.JMenu queryButton;
    private javax.swing.JMenu refreshButton;
    private javax.swing.JMenu removeButton;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
