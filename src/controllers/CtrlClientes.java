package controllers;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Clientes;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CtrlClientes {
    private final SessionFactory sf;
    private Session ss;
    private ArrayList<Clientes> listaClientes;

    public CtrlClientes() {
        sf = HibernateUtil.getSessionFactory();
        updateList();
    }

    public void updateList() {
        ss = sf.openSession();
        try {
            Criteria criteria = ss.createCriteria(Clientes.class);
            listaClientes = (ArrayList<Clientes>) criteria.list();
        } catch (HibernateException he) {
            JOptionPane.showMessageDialog(null, "error " + he.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        } finally {
            ss.close();
        }
    }
    
    public Clientes getClienteById(String id) {
        ss = sf.openSession();
        Clientes toReturn = (Clientes) ss.get(Clientes.class, id);
        ss.close();
        return toReturn;
    }
    
    public void updateCliente(Clientes c) {
        ss = sf.openSession();
        ss.beginTransaction();
        ss.update(c);
        ss.getTransaction().commit();
        ss.close();
    }
    
    public void insertCliente(Clientes c) {
        ss = sf.openSession();
        ss.beginTransaction();
        ss.save(c);
        ss.getTransaction().commit();
        ss.close();
    }
    
    public void removeCliente(Clientes c) {
        ss = sf.openSession();
        ss.beginTransaction();
        ss.delete(c);
        ss.getTransaction().commit();
        ss.close();
    }

    public ArrayList<Clientes> getListaClientes() {
        return listaClientes;
    }
}
