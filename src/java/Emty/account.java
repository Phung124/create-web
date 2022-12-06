/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Emty;



/**
 *
 * @author phuc
 */
public class account {
    private int id ;
    private String user;
    private String pass;
    private int admin;

    public account(int id, String user, String pass, int admin) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.admin = admin;
    }

  

    public account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    

  
  
  

 
    
}
