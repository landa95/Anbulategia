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
public class ErrezetaDAOHibernate implements ErrezetaDAO {
    
    public void save(Errezeta errezeta){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
             try {
                session.beginTransaction();
                session.saveOrUpdate(errezeta);
                session.getTransaction().commit();
            }catch (Exception ex) {
                ex.printStackTrace();
                session.getTransaction().rollback();
            }
        
    }
    public void delete(Errezeta errezeta){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         try {
            session.beginTransaction();
            session.delete(errezeta);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        
    }
    public void edit(Errezeta errezeta){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         try {
            session.beginTransaction();
            session.update(errezeta);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    
}
