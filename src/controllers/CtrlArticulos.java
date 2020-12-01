package controllers;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Articulos;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CtrlArticulos {
    private final SessionFactory sf;
    private Session ss;
    private ArrayList<Articulos> listaArticulos;

    public CtrlArticulos() {
        sf = HibernateUtil.getSessionFactory();
        updateList();
    }

    public void updateList() {
        ss = sf.openSession();
        try {
            Criteria criteria = ss.createCriteria(Articulos.class);
            listaArticulos = (ArrayList<Articulos>) criteria.list();
        } catch (HibernateException he) {
            JOptionPane.showMessageDialog(null, "error " + he.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        } finally {
            ss.close();
        }
    }
    
    public Articulos getArticuloById(String id) {
        ss = sf.openSession();
        Articulos toReturn = (Articulos) ss.get(Articulos.class, id);
        ss.close();
        return toReturn;
    }
    
    public void updateArticulo(Articulos a) {
        ss = sf.openSession();
        ss.beginTransaction();
        ss.update(a);
        ss.getTransaction().commit();
        ss.close();
    }
    
    public void insertArticulo(Articulos a) {
        ss = sf.openSession();
        ss.beginTransaction();
        ss.save(a);
        ss.getTransaction().commit();
        ss.close();
    }
    
    public void removeArticulo(Articulos a) {
        ss = sf.openSession();
        ss.beginTransaction();
        ss.delete(a);
        ss.getTransaction().commit();
        ss.close();
    }

    public ArrayList<Articulos> getListaArticulos() {
        return listaArticulos;
    }
}
