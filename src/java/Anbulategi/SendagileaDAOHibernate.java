/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Anbulategi;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author INAKI
 */
public class SendagileaDAOHibernate implements SendagileaDAO{
        
        @Override
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
        @Override
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
        @Override
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
    
         @Override
     public Sendagilea getSendagileaByNAN(int SNan){
             Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Sendagilea e = (Sendagilea) session.get(Sendagilea.class, SNan);
            session.getTransaction().commit();
            return e;
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return new Sendagilea();
        }
     }
     
         @Override
    public boolean checkSendagile(int GSZ, String password){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            String hql = "From Sendagilea sendagile where sendagile.NAN = ? and sendagile.pasahitza = ?";
            Query kontsulta = session.createQuery(hql).setParameter(0, GSZ).setParameter(1, password);
            List<Gaixoa> lista = kontsulta.list();
            session.getTransaction().commit();
            return !lista.isEmpty();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
}
