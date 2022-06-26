package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import com.toedter.calendar.JDateChooser;

import Libs.BookingLibs;
import Libs.BookingLibs2;
import Libs.BookingLibs3;
import Libs.Global;
import Libs.JDBCBooking;
import Libs.JDBCBooking2;
import Libs.JDBCRoom;
import Libs.MaterialTabbed;
import Libs.PanelRound;
import Libs.Room;


public class CustomerDashBoard implements ActionListener,MouseListener {
	
	JMenuBar menubar;
	JMenu file, about;
	JMenuItem file1, about1;
	JButton bookingbtn,bookingbtn1, bookingcancelbtn1,bookingclearbtn1;
	JTextField bookingidtxt,bookingidtxt1,customeridtxt,customeridtxt1,roomidtxt,roomidtxt1,cancelbookingtxt;
	JDateChooser checkin,checkout1, checkin1,checkout2;
	JComboBox bookingtypetxt,bookingtypetxt1;
	JTable table2,table1;
	DefaultTableModel dm,dm2,model;
	ArrayList<BookingLibs2>a1;
	Object[] columnsName;
	JTableHeader t2;

	public CustomerDashBoard() {
		
		JFrame frame = new JFrame("Customer DashBoard");
		frame.setSize(850, 750);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setResizable(false);
		
		menubar=new JMenuBar();
		frame.setJMenuBar(menubar);
		
		file=new JMenu("File");
		menubar.add(file);
			
		
		JMenuItem profile=new JMenuItem("View Profile");
		file.add(profile);
		profile.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==profile) {
				
				new ProfileGUI();
			}
		}	
		});
		
		
		JMenuItem file2=new JMenuItem("Log Out");
		file.add(file2);
		file2.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==file2) {
				frame.dispose();
				new LoginWindow();
			}
		}	
		});
		
		file1=new JMenuItem("Exit");
		file.add(file1);
		file1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==file1) {
				System.exit(0);
			}
		}	
		});
		
		about=new JMenu("About");
		menubar.add(about);
		about1=new JMenuItem("About");
		about.add(about1);
		about1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==about1) {
				new AboutUs();
				
			}
		}
			
			
		});
		
		
		
		JPanel south=new JPanel();
		south.setPreferredSize(new Dimension(200,50));
		south.setBackground(new Color(21, 159, 133));
		south.setLayout(null);
		frame.getContentPane().add(south, BorderLayout.SOUTH);
		

		JPanel north=new JPanel();
		north.setPreferredSize(new Dimension(200,100));
		north.setBackground(new Color(21, 159, 133));
		north.setLayout(null);
		frame.getContentPane().add(north, BorderLayout.CENTER);
		
		JLabel title=new JLabel("LUTON HOTEL CUSTOMER DASHBOARD",SwingConstants.CENTER);
		title.setFont(new Font("Verdana",Font.BOLD,20));
		title.setForeground(Color.white);
		title.setBounds(500,20,500,35);
		north.add(title);
		
		JLabel usertitle=new JLabel("Welcome: ");		
		usertitle.setFont(new Font("Times New Roman",Font.PLAIN,18));
		usertitle.setForeground(Color.white);
		usertitle.setBounds(1330,20,90,35);
		north.add(usertitle);
		
		JLabel usertitle1=new JLabel();
		usertitle1.setText(Global.currentUser.getUsername());
		usertitle1.setFont(new Font("Times New Roman",Font.PLAIN,18));
		usertitle1.setForeground(Color.white);
		usertitle1.setBounds(1410,20,90,35);
		north.add(usertitle1);
		
		

		MaterialTabbed tab = new MaterialTabbed();
		tab.setBounds(10, 50, 1520, 1200);
		tab.setForeground(Color.WHITE);
		tab.setFont(new Font("Verdana", Font.BOLD, 15));
		north.add(tab);

		JPanel Booking = new javax.swing.JPanel();
		Booking.setLayout(new BorderLayout());
		tab.add("Booking", Booking);
		
		JPanel booking1=new JPanel();
		booking1.setPreferredSize(new Dimension(400,100));
		booking1.setBackground(new Color(106,101,101));
		booking1.setLayout(null);
		Booking.add(booking1, BorderLayout.WEST);
		
		
		
		JLabel bookinglbl=new JLabel("CHECK FOR BOOKING");
		bookinglbl.setBounds(80,30,250,35);
		bookinglbl.setForeground(Color.white);
		bookinglbl.setFont(new Font("Verdana",Font.BOLD,18));
		booking1.add(bookinglbl);
		
		
		JLabel customerid=new JLabel("Customer ID:");
		customerid.setVisible(false);
		customerid.setBounds(30,100,200,35);
		customerid.setForeground(Color.white);
		customerid.setFont(new Font("Verdana",Font.PLAIN,18));
		booking1.add(customerid);
		
		customeridtxt=new JTextField();
		customeridtxt.setVisible(false);
		customeridtxt.setEnabled(false);
		customeridtxt.setText(Integer.toString(Global.currentUser.getCustomer_ID()));
		customeridtxt.setBounds(170,100,200,30);
		customeridtxt.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
		customeridtxt.setFont(new Font("Verdana",Font.PLAIN,18));
		booking1.add(customeridtxt);
		
		JLabel label=new JLabel("Check-In: ");
		label.setBounds(30,100,100,35);
		label.setForeground(Color.white);
		label.setFont(new Font("Verdana",Font.PLAIN,18));
		booking1.add(label);
		
		Date date=new Date();
		checkin = new JDateChooser();
		checkin.setMinSelectableDate(date);
        checkin.setDateFormatString("yyyy-MM-dd");
		checkin.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
		checkin.setFont(new Font("Verdana",Font.PLAIN,15));
		checkin.setBounds(170,100,200,30);
		booking1.add(checkin);
		
		
		
		JLabel checkout=new JLabel("Check-out:");
		checkout.setBounds(30,150,200,35);
		checkout.setForeground(Color.white);
		checkout.setFont(new Font("Verdana",Font.PLAIN,18));
		booking1.add(checkout);
		
		
		
		checkout1 = new JDateChooser();
		checkout1.setMinSelectableDate(date);
		checkout1.setDateFormatString("yyyy-MM-dd");
		checkout1.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
		checkout1.setFont(new Font("Verdana",Font.PLAIN,15));
		checkout1.setBounds(170,150,200,30);
		booking1.add(checkout1);
		
		
		
		JLabel bookingtype=new JLabel("Room Type:");
		bookingtype.setBounds(30,200,200,35);
		bookingtype.setForeground(Color.white);
		bookingtype.setFont(new Font("Verdana",Font.PLAIN,18));
		booking1.add(bookingtype);
		
		Object[] h1= {"Single","Twin","Double"};
		
		bookingtypetxt=new JComboBox(h1);
		bookingtypetxt.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
		bookingtypetxt.setBounds(170,200,200,30);
		bookingtypetxt.setFont(new Font("Verdana",Font.PLAIN,18));
		booking1.add(bookingtypetxt);
		
		
		bookingbtn=new JButton("Request Room");
		bookingbtn.setBounds(30,300,200,35);
		bookingbtn.setBackground(new Color(21, 159, 133));
		bookingbtn.setForeground(Color.white);
		bookingbtn.setFont(new Font("Verdana",Font.PLAIN,18));
		bookingbtn.addActionListener(this);
		booking1.add(bookingbtn);
		
		
		JButton bookingclearbtn=new JButton("Clear");
		bookingclearbtn.setBounds(250,300,100,35);
		bookingclearbtn.setBackground(new Color(21, 159, 133));
		bookingclearbtn.setForeground(Color.white);
		bookingclearbtn.setFont(new Font("Verdana",Font.PLAIN,18));
		booking1.add(bookingclearbtn);
		bookingclearbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(ae.getSource()==bookingclearbtn) {
					
					customeridtxt.setText("");
					checkin.setCalendar(null);
					checkout1.setCalendar(null);
					bookingtypetxt.setSelectedIndex(0);
					roomidtxt.setText("");
				}}});

		JPanel booking2=new JPanel();
		booking2.setPreferredSize(new Dimension(400,100));
		booking2.setBackground(Color.white);
		booking2.setLayout(null);
		Booking.add(booking2, BorderLayout.CENTER);
		
		PanelRound singleroom=new PanelRound();
		singleroom.setBounds(10,10,355,650);
		singleroom.setRoundBottomRight(100);
		singleroom.setRoundBottomLeft(100);
		singleroom.setBackground(Color.orange);
		singleroom.setRoundTopLeft(100);
		singleroom.setRoundTopRight(100);
		singleroom.setBackground(new Color(21,159,133));
		singleroom.setLayout(null);
		booking2.add(singleroom);
		
		JLabel singleroompic=new JLabel();
		singleroompic.setIcon(new javax.swing.ImageIcon(getClass().getResource("single room.jpg")));
		singleroompic.setBounds(20,20,315,300);
		singleroom.add(singleroompic);
		
		JLabel singleroomtitle=new JLabel("Single Room", JLabel.CENTER);
		singleroomtitle.setBounds(70,320,200,35);
		singleroomtitle.setBackground(new Color(21, 159, 133));
		singleroomtitle.setForeground(Color.white);
		singleroomtitle.setFont(new Font("Verdana",Font.BOLD,25));
		singleroom.add(singleroomtitle);
		
		JLabel singleroomtitle1=new JLabel("Services offered in this"
				+ " booking");
		singleroomtitle1.setBounds(30,360,250,35);
		singleroomtitle1.setBackground(new Color(21, 159, 133));
		singleroomtitle1.setForeground(Color.white);
		singleroomtitle1.setFont(new Font("Verdana",Font.PLAIN,15));
		singleroom.add(singleroomtitle1);
		
		JLabel singleroomtitle2=new JLabel("• No of beds: Single");
		singleroomtitle2.setBounds(40,400,250,35);
		singleroomtitle2.setBackground(new Color(21, 159, 133));
		singleroomtitle2.setForeground(Color.white);
		singleroomtitle2.setFont(new Font("Verdana",Font.PLAIN,15));
		singleroom.add(singleroomtitle2);
		
		JLabel singleroomtitle3=new JLabel("• Heater= No");
		singleroomtitle3.setBounds(40,430,250,35);
		singleroomtitle3.setBackground(new Color(21, 159, 133));
		singleroomtitle3.setForeground(Color.white);
		singleroomtitle3.setFont(new Font("Verdana",Font.PLAIN,15));
		singleroom.add(singleroomtitle3);
		
		JLabel singleroomtitle4=new JLabel("• AC= No");
		singleroomtitle4.setBounds(40,460,250,35);
		singleroomtitle4.setBackground(new Color(21, 159, 133));
		singleroomtitle4.setForeground(Color.white);
		singleroomtitle4.setFont(new Font("Verdana",Font.PLAIN,15));
		singleroom.add(singleroomtitle4);
		
		JLabel singleroomtitle5=new JLabel("Room Price: Rs. 2000");
		singleroomtitle5.setBounds(40,490,250,35);
		singleroomtitle5.setBackground(new Color(21, 159, 133));
		singleroomtitle5.setForeground(Color.white);
		singleroomtitle5.setFont(new Font("Verdana",Font.PLAIN,15));
		singleroom.add(singleroomtitle5);
		
		
		
		PanelRound doubleroom=new PanelRound();
		doubleroom.setBounds(380,10,355,650);
		doubleroom.setRoundBottomRight(100);
		doubleroom.setRoundBottomLeft(100);
		doubleroom.setBackground(new Color(21,159,133));
		doubleroom.setRoundTopLeft(100);
		doubleroom.setRoundTopRight(100);
        doubleroom.setLayout(null);
		booking2.add(doubleroom);
		
		JLabel doubleroompic=new JLabel();
		doubleroompic.setIcon(new javax.swing.ImageIcon(getClass().getResource("double room.jpg")));
		doubleroompic.setBounds(20,20,315,300);
		doubleroom.add(doubleroompic);
		
		JLabel doubleroomtitle=new JLabel("Double Room", JLabel.CENTER);
		doubleroomtitle.setBounds(70,320,200,35);
		doubleroomtitle.setBackground(new Color(21, 159, 133));
		doubleroomtitle.setForeground(Color.white);
		doubleroomtitle.setFont(new Font("Verdana",Font.BOLD,25));
		doubleroom.add(doubleroomtitle);
		
		JLabel doubleroomtitle1=new JLabel("Services offered in this"
				+ " booking");
		doubleroomtitle1.setBounds(30,360,250,35);
		doubleroomtitle1.setBackground(new Color(21, 159, 133));
		doubleroomtitle1.setForeground(Color.white);
		doubleroomtitle1.setFont(new Font("Verdana",Font.PLAIN,15));
		doubleroom.add(doubleroomtitle1);
		
		JLabel doubleroomtitle2=new JLabel("• No of beds: Double");
		doubleroomtitle2.setBounds(40,400,250,35);
		doubleroomtitle2.setBackground(new Color(21, 159, 133));
		doubleroomtitle2.setForeground(Color.white);
		doubleroomtitle2.setFont(new Font("Verdana",Font.PLAIN,15));
		doubleroom.add(doubleroomtitle2);
		
		JLabel doubleroomtitle3=new JLabel("• Heater= No");
		doubleroomtitle3.setBounds(40,430,250,35);
		doubleroomtitle3.setForeground(Color.white);
		doubleroomtitle3.setFont(new Font("Verdana",Font.PLAIN,15));
		doubleroom.add(doubleroomtitle3);
		
		
		
		JLabel doubleroomtitle4=new JLabel("• AC= Yes");
		doubleroomtitle4.setBounds(40,460,250,35);
		doubleroomtitle4.setForeground(Color.white);
		doubleroomtitle4.setFont(new Font("Verdana",Font.PLAIN,15));
		doubleroom.add(doubleroomtitle4);
		
		JLabel doubleroomtitle5=new JLabel("Room Price: Rs. 4000");
		doubleroomtitle5.setBounds(40,490,250,35);
		doubleroomtitle5.setBackground(new Color(21, 159, 133));
		doubleroomtitle5.setForeground(Color.white);
		doubleroomtitle5.setFont(new Font("Verdana",Font.PLAIN,15));
		doubleroom.add(doubleroomtitle5);
		
		
		
		
		PanelRound tripleroom=new PanelRound();
		tripleroom.setBounds(750,10,355,650);
		tripleroom.setRoundBottomRight(100);
		tripleroom.setRoundBottomLeft(100);
		tripleroom.setRoundTopLeft(100);
		tripleroom.setRoundTopRight(100);
		tripleroom.setBackground(new Color(21,159,133));
		tripleroom.setLayout(null);
		booking2.add(tripleroom);
		
		JLabel tripleroompic=new JLabel();
		tripleroompic.setIcon(new javax.swing.ImageIcon(getClass().getResource("triple room.jpg")));
		tripleroompic.setBounds(20,20,315,300);
		tripleroom.add(tripleroompic);
		
		JLabel tripleroomtitle=new JLabel("Twin Room", JLabel.CENTER);
		tripleroomtitle.setBounds(70,320,200,35);
		tripleroomtitle.setBackground(new Color(21, 159, 133));
		tripleroomtitle.setForeground(Color.white);
		tripleroomtitle.setFont(new Font("Verdana",Font.BOLD,25));
		tripleroom.add(tripleroomtitle);
		
		JLabel tripleroomtitle1=new JLabel("Services offered in this"
				+ " booking");
		tripleroomtitle1.setBounds(30,360,250,35);
		tripleroomtitle1.setBackground(new Color(21, 159, 133));
		tripleroomtitle1.setForeground(Color.white);
		tripleroomtitle1.setFont(new Font("Verdana",Font.PLAIN,15));
		tripleroom.add(tripleroomtitle1);
		
		JLabel tripleroomtitle2=new JLabel("• No of beds: Triple");
		tripleroomtitle2.setBounds(40,400,250,35);
		tripleroomtitle2.setBackground(new Color(21, 159, 133));
		tripleroomtitle2.setForeground(Color.white);
		tripleroomtitle2.setFont(new Font("Verdana",Font.PLAIN,15));
		tripleroom.add(tripleroomtitle2);
		
		JLabel tripleroomtitle3=new JLabel("• Heater= Yes");
		tripleroomtitle3.setBounds(40,430,250,35);
		tripleroomtitle3.setBackground(new Color(21, 159, 133));
		tripleroomtitle3.setForeground(Color.white);
		tripleroomtitle3.setFont(new Font("Verdana",Font.PLAIN,15));
		tripleroom.add(tripleroomtitle3);
		
		JLabel tripleroomtitle4=new JLabel("• AC= Yes");
		tripleroomtitle4.setBounds(40,460,250,35);
		tripleroomtitle4.setBackground(new Color(21, 159, 133));
		tripleroomtitle4.setForeground(Color.white);
		tripleroomtitle4.setFont(new Font("Verdana",Font.PLAIN,15));
		tripleroom.add(tripleroomtitle4);
		
		JLabel tripleroomtitle5=new JLabel("Room Price: Rs. 6000");
		tripleroomtitle5.setBounds(40,490,250,35);
		tripleroomtitle5.setBackground(new Color(21, 159, 133));
		tripleroomtitle5.setForeground(Color.white);
		tripleroomtitle5.setFont(new Font("Verdana",Font.PLAIN,15));
		tripleroom.add(tripleroomtitle5);
		
        
		
		//*********************Cencel History***********************8
		JPanel bookingHistory = new javax.swing.JPanel();
		bookingHistory.setLayout(new BorderLayout());
		tab.add("Current Booking", bookingHistory);
		
		
		//**********************Cencel Booking Panel**********************8
		JPanel bookinghistory1=new JPanel();
		bookinghistory1.setPreferredSize(new Dimension(400,100));
		bookinghistory1.setBackground(new Color(106,101,101));
		bookinghistory1.setLayout(null);
		bookingHistory.add(bookinghistory1, BorderLayout.WEST);
		
		
		JLabel bookinglbl1=new JLabel("CANCEL BOOKING");
		bookinglbl1.setBounds(80,30,250,35);
		bookinglbl1.setForeground(Color.white);
		bookinglbl1.setFont(new Font("Verdana",Font.BOLD,18));
		bookinghistory1.add(bookinglbl1);
		
		
		JLabel customerid1=new JLabel("Booking ID:");
		customerid1.setVisible(false);
		customerid1.setBounds(30,100,200,35);
		customerid1.setForeground(Color.white);
		customerid1.setFont(new Font("Verdana",Font.PLAIN,18));
		bookinghistory1.add(customerid1);
		
		customeridtxt1=new JTextField();
		customeridtxt1.setVisible(false);
		customeridtxt1.setEnabled(false);
		customeridtxt1.setText(Integer.toString(Global.currentUser.getCustomer_ID()));
		customeridtxt1.setBounds(170,100,200,30);
		customeridtxt1.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
		customeridtxt1.setFont(new Font("Verdana",Font.PLAIN,18));
		bookinghistory1.add(customeridtxt1);
		
		JLabel bookingidlbl=new JLabel("Booking ID:");
		bookingidlbl.setBounds(30,100,200,35);
		bookingidlbl.setForeground(Color.white);
		bookingidlbl.setFont(new Font("Verdana",Font.PLAIN,18));
		bookinghistory1.add(bookingidlbl);
		
		cancelbookingtxt=new JTextField();
		cancelbookingtxt.setBounds(170,100,200,30);
		cancelbookingtxt.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
		cancelbookingtxt.setFont(new Font("Verdana",Font.PLAIN,18));
		bookinghistory1.add(cancelbookingtxt);
		
		JLabel label1=new JLabel("Check-In: ");
		label1.setBounds(30,150,100,35);
		label1.setForeground(Color.white);
		label1.setFont(new Font("Verdana",Font.PLAIN,18));
		bookinghistory1.add(label1);
		
		checkin1 = new JDateChooser();
        checkin1.setDateFormatString("yyyy-MM-dd");
		checkin1.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
		checkin1.setFont(new Font("Verdana",Font.PLAIN,15));
		checkin1.setBounds(170,150,200,30);
		bookinghistory1.add(checkin1);
		
		
		
		JLabel checkout1=new JLabel("Check-out:");
		checkout1.setBounds(30,200,200,35);
		checkout1.setForeground(Color.white);
		checkout1.setFont(new Font("Verdana",Font.PLAIN,18));
		bookinghistory1.add(checkout1);
		
		checkout2 = new JDateChooser();
		checkout2.setDateFormatString("yyyy-MM-dd");
		checkout2.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
		checkout2.setFont(new Font("Verdana",Font.PLAIN,15));
		checkout2.setBounds(170,200,200,30);
		bookinghistory1.add(checkout2);
		
		JLabel bookingtype1=new JLabel("Room Type:");
		bookingtype1.setBounds(30,250,200,35);
		bookingtype1.setForeground(Color.white);
		bookingtype1.setFont(new Font("Verdana",Font.PLAIN,18));
		bookinghistory1.add(bookingtype1);
		
		Object[] h2= {"Single","Twin","Double"};
		
		bookingtypetxt1=new JComboBox(h2);
		bookingtypetxt1.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
		bookingtypetxt1.setBounds(170,250,200,30);
		bookingtypetxt1.setFont(new Font("Verdana",Font.PLAIN,18));
		bookinghistory1.add(bookingtypetxt1);
		
		
		
		bookingbtn1=new JButton("Cancel Booking");
		bookingbtn1.setBounds(30,340,200,35);
		bookingbtn1.setBackground(new Color(21, 159, 133));
		bookingbtn1.setForeground(Color.white);
		bookingbtn1.setFont(new Font("Verdana",Font.PLAIN,18));
		bookingbtn1.addActionListener(this);
		bookinghistory1.add(bookingbtn1);
		bookingbtn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==bookingbtn1) {
					BookingLibs booking = new BookingLibs();
					
		           int cancelbooking=(Integer.parseInt(cancelbookingtxt.getText()));
		            
					
		            
		            booking.setBooking_ID(cancelbooking);
		          

					JDBCBooking jdbc2 = new JDBCBooking();
					boolean result1 = jdbc2.delete(cancelbooking);
					if (result1 == true) {
						updateTable();
						
						ImageIcon i = new ImageIcon(getClass().getResource("5-stars.png"));
						JOptionPane.showMessageDialog(null, "Your booking is cancelled", "Customer Management", JOptionPane.WIDTH, i);
					} else {
						ImageIcon i = new ImageIcon(getClass().getResource("5-stars.png"));
						JOptionPane.showMessageDialog(null, "Error Occured!", "Customer Management", JOptionPane.WIDTH, i);
					}
					
					
				}
				
			}
			
			
			
		});
		
		
		
		bookingclearbtn1=new JButton("Clear");
		bookingclearbtn1.setBounds(250,340,100,35);
		bookingclearbtn1.setBackground(new Color(21, 159, 133));
		bookingclearbtn1.setForeground(Color.white);
		bookingclearbtn1.setFont(new Font("Verdana",Font.PLAIN,18));
		bookinghistory1.add(bookingclearbtn1);
		bookingclearbtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(ae.getSource()==bookingclearbtn1) {
					
					cancelbookingtxt.setText(null);
					checkin1.setCalendar(null);
					checkout2.setCalendar(null);
					bookingtypetxt1.setSelectedIndex(0);
					
				}}});
		
		JButton updatebtn=new JButton("Update Booking");
		updatebtn.setFocusable(false);
		updatebtn.setBounds(100,390,200,35);
		updatebtn.setBackground(new Color(21, 159, 133));
		updatebtn.setForeground(Color.white);
		updatebtn.setFont(new Font("Verdana",Font.PLAIN,18));
		bookinghistory1.add(updatebtn);
		updatebtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(ae.getSource()==updatebtn) {
					
					String date1=((JTextField)checkin1.getDateEditor().getUiComponent()).getText();
					String date2=((JTextField)checkout2.getDateEditor().getUiComponent()).getText();
					String bookingtype=bookingtypetxt1.getSelectedItem().toString();
					int bookingid=Integer.parseInt(cancelbookingtxt.getText());
					
					BookingLibs booking=new BookingLibs();
					booking.setBooking_ID(bookingid);
					booking.setCheckIn(date1);
					booking.setCheckOut(date2);
					booking.setBooking_Type(bookingtype);
					
					JDBCBooking2 jdbc=new JDBCBooking2();
					boolean result =jdbc.updatebooking(booking);
					if(result==true) {
						updateTable();
						ImageIcon i = new ImageIcon(getClass().getResource("5-stars.png"));
						JOptionPane.showMessageDialog(null, "Your booking data is updated", "Customer Dashboard", JOptionPane.WIDTH, i);	
						
					}
					else {
						ImageIcon i = new ImageIcon(getClass().getResource("5-stars.png"));
						JOptionPane.showMessageDialog(null, "Error!", "Customer Dashboard", JOptionPane.WIDTH, i);
					}
					
					
				}}});
		
		
		//****************************Cancel Booking Table******************88
//		dm2=new DefaultTableModel();
//		dm2.addColumn("Customer ID");
//		dm2.addColumn("Name");
//		dm2.addColumn("Booking ID");
//		dm2.addColumn("Check-In");
//		dm2.addColumn("Check-Out");
//		dm2.addColumn("Room Type");
//		dm2.addColumn("Room Status");
		
		columnsName = new Object[7];
		columnsName[0] = "Customer ID";
		columnsName[1] = "Name";
		columnsName[2] = "Booking ID";
		columnsName[3] = "Check-In";
		columnsName[4] = "Check-Out";
		columnsName[5] = "Room Type";
		columnsName[6] = "Room Status";
		
		
		table1 = new JTable(model);
		
		model = (DefaultTableModel) table1.getModel();
		model.setColumnIdentifiers(columnsName);
		
		
//		table1 = new JTable(dm2);
//		table1.addMouseListener(this);
//			
//		
		

//	   
////		JDBCBooking jdbc=new JDBCBooking();
////		ArrayList a1=jdbc.view_all1();
////		if(a1.size()>0) {
////			for(int i=0; i<a1.size(); i++) {
////				BookingLibs2 bio=(BookingLibs2) a1.get(i);
////				Object [] tmp= {bio.getCustomer_ID(),
////						bio.getName(),
////						bio.getBooking_ID(),
////						bio.getCheckIn(),
////						bio.getCheckOut(),
////						bio.getBooking_Type(),
////						bio.getBooking_Status()
////						
////						
////						
////						};
////				dm2.addRow(tmp);
////				
////			}
////			}
////		
		updateTable();
		JScrollPane scroll1=new JScrollPane(table1);
		scroll1.setPreferredSize(new Dimension(200,200));
		bookingHistory.add(scroll1, BorderLayout.CENTER);
		
		
		//**********************Booking Status Panel******************8
		JPanel billgeneratepanel = new javax.swing.JPanel();
		billgeneratepanel.setLayout(new BorderLayout());
		tab.add("Booking Status", billgeneratepanel);
		

		
		dm=new DefaultTableModel();
		dm.addColumn("Customer ID");
		dm.addColumn("Name");
		dm.addColumn("Booking ID");
		dm.addColumn("Check-In");
		dm.addColumn("Check-Out");
		dm.addColumn("Room ID");
		dm.addColumn("Booking Type");
		dm.addColumn("Booking Status");
		
		table2 = new JTable(dm);
		
		JTableHeader t1=table2.getTableHeader();
		t1.setBackground(Color.black);
		t1.setForeground(Color.white);
		table2.setSelectionBackground(Color.black);
		table2.setSelectionForeground(Color.white);
		table2.setRowHeight(30);
		table2.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 18));
		table2.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    table2.setPreferredSize(new Dimension(200,400));
		
		JDBCBooking jdbc1=new JDBCBooking();
		ArrayList CustomerBookingStatus=jdbc1.customerBookingViewAll();
		if(CustomerBookingStatus.size()>0) {
			for(int i=0; i<CustomerBookingStatus.size(); i++) {
				BookingLibs3 bio=(BookingLibs3) CustomerBookingStatus.get(i);
				Object [] tmp= {bio.getCustomer_ID(),
						bio.getName(),
						bio.getBooking_ID(),
						bio.getCheckIn(),
						bio.getCheckOut(),
						bio.getRoom_ID(),
						bio.getBooking_Type(),
						bio.getBooking_Status()
						
						
						
						};
				dm.addRow(tmp);
				
			}
			}
		
		JScrollPane scroll2=new JScrollPane(table2);
	    scroll2.setPreferredSize(new Dimension(200,400));
		billgeneratepanel.add(scroll2, BorderLayout.CENTER);
		
		
			
		
		frame.setVisible(true);
			}
	
	public void updateTable() {
		a1 = new JDBCBooking().view_all1();
		model.setRowCount(0);		
		for (BookingLibs2 bookingLibs : a1) {
			Object tmpRow[] = { 
					bookingLibs.getCustomer_ID(), 
					bookingLibs.getName(),					
					bookingLibs.getBooking_ID(), 
					bookingLibs.getCheckIn(),
					bookingLibs.getCheckOut(),
					bookingLibs.getBooking_Type(),
					bookingLibs.getBooking_Status()
			
			
			};
			
			
			model.addRow(tmpRow);
		}
		
		
		
		table1 = new JTable(model);
		t2=table1.getTableHeader();
		t2.setBackground(Color.black);
		t2.setForeground(Color.white);
		table1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table1.setSelectionBackground(Color.black);
		table1.setSelectionForeground(Color.white);
		table1.setRowHeight(30);
		table1.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 18));
		table1.addMouseListener(this);
		//table.setModel(model);	
		//table.repaint();
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==bookingbtn) {
			
			Room room=new Room();
			
			String bookingtype=bookingtypetxt.getSelectedItem().toString();
                      
            room.setStatus(bookingtype);
            
            
            JDBCRoom jdbc1=new JDBCRoom();
            boolean result1=jdbc1.update1(room);
            

			int cusid=Integer.parseInt(customeridtxt.getText());
			String str1 = ((JTextField)checkin.getDateEditor().getUiComponent()).getText();
            String str2 = ((JTextField)checkout1.getDateEditor().getUiComponent()).getText();
     
            String bookingtype1=bookingtypetxt.getSelectedItem().toString();
            
            
                   
            BookingLibs booking=new BookingLibs();
            
            booking.setCustomer_ID(cusid);
            booking.setCheckIn(str1);
            booking.setCheckOut(str2);
            booking.setBooking_Type(bookingtype);
            booking.setBooking_Status("Requested");
            
            
            JDBCBooking jdbc=new JDBCBooking();
            boolean result=jdbc.insert(booking);
            
            if(result==true) {
            	updateTable();
            	ImageIcon i=new ImageIcon(getClass().getResource("logo 100px.png"));
				JOptionPane.showMessageDialog(null, "You have requested successfully","Room Booking",JOptionPane.WIDTH,i);
            }

		
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource()==table1) {
			
			try {
				
				int tab1=table1.getSelectedRow();
				
				DefaultTableModel model =(DefaultTableModel) table1.getModel();
				
				TableModel tab11=table1.getModel();
				
				String custoid=tab11.getValueAt(tab1, 2).toString();
				cancelbookingtxt.setText(custoid);
				
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(tab1, 3));
				checkin1.setDate(date);
				
				Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(tab1, 4));
				checkout2.setDate(date1);
				
				String statustxt=tab11.getValueAt(tab1, 5).toString();
				bookingtypetxt1.setSelectedItem(statustxt);
				
				
				
			}
			
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		
		
		
		
		
		}}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public static void main(String[] args) {
		new CustomerDashBoard();

	}

	
}
