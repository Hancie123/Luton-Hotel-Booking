package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CreateAccount {
	
	JFrame frame;
	JLabel pic,background, name, username, email, password, role;
	JPanel panel1;
	JTextField nameField, usernameField, emailField ;
	JComboBox roleCombo;
	JPasswordField passwordField;
	JButton register, login;
	
	public CreateAccount() {
		frame=new JFrame();
		frame.setTitle("Create an Account");
		frame.setResizable(true);
		frame.setSize(950,500);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		pic=new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("logo 100px.png")).getImage();
		pic.setIcon(new ImageIcon(img));
		pic.setBounds(630,0,120,90);
		frame.add(pic);
		
		background=new JLabel("");
		Image img1=new ImageIcon(this.getClass().getResource("Profile Interface-bro.png")).getImage();
		background.setIcon(new ImageIcon(img1));
		background.setBounds(0,0,550,450);
		frame.add(background);
		
		name=new JLabel("Full-Name: ");
		name.setBounds(500,120,150,35);
		name.setFont(new Font("Verdana", Font.BOLD, 15));
		frame.add(name);
		
		nameField=new JTextField();
		nameField.setBounds(600,125,230,25);
		nameField.setFont(new Font("Verdana", Font.BOLD, 15));
		frame.add(nameField);
		
		username=new JLabel("Username: ");
		username.setBounds(500,160,150,35);
		username.setFont(new Font("Verdana", Font.BOLD, 15));
		frame.add(username);
		
		usernameField=new JTextField();
		usernameField.setBounds(600,165,230,25);
		usernameField.setFont(new Font("Verdana", Font.BOLD, 15));
		frame.add(usernameField);
		
		email=new JLabel("Email: ");
		email.setBounds(500,200,150,35);
		email.setFont(new Font("Verdana", Font.BOLD, 15));
		frame.add(email);
		
		emailField=new JTextField();
		emailField.setBounds(600,205,230,25);
		emailField.setFont(new Font("Verdana", Font.BOLD, 15));
		frame.add(emailField);
		
		role=new JLabel("Role: ");
		role.setBounds(500,240,150,35);
		role.setFont(new Font("Verdana", Font.BOLD, 15));
		frame.add(role);
		
		String role1[]= {"Manager", "Staff" };
		roleCombo=new JComboBox(role1);
		roleCombo.setBounds(600,245,150,25);
		roleCombo.setFont(new Font("Verdana", Font.BOLD, 15));
		
		frame.add(roleCombo);
		
		password=new JLabel("Password: ");
		password.setBounds(500,280,180,35);
		password.setFont(new Font("Verdana", Font.BOLD, 15));
		frame.add(password);
		
		passwordField=new JPasswordField();
		passwordField.setBounds(600,285,230,25);
		passwordField.setFont(new Font("Verdana", Font.BOLD, 15));
		frame.add(passwordField);
		
		register=new JButton("Register");
		register.setBounds(530,340,120,25);
		register.setFont(new Font("Verdana", Font.BOLD, 15));
		register.setBackground(new Color(70,195,219));
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String value = (String) roleCombo.getSelectedItem(); // get the selected item in the combobox
		        switch(value){
		        case "Manager":
		            ReceptionDashBoard b1 = new ReceptionDashBoard(); // call the class
		             // set the jframe to visible 
		            break;
		        case "Staff":
		            LoginWindow b2 = new LoginWindow();
		           
		            break;
		        
		        }          	
			}
	
			});
		frame.add(register);
		
		login=new JButton("Back to Login");
		login.setBounds(670,340,160,25);
		login.setFont(new Font("Verdana", Font.BOLD, 15));
		login.setBackground(new Color(70,195,219));
		frame.add(login);
		
		
		panel1=new JPanel();
		panel1.setBackground(new Color(70,195,219));
		panel1.setBounds(0,440,950,34);
		frame.add(panel1);
		
		
		
		
		frame.setVisible(true);
		
		
		
	}

	public static void main(String[] args) {
		new CreateAccount();

	}

}
