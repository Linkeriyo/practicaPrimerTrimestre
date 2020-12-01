package controllers;

import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    
    static {
        try {
            Configuration config = new Configuration();
            config.configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).build();
            sessionFactory = config.buildSessionFactory(serviceRegistry);
        } catch (HibernateException ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            JOptionPane.showMessageDialog(null,
                    "No se ha podido inicializar hibernate, comprueba que la base de datos es correcta.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
