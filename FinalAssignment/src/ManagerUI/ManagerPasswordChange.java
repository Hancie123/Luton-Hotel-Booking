package ManagerUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


///Main Class
public class ManagerPasswordChange {
	
	JFrame frame;
	JButton updatebtn;
	
	public ManagerPasswordChange() {
		frame=new JFrame("Update Password");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
		frame.setSize(450,550);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		//**********************North Panel*************************
		JPanel north=new JPanel();
		north.setLayout(null);
		north.setBackground(new Color(21,159,133));
		north.setPreferredSize(new Dimension(100,200));
		frame.add(north,BorderLayout.NORTH);
		
		//**********************Image Code****************************
		JLabel img=new JLabel();
		img.setIcon(new javax.swing.ImageIcon(getClass().getResource("add-user.png")));
		img.setBounds(150,20,128,128);
		north.add(img);
		
		//*******************Global Username*******************************8
		JLabel userlbl=new JLabel("Hancie Phago");
		userlbl.setForeground(Color.white);
		userlbl.setFont(new Font("Tahoma",Font.PLAIN,18));
		userlbl.setBounds(160,150,200,30);
		north.add(userlbl);
		
		//****************************Center Panel********************
		JPanel center=new JPanel();
		center.setLayout(null);
		center.setBackground(new Color(106,101,101));
		center.setPreferredSize(new Dimension(100,200));
		frame.add(center,BorderLayout.CENTER);
		
		JLabel usernamelbl=new JLabel("Username: ");
		usernamelbl.setForeground(Color.white);
		usernamelbl.setFont(new Font("Tahoma",Font.PLAIN,18));
		usernamelbl.setBounds(40,40,100,30);
		center.add(usernamelbl);
		
		JTextField usernametxt=new JTextField();
		usernametxt.setBorder(BorderFactory.createLineBorder(Color.white,1));
		usernametxt.setFont(new Font("Tahoma",Font.PLAIN,18));
		usernametxt.setBounds(150,40,200,30);
		center.add(usernametxt);
		
		JLabel passwordlbl=new JLabel("Password: ");
		passwordlbl.setForeground(Color.white);
		passwordlbl.setFont(new Font("Tahoma",Font.PLAIN,18));
		passwordlbl.setBounds(40,110,100,30);
		center.add(passwordlbl);
		
		JTextField passwordtxt=new JTextField();
		passwordtxt.setBorder(BorderFactory.createLineBorder(Color.white,1));
		passwordtxt.setFont(new Font("Tahoma",Font.PLAIN,18));
		passwordtxt.setBounds(150,110,200,30);
		center.add(passwordtxt);
		
		
		updatebtn=new JButton("Change");
		updatebtn.setFocusable(false);
		updatebtn.setBackground(new Color(21,159,133));
		updatebtn.setForeground(Color.white);
		updatebtn.setBorder(BorderFactory.createLineBorder(new Color(21,159,133),1));
		updatebtn.setFont(new Font("Tahoma",Font.PLAIN,18));
		updatebtn.setBounds(170,190,110,30);
		center.add(updatebtn);
		
		
		
		
		
		frame.setVisible(true);
		
		
		
	}

	public static void main(String[] args) {
		new ManagerPasswordChange();

	}

}
