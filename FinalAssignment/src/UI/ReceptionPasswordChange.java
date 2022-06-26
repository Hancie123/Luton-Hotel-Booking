package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Libs.CustomerLibs2;
import Libs.Global;
import Libs.JDBCCustomer;
import Libs.ReceptionPasswordChangeJDBC;


///Main Class
public class ReceptionPasswordChange implements ActionListener {
	
	JFrame frame;
	JButton updatebtn;
	JTextField idtxt,usernametxt,passwordtxt;
	
	public ReceptionPasswordChange() {
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
		JLabel userlbl=new JLabel();
		userlbl.setText(Global.registrationUser.getUsername());
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
		
		JLabel idlbl=new JLabel("ID: ");
		idlbl.setForeground(Color.white);
		idlbl.setFont(new Font("Tahoma",Font.PLAIN,18));
		idlbl.setBounds(40,40,100,30);
		center.add(idlbl);
		
		idtxt=new JTextField();
		idtxt.setEnabled(false);
		idtxt.setText(Integer.toString(Global.registrationUser.getRegistration_ID()));
		idtxt.setBorder(BorderFactory.createLineBorder(Color.white,1));
		idtxt.setFont(new Font("Tahoma",Font.PLAIN,18));
		idtxt.setBounds(150,40,200,30);
		center.add(idtxt);
		
		JLabel usernamelbl=new JLabel("Username: ");
		usernamelbl.setForeground(Color.white);
		usernamelbl.setFont(new Font("Tahoma",Font.PLAIN,18));
		usernamelbl.setBounds(40,90,100,30);
		center.add(usernamelbl);
		
		usernametxt=new JTextField();
		usernametxt.setText(Global.registrationUser.getUsername());
		usernametxt.setBorder(BorderFactory.createLineBorder(Color.white,1));
		usernametxt.setFont(new Font("Tahoma",Font.PLAIN,18));
		usernametxt.setBounds(150,90,200,30);
		center.add(usernametxt);
		
		JLabel passwordlbl=new JLabel("Password: ");
		passwordlbl.setForeground(Color.white);
		passwordlbl.setFont(new Font("Tahoma",Font.PLAIN,18));
		passwordlbl.setBounds(40,140,100,30);
		center.add(passwordlbl);
		
		passwordtxt=new JTextField();
		passwordtxt.setText(Global.registrationUser.getPassword());
		passwordtxt.setBorder(BorderFactory.createLineBorder(Color.white,1));
		passwordtxt.setFont(new Font("Tahoma",Font.PLAIN,18));
		passwordtxt.setBounds(150,140,200,30);
		center.add(passwordtxt);
		
		
		updatebtn=new JButton("Change");
		updatebtn.addActionListener(this);
		updatebtn.setFocusable(false);
		updatebtn.setBackground(new Color(21,159,133));
		updatebtn.setForeground(Color.white);
		updatebtn.setBorder(BorderFactory.createLineBorder(new Color(21,159,133),1));
		updatebtn.setFont(new Font("Tahoma",Font.PLAIN,18));
		updatebtn.setBounds(170,200,110,30);
		center.add(updatebtn);
		
		
		
		
		
		frame.setVisible(true);
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==updatebtn) {
			CustomerLibs2 customer = new CustomerLibs2();
			
            customer.setRegistration_ID(Integer.parseInt(idtxt.getText()));			
			customer.setUsername(usernametxt.getText());
			customer.setPassword(passwordtxt.getText());

			ReceptionPasswordChangeJDBC jdbc3 = new ReceptionPasswordChangeJDBC();
			boolean result1 = jdbc3.update(customer);
			if (result1 == true) {
				
				ImageIcon i = new ImageIcon(getClass().getResource("5-stars.png"));
				JOptionPane.showMessageDialog(null, "Your password is changed!", "Customer Management", JOptionPane.WIDTH, i);
			} else {
				ImageIcon i = new ImageIcon(getClass().getResource("5-stars.png"));
				JOptionPane.showMessageDialog(null, "Error Occured!", "Customer Management", JOptionPane.WIDTH, i);
			}
			
			
		}
		
	}

	public static void main(String[] args) {
		new ReceptionPasswordChange();

	}

	

}
