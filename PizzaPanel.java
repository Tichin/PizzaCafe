/* 
 *  PizzaPanel.java
 * 
 *  take the pizza order and calculate the money for the pizza
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
// import java.util.ArrayList;


public class PizzaPanel extends JPanel
{
   
   private JComboBox<String> pizzaNumberLC,pizzaNumberLN,pizzaNumberLH,pizzaNumberMC;//combo box to select pizza numbers.
   private JComboBox<String> pizzaNumberMN,pizzaNumberMH,pizzaNumberSC,pizzaNumberSN,pizzaNumberSH;//LN=>large New York and so on.
   private JCheckBox pizzaTypeLC,pizzaTypeLN,pizzaTypeLH,pizzaTypeMC;// set the  pizza type including the sizes.
   private JCheckBox pizzaTypeMN,pizzaTypeMH,pizzaTypeSC,pizzaTypeSN,pizzaTypeSH;// set the  pizza type including the sizes.
   private String[]number={"0","1","2","3","4","5","6","7","8","9","10"};//the number(s) of pizza
   private JPanel subPanel1,subPanel2;// subPanel1 displays the types of pizza. 
                                      // subPanel2 dusplays the order.
   private JPanel sub0,sub1,sub2,sub3,sub4,sub5,sub6;//used to hold combo boxes or check boxes in subPanel1.
   private JPanel sub7,sub8,sub9,sub10,sub11,sub12; //used to hold combo boxes or check boxes in subPanel1.
 
   private JPanel subOne,subTwo;//used in subPanel2.
   private JLabel pizzaSizeAndPriceL,pizzaSizeAndPriceM,pizzaSizeAndPriceS; //information for size and price
   private JLabel youOrdered,itemSelected,done;//display order
   private int numLC,numLN,numLH,numMC,numMN,numMH,numSC,numSN,numSH;//number of pizza ordered
   private JLabel itemLC,itemLN,itemLH,itemMC,itemMN,itemMH,itemSC,itemSN,itemSH;
   private JLabel instruction;
   private int sum;// total price of the pizzas.
   // private JButton finish;//push when order finished
   private final int LARGE_PIZZA_PRICE=10,MEDIUM_PIZZA_PRICE=8,SMALL_PIZZA_PRICE=6;
  
   public PizzaPanel()
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
       sub7= new JPanel(new FlowLayout(FlowLayout.LEFT));
       sub8= new JPanel(new FlowLayout(FlowLayout.LEFT));
       sub9= new JPanel(new FlowLayout(FlowLayout.LEFT));
       sub10= new JPanel(new FlowLayout(FlowLayout.LEFT));
       sub11= new JPanel(new FlowLayout(FlowLayout.LEFT));
       sub12= new JPanel(new FlowLayout(FlowLayout.LEFT));
       
       subPanel1.add(sub0);
       subPanel1.add(sub1);
       subPanel1.add(sub2);
       subPanel1.add(sub3);
       subPanel1.add(sub4);
       subPanel1.add(sub5);
       subPanel1.add(sub6);
       subPanel1.add(sub7);
       subPanel1.add(sub8);
       subPanel1.add(sub9);
       subPanel1.add(sub10);
       subPanel1.add(sub11);
       subPanel1.add(sub12);
       
       //*********************************************************************
       // contents of subPanel1.
       //*********************************************************************       
       
       // instruction.Before the first line of subPanel1.
       instruction=new JLabel("Select numbers first then check the box.");
       sub0.add(instruction);
       
       //The first line of subPanel1-sub1.
       //Information of large pizza's size and price.
       pizzaSizeAndPriceL=new JLabel("Large Pizza 12\" $10");  
       sub1.add(pizzaSizeAndPriceL);
       
       //The 2nd line of subPanel1-sub2
       //Add listeners to choose pizza and number(s) of large California pizza.
       pizzaTypeLC=new JCheckBox("Large California");
       pizzaNumberLC=new JComboBox<>(number);
       
       pizzaTypeLC.addItemListener(new CheckBoxListener());
       pizzaNumberLC.addActionListener(new ComboBoxListener());

       sub2.add(pizzaTypeLC);
       sub2.add(pizzaNumberLC);
       
       //The 3rd line of subPanel1-sub3.
       //Add listeners to choose pizza and number(s) of large New York pizza.
       pizzaTypeLN=new JCheckBox("Large New York");
       pizzaNumberLN=new JComboBox<>(number);
       
       pizzaTypeLN.addItemListener(new CheckBoxListener());
       pizzaNumberLN.addActionListener(new ComboBoxListener());

       sub3.add(pizzaTypeLN);
       sub3.add(pizzaNumberLN);
              
       //The 4th line of subPanel1-sub4.
       //Add listeners to choose pizza and number(s) of large Hawaiian pizza.
       pizzaTypeLH=new JCheckBox("Large Hawaiian");
       pizzaNumberLH=new JComboBox<>(number);
       
       pizzaTypeLH.addItemListener(new CheckBoxListener());
       pizzaNumberLH.addActionListener(new ComboBoxListener());

       sub4.add(pizzaTypeLH);
       sub4.add(pizzaNumberLH);
                   
       //The 5th line of subPanel1-sub5.
       //Information of medium pizza's size and price.
       pizzaSizeAndPriceM=new JLabel("Medium Pizza 10\" $8");  
       sub5.add(pizzaSizeAndPriceM);
             
       //The 6th line of subPanel1-sub6.
       //Add listeners to choose pizza and number(s) of medium California pizza.
       pizzaTypeMC=new JCheckBox("Medium California");
       pizzaNumberMC=new JComboBox<>(number);
       
       pizzaTypeMC.addItemListener(new CheckBoxListener());
       pizzaNumberMC.addActionListener(new ComboBoxListener());

       sub6.add(pizzaTypeMC);
       sub6.add(pizzaNumberMC);
             
       //The 7th line of subPanel1-sub7.
       //Add listeners to choose pizza and number(s) of medium New York pizza.
       pizzaTypeMN=new JCheckBox("Medium New York");
       pizzaNumberMN=new JComboBox<>(number);
       
       pizzaTypeMN.addItemListener(new CheckBoxListener());
       pizzaNumberMN.addActionListener(new ComboBoxListener());

       sub7.add(pizzaTypeMN);
       sub7.add(pizzaNumberMN);
            
       //The 8th line of subPanel1-sub8.
       //Add listeners to choose pizza and number(s) of medium Hawaiian pizza.
       pizzaTypeMH=new JCheckBox("Medium Hawaiian");
       pizzaNumberMH=new JComboBox<>(number);
       
       pizzaTypeMH.addItemListener(new CheckBoxListener());
       pizzaNumberMH.addActionListener(new ComboBoxListener());

       sub8.add(pizzaTypeMH);
       sub8.add(pizzaNumberMH);
             
       //The 9th line of subPanel1-sub9.
       //Information of small pizza's size and price.
       pizzaSizeAndPriceS=new JLabel("Small Pizza 8\" $6");  
       sub9.add(pizzaSizeAndPriceS);
       
       //The 10th line of subPanel1-sub10.
       //Add listeners to choose pizza and number(s) of small California pizza.
       pizzaTypeSC=new JCheckBox("Small California");
       pizzaNumberSC=new JComboBox<>(number);
       
       pizzaTypeSC.addItemListener(new CheckBoxListener());
       pizzaNumberSC.addActionListener(new ComboBoxListener());

       sub10.add(pizzaTypeSC);
       sub10.add(pizzaNumberSC);
             
       //The 11th line of subPanel1-sub11.
       //Add listeners to choose pizza and number(s) of small New York pizza.
       pizzaTypeSN=new JCheckBox("Small New York");
       pizzaNumberSN=new JComboBox<>(number);
       
       pizzaTypeSN.addItemListener(new CheckBoxListener());
       pizzaNumberSN.addActionListener(new ComboBoxListener());

       sub11.add(pizzaTypeSN);
       sub11.add(pizzaNumberSN);
             
       //The 12th line of subPanel1-sub12.
       //Add listeners to choose pizza and number(s) of small Hawaiian pizza.
       pizzaTypeSH=new JCheckBox("Small Hawaiian");
       pizzaNumberSH=new JComboBox<>(number);
       
       pizzaTypeSH.addItemListener(new CheckBoxListener());
       pizzaNumberSH.addActionListener(new ComboBoxListener());
       
       sub12.add(pizzaTypeSH);
       sub12.add(pizzaNumberSH);
          
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
       // itemSelected label in subTwo displays "Nothing yet!" before any pizza is chozen,
       // then display " " after pizza is chozen.
                              
       youOrdered=new JLabel("You ordered:");
       itemSelected=new JLabel("Nothing yet! ");
              
       subOne.add(youOrdered);
       subTwo.add(itemSelected);
             
       // items here are used for display information of how many pizzas are ordered 
       // of each kind of pizza.Before order it's blank.
       // For example: itemLC means the first type of large pizza-large California.
       // For example: itemMN means the second type of medium pizza-medium New York.
       itemLC=new JLabel(""); 
       itemLN=new JLabel("");
       itemLH=new JLabel("");
       
       itemMC=new JLabel(""); 
       itemMN=new JLabel("");
       itemMH=new JLabel("");
       
       itemSC=new JLabel(""); 
       itemSN=new JLabel("");
       itemSH=new JLabel("");
       
       subTwo.add(itemLC);
       subTwo.add(itemLN);
       subTwo.add(itemLH);
       subTwo.add(itemMC);
       subTwo.add(itemMN);
       subTwo.add(itemMH);
       subTwo.add(itemSC);
       subTwo.add(itemSN);
       subTwo.add(itemSH);
       
       //done label in subTwo displays the money after finish the order.
       done=new JLabel("");
       subTwo.add(done); 
 
       //push finish button to claculate the total price of the pizza(s). 
       JButton finish=new JButton("finish");
       finish.addActionListener(new ButtonListener());
       subTwo.add(finish);        
   }
 
   // get the numbers of pizza(s) selected.
   public class ComboBoxListener implements ActionListener
   {
       public void actionPerformed(ActionEvent e)
       {       
           String selectionLC=(String)pizzaNumberLC.getSelectedItem();
           String selectionLN=(String)pizzaNumberLN.getSelectedItem();
           String selectionLH=(String)pizzaNumberLH.getSelectedItem();
          
           String selectionMC=(String)pizzaNumberMC.getSelectedItem();
           String selectionMN=(String)pizzaNumberMN.getSelectedItem();
           String selectionMH=(String)pizzaNumberMH.getSelectedItem();
          
           String selectionSC=(String)pizzaNumberSC.getSelectedItem();
           String selectionSN=(String)pizzaNumberSN.getSelectedItem();
           String selectionSH=(String)pizzaNumberSH.getSelectedItem();

           numLC=Integer.parseInt(selectionLC);
           numLN=Integer.parseInt(selectionLN);
           numLH=Integer.parseInt(selectionLH);

           numMC=Integer.parseInt(selectionMC);
           numMN=Integer.parseInt(selectionMN);
           numMH=Integer.parseInt(selectionMH);
          
           numSC=Integer.parseInt(selectionSC);
           numSN=Integer.parseInt(selectionSN);
           numSH=Integer.parseInt(selectionSH);
             
           // numbers*price 
           sum=((numLC+numLN+numLH)*LARGE_PIZZA_PRICE+(numMC+numMN+numMH)*MEDIUM_PIZZA_PRICE+
               (numSC+numSN+numSH)*SMALL_PIZZA_PRICE);                   
        }
    }
       
    // push the finish bottun to display the price.          
    private class ButtonListener implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
       {     
           done.setText("The total price of pizzas is: "+(Integer.toString(sum)));
           youOrdered.setText("");
       }
    }     
       
    // Get the values of check box.
    // If it is not 0,get the number of the pizza and display it. 
    private class CheckBoxListener implements ItemListener
    {
        public void itemStateChanged(ItemEvent e)
        {
            if((pizzaTypeLC.isSelected())&&numLC!=0)
            {
               itemSelected.setText("");
               itemLC.setText(""+numLC+" large California Pizzas");
               
            }
            
            if((pizzaTypeLN.isSelected())&&numLN!=0)
            {
               itemSelected.setText("");
               itemLN.setText(""+numLN+" large New York Pizzas");
            }
            
            if((pizzaTypeLH.isSelected())&&numLH!=0)
            {
              
               itemSelected.setText("");
               itemLH.setText(""+numLH+" large Hawaiian Pizzas");
            }
            
            if((pizzaTypeMC.isSelected())&&numMC!=0)
            {
               itemSelected.setText("");
               itemMC.setText(""+numMC+" medium California Pizzas");
            }
            
            if((pizzaTypeMN.isSelected())&&numMN!=0)
            {
               itemSelected.setText("");
               itemMN.setText(""+numMN+" medium New York Pizzas");
            }
           
            
            if((pizzaTypeMH.isSelected())&&numMH!=0)
            {
              
               itemSelected.setText("");
               itemMH.setText(""+numMH+" medium Hawaiian Pizzas");
            }
 
            if((pizzaTypeSC.isSelected())&&numSC!=0)
            {
               itemSelected.setText("");
               itemSC.setText(""+numSC+" small California Pizzas");
            }
            
            if((pizzaTypeSN.isSelected())&&numSN!=0)
            {
               itemSelected.setText("");
               itemSN.setText(""+numMN+" small New York Pizzas");
            }
            
            if((pizzaTypeSH.isSelected())&&numSH!=0)
            {
              
               itemSelected.setText("");
               itemSH.setText(""+numSH+" small Hawaiian Pizzas");
            }           
         }
     } 
}  