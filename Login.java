//package com.dhitchin.smartFridge.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;



@SuppressWarnings("serial")
public class Login extends JDialog {

	private JPanel contentPane;
	private JTextField passwordField;
	JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnEnter;
	
	public void addController(LoginController controller){
		btn0.addActionListener(controller);
		btn1.addActionListener(controller);
		btn2.addActionListener(controller);
		btn3.addActionListener(controller);
		btn4.addActionListener(controller);
		btn5.addActionListener(controller);
		btn6.addActionListener(controller);
		btn7.addActionListener(controller);
		btn8.addActionListener(controller);
		btn9.addActionListener(controller);
		btnEnter.addActionListener(controller);
		contentPane.addKeyListener(controller);
		passwordField.addKeyListener(controller);
		
		passwordField.grabFocus();
	}
	
	public void clearPasscode(){
		passwordField.setText("");
	}
	
	public void appendPasscode(String s){
		String updated = passwordField.getText()+s;
		passwordField.setText(updated);
	}
	
	public void startProgram(){
		setVisible(false);
		getParent().setVisible(true);
	}
	
	public String getPasscode(){
		return passwordField.getText();
	}

	/**
	 * Create the frame.
	 */
	public Login(final JFrame parent) {
		super(parent, true);
		setTitle("Login");
		setResizable(false);
		setFocusable(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {60, 60, 55};
		gbl_contentPane.rowHeights = new int[] {60, 60, 60, 60, 60};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		passwordField = new JTextField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 20));
		passwordField.setFocusable(true);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.gridwidth = 3;
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.gridx = 0;
		gbc_passwordField.gridy = 0;
		contentPane.add(passwordField, gbc_passwordField);
		
		btn7 = new JButton("7");
		btn7.setFont(new Font("Dialog", Font.PLAIN, 20));
		GridBagConstraints gbc_btn7 = new GridBagConstraints();
		gbc_btn7.fill = GridBagConstraints.BOTH;
		gbc_btn7.insets = new Insets(0, 0, 5, 5);
		gbc_btn7.gridx = 0;
		gbc_btn7.gridy = 1;
		contentPane.add(btn7, gbc_btn7);
		
		btn8 = new JButton("8");
		btn8.setFont(new Font("Dialog", Font.PLAIN, 20));
		GridBagConstraints gbc_btn8 = new GridBagConstraints();
		gbc_btn8.fill = GridBagConstraints.BOTH;
		gbc_btn8.insets = new Insets(0, 0, 5, 5);
		gbc_btn8.gridx = 1;
		gbc_btn8.gridy = 1;
		contentPane.add(btn8, gbc_btn8);
		
		btn9 = new JButton("9");
		btn9.setFont(new Font("Dialog", Font.PLAIN, 20));
		GridBagConstraints gbc_btn9 = new GridBagConstraints();
		gbc_btn9.fill = GridBagConstraints.BOTH;
		gbc_btn9.insets = new Insets(0, 0, 5, 0);
		gbc_btn9.gridx = 2;
		gbc_btn9.gridy = 1;
		contentPane.add(btn9, gbc_btn9);
		
		btn4 = new JButton("4");
		btn4.setFont(new Font("Dialog", Font.PLAIN, 20));
		GridBagConstraints gbc_btn4 = new GridBagConstraints();
		gbc_btn4.fill = GridBagConstraints.BOTH;
		gbc_btn4.insets = new Insets(0, 0, 5, 5);
		gbc_btn4.gridx = 0;
		gbc_btn4.gridy = 2;
		contentPane.add(btn4, gbc_btn4);
		
		btn5 = new JButton("5");
		btn5.setFont(new Font("Dialog", Font.PLAIN, 20));
		GridBagConstraints gbc_btn5 = new GridBagConstraints();
		gbc_btn5.fill = GridBagConstraints.BOTH;
		gbc_btn5.insets = new Insets(0, 0, 5, 5);
		gbc_btn5.gridx = 1;
		gbc_btn5.gridy = 2;
		contentPane.add(btn5, gbc_btn5);
		
		btn6 = new JButton("6");
		btn6.setFont(new Font("Dialog", Font.PLAIN, 20));
		GridBagConstraints gbc_btn6 = new GridBagConstraints();
		gbc_btn6.fill = GridBagConstraints.BOTH;
		gbc_btn6.insets = new Insets(0, 0, 5, 0);
		gbc_btn6.gridx = 2;
		gbc_btn6.gridy = 2;
		contentPane.add(btn6, gbc_btn6);
		
		btn1 = new JButton("1");
		btn1.setFont(new Font("Dialog", Font.PLAIN, 20));
		GridBagConstraints gbc_btn1 = new GridBagConstraints();
		gbc_btn1.fill = GridBagConstraints.BOTH;
		gbc_btn1.insets = new Insets(0, 0, 5, 5);
		gbc_btn1.gridx = 0;
		gbc_btn1.gridy = 3;
		contentPane.add(btn1, gbc_btn1);
		
		btn2 = new JButton("2");
		btn2.setFont(new Font("Dialog", Font.PLAIN, 20));
		GridBagConstraints gbc_btn2 = new GridBagConstraints();
		gbc_btn2.fill = GridBagConstraints.BOTH;
		gbc_btn2.insets = new Insets(0, 0, 5, 5);
		gbc_btn2.gridx = 1;
		gbc_btn2.gridy = 3;
		contentPane.add(btn2, gbc_btn2);
		
		btn3 = new JButton("3");
		btn3.setFont(new Font("Dialog", Font.PLAIN, 20));
		GridBagConstraints gbc_btn3 = new GridBagConstraints();
		gbc_btn3.fill = GridBagConstraints.BOTH;
		gbc_btn3.insets = new Insets(0, 0, 5, 0);
		gbc_btn3.gridx = 2;
		gbc_btn3.gridy = 3;
		contentPane.add(btn3, gbc_btn3);
		
		btn0 = new JButton("0");
		btn0.setFont(new Font("Dialog", Font.PLAIN, 20));
		GridBagConstraints gbc_btn0 = new GridBagConstraints();
		gbc_btn0.fill = GridBagConstraints.BOTH;
		gbc_btn0.insets = new Insets(0, 0, 0, 5);
		gbc_btn0.gridx = 0;
		gbc_btn0.gridy = 4;
		contentPane.add(btn0, gbc_btn0);
		
		btnEnter = new JButton("Enter");
		btnEnter.setFont(new Font("Dialog", Font.PLAIN, 20));
		GridBagConstraints gbc_btnEnter = new GridBagConstraints();
		gbc_btnEnter.gridwidth = 2;
		gbc_btnEnter.fill = GridBagConstraints.BOTH;
		gbc_btnEnter.gridx = 1;
		gbc_btnEnter.gridy = 4;
		contentPane.add(btnEnter, gbc_btnEnter);
		
		pack();
		setLocationRelativeTo(null);
	}

}
