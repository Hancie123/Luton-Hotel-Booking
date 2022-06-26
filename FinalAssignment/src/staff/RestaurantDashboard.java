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
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import Libs.Global;
import Libs.JDBCRestaurant;
import Libs.MaterialTabbed;
import Libs.RestaurantLibs;
import UI.LoginWindow;

public class RestaurantDashboard {
	JButton orderbtn;
	JTextField totalamounttxt, bookingidtxt;
    JComboBox BookingCombo;
	JCheckBox item01, item02, item03, item04, item05, item06, item07, item08, item09;

	public RestaurantDashboard() {
		JFrame frame = new JFrame("Restaurant Dashboard");
		frame.setSize(1000, 750);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setLocationRelativeTo(null);
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

		JLabel menutitle = new JLabel("Restaurant Dashboard");
		menutitle.setBorder(new MatteBorder(0, 0, 4, 0, Color.RED));
		menutitle.setForeground(Color.white);
		menutitle.setBounds(600, 40, 400, 40);
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
		

		// ***************West Panel***********
		JPanel west = new JPanel();
		west.setLayout(null);
		west.setPreferredSize(new Dimension(1100, 120));
		frame.add(west, BorderLayout.WEST);

		// **************Noddles***********************
		JLabel item1 = new JLabel();
		item1.setIcon(new javax.swing.ImageIcon(getClass().getResource("noodles.png")));
		item1.setBounds(40, 50, 150, 80);
		item1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		west.add(item1);

		item01 = new JCheckBox("Nooodles");
		item01.setBounds(25, 125, 150, 20);
		item01.setFont(new Font("Times New Roman", Font.BOLD, 18));
		west.add(item01);

		// ********************Pasta******************************
		JLabel item2 = new JLabel();
		item2.setIcon(new javax.swing.ImageIcon(getClass().getResource("spaguetti.png")));
		item2.setBounds(225, 50, 150, 80);
		item2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		west.add(item2);

		item02 = new JCheckBox("Pasta");
		item02.setBounds(220, 125, 150, 20);
		item02.setFont(new Font("Times New Roman", Font.BOLD, 18));
		west.add(item02);

		// ***********************Rice****************************
		JLabel item3 = new JLabel();
		item3.setIcon(new javax.swing.ImageIcon(getClass().getResource("rice.png")));
		item3.setBounds(410, 50, 150, 80);
		item3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		west.add(item3);

		item03 = new JCheckBox("Rice");
		item03.setBounds(420, 125, 150, 20);
		item03.setFont(new Font("Times New Roman", Font.BOLD, 18));
		west.add(item03);

		// ********************Curry**********************************
		JLabel item4 = new JLabel();
		item4.setIcon(new javax.swing.ImageIcon(getClass().getResource("curry.png")));
		item4.setBounds(595, 50, 150, 80);
		item4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		west.add(item4);

		item04 = new JCheckBox("Curry");
		item04.setBounds(600, 125, 150, 20);
		item04.setFont(new Font("Times New Roman", Font.BOLD, 18));
		west.add(item04);

		// ***********************Chicken*******************************
		JLabel item5 = new JLabel();
		item5.setIcon(new javax.swing.ImageIcon(getClass().getResource("chicken-leg.png")));
		item5.setBounds(780, 50, 150, 80);
		item5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		west.add(item5);

		item05 = new JCheckBox("Chicken");
		item05.setBounds(775, 125, 150, 20);
		item05.setFont(new Font("Times New Roman", Font.BOLD, 18));
		west.add(item05);

		// ****************************Fruits************************8
		JLabel item6 = new JLabel();
		item6.setIcon(new javax.swing.ImageIcon(getClass().getResource("fruits.png")));
		item6.setBounds(965, 50, 150, 80);
		item6.setFont(new Font("Times New Roman", Font.BOLD, 18));
		west.add(item6);

		item06 = new JCheckBox("Fruits");
		item06.setBounds(960, 125, 150, 20);
		item06.setFont(new Font("Times New Roman", Font.BOLD, 18));
		west.add(item06);

		// ******************Coke*******************88
		JLabel item7 = new JLabel();
		item7.setIcon(new javax.swing.ImageIcon(getClass().getResource("cola.png")));
		item7.setBounds(40, 220, 150, 80);
		item7.setFont(new Font("Times New Roman", Font.BOLD, 18));
		west.add(item7);

		item07 = new JCheckBox("Coke");
		item07.setBounds(40, 300, 150, 20);
		item07.setFont(new Font("Times New Roman", Font.BOLD, 18));
		west.add(item07);

		// *********************Sprite***********************
		JLabel item8 = new JLabel();
		item8.setIcon(new javax.swing.ImageIcon(getClass().getResource("soda.png")));
		item8.setBounds(225, 220, 150, 80);
		item8.setFont(new Font("Times New Roman", Font.BOLD, 18));
		west.add(item8);

		item08 = new JCheckBox("Sprite");
		item08.setBounds(225, 300, 150, 20);
		item08.setFont(new Font("Times New Roman", Font.BOLD, 18));
		west.add(item08);

		// ************************Beer******************************
		JLabel item9 = new JLabel();
		item9.setIcon(new javax.swing.ImageIcon(getClass().getResource("beer.png")));
		item9.setBounds(410, 220, 150, 80);
		item9.setFont(new Font("Times New Roman", Font.BOLD, 18));
		west.add(item9);

		item09 = new JCheckBox("Beer");
		item09.setBounds(410, 300, 150, 20);
		item09.setFont(new Font("Times New Roman", Font.BOLD, 18));
		west.add(item09);

		// ***************Center Panel***********
		
		MaterialTabbed tab = new MaterialTabbed();
		tab.setPreferredSize(new Dimension(1000, 80));
		tab.setFont(new Font("Verdana", Font.BOLD, 15));
		frame.add(tab, BorderLayout.CENTER);
		
		JPanel center=new JPanel();
		center.setLayout(null);
		center.setPreferredSize(new Dimension(100,120));
		center.setBackground(new Color(106,101,101));
		tab.add("Menu-1",center);
		
		JPanel center1=new JPanel();
		center1.setLayout(null);
		center1.setPreferredSize(new Dimension(100,120));
		center1.setBackground(new Color(106,101,101));
		tab.add("Menu-2",center1);
		
		JLabel menutitlelbl=new JLabel("Menu Items-1",JLabel.CENTER);
		menutitlelbl.setBounds(50,10,250,35);
		menutitlelbl.setFont(new Font("Brush Script MT", Font.BOLD,30));
		menutitlelbl.setForeground(Color.white);
		center.add(menutitlelbl);
		
		JSeparator j1=new JSeparator();
		j1.setBounds(10,45,320,10);
		center.add(j1);
		
		JLabel item11 = new JLabel("     --------------------------Rs: 40");
		item11.setForeground(Color.white);
		item11.setIcon(new javax.swing.ImageIcon(getClass().getResource("noodles.png")));
		item11.setBounds(10,50,450,80);
		item11.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item11);
        
        JLabel item22 = new JLabel("     --------------------------Rs: 80");
        item22.setIcon(new javax.swing.ImageIcon(getClass().getResource("spaguetti.png")));
        item22.setBounds(10,120,450,80);
        item22.setForeground(Color.white);
        item22.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item22);
        
        JLabel item33 = new JLabel("     --------------------------Rs: 120");
        item33.setIcon(new javax.swing.ImageIcon(getClass().getResource("rice.png")));
        item33.setBounds(10,190,450,80);
        item33.setForeground(Color.white);
        item33.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item33);
        
        JLabel item44 = new JLabel("     --------------------------Rs: 30");
        item44.setIcon(new javax.swing.ImageIcon(getClass().getResource("curry.png")));
        item44.setBounds(10,260,450,80);
        item44.setForeground(Color.white);
        item44.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item44);
        
        JLabel item55 = new JLabel("     --------------------------Rs: 100");
        item55.setForeground(Color.white);
        item55.setIcon(new javax.swing.ImageIcon(getClass().getResource("chicken-leg.png")));
        item55.setBounds(10,330,450,80);
        item55.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item55);
        
       
        
        JLabel menutitlelbl1=new JLabel("Menu Items-2",JLabel.CENTER);
		menutitlelbl1.setBounds(50,10,250,35);
		menutitlelbl1.setFont(new Font("Brush Script MT", Font.BOLD,30));
		menutitlelbl1.setForeground(Color.white);
		center1.add(menutitlelbl1);
		
		JSeparator j2=new JSeparator();
		j2.setBounds(10,45,320,10);
		center1.add(j2);
        
        JLabel item77 = new JLabel("     --------------------------Rs: 60");
        item77.setForeground(Color.white);
        item77.setIcon(new javax.swing.ImageIcon(getClass().getResource("cola.png")));
        item77.setBounds(10,50,450,80);
        item77.setFont(new Font("Times New Roman",Font.BOLD,18));
        center1.add(item77);
        
        JLabel item88 = new JLabel("     --------------------------Rs: 60");
        item88.setForeground(Color.white);
        item88.setIcon(new javax.swing.ImageIcon(getClass().getResource("soda.png")));
        item88.setBounds(10,120,450,80);
        item88.setFont(new Font("Times New Roman",Font.BOLD,18));
        center1.add(item88);
        
        
        JLabel item99 = new JLabel("     --------------------------Rs: 350");
        item99.setForeground(Color.white);
        item99.setIcon(new javax.swing.ImageIcon(getClass().getResource("beer.png")));
        item99.setBounds(10,190,450,80);
        item99.setFont(new Font("Times New Roman",Font.BOLD,18));
        center1.add(item99);
        
        JLabel item66 = new JLabel("     --------------------------Rs: 200");
        item66.setIcon(new javax.swing.ImageIcon(getClass().getResource("fruits.png")));
        item66.setBounds(10,260,450,80);
        item66.setForeground(Color.white);
        item66.setFont(new Font("Times New Roman",Font.BOLD,18));
        center1.add(item66);
		
		
	

		// ***************South Panel***********
		JPanel south = new JPanel();
		south.setLayout(null);
		south.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Billing",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		south.setPreferredSize(new Dimension(100, 180));
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

		JLabel bookingidlbl = new JLabel("Booking ID", JLabel.CENTER);
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
			
			
			

			
			String query1 = "SELECT Customer_ID, Name, Booking_ID, "
					+ "Booking_Status FROM booking INNER JOIN customers USING"
					+ " (Customer_ID) WHERE Booking_Status='Active' ORDER BY Booking_ID;";
		

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
				int subtotal=0;
				int subtotal1=0;
				
				
				if(item01.isSelected()) {
					subtotal=subtotal+40;
				}
				if(item02.isSelected()) {
					subtotal=subtotal+80;
				}
				if(item03.isSelected()) {
					subtotal=subtotal+120;
				}
				if(item04.isSelected()) {
					subtotal=subtotal+30;
				}
				if(item05.isSelected()) {
					subtotal=subtotal+100;
				}
				if(item06.isSelected()) {
					subtotal=subtotal+200;
				}
				if(item07.isSelected()) {
					subtotal=subtotal+60;
				}
				if(item08.isSelected()) {
					subtotal=subtotal+60;
				}
				if(item09.isSelected()) {
					subtotal=subtotal+350;
				}
				
				total=subtotal;
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
				if (e.getSource() == orderbtn) {

					RestaurantLibs restaurant = new RestaurantLibs();

					int bookingid = Integer.parseInt(BookingCombo.getSelectedItem().toString());
					int totalamount = Integer.parseInt(totalamounttxt.getText());

					restaurant.setBooking_ID(bookingid);
					restaurant.setItem_Amount(totalamount);

					JDBCRestaurant jdbc = new JDBCRestaurant();
					boolean result = jdbc.insert(restaurant);
					if (result == true) {
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
		new RestaurantDashboard();
	}
}