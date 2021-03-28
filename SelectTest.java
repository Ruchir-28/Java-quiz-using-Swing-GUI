package selecttest;
import javaquiz.JavaQuiz;
import pythonquiz.PythonQuiz;
import cquiz.CQuiz;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
public class SelectTest 
{

	public static void main(String...args){
	JFrame f;
	JLabel jl;
	JButton b1,b2,b3;
	
	
		f = new JFrame("SELECT QUIZ");	
		
		jl = new JLabel();
		jl.setText("Select Test: ");
		b1 = new JButton("Java");
		b2 = new JButton("Python");
		b3 = new JButton("C");
		Font f1=new Font(Font.DIALOG_INPUT,Font.BOLD|Font.BOLD,20);
		jl.setFont(f1);
		jl.setBounds(200,60,300,40);
		b1.setBounds(200,100,120,40);
		b2.setBounds(200,140,120,40);
		b3.setBounds(200,180,120,40);
		

			b1.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e){
			JavaQuiz.main();
			}	
		});
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			PythonQuiz.main();
			}
		});
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			CQuiz.main();
			}
		});
	 
	 	f.getContentPane().setBackground(Color.BLUE); 
    	  	f.add(jl);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.setLayout(null);    
		f.setSize(550,500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
		}
}
	

		