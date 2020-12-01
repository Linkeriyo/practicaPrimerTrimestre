package controllers;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.FacturasLin;
import models.FacturasLinId;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CtrlFacturasLin {

    private final SessionFactory sf;
    private Session ss;
    private ArrayList<FacturasLin> listaFacturasLin;

    public CtrlFacturasLin() {
        sf = HibernateUtil.getSessionFactory();
        updateList();
    }

    public void updateList() {
        ss = sf.openSession();
        try {
            Criteria criteria = ss.createCriteria(FacturasLin.class);
            listaFacturasLin = (ArrayList<FacturasLin>) criteria.list();
        } catch (HibernateException he) {
            JOptionPane.showMessageDialog(null, "error " + he.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        } finally {
            ss.close();
        }
    }

    public FacturasLin getFacturaLinById(FacturasLinId id) {
        ss = sf.openSession();
        FacturasLin toReturn = (FacturasLin) ss.get(FacturasLin.class, id);
        ss.close();
        return toReturn;
    }

    public void updateFacturaLin(FacturasLin c) {
        ss = sf.openSession();
        ss.beginTransaction();
        ss.update(c);
        ss.getTransaction().commit();
        ss.close();
    }

    public void insertFacturaLin(FacturasLin linea) {
        // Buscar si hay alguna línea con el artículo
        updateList();
        boolean articuloExists = false;
        for (FacturasLin lf : listaFacturasLin) {
            if (lf.getId().getNumfac() == linea.getId().getNumfac()) {
                if (lf.getArticulos().getReferencia().equals(
                        linea.getArticulos().getReferencia())) {
                    articuloExists = true;
                }
            }
        }

        ss = sf.openSession();
        ss.beginTransaction();

        //Si hay alguna línea con el artículo, le sumo la cantidad de la nueva línea en vez de crear una nueva.
        if (articuloExists) {
            FacturasLin existingLF = null;
            for (FacturasLin lf : listaFacturasLin) {
                if (lf.getArticulos().getReferencia().equals(linea.getArticulos().getReferencia())) {
                    existingLF = lf;
                }
            }
            existingLF.setCantidad(existingLF.getCantidad().add(linea.getCantidad()));
            ss.update(existingLF);
        } else {
            ss.save(linea);
        }

        ss.getTransaction().commit();
        ss.close();
    }

    public void removeFacturaLin(FacturasLin c) {
        ss = sf.openSession();
        ss.beginTransaction();
        ss.delete(c);
        ss.getTransaction().commit();
        ss.close();
    }

    public ArrayList<FacturasLin> getListaFacturasLin() {
        return listaFacturasLin;
    }
}
