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
public class login extends JFrame implements ActionListener,ItemListener
{
		JLabel l1,l2,l3;
		JButton b1,b2;
		JTextField t1;
        JCheckBox cb;
		JPasswordField p1;
		


	public login()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Login Screen");
		setLayout(null);
        l3=new JLabel("Login Here");
		Font f1=new Font("aprajita",Font.BOLD|Font.ITALIC,50);
		l3.setFont(f1);
        l3.setForeground(Color.red);
        l3.setBounds(500,100,600,60);

		l1=new JLabel("Username :");
		l1.setBounds(470,200,150,40);
		t1=new JTextField(20);
		t1.setBounds(650,200,150,30);
         Font f2=new Font(" system-ui",Font.BOLD|Font.ITALIC,20);
         l1.setFont(f2);

		l2=new JLabel("Password :");
		l2.setBounds(470,280,150,40);
		p1=new JPasswordField(20);
		p1.setBounds(650,280,150,30);
         Font f3=new Font(" system-ui",Font.BOLD|Font.ITALIC,20);
         l2.setFont(f3);
        p1.addActionListener(this);

        cb=new JCheckBox("Forgot Your Password?");
        cb.setBounds(700,320,200,30);
        Font f=new Font("cursive",Font.ITALIC,15);
        cb.setFont(f);
        cb.addItemListener(this);

		b1=new JButton("Login");
		b1.setBounds(480,380,100,50);
         Font f4=new Font("courier new",Font.BOLD,18);
         b1.setFont(f4);
         b1.setBackground(Color.yellow);
         b1.setForeground(Color.red);
		b1.addActionListener(this);

		b2=new JButton("Create Account");
		b2.setBounds(630,380,200,50);
         Font f5=new Font("courier new",Font.BOLD,18);
         b2.setFont(f5);
         b2.setBackground(Color.yellow);
         b2.setForeground(Color.red);
		b2.addActionListener(this);
       
        
		add(l3);
		add(l1);
		add(t1);
		add(l2);
		add(p1);
        add(cb);
		add(b1);
		add(b2);

       
        
	}

    public void itemStateChanged(ItemEvent i)
    {
        if(i.getSource()==cb)
        {
         forgotpass fp=new forgotpass();
    fp.setSize(1366,768);
    fp.setVisible(true);
    fp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    dispose();
        }
    }

	public void actionPerformed(ActionEvent ae)
	{
		String s=ae.getActionCommand();

			if(s.equals("Login")||ae.getSource()==p1)
            {
                try
                {
                   Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/inventorydb","root","123");
					Statement stmt=con.createStatement();
					String query="select * from user where username='"+t1.getText()+"'and password='"+p1.getText()+"'";
					ResultSet rs=stmt.executeQuery(query);
                    int ctr=0;
                    while(rs.next())
                    {
                        ctr++;
                    }
                    if(ctr==0)
                    {
                        JOptionPane.showMessageDialog(null,"User not found !!!-Try Again");
                        t1.setText("");
                        p1.setText("");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Login succesfull");
                      t1.setText("");
                        p1.setText("");
                        
                       
                    }
					con.close();
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e);
                }
			}
			
			if(s.equals("Create Account"))
			{

				createaccount obj=new createaccount();
				obj.setSize(1366,770);
				obj.setVisible(true);
				obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 dispose();
                 
			}



    
}

    public static void main(String args[])
	{
		login o=new login();
		o.setSize(1366,770);
		o.setVisible(true);
	}

   

}
