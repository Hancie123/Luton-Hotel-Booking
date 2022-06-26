package UI;

//Author: Hancie Phago

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.mysql.cj.xdevapi.Schema.Validation;
import com.toedter.calendar.JDateChooser;
import regularExpression.RegexExpression;
import Libs.CustomerLibs;
import Libs.JDBCCustomer;
import Libs.MaterialTabbed;

public class RegistrationForm implements ActionListener {
	private static final Integer Interger = null;
	JFrame frame;
	JPanel panel, panel1, panel3;

	JTextField nametxt, mobiletxt, emailtxt, addresstxt, usernametxt, credittxt;
	JComboBox titlebox, genderCombo, roleCombo;
	JPasswordField passwordtxt;
	JDateChooser DOBtxt;

	JButton register, receptionregister, managerRegister, customerClear, Clearbtn, registerbtn;
	MaterialTabbed tab;

	public RegistrationForm() {
		frame = new JFrame();
		frame.setTitle("Create an Account");
		frame.setResizable(true);
		frame.setSize(950, 500);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setLayout(new BorderLayout());

		panel = new JPanel();
		panel.setBackground(new Color(21, 159, 133));
		panel.setPreferredSize(new Dimension(0, 90));
		frame.add(panel, BorderLayout.NORTH);

		panel1 = new JPanel();
		panel1.setBackground(new Color(45, 64, 89));
		panel1.setPreferredSize(new Dimension(600, 90));
		frame.add(panel1, BorderLayout.WEST);

		JLabel background = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("Hotel Booking-bro.png")).getImage();
		background.setIcon(new ImageIcon(img1));
		background.setBounds(0, 0, 600, 600);
		panel1.add(background);

		tab = new MaterialTabbed();
		tab.setPreferredSize(new Dimension(1000, 80));
		tab.setFont(new Font("Verdana", Font.BOLD, 15));
		frame.add(tab, BorderLayout.CENTER);

		JPanel main = new JPanel();
		main.setLayout(null);
		tab.add("Customer", main);

		JPanel main1 = new JPanel();
		main1.setBackground(new Color(21, 159, 133));
		main1.setBounds(0, 0, 950, 70);
		main.add(main1);

		JLabel customer = new JLabel("Fill Customer Details", SwingConstants.CENTER);
		customer.setForeground(new Color(255, 255, 255));
		customer.setPreferredSize(new Dimension(400, 60));
		customer.setFont(new Font("Verdana", Font.PLAIN, 25));
		customer.setBounds(10, 80, 200, 35);
		main1.add(customer);

		JLabel titlelbl = new JLabel("Title: ");
		titlelbl.setBounds(50, 120, 230, 25);
		titlelbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		main.add(titlelbl);

		String title1[] = { "Mr.", "Mrs.", "Miss." };
		titlebox = new JComboBox(title1);
		titlebox.setBounds(190, 120, 230, 30);
		titlebox.setFont(new Font("Verdana", Font.PLAIN, 20));
		main.add(titlebox);

		JLabel Namelbl = new JLabel("Name: ");
		Namelbl.setBounds(50, 180, 230, 25);
		Namelbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		main.add(Namelbl);

		nametxt = new JTextField();
		nametxt.setBounds(190, 180, 230, 30);
		nametxt.setFont(new Font("Verdana", Font.PLAIN, 20));
		main.add(nametxt);

		JLabel Genderlbl = new JLabel("Gender: ");
		Genderlbl.setBounds(50, 240, 230, 25);
		Genderlbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		main.add(Genderlbl);

		String G1[] = { "Male", "Female", "Other" };
		genderCombo = new JComboBox(G1);
		genderCombo.setBounds(190, 240, 230, 30);
		genderCombo.setFont(new Font("Verdana", Font.PLAIN, 20));
		main.add(genderCombo);

		JLabel DOBlbl = new JLabel("DOB: ");
		DOBlbl.setBounds(50, 300, 230, 25);
		DOBlbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		main.add(DOBlbl);

		DOBtxt = new JDateChooser();
		DOBtxt.setDateFormatString("yyyy-MM-dd");
		DOBtxt.setBounds(190, 300, 230, 30);
		DOBtxt.setFont(new Font("Verdana", Font.PLAIN, 20));
		main.add(DOBtxt);

		JLabel Mobilelbl = new JLabel("Mobile No: ");
		Mobilelbl.setBounds(50, 360, 230, 25);
		Mobilelbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		main.add(Mobilelbl);

		mobiletxt = new JTextField();
		mobiletxt.setBounds(190, 360, 230, 30);
		mobiletxt.setFont(new Font("Verdana", Font.PLAIN, 20));
		main.add(mobiletxt);

		JLabel Emaillbl = new JLabel("Email: ");
		Emaillbl.setBounds(50, 420, 230, 25);
		Emaillbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		main.add(Emaillbl);

		emailtxt = new JTextField();
		emailtxt.setBounds(190, 420, 230, 30);
		emailtxt.setFont(new Font("Verdana", Font.PLAIN, 20));
		main.add(emailtxt);

		JLabel Addresslbl = new JLabel("Address: ");
		Addresslbl.setBounds(480, 120, 230, 25);
		Addresslbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		main.add(Addresslbl);

		addresstxt = new JTextField();
		addresstxt.setBounds(630, 120, 230, 30);
		addresstxt.setFont(new Font("Verdana", Font.PLAIN, 20));
		main.add(addresstxt);

		JLabel Usernamelbl = new JLabel("Username: ");
		Usernamelbl.setBounds(480, 180, 230, 25);
		Usernamelbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		main.add(Usernamelbl);

		usernametxt = new JTextField();
		usernametxt.setBounds(630, 180, 230, 30);
		usernametxt.setFont(new Font("Verdana", Font.PLAIN, 20));
		main.add(usernametxt);

		JLabel Passwordlbl = new JLabel("Password: ");
		Passwordlbl.setBounds(480, 240, 230, 25);
		Passwordlbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		main.add(Passwordlbl);

		passwordtxt = new JPasswordField();
		passwordtxt.setBounds(630, 240, 230, 30);
		passwordtxt.setFont(new Font("Verdana", Font.PLAIN, 20));
		main.add(passwordtxt);

		JLabel Creditlbl = new JLabel("Credit No: ");
		Creditlbl.setBounds(480, 300, 230, 25);
		Creditlbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		main.add(Creditlbl);

		credittxt = new JTextField();
		credittxt.setBounds(630, 300, 230, 30);
		credittxt.setFont(new Font("Verdana", Font.PLAIN, 20));
		main.add(credittxt);

		JLabel Rolelbl = new JLabel("Role: ");
		Rolelbl.setBounds(480, 360, 230, 25);
		Rolelbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		main.add(Rolelbl);

		Object[] R1 = { "Customer", "Corp Client" };
		roleCombo = new JComboBox(R1);
		roleCombo.setBounds(630, 360, 230, 30);
		roleCombo.setFont(new Font("Verdana", Font.PLAIN, 20));
		main.add(roleCombo);

		register = new JButton("Register");
		register.setFocusable(false);
		register.setBounds(230, 500, 130, 30);
		register.setBackground(new Color(21, 159, 133));
		register.setForeground(Color.WHITE);
		register.setFont(new Font("Verdana", Font.PLAIN, 20));
		register.addActionListener(this);
		main.add(register);
		register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				RegexExpression val = new RegexExpression();

				if (e.getSource() == register) {

					String Name = nametxt.getText();
					boolean resultFName = val.Name(Name);
					if (resultFName == true) {
						
						String Gender = genderCombo.getSelectedItem().toString();
						boolean Gender1 = val.Gender(Gender);
						if (Gender1 == true) {
							
							String number = mobiletxt.getText();
							boolean result = val.Phone(number);
							if (result == true) {
								
								String email = emailtxt.getText();
								boolean emailresult = val.Email(email);
								if (emailresult == true) {
									
									String username=usernametxt.getText();
									boolean resultusername=val.UserName(username);
									if(resultusername==true) {
										
										String password=passwordtxt.getText();
										boolean resultpassword=val.Password(password);
										if(resultpassword==true) {
											
											
											
											
										}
										else {
											JOptionPane.showMessageDialog(null, "Please enter proper password!");
										}
										
										
									}
									else {
										JOptionPane.showMessageDialog(null, "Please enter proper Username!");
									}
									
								}
								else {
									JOptionPane.showMessageDialog(null, "Invalid Email");
								}
								
								
							}
							else {
								JOptionPane.showMessageDialog(null, "Invalid Mobile Number");
							}
	

					}
						else {
							JOptionPane.showMessageDialog(null, "Invalid Gender");
						}

					

					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid Name");
					}
					

				}

			}

		});

		customerClear = new JButton("Clear");
		customerClear.setBounds(390, 500, 130, 30);
		customerClear.setBackground(new Color(21, 159, 133));
		customerClear.setForeground(Color.WHITE);
		customerClear.setFont(new Font("Verdana", Font.PLAIN, 20));
		customerClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

			}

		});
		main.add(customerClear);

		JButton loginbtn = new JButton("Back to login");
		loginbtn.setBounds(550, 500, 170, 30);
		loginbtn.setBackground(new Color(21, 159, 133));
		loginbtn.setForeground(Color.WHITE);
		loginbtn.setFont(new Font("Verdana", Font.PLAIN, 20));
		loginbtn.addActionListener(this);
		main.add(loginbtn);
		loginbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new LoginWindow();

			}

		});

		JPanel customersouth = new JPanel();
		customersouth.setBounds(0, 600, 1000, 120);
		customersouth.setBackground(new Color(21, 159, 133));
		main.add(customersouth);

		JLabel customertitlelbl = new JLabel("LUTON HOTEL CUSTOMER REGISTRATION", SwingConstants.CENTER);
		customertitlelbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		customertitlelbl.setForeground(Color.WHITE);
		customersouth.add(customertitlelbl);

		JLabel title = new JLabel("CUSTOMER REGISTRATION", SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Verdana", Font.BOLD, 25));
		title.setPreferredSize(new Dimension(400, 80));
		panel.add(title);

		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == register) {

			if (nametxt.getText().trim().isEmpty() || addresstxt.getText().trim().isEmpty()
					|| mobiletxt.getText().trim().isEmpty() || emailtxt.getText().trim().isEmpty()
					|| usernametxt.getText().trim().isEmpty() || passwordtxt.getText().trim().isEmpty()
					|| credittxt.getText().trim().isEmpty()) {
				ImageIcon i2 = new ImageIcon(getClass().getResource("5-stars.png"));
				JOptionPane.showMessageDialog(null, "Please fill all the details!", "Luton Hotel System",
						JOptionPane.WIDTH, i2);
			}

			else {

				// save
				String title = titlebox.getSelectedItem().toString();
				String name = nametxt.getText();
				String gender = genderCombo.getSelectedItem().toString();
				String DOB = ((JTextField) DOBtxt.getDateEditor().getUiComponent()).getText();
				String mobile = mobiletxt.getText();
				String email = emailtxt.getText();
				String address = addresstxt.getText();
				String username = usernametxt.getText();
				String password = passwordtxt.getText();
				String credit = credittxt.getText();
				String role = roleCombo.getSelectedItem().toString();

				CustomerLibs customer = new CustomerLibs();

				customer.setTitle(title);
				customer.setName(name);
				customer.setGender(gender);
				customer.setDOB(DOB);
				customer.setMobile(mobile);
				customer.setEmail(email);
				customer.setAddress(address);
				customer.setUsername(username);
				customer.setPassword(password);
				customer.setCredit_Number(credit);
				customer.setRole(role);

				JDBCCustomer jdbc = new JDBCCustomer();
				boolean result = jdbc.insert(customer);
				if (result == true) {

					ImageIcon i = new ImageIcon(getClass().getResource("5-stars.png"));
					JOptionPane.showMessageDialog(null, "You have registered your account successfully!",

							"Luton Hotel System", JOptionPane.WIDTH, i);
				}

				else {
					ImageIcon i = new ImageIcon(getClass().getResource("5-stars.png"));
					JOptionPane.showMessageDialog(null, "Error Occured!", "Luton Hotel System", JOptionPane.WIDTH, i);
				}

			}
		}

	}

	public static void main(String[] args) {
		new RegistrationForm();

	}

}
