package controllers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.EstadisticasClientes;
import models.FacturasCab;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CtrlStats {

    private Connection connection;
    private Statement statement;
    private boolean result;
    SimpleDateFormat sdf = FacturasProgram.sdf;
    private final SessionFactory sf;
    private Session ss;
    private ArrayList<EstadisticasClientes> listaStats;
    
    public CtrlStats() {
        connectServer();
        connectToDB();
        sf = HibernateUtil.getSessionFactory();
    }
    public void updateList() {
        ss = sf.openSession();
        try {
            Criteria criteria = ss.createCriteria(EstadisticasClientes.class);
            listaStats = (ArrayList<EstadisticasClientes>) criteria.list();
        } catch (HibernateException he) {
            JOptionPane.showMessageDialog(null, "error " + he.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        } finally {
            ss.close();
        }
    }

    public void updateStat(FacturasCab c) {
        ss = sf.openSession();
        ss.beginTransaction();
        ss.update(c);
        ss.getTransaction().commit();
        ss.close();
    }

    public void insertStat(FacturasCab c) {
        ss = sf.openSession();
        ss.beginTransaction();
        ss.save(c);
        ss.getTransaction().commit();
        ss.close();
    }

    public void removeStat(FacturasCab c) {
        ss = sf.openSession();
        ss.beginTransaction();
        ss.delete(c);
        ss.getTransaction().commit();
        ss.close();
    }

    public ArrayList<EstadisticasClientes> getListaStats() {
        return listaStats;
    }
    
    public final boolean connectServer() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            result = true;
        } catch (ClassNotFoundException ex) {
            result = false;
        }
        return result;
    }

    public final boolean connectToDB() {
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "AD_TEMA_03_FACTURAS", "AD_TEMA_03_FACTURAS");
            result = true;
        } catch (SQLException ex) {
            result = false;
        }
        return result;
    }

    public void close() {
        try {
            
            if (statement != null) statement.close();
            if (connection != null) connection.close();
            
        } catch (SQLException ex) {
        }
    }   
    
    public java.sql.Date stringToSQLDate(String date) throws ParseException {
        java.util.Date uDate = sdf.parse(date);
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    public boolean executeProcedure(String fecha1, String fecha2, String dnicif1, String dnicif2) {
        result = connectToDB();
        try {
            if (result) {
                CallableStatement cst = connection.prepareCall("{call SP_ESTADISTICAS (?,?,?,?)}");
                java.sql.Date fecha1SQL = stringToSQLDate(fecha1);
                java.sql.Date fecha2SQL = stringToSQLDate(fecha2);
                if (fecha1SQL != null && fecha2SQL != null) {
                    if (fecha1SQL.compareTo(fecha2SQL) > 0) {
                        cst.setDate(3, fecha2SQL);
                        cst.setDate(4, fecha1SQL);

                    } else {
                        cst.setDate(3, fecha1SQL);
                        cst.setDate(4, fecha2SQL);
                    }

                    cst.setString(1, dnicif1);
                    cst.setString(2, dnicif2);
                    result = cst.execute();
                    if (!result) {
                        result = true;
                    } else {
                        result = false;
                    }

                } else {
                    result = false;
                }
            }

        } catch (SQLException | ParseException ex) {
            result = false;
        }
        close();

        return result;
    }
}
