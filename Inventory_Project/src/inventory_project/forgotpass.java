package inventory_project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class forgotpass extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4;
    JTextField t;
    JPasswordField p;
    JButton b1,b2;

    public forgotpass()
    {
        setTitle("Change Password");
                setLayout(null);
        l1=new JLabel("Forgot Your Password?");
        l1.setForeground(Color.red);
        l1.setBounds(450,100,450,60);
       Font f=new Font("aprajita",Font.BOLD|Font.ITALIC,40);
       l1.setFont(f);

        l2=new JLabel("To reset your password enter the Phone Number associated with your account.");
        Font f1=new Font(" system-ui",Font.ITALIC,18);
       l2.setFont(f1);
        l2.setBounds(360,180,650,50);

        l3=new JLabel("Phone Number :");
        Font f2=new Font("system-ui",Font.ITALIC|Font.BOLD,20);
        l3.setFont(f2);
        l3.setForeground(Color.black);
        l3.setBounds(450,250,200,50);
        t=new JTextField();
        t.setBounds(700,260,150,30);

        l4=new JLabel("New Password :");
        Font f3=new Font("system-ui",Font.BOLD|Font.ITALIC,20);
        l4.setFont(f3);
        l4.setForeground(Color.black);
        l4.setBounds(450,330,200,50);
        p=new JPasswordField();
        p.setBounds(700,340,150,30);
        p.addActionListener(this);

        b1=new JButton("Back To Login");
        b1.setForeground(Color.red);
        b1.setBackground(Color.yellow);
        Font f4=new Font("courier new",Font.BOLD,18);
        b1.setFont(f4);
        b1.setBounds(420,420,200,50);
        b1.addActionListener(this);

        b2=new JButton("Change Password");
        b2.setBounds(680,420,200,50);
        b2.setForeground(Color.red);
        b2.setBackground(Color.yellow);
        Font f5=new Font("courier new",Font.BOLD,18);
        b2.setFont(f5);
        b2.addActionListener(this);




       add(l1);
       add(l2);
       add(l3);
       add(l4);
       add(t);
       add(p);
       add(b1);
       add(b2);


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
            String query1="select * from user where phonenum='"+t.getText()+"'";
            ResultSet rs=stmt.executeQuery(query1);
            int count=0;
            while(rs.next())
            {
                count++;
            }

            int ctr=t.getText().length();
            if(ctr<10||count==0)
            {
                JOptionPane.showMessageDialog(null,"The entered phone number is less than 10 digits");
                 t.setText("");
                p.setText("");
                JOptionPane.showMessageDialog(null,"User with entered Phone Number not found");
            }

           
            else
            {
            String query="update user set password='"+p.getText()+"'where phonenum='"+t.getText()+"'";
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
