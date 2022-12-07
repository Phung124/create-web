///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package Dao;
//
//import Emty.account;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import newpackage.DBcontext;
//
///**
// *
// * @author phuc
// */
//public class CustomerDAOO {
//    
//    
//    Connection conn = null;
//    PreparedStatement ps = null;
//    ResultSet rs = null;
//    
//    public account getaccount(String user, String pass){
//    
//    String query = "select * from TAIKHOAN\n"
//            +" where USERNAME = ?\n "+" AND PASS = ?";
//    try{
//      conn = new DBcontext().getConnection();
//      ps  =conn.prepareStatement(query);
//      ps.setString(1, user);
//       ps.setString(2, pass);
//      rs = ps.executeQuery();
//      while(rs.next()){
//   return new account( rs.getInt(1),         
//           rs.getString(2),
//    rs.getString(3),
//    rs.getInt(4));
//      }
//      
//    }catch(Exception e){
//        
//    }
//    return null;
//    }
//    }
