package UI;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

import Libs.CustomerLibs;
import Libs.CustomerLibs2;
import Libs.CustomerLoginLibs;
import Libs.CustomerLoginLibs2;
import Libs.Global;
import ManagerUI.AdminDashBoard;
import staff.BarDashboard;
import staff.RestaurantDashboard;

public class LoginWindow {

	

	JFrame frame;
	JLabel label, loginlbl, loginlbl1, label1, image, name;
	JPanel panel;
	JTextField txtField;
	JPasswordField txtField1;
	JButton btn, reset, login1;

	JRadioButton radioBtn;

	public LoginWindow() {
		frame = new JFrame();
		frame.setTitle("Login Window");
		frame.setSize(900, 440);
		frame.setResizable(false);
		frame.setLocation(470, 150);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
		frame.getContentPane().setBackground(new Color(27, 188, 155));
		frame.getContentPane().setLayout(new BorderLayout());

		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		frame.getContentPane().add(panel2, BorderLayout.CENTER);

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 100));
		panel.setBackground(new Color(238, 238, 228));
		panel.setLayout(null);
		panel2.add(panel, BorderLayout.CENTER);

		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(21, 159, 133));
		panel1.setPreferredSize(new Dimension(100, 80));
		frame.getContentPane().add(panel1, BorderLayout.NORTH);

		label = new JLabel("Enter Username and Password", SwingConstants.CENTER);
		label.setPreferredSize(new Dimension(500, 70));
		label.setBackground(new Color(21, 159, 133));
		label.setOpaque(true);
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setForeground(Color.WHITE);
		panel1.add(label);

		name = new JLabel("Enter Username and Password", SwingConstants.CENTER);
		name.setIcon(new ImageIcon("nitesh.png"));
		name.setBounds(45, 10, 300, 35);
		name.setBackground(new Color(70, 195, 219));
		name.setOpaque(true);
		name.setFont(new Font("Verdana", Font.PLAIN, 18));
		panel.add(name);

		loginlbl = new JLabel("Username:");
		loginlbl.setIcon(new ImageIcon("nitesh.png"));
		loginlbl.setBounds(10, 90, 200, 35);
		loginlbl.setFont(new Font("Verdana", Font.BOLD, 18));
		panel.add(loginlbl);

		loginlbl1 = new JLabel("Password:");
		loginlbl1.setBounds(10, 167, 200, 35);
		loginlbl1.setFont(new Font("Verdana", Font.BOLD, 18));
		panel.add(loginlbl1);

		txtField = new JTextField(15);
		txtField.setBorder(new MatteBorder(0, 0, 2, 0, Color.red));
		String html2 = "<html><p><font color=\"#800080\" " + "size=\"4\" face=\"Verdana\">Please select your username!"
				+ "</font></p></html>";
		txtField.setToolTipText(html2);
		txtField.setBounds(130, 90, 200, 35);
		txtField.setFont(new Font("Verdana", Font.BOLD, 18));
		panel.add(txtField);

		txtField1 = new JPasswordField();
		txtField1.setBorder(new MatteBorder(0, 0, 2, 0, Color.red));
		String html1 = "<html><p><font color=\"#800080\" " + "size=\"4\" face=\"Verdana\">Please select your password!"
				+ "</font></p></html>";
		txtField1.setToolTipText(html1);
		txtField1.setFont(new Font("Verdana", Font.BOLD, 18));
		txtField1.setBounds(130, 170, 200, 35);
		panel.add(txtField1);

		Object[] data = { "Manager", "Customer", "Receptionist" };
		String html = "<html><p><font color=\"#800080\" " + "size=\"4\" face=\"Verdana\">Please select your role!"
				+ "</font></p></html>";

		image = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("passwords122.jpg")).getImage();
		image.setIcon(new ImageIcon(img));
		image.setPreferredSize(new Dimension(500, 400));
		panel2.add(image, BorderLayout.WEST);

		login1 = new JButton("Register");
		login1.setFocusable(false);
		login1.setBorder(BorderFactory.createLoweredBevelBorder());
		login1.setBounds(170, 270, 110, 35);
		login1.setBackground(new Color(21, 159, 133));
		login1.setForeground(Color.WHITE);
		login1.setFont(new Font("Verdana", Font.BOLD, 15));
		login1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {

				if (ae.getSource() == login1) {
					frame.dispose();
					new RegistrationForm();

				}
			}

		});
		panel.add(login1);

		reset = new JButton("Clear");
		reset.setFocusable(false);
		reset.setBorder(BorderFactory.createLoweredBevelBorder());
		reset.setBounds(90, 270, 70, 35);
		reset.setBackground(new Color(21, 159, 133));
		reset.setForeground(Color.WHITE);
		reset.setFont(new Font("Verdana", Font.BOLD, 15));
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == reset) {
					txtField.setText("");
					txtField1.setText("");
				}
			}

			public void MouseClicked(MouseEvent ae) {
				if (ae.getSource() == reset) {
					reset.setBackground(Color.YELLOW);
				}
			}

		});
		panel.add(reset);

		btn = new JButton("Login");
		btn.setFocusable(false);
		btn.setBorder(BorderFactory.createLoweredBevelBorder());
		btn.setBounds(10, 270, 70, 35);
		btn.setBackground(new Color(21, 159, 133));
		btn.setForeground(Color.WHITE);
		btn.setFont(new Font("Verdana", Font.BOLD, 15));
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				if (txtField1.getText().trim().isEmpty() && txtField1.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter username and password");
				}

				else if (ae.getSource() == btn) {
					
					CustomerLibs2 user1 = new CustomerLibs2();
					
					user1.setUsername(txtField.getText());
					user1.setPassword(txtField1.getText());
					user1 = new CustomerLoginLibs2().login(user1);
					
					Global.registrationUser=user1;
					if (user1.getRegistration_ID() > 0) {
						ImageIcon i=new ImageIcon(getClass().getResource("5-stars.png"));
						JOptionPane.showMessageDialog(null, "Welcome "+user1.getName(),"Login Window",JOptionPane.WIDTH,i);
						
						if (user1.getRole().equals("Manager")) {
							new AdminDashBoard();
							frame.dispose();
						} else if (user1.getRole().equals("Receptionist")) {
							new ReceptionDashBoard();
							frame.dispose();
						}
						
						else if (user1.getRole().equals("Bar Staff")) {
							new BarDashboard();
							frame.dispose();
						}
						
						else if (user1.getRole().equals("Restaurant Staff")) {
							new RestaurantDashboard();
							frame.dispose();
						}
						
						
						
					}
					
					else if (ae.getSource() == btn) {

					CustomerLibs user = new CustomerLibs();
					user.setUsername(txtField.getText());
					user.setPassword(txtField1.getText());
					user = new CustomerLoginLibs().login(user);
					
					
					Global.currentUser=user;
					if (user.getCustomer_ID() > 0) {
						ImageIcon i2=new ImageIcon(getClass().getResource("5-stars.png"));
						JOptionPane.showMessageDialog(null, "Welcome "+user.getName(),"Login Window",JOptionPane.WIDTH,i2);
						
						}  if (user.getRole().equals("Customer")) {																					
							frame.dispose();
							new CustomerDashBoard();
							
						} else if (user.getRole().equals("Corp Client")) {
							new CorporateDashBoard();
							frame.dispose();
						}
					} else {

						JOptionPane.showMessageDialog(null, "Incorrect Username and window");
					}

				}
			}
		});

		panel.add(btn);

		radioBtn = new JRadioButton("Show Password");
		radioBtn.setToolTipText("Click here to show your password!");
		UIManager.put("ToolTip.background", Color.ORANGE);
		UIManager.put("ToolTip.foreground", Color.BLACK);
		UIManager.put("ToolTip.font", new Font("Arial", Font.PLAIN, 14));
		radioBtn.setBounds(130, 205, 150, 35);
		radioBtn.setFont(new Font("Verdana", Font.PLAIN, 12));
		radioBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				// show password chars
				if (radioBtn.isSelected()) {
					txtField1.setEchoChar((char) 0);
				}
				// hide password chars
				else {
					txtField1.setEchoChar('*');
				}
			}
		});
		panel.add(radioBtn);

		frame.setVisible(true);

	}
	
	public static void main(String[] args) {
		new LoginWindow();

	}

}
