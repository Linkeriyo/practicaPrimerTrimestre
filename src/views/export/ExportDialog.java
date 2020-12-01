package views.export;

import controllers.CtrlFacturasCab;
import controllers.CtrlFacturasLin;
import controllers.CtrlFacturasTot;
import controllers.FacturasProgram;
import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import exportmodels.JSONFactura;
import exportmodels.XMLFactura;
import java.nio.file.FileAlreadyExistsException;
import javax.swing.JOptionPane;
import models.FacturasCab;

public class ExportDialog extends JDialog {

    static SimpleDateFormat sdf = FacturasProgram.sdf;
    CtrlFacturasCab cFacturasCab;
    CtrlFacturasLin cFacturasLin;
    CtrlFacturasTot cFacturasTot;
    FacturasCab selectedFacturaCab;

    public ExportDialog(Frame parent, boolean modal) {
        super(parent, modal);
        cFacturasCab = new CtrlFacturasCab();
        cFacturasLin = new CtrlFacturasLin();
        cFacturasTot = new CtrlFacturasTot();
        initComponents();
        updateFacCabTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        facCabTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        selectedFacCabLabel = new javax.swing.JLabel();
        pathField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        exploreButton = new javax.swing.JButton();
        formatComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        exportButton = new javax.swing.JButton();
        saveStateLabel = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Facturas");

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

        selectedFacCabLabel.setText("Selecciona una factura para exportar");
        selectedFacCabLabel.setEnabled(false);

        pathField.setEnabled(false);
        pathField.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                pathFieldCaretUpdate(evt);
            }
        });

        jLabel2.setText("Ruta");
        jLabel2.setEnabled(false);

        exploreButton.setText("Explorar");
        exploreButton.setEnabled(false);
        exploreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exploreButtonActionPerformed(evt);
            }
        });

        formatComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona un formato", "JSON", "XML" }));
        formatComboBox.setEnabled(false);
        formatComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                formatComboBoxItemStateChanged(evt);
            }
        });

        jLabel3.setText("Formato");
        jLabel3.setEnabled(false);

        exportButton.setText("Exportar");
        exportButton.setEnabled(false);
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(selectedFacCabLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pathField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exploreButton))
                            .addComponent(formatComboBox, 0, 268, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(saveStateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exportButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectedFacCabLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formatComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(exploreButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exportButton)
                    .addComponent(saveStateLabel))
                .addContainerGap())
        );

        refreshButton.setText("Refrescar");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(refreshButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshButton)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void exportPanelSetEnabled(boolean enabled) {
        formatComboBox.setEnabled(enabled);
        selectedFacCabLabel.setEnabled(enabled);
        jLabel3.setEnabled(enabled);
    }

    private void pathControlSetEnabled(boolean enabled) {
        jLabel2.setEnabled(enabled);
        pathField.setEnabled(enabled);
        exploreButton.setEnabled(enabled);
    }

    private void facCabTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_facCabTableMouseReleased
        try {
            int rowNumber = facCabTable.getSelectedRow();
            long numfac = Long.parseLong((String) facCabTable.getValueAt(rowNumber, 0));
            selectedFacturaCab = cFacturasCab.calculateTotalThenGet(numfac);
            selectedFacCabLabel.setText("Factura seleccionada: " + numfac);
            exportPanelSetEnabled(true);
        } catch (ArrayIndexOutOfBoundsException ex) {
        }
    }//GEN-LAST:event_facCabTableMouseReleased

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        selectedFacturaCab = null;
        selectedFacCabLabel.setText("Selecciona una factura para exportar");
        formatComboBox.setSelectedIndex(0);
        updateFacCabTable();
        exportPanelSetEnabled(false);
        exportButton.setEnabled(false);
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void exploreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exploreButtonActionPerformed

        String extension;
        switch (formatComboBox.getSelectedIndex()) {
            case 1:
                extension = ".json";
                break;
            case 2:
                extension = ".xml";
                break;
            default:
                extension = "";
        }

        JFileChooser chooser;
        if (pathField.getText().isEmpty()) {
            chooser = new JFileChooser();
        } else {
            chooser = new JFileChooser(pathField.getText());
        }

        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                switch (formatComboBox.getSelectedIndex()) {
                    case 1:
                        return f.getName().endsWith(".json") || f.isDirectory();
                    case 2:
                        return f.getName().endsWith(".xml") || f.isDirectory();
                    default:
                        return false;
                }
            }

            @Override
            public String getDescription() {
                switch (formatComboBox.getSelectedIndex()) {
                    case 1:
                        return "Fichero JSON";
                    case 2:
                        return "Fichero XML";
                    default:
                        return "Not supported format";
                }
            }
        });

        chooser.showSaveDialog(this);

        if (chooser.getSelectedFile() != null) {
            String selectedPath = chooser.getSelectedFile().getAbsolutePath();
            if (!selectedPath.contains(".")) {
                selectedPath = selectedPath + extension;
            }
            pathField.setText(selectedPath);
        }
    }//GEN-LAST:event_exploreButtonActionPerformed

    private void formatComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_formatComboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (formatComboBox.getSelectedIndex() == 1
                    || formatComboBox.getSelectedIndex() == 2) {
                pathControlSetEnabled(true);
            } else {
                pathControlSetEnabled(false);
            }
        }
    }//GEN-LAST:event_formatComboBoxItemStateChanged

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed

        try {
            String path = pathField.getText();
            File f = new File(path);
            if (f.exists()) {
                boolean confirmed = JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
                        "El archivo " + f.getName() + " ya existe, ¿quieres reemplazarlo?",
                        "Confirmación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );

                if (!confirmed) {
                    throw new FileAlreadyExistsException(path);
                }
            }
            
            switch (formatComboBox.getSelectedIndex()) {
                case 1:
                    JSONFactura json = new JSONFactura(selectedFacturaCab);
                    json.write(new File(path));
                    break;
                case 2:
                    XMLFactura xml = new XMLFactura(selectedFacturaCab);
                    xml.write(new File(path));
            }
        } catch (FileAlreadyExistsException ex) {
        }


    }//GEN-LAST:event_exportButtonActionPerformed

    private void pathFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_pathFieldCaretUpdate
        if (pathField.getText().isEmpty()) {
            exportButton.setEnabled(false);
        } else {
            exportButton.setEnabled(true);
        }
    }//GEN-LAST:event_pathFieldCaretUpdate

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exploreButton;
    private javax.swing.JButton exportButton;
    private javax.swing.JTable facCabTable;
    private javax.swing.JComboBox<String> formatComboBox;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pathField;
    private javax.swing.JButton refreshButton;
    private javax.swing.JLabel saveStateLabel;
    private javax.swing.JLabel selectedFacCabLabel;
    // End of variables declaration//GEN-END:variables
}
