package controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import models.FacturasCab;
import models.FacturasLin;
import models.FacturasTot;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CtrlFacturasCab {

    private final SessionFactory sf;
    private Session ss;
    private ArrayList<FacturasCab> listaFacturasCab;

    public CtrlFacturasCab() {
        sf = HibernateUtil.getSessionFactory();
        updateList();
    }

    public void updateList() {
        ss = sf.openSession();
        try {
            Criteria criteria = ss.createCriteria(FacturasCab.class);
            listaFacturasCab = (ArrayList<FacturasCab>) criteria.list();
        } catch (HibernateException he) {
            JOptionPane.showMessageDialog(null, "error " + he.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        } finally {
            ss.close();
        }
    }

    public FacturasCab getFacturaCabById(long id) {
        ss = sf.openSession();
        FacturasCab toReturn = (FacturasCab) ss.get(FacturasCab.class, id);
        ss.close();
        return toReturn;
    }

    public void updateFacturaCab(FacturasCab c) {
        ss = sf.openSession();
        ss.beginTransaction();
        ss.update(c);
        ss.getTransaction().commit();
        ss.close();
    }

    public void insertFacturaCab(FacturasCab c) {
        ss = sf.openSession();
        ss.beginTransaction();
        ss.save(c);
        ss.getTransaction().commit();
        ss.close();
    }

    public void removeFacturaCab(FacturasCab c) {
        ss = sf.openSession();
        ss.beginTransaction();
        ss.delete(c);
        ss.getTransaction().commit();
        ss.close();
    }

    public ArrayList<FacturasCab> getListaFacturasCab() {
        return listaFacturasCab;
    }

    public FacturasCab calculateTotalThenGet(long numfac) {
        FacturasCab facturaCab = getFacturaCabById(numfac);

        //Lista con las líneas de la factura introducida
        ArrayList<FacturasLin> lineasFactura = new ArrayList<>();
        FacturasProgram.cFacturasLin.getListaFacturasLin().forEach(lf -> {
            if (lf.getId().getNumfac() == facturaCab.getNumfac()) {
                lineasFactura.add(lf);
            }
        });

        //Calcular base imponible
        BigDecimal baseImp = BigDecimal.ZERO;
        for (FacturasLin lf : lineasFactura) {
            baseImp = baseImp.add(lf.getPrecio().multiply(lf.getCantidad()));
        }

        //Calcular importe del descuento
        BigDecimal impDto = BigDecimal.ZERO;
        for (FacturasLin lf : lineasFactura) {
            BigDecimal importe = lf.getPrecio().multiply(lf.getDtolinea().divide(BigDecimal.valueOf(100.0)));
            impDto = impDto.add(importe);
        }

        //Calcular importe del iva
        BigDecimal impIva = BigDecimal.ZERO;
        for (FacturasLin lf : lineasFactura) {
            BigDecimal importe = lf.getPrecio().multiply(lf.getIvalinea().divide(BigDecimal.valueOf(100.0)));
            impIva = impIva.add(importe);
        }

        //Calcular el importe total
        BigDecimal impTotal = baseImp.add(impIva).subtract(impDto);

        //Actualizar los valores en la base de datos
        FacturasTot ft = new FacturasTot(facturaCab, baseImp, impDto, impIva, impTotal);
        
        if (facturaCab.getFacturasTot() == null) {
            FacturasProgram.cFacturasTot.insertFacturaTot(ft);
        } else {
            FacturasProgram.cFacturasTot.updateFacturaTot(ft);
        }
        
        
        return facturaCab;
    }

    public long getNextAvailableLinId(long numfac) {
        ArrayList<Long> ids = new ArrayList<>();

        FacturasProgram.cFacturasLin.getListaFacturasLin().forEach(lf -> {
            if (lf.getFacturasCab().getNumfac() == getFacturaCabById(numfac).getNumfac()) {
                ids.add(lf.getId().getLineafac());
            }
        });

        if (ids.isEmpty()) {
            return 1;
        }

        ids.sort(Comparator.comparingLong(id -> {
            return id;
        }));
        for (int i = 1; i <= ids.size(); i++) {
            if (i < ids.get(i - 1)) {
                return i; // "i" is missing, return that
            }
        }
        return ids.size() + 1;
    }
}
