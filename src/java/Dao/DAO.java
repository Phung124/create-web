/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Emty.Product;
import Emty.account;

import Emty.category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import newpackage.DBcontext;

/**
 *
 * @author phuc
 */
public class DAO {

    
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
     
    public List<Product> getAllProduct(){
    List<Product> list = new ArrayList<>();
    String query = "select * from SANPHAM";
    try{
      conn = new DBcontext().getConnection();
      ps  =conn.prepareStatement(query);
      rs = ps.executeQuery();
      while(rs.next()){
    list.add(new Product(rs.getInt(1),
            rs.getString(2),
            rs.getDouble(4),
            rs.getInt(5),
            rs.getString(6),
            rs.getString(3),
    rs.getInt(8),
    rs.getString(10)));
      }
      
    }catch(Exception e){
        
    }
    return list;
    }
public List<category> getAllCategory(){
    List<category> list = new ArrayList<>();
    String query = "select * from DANHMUC";
    try{
      conn = new DBcontext().getConnection();
      ps  =conn.prepareStatement(query);
      rs = ps.executeQuery();
      while(rs.next()){
    list.add(new category(rs.getString(1),
    rs.getString(2)));
      }
      
    }catch(Exception e){
        
    }
    return list;
    }

    public List<Product> getProductbyCategory(String did){
    List<Product> list = new ArrayList<>();
    String query = "select * from SANPHAM\n"
            +" where IDDANHMUC = ?";
    try{
      conn = new DBcontext().getConnection();
      ps  =conn.prepareStatement(query);
      ps.setString(1, did);
      rs = ps.executeQuery();
      while(rs.next()){
  list.add(new Product(rs.getInt("ID"),
            rs.getString("TENSANPHAM"),
            rs.getDouble("GIA"),
            rs.getInt("GIAGIAM"),
            rs.getString("DESCRIPTION"),
            rs.getString("HINHANH"),
    rs.getInt("QUANTITY"),
  rs.getString("SIZE1")));
      }
      
    }catch(Exception e){
        
    }
    return list;
    }
    public Product getProductbyID(int id){
    
    String query = "select * from SANPHAM\n"
            +" where ID = ?";
    try{
      conn = new DBcontext().getConnection();
      ps  =conn.prepareStatement(query);
      ps.setInt(1, id);
      rs = ps.executeQuery();
      while(rs.next()){
   
     return new Product(id,
           rs.getString("TENSANPHAM"),
            rs.getDouble("GIA"),
          rs.getInt("GIAGIAM"),
            rs.getString("DESCRIPTION"),
            rs.getString("HINHANH"),
    rs.getInt("QUANTITY"),
     rs.getString("SIZE1"));
      }
      
    }catch(Exception e){
        
    }
    return null;
    }
    public List<Product> Searchbyname(String txtSearch){
    List<Product> list = new ArrayList<>();
    String query = "select * from SANPHAM\n"
            +" where lower(TENSANPHAM) like ?";
    try{
      conn = new DBcontext().getConnection();
      ps  =conn.prepareStatement(query);
      ps.setString(1, "%"+txtSearch+"%");
      rs = ps.executeQuery();
      while(rs.next()){
       list.add(new Product(rs.getInt(1),
            rs.getString(2),
            rs.getDouble(4),
          rs.getInt(5),
            rs.getString(6),
            rs.getString(3),
    rs.getInt(8),
       rs.getString(10)));
      }
      
    }catch(Exception e){
        
    }
    return list;
    }
    public account getaccount(String user, String pass){
    
    String query = "select * from TAIKHOAN\n"
            +" where USERNAME = ?\n "+" AND PASS = ?";
    try{
      conn = new DBcontext().getConnection();
      ps  =conn.prepareStatement(query);
      ps.setString(1, user);
       ps.setString(2, pass);
      rs = ps.executeQuery();
      while(rs.next()){
   return new account( rs.getInt(1),         
           rs.getString(2),
    rs.getString(3),
    rs.getInt(4));
      }
      
    }catch(Exception e){
        
    }
    return null;
    }
    public account checkaccount(String user){
    
    String query = "select * from TAIKHOAN\n"
            +" where USERNAME = ?\n ";
    try{
      conn = new DBcontext().getConnection();
      ps  =conn.prepareStatement(query);
      ps.setString(1, user);
      rs = ps.executeQuery();
      while(rs.next()){
    return new account( rs.getInt(1),         
           rs.getString(2),
    rs.getString(3),
    rs.getInt(4));
      }
      
    }catch(Exception e){
        
    }
    return null;
    }
    public void Signup(String user, String pass){
    
    String query = "Insert into TAIKHOAN\n "+"values (?,?,0)";
        try {
            conn = new DBcontext().getConnection();
      ps  =conn.prepareStatement(query);
      ps.setString(1, user);
      ps.setString(2, pass);
      ps.executeUpdate();
        } catch (Exception e) {
        }
    
    }
      public Product deleteProduct(int id){
    
    String query = "Delete FROM SANPHAM\n"
            +" where ID = ?";
    try{
      conn = new DBcontext().getConnection();
      ps  =conn.prepareStatement(query);
      ps.setInt(1, id);
      ps.executeUpdate();
        } catch (Exception e) {
        }    return null;
    }
         public void insertProduct(int id ,String name, String imsges, String price, String description, String category){
    
    String query = "INSERT INTO SANPHAM(ID,TENSANPHAM,HINHANH,GIA,DESCRIPTION,IDDANHMUC)"
            +"VALUES(?,?,?,?,?,?)";
    try{
      conn = new DBcontext().getConnection();
      ps  =conn.prepareStatement(query);
      ps.setInt(1, id);
      ps.setString(2, name);
      ps.setString(3, imsges);
      ps.setString(4, price);
      ps.setString(5, description);
      ps.setString(6, category);
      
      ps.executeUpdate();
        } catch (Exception e) {
        }  
    }
         public void updateProduct( String name, String imsges, String price, String description, String category,int id){
    
    String query = (" UPDATE SANPHAM\n"
            +"SET TENSANPHAM = ?,\n"
            +"HINHANH = ?,\n"
            +"GIA = ?,\n"
            +"DESCRIPTION = ?,\n"
            +"IDDANHMUC = ?\n"
            + "WHERE ID = ?");
    try{
      conn = new DBcontext().getConnection();
      ps  =conn.prepareStatement(query);
      ps.setString(1, name);
      ps.setString(2, imsges);
      ps.setString(3, price);
      ps.setString(4, description);
      ps.setString(5, category);
      ps.setInt(6, id);
      ps.executeUpdate();
        } catch (Exception e) {
        }  
    }
 public Product checkidsanpham(int id){
    
    String query = "select * from SANPHAM\n"
            +" where ID = ?\n ";
    try{
      conn = new DBcontext().getConnection();
      ps  =conn.prepareStatement(query);
      ps.setInt(1, id);
      rs = ps.executeQuery();
      while(rs.next()){
    return new Product(rs.getInt(1),
            rs.getString(2),
            rs.getDouble(3),
           rs.getInt(5),
            rs.getString(7),
            rs.getString(6),
      rs.getInt(8),
    rs.getString(10));
      }
      
    }catch(Exception e){
        
    }
    return null;
    }
  public List<Product> top3(){
    List<Product> list = new ArrayList<>();
    String query = "select * from SANPHAM where ROWNUM  <=3\n ";
    try{
      conn = new DBcontext().getConnection();
      ps  =conn.prepareStatement(query);
      rs = ps.executeQuery();
      while(rs.next()){
    list.add(new Product(rs.getInt(1),
            rs.getString(2),
            rs.getDouble(4),
            rs.getInt(5),
            rs.getString(6),
            rs.getString(3),
    rs.getInt(8),
    rs.getString(10)));
      }
      
    }catch(Exception e){
        
    }
    return list;
    }
   public List<Product> top4(){
    List<Product> list = new ArrayList<>();
    String query = "select * from SANPHAM where ROWNUM  <=4\n ";
    try{
      conn = new DBcontext().getConnection();
      ps  =conn.prepareStatement(query);
      rs = ps.executeQuery();
      while(rs.next()){
    list.add(new Product(rs.getInt(1),
            rs.getString(2),
            rs.getDouble(4),
            rs.getInt(5),
            rs.getString(6),
            rs.getString(3),
    rs.getInt(8),
    rs.getString(10)));
      }
      
    }catch(Exception e){
        
    }
    return list;
    }
     public List<Product> giagiam(){
    List<Product> list = new ArrayList<>();
    String query = "select * from SANPHAM where GIAGIAM >0\n ";
    try{
      conn = new DBcontext().getConnection();
      ps  =conn.prepareStatement(query);
      rs = ps.executeQuery();
      while(rs.next()){
    list.add(new Product(rs.getInt(1),
            rs.getString(2),
            rs.getDouble(4),
            rs.getInt(5),
            rs.getString(6),
            rs.getString(3),
    rs.getInt(8),
    rs.getString(10)));
      }
      
    }catch(Exception e){
        
    }
    return list;
    }
      public List<Product> gia(){
    List<Product> list = new ArrayList<>();
    String query = "select *from sanpham where gia>0 and gia<150\n ";
    try{
      conn = new DBcontext().getConnection();
      ps  =conn.prepareStatement(query);
      rs = ps.executeQuery();
      while(rs.next()){
    list.add(new Product(rs.getInt(1),
            rs.getString(2),
            rs.getDouble(4),
            rs.getInt(5),
            rs.getString(6),
            rs.getString(3),
    rs.getInt(8),
    rs.getString(10)));
      }
      
    }catch(Exception e){
        
    }
    return list;
    }
      public List<Product> gia1(){
    List<Product> list = new ArrayList<>();
    String query = "select *from sanpham where gia>=150 and gia<300\n ";
    try{
      conn = new DBcontext().getConnection();
      ps  =conn.prepareStatement(query);
      rs = ps.executeQuery();
      while(rs.next()){
    list.add(new Product(rs.getInt(1),
            rs.getString(2),
            rs.getDouble(4),
            rs.getInt(5),
            rs.getString(6),
            rs.getString(3),
    rs.getInt(8),rs.getString(10)));
      }
      
    }catch(Exception e){
        
    }
    return list;
    }
      public List<Product> gia2(){
    List<Product> list = new ArrayList<>();
    String query = "select *from sanpham where gia>300";
    try{
      conn = new DBcontext().getConnection();
      ps  =conn.prepareStatement(query);
      rs = ps.executeQuery();
      while(rs.next()){
    list.add(new Product(rs.getInt(1),
            rs.getString(2),
            rs.getDouble(4),
            rs.getInt(5),
            rs.getString(6),
            rs.getString(3),
    rs.getInt(8),
    rs.getString(10)));
      }
      
    }catch(Exception e){
        
    }
    return list;
    }
        public List<Product> getProductBySize(){
    List<Product> list = new ArrayList<>();
   String query = "select * from SANPHAM where SIZE1 = 'nhỏ' ";
    try{
      conn = new DBcontext().getConnection();
      ps  =conn.prepareStatement(query);
      rs = ps.executeQuery();
      while(rs.next()){
    list.add(new Product(rs.getInt(1),
            rs.getString(2),
            rs.getDouble(4),
            rs.getInt(5),
            rs.getString(6),
            rs.getString(3),
    rs.getInt(8),
    rs.getString(10)));
      }
      
    }catch(Exception e){
        
    }
    return list;
    }
       public List<Product> getProductBySize1(){
    List<Product> list = new ArrayList<>();
   String query = "select * from SANPHAM where SIZE1 = 'trung bình' ";
    try{
      conn = new DBcontext().getConnection();
      ps  =conn.prepareStatement(query);
      rs = ps.executeQuery();
      while(rs.next()){
    list.add(new Product(rs.getInt(1),
            rs.getString(2),
            rs.getDouble(4),
            rs.getInt(5),
            rs.getString(6),
            rs.getString(3),
    rs.getInt(8),
    rs.getString(10)));
      }
      
    }catch(Exception e){
        
    }
    return list;
    }
  public List<Product> getProductBySize2(){
    List<Product> list = new ArrayList<>();
   String query = "select * from SANPHAM where SIZE1 = 'lớn' ";
    try{
      conn = new DBcontext().getConnection();
      ps  =conn.prepareStatement(query);
      rs = ps.executeQuery();
      while(rs.next()){
    list.add(new Product(rs.getInt(1),
            rs.getString(2),
            rs.getDouble(4),
            rs.getInt(5),
            rs.getString(6),
            rs.getString(3),
    rs.getInt(8),
    rs.getString(10)));
      }
      
    }catch(Exception e){
        
    }
    return list;
    }

public static void main(String[] args ){
DAO dao =new DAO();
  List<Product> list = dao.getAllProduct();
   List<category> listC = dao.getAllCategory();
     List<Product> list2 = dao.Searchbyname("hoa");
      List<Product> list1 = dao.getProductbyCategory("DM1");
       List<Product> list11 = dao.top4();
     
  for(Product o :list11){
      System.out.println(o);


  }


}
}
