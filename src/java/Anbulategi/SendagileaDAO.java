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
public interface SendagileaDAO {
    public void save(Sendagilea sendagile);
    public void delete(Sendagilea sendagile);
    public void edit(Sendagilea sendagile);
    public Sendagilea getSendagileaByNAN(int SNan);
}
