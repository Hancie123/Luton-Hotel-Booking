package staff;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import Libs.BarLibs;
import Libs.Global;
import Libs.JDBCBar;
import UI.LoginWindow;

public class BarDashboard {
	JButton orderbtn;
	JTextField totalamounttxt,bookingidtxt;
	JCheckBox espresso,americano,cappucino,latte,mocha,chocolate,od,mt,sign,label,vat,
	gin,wine,tuborg,gorkha,nepalice,carlsberg,barhasinghe;
	JComboBox BookingCombo;

	public BarDashboard() {
		JFrame frame = new JFrame("Bar Dashboard");
		frame.setSize(1000, 750);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
		frame.setLayout(new BorderLayout());

// ***************North Panel***********
		JPanel north = new JPanel();
		north.setLayout(null);
		north.setPreferredSize(new Dimension(100, 120));
		north.setBackground(new Color(21, 159, 133));
		frame.add(north, BorderLayout.NORTH);

		JLabel title = new JLabel("Luton Hotel System");
		title.setBounds(50, 10, 250, 35);
		title.setFont(new Font("Times New Roman", Font.BOLD, 29));
		title.setForeground(Color.white);
		north.add(title);

		JLabel subtitle = new JLabel("New Baneshwor, Kathmandu");
		subtitle.setBounds(50, 40, 250, 35);
		subtitle.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		subtitle.setForeground(Color.white);
		north.add(subtitle);

		JLabel subtitle1 = new JLabel("Email:luton@gmail.com");
		subtitle1.setBounds(50, 60, 250, 35);
		subtitle1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		subtitle1.setForeground(Color.white);
		north.add(subtitle1);

		JLabel subtitle2 = new JLabel("Tel: 534788");
		subtitle2.setBounds(50, 80, 250, 35);
		subtitle2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		subtitle2.setForeground(Color.white);
		north.add(subtitle2);
		
		JLabel menutitle = new JLabel("Bar Dashboard");
		menutitle.setBorder(new MatteBorder(0, 0, 4, 0, Color.RED));
		menutitle.setForeground(Color.white);
		menutitle.setBounds(600, 40, 270, 40);
		menutitle.setFont(new Font("Times New Roman", Font.BOLD, 40));
		north.add(menutitle);
		
		JLabel usertitle=new JLabel("Welcome: ");		
		usertitle.setFont(new Font("Times New Roman",Font.PLAIN,18));
		usertitle.setForeground(Color.white);
		usertitle.setBounds(1330,20,90,35);
		north.add(usertitle);
		
		JLabel usertitle1=new JLabel();
		usertitle1.setText(Global.registrationUser.getUsername());
		usertitle1.setFont(new Font("Times New Roman",Font.PLAIN,18));
		usertitle1.setForeground(Color.white);
		usertitle1.setBounds(1410,20,90,35);
		north.add(usertitle1);
		
		JButton logoutbtn = new JButton("Logout");
		logoutbtn.setBounds(1330, 70, 180, 30);
		logoutbtn.setFocusable(false);
		logoutbtn.setBackground(new Color(106, 101, 101));
		logoutbtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		logoutbtn.setForeground(Color.white);
		north.add(logoutbtn);
		logoutbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new LoginWindow();
				
			}
			
			
			
		});
		
		

        // ***************Center Panel***********
		JPanel center = new JPanel();
		center.setLayout(null);
		center.setPreferredSize(new Dimension(100, 120));
		frame.add(center, BorderLayout.CENTER);

		

		JLabel coffee = new JLabel("Coffee", JLabel.CENTER);
		coffee.setBounds(150, 80, 118, 35);
		coffee.setBorder(new MatteBorder(0,0,4,0,Color.red));
		coffee.setFont(new Font("Times New Roman", Font.BOLD, 35));
		center.add(coffee);

		espresso = new JCheckBox("Espresso        -----------------------Rs: 200");
		espresso.setBounds(50, 130, 350, 35);
		espresso.setFocusable(false);
		espresso.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		center.add(espresso);

		americano = new JCheckBox("Americano     -----------------------Rs: 180");
		americano.setBounds(50, 170, 350, 35);
		americano.setFocusable(false);
		americano.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		center.add(americano);

		cappucino = new JCheckBox("Cappucino     -----------------------Rs: 250");
		cappucino.setBounds(50, 210, 350, 35);
		cappucino.setFocusable(false);
		cappucino.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		center.add(cappucino);

		latte = new JCheckBox("Cafe Latte      -----------------------Rs: 180");
		latte.setBounds(50, 250, 350, 35);
		latte.setFocusable(false);
		latte.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		center.add(latte);

		mocha = new JCheckBox("Cafe Mocha   -----------------------Rs: 200");
		mocha.setBounds(50, 290, 350, 35);
		mocha.setFocusable(false);
		mocha.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		center.add(mocha);

		chocolate = new JCheckBox("Hot chocolate -----------------------Rs: 160");
		chocolate.setBounds(50, 330, 350, 35);
		chocolate.setFocusable(false);
		chocolate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		center.add(chocolate);

		JLabel liqours = new JLabel("Liqours(60ml)", JLabel.CENTER);
		liqours.setBounds(550, 80, 230, 35);
		liqours.setBorder(new MatteBorder(0,0,4,0,Color.red));
		liqours.setFont(new Font("Times New Roman", Font.BOLD, 35));
		center.add(liqours);

		od = new JCheckBox("Old Durbar     -----------------------Rs: 450");
		od.setBounds(500, 130, 350, 35);
		od.setFocusable(false);
		od.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		center.add(od);

		mt = new JCheckBox("Mt 8848          -----------------------Rs: 400");
		mt.setBounds(500, 170, 350, 35);
		mt.setFocusable(false);
		mt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		center.add(mt);

		sign = new JCheckBox("Signature        -----------------------Rs: 500");
		sign.setBounds(500, 210, 350, 35);
		sign.setFocusable(false);
		sign.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		center.add(sign);

		label = new JCheckBox("Label               -----------------------Rs: 550");
		label.setBounds(500, 250, 350, 35);
		label.setFocusable(false);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		center.add(label);

		vat = new JCheckBox("Vat 69             -----------------------Rs: 500");
		vat.setBounds(500, 290, 350, 35);
		vat.setFocusable(false);
		vat.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		center.add(vat);

		gin = new JCheckBox("Gin                  -----------------------Rs: 600");
		gin.setBounds(500, 330, 350, 35);
		gin.setFocusable(false);
		gin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		center.add(gin);

		JLabel winebeer = new JLabel("Wine/Beer", JLabel.CENTER);
		winebeer.setBounds(1050, 80, 170, 35);
		winebeer.setBorder(new MatteBorder(0,0,4,0,Color.red));
		winebeer.setFont(new Font("Times New Roman", Font.BOLD, 35));
		center.add(winebeer);

		wine = new JCheckBox("Table Wine    -----------------------Rs: 2000");
		wine.setBounds(990, 130, 400, 35);
		wine.setFocusable(false);
		wine.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		center.add(wine);

		tuborg = new JCheckBox("Tuborg           -----------------------Rs: 450");
		tuborg.setBounds(990, 170, 400, 35);
		tuborg.setFocusable(false);
		tuborg.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		center.add(tuborg);

		gorkha = new JCheckBox("Gorkha           ----------------------Rs: 500");
		gorkha.setBounds(990, 210, 400, 35);
		gorkha.setFocusable(false);
		gorkha.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		center.add(gorkha);

		nepalice = new JCheckBox("Nepal Ice        ----------------------Rs: 500");
		nepalice.setBounds(990, 250, 400, 35);
		nepalice.setFocusable(false);
		nepalice.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		center.add(nepalice);

		carlsberg = new JCheckBox("Carlsberg        ----------------------Rs: 600");
		carlsberg.setBounds(990, 290, 400, 35);
		carlsberg.setFocusable(false);
		carlsberg.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		center.add(carlsberg);

		barhasinghe = new JCheckBox("Barhasinghe   ----------------------Rs: 550");
		barhasinghe.setBounds(990, 330, 400, 35);
		barhasinghe.setFocusable(false);
		barhasinghe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		center.add(barhasinghe);

		JLabel servicecharge = new JLabel("10% service charge is included.", JLabel.CENTER);
		servicecharge.setBounds(600, 400, 350, 35);
		servicecharge.setFont(new Font("Times New Roman", Font.BOLD, 20));
		center.add(servicecharge);

        // ***************South Panel***********
		JPanel south = new JPanel();
		south.setLayout(null);
		south.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Billing", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		south.setPreferredSize(new Dimension(100, 230));
		south.setBackground(new Color(21, 159, 133));
		frame.add(south, BorderLayout.SOUTH);
		
		JButton searchcustomerbtn = new JButton("Search Customers");
		searchcustomerbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("search (1).png")));
		searchcustomerbtn.setBounds(10, 20, 280, 50);
		searchcustomerbtn.setBorder(BorderFactory.createLineBorder(Color.white,1));
		searchcustomerbtn.setFocusable(false);
		searchcustomerbtn.setBackground(new Color(106, 101, 101));
		searchcustomerbtn.setFont(new Font("Times New Roman", Font.BOLD, 25));
		searchcustomerbtn.setForeground(Color.white);
		south.add(searchcustomerbtn);
		searchcustomerbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SearchBookingID();
				
			}
			
			
			
		});
		
		JButton exitbtn = new JButton("Exit");
		exitbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("button.png")));
		exitbtn.setBounds(10, 80, 280, 50);
		exitbtn.setBorder(BorderFactory.createLineBorder(Color.white,1));
		exitbtn.setFocusable(false);
		exitbtn.setBackground(new Color(106, 101, 101));
		exitbtn.setFont(new Font("Times New Roman", Font.BOLD, 25));
		exitbtn.setForeground(Color.white);
		south.add(exitbtn);
		exitbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
			
			
			
		});
		
		JLabel bookingidlbl = new JLabel("Booking ID",JLabel.CENTER);
		bookingidlbl.setBounds(1000, 30, 180, 30);
		bookingidlbl.setForeground(Color.white);
		bookingidlbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		bookingidlbl.setBackground(new Color(106, 101, 101));
		bookingidlbl.setOpaque(true);
		south.add(bookingidlbl);
		
		

		
		BookingCombo = new JComboBox();
		BookingCombo.setBorder(BorderFactory.createLineBorder(Color.white));
		BookingCombo.setBounds(1200, 30, 200, 30);		
		BookingCombo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		south.add(BookingCombo);
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database","root","");
			
			
			

			
			String query1 = "SELECT Customer_ID, Name, Booking_ID,Booking_Status "
					+ "FROM booking INNER JOIN customers USING (Customer_ID) WHERE "
					+ "Booking_Status='Active' ORDER BY Booking_ID;";
		

			PreparedStatement pst1 = conn.prepareStatement(query1);
			ResultSet rst1 = pst1.executeQuery();

			String Booking_ID = "";
			while (rst1.next()) {
				
				BookingCombo.addItem(rst1.getString("Booking_ID"));
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}

		JButton calculatebtn = new JButton("Calculator Total: ");
		calculatebtn.setBounds(1000, 70, 180, 30);
		calculatebtn.setFocusable(false);
		calculatebtn.setBackground(new Color(106, 101, 101));
		calculatebtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		calculatebtn.setForeground(Color.white);
		south.add(calculatebtn);
		calculatebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int total;
				int subtotal = 0;
				int subtotal1 = 0;

				if (espresso.isSelected()) {
					subtotal = subtotal + 200;
				}
				if (americano.isSelected()) {
					subtotal = subtotal + 180;
				}
				if (cappucino.isSelected()) {
					subtotal = subtotal + 250;
				}
				if (latte.isSelected()) {
					subtotal = subtotal + 180;
				}
				if (mocha.isSelected()) {
					subtotal = subtotal + 200;
				}
				if (chocolate.isSelected()) {
					subtotal = subtotal + 160;
				}
				if (od.isSelected()) {
					subtotal = subtotal + 450;
				}
				if (mt.isSelected()) {
					subtotal = subtotal + 400;
				}
				if (sign.isSelected()) {
					subtotal = subtotal + 500;
				}
				if (label.isSelected()) {
					subtotal = subtotal + 550;
				}
				if (vat.isSelected()) {
					subtotal = subtotal + 500;
				}
				if (gin.isSelected()) {
					subtotal = subtotal + 600;
				}
				if (wine.isSelected()) {
					subtotal = subtotal + 2000;
				}
				if (tuborg.isSelected()) {
					subtotal = subtotal + 450;
				}
				if (gorkha.isSelected()) {
					subtotal = subtotal + 500;
				}
				if (nepalice.isSelected()) {
					subtotal = subtotal + 500;
				}
				if (carlsberg.isSelected()) {
					subtotal = subtotal + 600;
				}
				if (barhasinghe.isSelected()) {
					subtotal = subtotal + 550;
				}

				total = subtotal;
				totalamounttxt.setText(Integer.toString(total));
			}

		});

		totalamounttxt = new JTextField();
		totalamounttxt.setBorder(BorderFactory.createLineBorder(Color.white));
		totalamounttxt.setBounds(1200, 70, 200, 30);
		totalamounttxt.setFont(new Font("Times New Roman", Font.BOLD, 18));
		south.add(totalamounttxt);

		orderbtn = new JButton("Order");		
		orderbtn.setBounds(1200, 120, 200, 30);
		orderbtn.setFocusable(false);
		orderbtn.setBackground(new Color(106, 101, 101));
		orderbtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		orderbtn.setForeground(Color.white);
		south.add(orderbtn);
		orderbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==orderbtn) {
					
					BarLibs bar=new BarLibs();
					
					int bookingid=Integer.parseInt(BookingCombo.getSelectedItem().toString());
					int totalamount=Integer.parseInt(totalamounttxt.getText());
					
					bar.setBooking_ID(bookingid);
					bar.setDrink_Amount(totalamount);
					
					JDBCBar jdbc=new JDBCBar();
					boolean result=jdbc.insert(bar);
					if(result==true) {
						JOptionPane.showMessageDialog(null, "The Item is ordered!");
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Error!");
					}
					
					
				}
				
			}
			
			
			
		});

		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new BarDashboard();
	}
}