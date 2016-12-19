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
public class SendagileaDAOHibernate implements SendagileaDAO{
        
        public void save(Sendagilea sendagile){
            
             Session session = HibernateUtil.getSessionFactory().getCurrentSession();
             try {
                session.beginTransaction();
                session.saveOrUpdate(sendagile);
                session.getTransaction().commit();
            }catch (Exception ex) {
                ex.printStackTrace();
                session.getTransaction().rollback();
            }
        }
    public void delete(Sendagilea sendagile){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         try {
            session.beginTransaction();
            session.delete(sendagile);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        
    }
    public void edit(Sendagilea sendagile){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         try {
            session.beginTransaction();
            session.update(sendagile);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        
    }
}
