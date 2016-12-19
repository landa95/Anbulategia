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
public class HistorialDAOHibernate implements HistorialDAO {
    
   public void save(Historial historiala){
       
       Session session = HibernateUtil.getSessionFactory().getCurrentSession();
             try {
                session.beginTransaction();
                session.saveOrUpdate(historiala);
                session.getTransaction().commit();
            }catch (Exception ex) {
                ex.printStackTrace();
                session.getTransaction().rollback();
            }
   }
    public void delete(Historial historiala){
        
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         try {
            session.beginTransaction();
            session.delete(historiala);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
    }
            
    public void edit(Historial historiala){
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         try {
            session.beginTransaction();
            session.update(historiala);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
