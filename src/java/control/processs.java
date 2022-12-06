/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import Dao.DAO;
import Emty.Cart;
import Emty.Item;
import Emty.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author phuc
 */
@WebServlet(name = "processs", urlPatterns = {"/processs"})
public class processs extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        Cart cart = null;
        Object o =session.getAttribute("cart");
      if(o!=null){
      cart=(Cart)o;
      }else{
      cart=new Cart();
      }
         String iinum = request.getParameter("num").trim();
          int num;
           String iid = request.getParameter("id");
           
        int id;
          try{
              num=Integer.parseInt(iinum);
          id=Integer.parseInt(iid);
         if((num==-1)&&(cart.getQuantityById(id)<=1)){
         cart.removeItem(id);
         }else{
          DAO dao =new DAO();
          Product p = dao.getProductbyID(id);
 
          double price =p.getPrice()*1.2;
          Item t = new Item(p, num, price);
          cart.addItem(t);
         }
         
          
          }catch(NumberFormatException e){
              System.out.println("e");
          }
          List<Item> list =cart.getItems();
         double d =0;
          
         d= cart.getTotalmoney();
          session.setAttribute("cart",cart);
          session.setAttribute("d",d);
        
          
          session.setAttribute("size",list.size());
          request.getRequestDispatcher("shoping-cart.jsp").forward(request, response);
        }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
