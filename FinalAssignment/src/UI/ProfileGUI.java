package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Libs.Global;

//main class
public class ProfileGUI {

	JFrame frame;

	// deafult constructor
	public ProfileGUI() {

		// Main Frame
		frame = new JFrame("My Profile");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
		frame.setSize(400, 600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());

		// **************************North Panel****************************************
		JPanel north = new JPanel();
		north.setLayout(null);
		north.setBackground(new Color(21, 159, 133));
		north.setPreferredSize(new Dimension(100, 200));
		frame.add(north, BorderLayout.NORTH);

		// User profile Picture
		JLabel img = new JLabel();
		img.setIcon(new javax.swing.ImageIcon(getClass().getResource("user.png")));
		img.setBounds(125, 10, 200, 128);
		north.add(img);

		JLabel userlbl = new JLabel();
		userlbl.setText(Global.currentUser.getUsername());
		userlbl.setForeground(Color.white);
		userlbl.setBounds(135, 90, 200, 128);
		userlbl.setFont(new Font("Verdana", Font.BOLD, 18));
		north.add(userlbl);

		// *************************Center Panel***********************
		JPanel center = new JPanel();
		center.setLayout(null);
		center.setBackground(new Color(205, 209, 228));
		center.setPreferredSize(new Dimension(100, 200));
		frame.add(center, BorderLayout.CENTER);

		// Customer id label
		JLabel customeridlbl = new JLabel("Customer-ID: ");
		customeridlbl.setForeground(Color.black);
		customeridlbl.setBounds(50, 20, 200, 35);
		customeridlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		center.add(customeridlbl);

		// Global customer id
		JLabel GlobalCustomerID = new JLabel();
		GlobalCustomerID.setForeground(Color.black);
		GlobalCustomerID.setText(Integer.toString(Global.currentUser.getCustomer_ID()));
		GlobalCustomerID.setBounds(180, 20, 200, 35);
		GlobalCustomerID.setFont(new Font("Tahoma", Font.BOLD, 18));
		center.add(GlobalCustomerID);

		// Customer Name label
		JLabel Namelbl = new JLabel("Name: ");
		Namelbl.setForeground(Color.black);
		Namelbl.setBounds(50, 70, 200, 35);
		Namelbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		center.add(Namelbl);

		// Global customer Name
		JLabel GlobalName = new JLabel();
		GlobalName.setText(Global.currentUser.getName());
		GlobalName.setForeground(Color.black);
		GlobalName.setBounds(180, 70, 200, 35);
		GlobalName.setFont(new Font("Tahoma", Font.BOLD, 18));
		center.add(GlobalName);

		// Customer Mobile label
		JLabel Mobilelbl = new JLabel("Mobile: ");
		Mobilelbl.setForeground(Color.black);
		Mobilelbl.setBounds(50, 120, 200, 35);
		Mobilelbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		center.add(Mobilelbl);

		// Global customer Mobile
		JLabel GlobalMobile = new JLabel();
		GlobalMobile.setText(Global.currentUser.getMobile());
		GlobalMobile.setForeground(Color.black);
		GlobalMobile.setBounds(180, 120, 200, 35);
		GlobalMobile.setFont(new Font("Tahoma", Font.BOLD, 18));
		center.add(GlobalMobile);

		// Customer Email label
		JLabel Emaillbl = new JLabel("Email: ");
		Emaillbl.setForeground(Color.black);
		Emaillbl.setBounds(50, 170, 200, 35);
		Emaillbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		center.add(Emaillbl);

		// Global customer Email
		JLabel GlobalEmail = new JLabel();
		GlobalEmail.setText(Global.currentUser.getEmail());
		GlobalEmail.setForeground(Color.black);
		GlobalEmail.setBounds(180, 170, 200, 35);
		GlobalEmail.setFont(new Font("Tahoma", Font.BOLD, 18));
		center.add(GlobalEmail);

		// Customer Username label
		JLabel Usernamelbl = new JLabel("Username: ");
		Usernamelbl.setForeground(Color.black);
		Usernamelbl.setBounds(50, 220, 200, 35);
		Usernamelbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		center.add(Usernamelbl);

		// Global customer Username
		JLabel GlobalUsername = new JLabel();
		GlobalUsername.setText(Global.currentUser.getUsername());
		GlobalUsername.setForeground(Color.black);
		GlobalUsername.setBounds(180, 220, 200, 35);
		GlobalUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
		center.add(GlobalUsername);

		// Customer Password label
		JLabel Passwordlbl = new JLabel("Password: ");
		Passwordlbl.setForeground(Color.black);
		Passwordlbl.setBounds(50, 270, 200, 35);
		Passwordlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		center.add(Passwordlbl);

		// Global customer Password
		JLabel GlobalPassword = new JLabel();
		GlobalPassword.setText(Global.currentUser.getPassword());
		GlobalPassword.setForeground(Color.black);
		GlobalPassword.setBounds(180, 270, 200, 35);
		GlobalPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		center.add(GlobalPassword);

		// Customer Role label
		JLabel Rolelbl = new JLabel("Role: ");
		Rolelbl.setForeground(Color.black);
		Rolelbl.setBounds(50, 320, 200, 35);
		Rolelbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		center.add(Rolelbl);

		// Global customer Role
		JLabel GlobalRole = new JLabel();
		GlobalRole.setText(Global.currentUser.getRole());
		GlobalRole.setForeground(Color.black);
		GlobalRole.setBounds(180, 320, 200, 35);
		GlobalRole.setFont(new Font("Tahoma", Font.BOLD, 18));
		center.add(GlobalRole);

		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new ProfileGUI();

	}

}
