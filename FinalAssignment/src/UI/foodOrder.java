package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class foodOrder {
	JFrame frame;
	JLabel lblTitle, orderFood,roomID, foodID, FoodName, Quantity;
	JTextField roomIDtxt, foodIDtxt, FoodNametxt, Quantitytxt;
	JPanel foodTitle, foodEntry, foodTable;
	
	public foodOrder() {
		frame=new JFrame();
		frame.setSize(850,550);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		
		foodTitle=new JPanel();
		foodTitle.setBackground(new Color(21, 159, 133));
		foodTitle.setPreferredSize(new Dimension(100,100));
		frame.add(foodTitle, BorderLayout.NORTH);
		
		foodEntry=new JPanel();
		foodEntry.setBackground(new Color(21, 159, 133));
		foodEntry.setPreferredSize(new Dimension(300,100));
		foodEntry.setLayout(null);
		frame.add(foodEntry, BorderLayout.WEST);
		
		foodTable=new JPanel();
		foodTable.setPreferredSize(new Dimension(300,100));
		frame.add(foodTable, BorderLayout.CENTER);
		
		lblTitle=new JLabel("Order Foods", SwingConstants.CENTER);
		lblTitle.setPreferredSize(new Dimension(400,100));
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Tahoma",Font.BOLD,25));
		foodTitle.add(lblTitle);
		
		JSeparator separator=new JSeparator();
		separator.setBounds(0,0,400,10);
		foodEntry.add(separator);
		
		orderFood=new JLabel("PLEASE ORDER FOODS", SwingConstants.CENTER);
		orderFood.setForeground(Color.WHITE);
		orderFood.setFont(new Font("Tahoma", Font.BOLD,18));
		orderFood.setBounds(5,10,300,20);
		foodEntry.add(orderFood);
		
		roomID=new JLabel("Room ID:");
		roomID.setForeground(Color.WHITE);
		roomID.setFont(new Font("Tahoma", Font.PLAIN,15));
		roomID.setBounds(10,60,100,20);
		foodEntry.add(roomID);
		
		roomIDtxt=new JTextField();
		roomIDtxt.setFont(new Font("Tahoma", Font.PLAIN,15));
		roomIDtxt.setBorder(BorderFactory.createLineBorder(Color.white,1));
		roomIDtxt.setBounds(110,60,150,20);
		foodEntry.add(roomIDtxt);
		
		
		
		
		
		
		
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new foodOrder();

	}

}
