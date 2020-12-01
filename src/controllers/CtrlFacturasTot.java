package controllers;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.FacturasTot;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CtrlFacturasTot {
    private final SessionFactory sf;
    private Session ss;
    private ArrayList<FacturasTot> listaFacturasTot;

    public CtrlFacturasTot() {
        sf = HibernateUtil.getSessionFactory();
        updateList();
    }

    public void updateList() {
        ss = sf.openSession();
        try {
            Criteria criteria = ss.createCriteria(FacturasTot.class);
            listaFacturasTot = (ArrayList<FacturasTot>) criteria.list();
        } catch (HibernateException he) {
            JOptionPane.showMessageDialog(null, "error " + he.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        } finally {
            ss.close();
        }
    }
    
    public FacturasTot getFacturaTotById(String id) {
        ss = sf.openSession();
        FacturasTot toReturn = (FacturasTot) ss.get(FacturasTot.class, id);
        ss.close();
        return toReturn;
    }
    
    public void updateFacturaTot(FacturasTot c) {
        ss = sf.openSession();
        ss.beginTransaction();
        ss.update(c);
        ss.getTransaction().commit();
        ss.close();
    }
    
    public void insertFacturaTot(FacturasTot c) {
        ss = sf.openSession();
        ss.beginTransaction();
        ss.save(c);
        ss.getTransaction().commit();
        ss.close();
    }
    
    public void removeFacturaTot(FacturasTot c) {
        ss = sf.openSession();
        ss.beginTransaction();
        ss.delete(c);
        ss.getTransaction().commit();
        ss.close();
    }

    public ArrayList<FacturasTot> getListaFacturasTot() {
        return listaFacturasTot;
    }
}
