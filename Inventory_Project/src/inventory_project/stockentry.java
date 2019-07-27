/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory_project;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Acer
 */
public class stockentry extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t3,t4,t5;
    JComboBox c;
    JButton b1,b2,b3,b4,b5;
   

    public stockentry()
    {
        setLayout(null);
        setTitle("Stock Entry");
        l1=new JLabel("Enter The Stock Details");
        l1.setBounds(400,100,600,60);
        Font f=new Font("aprajita",Font.ITALIC,50);
        l1.setForeground(Color.red);
        l1.setFont(f);

        l2=new JLabel("Item Code");
        l2.setBounds(450,200,150,40);
        l2.setForeground(Color.black);
        Font f1=new Font("chiller",Font.BOLD|Font.ITALIC,30);
        l2.setFont(f1);
        c=new JComboBox();
         c.setBounds(680,200,150,30);

        l3=new JLabel("Item Name");
         Font f2=new Font("chiller",Font.BOLD|Font.ITALIC,30);
         l3.setFont(f2);
         l3.setBounds(450,280,150,40);
         t3=new JTextField();
         t3.setBounds(680,280,150,30);

         l4=new JLabel("Rate per Kilo");
          Font f3=new Font("chiller",Font.BOLD|Font.ITALIC,30);
        l4.setFont(f3);
        l4.setBounds(450,350,200,40);
        t4=new JTextField();
        t4.setBounds(680,350,150,30);

        l5=new JLabel("Quantity on Hand");
         Font f4=new Font("chiller",Font.BOLD|Font.ITALIC,30);
         l5.setFont(f4);
         l5.setBounds(450,420,200,40);
         t5=new JTextField();
         t5.setBounds(680,430,150,30);
         t5.addActionListener(this);

         b1=new JButton("Insert");
         Font f5=new Font("Courier New",Font.BOLD,18);
         b1.setFont(f5);
         b1.setForeground(Color.red);
         b1.setBackground(Color.yellow);
         b1.setBounds(380,520,100,50);
         b1.addActionListener(this);

         b2=new JButton("Update Items");
         Font f6=new Font("courier new",Font.BOLD,18);
         b2.setFont(f6);
         b2.setBackground(Color.yellow);
         b2.setForeground(Color.red);
         b2.setBounds(500,520,200,50);
         b2.addActionListener(this);

         b3=new JButton("Clear All");
         Font f7=new Font("courier new",Font.BOLD,18);
         b3.setForeground(Color.red);
         b3.setBackground(Color.yellow);
         b3.setFont(f7);
         b3.setBounds(720,520,150,50);
         b3.addActionListener(this);

         b4=new JButton("Exit");
         Font f8=new Font("courier new",Font.BOLD,18);
         b4.setForeground(Color.yellow);
         b4.setBackground(Color.red);
         b4.setFont(f8);
         b4.setBounds(890,520,100,50);
         b4.addActionListener(this);

         b5=new JButton("Back To Login");
         Font f9=new Font("courier new",Font.BOLD,18);
         b5.setFont(f9);
         b5.setForeground(Color.red);
         b5.setBackground(Color.yellow);
         b5.setBounds(535,600,300,50);
         b5.addActionListener(this);

       


         
        add(l1);
        add(l2);
        add(c);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(l5);
        add(t5);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
       
        
    }




public void actionPerformed(ActionEvent e)
{
     if(e.getSource()==b1)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost/inventorydb","root","123");
        }

        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,ex);
        }
    }

      if(e.getSource()==b2)
    {

    }

      if(e.getSource()==b3)
    {
 
    }

    if(e.getSource()==b4)
    {
      System.exit(0);
    }

    if(e.getSource()==b5)
    {
        login o=new login();
		o.setSize(1366,770);
		o.setVisible(true);
        dispose();
    }

}




public static void main(String args[])
{
    stockentry stock=new stockentry();
    stock.setSize(1366,768);
    stock.setVisible(true);
    stock.setDefaultCloseOperation(EXIT_ON_CLOSE);
}


}


