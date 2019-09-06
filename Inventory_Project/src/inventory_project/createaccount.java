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
		JLabel l1,l2,l3,l5,l4,l6;
		JButton b1,b2;
		JTextField t1,t3;
        ImageIcon i;
		JPasswordField p1;
        JSeparator js;


	public createaccount()
	{
		setTitle("Create An Account");
		setLayout(null);

         l4=new JLabel("Hello User");
        l4.setBounds(400,100,500,100);
        Font f=new Font("baskerville old face",1,80);
        l4.setFont(f);
        l4.setForeground(Color.green);

        l5=new JLabel("Sign Up Here");
        l5.setForeground(Color.yellow);
        l5.setFont(new Font("Baskerville Old Face", 1, 40));
        l5.setBounds(470,180,400,100);


		l1=new JLabel("Username :");
		l1.setBounds(410,280,150,50);
        l1.setForeground(Color.white);
        l1.setFont(new Font("cursive",Font.BOLD|Font.ITALIC,20));
		t1=new JTextField(20);
		t1.setBounds(600,290,150,30);

		l2=new JLabel("Password :");
		l2.setBounds(410,350,150,50);
        l2.setFont(new Font("cursive",Font.BOLD|Font.ITALIC,20));
        l2.setForeground(Color.white);
        p1=new JPasswordField(20);
        p1.setBounds(600,360,150,30);
		
       

        l3=new JLabel("Email Address :");
        l3.setBounds(410,420,200,50);
        l3.setForeground(Color.white);
        l3.setFont(new Font("cursive",Font.BOLD|Font.ITALIC,20));
        t3=new JTextField(20);
        t3.setBounds(600,430,150,30);
        t3.addActionListener(this);

		
		b1=new JButton("Back to Login");
		b1.setBounds(400,520,150,50);
        b1.setBackground(Color.green);
        b1.setFont(new Font("Baskerville Old Face",Font.BOLD,18));
		b1.addActionListener(this);

		b2=new JButton("Create Account");
        b2.setBackground(Color.green);
		b2.setBounds(600,520,180,50);
         b2.setFont(new Font("Baskerville Old Face",Font.BOLD,18));
		b2.addActionListener(this);

        js=new JSeparator();
        js.setOrientation(JSeparator.VERTICAL);
        js.setBounds(570,530,2,25);




       

        i=new ImageIcon("D:\\javawork\\PROJECT\\stock_control_system\\Inventory_Project\\src\\inventory_project\\createaccountback.jpg");
        l6=new JLabel(i);
        l6.setBounds(0,0,1366,768);

        add(l4);
        add(l5);
        add(l1);
        add(t1);
        add(l2);
        add(p1);
        add(l3);
        add(t3);
        add(b1);
        add(b2);
        add(js);
        add(l6);
        
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
                if(t1.getText().equals("")&&p1.getText().equals("")&&t3.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please enter all the values");
                }
                else
                {
				try
				 {

					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/inventorydb","root","123");
					Statement stmt=con.createStatement();
					String query="select * from user where username='"+t1.getText()+"' and password='"+p1.getText()+"' and email='"+t3.getText()+"'";
					ResultSet rs=stmt.executeQuery(query);
                    int count=0;
                    while(rs.next())
                    {
                        count++;
                    }
           
                    if(count==0 )
                    {
                        String query1="insert into user (username,password,email) values('"+t1.getText()+"','"+p1.getText()+"','"+t3.getText()+"')";
                        int x=stmt.executeUpdate(query1);
                         t1.setText("");
                    p1.setText("");
                    t3.setText("");
                    t1.requestFocus();
                        JOptionPane.showMessageDialog(null,"User Created Succesfully");
                    }
                    else
                    {
                       
                        JOptionPane.showMessageDialog(null,"User already exists");
                        t1.setText("");
                    p1.setText("");
                    t3.setText("");
                    t1.requestFocus();
                       

                    }
					
					con.close();
				}

				catch (Exception e)
				 {
					JOptionPane.showMessageDialog(null,"Exception :"+e);//TODO: handle exception
                    
				}
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

