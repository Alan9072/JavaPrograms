package JAVATEST;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;

public class CALCULATOR implements ActionListener
{
	JFrame frame;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[8];
	JButton add,sub,mul,div,dec,equal,delete,clear;
	JPanel panel;
	JTextField textfield;
	double num1=0,num2=0,result=0;
	char operator;
	
	public CALCULATOR()
	{
		frame=new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(420,480);
		frame.setLayout(null);
	
		
		textfield =new JTextField();
		textfield.setBounds(10,10,380,40);
		frame.add(textfield);		
		//numberButtons
		
		
		add=new JButton("+");
		sub=new JButton("-");
		mul=new JButton("*");
		div=new JButton("/");
		dec=new JButton(".");
		equal=new JButton("=");
		delete=new JButton("Delete");
		clear=new JButton("Clear");
		
		functionButtons[0] = add;
		functionButtons[1] = sub;
		functionButtons[2] = mul;
		functionButtons[3] = div;
		functionButtons[4] = dec;
		functionButtons[5] = equal;
		functionButtons[6] = delete;
		functionButtons[7] = clear;
		
		
		for(int i=0;i<8;i++)
		{
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFocusable(false);
		}
		
		for(int i=0;i<10;i++)
		{
			numberButtons[i]=new JButton(""+i);
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFocusable(false);
		}
		
		panel = new JPanel();
		panel.setBounds(10,55,380,320);
		panel.setLayout(new GridLayout(4,4,15,15));
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(add);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(sub);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mul);
		panel.add(dec);
		panel.add(numberButtons[0]);
		panel.add(div);
		panel.add(equal);
		delete.setBounds(10,390,180,40);
		frame.add(delete);
		clear.setBounds(210,390,180,40);
		frame.add(clear);
		
		frame.add(panel);
		frame.setVisible(true);
		
		
	}
	
	
	
	public static void main(String[] args)
	{
		CALCULATOR calculator=new CALCULATOR();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++)
		{
			if(e.getSource()==numberButtons[i])
			{
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==add)
		{
			operator='+';
			num1=Double.parseDouble(textfield.getText());
			textfield.setText("");
		}
		if(e.getSource()==sub)
		{
			operator='-';
			num1=Double.parseDouble(textfield.getText());
			textfield.setText("");
		}
		if(e.getSource()==mul)
		{
			operator='*';
			num1=Double.parseDouble(textfield.getText());
			textfield.setText("");
		}
		if(e.getSource()==div)
		{
			operator='/';
			num1=Double.parseDouble(textfield.getText());
			textfield.setText("");
		}
		if(e.getSource()==dec)
		{
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()==equal)
		{
		 num2=Double.parseDouble(textfield.getText());
		 
		 switch(operator)
			 {case '+':
				 result=num1+num2;
				 break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				 if(num2==0)
				 {
					
					JOptionPane.showMessageDialog(frame,"Cannot divide by Zero");
					
				 }
				 else 
					 result=num1/num2;
				 break;
			 
			 }
		 textfield.setText(""+result);
		 num1=result;
		}
		if(e.getSource()==clear) 
		{
			textfield.setText("");
		}
		if (e.getSource()==delete)
		{
			String a=textfield.getText();
			textfield.setText("");
			for(int i=0;i<a.length()-1;i++)
			{
				textfield.setText(textfield.getText()+a.charAt(i));
			}
				
			
		}
		
	}

  
}
