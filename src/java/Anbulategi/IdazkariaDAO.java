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
public interface IdazkariaDAO {
    public void save(Idazkaria idazkari);
    public void delete(Idazkaria idazkari);
    public void edit(Idazkaria idazkari);
    public boolean checkIdazkari(int id, String password);
}
