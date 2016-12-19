/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Anbulategi;

/**
 *
 * @author INAKI
 */
public interface EspezialistaDAO {
    
    public void save(Espezialista espezialista);
    public void delete(Espezialista espezialista);
    public void edit(Espezialista espezialista);
    public Espezialista EspezialistaByNAN(int SNan);
    
}
