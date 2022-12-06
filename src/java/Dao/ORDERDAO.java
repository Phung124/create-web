/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Emty.Cart;
import Emty.Item;
import Emty.Product;
import Emty.account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import newpackage.DBcontext;

/**
 *
 * @author phuc
 */
public class ORDERDAO {
    Connection conn = null;   
 public void addOrder(account u, Cart cart){
LocalDate curDate = java.time.LocalDate.now();
 String date = curDate.toString();
         try{
              
             String sql ="Insert into ORDER1(DATE1,CID,totalmoney)"+"values (?,?,?)";
          conn = new DBcontext().getConnection();
     PreparedStatement ps  =conn.prepareStatement(sql);
        ps.setString(1,date);
        ps.setInt(2,u.getId());
        ps.setDouble(3, cart.getTotalmoney());
        
        String sql1 ="select top 1 id from ORDER1 order by id desc";
        conn = new DBcontext().getConnection();
        PreparedStatement st1 =conn.prepareStatement(sql1);
     
       
         ResultSet rs =st1.executeQuery();
         if(rs.next()){
         int oid=rs.getInt(1);
         for(Item i:cart.getItems()){
         String sql2="insert into ORDERLINE(OID,ID,QUANTITY,PRICE)" +"values (?,?,?,?)";

           conn = new DBcontext().getConnection();
       PreparedStatement st2 =conn.prepareStatement(sql2);
         st2.setInt(1, oid);
         st2.setInt(2, i.getProduct().getId());
         st2.setInt(3, i.getQuantity());
          st2.setDouble(4, i.getPrice());
          st2.executeUpdate();
         }
         }
         } catch(SQLException e){
             System.out.println(e);
    }
 }
}
