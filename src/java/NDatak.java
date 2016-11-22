import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Oier
 */
class NDatak {
     SimpleDateFormat ft = new SimpleDateFormat ("HH:mm");
     
     public String dataEman(Date pData){
         return ft.format(pData);
     }
}
