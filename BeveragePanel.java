/* 
 *  BeveragePanel.java
 * 
 *  take the beverage order and calculate the money for the beverages 
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BeveragePanel extends JPanel
{
   
   private JComboBox<String> number1,number2,number3;//combo box to select drink numbers.
   private JComboBox<String> number4,number5,number6;//combo box to select drink numbers.
   private JCheckBox type1,type2,type3,type4,type5,type6;// set the type

   private String[]number={"0","1","2","3","4","5","6","7","8","9","10"};//the number(s) of beverage
   private JPanel subPanel1,subPanel2;// subPanel1 displays the types of beverages. 
                                      // subPanel2 dusplays the order.
   private JPanel sub0,sub1,sub2,sub3,sub4,sub5,sub6;//used for combo boxes or check boxes in subPanel1.
   private JPanel subOne,subTwo;//used in subPanel2.
   private JLabel price1,price2,price3,price4,price5,price6; //information of the price
   private JLabel youOrdered,itemSelected,done;//display order
   private int num1,num2,num3,num4,num5,num6,sum;
   private JLabel item1,item2,item3,item4,item5,item6;
   private JLabel instruction;
   private JButton finish;//push when order finished
   private final int FOUNTAIN_PRICE=2,BOTTLE_PRICE=2,BEER_PRICE=3,TEA_PRICE=2;
   private final int COFFEE_PRICE=2,CHOCOLATE_PRICE=2;
   
   public BeveragePanel()
   {
              
       // subPanel1 is used to take the customs order. 
       // subPanel2 us ueed to display the order and the money.
       subPanel1=new JPanel();
       subPanel2=new JPanel();
       add(subPanel1);
       add(subPanel2);

       // subPanel will have panels.Each one would have lables,combobox,or checkbox
       subPanel1.setLayout(new BoxLayout(subPanel1,BoxLayout.Y_AXIS));
       
       sub0= new JPanel(new FlowLayout(FlowLayout.LEFT));
       sub1= new JPanel(new FlowLayout(FlowLayout.LEFT));
       sub2= new JPanel(new FlowLayout(FlowLayout.LEFT));
       sub3= new JPanel(new FlowLayout(FlowLayout.LEFT));
       sub4= new JPanel(new FlowLayout(FlowLayout.LEFT));
       sub5= new JPanel(new FlowLayout(FlowLayout.LEFT));
       sub6= new JPanel(new FlowLayout(FlowLayout.LEFT));
       
       subPanel1.add(sub0);
       subPanel1.add(sub1);
       subPanel1.add(sub2);
       subPanel1.add(sub3);
       subPanel1.add(sub4);
       subPanel1.add(sub5);
       subPanel1.add(sub6);
              
       //*********************************************************************
       // contents of subPanel1.
       //*********************************************************************       
       
       // instruction.Before the first line of subPanel1.
       instruction=new JLabel("Select numbers first then check the box.");
       sub0.add(instruction);
       
       //The first line of subPanel1-sub1.
       //fountain beverages
       type1=new JCheckBox("Fountain Beverages");
       price1=new JLabel("$2");
       number1=new JComboBox<>(number);
       
       sub1.add(type1);
       sub1.add(price1);
       sub1.add(number1);
       
       type1.addItemListener(new CheckBoxListener());
       number1.addActionListener(new ComboBoxListener());

       //The 2nd line of subPanel1-sub2
       //bottled beverages
       
       type2=new JCheckBox("Bottled Beverages");
       price2=new JLabel("$2");
       number2=new JComboBox<>(number);
       
       sub2.add(type2);
       sub2.add(price2);
       sub2.add(number2);
       
       type2.addItemListener(new CheckBoxListener());
       number2.addActionListener(new ComboBoxListener());
                  
       //The 3rd line of subPanel1-sub3.
       //Craft beer 
       
       type3=new JCheckBox("Craft Beer ");
       price3=new JLabel("$3");
       number3=new JComboBox<>(number);
       
       sub3.add(type3);
       sub3.add(price3);
       sub3.add(number3);
       
       type3.addItemListener(new CheckBoxListener());
       number3.addActionListener(new ComboBoxListener());
                                
       //The 4th line of subPanel1-sub4.
       //Iced Tea       
       type4=new JCheckBox("Iced Tea ");
       price4=new JLabel("$2");
       number4=new JComboBox<>(number);
       
       sub4.add(type4);
       sub4.add(price4);
       sub4.add(number4);
       
       type4.addItemListener(new CheckBoxListener());
       number4.addActionListener(new ComboBoxListener());
                  
       //The 5th line of subPanel1-sub5.
       //Iced Coffee       
       type5=new JCheckBox("Iced Coffee ");
       price5=new JLabel("$2");
       number5=new JComboBox<>(number);
       
       sub5.add(type5);
       sub5.add(price5);
       sub5.add(number5);
       
       type5.addItemListener(new CheckBoxListener());
       number5.addActionListener(new ComboBoxListener());
       //The 6th line of subPanel1-sub6.
       //Hot Chocolate       
       type6=new JCheckBox("Hot Chocolate");
       price6=new JLabel("$2");
       number6=new JComboBox<>(number);
       
       sub6.add(type6);
       sub6.add(price6);
       sub6.add(number6);
       
       type6.addItemListener(new CheckBoxListener());
       number6.addActionListener(new ComboBoxListener());
                                            
       //*********************************************************************
       // contents of subPanel2
       //**********************************************************************
       
       // subPanel2 will have 2 panels in it: subOne and subTwo
       subOne=new JPanel();
       subTwo=new JPanel();
       subTwo.setLayout(new BoxLayout(subTwo,BoxLayout.Y_AXIS));
     
       subPanel2.add(subOne); 
       subPanel2.add(subTwo); 
       
       // youOdered label in subOne displays "You ordered:"
       // itemSelected label in subTwo displays "Nothing yet!" before any beverage is chozen,
       // then display " " after beverage is chozen.                      
       youOrdered=new JLabel("You ordered:");
       itemSelected=new JLabel("Nothing yet! ");
              
       subOne.add(youOrdered);
       subTwo.add(itemSelected);
             
       // items here are used for display information of how many drinks are ordered 
       // of each kind of drink.Before order it's blank.        
       item1=new JLabel(""); 
       item2=new JLabel("");
       item3=new JLabel("");
       item4=new JLabel(""); 
       item5=new JLabel("");
       item6=new JLabel("");
       
       subTwo.add(item1);
       subTwo.add(item2);
       subTwo.add(item3);
       subTwo.add(item4);
       subTwo.add(item5);
       subTwo.add(item6);
              
       //done label in subTwo displays the money after finish the order.
       done=new JLabel("");
       subTwo.add(done); 
 
       //push finish button to claculate the total price of the pizza(s). 
       JButton finish=new JButton("finish");
       finish.addActionListener(new ButtonListener());
       subTwo.add(finish);        
    }
 
    //get the number(s) of beverage(s) selected.
    public class ComboBoxListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {       
            String selection1=(String)number1.getSelectedItem();
            String selection2=(String)number2.getSelectedItem();
            String selection3=(String)number3.getSelectedItem();
            String selection4=(String)number4.getSelectedItem();
            String selection5=(String)number5.getSelectedItem();
            String selection6=(String)number6.getSelectedItem();
           
            num1=Integer.parseInt(selection1);
            num2=Integer.parseInt(selection2);
            num3=Integer.parseInt(selection3);
            num4=Integer.parseInt(selection4);
            num5=Integer.parseInt(selection5);
            num6=Integer.parseInt(selection6);
                       
            // numbers*price 
            sum=((num1*FOUNTAIN_PRICE)+(num2*BOTTLE_PRICE)+(num3*BEER_PRICE)+
                (num4*TEA_PRICE)+(num5*COFFEE_PRICE)+(num6*CHOCOLATE_PRICE));
               
          }
     }
       
     // push the finish bottun to display the price.          
     private class ButtonListener implements ActionListener
     {
        public void actionPerformed(ActionEvent e)
        {     
            done.setText("The total price of beverages is: "+(Integer.toString(sum)));
            youOrdered.setText("");
        }
     }     
       
     // Get the values of check box.
     // If it is not 0,get the number of the beverages and display it. 
     private class CheckBoxListener implements ItemListener
     {
        public void itemStateChanged(ItemEvent e)
        {
            if((type1.isSelected())&&num1!=0)
            {
               itemSelected.setText("");
               item1.setText(""+num1+" Fountain Beverages");
               
            }
            
            if((type2.isSelected())&&num2!=0)
            {
               itemSelected.setText("");
               item2.setText(""+num2+" Bottled Beverages");
            }
            
            if((type3.isSelected())&&num3!=0)
            {
              
               itemSelected.setText("");
               item3.setText(""+num3+" Craft Beer");
            }
            
            if((type4.isSelected())&&num4!=0)
            {
               itemSelected.setText("");
               item4.setText(""+num4+" Iced Tea");
            }
            
            if((type5.isSelected())&&num5!=0)
            {
               itemSelected.setText("");
               item5.setText(""+num5+" Iced Coffee");
            }
           
            
            if((type6.isSelected())&&num6!=0)
            {
              
               itemSelected.setText("");
               item6.setText(""+num6+" Chocolate Drink");
            }
         }
      } 
}  