package inventory_project;

import java.awt.*;
import javax.swing.*;

class splashscreen extends JFrame
{
    

    splashscreen()
    {
        setTitle("Welcome Screen");
        setLayout(null);
        JLabel jLabel2 = new javax.swing.JLabel();
        JLabel jLabel3 = new javax.swing.JLabel();
        JLabel jLabel4 = new javax.swing.JLabel();
        JSeparator jSeparator2 = new javax.swing.JSeparator();
        JSeparator jSeparator1 = new javax.swing.JSeparator();
        JLabel jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Baskerville Old Face", 1, 100)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 0));
        jLabel2.setText("STOCK");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(500, 190, 440, 90);

        jLabel3.setFont(new java.awt.Font("Baskerville Old Face", 1, 80)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("MANAGEMENT");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(390, 300, 660, 80);

        jLabel4.setFont(new java.awt.Font("Baskerville Old Face", 1, 100)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 255, 0));
        jLabel4.setText("SYSTEM");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(470, 400, 460, 100);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(480, 280, 420, 10);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(520, 380, 340, 10);

        JLabel l2 = new JLabel("");
        l2.setIcon(new javax.swing.ImageIcon("D:\\javawork\\PROJECT\\stock_control_system\\Inventory_Project\\src\\inventory_project\\splashscreen.gif")); // NOI18N
       l2.setText("jLabel1");
       l2.setPreferredSize(new java.awt.Dimension(500, 500));
        getContentPane().add(l2);
       l2.setBounds(0, -20, 1366, 768);

       
       
    }
    public static void main(String args[])
    {
        splashscreen m=new splashscreen();
        m.setSize(1366,768);
        m.setVisible(true);
        m.setBackground(Color.cyan);

        try
        {
            Thread.sleep(5000);
            m.dispose();
            login o=new login();
		o.setSize(1366,770);
        o.setBackground(Color.cyan);
		o.setVisible(true);
        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
}


