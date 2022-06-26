package Trial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.mysql.cj.xdevapi.Statement;


public class GUIDemo implements ActionListener {
	
	//Control shift o to import library automatically
	
	JFrame frame;
	JLabel label, loginlbl, loginlbl1, label1, image, name;
	JPanel panel;
	JTextField txtField;
	JPasswordField txtField1;
	JButton btn, login;
	private JTable table;
	
	public GUIDemo() {
		frame=new JFrame();
		frame.setTitle("Register Password");
		frame.setSize(900,440);
		frame.setResizable(false);
		frame.setLocation(470,150);
		frame.getContentPane().setBackground(new Color(27, 188, 155));
		frame.getContentPane().setLayout(new BorderLayout());
		
		JPanel panel2=new JPanel();
		panel2.setLayout(new BorderLayout());
		frame.getContentPane().add(panel2, BorderLayout.CENTER);
		

		panel=new JPanel();
		panel.setPreferredSize(new Dimension(500,100));	
		panel.setBackground(new Color(238,238,228));
		panel.setLayout(null);
		panel2.add(panel, BorderLayout.CENTER);
		
		JPanel panel1=new JPanel();
		panel1.setBackground(new Color(21, 159, 133));
		panel1.setPreferredSize(new Dimension(100,80));
		frame.getContentPane().add(panel1, BorderLayout.NORTH);
		
		
		label=new JLabel("Register Username and Password",SwingConstants.CENTER);
		label.setPreferredSize(new Dimension(500,70));
		label.setBackground(new Color(21, 159, 133));
		label.setOpaque(true);
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setForeground(Color.WHITE);
		panel1.add(label);
		
		name=new JLabel("Set Username and Password", SwingConstants.CENTER);
		name.setIcon(new ImageIcon("nitesh.png"));
		name.setBounds(45,10,300,35);
		name.setBackground(new Color(70,195,219));
		name.setOpaque(true);
		name.setFont(new Font("Verdana", Font.PLAIN, 18));
		panel.add(name);
		
		loginlbl=new JLabel("Username:");
		loginlbl.setIcon(new ImageIcon("nitesh.png"));
		loginlbl.setBounds(10,70,200,35);
		loginlbl.setFont(new Font("Verdana", Font.BOLD, 18));
		panel.add(loginlbl);
		
		loginlbl1=new JLabel("Password:");
		loginlbl1.setBounds(10,120,200,35);
		loginlbl1.setFont(new Font("Verdana", Font.BOLD, 18));
		panel.add(loginlbl1);
		
		txtField=new JTextField(15);
		txtField.setBounds(130,70,200,35);
		txtField.setFont(new Font("Verdana", Font.BOLD, 18));
		txtField.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	             char c = e.getKeyChar();
	             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
	                  e.consume();  // if it's not a number, ignore the event
	             }
	         }
	      });
		panel.add(txtField);
		
		txtField1=new JPasswordField();
		txtField1.setFont(new Font("Verdana", Font.BOLD, 18));
		txtField1.setBounds(130,120,200,35);
		panel.add(txtField1);
		
		login=new JButton("Back to Login");
		login.setBorder(BorderFactory.createLoweredBevelBorder());
		login.setBounds(470,250,100,35);
		login.setBackground(new Color(21, 159, 133));
		login.setForeground(Color.WHITE);
		login.setFont(new Font("Verdana", Font.BOLD, 15));
		panel.add(login);
		
		image=new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("passwords122.jpg")).getImage();
		image.setIcon(new ImageIcon(img));
		image.setPreferredSize(new Dimension(500,400));
		panel2.add(image, BorderLayout.WEST);
		
		
		btn=new JButton("Register");
		btn.setBorder(BorderFactory.createLoweredBevelBorder());
		btn.setBounds(270,250,100,35);
		btn.setBackground(new Color(21, 159, 133));
		btn.setForeground(Color.WHITE);
		btn.setFont(new Font("Verdana", Font.BOLD, 15));
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				try {
					
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
				 
				 
				PreparedStatement ps= con.prepareStatement("insert into login(Name, Password)values (?,?);");
				 ps.setString(1,txtField.getText());
				 ps.setNString(2,txtField1.getText()); 
				int x=ps.executeUpdate();
				
				if(x>0) {
					JOptionPane.showMessageDialog(null,"Registered Name and Password Successfully");
				}
				
				else if(x==0) {
					JOptionPane.showMessageDialog(null,"Please type");
				}
				else
				JOptionPane.showMessageDialog(null,"Registration Failed");
				con.close();
				}
				catch(Exception e) {System.out.print(e);
			}
				}
		});
		panel.add(btn);
		
		label1=new JLabel("");
		label1.setBounds(270,300,300,35);
		label1.setFont(new Font("Verdana",Font.BOLD,10));
		panel.add(label1);
		
		
		

		frame.setVisible(true);
		
		
	}
	@Override
	public void actionPerformed (ActionEvent ae) {
		String user=txtField.getText();
		String password=txtField1.getText();
		
		if(user.equals("admin")&& password.equals("admin")) {
			label1.setText("Login in successfully");
		}
		
		
	}

	public static void main(String[] args) {
		new GUIDemo();

	}
}
