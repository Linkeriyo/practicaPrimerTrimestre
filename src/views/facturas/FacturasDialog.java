package views.facturas;

import controllers.CtrlFacturasCab;
import controllers.CtrlFacturasLin;
import controllers.CtrlFacturasTot;
import controllers.FacturasProgram;
import java.awt.Frame;
import java.text.SimpleDateFormat;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.FacturasCab;
import models.FacturasTot;

public class FacturasDialog extends JDialog {

    static SimpleDateFormat sdf = FacturasProgram.sdf;
    CtrlFacturasCab cFacturasCab;
    CtrlFacturasLin cFacturasLin;
    CtrlFacturasTot cFacturasTot;
    SelectFacturaCabDialog selectDialog;
    AddFacturaCabDialog addDialog;
    InsertFacturaLinDialog insertLinDialog;
    RemoveFacturaCabDialog removeDialog;
    DeleteFacturaLinDialog deleteLinDialog;
    FacturasCab selectedFacturaCab;

    public FacturasDialog(Frame parent, boolean modal) {
        super(parent, modal);
        cFacturasCab = new CtrlFacturasCab();
        cFacturasLin = new CtrlFacturasLin();
        cFacturasTot = new CtrlFacturasTot();
        selectDialog = new SelectFacturaCabDialog(this, true);
        addDialog = new AddFacturaCabDialog(this, true);
        insertLinDialog = new InsertFacturaLinDialog(this, true);
        removeDialog = new RemoveFacturaCabDialog(this, true);
        deleteLinDialog = new DeleteFacturaLinDialog(this, true);
        initComponents();
        updateFacCabTable();
    }

    public void refreshSelectedFacCab() {
        selectedFacturaCab = cFacturasCab.calculateTotalThenGet(selectedFacturaCab.getNumfac());
    }

    public FacturasCab getSelectedFacturaCab() {
        return selectedFacturaCab;
    }

    public CtrlFacturasCab getCFacturasCab() {
        return cFacturasCab;
    }

    public CtrlFacturasLin getCFacturasLin() {
        return cFacturasLin;
    }

    public CtrlFacturasTot getCFacturasTot() {
        return cFacturasTot;
    }

    public void setSelectedFactura(FacturasCab factura) {
        selectedFacturaCab = cFacturasCab.calculateTotalThenGet(factura.getNumfac());
        selectedFacCabLabel.setText("Factura seleccionada: " + String.valueOf(factura.getNumfac()));
        updateFacLinTable();
    }

    public void resetSelectDialog() {
        selectDialog = new SelectFacturaCabDialog(this, true);
    }

    public void resetAddDialog() {
        addDialog = new AddFacturaCabDialog(this, true);
    }

    public void resetInsertDialog() {
        insertLinDialog = new InsertFacturaLinDialog(this, true);
    }
    
    public void resetRemoveDialog() {
        removeDialog = new RemoveFacturaCabDialog(this, true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        facLinTable = new javax.swing.JTable();
        selectedFacCabLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        facCabTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        baseImpLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        impIvaLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        totalFacLabel = new javax.swing.JLabel();
        impDtoLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        selectCabButton = new javax.swing.JMenuItem();
        addCabButton = new javax.swing.JMenuItem();
        removeCabButton = new javax.swing.JMenuItem();
        refreshCabButton = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        insertLineButton = new javax.swing.JMenuItem();
        deleteLineButton = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Facturas");

        facLinTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº Línea", "Artículo", "Cantidad", "Precio", "Descuento", "IVA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        facLinTable.setRowSelectionAllowed(false);
        scrollPane.setViewportView(facLinTable);

        selectedFacCabLabel.setText("Selecciona una factura para ver sus líneas");

        facCabTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº Factura", "Cliente", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        facCabTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        facCabTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                facCabTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(facCabTable);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setName(""); // NOI18N

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Base imponible:");

        baseImpLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Total de factura");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Importe del descuento:");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Importe del IVA:");

        impIvaLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Total:");

        totalFacLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        impDtoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(15, 15, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(impDtoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(totalFacLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(impIvaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(baseImpLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(baseImpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(impDtoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(impIvaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(totalFacLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenu2.setText("Cabeceras");

        selectCabButton.setText("Seleccionar");
        selectCabButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCabButtonActionPerformed(evt);
            }
        });
        jMenu2.add(selectCabButton);

        addCabButton.setText("Añadir");
        addCabButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCabButtonActionPerformed(evt);
            }
        });
        jMenu2.add(addCabButton);

        removeCabButton.setText("Eliminar");
        removeCabButton.setEnabled(false);
        removeCabButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCabButtonActionPerformed(evt);
            }
        });
        jMenu2.add(removeCabButton);

        refreshCabButton.setText("Refrescar");
        refreshCabButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshCabButtonActionPerformed(evt);
            }
        });
        jMenu2.add(refreshCabButton);

        menuBar.add(jMenu2);

        jMenu3.setText("Líneas");

        insertLineButton.setText("Insertar");
        insertLineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertLineButtonActionPerformed(evt);
            }
        });
        jMenu3.add(insertLineButton);

        deleteLineButton.setText("Eliminar");
        deleteLineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteLineButtonActionPerformed(evt);
            }
        });
        jMenu3.add(deleteLineButton);

        menuBar.add(jMenu3);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectedFacCabLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectedFacCabLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public JTable getFacLinTable() {
        return facLinTable;
    }

    public void updateFacCabTable() {
        DefaultTableModel model = (DefaultTableModel) facCabTable.getModel();

        //Empty model
        model.setRowCount(0);

        //Fill model
        cFacturasCab.getListaFacturasCab().forEach(cf -> {
            String numfac = String.valueOf(cf.getNumfac());
            String cliente = cf.getClientes().getDnicif();
            String fecha = sdf.format(cf.getFechafac());

            model.addRow(new String[]{
                numfac,
                cliente,
                fecha,});
        });
    }

    public void updateTotalPanel() {
        if (selectedFacturaCab != null && selectedFacturaCab.getFacturasTot() != null) {
            FacturasTot total = selectedFacturaCab.getFacturasTot();
            String baseImp = FacturasProgram.bigDecimalToString(total.getBaseimp(), "€");
            String impDto = FacturasProgram.bigDecimalToString(total.getImpDto(), "€");
            String impIva = FacturasProgram.bigDecimalToString(total.getImpIva(), "€");
            String impTotal = FacturasProgram.bigDecimalToString(total.getTotalfac(), "€");

            baseImpLabel.setText(baseImp);
            impDtoLabel.setText(impDto);
            impIvaLabel.setText(impIva);
            totalFacLabel.setText(impTotal);
        } else {
            baseImpLabel.setText("");
            impDtoLabel.setText("");
            impIvaLabel.setText("");
            totalFacLabel.setText("");
        }
    }

    public void updateFacLinTable() {
        DefaultTableModel model = (DefaultTableModel) facLinTable.getModel();

        //Empty model
        model.setRowCount(0);

        //Fill model
        if (selectedFacturaCab != null) {
            cFacturasLin.getListaFacturasLin().forEach(lf -> {
                if (lf.getFacturasCab().getNumfac() == selectedFacturaCab.getNumfac()) {
                    String id = String.valueOf(lf.getId().getLineafac());
                    String articulo = FacturasProgram.nullStringIfNull(lf.getArticulos().getReferencia());
                    String cantidad = FacturasProgram.bigDecimalToString(lf.getCantidad(), null);
                    String precio = FacturasProgram.bigDecimalToString(lf.getPrecio(), "€");
                    String descuento = FacturasProgram.bigDecimalToString(lf.getDtolinea(), "%");
                    String porciva = FacturasProgram.bigDecimalToString(lf.getIvalinea(), "%");

                    model.addRow(new String[]{
                        id,
                        articulo,
                        cantidad,
                        precio,
                        descuento,
                        porciva
                    });
                }
            });
        }
    }

    public void fullTableRefresh() {
        cFacturasCab.updateList();
        cFacturasLin.updateList();
        cFacturasTot.updateList();
        updateFacCabTable();
        updateFacLinTable();
        updateTotalPanel();
    }
    
    private void selectCabButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCabButtonActionPerformed
        selectDialog.setVisible(true);
    }//GEN-LAST:event_selectCabButtonActionPerformed

    private void addCabButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCabButtonActionPerformed
        addDialog.setVisible(true);
    }//GEN-LAST:event_addCabButtonActionPerformed

    private void removeCabButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCabButtonActionPerformed
        removeDialog.setVisible(true);
    }//GEN-LAST:event_removeCabButtonActionPerformed

    private void refreshCabButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshCabButtonActionPerformed
        selectedFacturaCab = null;
        removeCabButton.setEnabled(false);
        selectedFacCabLabel.setText("Selecciona una factura para ver sus líneas");
        fullTableRefresh();
        updateTotalPanel();
    }//GEN-LAST:event_refreshCabButtonActionPerformed

    private void insertLineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertLineButtonActionPerformed
        if (selectedFacturaCab != null) {
            insertLinDialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Debes seleccionar una cabecera para insertar una línea.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_insertLineButtonActionPerformed

    private void facCabTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_facCabTableMouseReleased
        try {
            int rowNumber = facCabTable.getSelectedRow();
            long numfac = Long.parseLong((String) facCabTable.getValueAt(rowNumber, 0));
            selectedFacturaCab = cFacturasCab.calculateTotalThenGet(numfac);
            selectedFacCabLabel.setText("Factura seleccionada: " + numfac);
            insertLinDialog.setSelectedFacCabLabel("Factura seleccionada: " + numfac);
            deleteLinDialog.setSelectedFacCabLabel("Factura seleccionada: " + numfac);
            updateFacLinTable();
            updateTotalPanel();
            removeCabButton.setEnabled(true);
        } catch (ArrayIndexOutOfBoundsException ex) {
        }
    }//GEN-LAST:event_facCabTableMouseReleased

    private void deleteLineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteLineButtonActionPerformed
        if (selectedFacturaCab != null) {
            deleteLinDialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Debes seleccionar una cabecera para insertar una línea.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_deleteLineButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addCabButton;
    private javax.swing.JLabel baseImpLabel;
    private javax.swing.JMenuItem deleteLineButton;
    private javax.swing.JTable facCabTable;
    private javax.swing.JTable facLinTable;
    private javax.swing.JLabel impDtoLabel;
    private javax.swing.JLabel impIvaLabel;
    private javax.swing.JMenuItem insertLineButton;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem refreshCabButton;
    private javax.swing.JMenuItem removeCabButton;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JMenuItem selectCabButton;
    private javax.swing.JLabel selectedFacCabLabel;
    private javax.swing.JLabel totalFacLabel;
    // End of variables declaration//GEN-END:variables
}
