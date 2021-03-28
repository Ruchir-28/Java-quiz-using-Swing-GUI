package pythonquiz;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.Timer;


public class PythonQuiz extends JFrame implements ActionListener{


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
			if(count>=5){
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

	public PythonQuiz() {
	
		
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
			if (check()){
				count = count + 1;
			current++;
			}

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
			label.setText("Que1:  What is the maximum possible length of an identifier?");
			radioButton[0].setText("16");
			radioButton[1].setText("32");
			radioButton[2].setText("64");
			radioButton[3].setText("None");
		}
		if (current == 1) {
			label.setText("Que2:   Which of the following functions is a built-in function in python language?");
			radioButton[0].setText("val()");
			radioButton[1].setText("print()");
			radioButton[2].setText("main()");
			radioButton[3].setText("None");
		}
		if (current == 2) {
			label.setText("Que3:  What is the method inside the class in python language?");
			radioButton[0].setText("Object");
			radioButton[1].setText("Function");
			radioButton[2].setText("Attribute");
			radioButton[3].setText("Argument");
		}
		if (current == 3) {
			label.setText("Que4: Which of the following declarations is incorrect?");
			radioButton[0].setText("_x = 2");
			radioButton[1].setText("_x = 3");
			radioButton[2].setText("__xyz__ = 5");
			radioButton[3].setText("None");
		}
		if (current == 4) {
			label.setText("Que5:Why does the name of local variables start with an underscore discouraged?");
			radioButton[0].setText(" To identify the variable");
			radioButton[1].setText("It confuses the interpreter");
			radioButton[2].setText("It indicates a private variable of a class");
			radioButton[3].setText("None");
		}
		if (current == 5) {
			label.setText("Que6: Which of the following is not a keyword in Python language?");
			radioButton[0].setText("val");
			radioButton[1].setText("raise");
			radioButton[2].setText("try");
			radioButton[3].setText("with");
		}
		if (current == 6) {
			label.setText("Que7: Which of the following operators is the correct option for power(ab)?");
			radioButton[0].setText("a^b");
			radioButton[1].setText("a**b");
			radioButton[2].setText("a^^b");
			radioButton[3].setText("a^*b");
		}
		if (current == 7) {
			label.setText("Que8: Output of  >>>string(a)+string(bc) is: ");
			radioButton[0].setText("a+bc");
			radioButton[1].setText("abc");
			radioButton[2].setText("a bc");
			radioButton[3].setText("a");
		}
		if (current == 8) {
			label.setText("Que9: any([5>8, 6>3, 3>1])  What will be the output of this code?");
			radioButton[0].setText("true");
			radioButton[1].setText("false");
			radioButton[2].setText("Invalid code");
			radioButton[3].setText("None");
		}
		if (current == 9) {
			label.setText("Que10: >>> print(ord('h') - ord('z')) Output is:"); 	
			radioButton[0].setText("18");
			radioButton[1].setText("-18");
			radioButton[2].setText("17");
			radioButton[3].setText("-17");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	boolean check() {
		if (current == 0)
			return (radioButton[2].isSelected());
		if (current == 1)
			return (radioButton[1].isSelected());
		if (current == 2)
			return (radioButton[1].isSelected());
		if (current == 3)
			return (radioButton[3].isSelected());
		if (current == 4)
			return (radioButton[2].isSelected());
		if (current == 5)
			return (radioButton[0].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		if (current == 7)
			return (radioButton[1].isSelected());
		if (current == 8)
			return (radioButton[0].isSelected());
		if (current == 9)
			return (radioButton[1].isSelected());
		return false;
	}		

	public static void main(String...args) {
		new PythonQuiz();		
	}
     }