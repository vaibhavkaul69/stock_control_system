/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory_project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


/**
 *
 * @author Acer
 */
public class issueitem extends JFrame implements ActionListener,ItemListener
{
    JButton  b1,b2,b3,b4;
    JFileChooser file;
        JTextField t1,t2,t3,t4;
        JComboBox cb;
        JSeparator js;
        ImageIcon image;
        JLabel l1,l2,l3,l4,l5,l6,l7;


    public issueitem()
    {
       setTitle("Issue Item");
       setLayout(null);

       l1=new JLabel("Insert New Item");
       l1.setFont(new Font("baskerville old face",1,70));
       l1.setForeground(Color.green);
       l1.setBounds(200,10,700,150);

       js=new JSeparator();
       js.setBounds(350,140,200,50);
       

       l2=new JLabel("Item Code :");
       l2.setForeground(Color.white);
       l2.setFont(new Font("system-ui",Font.BOLD|Font.ITALIC,23));
       l2.setBounds(280,180,150,30);

       cb=new JComboBox();
       cb.setBounds(450,180,170,30);

       image=new ImageIcon("D:\\javawork\\PROJECT\\stock_control_system\\Inventory_Project\\src\\inventory_project\\photo1.jpg");
       l3=new JLabel(image);
       l3.setBounds(0,0,1366,768);

       l4=new JLabel("Item Name :");
       l4.setForeground(Color.white);
       l4.setFont(new Font("system-ui",Font.BOLD|Font.ITALIC,23));
       l4.setBounds(280,250,150,30);

       t1=new JTextField();
       t1.setBounds(450,250,170,30);




       

      


       add(l1);
       add(js);
       add(l2);
       add(cb);
       add(l4);
       add(l3);
       add(t1);
       
       
              


    }
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String args[])
    {
        issueitem item=new issueitem();
        item.setSize(1366,768);
        item.setVisible(true);
    }


}
