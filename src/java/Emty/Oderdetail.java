/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Emty;

/**
 *
 * @author phuc
 */
public class Oderdetail {
    
    private int oid,pid,quantity;
    private double price;

    public Oderdetail() {
    }

    public Oderdetail(int oid, int pid, int quantity, double price) {
        this.oid = oid;
        this.pid = pid;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOid() {
        return oid;
    }

    public int getPid() {
        return pid;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

   
    
}
