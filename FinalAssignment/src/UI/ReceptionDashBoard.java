package UI;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
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
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import CustomersUI.CorporateCustomerManagement;
import CustomersUI.CustomerManagement;
import CustomersUI.customerDetails;
import Libs.BookingLibs;
import Libs.BookingLibs2;
import Libs.BookingLibs3;
import Libs.Global;
import Libs.JDBCBooking;
import Libs.JDBCRoom;
import Libs.MaterialTabbed;
import Libs.Room;
import ManagerUI.ServicesGUI;
import billing.BillingGUI;
import billing.CorporateBilling;
import bookingUI.CheckInGUI;
import foodsUI.FoodMenu;
import foodsUI.FoodsGUI;
import roomUI.AvailableRooms;
import roomUI.RoomManagement;

public class ReceptionDashBoard implements MouseListener {

	protected static final Color COLOR = null;

	JFrame frame;
	JPanel panel, title, center, north, south;
	JLabel startDate, checkOut, image, roomNo, days, titlelbl, payment, roomID, resultlbl, roomType, floor, title1,
			customerID, customerName, availableroomlbl, manageroomlbl, managecustomerlbl, manageservicesbl,
			managebillinglbl;

	JTextField roomtxt, roomIDTxt, CustomerNametxt, bookingsearch, bookingtxt, searchtxt;
	JComboBox daysCombo, roomTypeCombo, floorCombo, paymentMethodCombo;
	JButton check, checkbtn;
	TableRowSorter sorter;
	JTable table, table1;
	DefaultTableModel dtm, model;
	JTextField bookingidtxt, customeridtxt, roomidtxt;
	JDateChooser checkin, checkout1;
	JComboBox bookingtypetext;
	Object[] columnsName;
	ArrayList<BookingLibs3> a5;

	public ReceptionDashBoard() {

		// *******************Main Frame*********************
		frame = new JFrame();
		frame.setBackground(new Color(102, 204, 255));
		frame.setTitle("Luton Hotel Booking System");
		frame.setResizable(true);
		frame.setSize(950, 500);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(new BorderLayout());

		// **************************Center Panel******************
		center = new JPanel();
		center.setBackground(new Color(21, 159, 133));
		center.setLayout(new BorderLayout());
		frame.add(center, BorderLayout.CENTER);

		// *********************Center North Panel******************
		JPanel northPanel = new JPanel();
		northPanel.setBackground(new Color(21, 159, 133));
		northPanel.setLayout(null);
		northPanel.setPreferredSize(new Dimension(100, 380));
		center.add(northPanel, BorderLayout.NORTH);

		JLabel roomlbl = new JLabel("Check Available Room");
		roomlbl.setFont(new Font("Tahoma", Font.BOLD, 40));
		roomlbl.setForeground(Color.white);
		roomlbl.setBounds(300, 50, 500, 40);
		northPanel.add(roomlbl);

		checkbtn = new JButton("Check");
		checkbtn.setFocusable(false);
		checkbtn.setFont(new Font("Verdana", Font.BOLD, 25));
		checkbtn.setBounds(450, 150, 150, 45);
		checkbtn.setForeground(Color.white);
		checkbtn.setBackground(new Color(99, 110, 114));
		northPanel.add(checkbtn);
		checkbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				new AvailableRooms();

			}

		});

		resultlbl = new JLabel();
		resultlbl.setFont(new Font("Verdana", Font.BOLD, 18));
		resultlbl.setBounds(400, 210, 350, 35);
		resultlbl.setForeground(Color.white);
		resultlbl.setBackground(new Color(99, 110, 114));
		northPanel.add(resultlbl);

		// ********************Center Booking Table*********************
		columnsName = new Object[8];
		columnsName[0] = "Customer ID";
		columnsName[1] = "Name";
		columnsName[2] = "Booking ID";
		columnsName[3] = "Check-In";
		columnsName[4] = "Check-Out";
		columnsName[5] = "Room ID";
		columnsName[6] = "Room Type";
		columnsName[7] = "Room Status";

		table1 = new JTable(model);

		model = (DefaultTableModel) table1.getModel();
		model.setColumnIdentifiers(columnsName);

		updateTable();
		JScrollPane scroll1 = new JScrollPane(table1);
		scroll1.setPreferredSize(new Dimension(200, 250));
		center.add(scroll1, BorderLayout.SOUTH);

		// *******************Center Center Panel******************
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(new Color(105, 105, 105));
		centerPanel.setLayout(null);
		centerPanel.setPreferredSize(new Dimension(100, 300));
		center.add(centerPanel, BorderLayout.CENTER);

		JLabel searchlbl = new JLabel("Search Customer:");
		searchlbl.setFont(new Font("Tahoma", Font.BOLD, 25));
		searchlbl.setForeground(Color.white);
		searchlbl.setBounds(20, 25, 450, 25);
		centerPanel.add(searchlbl);

		searchtxt = new JTextField();
		searchtxt.setBounds(250, 20, 250, 35);
		searchtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		searchtxt.setFont(new Font("Verdana", Font.PLAIN, 25));
		centerPanel.add(searchtxt);

		searchtxt.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				search(searchtxt.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				search(searchtxt.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				search(searchtxt.getText());
			}

			public void search(String str) {
				if (str.length() == 0) {
					sorter.setRowFilter(null);
				} else {
					sorter.setRowFilter(RowFilter.regexFilter(str));
				}
			}
		});

		title = new JPanel();
		title.setLayout(null);
		title.setBackground(new Color(68, 71, 101));
		title.setPreferredSize(new Dimension(100, 70));
		frame.getContentPane().add(title, BorderLayout.NORTH);

		titlelbl = new JLabel("Reception Dashboard", SwingConstants.CENTER);
		titlelbl.setFont(new Font("Tahoma", Font.BOLD, 35));
		titlelbl.setForeground(Color.white);
		titlelbl.setBounds(500, 20, 450, 35);
		title.add(titlelbl);

		JLabel welcomelbl = new JLabel("Welcome: ");
		welcomelbl.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		welcomelbl.setForeground(Color.white);
		welcomelbl.setBounds(1300, 20, 150, 35);
		title.add(welcomelbl);

		JLabel welcomelbl1 = new JLabel();
		welcomelbl1.setText(Global.registrationUser.getUsername());
		welcomelbl1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		welcomelbl1.setForeground(Color.white);
		welcomelbl1.setBounds(1390, 20, 150, 35);
		title.add(welcomelbl1);

		MaterialTabbed tabbedPane = new MaterialTabbed();
		tabbedPane.setBounds(23, 80, 450, 250);
		tabbedPane.setPreferredSize(new Dimension(450, 100));
		frame.add(tabbedPane, BorderLayout.WEST);

		// ********************Check Booking Panel for west side**************8
		panel = new JPanel();
		panel.setBackground(new Color(106, 101, 101));
		panel.setLayout(null);
		tabbedPane.add("Booking", panel);

		title1 = new JLabel("CHECK FOR BOOKING", JLabel.CENTER);
		title1.setFont(new Font("Tahoma", Font.BOLD, 18));
		title1.setForeground(Color.white);
		title1.setBounds(100, 0, 250, 35);
		panel.add(title1);

		JSeparator separator1 = new JSeparator();
		separator1.setBounds(10, 30, 470, 21);
		panel.add(separator1);

		JLabel bookinglbl = new JLabel("Booking ID:");
		bookinglbl.setBounds(20, 50, 200, 35);
		bookinglbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		bookinglbl.setForeground(Color.white);
		panel.add(bookinglbl);

		bookingtxt = new JTextField();
		bookingtxt.setBounds(180, 50, 250, 35);
		bookingtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		bookingtxt.setFont(new Font("Verdana", Font.PLAIN, 18));
		panel.add(bookingtxt);

		JLabel CheckInlbl = new JLabel("Check-In Date:");
		CheckInlbl.setBounds(20, 100, 200, 35);
		CheckInlbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		CheckInlbl.setForeground(Color.white);
		panel.add(CheckInlbl);

		checkin = new JDateChooser();
		checkin.setDateFormatString("yyyy-MM-dd");
		checkin.setBounds(180, 100, 250, 35);
		checkin.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		checkin.setFont(new Font("Verdana", Font.PLAIN, 18));
		panel.add(checkin);

		JLabel CheckOutlbl = new JLabel("Check-Out Date:");
		CheckOutlbl.setBounds(20, 150, 200, 35);
		CheckOutlbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		CheckOutlbl.setForeground(Color.white);
		panel.add(CheckOutlbl);

		checkout1 = new JDateChooser();
		checkout1.setDateFormatString("yyyy-MM-dd");
		checkout1.setBounds(180, 150, 250, 35);
		checkout1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		checkout1.setFont(new Font("Verdana", Font.PLAIN, 18));
		panel.add(checkout1);

		JLabel roomidlbl = new JLabel("Room No:");
		roomidlbl.setBounds(20, 200, 200, 35);
		roomidlbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		roomidlbl.setForeground(Color.white);
		panel.add(roomidlbl);

		roomidtxt = new JTextField();
		roomidtxt.setBounds(180, 200, 250, 35);
		roomidtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		roomidtxt.setFont(new Font("Verdana", Font.PLAIN, 18));
		panel.add(roomidtxt);

		JLabel statuslbl = new JLabel("Status:");
		statuslbl.setBounds(20, 250, 200, 35);
		statuslbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		statuslbl.setForeground(Color.white);
		panel.add(statuslbl);

		Object[] h5 = { "Booked", "Room Not Available" };
		bookingtypetext = new JComboBox(h5);
		bookingtypetext.setBounds(180, 250, 250, 35);
		bookingtypetext.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		bookingtypetext.setFont(new Font("Verdana", Font.PLAIN, 18));
		panel.add(bookingtypetext);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 310, 470, 21);
		panel.add(separator);

		check = new JButton("Confirm Booking");
		check.setFocusable(false);
		check.setFont(new Font("Tahoma", Font.PLAIN, 18));
		check.setForeground(Color.WHITE);
		check.setBackground(new Color(21, 159, 133));
		check.setBounds(80, 340, 180, 35);
		panel.add(check);
		check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// *********Update Room Status***************
				Room room = new Room();

				int room_id1 = Integer.parseInt(roomidtxt.getText());

				room.setId(room_id1);
				room.setStatus("Booked");
				JDBCRoom jdbc1 = new JDBCRoom();
				boolean result1 = jdbc1.update1(room);

				// **************Update Customer Booking***********************
				int cusid = Integer.parseInt(bookingtxt.getText());
				String str1 = ((JTextField) checkin.getDateEditor().getUiComponent()).getText();
				String str2 = ((JTextField) checkout1.getDateEditor().getUiComponent()).getText();

				String bookingtype1 = bookingtypetext.getSelectedItem().toString();
				int room_id = Integer.parseInt(roomidtxt.getText());

				BookingLibs booking = new BookingLibs();

				booking.setBooking_ID(cusid);
				booking.setCheckIn(str1);
				booking.setCheckOut(str2);
				booking.setRoom_ID(room_id);
				booking.setBooking_Status(bookingtype1);

				JDBCBooking jdbc = new JDBCBooking();
				boolean result = jdbc.update(booking);

				if (result == true) {
					updateTable();
					ImageIcon i = new ImageIcon(getClass().getResource("logo 100px.png"));
					JOptionPane.showMessageDialog(null, "The booking is done", "Room Booking", JOptionPane.WIDTH, i);
				}

			}

		});

		// ********************West Side Services Panel*********************8
		JPanel servicesPanel = new JPanel();
		servicesPanel.setLayout(null);
		tabbedPane.add("View Services", servicesPanel);

		// *****************Available Room Panel***************
		JPanel availableroomPanel = new JPanel();
		availableroomPanel.setLayout(null);
		availableroomPanel.setBackground(new Color(21, 159, 133));
		availableroomPanel.setBounds(10, 10, 200, 200);
		servicesPanel.add(availableroomPanel);

		// *******************Image for available room***************8
		JLabel img = new JLabel();
		img.setIcon(new javax.swing.ImageIcon(getClass().getResource("room.png")));
		img.setBounds(40, 20, 128, 128);
		img.setFont(new Font("Tahoma", Font.BOLD, 18));
		img.setForeground(Color.white);
		availableroomPanel.add(img);

		// *******************Label for available room***************
		availableroomlbl = new JLabel("Manage Corp Client");
		availableroomlbl.setBounds(10, 150, 200, 30);
		availableroomlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		availableroomlbl.setForeground(Color.white);
		availableroomlbl.addMouseListener(this);
		availableroomPanel.add(availableroomlbl);
		availableroomlbl.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new CorporateCustomerManagement();
			}

		});

		// **************Manage Room Panel***********************
		JPanel manageroomPanel = new JPanel();
		manageroomPanel.setLayout(null);
		manageroomPanel.setBackground(new Color(21, 159, 133));
		manageroomPanel.setBounds(230, 10, 200, 200);
		servicesPanel.add(manageroomPanel);

		// *******************Image for manage room***************8
		JLabel img1 = new JLabel();
		img1.setIcon(new javax.swing.ImageIcon(getClass().getResource("room.png")));
		img1.setBounds(40, 20, 128, 128);
		img1.setFont(new Font("Tahoma", Font.BOLD, 18));
		img1.setForeground(Color.white);
		manageroomPanel.add(img1);

		// *******************Label for manage room***************
		manageroomlbl = new JLabel("Manage Rooms");
		manageroomlbl.setBounds(20, 150, 200, 30);
		manageroomlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		manageroomlbl.setForeground(Color.white);
		manageroomlbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				manageroomlbl.setForeground(new Color(147, 250, 165));

			}

			@Override
			public void mouseExited(MouseEvent e) {

				manageroomlbl.setForeground(COLOR);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				new RoomManagement();
			}

		});
		manageroomPanel.add(manageroomlbl);

		// ********************Manage Customers*****************
		JPanel managecustomerPanel = new JPanel();
		managecustomerPanel.setLayout(null);
		managecustomerPanel.setBackground(new Color(21, 159, 133));
		managecustomerPanel.setBounds(10, 220, 200, 200);
		servicesPanel.add(managecustomerPanel);

		// *******************Image for manage Customers***************8
		JLabel img2 = new JLabel();
		img2.setIcon(new javax.swing.ImageIcon(getClass().getResource("view.png")));
		img2.setBounds(40, 20, 128, 128);
		img2.setFont(new Font("Tahoma", Font.BOLD, 18));
		img2.setForeground(Color.white);
		managecustomerPanel.add(img2);

		// *******************Label for manage Customers***************
		managecustomerlbl = new JLabel("Manage Customers");
		managecustomerlbl.setBounds(10, 150, 200, 30);
		managecustomerlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		managecustomerlbl.setForeground(Color.white);
		managecustomerPanel.add(managecustomerlbl);
		managecustomerlbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				managecustomerlbl.setForeground(new Color(147, 250, 165));

			}

			@Override
			public void mouseExited(MouseEvent e) {

				managecustomerlbl.setForeground(COLOR);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				new CustomerManagement();
			}

		});

		// ********************Manage Services*****************
		JPanel manageservicesPanel = new JPanel();
		manageservicesPanel.setLayout(null);
		manageservicesPanel.setBackground(new Color(21, 159, 133));
		manageservicesPanel.setBounds(230, 220, 200, 200);
		servicesPanel.add(manageservicesPanel);

		// *******************Image for manage Services***************8
		JLabel img3 = new JLabel();
		img3.setIcon(new javax.swing.ImageIcon(getClass().getResource("customer1 (2).png")));
		img3.setBounds(40, 20, 128, 128);
		img3.setFont(new Font("Tahoma", Font.BOLD, 18));
		img3.setForeground(Color.white);
		manageservicesPanel.add(img3);

		// *******************Label for manage Services***************
		manageservicesbl = new JLabel("Manage Services");
		manageservicesbl.setBounds(20, 150, 200, 30);
		manageservicesbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		manageservicesbl.setForeground(Color.white);
		manageservicesPanel.add(manageservicesbl);
		manageservicesbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				manageservicesbl.setForeground(new Color(147, 250, 165));

			}

			@Override
			public void mouseExited(MouseEvent e) {

				manageservicesbl.setForeground(COLOR);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				new ServicesGUI();
			}

		});

		// ********************Manage Billing*****************
		JPanel managebillingPanel = new JPanel();
		managebillingPanel.setLayout(null);
		managebillingPanel.setBackground(new Color(21, 159, 133));
		managebillingPanel.setBounds(10, 430, 200, 200);
		servicesPanel.add(managebillingPanel);

		// *******************Image for manage Services***************8
		JLabel img4 = new JLabel();
		img4.setIcon(new javax.swing.ImageIcon(getClass().getResource("bill.png")));
		img4.setBounds(40, 20, 128, 128);
		img4.setFont(new Font("Tahoma", Font.BOLD, 18));
		img4.setForeground(Color.white);
		managebillingPanel.add(img4);

		// *******************Label for manage Services***************
		managebillinglbl = new JLabel("Customers Billing");
		managebillinglbl.setBounds(20, 150, 200, 30);
		managebillinglbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		managebillinglbl.setForeground(Color.white);
		managebillingPanel.add(managebillinglbl);
		managebillinglbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				managebillinglbl.setForeground(new Color(147, 250, 165));

			}

			@Override
			public void mouseExited(MouseEvent e) {

				managebillinglbl.setForeground(COLOR);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				new BillingGUI();
			}

		});

		// ********************Manage Billing*****************
		JPanel managecorporatebilling = new JPanel();
		managecorporatebilling.setLayout(null);
		managecorporatebilling.setBackground(new Color(21, 159, 133));
		managecorporatebilling.setBounds(230, 430, 200, 200);
		servicesPanel.add(managecorporatebilling);

		// *******************Image for manage Services***************8
		JLabel img5 = new JLabel();
		img5.setIcon(new javax.swing.ImageIcon(getClass().getResource("bill.png")));
		img5.setBounds(40, 20, 128, 128);
		img5.setFont(new Font("Tahoma", Font.BOLD, 18));
		img5.setForeground(Color.white);
		managecorporatebilling.add(img5);

		// *******************Label for manage Services***************
		JLabel managecorporatebillinglbl = new JLabel("Corporate Billing");
		managecorporatebillinglbl.setBounds(20, 150, 200, 30);
		managecorporatebillinglbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		managecorporatebillinglbl.setForeground(Color.white);
		managecorporatebilling.add(managecorporatebillinglbl);
		managecorporatebillinglbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				managecorporatebillinglbl.setForeground(new Color(147, 250, 165));

			}

			@Override
			public void mouseExited(MouseEvent e) {

				managecorporatebillinglbl.setForeground(COLOR);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				new CorporateBilling();
			}

		});

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu file = new JMenu("File");
		JMenu room = new JMenu("Room");
		JMenu customerMenu = new JMenu("Customers");
		JMenu booking = new JMenu("Booking");
		JMenu setting = new JMenu("Setting");
		JMenu services = new JMenu("Services");
		JMenu billing = new JMenu("Billing");
		JMenu about = new JMenu("About");

		menuBar.add(file);
		menuBar.add(room);
		menuBar.add(customerMenu);
		menuBar.add(booking);
		menuBar.add(setting);
		menuBar.add(services);
		menuBar.add(billing);
		menuBar.add(about);

		JMenuItem customer = new JMenuItem("Manage Customers");
		customer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == customer) {

					new CustomerManagement();
				}
			}
		});
		file.add(customer);

		JMenuItem viewCustomer = new JMenuItem("View Customers");
		viewCustomer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == viewCustomer) {

					new customerDetails();
				}
			}
		});
		file.add(viewCustomer);

		JMenuItem LogOut = new JMenuItem("Log Out");
		LogOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == LogOut) {
					frame.dispose();
					new LoginWindow();
				}
			}
		});
		file.add(LogOut);

		JMenuItem Exit = new JMenuItem("Exit");
		Exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == Exit) {
					System.exit(0);
				}
			}
		});
		file.add(Exit);

		JMenuItem customerMenu1 = new JMenuItem("Search Customers");
		customerMenu.add(customerMenu1);
		customerMenu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == customerMenu1) {
					new customerDetails();
				}
			}

		});

		JMenuItem ReserveRoom = new JMenuItem("Manage Rooms");
		room.add(ReserveRoom);
		ReserveRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == ReserveRoom) {
					new RoomManagement();
				}
			}

		});
		
		JMenuItem viewHistory = new JMenuItem("Booking History");
		booking.add(viewHistory);
		viewHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == viewHistory) {
					new BookingHistoryGUI();
				}
			}

		});

		
		JMenuItem checkinmanage = new JMenuItem("Manage Check-In Customers");
		booking.add(checkinmanage);
		checkinmanage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == checkinmanage) {
					new CheckInGUI();
				}
			}

		});

		JMenuItem setting1 = new JMenuItem("Change Password");
		setting.add(setting1);
		setting1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == setting1) {
					new ReceptionPasswordChange();
				}
			}

		});

		JMenuItem extraservices = new JMenuItem("Manage Services");
		services.add(extraservices);
		extraservices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == extraservices) {
					new ServicesGUI();
				}
			}

		});

		JMenuItem billing1 = new JMenuItem("View Billing");
		billing.add(billing1);
		billing1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == billing1) {
					new BillingGUI();
				}
			}

		});

		JMenuItem aboutDeveloper = new JMenuItem("About Developer");
		aboutDeveloper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == aboutDeveloper) {
					new AboutUs();
				}
			}

		});
		about.add(aboutDeveloper);

		final JPopupMenu menu = new JPopupMenu("Menu");

		JMenuItem logout1 = new JMenuItem("Log Out");
		logout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("log-out.png")));
		menu.add(logout1);
		logout1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == logout1) {
					frame.dispose();
					new LoginWindow();
				}
			}

		});

		JMenuItem open = new JMenuItem("Exit");
		open.setIcon(new javax.swing.ImageIcon(getClass().getResource("shutdown.png")));
		menu.add(open);
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == open) {
					System.exit(0);
				}
			}

		});

		frame.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// right mouse click event
				if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1) {
					menu.show(frame, e.getX(), e.getY());
				}
			}
		});

		frame.setVisible(true);

	}

	public void updateTable() {

		a5 = new JDBCBooking().ReceptionViewAllCustomer();
		model.setRowCount(0);
		for (BookingLibs3 bookingLibs : a5) {
			Object tmpRow[] = { bookingLibs.getCustomer_ID(), bookingLibs.getName(), bookingLibs.getBooking_ID(),
					bookingLibs.getCheckIn(), bookingLibs.getCheckOut(), bookingLibs.getRoom_ID(),
					bookingLibs.getBooking_Type(), bookingLibs.getBooking_Status()

			};

			model.addRow(tmpRow);
		}

		table1 = new JTable(model);
		JTableHeader t2 = table1.getTableHeader();
		t2.setBackground(Color.black);
		t2.setForeground(Color.white);
		table1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table1.setSelectionBackground(Color.black);
		table1.setSelectionForeground(Color.white);
		table1.setRowHeight(30);
		table1.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 18));
		table1.addMouseListener(this);
		sorter = new TableRowSorter<>(model);
		table1.setRowSorter(sorter);

	}

	public void mouseClicked(MouseEvent ae) {
		if (ae.getSource() == table1) {

			try {
				int h2 = table1.getSelectedRow();

				TableModel model = table1.getModel();

				String name = model.getValueAt(h2, 2).toString();
				bookingtxt.setText(name);

				Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(h2, 3));
				checkin.setDate(date);

				Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(h2, 4));
				checkout1.setDate(date2);

			} catch (Exception ex) {
				System.out.println("Erro" + ex.getMessage());
			}

		}

	}

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
		availableroomlbl.setForeground(new Color(147, 250, 165));

	}

	@Override
	public void mouseExited(MouseEvent e) {
		availableroomlbl.setForeground(COLOR);

	}

	public static void main(String[] args) {
		new ReceptionDashBoard();

	}

}
