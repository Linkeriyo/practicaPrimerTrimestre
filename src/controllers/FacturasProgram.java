package controllers;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import exportmodels.JSONFactura;
import views.MainFrame;

public class FacturasProgram {
    public static SimpleDateFormat sdf;
    public static CtrlArticulos cArticulos;
    public static CtrlClientes cClientes;
    public static CtrlFacturasCab cFacturasCab;
    public static CtrlFacturasLin cFacturasLin;
    public static CtrlFacturasTot cFacturasTot;
    
    private static void setLookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public static String bigDecimalToString(BigDecimal bd, String unit) {
        if (unit == null) {
            unit = "";
        }

        if (bd == null) {
            return "null";
        } else if (bd.toString().endsWith(".00")
                || bd.toString().endsWith(".0")) {
            return bd.toBigInteger().toString() + unit;
        } else if (bd.toString().matches("[0-9]+\\.[0-9]")) {
            return bd.toString() + "0" + unit;
        } else {
            return bd.toString() + unit;
        }
    }
    
    public static String nullStringIfNull(String s) {
        if (s == null) {
            return "null";
        } else {
            return s;
        }
    }
    
    private static void initializeControllers() {   
        cArticulos = new CtrlArticulos();
        cClientes = new CtrlClientes();
        cFacturasCab = new CtrlFacturasCab();
        cFacturasLin = new CtrlFacturasLin();
        cFacturasTot = new CtrlFacturasTot();
    }
    
    public static void main(String[] args) {
        initializeControllers();
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        setLookAndFeel();
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
    }
}
