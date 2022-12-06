/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Emty;

/**
 *
 * @author phuc
 */
public class category {
    private String did;
    private String dname;

    public category(String did, String dname) {
        this.did = did;
        this.dname = dname;
    }

    public category() {
    }

    public String getDid() {
        return did;
    }

    public String getDname() {
        return dname;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "category{" + "did=" + did + ", dname=" + dname + '}';
    }
    
    
}
