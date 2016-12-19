/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Anbulategi;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author INAKI
 */
public class GaixoaDAOHibernate implements GaixoaDAO {
    public void save(Gaixoa gaixo){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         try {
            session.beginTransaction();
            session.saveOrUpdate(gaixo);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    @Override
    public void delete(Gaixoa gaixo){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         try {
            session.beginTransaction();
            session.delete(gaixo);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        
    }
    
    @Override
    public void edit(Gaixoa gaixo){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         try {
            session.beginTransaction();
            session.update(gaixo);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    @Override
    public Gaixoa getGaixoaByGSZ(int GSZ){
                Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Gaixoa e = (Gaixoa) session.get(Gaixoa.class, GSZ);
            session.getTransaction().commit();
            return e;
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return new Gaixoa();
        }
    }
    
    @Override
    public List<Errezeta> lortuErrezetak(int GSZ){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         try {
            session.beginTransaction();
            String hql = "From Errezeta errezeta where gaixoa.GSZ = ?";
            Query kontsulta = session.createQuery(hql).setParameter(0, GSZ);
            List<Errezeta> set = kontsulta.list();
            
            session.getTransaction().commit();
            return set;
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    @Override
    public List<bajaTxostena> lortuBajaTxostenak(int GSZ){
                Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         try {
            session.beginTransaction();
            String hql = "From bajaTxostena Baja where baja.GSZ = ?";
            Query kontsulta = session.createQuery(hql).setParameter(0, GSZ);
            List<bajaTxostena> set = kontsulta.list();
            
            session.getTransaction().commit();
            return set;
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    
}
