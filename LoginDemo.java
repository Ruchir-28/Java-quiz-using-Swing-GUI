import selecttest.SelectTest;
import java.awt.Color;
import javax.swing.*;
import java.util.*;
import java.awt.*;

import java.awt.event.*;

import java.sql.*;

 
public class LoginDemo extends JFrame implements ActionListener
{

     private static final long serialVersionUID = 1L;	
    JLabel l1, l2, l3, l4;

    JTextField tf1,tf2;

    JButton btn1;

    JPasswordField p1;
     

 

   public LoginDemo()
    {

        setTitle("Welcome");

	Image icon = Toolkit.getDefaultToolkit().getImage("E:/java/casestudy2/OnlineTestApp-master/onlinelogomaker-020721-1948-5121.png");    
	setIconImage(icon);        

	//setContentPane(new JLabel(new ImageIcon("E:/java/casestudy2/OnlineTestApp-master/onlinelogomaker-020721-1948-5121.png")));
        l1 = new JLabel("LOGIN");

        l1.setForeground(Color.orange);

        l1.setFont(new Font("Serif", Font.BOLD, 20));

 

        l2 = new JLabel("Enter Username");

        l3 = new JLabel("Enter Password:");
	
	l4=new JLabel("Enter SAP id:");
	


       
	
	

        tf1 = new JTextField();

        p1 = new JPasswordField();

	tf2=new JTextField();

        btn1 = new JButton("Submit");
	
 

        l1.setBounds(380, 110, 300, 30);

        l2.setBounds(260, 170, 200, 30);

        l3.setBounds(260, 210, 200, 30);
	
	l4.setBounds(260, 250,200,30);
	
	
	
	

        tf1.setBounds(400, 170, 200, 30);
        p1.setBounds(400, 210, 200, 30);
	tf2.setBounds(400,250,200,30);

        btn1.setBounds(250, 300, 100, 30);
	  btn1.setBackground(Color.RED);


 

        add(l1);

        add(l2);

        add(tf1);
	add(tf2);
	
        add(l3);

	add(l4);
	
	
	

        add(p1);

        add(btn1);
	
        btn1.addActionListener(this);
	
	

        setSize(800, 500);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	getContentPane().setBackground(Color.cyan);
	
  	setVisible(true);

    }

 

    public void actionPerformed(ActionEvent e)

    {
	
        showData();

    }

 

    public void showData()

    {

        JFrame f1 = new JFrame();

        JLabel l, l0;

 

        String str1 = tf1.getText();

        char[] p = p1.getPassword();

        String str2 = new String(p);
	
	String str3 =tf2.getText();

        try

        {

            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dem","root","");

            PreparedStatement ps = con.prepareStatement("Select name, password, SAP from stud where name=? and password=? and SAP=?");

            ps.setString(1, str1);

            ps.setString(2, str2);
	
	    ps.setString(3, str3);

            ResultSet rs = ps.executeQuery();

            if (rs.next())

            {
		
		SelectTest.main();    

            } 
		else
            {
                JOptionPane.showMessageDialog(null,

                   "Incorrect username or password or SAP id..Try Again with correct detail");

            }

        }

        catch (Exception ex)
        {
            System.out.println(ex);
        }

    }
		
		
	

  public static void main(String[] args) {
		new LoginDemo();
		 }
}