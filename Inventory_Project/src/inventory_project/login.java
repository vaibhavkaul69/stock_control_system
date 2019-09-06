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
		JLabel l1,l2,l3,l4,lf;
		JButton b1,b2;
		JTextField t1;
        JCheckBox cb;
		JPasswordField p1;
        ImageIcon i;
        JMenuBar mbr;
        JMenu menu;
        JMenuItem item1,item2,item3,item4,item5,item6;
		


	public login()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Login Screen");
		setLayout(null);
        l3=new JLabel("Login Here");

		l3.setFont(new Font("Baskerville Old Face", 1, 80));
		
        l3.setForeground(Color.green);
        l3.setBounds(450,140,600,100);

		l1=new JLabel("Username :");
        l1.setForeground(Color.white);
		l1.setBounds(470,240,150,40);
		t1=new JTextField(20);
		t1.setBounds(650,240,150,30);
         Font f2=new Font(" system-ui",Font.BOLD|Font.ITALIC,20);
         l1.setFont(f2);

		l2=new JLabel("Password :");
        l2.setForeground(Color.white);
		l2.setBounds(470,320,150,40);
		p1=new JPasswordField(20);
		p1.setBounds(650,320,150,30);
         Font f3=new Font(" system-ui",Font.BOLD|Font.ITALIC,20);
         l2.setFont(f3);
        p1.addActionListener(this);

        cb=new JCheckBox();
        cb.setBounds(700,360,20,20);
        cb.setBackground(Color.green);
        lf=new JLabel("Forgot Your Password?");
        lf.setBounds(730,345,200,50);
        lf.setForeground(Color.white);
        Font f=new Font("cursive",Font.ITALIC,15);
        lf.setFont(f);
        cb.addItemListener(this);

		b1=new JButton("Login");
		b1.setBounds(480,420,100,50);
         Font f4=new Font("Baskerville Old Face",Font.BOLD,18);
         b1.setFont(f4);
         b1.setBackground(Color.green);
         b1.setForeground(Color.black);
		b1.addActionListener(this);

		b2=new JButton("Create Account");
		b2.setBounds(630,420,200,50);
         Font f5=new Font("Baskerville Old Face",Font.BOLD,18);
         b2.setFont(f5);
         b2.setBackground(Color.green);
         b2.setForeground(Color.black);
		b2.addActionListener(this);

         
        i=new ImageIcon("D:\\javawork\\PROJECT\\stock_control_system\\Inventory_Project\\src\\inventory_project\\image4.jpg");

                /*l6.setIcon(new ImageIcon("D:\\javawork\\PROJECT\\stock_control_system\\Inventory_Project\\src\\inventory_project\\background.jpg")); // NOI18N

   */
                l4=new JLabel(i);
       
       l4.setBounds(0, -20, 1366, 768);
       
        
		add(l3);
		add(l1);
		add(t1);
		add(l2);
		add(p1);
        add(cb);
        add(lf);
		add(b1);
		add(b2);
        add(l4);
        

       
        
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
                        JOptionPane.showMessageDialog(null,"User not found - Try Again");
                        t1.setText("");
                        t1.requestFocus();
                        p1.setText("");
                       
                    }
                    else
                    {
                        
                         stockentry stock=new stockentry();
                         stock.setSize(1366,768);
                         stock.setVisible(true);
                         stock.setDefaultCloseOperation(EXIT_ON_CLOSE);
                        dispose();
                     
                        
                       
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
