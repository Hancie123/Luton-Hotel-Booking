package ManagerUI;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import CustomersUI.customerDetails;
import EmployeesUI.EmployeesDetails;
import Libs.PanelRound;

public class admingSettingUI {
	
	JFrame frame;
	JLabel titlelbl;
	JPanel north, south;
	public admingSettingUI() {
		
		frame=new JFrame("Settings");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
		frame.setSize(550,600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		
		north=new JPanel();
		north.setBackground(new Color(21, 159, 133));
		north.setPreferredSize(new Dimension(100,100));
		frame.add(north, BorderLayout.NORTH);
		
		titlelbl=new JLabel("Settings",SwingConstants.CENTER);
		titlelbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("settings (2).png")));
		titlelbl.setFont(new Font("Verdana", Font.BOLD,25));
		titlelbl.setForeground(Color.white);
		titlelbl.setPreferredSize(new Dimension(400,90));
		north.add(titlelbl);
		
		
		JPanel center=new JPanel();
		center.setLayout(null);
		frame.add(center, BorderLayout.CENTER);
		
		
		PanelRound addCustomerPanel=new PanelRound();
		addCustomerPanel.setBounds(50,20,200,200);
		addCustomerPanel.setRoundBottomRight(100);
		addCustomerPanel.setRoundBottomLeft(100);
		addCustomerPanel.setRoundTopLeft(100);
		addCustomerPanel.setRoundTopRight(100);
		addCustomerPanel.setBackground(new Color(21, 159, 133));
		addCustomerPanel.setLayout(null);
		addCustomerPanel.setPreferredSize(new Dimension(100,200));
		center.add(addCustomerPanel);
		
		JLabel image=new JLabel();
		Image img=new ImageIcon(this.getClass().getResource("add-user.png")).getImage();
		image.setIcon(new ImageIcon(img));
		image.setBounds(40,20,128,128);
		addCustomerPanel.add(image);
		
		JLabel title1=new JLabel("Manager Customers");
		title1.setFont(new Font("Verdana", Font.PLAIN,15));
		title1.setBounds(25,150,190,35);
		addCustomerPanel.add(title1);
		addCustomerPanel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
					new customerDetails();
			}
		});
		
		PanelRound modifyCustomerPanel=new PanelRound();
		modifyCustomerPanel.setBounds(290,20,200,200);
		modifyCustomerPanel.setRoundBottomRight(100);
		modifyCustomerPanel.setRoundBottomLeft(100);
		modifyCustomerPanel.setRoundTopLeft(100);
		modifyCustomerPanel.setRoundTopRight(100);
		modifyCustomerPanel.setBackground(new Color(21, 159, 133));
		modifyCustomerPanel.setLayout(null);
		modifyCustomerPanel.setPreferredSize(new Dimension(100,200));
		center.add(modifyCustomerPanel);
		
		JLabel image1=new JLabel();
		Image img1=new ImageIcon(this.getClass().getResource("update.png")).getImage();
		image1.setIcon(new ImageIcon(img1));
		image1.setBounds(40,20,128,128);
		modifyCustomerPanel.add(image1);
		
		JLabel title2=new JLabel("Change Password");
		title2.setFont(new Font("Verdana", Font.PLAIN,15));
		title2.setBounds(30,150,150,35);
		modifyCustomerPanel.add(title2);
		modifyCustomerPanel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
					new ManagerPasswordChange();
			}
		});
		
		PanelRound addReceptionPanel=new PanelRound();
		addReceptionPanel.setBounds(50,240,200,200);
		addReceptionPanel.setRoundBottomRight(100);
		addReceptionPanel.setRoundBottomLeft(100);
		addReceptionPanel.setRoundTopLeft(100);
		addReceptionPanel.setRoundTopRight(100);
		addReceptionPanel.setBackground(new Color(21, 159, 133));
		addReceptionPanel.setLayout(null);
		addReceptionPanel.setPreferredSize(new Dimension(100,200));
		center.add(addReceptionPanel);
		
		JLabel image2=new JLabel();
		Image img2=new ImageIcon(this.getClass().getResource("add-user.png")).getImage();
		image2.setIcon(new ImageIcon(img2));
		image2.setBounds(40,20,128,128);
		addReceptionPanel.add(image2);
		
		JLabel title3=new JLabel("View All Employees");
		title3.setFont(new Font("Verdana", Font.PLAIN,15));
		title3.setBounds(25,150,190,35);
		addReceptionPanel.add(title3);
		addReceptionPanel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
					new EmployeesDetails();
			}
		});
		
		PanelRound modifyReceptionPanel=new PanelRound();
		modifyReceptionPanel.setBounds(290,240,200,200);
		modifyReceptionPanel.setRoundBottomRight(100);
		modifyReceptionPanel.setRoundBottomLeft(100);
		modifyReceptionPanel.setRoundTopLeft(100);
		modifyReceptionPanel.setRoundTopRight(100);
		modifyReceptionPanel.setBackground(new Color(21, 159, 133));
		modifyReceptionPanel.setLayout(null);
		modifyReceptionPanel.setPreferredSize(new Dimension(100,200));
		center.add(modifyReceptionPanel);
		
		JLabel image3=new JLabel();
		Image img3=new ImageIcon(this.getClass().getResource("update.png")).getImage();
		image3.setIcon(new ImageIcon(img3));
		image3.setBounds(40,20,128,128);
		modifyReceptionPanel.add(image3);
		
		JLabel title4=new JLabel("Update My Profile");
		title4.setFont(new Font("Verdana", Font.PLAIN,15));
		title4.setBounds(30,150,150,35);
		modifyReceptionPanel.add(title4);
		modifyReceptionPanel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
					new customerDetails();
			}
		});
		

		
		
		
		
		frame.setVisible(true);
		
		
		
	}

	public static void main(String[] args) {
		new admingSettingUI();

	}

}
