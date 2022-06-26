package tools;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Calculator extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	double FIRSTNUM;
	double SECONDNUM;
	double RESULT;
	String ANSWER;
	String OPERATION;

	/**
	 * Author: Hancie Phago
	 */
	
	public Calculator() {
		setResizable(false);
		setTitle("Calculator");
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
		setSize(281,480);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel CONTAINER = new JPanel();
		CONTAINER.setBackground(Color.WHITE);
		contentPane.add(CONTAINER, BorderLayout.CENTER);
		CONTAINER.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(10, 11, 234, 47);
		CONTAINER.add(textField);
		textField.setColumns(10);

		JButton ONE = new JButton("1");
		ONE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String ENTERVALUE = textField.getText() + ONE.getText();
				textField.setText(ENTERVALUE);

			}
		});
		ONE.setBackground(Color.WHITE);
		ONE.setBounds(10, 95, 50, 47);
		CONTAINER.add(ONE);

		JButton TWO = new JButton("2");
		TWO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ENTERVALUE = textField.getText() + TWO.getText();
				textField.setText(ENTERVALUE);

			}
		});
		TWO.setBackground(Color.WHITE);
		TWO.setBounds(70, 95, 50, 47);
		CONTAINER.add(TWO);

		JButton THREE = new JButton("3");
		THREE.setBackground(Color.WHITE);
		THREE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ENTERVALUE = textField.getText() + THREE.getText();
				textField.setText(ENTERVALUE);

			}
		});
		THREE.setBounds(130, 95, 50, 47);
		CONTAINER.add(THREE);

		JButton FOUR = new JButton("4");
		FOUR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ENTERVALUE = textField.getText() + FOUR.getText();
				textField.setText(ENTERVALUE);

			}
		});
		FOUR.setBackground(Color.WHITE);
		FOUR.setBounds(194, 95, 50, 47);
		CONTAINER.add(FOUR);

		JButton FIVE = new JButton("5");
		FIVE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ENTERVALUE = textField.getText() + FIVE.getText();
				textField.setText(ENTERVALUE);

			}
		});
		FIVE.setBackground(Color.WHITE);
		FIVE.setBounds(10, 150, 50, 47);
		CONTAINER.add(FIVE);

		JButton SIX = new JButton("6");
		SIX.setBackground(Color.WHITE);
		SIX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String ENTERVALUE = textField.getText() + SIX.getText();
				textField.setText(ENTERVALUE);

			}
		});
		SIX.setBounds(70, 150, 50, 47);
		CONTAINER.add(SIX);

		JButton SEVEN = new JButton("7");
		SEVEN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ENTERVALUE = textField.getText() + SEVEN.getText();
				textField.setText(ENTERVALUE);

			}
		});
		SEVEN.setBackground(Color.WHITE);
		SEVEN.setBounds(130, 150, 50, 47);
		CONTAINER.add(SEVEN);

		JButton EIGHT = new JButton("8");
		EIGHT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ENTERVALUE = textField.getText() + EIGHT.getText();
				textField.setText(ENTERVALUE);

			}
		});
		EIGHT.setBackground(Color.WHITE);
		EIGHT.setBounds(194, 150, 50, 47);
		CONTAINER.add(EIGHT);

		JButton NINE = new JButton("9");
		NINE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ENTERVALUE = textField.getText() + NINE.getText();
				textField.setText(ENTERVALUE);

			}
		});
		NINE.setBackground(Color.WHITE);
		NINE.setBounds(10, 208, 50, 47);
		CONTAINER.add(NINE);

		JButton SUM = new JButton("+");
		SUM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "SORRY!ENTER YOUR FIRST NUMBER");
				} else {
					FIRSTNUM = Double.parseDouble(textField.getText());
					textField.setText("");
					OPERATION = "+";
				}
			}
		});
		SUM.setBackground(Color.WHITE);
		SUM.setBounds(70, 208, 50, 47);
		CONTAINER.add(SUM);

		JButton MINUS = new JButton("-");
		MINUS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "SORRY!ENTER YOUR FIRST NUMBER");

				} else {
					FIRSTNUM = Double.parseDouble(textField.getText());
					textField.setText("");
					OPERATION = "-";
				}
			}
		});
		MINUS.setBackground(Color.WHITE);
		MINUS.setBounds(130, 208, 50, 47);
		CONTAINER.add(MINUS);

		JButton MULTIPLY = new JButton("*");
		MULTIPLY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "SORRY!ENTER YOUR FIRST NUMBER");

				} else {
					FIRSTNUM = Double.parseDouble(textField.getText());
					textField.setText("");
					OPERATION = "*";
				}
			}
		});
		MULTIPLY.setBackground(Color.WHITE);
		MULTIPLY.setBounds(190, 208, 50, 47);
		CONTAINER.add(MULTIPLY);

		JButton DIVISION = new JButton("/");
		DIVISION.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "SORRY!ENTER YOUR FIRST NUMBER");

				} else {
					FIRSTNUM = Double.parseDouble(textField.getText());
					textField.setText("");
					OPERATION = "/";
				}
			}
		});
		DIVISION.setBackground(Color.WHITE);
		DIVISION.setBounds(10, 266, 50, 47);
		CONTAINER.add(DIVISION);

		JButton CLEAR = new JButton("C");
		CLEAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		CLEAR.setBackground(Color.WHITE);
		CLEAR.setBounds(70, 266, 50, 47);
		CONTAINER.add(CLEAR);

		JButton EQUAL = new JButton("=");
		EQUAL.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (OPERATION == "+") {
					SECONDNUM = Double.parseDouble(textField.getText());
					RESULT = FIRSTNUM + SECONDNUM;
					ANSWER = ANSWER.valueOf(RESULT);
					textField.setText(ANSWER);
				}

				if (OPERATION == "-") {
					SECONDNUM = Double.parseDouble(textField.getText());
					RESULT = FIRSTNUM - SECONDNUM;
					ANSWER = ANSWER.valueOf(RESULT);
					textField.setText(ANSWER);
				}

				if (OPERATION == "*") {
					SECONDNUM = Double.parseDouble(textField.getText());
					RESULT = FIRSTNUM * SECONDNUM;
					ANSWER = ANSWER.valueOf(RESULT);
					textField.setText(ANSWER);
				}

				if (OPERATION == "/") {
					SECONDNUM = Double.parseDouble(textField.getText());
					RESULT = FIRSTNUM / SECONDNUM;
					ANSWER = ANSWER.valueOf(RESULT);
					textField.setText(ANSWER);
				}

			}
		});
		EQUAL.setBackground(Color.WHITE);
		EQUAL.setBounds(190, 266, 50, 47);
		CONTAINER.add(EQUAL);

		JLabel ABOUT = new JLabel("DEVELOPED BY :");
		ABOUT.setBounds(92, 334, 100, 25);
		CONTAINER.add(ABOUT);

		JLabel ABOUTT = new JLabel("HANCIE PHAGO");
		ABOUTT.setBounds(92, 357, 150, 17);
		CONTAINER.add(ABOUTT);

		JButton button = new JButton(".");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ENTERVALUE = textField.getText() + button.getText();
				textField.setText(ENTERVALUE);
			}
		});
		button.setBackground(Color.WHITE);
		button.setBounds(130, 266, 50, 47);
		CONTAINER.add(button);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new Calculator();
	}
}
