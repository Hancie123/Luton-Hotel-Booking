package bookingUI;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import Libs.BookingLibs;
import Libs.BookingLibs5;
import Libs.JDBCBooking;
import Libs.JDBCBooking2;
import Libs.JDBCRoom;
import Libs.Room;
import UI.TodayCheckInGUI;

public class CheckInGUI implements MouseListener {

	JFrame frame;
	Object[] columnsName;
	DefaultTableModel model;
	JTable table;
	JDateChooser c1,c2;
	ArrayList<BookingLibs5> check;
	JButton insertbtn,cancelbtn;
	JTextField nametxt,roomidtxt,credittxt,bookingidtxt,roomtypetxt;
	JComboBox statustxt;

	public CheckInGUI() {

		frame = new JFrame("Today's Check-In Customers");
		frame.setSize(1350, 700);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		frame.setResizable(false);

		// *******************North Panel***************
		JPanel north = new JPanel();
		north.setLayout(null);
		north.setPreferredSize(new Dimension(100, 80));
		north.setBackground(new Color(21, 159, 133));
		frame.add(north, BorderLayout.NORTH);

		JLabel searchlbl = new JLabel("Search:");
		searchlbl.setBounds(10, 25, 200, 30);
		searchlbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		searchlbl.setForeground(Color.white);
		north.add(searchlbl);

		JTextField searchtxt = new JTextField();
		searchtxt.setBounds(100, 25, 200, 30);
		searchtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		searchtxt.setFont(new Font("Tahoma", Font.BOLD, 20));
		north.add(searchtxt);

		// *******************Center Panel***************
		JPanel center = new JPanel();
		center.setLayout(null);
		center.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Customer Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		center.setBackground(new Color(105,105,105));
		frame.add(center, BorderLayout.CENTER);
		
		JLabel namelbl = new JLabel("Name:");
		namelbl.setBounds(90, 50, 200, 30);
		namelbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		namelbl.setForeground(Color.white);
		center.add(namelbl);
		
		nametxt = new JTextField();
		nametxt.setBounds(240, 50, 230, 30);
		nametxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		nametxt.setFont(new Font("Tahoma", Font.BOLD, 20));
		center.add(nametxt);
		
		JLabel creditlbl = new JLabel("Credit No:");
		creditlbl.setBounds(90, 100, 200, 30);
		creditlbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		creditlbl.setForeground(Color.white);
		center.add(creditlbl);
		
		credittxt = new JTextField();
		credittxt.setBounds(240, 100, 230, 30);
		credittxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		credittxt.setFont(new Font("Tahoma", Font.BOLD, 20));
		center.add(credittxt);
		
		JLabel bookinglbl = new JLabel("Boooking ID:");
		bookinglbl.setBounds(90, 150, 200, 30);
		bookinglbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		bookinglbl.setForeground(Color.white);
		center.add(bookinglbl);
		
		bookingidtxt = new JTextField();
		bookingidtxt.setBounds(240, 150, 230, 30);
		bookingidtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		bookingidtxt.setFont(new Font("Tahoma", Font.BOLD, 20));
		center.add(bookingidtxt);
		
		JLabel roomidlbl = new JLabel("Room ID:");
		roomidlbl.setBounds(90, 200, 200, 30);
		roomidlbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		roomidlbl.setForeground(Color.white);
		center.add(roomidlbl);
		
		roomidtxt = new JTextField();
		roomidtxt.setBounds(240, 200, 230, 30);
		roomidtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		roomidtxt.setFont(new Font("Tahoma", Font.BOLD, 20));
		center.add(roomidtxt);
		
		//*****************Another Side*****************
		JLabel checkinlbl = new JLabel("Check-In:");
		checkinlbl.setBounds(600, 50, 200, 30);
		checkinlbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		checkinlbl.setForeground(Color.white);
		center.add(checkinlbl);
		
		c1 = new JDateChooser();
		c1.setDateFormatString("yyyy-MM-dd");
		c1.setBounds(750, 50, 230, 30);
		c1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		c1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		center.add(c1);
		
		JLabel checkoutlbl = new JLabel("Check-Out:");
		checkoutlbl.setBounds(600, 100, 200, 30);
		checkoutlbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		checkoutlbl.setForeground(Color.white);
		center.add(checkoutlbl);
		
		c2 = new JDateChooser();
		c2.setDateFormatString("yyyy-MM-dd");
		c2.setBounds(750, 100, 230, 30);
		c2.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		c2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		center.add(c2);
		
		JLabel roomtype = new JLabel("Room Type:");
		roomtype.setBounds(600, 150, 200, 30);
		roomtype.setFont(new Font("Tahoma", Font.BOLD, 20));
		roomtype.setForeground(Color.white);
		center.add(roomtype);
		
		roomtypetxt = new JTextField();
		roomtypetxt.setBounds(750, 150, 230, 30);
		roomtypetxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		roomtypetxt.setFont(new Font("Tahoma", Font.BOLD, 20));
		center.add(roomtypetxt);
		
		JLabel statuslbl = new JLabel("Status:");
		statuslbl.setBounds(600, 200, 200, 30);
		statuslbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		statuslbl.setForeground(Color.white);
		center.add(statuslbl);
		
		String[]h1= {"Active","Inactive"};
		statustxt = new JComboBox(h1);
		statustxt.setBounds(750, 200, 230, 30);
		statustxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		statustxt.setFont(new Font("Tahoma", Font.BOLD, 20));
		center.add(statustxt);
		
		insertbtn = new JButton("Check-In");		
		insertbtn.setBounds(1050, 50, 200, 35);
		insertbtn.setFont(new Font("Times New Roman", Font.BOLD, 25));
		insertbtn.setBackground(new Color(21, 159, 133));
		insertbtn.setForeground(Color.white);
		insertbtn.setFocusable(false);
		center.add(insertbtn);
		insertbtn.addActionListener(new ActionListener() {
			
			
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// *********Update Room Status***************
				Room room = new Room();
				
				int room_id1 = Integer.parseInt(roomidtxt.getText());

				room.setId(room_id1);
				room.setStatus("Active");
				JDBCRoom jdbc1 = new JDBCRoom();
				boolean result1 = jdbc1.update1(room);
				
				
				
				int cusid = Integer.parseInt(bookingidtxt.getText());
				
				String Bookingtype=statustxt.getSelectedItem().toString();

				BookingLibs booking = new BookingLibs();

				booking.setBooking_ID(cusid);				
				booking.setBooking_Status(Bookingtype);

				JDBCBooking2 jdbc = new JDBCBooking2();
				boolean result = jdbc.update(booking);

				if (result == true) {
					updateTable();
					ImageIcon i = new ImageIcon(getClass().getResource("5-stars.png"));
					JOptionPane.showMessageDialog(null, "The customer is active now!", "Room Booking", JOptionPane.WIDTH, i);
				}

			}

		

				
			
			
			
		});
		
		cancelbtn = new JButton("Cancel Booking");		
		cancelbtn.setBounds(1050, 100, 200, 35);
		cancelbtn.setFont(new Font("Times New Roman", Font.BOLD, 25));
		cancelbtn.setBackground(new Color(21, 159, 133));
		cancelbtn.setForeground(Color.white);
		cancelbtn.setFocusable(false);
		center.add(cancelbtn);
		cancelbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==cancelbtn) {
					
					//**************Update Room*****************8
					int room_id1 = Integer.parseInt(roomidtxt.getText());

					Room room = new Room();
					
					room.setId(room_id1);
					room.setStatus("Available");
					JDBCRoom jdbc1 = new JDBCRoom();
					boolean result = jdbc1.update1(room);
					
					
					
					
					
					BookingLibs booking = new BookingLibs();

		           int cancelbooking=(Integer.parseInt(bookingidtxt.getText()));
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
		
		JButton checkinbtn = new JButton("View Check-In");		
		checkinbtn.setBounds(1050, 150, 200, 35);
		checkinbtn.setFont(new Font("Times New Roman", Font.BOLD, 25));
		checkinbtn.setBackground(new Color(21, 159, 133));
		checkinbtn.setForeground(Color.white);
		checkinbtn.setFocusable(false);
		center.add(checkinbtn);
		checkinbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TodayCheckInGUI();
				
			}
			
			
			
			
		});

		// ******************South Table*************************8
		columnsName = new Object[9];
		columnsName[0] = "Customer ID";
		columnsName[1] = "Name";
		columnsName[2] = "Credit Number";
		columnsName[3] = "Booking ID";
		columnsName[4] = "Check-In";
		columnsName[5] = "Check-Out";
		columnsName[6] = "Room ID";
		columnsName[7] = "Room Type";
		columnsName[8] = "Room Status";

		table = new JTable(model);

		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(columnsName);
		updateTable();
		JScrollPane scroll1 = new JScrollPane(table);
		scroll1.setPreferredSize(new Dimension(200, 300));
		frame.add(scroll1, BorderLayout.SOUTH);

		frame.setVisible(true);

	}

	public void updateTable() {
		check = new JDBCBooking().CheckIn();
		model.setRowCount(0);
		for (BookingLibs5 bookingLibs : check) {
			Object tmpRow[] = { bookingLibs.getCustomer_ID(),
					bookingLibs.getName(),
					bookingLibs.getCredit_Number(),
					bookingLibs.getBooking_ID(),
					bookingLibs.getCheckIn(),
					bookingLibs.getCheckOut(),
					bookingLibs.getRoom_ID(),
					bookingLibs.getBooking_Type(),
					bookingLibs.getBooking_Status()

			};

			model.addRow(tmpRow);
		}

		table = new JTable(model);
		JTableHeader t2 = table.getTableHeader();
		t2.setBackground(Color.black);
		t2.setForeground(Color.white);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setSelectionBackground(Color.black);
		table.setSelectionForeground(Color.white);
		table.setRowHeight(30);
		table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 18));
		table.addMouseListener(this);

		// table.setModel(model);
		// table.repaint();
	}
	
	public void mouseClicked(MouseEvent ae) {
		if (ae.getSource() == table) {
			
			try {
				int h2=table.getSelectedRow();
				
				TableModel model=table.getModel();
				
				String name=model.getValueAt(h2, 1).toString();
				nametxt.setText(name);
				
				String credit=model.getValueAt(h2, 2).toString();
				credittxt.setText(credit);
				
				String booking=model.getValueAt(h2, 3).toString();
				bookingidtxt.setText(booking);
				
				String room=model.getValueAt(h2, 6).toString();
				roomidtxt.setText(room);
				
				String type=model.getValueAt(h2, 7).toString();
				roomtypetxt.setText(type);
				
				String status=model.getValueAt(h2, 8).toString();
				statustxt.setSelectedItem(status);
				
				
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(h2, 4));
				c1.setDate(date);
				
				Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(h2, 5));
				c2.setDate(date2);
				
				
			}
			catch(Exception ex) {
				System.out.println("Error"+ex.getMessage());
			}
			
		}	
			
		}

	public static void main(String[] args) {
		new CheckInGUI();
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
