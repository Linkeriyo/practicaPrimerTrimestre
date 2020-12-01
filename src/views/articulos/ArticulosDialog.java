package views.articulos;

import controllers.CtrlArticulos;
import controllers.FacturasProgram;
import java.math.BigDecimal;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ArticulosDialog extends javax.swing.JDialog {

    CtrlArticulos cArticulos;
    AddArticuloDialog addDialog;
    RemoveArticuloDialog removeDialog;
    ModifyArticuloDialog modifyDialog;
    QueryArticuloDialog queryDialog;

    public ArticulosDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        cArticulos = new CtrlArticulos();

        addDialog = new AddArticuloDialog(this, true);
        removeDialog = new RemoveArticuloDialog(this, true);
        modifyDialog = new ModifyArticuloDialog(this, true);
        queryDialog = new QueryArticuloDialog(this, true);
        initComponents();
        updateArtTable();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        articulosTable = new javax.swing.JTable();
        menuBar = new javax.swing.JMenuBar();
        addButton = new javax.swing.JMenu();
        removeButton = new javax.swing.JMenu();
        modifyButton = new javax.swing.JMenu();
        queryButton = new javax.swing.JMenu();
        refreshButton = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Artículos");

        articulosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Referencia", "Descripcion", "Precio", "IVA%", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        articulosTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        articulosTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                articulosTableMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(articulosTable);

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
    
    public CtrlArticulos getCArticulos() {
        return cArticulos;
    }
    
    public void resetAddDialog() {
        addDialog = new AddArticuloDialog(this, true);
    }

    public void resetRemoveDialog() {
        removeDialog = new RemoveArticuloDialog(this, true);
    }

    public void resetModifyDialog() {
        modifyDialog = new ModifyArticuloDialog(this, true);
    }

    public void resetQueryDialog() {
        queryDialog = new QueryArticuloDialog(this, true);
    }

    public void updateArtTable() {
        DefaultTableModel model = (DefaultTableModel) articulosTable.getModel();

        //Empty model
        model.setRowCount(0);

        //Fill model
        cArticulos.getListaArticulos().forEach(a -> {
            String referencia = FacturasProgram.nullStringIfNull(a.getReferencia());
            String descripcion = FacturasProgram.nullStringIfNull(a.getDescripcion());
            String precio = FacturasProgram.bigDecimalToString(a.getPrecio(), "€");
            String porciva = FacturasProgram.bigDecimalToString(a.getPorciva(), "%");
            String stock = FacturasProgram.bigDecimalToString(a.getStock(), null);

            model.addRow(new String[]{
                referencia,
                descripcion,
                precio,
                porciva,
                stock
            });
        });
    }

    public void updateArtTableWithRegexFilter(String filter, int column) {
        DefaultTableModel model = (DefaultTableModel) articulosTable.getModel();

        //Empty model
        model.setRowCount(0);
        
        //Fill model
        cArticulos.getListaArticulos().forEach(a -> {
            String referencia = FacturasProgram.nullStringIfNull(a.getReferencia());
            String descripcion = FacturasProgram.nullStringIfNull(a.getDescripcion());
            String precio = FacturasProgram.bigDecimalToString(a.getPrecio(), "€");
            String porciva = FacturasProgram.bigDecimalToString(a.getPorciva(), "%");
            String stock = FacturasProgram.bigDecimalToString(a.getStock(), null);

            switch (column) {
                case 0:
                    if (referencia.matches(filter)) {
                        model.addRow(new String[]{
                            referencia,
                            descripcion,
                            precio,
                            porciva,
                            stock
                        });
                    }
                    break;

                case 1:
                    if (descripcion.matches(filter)) {
                        model.addRow(new String[]{
                            referencia,
                            descripcion,
                            precio,
                            porciva,
                            stock
                        });
                    }
            }
        });
    }

    public void updateArtTableWithEqualsFilter(String filter, int column) {
        DefaultTableModel model = (DefaultTableModel) articulosTable.getModel();

        //Empty model
        model.setRowCount(0);
        cArticulos.getListaArticulos().forEach(a -> {
            String referencia = FacturasProgram.nullStringIfNull(a.getReferencia());
            String descripcion = FacturasProgram.nullStringIfNull(a.getDescripcion());
            String precio = FacturasProgram.bigDecimalToString(a.getPrecio(), "€");
            String porciva = FacturasProgram.bigDecimalToString(a.getPorciva(), "%");
            String stock = FacturasProgram.bigDecimalToString(a.getStock(), null);

            switch (column) {
                case 0:
                    if (referencia.equals(filter)) {
                        model.addRow(new String[]{
                            referencia,
                            descripcion,
                            precio,
                            porciva,
                            stock
                        });
                    }
                    break;

                case 1:
                    if (descripcion.equals(filter)) {
                        model.addRow(new String[]{
                            referencia,
                            descripcion,
                            precio,
                            porciva,
                            stock
                        });
                    }
                    break;
                case 2:
                    if (a.getPrecio().compareTo(new BigDecimal(Double.parseDouble(filter))) == 0) {
                        model.addRow(new String[]{
                            referencia,
                            descripcion,
                            precio,
                            porciva,
                            stock
                        });
                    }
                    break;
                case 3:
                    if (a.getPorciva().compareTo(new BigDecimal(Double.parseDouble(filter))) == 0) {
                        model.addRow(new String[]{
                            referencia,
                            descripcion,
                            precio,
                            porciva,
                            stock
                        });
                    }
                    break;
                case 4:
                    if (a.getStock().compareTo(new BigDecimal(Double.parseDouble(filter))) == 0) {
                        model.addRow(new String[]{
                            referencia,
                            descripcion,
                            precio,
                            porciva,
                            stock
                        });
                    }
            }
        });

    }

    public void updateArtTableWithGreaterThanFilter(String filter, int column) {
        DefaultTableModel model = (DefaultTableModel) articulosTable.getModel();

        //Empty model
        model.setRowCount(0);

        cArticulos.getListaArticulos().forEach(a -> {
            String referencia = FacturasProgram.nullStringIfNull(a.getReferencia());
            String descripcion = FacturasProgram.nullStringIfNull(a.getDescripcion());
            String precio = FacturasProgram.bigDecimalToString(a.getPrecio(), "€");
            String porciva = FacturasProgram.bigDecimalToString(a.getPorciva(), "%");
            String stock = FacturasProgram.bigDecimalToString(a.getStock(), null);

            switch (column) {
                case 2:
                    if (a.getPrecio().compareTo(new BigDecimal(Double.parseDouble(filter))) == 1) {
                        model.addRow(new String[]{
                            referencia,
                            descripcion,
                            precio,
                            porciva,
                            stock
                        });
                    }
                    break;
                case 3:
                    if (a.getPorciva().compareTo(new BigDecimal(Double.parseDouble(filter))) == 1) {
                        model.addRow(new String[]{
                            referencia,
                            descripcion,
                            precio,
                            porciva,
                            stock
                        });
                    }
                    break;
                case 4:
                    if (a.getStock().compareTo(new BigDecimal(Double.parseDouble(filter))) == 1) {
                        model.addRow(new String[]{
                            referencia,
                            descripcion,
                            precio,
                            porciva,
                            stock
                        });
                    }
            }
        });
    }

    public void updateArtTableWithLessThanFilter(String filter, int column) {
        DefaultTableModel model = (DefaultTableModel) articulosTable.getModel();

        //Empty model
        model.setRowCount(0);

        cArticulos.getListaArticulos().forEach(a -> {
            String referencia = FacturasProgram.nullStringIfNull(a.getReferencia());
            String descripcion = FacturasProgram.nullStringIfNull(a.getDescripcion());
            String precio = FacturasProgram.bigDecimalToString(a.getPrecio(), "€");
            String porciva = FacturasProgram.bigDecimalToString(a.getPorciva(), "%");
            String stock = FacturasProgram.bigDecimalToString(a.getStock(), null);

            switch (column) {
                case 2:
                    if (a.getPrecio().compareTo(new BigDecimal(Double.parseDouble(filter))) == -1) {
                        model.addRow(new String[]{
                            a.getReferencia(),
                            a.getDescripcion(),
                            precio,
                            a.getPorciva().toString() + "%",
                            a.getStock().toString()
                        });
                    }
                    break;
                case 3:
                    if (a.getPorciva().compareTo(new BigDecimal(Double.parseDouble(filter))) == -1) {
                        model.addRow(new String[]{
                            a.getReferencia(),
                            a.getDescripcion(),
                            precio,
                            a.getPorciva().toString() + "%",
                            a.getStock().toString()
                        });
                    }
                    break;
                case 4:
                    if (a.getStock().compareTo(new BigDecimal(Double.parseDouble(filter))) == -1) {
                        model.addRow(new String[]{
                            a.getReferencia(),
                            a.getDescripcion(),
                            precio,
                            a.getPorciva().toString() + "%",
                            a.getStock().toString()
                        });
                    }
            }
        });
    }

    public JTable getArticulosTable() {
        return articulosTable;
    }

    private void addButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseClicked
        addDialog.pack();
        addDialog.setVisible(true);
    }//GEN-LAST:event_addButtonMouseClicked

    private void removeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeButtonMouseClicked
        removeDialog.pack();
        removeDialog.setVisible(true);
    }//GEN-LAST:event_removeButtonMouseClicked

    private void articulosTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_articulosTableMouseClicked
        int rowNumber = articulosTable.getSelectedRow();
        String reference = (String) articulosTable.getValueAt(rowNumber, 0);
        String description = (String) articulosTable.getValueAt(rowNumber, 1);
        String precio = (String) articulosTable.getValueAt(rowNumber, 2);
        String porciva = (String) articulosTable.getValueAt(rowNumber, 3);
        String stock = (String) articulosTable.getValueAt(rowNumber, 4);

        addDialog.setReferenceFieldText(reference);
        removeDialog.setReferenceFieldText(reference);
        modifyDialog.setReferenceFieldText(reference);

        addDialog.setDescriptionFieldText(description);
        modifyDialog.setDescriptionFieldText(description);

        addDialog.setPriceFieldText(precio);
        modifyDialog.setPriceFieldText(precio);

        addDialog.setIvaFieldText(porciva);
        modifyDialog.setIvaFieldText(porciva);

        addDialog.setStockFieldText(stock);
        modifyDialog.setStockFieldText(stock);
    }//GEN-LAST:event_articulosTableMouseClicked

    private void modifyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyButtonMouseClicked
        modifyDialog.pack();
        modifyDialog.setVisible(true);
    }//GEN-LAST:event_modifyButtonMouseClicked

    private void queryButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_queryButtonMouseClicked
        queryDialog.pack();
        queryDialog.setVisible(true);
    }//GEN-LAST:event_queryButtonMouseClicked

    private void refreshButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMouseClicked
        updateArtTable();
    }//GEN-LAST:event_refreshButtonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu addButton;
    private javax.swing.JTable articulosTable;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu modifyButton;
    private javax.swing.JMenu queryButton;
    private javax.swing.JMenu refreshButton;
    private javax.swing.JMenu removeButton;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
