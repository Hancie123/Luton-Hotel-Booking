package ManagerUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import CustomersUI.CustomerManagement;
import CustomersUI.customerDetails;
import EmployeesUI.EmployeesDetails;
import EmployeesUI.manageEmployees;
import Libs.BillingLibs;
import Libs.BillingLibs2;
import Libs.BillingLibs3;
import Libs.BookingLibs2;
import Libs.BookingLibs3;
import Libs.CustomerLibs;
import Libs.CustomerLibs2;
import Libs.JDBCBilling;
import Libs.JDBCBooking;
import Libs.JDBCCustomer;
import Libs.JDBCRestaurant;
import Libs.JDBCRoom;
import Libs.JDBCServices;
import Libs.PanelRound;
import Libs.RestaurantLibs;
import Libs.Room;
import Libs.ServicesLibs;
import UI.AboutUs;
import UI.CustomerDashBoard;
import UI.LoginWindow;
import UI.ReceptionDashBoard;
import roomUI.AvailableRooms;
import roomUI.RoomManagement;
import roomUI.roomDetails;

public class AdminDashBoard {
	private static final Cursor CURSOR = null;
	protected static final Color COLOR2 = null;

	JFrame frame;
	JPanel mainPanel, titlePanel, westPanel;
	JLabel title, titleLogin, Image, lbl_date, date, totalbookinglbl, totalcustomerlbl1, totalroomlbl1;
	JMenuBar menubar;
	JMenu file, about, customer;
	JMenuItem customer1, about1, customer2, customer3;
	JComboBox switchTo;
	JButton logoutbtn, closebtn, settingbtn;
	JLabel foodlbl1, totalbilllbl,servicelbl1;
	JTable table3,table4;
	DefaultTableModel modeltable2;

	// Default Constructor
	public AdminDashBoard() {
		frame = new JFrame();
		frame.setSize(880, 880);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo 100px.png")));
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());

		// Menu bar
		menubar = new JMenuBar();
		frame.setJMenuBar(menubar);

		// menu for menubar
		file = new JMenu("File");
		menubar.add(file);

		customer = new JMenu("Customer");
		menubar.add(customer);

		JMenu roommenu = new JMenu("Room");
		menubar.add(roommenu);

		JMenu employeesmenu = new JMenu("Employees");
		menubar.add(employeesmenu);

		about = new JMenu("About");
		menubar.add(about);

		JMenuItem logout10 = new JMenuItem("Log Out");
		file.add(logout10);
		logout10.setIcon(new javax.swing.ImageIcon(getClass().getResource("about.png")));
		logout10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == logout10) {
					frame.dispose();
					new LoginWindow();
				}

			}
		});

		JMenuItem exit11 = new JMenuItem("Exit");
		file.add(exit11);
		exit11.setIcon(new javax.swing.ImageIcon(getClass().getResource("about.png")));
		exit11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == exit11) {
					System.exit(0);
				}

			}
		});

		customer1 = new JMenuItem("Manage Customer");
		customer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("customer.png")));
		customer.add(customer1);
		customer1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == customer1) {
					new CustomerManagement();
				}

			}
		});
		customer3 = new JMenuItem("View Customer");
		customer3.setIcon(new javax.swing.ImageIcon(getClass().getResource("customer.png")));
		customer.add(customer3);
		customer3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == customer3) {
					new customerDetails();
				}

			}
		});

		JMenuItem room1 = new JMenuItem("Manage Rooms");
		roommenu.add(room1);

		room1.setIcon(new javax.swing.ImageIcon(getClass().getResource("about.png")));
		room1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == room1) {
					new RoomManagement();
				}

			}
		});
		JMenuItem room2 = new JMenuItem("View Rooms");
		roommenu.add(room2);

		room2.setIcon(new javax.swing.ImageIcon(getClass().getResource("about.png")));
		room2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == room2) {
					new roomDetails();
				}

			}
		});

		JMenuItem room3 = new JMenuItem("View Available Rooms");
		roommenu.add(room3);
		room3.setIcon(new javax.swing.ImageIcon(getClass().getResource("about.png")));
		room3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == room3) {
					new AvailableRooms();
				}

			}
		});

		JMenuItem employees11 = new JMenuItem("Manage Employees");
		employeesmenu.add(employees11);
		employees11.setIcon(new javax.swing.ImageIcon(getClass().getResource("about.png")));
		employees11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == employees11) {
					new manageEmployees();
				}

			}
		});

		JMenuItem employees12 = new JMenuItem("View Employees");
		employeesmenu.add(employees12);
		employees12.setIcon(new javax.swing.ImageIcon(getClass().getResource("about.png")));
		employees12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == employees12) {
					new EmployeesDetails();
				}

			}
		});

		about1 = new JMenuItem("About");
		about.add(about1);

		about1.setIcon(new javax.swing.ImageIcon(getClass().getResource("about.png")));
		about1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == about1) {
					new AboutUs();
				}

			}
		});

		// *******************Title(North) Panel*******************
		titlePanel = new JPanel();
		titlePanel.setLayout(null);
		titlePanel.setBackground(new Color(21, 159, 133));
		titlePanel.setPreferredSize(new Dimension(100, 100));
		frame.add(titlePanel, BorderLayout.NORTH);

		/// Date label
		lbl_date = new JLabel("Date :");
		lbl_date.setBounds(1040, 30, 60, 30);
		lbl_date.setFont(new Font("Verdana", Font.PLAIN, 18));
		lbl_date.setForeground(Color.white);
		titlePanel.add(lbl_date);

		// Adding date to jlabel
		date = new JLabel("");
		date.setBounds(1100, 30, 160, 30);
		date.setFont(new Font("Verdana", Font.PLAIN, 18));
		date.setForeground(Color.white);
		titlePanel.add(date);
		curDate();

		westPanel = new JPanel();
		westPanel.setLayout(null);
		westPanel.setBackground(new Color(106, 101, 101));
		westPanel.setPreferredSize(new Dimension(400, 100));
		frame.add(westPanel, BorderLayout.WEST);

		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(238, 238, 228));
		mainPanel.setLayout(new BorderLayout());
		frame.add(mainPanel, BorderLayout.CENTER);

		// ****************Center panel north panel**************8
		JPanel mainPanelNorth = new JPanel();
		mainPanelNorth.setBackground(Color.WHITE);
		mainPanelNorth.setLayout(null);
		mainPanelNorth.setPreferredSize(new Dimension(100, 400));
		mainPanel.add(mainPanelNorth, BorderLayout.NORTH);

		// ******************Total Booking Panel***************8
		PanelRound BookingPanel = new PanelRound();
		BookingPanel.setBounds(60, 10, 270, 180);
		BookingPanel.setRoundBottomRight(100);
		BookingPanel.setRoundBottomLeft(100);
		BookingPanel.setRoundTopLeft(100);
		BookingPanel.setRoundTopRight(100);
		BookingPanel.setBackground(new Color(21, 159, 133));
		BookingPanel.setLayout(null);
		mainPanelNorth.add(BookingPanel);

		JLabel totalbookinglbl1 = new JLabel("Total Booking");
		totalbookinglbl1.setFont(new Font("Tahoma", Font.BOLD, 30));
		totalbookinglbl1.setForeground(Color.white);
		totalbookinglbl1.setBounds(30, 10, 300, 100);
		BookingPanel.add(totalbookinglbl1);

		totalbookinglbl = new JLabel();
		totalbookinglbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		totalbookinglbl.setForeground(Color.white);
		totalbookinglbl.setBounds(110, 75, 100, 100);
		BookingPanel.add(totalbookinglbl);

		// *******************Total Customer Panel****************8
		PanelRound customerPanel = new PanelRound();
		customerPanel.setBounds(430, 10, 270, 180);
		customerPanel.setRoundBottomRight(100);
		customerPanel.setRoundBottomLeft(100);
		customerPanel.setRoundTopLeft(100);
		customerPanel.setRoundTopRight(100);
		customerPanel.setBackground(new Color(21, 159, 133));
		customerPanel.setPreferredSize(new Dimension(100, 200));
		customerPanel.setLayout(null);
		mainPanelNorth.add(customerPanel);

		JLabel tatalcustomerlbl = new JLabel("Total Customer");
		tatalcustomerlbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		tatalcustomerlbl.setForeground(Color.white);
		tatalcustomerlbl.setBounds(20, 10, 300, 100);
		customerPanel.add(tatalcustomerlbl);

		totalcustomerlbl1 = new JLabel();
		totalcustomerlbl1.setFont(new Font("Tahoma", Font.BOLD, 30));
		totalcustomerlbl1.setForeground(Color.white);
		totalcustomerlbl1.setBounds(110, 75, 100, 100);
		customerPanel.add(totalcustomerlbl1);

		// *********************Total Room Panel**********************8
		PanelRound RoomPanel = new PanelRound();
		RoomPanel.setBounds(800, 10, 270, 180);
		RoomPanel.setRoundBottomRight(100);
		RoomPanel.setRoundBottomLeft(100);
		RoomPanel.setRoundTopLeft(100);
		RoomPanel.setRoundTopRight(100);
		RoomPanel.setBackground(new Color(21, 159, 133));
		RoomPanel.setLayout(null);
		RoomPanel.setPreferredSize(new Dimension(100, 200));
		mainPanelNorth.add(RoomPanel);

		JLabel totalroomlbl = new JLabel("Total Room");
		totalroomlbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		totalroomlbl.setForeground(Color.white);
		totalroomlbl.setBounds(50, 10, 300, 100);
		RoomPanel.add(totalroomlbl);

		totalroomlbl1 = new JLabel();
		totalroomlbl1.setFont(new Font("Tahoma", Font.BOLD, 30));
		totalroomlbl1.setForeground(Color.white);
		totalroomlbl1.setBounds(110, 75, 100, 100);
		RoomPanel.add(totalroomlbl1);

		// *****************Total Bill Profit*****************
		PanelRound totalbillpanel = new PanelRound();
		totalbillpanel.setBounds(60, 210, 270, 180);
		totalbillpanel.setRoundBottomRight(100);
		totalbillpanel.setRoundBottomLeft(100);
		totalbillpanel.setRoundTopLeft(100);
		totalbillpanel.setRoundTopRight(100);
		totalbillpanel.setBackground(new Color(21, 159, 133));
		totalbillpanel.setLayout(null);
		mainPanelNorth.add(totalbillpanel);

		JLabel totalbilllnl = new JLabel("Total Earned ");
		totalbilllnl.setFont(new Font("Tahoma", Font.BOLD, 30));
		totalbilllnl.setForeground(Color.white);
		totalbilllnl.setBounds(30, 10, 300, 100);
		totalbillpanel.add(totalbilllnl);

		totalbilllbl = new JLabel();
		totalbilllbl.setFont(new Font("Tahoma", Font.BOLD, 25));
		totalbilllbl.setForeground(Color.white);
		totalbilllbl.setBounds(60, 75, 150, 100);
		totalbillpanel.add(totalbilllbl);

		// *****************Total Food Profit*****************
		PanelRound foodpanel = new PanelRound();
		foodpanel.setBounds(430, 210, 270, 180);
		foodpanel.setRoundBottomRight(100);
		foodpanel.setRoundBottomLeft(100);
		foodpanel.setRoundTopLeft(100);
		foodpanel.setRoundTopRight(100);
		foodpanel.setBackground(new Color(21, 159, 133));
		foodpanel.setLayout(null);
		mainPanelNorth.add(foodpanel);

		JLabel foodlbl = new JLabel("Food Earned ");
		foodlbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		foodlbl.setForeground(Color.white);
		foodlbl.setBounds(30, 10, 300, 100);
		foodpanel.add(foodlbl);

		foodlbl1 = new JLabel();
		foodlbl1.setFont(new Font("Tahoma", Font.BOLD, 25));
		foodlbl1.setForeground(Color.white);
		foodlbl1.setBounds(60, 75, 150, 100);
		foodpanel.add(foodlbl1);
		
		// *****************Total Service Profit*****************
				PanelRound servicepanel = new PanelRound();
				servicepanel.setBounds(800, 210, 270, 180);
				servicepanel.setRoundBottomRight(100);
				servicepanel.setRoundBottomLeft(100);
				servicepanel.setRoundTopLeft(100);
				servicepanel.setRoundTopRight(100);
				servicepanel.setBackground(new Color(21, 159, 133));
				servicepanel.setLayout(null);
				mainPanelNorth.add(servicepanel);

				JLabel servicelbl = new JLabel("Service Earned ");
				servicelbl.setFont(new Font("Tahoma", Font.BOLD, 30));
				servicelbl.setForeground(Color.white);
				servicelbl.setBounds(30, 10, 300, 100);
				servicepanel.add(servicelbl);

				servicelbl1 = new JLabel();
				servicelbl1.setFont(new Font("Tahoma", Font.BOLD, 25));
				servicelbl1.setForeground(Color.white);
				servicelbl1.setBounds(60, 75, 150, 100);
				servicepanel.add(servicelbl1);

		// *****************West Customer View Panel*******************8
		PanelRound mainPanelNorth1 = new PanelRound();
		mainPanelNorth1.setBounds(10, 10, 375, 100);
		mainPanelNorth1.setRoundBottomRight(100);
		mainPanelNorth1.setRoundBottomLeft(100);
		mainPanelNorth1.setRoundTopLeft(100);
		mainPanelNorth1.setRoundTopRight(100);
		mainPanelNorth1.setBackground(new Color(21, 159, 133));
		mainPanelNorth1.setLayout(new GridLayout(1, 1));
		mainPanelNorth1.setPreferredSize(new Dimension(100, 200));
		westPanel.add(mainPanelNorth1);

		JLabel totalBooking = new JLabel("Manage Customers", JLabel.CENTER);
		totalBooking.setIcon(new javax.swing.ImageIcon(getClass().getResource("Hotel.png")));
		totalBooking.setFont(new Font("Tahoma", Font.BOLD, 18));
		mainPanelNorth1.add(totalBooking);
		totalBooking.setCursor(CURSOR);
		totalBooking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ae) {
				new CustomerManagement();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				totalBooking.setForeground(Color.green);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				totalBooking.setForeground(COLOR2);
			}
		});

		PanelRound mainPanelNorth2 = new PanelRound();
		mainPanelNorth2.setBounds(10, 120, 375, 100);
		mainPanelNorth2.setRoundBottomRight(100);
		mainPanelNorth2.setRoundBottomLeft(100);
		mainPanelNorth2.setRoundTopLeft(100);
		mainPanelNorth2.setRoundTopRight(100);
		mainPanelNorth2.setBackground(new Color(21, 159, 133));
		westPanel.add(mainPanelNorth2);

		JLabel newBooking = new JLabel("Manage Employees", JLabel.CENTER);
		newBooking.setFont(new Font("Tahoma", Font.BOLD, 18));
		newBooking.setIcon(new javax.swing.ImageIcon(getClass().getResource("Booking.png")));
		mainPanelNorth2.add(newBooking);
		newBooking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ae) {
				new manageEmployees();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				newBooking.setForeground(Color.green);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				newBooking.setForeground(COLOR2);
			}
		});

		PanelRound mainPanelNorth3 = new PanelRound();
		mainPanelNorth3.setBounds(10, 230, 375, 100);
		mainPanelNorth3.setRoundBottomRight(100);
		mainPanelNorth3.setRoundBottomLeft(100);
		mainPanelNorth3.setRoundTopLeft(100);
		mainPanelNorth3.setRoundTopRight(100);
		mainPanelNorth3.setBackground(new Color(21, 159, 133));
		westPanel.add(mainPanelNorth3);

		JLabel roomType = new JLabel("Manage Rooms", JLabel.CENTER);
		roomType.setFont(new Font("Tahoma", Font.BOLD, 18));
		roomType.setIcon(new javax.swing.ImageIcon(getClass().getResource("Hotel.png")));
		mainPanelNorth3.add(roomType);
		roomType.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ae) {
				new RoomManagement();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				roomType.setForeground(Color.green);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				roomType.setForeground(COLOR2);
			}
		});

		PanelRound mainPanelNorth4 = new PanelRound();
		mainPanelNorth4.setBounds(10, 340, 375, 100);
		mainPanelNorth4.setRoundBottomRight(100);
		mainPanelNorth4.setRoundBottomLeft(100);
		mainPanelNorth4.setRoundTopLeft(100);
		mainPanelNorth4.setRoundTopRight(100);
		mainPanelNorth4.setBackground(new Color(21, 159, 133));
		westPanel.add(mainPanelNorth4);

		JLabel specialOffer = new JLabel("Special Offer: 10", JLabel.CENTER);
		specialOffer.setFont(new Font("Tahoma", Font.BOLD, 18));
		specialOffer.setIcon(new javax.swing.ImageIcon(getClass().getResource("Offer.png")));
		mainPanelNorth4.add(specialOffer);

		settingbtn = new JButton("Settings");
		settingbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("settings (3).png")));
		settingbtn.setBounds(120, 495, 170, 40);
		settingbtn.setBackground(new Color(21, 159, 133));
		settingbtn.setForeground(Color.WHITE);
		settingbtn.setFont(new Font("Verdana", Font.PLAIN, 20));
		westPanel.add(settingbtn);
		settingbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == settingbtn) {

					new admingSettingUI();
				}

			}

		});

		logoutbtn = new JButton("Log Out");
		logoutbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("shutdown.png")));
		logoutbtn.setBounds(120, 545, 170, 40);
		logoutbtn.setBackground(new Color(21, 159, 133));
		logoutbtn.setForeground(Color.WHITE);
		logoutbtn.setFont(new Font("Verdana", Font.PLAIN, 20));
		westPanel.add(logoutbtn);
		logoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == logoutbtn) {
					frame.dispose();
					new LoginWindow();
				}

			}

		});

		closebtn = new JButton("Close");
		closebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("close.png")));
		closebtn.setBounds(120, 595, 170, 40);
		closebtn.setBackground(new Color(21, 159, 133));
		closebtn.setForeground(Color.WHITE);
		closebtn.setFont(new Font("Verdana", Font.PLAIN, 20));
		westPanel.add(closebtn);
		closebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == closebtn) {
					System.exit(0);
				}
			}

		});

		// ******************Booking Table******************88
		DefaultTableModel dm2 = new DefaultTableModel();
		dm2.addColumn("Customer ID");
		dm2.addColumn("Name");
		dm2.addColumn("Booking ID");
		dm2.addColumn("Check-In");
		dm2.addColumn("Check-Out");
		dm2.addColumn("Status");
		dm2.addColumn("Room ID");

		JTable table1 = new JTable(dm2);
		JTableHeader t2 = table1.getTableHeader();
		t2.setBackground(Color.black);
		t2.setForeground(Color.white);
		table1.setSelectionBackground(Color.black);
		table1.setSelectionForeground(Color.white);
		table1.setRowHeight(30);
		table1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		table1.getTableHeader().setFont(new Font("Sans Serif", Font.BOLD, 18));
		table1.setBounds(10, 10, 700, 200);

		JDBCBooking jdbc = new JDBCBooking();
		ArrayList a5 = jdbc.ReceptionViewAllCustomer();
		if (a5.size() > 0) {
			for (int i = 0; i < a5.size(); i++) {
				BookingLibs3 bio = (BookingLibs3) a5.get(i);
				Object[] tmp = { bio.getCustomer_ID(),
						bio.getName(),
						bio.getBooking_ID(),
						bio.getCheckIn(),
						bio.getCheckOut(),
						bio.getBooking_Type(),
						bio.getBooking_Status()

				};
				dm2.addRow(tmp);

			}
		}
		int row1 = table1.getRowCount();
		totalbookinglbl.setText(Integer.toString(row1));

		JScrollPane scroll1 = new JScrollPane(table1);
		scroll1.setPreferredSize(new Dimension(200, 200));
		mainPanel.add(scroll1, BorderLayout.CENTER);

		Image = new JLabel();
		Image img = new ImageIcon(this.getClass().getResource("logo 100px.png")).getImage();
		Image.setIcon(new ImageIcon(img));
		Image.setBounds(0, 0, 150, 100);
		titlePanel.add(Image);

		title = new JLabel("Admin DashBoard");
		title.setBounds(150, 30, 250, 35);
		title.setFont(new Font("Tahoma", Font.BOLD, 25));
		title.setForeground(Color.WHITE);
		titlePanel.add(title);

		titleLogin = new JLabel("Switch To", JLabel.CENTER);
		titleLogin.setBounds(1220, 30, 120, 35);
		titleLogin.setBackground(new Color(85, 239, 196));
		titleLogin.setOpaque(true);
		titleLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titleLogin.setForeground(Color.BLACK);
		titlePanel.add(titleLogin);

		String[] Channel = { "Select","Logout" };
		switchTo = new JComboBox(Channel);
		switchTo.setBounds(1350, 30, 180, 35);
		switchTo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		switchTo.setForeground(Color.BLACK);
		titlePanel.add(switchTo);
		switchTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String value = (String) switchTo.getSelectedItem(); // get the selected item in the combobox
				switch (value) {
				case "Logout":
					frame.dispose();
					LoginWindow b4 = new LoginWindow();
					break;

				}
			}

		});

		// *********************Customer Table*********************
		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("ID");
		JTable table = new JTable(dm);
		table.setGridColor(Color.white);
		table.setRowHeight(25);
		JTableHeader h1 = table.getTableHeader();
		h1.setBackground(Color.black);
		h1.setForeground(Color.white);
		h1.setFont(new Font("Times New Roman", Font.BOLD, 16));

		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setSelectionBackground(Color.black);
		table.setSelectionForeground(Color.white);
		JDBCCustomer jdbc2 = new JDBCCustomer();
		ArrayList select = jdbc2.select_all();
		if (select.size() > 0) {
			for (int i = 0; i < select.size(); i++) {
				CustomerLibs customer2 = (CustomerLibs) select.get(i);
				Object[] tmp = { customer2.getCustomer_ID()

				};

				dm.addRow(tmp);
			}

		}
		int totalcustomer = table.getRowCount();
		totalcustomerlbl1.setText(Integer.toString(totalcustomer));

		// ******************Room Table***********************
		DefaultTableModel modeltable = new DefaultTableModel();
		JTable table2 = new JTable(modeltable);
		JTableHeader h5 = table.getTableHeader();

		modeltable.addColumn("ID");

		JDBCRoom jdbc3 = new JDBCRoom();
		ArrayList room = jdbc3.select_all();
		if (room.size() > 0) {
			for (int i = 0; i < room.size(); i++) {
				Room p = (Room) room.get(i);
				Object[] tmp = { p.getId(), };
				modeltable.addRow(tmp);
			}
		}
		int totalroom = table2.getRowCount();
		totalroomlbl1.setText(Integer.toString(totalroom));

		// ******************************Billing Table*********************

		modeltable2 = new DefaultTableModel();
		table3 = new JTable(modeltable2);
		JTableHeader h6 = table3.getTableHeader();

		modeltable2.addColumn("ID");

		modeltable2.addColumn("Bill");

		JDBCBilling jdbc4 = new JDBCBilling();
		ArrayList select2 = jdbc4.select_all();
		if (select2.size() > 0) {
			for (int i = 0; i < select2.size(); i++) {
				BillingLibs3 p1 = (BillingLibs3) select2.get(i);

				Object[] tmp = { p1.getBilling_ID(),
						p1.getTotal_Bill(), };
				modeltable2.addRow(tmp);
			}
		}

		int sum = 0;
		for (int i = 0; i < table3.getRowCount(); i++) {
			sum = (int) (sum + Double.parseDouble(table3.getValueAt(i, 1).toString()));
		}
		
		

		

		totalbilllbl.setText("Rs: " + sum);
		
		foodlbl1.setText(Integer.toString(sum));
		
		
		// ******************************Food Table*********************

		   DefaultTableModel modeltable3 = new DefaultTableModel();
				table4 = new JTable(modeltable3);
				JTableHeader h7 = table4.getTableHeader();

				modeltable3.addColumn("ID");

				modeltable3.addColumn("Bill");

				JDBCRestaurant jdbc5 = new JDBCRestaurant();
				ArrayList select3 = jdbc5.select_all();
				if (select3.size() > 0) {
					for (int i = 0; i < select3.size(); i++) {
						RestaurantLibs p2 = (RestaurantLibs) select3.get(i);

						Object[] tmp = {
								p2.getItem_Amount(),
								};
						modeltable3.addRow(tmp);
					}
				}

				int sum1 = 0;
				for (int i = 0; i < table4.getRowCount(); i++) {
					sum1 = (int) (sum1 + Double.parseDouble(table4.getValueAt(i, 0).toString()));
				}
				
				foodlbl1.setText("Rs: " + sum1);
				
				
				

				// ******************************Service Table*********************

				   DefaultTableModel modeltable4 = new DefaultTableModel();
					JTable	table5 = new JTable(modeltable4);
						JTableHeader h8 = table5.getTableHeader();

						modeltable4.addColumn("ID");

						

						JDBCServices jdbc6 = new JDBCServices();
						ArrayList select5 = jdbc6.select_all();
						if (select5.size() > 0) {
							for (int i = 0; i < select5.size(); i++) {
								ServicesLibs p2 = (ServicesLibs) select5.get(i);

								Object[] tmp = {
										p2.getServices_Price()
										 };
								modeltable4.addRow(tmp);
							}
						}

						
						
						int sum3 = 0;
						for (int i = 0; i < table5.getRowCount(); i++) {
							sum3 = (int) (sum3 + Double.parseDouble(table5.getValueAt(i, 0).toString()));
						}
						servicelbl1.setText("Rs: " + sum3);
						


		frame.setVisible(true);

	}

	public void curDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY/MM/dd");
		LocalDateTime today = LocalDateTime.now();
		date.setText(dtf.format(today));

	}

	public static void main(String[] args) {
		new AdminDashBoard();

	}

}
