import selecttest.SelectTest;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
 
 class RegistrationForm implements ActionListener {
    JFrame frame;
  
    JLabel nameLabel=new JLabel("NAME");
 
    JLabel passwordLabel=new JLabel("PASSWORD");

  
    JLabel SAPLabel=new JLabel("SAP");
    JTextField nameTextField=new JTextField();
   
    
    JPasswordField passwordField=new JPasswordField();
   

    JTextField SAPTextField=new JTextField();
    JButton registerButton=new JButton("REGISTER");
    JButton resetButton=new JButton("RESET");
 

	
 
 
    RegistrationForm()
    {
        createWindow();
	
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
	


    }
    public void createWindow()
    {
        frame=new JFrame();
        frame.setTitle("Registration Form");
        frame.setBounds(60,60,380,600);
        frame.getContentPane().setBackground(Color.pink);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
	

    public void setLocationAndSize()
    {
        nameLabel.setBounds(20,20,40,70);
      
      
        passwordLabel.setBounds(20,170,100,70);
   
     
        SAPLabel.setBounds(20,320,100,70);
        nameTextField.setBounds(180,43,165,23);
     
     
        passwordField.setBounds(180,193,165,23);
        
        SAPTextField.setBounds(180,343,165,23);
        registerButton.setBounds(70,400,100,35);
        resetButton.setBounds(220,400,100,35);
    }
    public void addComponentsToFrame()
    {
        frame.add(nameLabel);
     
	
        frame.add(passwordLabel);
        

        frame.add(SAPLabel);
        frame.add(nameTextField);
     
        frame.add(passwordField);

 
        frame.add(SAPTextField);
        frame.add(registerButton);
        frame.add(resetButton);
	
    }
    public void actionEvent()
    {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);

    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {

	
	
        if(e.getSource()==registerButton)
        {
            try {
                //Creating Connection Object
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dem","root","");
                //Preapared Statement
                PreparedStatement Pstatement=connection.prepareStatement("insert into stud values(?,?,?)");
                //Specifying the values of it's parameter
                Pstatement.setString(1,nameTextField.getText());
               
              
                Pstatement.setString(2,passwordField.getText());
            
             
                Pstatement.setString(3,SAPTextField.getText());
                {
                    Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
		    SelectTest.main();
                }
 
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
 
 
        }
        if(e.getSource()==resetButton)
        {
            //Clearing Fields
            nameTextField.setText("");
          

            passwordField.setText("");
         
         
            SAPTextField.setText("");
        }
    }
}

public class Main {
    public static void main(String[] args)
    {
        new RegistrationForm();
    }
}
