package web;

import javax.faces.bean.ManagedBean;
 
@ManagedBean
public class PasswordView {
     
    private String password2;
 
    public String getPassword2() {
        return password2;
    }
 
    public void setPassword2(String password2) {
        this.password2 = password2;
    }  
}