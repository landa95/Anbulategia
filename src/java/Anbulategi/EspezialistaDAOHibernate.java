/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Anbulategi;

import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author INAKI
 */
public class EspezialistaDAOHibernate implements EspezialistaDAO{
    
    @Override
    public void save(Espezialista espezialista){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
             try {
                session.beginTransaction();
                session.saveOrUpdate(espezialista);
                session.getTransaction().commit();
            }catch (Exception ex) {
                ex.printStackTrace();
                session.getTransaction().rollback();
            }
    }
    @Override
    public void delete(Espezialista espezialista){
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         try {
            session.beginTransaction();
            session.delete(espezialista);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        
    }
    @Override
    public void edit(Espezialista espezialista){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         try {
            session.beginTransaction();
            session.update(espezialista);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }  
        
    }
    @Override
    public Espezialista EspezialistaByNAN(int SNan){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Espezialista e = (Espezialista) session.get(Espezialista.class, SNan);
            session.getTransaction().commit();
            return e;
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return new Espezialista();
        }
        
    }
    
}
