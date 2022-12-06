/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author phuc
 */
public class DBcontext {
  public static Connection getConnection () throws SQLException{
       final String url = "jdbc:oracle:thin:@localhost:1521:xe";
          final String user = "c##scott";
          final String password ="12121314";
      try {       
          Class.forName("oracle.jdbc.driver.OracleDriver");
          
          return DriverManager.getConnection( url, user, password);
          
      } catch (ClassNotFoundException ex) {
          System.out.println("Opps,error:");
      }
     return null;
  }
}

//   public static void main (string){
//  final String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
//   String username = "c##scott";
//   String password ="12121314";
//   
//   try{
//Connection connection = DriverManager.getConnection(dbURL,username, password);
//
//System.out.println("Connected to Oracle database server");
//   }catch(SQLException e){
//    System.out.println("Opps,error:");
//e.printStackTrace();
//}
//
//}
