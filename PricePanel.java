/* 
 *  PricePanel.java
 * 
 *  input price of each panel and calculate the total price 
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PricePanel extends JPanel
{
   private JPanel sub1,sub2,sub3,sub4,sub5;
   private JLabel pizzaPrice,beveragePrice,specialItemPrice,done;  
   private JTextField totalPizzaPrice,totalBeveragePrice,totalSpecialItemPrice;
   private JButton calculate;
   
   public PricePanel()
   {
       // sub panels to hold lables and textfields
       sub1= new JPanel(new FlowLayout(FlowLayout.LEFT));
       sub2= new JPanel(new FlowLayout(FlowLayout.LEFT));
       sub3= new JPanel(new FlowLayout(FlowLayout.LEFT));
       sub4= new JPanel(new FlowLayout(FlowLayout.LEFT));
       sub5= new JPanel(new FlowLayout(FlowLayout.LEFT));
        
       setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
       add(sub1);
       add(sub2);
       add(sub3);
       add(sub4);
       add(sub5);
       
              
       //**********************************************************************
       //Let user to input the price of the pizza, beverage and special items.
       //********************************************************************** 
       pizzaPrice=new JLabel("Enter the total pizza price");
       totalPizzaPrice=new JTextField(10);   
       sub1.add(pizzaPrice);
       sub1.add(totalPizzaPrice);
             
       beveragePrice=new JLabel("Enter the total beverage price");
       totalBeveragePrice=new JTextField(10); 
       sub2.add(beveragePrice);
       sub2.add(totalBeveragePrice);

       specialItemPrice=new JLabel("Enter the total total special item price");
       totalSpecialItemPrice=new JTextField(10);
       sub3.add(specialItemPrice);
       sub3.add(totalSpecialItemPrice);
 
       // calculate the total price
       calculate=new JButton("Calculate");
       sub4.add(calculate);
       calculate.addActionListener(new ButtonListener());
       
       // show the price after calculate.
       done=new JLabel("");  
       sub5.add(done);         
   } 
   // calculate the price.    
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {   
         String input1,input2,input3;
         int sum;
         
         input1=totalPizzaPrice.getText();
         input2=totalBeveragePrice.getText();
         input3=totalSpecialItemPrice.getText();
         
         sum=(Integer.parseInt(input1))+(Integer.parseInt(input2))+(Integer.parseInt(input3));

         done.setText("The total price is: "+(Integer.toString(sum)));                    
       }        
    }             
}   