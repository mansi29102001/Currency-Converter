package SwingApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Color;

public class CurrencyConverter {

	private JFrame frame;
	private JTextField AmountField;
	String from_convert, to_convert;
	int convert, conversionTo;
	double amount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrencyConverter window = new CurrencyConverter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CurrencyConverter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 250, 250));
		frame.setBounds(100, 100, 725, 419);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Heading = new JLabel("---- CURRENCY CONVERTER ----");
		Heading.setForeground(new Color(255, 69, 0));
		Heading.setBackground(new Color(204, 51, 255));
		Heading.setFont(new Font("Footlight MT Light", Font.BOLD, 20));
		Heading.setHorizontalAlignment(SwingConstants.CENTER);
		Heading.setBounds(192, 11, 310, 60);
		frame.getContentPane().add(Heading);
		
		JLabel Amount = new JLabel("Enter the Amount :");
		Amount.setFont(new Font("Sitka Text", Font.BOLD, 15));
		Amount.setHorizontalAlignment(SwingConstants.CENTER);
		Amount.setBounds(170, 252, 158, 36);
		frame.getContentPane().add(Amount);
		
		AmountField = new JTextField();
		AmountField.setBackground(new Color(255, 255, 0));
		AmountField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//amount=Integer.parseInt(AmountField.getText());
			}
		});
		AmountField.setFont(new Font("Sitka Text", Font.BOLD, 15));
		AmountField.setHorizontalAlignment(SwingConstants.CENTER);
		AmountField.setBounds(357, 255, 163, 31);
		frame.getContentPane().add(AmountField);
		AmountField.setColumns(10);
		
		JLabel from = new JLabel("Which type of currency you want to convert ?");
		from.setHorizontalAlignment(SwingConstants.CENTER);
		from.setFont(new Font("Sitka Text", Font.BOLD, 13));
		from.setBounds(25, 92, 303, 60);
		frame.getContentPane().add(from);
		
		
		final JComboBox currency_convert = new JComboBox();
		
		currency_convert.setMaximumRowCount(7);
		currency_convert.setFont(new Font("Sitka Text", Font.BOLD, 13));
		currency_convert.setBackground(new Color(255, 140, 0));
		currency_convert.addItem("Select your choice");
		
		currency_convert.addItem("US Dollar");
		currency_convert.addItem("Euro");
		currency_convert.addItem("Yen");
		currency_convert.addItem("Pound");
		currency_convert.addItem("Swiss Franc");
		currency_convert.addItem("Canadian Dollar");
		currency_convert.addItem("Indian Rupee");
		currency_convert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				from_convert=currency_convert.getSelectedItem().toString();
				switch(from_convert) {
				case "US Dollar": convert=1;break;
				case "Euro": convert=2;break;
				case "Yen": convert=3;break;
				case "Pound": convert=4;break;
				case "Swiss Franc": convert=5;break;
				case "Canadian Dollar": convert=6;break;
				case "Indian Rupee": convert=7;break;
				default: System.out.println("Please select a valid option");
				}
			}
		});
		currency_convert.setBounds(357, 107, 163, 31);
		frame.getContentPane().add(currency_convert);
		
		JLabel to = new JLabel("Into which type of currency you want to convert ?");
		to.setFont(new Font("Sitka Text", Font.BOLD, 13));
		to.setHorizontalAlignment(SwingConstants.CENTER);
		to.setBounds(10, 163, 318, 60);
		frame.getContentPane().add(to);
		
		final JComboBox to_convertCurrency = new JComboBox();
		to_convertCurrency.setBackground(new Color(153, 255, 51));
		to_convertCurrency.addItem("Select your choice");
		to_convertCurrency.addItem("US Dollar");
		to_convertCurrency.addItem("Euro");
		to_convertCurrency.addItem("Yen");
		to_convertCurrency.addItem("Pound");
		to_convertCurrency.addItem("Swiss Franc");
		to_convertCurrency.addItem("Canadian Dollar");
		to_convertCurrency.addItem("Indian Rupee");
		to_convertCurrency.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				to_convert=to_convertCurrency.getSelectedItem().toString();
				switch(to_convert) {
				case "US Dollar": conversionTo=1;break;
				case "Euro": conversionTo=2;break;
				case "Yen": conversionTo=3;break;
				case "Pound": conversionTo=4;break;
				case "Swiss Franc": conversionTo=5;break;
				case "Canadian Dollar": conversionTo=6;break;
				case "Indian Rupee": conversionTo=7;break;
				default: System.out.println("Please select a valid option");
				}
			}
		});
		to_convertCurrency.setMaximumRowCount(7);
		to_convertCurrency.setFont(new Font("Sitka Text", Font.BOLD, 13));
		to_convertCurrency.setBounds(357, 178, 163, 31);
		frame.getContentPane().add(to_convertCurrency);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(318, 346, 230, -21);
		frame.getContentPane().add(btnNewButton);
		
		JButton convert_button = new JButton("Convert");
		convert_button.setForeground(new Color(0, 0, 0));
		convert_button.setBackground(new Color(204, 51, 255));
		convert_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double result;
				
				try {
					amount=Integer.parseInt(AmountField.getText());
					switch(convert) {
					case 1:{
						if(conversionTo==1) {
							result=amount*1;
							JOptionPane.showMessageDialog(null,amount+" US Dollar "+"= "+ result+" US Dollar");break;
						}
						else if(conversionTo==2) {
								result=amount*0.85;
								JOptionPane.showMessageDialog(null,amount+" US Dollar "+"= "+ result+" Euro");break;
							}
						else if(conversionTo==3) {
							result=amount*109.6;
							JOptionPane.showMessageDialog(null,amount+" US Dollar "+"= "+ result+" Yen");break;
						}
						else if(conversionTo==4) {
							result=amount*0.72;
							JOptionPane.showMessageDialog(null,amount+" US Dollar "+"= "+ result+" Pound");break;
						}
						else if(conversionTo==5) {
							result=amount*0.91;
							JOptionPane.showMessageDialog(null,amount+" US Dollar "+"= "+ result+" Swiss franc");break;
						}
						else if(conversionTo==6) {
							result=amount*1.26;
							JOptionPane.showMessageDialog(null,amount+" US Dollar "+"= "+ result+" Canadian Dollar");break;
						}
						else if(conversionTo==7) {
							result=amount*74.54;
							JOptionPane.showMessageDialog(null,amount+" US Dollar "+"= "+ result+" Rupee");break;
						}
						else {
							JOptionPane.showMessageDialog(null, "Cannot convert the given amount");
						}
					}
					case 2:{
						if(conversionTo==1) {
							result=amount*1.18;
							JOptionPane.showMessageDialog(null,amount+" Euro "+"= "+ result+" US Dollar");break;
						}
						else if(conversionTo==2) {
								result=amount*1;
								JOptionPane.showMessageDialog(null,amount+" Euro "+"= "+ result+" Euro");break;
							}
						else if(conversionTo==3) {
							result=amount*129.67;
							JOptionPane.showMessageDialog(null,amount+" Euro "+"= "+ result+" Yen");break;
						}
						else if(conversionTo==4) {
							result=amount*0.85;
							JOptionPane.showMessageDialog(null,amount+" Euro "+"= "+ result+" Pound");break;
						}
						else if(conversionTo==5) {
							result=amount*1.08;
							JOptionPane.showMessageDialog(null,amount+" Euro "+"= "+ result+" Swiss franc");break;
						}
						else if(conversionTo==6) {
							result=amount*1.49;
							JOptionPane.showMessageDialog(null,amount+" Euro "+"= "+ result+" Canadian Dollar");break;
						}
						else if(conversionTo==7) {
							result=amount*88.13;
							JOptionPane.showMessageDialog(null,amount+" US Dollar "+"= "+ result+" Rupee");break;
						}
						else {
							JOptionPane.showMessageDialog(null, "Cannot convert the given amount");
						}
					}
					case 3:{
						if(conversionTo==1) {
							result=amount*0.0091;
							JOptionPane.showMessageDialog(null,amount+" Yen "+"= "+ result+" US Dollar");break;
						}
						else if(conversionTo==2) {
								result=amount*0.0077;
								JOptionPane.showMessageDialog(null,amount+" Yen "+"= "+ result+" Euro");break;
							}
						else if(conversionTo==3) {
							result=amount*1;
							JOptionPane.showMessageDialog(null,amount+" Yen "+"= "+ result+" Yen");break;
						}
						else if(conversionTo==4) {
							result=amount*0.0066;
							JOptionPane.showMessageDialog(null,amount+" Yen "+"= "+ result+" Pound");break;
						}
						else if(conversionTo==5) {
							result=amount*0.0083;
							JOptionPane.showMessageDialog(null,amount+" Yen "+"= "+ result+" Swiss franc");break;
						}
						else if(conversionTo==6) {
							result=amount*0.011;
							JOptionPane.showMessageDialog(null,amount+" Yen "+"= "+ result+" Canadian Dollar");break;
						}
						else if(conversionTo==7) {
							result=amount*0.68;
							JOptionPane.showMessageDialog(null,amount+" Yen "+"= "+ result+" Rupee");break;
						}
						else {
							JOptionPane.showMessageDialog(null, "Cannot convert the given amount");
						}
					}
					case 4:{
						if(conversionTo==1) {
							result=amount*1.39;
							JOptionPane.showMessageDialog(null,amount+" Pound "+"= "+ result+" US Dollar");break;
						}
						else if(conversionTo==2) {
								result=amount*1.17;
								JOptionPane.showMessageDialog(null,amount+" Pound "+"= "+ result+" Euro");break;
							}
						else if(conversionTo==3) {
							result=amount*152.20;
							JOptionPane.showMessageDialog(null,amount+" Pound "+"= "+ result+" Yen");break;
						}
						else if(conversionTo==4) {
							result=amount*1;
							JOptionPane.showMessageDialog(null,amount+" Pound "+"= "+ result+" Pound");break;
						}
						else if(conversionTo==5) {
							result=amount*1.27;
							JOptionPane.showMessageDialog(null,amount+" Pound "+"= "+ result+" Swiss franc");break;
						}
						else if(conversionTo==6) {
							result=amount*1.75;
							JOptionPane.showMessageDialog(null,amount+" Pound "+"= "+ result+" Canadian Dollar");break;
						}
						else if(conversionTo==7) {
							result=amount*103.46;
							JOptionPane.showMessageDialog(null,amount+" Pound "+"= "+ result+" Rupee");break;
						}
						else {
							JOptionPane.showMessageDialog(null, "Cannot convert the given amount");
						}
					}
					case 5:{
						if(conversionTo==1) {
							result=amount*1.09;
							JOptionPane.showMessageDialog(null,amount+" Swiss franc "+"= "+ result+" US Dollar");break;
						}
						else if(conversionTo==2) {
								result=amount*0.93;
								JOptionPane.showMessageDialog(null,amount+" Swiss franc "+"= "+ result+" Euro");break;
							}
						else if(conversionTo==3) {
							result=amount*120.03;
							JOptionPane.showMessageDialog(null,amount+" Swiss franc "+"= "+ result+" Yen");break;
						}
						else if(conversionTo==4) {
							result=amount*0.79;
							JOptionPane.showMessageDialog(null,amount+" Swiss franc "+"= "+ result+" Pound");break;
						}
						else if(conversionTo==5) {
							result=amount*1;
							JOptionPane.showMessageDialog(null,amount+" Swiss franc "+"= "+ result+" Swiss franc");break;
						}
						else if(conversionTo==6) {
							result=amount*1.38;
							JOptionPane.showMessageDialog(null,amount+" Swiss franc "+"= "+ result+" Canadian Dollar");break;
						}
						else if(conversionTo==7) {
							result=amount*81.60;
							JOptionPane.showMessageDialog(null,amount+" Swiss franc "+"= "+ result+" Rupee");break;
						}
						else {
							JOptionPane.showMessageDialog(null, "Cannot convert the given amount");
						}
					}
					case 6:{
						if(conversionTo==1) {
							result=amount*0.79;
							JOptionPane.showMessageDialog(null,amount+" Canadian Dollar "+"= "+ result+" US Dollar");break;
						}
						else if(conversionTo==2) {
								result=amount*0.67;
								JOptionPane.showMessageDialog(null,amount+" Canadian Dollar "+"= "+ result+" Euro");break;
							}
						else if(conversionTo==3) {
							result=amount*87.19;
							JOptionPane.showMessageDialog(null,amount+" Canadian Dollar "+"= "+ result+" Yen");break;
						}
						else if(conversionTo==4) {
							result=amount*0.57;
							JOptionPane.showMessageDialog(null,amount+" Canadian Dollar "+"= "+ result+" Pound");break;
						}
						else if(conversionTo==5) {
							result=amount*0.73;
							JOptionPane.showMessageDialog(null,amount+" Canadian Dollar "+"= "+ result+" Swiss franc");break;
						}
						else if(conversionTo==6) {
							result=amount*1;
							JOptionPane.showMessageDialog(null,amount+" Canadian Dollar "+"= "+ result+" Canadian Dollar");break;
						}
						else if(conversionTo==7) {
							result=amount*59.23;
							JOptionPane.showMessageDialog(null,amount+" Canadian Dollar "+"= "+ result+" Rupee");break;
						}
						else {
							JOptionPane.showMessageDialog(null, "Cannot convert the given amount");
						}
					}
					case 7:{
						if(conversionTo==1) {
							result=amount*0.013;
							JOptionPane.showMessageDialog(null,amount+" Rupee "+"= "+ result+" US Dollar");break;
						}
						else if(conversionTo==2) {
								result=amount*0.011;
								JOptionPane.showMessageDialog(null,amount+" Rupee "+"= "+ result+" Euro");break;
							}
						else if(conversionTo==3) {
							result=amount*1.47;
							JOptionPane.showMessageDialog(null,amount+"Rupee "+"= "+ result+" Yen");break;
						}
						else if(conversionTo==4) {
							result=amount*0.0097;
							JOptionPane.showMessageDialog(null,amount+" Rupee"+"= "+ result+" Pound");break;
						}
						else if(conversionTo==5) {
							result=amount*0.012;
							JOptionPane.showMessageDialog(null,amount+" Rupee "+"= "+ result+" Swiss franc");break;
						}
						else if(conversionTo==6) {
							result=amount*0.017;
							JOptionPane.showMessageDialog(null,amount+" Rupee "+"= "+ result+" Canadian Dollar");break;
						}
						else if(conversionTo==7) {
							result=amount*1;
							JOptionPane.showMessageDialog(null,amount+" Rupee "+"= "+ result+" Rupee");break;
						}
						else {
							JOptionPane.showMessageDialog(null, "Cannot convert the given amount");
						}
					}
					}
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Enter the valid amount");
					
				}
			}
		});
		convert_button.setFont(new Font("Sitka Text", Font.BOLD, 14));
		convert_button.setBounds(399, 333, 121, 36);
		frame.getContentPane().add(convert_button);
		
		JButton cancel_button = new JButton("Cancel");
		cancel_button.setForeground(new Color(0, 0, 0));
		cancel_button.setBackground(new Color(255, 204, 51));
		cancel_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Exit");
				
			}
		});
		cancel_button.setFont(new Font("Sitka Text", Font.BOLD, 14));
		cancel_button.setBounds(566, 333, 121, 36);
		frame.getContentPane().add(cancel_button);
	}
}
