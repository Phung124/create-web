/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Emty;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phuc
 */
public class Cart {
    private List<Item> items;
    
    public Cart(){
        items = new ArrayList<>();
    }
 public Cart(List<Item> items){
        this.items = items;
    }
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
      private Item getItemById(int id){
 for (Item i:items)
 if(i.getProduct().getId()==id)
 return i;
   return null;
   }
    public int getQuantityById(int id){
    return getItemById(id).getQuantity();
    }
 
   public void addItem(Item t){
      if(getItemById(t.getProduct().getId())!=null){
           Item i =getItemById(t.getProduct().getId());
           i.setQuantity(i.getQuantity()+t.getQuantity());
           
      }else {
          items.add(t);
      }
   }
   public void removeItem(int id){
       if(getItemById(id)!=null){
       items.remove(getItemById(id));
       }
       }
   public double getTotalmoney(){
   double t =0;
   for(Item i:items)
       t+=i.getQuantity()*i.getPrice();
   return t;
   }
//   private Product getProductbyID(int id, List<Product> list){
//   for(Product i:list){
//   if(i.getId()==id)
//       return i;
//       }
//   return null;
//   }
//   public Cart(String txt,List<Product> list){
//   items  =new ArrayList<>();
//       try {
//            if(txt!=null && txt.length()!=0){
//   String[] s =txt.split(",");
//      for(String i:s){
//   String[] n = i.split(":");
//   int id = Integer.parseInt(n[0]);
//   int quantity=Integer.parseInt(n[1]);
//  Product p= getProductbyID(id, list);
//  item t =new item(p, 0, p.getPrice()*2);
//          addItem(t);
//   }
//   }
//       } catch (Exception e) {
//       }
//  
//   
//   }


}
