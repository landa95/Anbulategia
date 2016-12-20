/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Anbulategi;

import java.util.List;
import java.util.Set;

/**
 *
 * @author INAKI
 */
public interface GaixoaDAO {
    public void save(Gaixoa gaixo);
    public void delete(Gaixoa gaixo);
    public void edit(Gaixoa gaixo);
    public Gaixoa getGaixoaByGSZ(int GSZ);
    public List<Errezeta> lortuErrezetak(int GSZ);
    public List<bajaTxostena> lortuBajaTxostenak(int GSZ);
    public boolean gaixoaDago(Gaixoa ga);
    public boolean checkGaixoa(int GSZ, String password);
}
