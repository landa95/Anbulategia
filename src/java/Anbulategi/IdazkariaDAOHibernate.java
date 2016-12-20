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
public class IdazkariaDAOHibernate implements IdazkariaDAO {
    
    @Override
    public void save(Idazkaria idazkari){
                 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
             try {
                session.beginTransaction();
                session.saveOrUpdate(idazkari);
                session.getTransaction().commit();
            }catch (Exception ex) {
                ex.printStackTrace();
                session.getTransaction().rollback();
            }
    }
    
    @Override
    public void delete(Idazkaria idazkari){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         try {
            session.beginTransaction();
            session.delete(idazkari);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        
    }
    @Override
    public void edit(Idazkaria idazkari){
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         try {
            session.beginTransaction();
            session.update(idazkari);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }  
        
    }
    @Override
    public boolean checkIdazkari(int id, String password){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            String hql = "From Idazkaria idazkari where idazkari.id = ? and idazkari.pasahitza = ?";
            Query kontsulta = session.createQuery(hql).setParameter(0, id).setParameter(1, password);
            List<Idazkaria> lista = kontsulta.list();
            session.getTransaction().commit();
            return !lista.isEmpty();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
            
}
