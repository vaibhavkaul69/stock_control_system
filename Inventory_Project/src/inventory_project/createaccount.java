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
	public class createaccount extends JFrame implements ActionListener
{
		JLabel l1,l2,l3;
		JButton b1,b2;
		JTextField t1,t3;
		JPasswordField p1;


	public createaccount()
	{
		setTitle("Create An Account");
		setLayout(null);
		l1=new JLabel("Username");
		l1.setBounds(100,100,100,50);
		t1=new JTextField(20);
		t1.setBounds(250,100,150,30);
		l2=new JLabel("Password");
		l2.setBounds(100,200,100,50);
		p1=new JPasswordField(20);
        l3=new JLabel("Phone Number");
        l3.setBounds(100,300,100,50);
        t3=new JTextField(20);
        t3.setBounds(250,300,150,30);
        t3.addActionListener(this);
		p1.setBounds(250,200,150,30);
		b1=new JButton("Login");
		b1.setBounds(200,400,100,50);
		b1.addActionListener(this);
		b2=new JButton("Create Account");
		b2.setBounds(350,400,200,50);
		b2.addActionListener(this);
		add(l1);
		add(t1);
		add(l2);
		add(p1);
        add(l3);
        add(t3);
		add(b1);
		add(b2);
	}
	public void actionPerformed(ActionEvent ae)
	{
	

			if(ae.getSource()==b1)
            {
                 login o=new login();
		o.setSize(1366,770);
		o.setVisible(true);
        dispose();
       
            }
				

			if(ae.getSource()==b2 ||  ae.getSource()==t3)
			{
				try
				 {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/inventorydb","root","123");
					Statement stmt=con.createStatement();
					String query="insert into user (username,password,phonenum) values ('"+t1.getText()+"','"+p1.getText()+"','"+t3.getText()+"')";
					int x=stmt.executeUpdate(query);
                    t1.setText("");
                    p1.setText("");
                    t3.setText("");

					JOptionPane.showMessageDialog(null,"User Created");
					con.close();
				}
				catch (Exception e)
				 {
					JOptionPane.showMessageDialog(null,"Exception :"+e);//TODO: handle exception
				}


			}

	}
    /**
     * @param args the command line arguments
     */
   public static void main(String args[])
	{
		createaccount obj=new createaccount();
		obj.setSize(1366,770);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}


}

