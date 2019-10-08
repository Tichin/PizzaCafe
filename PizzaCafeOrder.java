/*   PizzaCafeOrder.java
 * 
 *   Use a tabbed pane to take order 
 *   for different categories of food (pizza, beverages, special items). 
 *   Collect info about quantity and size.  
 *   Display the cost of the order as info is gathered. 
 *   
 *   @author    TICHIN WU
 *   @version   1.8.0
 */


import javax.swing.*;

public class  PizzaCafeOrder
{
   public static void main(String[] args)
   {
   
       JFrame frame= new JFrame("Pizza Café Order");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       JTabbedPane tp = new JTabbedPane();
       
       tp.addTab("pizza",new PizzaPanel());
       tp.addTab("Beverages",new BeveragePanel());
       tp.addTab("Special items",new SpecialItemPanel());
       tp.addTab("Price",new PricePanel());
             
       frame.getContentPane().add(tp);
       frame.pack();
       frame.setVisible(true);  
       
           
   } 

}