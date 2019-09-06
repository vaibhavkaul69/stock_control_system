package inventory_project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class forgotpass extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5;
    JTextField t;
    JSeparator js;
    JPasswordField p;
    JButton b1,b2;
    ImageIcon i;

    public forgotpass()
    {
        setTitle("Change Password");
                setLayout(null);
        l1=new JLabel("Forgot Your Password?");
        l1.setForeground(Color.green);
        l1.setBounds(300,100,800,100);
       Font f=new Font("Baskerville Old Face",Font.BOLD,70);
       l1.setFont(f);

       js=new JSeparator();
       js.setBounds(530,210,250,50);


        l2=new JLabel("To reset your password enter the Email Address associated with your account.");
        l2.setForeground(Color.black);
        Font f1=new Font("aprajita",Font.BOLD,20);
       l2.setFont(f1);
        l2.setBounds(290,220,750,50);

        l3=new JLabel("Email Address :");
        Font f2=new Font("system-ui",Font.ITALIC|Font.BOLD,20);
        l3.setFont(f2);
        l3.setForeground(Color.white);
        l3.setBounds(450,300,200,50);
        t=new JTextField();
        t.setBounds(650,310,150,30);

        l4=new JLabel("New Password :");
        Font f3=new Font("system-ui",Font.BOLD|Font.ITALIC,20);
        l4.setFont(f3);
        l4.setForeground(Color.white);
        l4.setBounds(450,380,200,50);
        p=new JPasswordField();
        p.setBounds(650,390,150,30);
        p.addActionListener(this);

        b1=new JButton("Back To Login");
        b1.setForeground(Color.black);
        b1.setBackground(Color.green);
        Font f4=new Font("Baskerville Old Face",Font.BOLD,18);
        b1.setFont(f4);
        b1.setBounds(400,480,200,50);
        b1.addActionListener(this);

        b2=new JButton("Change Password");
        b2.setBounds(650,480,200,50);
        b2.setForeground(Color.black);
        b2.setBackground(Color.green);
        Font f5=new Font("Baskerville Old Face",Font.BOLD,18);
        b2.setFont(f5);
        b2.addActionListener(this);

        i=new ImageIcon("D:\\javawork\\PROJECT\\stock_control_system\\Inventory_Project\\src\\inventory_project\\forgotpass.jpg");
        l5=new JLabel(i);
        l5.setBounds(0,0,1366,768);



       add(l1);
       add(js);
       add(l2);
       add(l3);
       add(l4);
       add(t);
       add(p);
       add(b1);
       add(b2);
       add(l5);


    }
    
 


public void actionPerformed(ActionEvent e)
 {
    if(e.getSource()==b1)
    {
        login o=new login();
		o.setSize(1366,770);
		o.setVisible(true);
        dispose();
    }

    if(e.getSource()==b2||e.getSource()==p)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/inventorydb","root","123");
            Statement stmt=con.createStatement();
            String query1="select * from user where email='"+t.getText()+"'";
            ResultSet rs=stmt.executeQuery(query1);
            int count=0;
            while(rs.next())
            {
                count++;
            }
            
            if(count==0)
            {
                 JOptionPane.showMessageDialog(null,"User with entered Email not found");
                 t.setText("");
                 p.setText("");
            }

           
            else
            {
            String query="update user set password='"+p.getText()+"'where email='"+t.getText()+"'";
            int x=stmt.executeUpdate(query);
             p.setText("");
            t.setText("");
            JOptionPane.showMessageDialog(null,"Password Changed Succesfully");
            }
           
            con.close();
        }

        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
 }


public static void main(String args[])
{
    forgotpass fp=new forgotpass();
    fp.setSize(1366,768);
    fp.setVisible(true);
    fp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
   
}

    
}
