package cquiz;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.Timer;


public class CQuiz extends JFrame implements ActionListener{



	private static final long serialVersionUID = 1L;

	JPanel jp;
	JLabel label;
	JLabel counterLabel;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnSubmit,btnPrevious;
	ButtonGroup bg;
	
	Timer timer;
	int sec=0;
	int min=10;
	
	
	
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	public void seeTime(){
			
					

   		 timer=new Timer(1000,new ActionListener(){
			
		public void actionPerformed(ActionEvent e){
			
		sec--;
		
		
		counterLabel.setText(min+ ":" +sec);
		
		if(sec==-1){
			sec=59;
			min--;
			counterLabel.setText(min+ ":" +sec);
			}
			
		if(min==0 && sec==0){
			timer.stop();
			JOptionPane.showMessageDialog(btnSubmit,"Time up!! Attempted: " +current);
			JOptionPane.showMessageDialog(btnSubmit,"Time up!! Result " +count);
			if(count>5){
				JOptionPane.showMessageDialog(btnSubmit,"PASS");
			}
			else{
				JOptionPane.showMessageDialog(btnSubmit,"FAIL");
				}
			System.exit(0);
			}
		}		
			
	});	
}	

	public CQuiz() {
		label = new JLabel();
		add(label);
		
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnSubmit = new JButton("Submit");
		btnPrevious= new JButton("Previous");
		
		btnNext.addActionListener(this);
		btnSubmit.addActionListener(this);
		btnPrevious.addActionListener(this);
		
		add(btnNext);
		add(btnSubmit);
		add(btnPrevious);
		

		
		counterLabel=new JLabel("");
		
		counterLabel.setBounds(80, 20, 550, 550);
		counterLabel.setVerticalAlignment(JLabel.TOP);
		counterLabel.setHorizontalAlignment(JLabel.RIGHT);
		add(counterLabel);
		
		set();
		
		label.setBounds(30, 40, 550, 20);
		
		radioButton[0].setBounds(50, 80, 550, 20);
		radioButton[1].setBounds(50, 110, 300, 20);
		radioButton[2].setBounds(50, 140, 300, 20);
		radioButton[3].setBounds(50, 170, 300, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnSubmit.setBounds(500, 240, 100, 30);
		btnPrevious.setBounds(220,240,100,30);
		
		seeTime();
		timer.start();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(700, 450);
	}

	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Next")) {
			if(current<9){
			m[x] = current;
			current=current+1;
			set();
			setVisible(true);
			}	
			if (current == 9){
				btnSubmit.setText("Submit");
				timer.stop();
				}
		}

		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Next" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(true);
				current = now;
			}
		}
		
		
		
	if (e.getActionCommand().equals("Previous")) {
			if(current>0){
			m[x] = current;
			current=current-1;
			set();
			setVisible(true);
			}	
		}

		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Previous" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(true);
				current = now;
				if(current == 9){
					btnNext.setVisible(true);	
				}
			}
		}
		
		if (e.getActionCommand().equals("Submit")) {		
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Submit" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Submit")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			if(count>=5){
			JOptionPane.showMessageDialog(this,"PASS");
			System.exit(0);
			}
			else{
			JOptionPane.showMessageDialog(this,"FAIL");
			System.exit(0);
			}
			
		}
		
	}


	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1: Chalna Bhosdu");
			radioButton[0].setText("Stream API");
			radioButton[1].setText("Serialization");
			radioButton[2].setText("Spliterator");
			radioButton[3].setText("Lambda Expression");
		}
		if (current == 1) {
			label.setText("Que2:  Which feature of java 7 allows to not explicitly close IO resource?");
			radioButton[0].setText("try catch finally");
			radioButton[1].setText("IOException");
			radioButton[2].setText("AutoCloseable");
			radioButton[3].setText("Streams");
		}
		if (current == 2) {
			label.setText("Que3: SessionFactory is a thread-safe object.");
			radioButton[0].setText("true");
			radioButton[1].setText("false");
			radioButton[2].setText("don't know");
			radioButton[3].setText("false");
		}
		if (current == 3) {
			label.setText("Que4: Which is the new method introduced in java 8 to iterate over a collection?");
			radioButton[0].setText("for (String i : StringList)");
			radioButton[1].setText("foreach (String i : StringList)");
			radioButton[2].setText("StringList.forEach()");
			radioButton[3].setText("List.for()");
		}
		if (current == 4) {
			label.setText("Que5:  What is the substitute of Rhino javascript engine in Java 8?");
			radioButton[0].setText(" Nashorn");
			radioButton[1].setText("V8");
			radioButton[2].setText("Inscript");
			radioButton[3].setText("Narcissus");
		}
		if (current == 5) {
			label.setText("Que6: How to read entire file in one line using java 8?");
			radioButton[0].setText("Files.readAllLines()");
			radioButton[1].setText("Files.read()");
			radioButton[2].setText("Files.readFile()");
			radioButton[3].setText("Files.lines()");
		}
		if (current == 6) {
			label.setText("Que7:  Which feature of java 7 allows to not explicitly close IO resource?");
			radioButton[0].setText("try catch finally");
			radioButton[1].setText("IOException");
			radioButton[2].setText("AutoCloseable");
			radioButton[3].setText("Streams");
		}
		if (current == 7) {
			label.setText("Que8:  Which of the following is not a core interface of Hibernate?");
			radioButton[0].setText("Configuration");
			radioButton[1].setText("Criteria");
			radioButton[2].setText("SessionManagement");
			radioButton[3].setText("Session");
		}
		if (current == 8) {
			label.setText("Que9: SessionFactory is a thread-safe object.");
			radioButton[0].setText("true");
			radioButton[1].setText("false");
			radioButton[2].setText("don't know");
			radioButton[3].setText("false");
		}
		if (current == 9) {
			label.setText("Que10: Which of the following is not a state of object in Hibernate?");
			radioButton[0].setText("Attached()");
			radioButton[1].setText("Detached()");
			radioButton[2].setText("Persistent()");
			radioButton[3].setText("Transient()");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	boolean check() {
		if (current == 0)
			return (radioButton[1].isSelected());
		if (current == 1)
			return (radioButton[1].isSelected());
		if (current == 2)
			return (radioButton[0].isSelected());
		if (current == 3)
			return (radioButton[2].isSelected());
		if (current == 4)
			return (radioButton[0].isSelected());
		if (current == 5)
			return (radioButton[0].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		if (current == 7)
			return (radioButton[2].isSelected());
		if (current == 8)
			return (radioButton[0].isSelected());
		if (current == 9)
			return (radioButton[0].isSelected());
		return false;
	}		

	public static void main(String...args) {
		new CQuiz();	
	}
}





		


