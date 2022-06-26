package billing;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import Libs.BillingLibs;
import Libs.BillingLibs2;
import Libs.BillingLibs3;
import Libs.BookingLibs;
import Libs.CustomerLibs;
import Libs.Global;
import Libs.JDBCBilling;
import Libs.JDBCCustomer;
import Libs.JDBCRoom;
import Libs.Room;
import UI.TodayCheckOutGUI;

public class CorporateBilling implements MouseListener {
	JFrame frame;
	JTextField searchField;
	TableRowSorter sorter;
	JTable table1;
	JTextField discounttxt,credittxt,bookingidtxt,customeridtxt, nametxt, typetxt, roomratetxt, servicepricetxt, foodpricetxt, vattxt, servicechargetxt,
			totalbilltxt, totalpaidtxt, returnamounttxt, drinktxt, roomidtxt, noofdaystxt, roompricetxt;
	JComboBox statustxt, billingstatustxt;
	JButton generatebillbtn, calculatebillbtn;
	Object[] Column;
	DefaultTableModel model;
	ArrayList<BillingLibs2> Billing;
	JDateChooser c1, c2;

	public CorporateBilling() {
		frame = new JFrame("Corporate Billing");
		frame.setSize(1450, 770);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
		frame.setLayout(new BorderLayout());

		// ***************North Panel*****************
		JPanel north = new JPanel();
		north.setLayout(null);
		north.setBackground(new Color(21, 159, 133));
		north.setPreferredSize(new Dimension(100, 100));
		frame.add(north, BorderLayout.NORTH);

		// Title Label
		JLabel customer = new JLabel("BILLING SYSTEM [CORPORATE CUSTOMER]", SwingConstants.CENTER);
		customer.setBounds(500, 30, 700, 35);
		customer.setForeground(Color.white);
		customer.setFont(new Font("Verdana", Font.BOLD, 25));
		north.add(customer);

		// North Panel Search Label
		JLabel searchlbl = new JLabel("Search Customers: ");
		searchlbl.setBounds(10, 30, 210, 35);
		searchlbl.setForeground(Color.white);
		searchlbl.setFont(new Font("Verdana", Font.BOLD, 18));
		north.add(searchlbl);

		// Search Field
		searchField = new JTextField();
		searchField.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		searchField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		searchField.setBounds(210, 30, 200, 30);
		north.add(searchField);

		searchField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				search(searchField.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				search(searchField.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				search(searchField.getText());
			}

			public void search(String str) {
				if (str.length() == 0) {
					sorter.setRowFilter(null);
				} else {
					sorter.setRowFilter(RowFilter.regexFilter(str));
				}
			}
		});

		// **********************Center Panel*****************
		Column = new Object[11];
			
		Column[0] = "Name";
		Column[1] = "Status";
		Column[2] = "Rate";
		Column[3] = "Check-In";
		Column[4] = "Check-Out";
		Column[5] = "Service Price";
		Column[6] = "Drink Amount";
		Column[7] = "Food Amount";
		Column[8] = "Room ID";
		Column[9]="Booking ID";
		Column[10]="Credit Number";

		table1 = new JTable();
		model = (DefaultTableModel) table1.getModel();
		model.setColumnIdentifiers(Column);
		
		table1.addMouseListener(this);
		JTableHeader h1 = table1.getTableHeader();
		h1.setBackground(Color.black);
		h1.setForeground(Color.white);
		h1.setFont(new Font("Verdana", Font.BOLD, 15));
		table1.setFont(new Font("Verdana", Font.PLAIN, 16));
		table1.setRowHeight(20);
		table1.setSelectionBackground(Color.BLACK);
		table1.setSelectionForeground(Color.white);
		sorter = new TableRowSorter<>(model);
		table1.setRowSorter(sorter);


		JScrollPane scroll1 = new JScrollPane(table1);
		scroll1.setBounds(400, 20, 500, 400);
		frame.add(scroll1, BorderLayout.CENTER);

		// *******************South Panel******************
		JPanel south = new JPanel();
		south.setLayout(null);
		south.setBackground(new Color(21, 159, 133));
		south.setPreferredSize(new Dimension(100, 280));
		frame.add(south, BorderLayout.SOUTH);

		roomidtxt = new JTextField();

		
		bookingidtxt=new JTextField();

		JLabel namelbl = new JLabel("Name:");
		namelbl.setBounds(10, 20, 210, 35);
		namelbl.setForeground(Color.white);
		namelbl.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(namelbl);

		nametxt = new JTextField();
		nametxt.setBounds(160, 20, 210, 35);
		nametxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		nametxt.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(nametxt);
		
		JLabel checkinlbl = new JLabel("Check-In:");
		checkinlbl.setVisible(false);
		checkinlbl.setBounds(10, 220, 210, 35);
		checkinlbl.setForeground(Color.white);
		checkinlbl.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(checkinlbl);

		c1 = new JDateChooser();
		c1.setVisible(false);
		c1.setDateFormatString("yyyy-MM-dd");
		c1.setBounds(160, 220, 210, 35);
		c1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		c1.setFont(new Font("Verdana", Font.PLAIN, 18));
		south.add(c1);

		JLabel checkoutlbl = new JLabel("Check Out: ");
		checkoutlbl.setVisible(false);
		checkoutlbl.setBounds(10, 270, 210, 35);
		checkoutlbl.setForeground(Color.white);
		checkoutlbl.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(checkoutlbl);

		c2 = new JDateChooser();
		c2.setVisible(false);
		c2.setDateFormatString("yyyy-MM-dd");
		c2.setBounds(160, 270, 210, 35);
		c2.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		c2.setFont(new Font("Verdana", Font.PLAIN, 18));
		south.add(c2);

		JLabel roompricelbl = new JLabel("Room Rate:");
		roompricelbl.setVisible(false);
		roompricelbl.setBounds(10, 120, 210, 35);
		roompricelbl.setForeground(Color.white);
		roompricelbl.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(roompricelbl);

		roomratetxt = new JTextField();
		roomratetxt.setVisible(false);
		roomratetxt.setBounds(160, 120, 210, 35);
		roomratetxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		roomratetxt.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(roomratetxt);
		
		JLabel noofdays = new JLabel("No of Days: ");
		noofdays.setBounds(10, 70, 210, 35);
		noofdays.setForeground(Color.white);
		noofdays.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(noofdays);

		noofdaystxt = new JTextField();
		noofdaystxt.setBounds(160, 70, 210, 35);
		noofdaystxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		noofdaystxt.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(noofdaystxt);
		
		JLabel roompricelbl1 = new JLabel("Room Price");
		roompricelbl1.setBounds(10, 120, 210, 35);
		roompricelbl1.setForeground(Color.white);
		roompricelbl1.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(roompricelbl1);

		roompricetxt = new JTextField();
		roompricetxt.setBounds(160, 120, 210, 35);
		roompricetxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		roompricetxt.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(roompricetxt);

		JLabel barlbl = new JLabel("Bar Amount:");
		barlbl.setBounds(10, 170, 210, 35);
		barlbl.setForeground(Color.white);
		barlbl.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(barlbl);

		drinktxt = new JTextField();
		drinktxt.setBounds(160, 170, 210, 35);
		drinktxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		drinktxt.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(drinktxt);


		JLabel servicepricelbl = new JLabel("Service Amt:");
		servicepricelbl.setBounds(10, 220, 210, 35);
		servicepricelbl.setForeground(Color.white);
		servicepricelbl.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(servicepricelbl);

		servicepricetxt = new JTextField();
		servicepricetxt.setBounds(160, 220, 210, 35);
		servicepricetxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		servicepricetxt.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(servicepricetxt);

		JLabel foodpricelbl = new JLabel("Food Price:");
		foodpricelbl.setBounds(380, 20, 210, 35);
		foodpricelbl.setForeground(Color.white);
		foodpricelbl.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(foodpricelbl);

		foodpricetxt = new JTextField();
		foodpricetxt.setBounds(550, 20, 210, 35);
		foodpricetxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		foodpricetxt.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(foodpricetxt);
		
		JLabel creaditlbl = new JLabel("Credit Number:");
		creaditlbl.setBounds(380, 70, 210, 35);
		creaditlbl.setForeground(Color.white);
		creaditlbl.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(creaditlbl);
		
		credittxt = new JTextField();
		credittxt.setBounds(550, 70, 210, 35);
		credittxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		credittxt.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(credittxt);

		JLabel vatlbl = new JLabel("VAT:");
		vatlbl.setBounds(380, 120, 210, 35);
		vatlbl.setForeground(Color.white);
		vatlbl.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(vatlbl);

		vattxt = new JTextField();
		vattxt.setText("13%");
		vattxt.setEditable(false);
		vattxt.setBounds(550, 120, 210, 35);
		vattxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		vattxt.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(vattxt);

		JLabel servicechargelbl = new JLabel("Service Charge: ");
		servicechargelbl.setBounds(380, 170, 210, 35);
		servicechargelbl.setForeground(Color.white);
		servicechargelbl.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(servicechargelbl);

		servicechargetxt = new JTextField();
		servicechargetxt.setText("$ 500");
		servicechargetxt.setEditable(false);
		servicechargetxt.setBounds(550, 170, 210, 35);
		servicechargetxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		servicechargetxt.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(servicechargetxt);
		
		JLabel discountlbl = new JLabel("Discount: ");
		discountlbl.setBounds(380, 220, 210, 35);
		discountlbl.setForeground(Color.white);
		discountlbl.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(discountlbl);
		
		discounttxt = new JTextField();
		discounttxt.setBounds(550, 220, 210, 35);
		discounttxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		discounttxt.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(discounttxt);
		discounttxt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				double roomprice1;
				double serviceprice1;
				double foodprice1;
				double drinkprice1;

				drinkprice1 = Integer.parseInt(drinktxt.getText());
				roomprice1 = Integer.parseInt(roompricetxt.getText());
				serviceprice1 = Integer.parseInt(servicepricetxt.getText());
				foodprice1 = Integer.parseInt(foodpricetxt.getText());

				double h5 = roomprice1 + serviceprice1 + foodprice1 + drinkprice1;

				double h6 = Float.parseFloat(discounttxt.getText());
				double h7=h6/100;
				double h8 = h7 * h5;

				double h9 = (h5-h8) + 500;

				totalbilltxt.setText(Double.toString(h9));
				
			}
			
			
			
		});

		JLabel totalbilllbl = new JLabel("Total Bill: ");
		totalbilllbl.setBounds(780, 20, 210, 35);
		totalbilllbl.setForeground(Color.white);
		totalbilllbl.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(totalbilllbl);

		totalbilltxt = new JTextField();
		totalbilltxt.setBounds(950, 20, 210, 35);
		totalbilltxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		totalbilltxt.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(totalbilltxt);


		JLabel billingststaus = new JLabel("Billing Status: ");
		billingststaus.setBounds(780, 70, 210, 35);
		billingststaus.setForeground(Color.white);
		billingststaus.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(billingststaus);

		Object[] h55 = { "Paid", "Unpaid", "Due" };
		billingstatustxt = new JComboBox(h55);
		billingstatustxt.setBounds(950, 70, 210, 35);
		billingstatustxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		billingstatustxt.setFont(new Font("Verdana", Font.BOLD, 18));
		south.add(billingstatustxt);

		calculatebillbtn = new JButton("View Check-Out");
		calculatebillbtn.setFocusable(false);
		calculatebillbtn.setBounds(1200, 20, 200, 35);
		calculatebillbtn.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		calculatebillbtn.setFont(new Font("Verdana", Font.BOLD, 18));
		calculatebillbtn.setForeground(Color.white);
		calculatebillbtn.setBackground(new Color(106, 101, 101));
		south.add(calculatebillbtn);
		calculatebillbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TodayCheckOutGUI();

			}

		});

		generatebillbtn = new JButton("Generate Bill");
		generatebillbtn.setFocusable(false);
		generatebillbtn.setBounds(1200, 70, 200, 35);
		generatebillbtn.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		generatebillbtn.setFont(new Font("Verdana", Font.BOLD, 18));
		generatebillbtn.setForeground(Color.white);
		generatebillbtn.setBackground(new Color(106, 101, 101));
		south.add(generatebillbtn);
		generatebillbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == generatebillbtn) {

					//********************Update Room**********************
					Room room = new Room();
					int room_id = Integer.parseInt(roomidtxt.getText());
					room.setId(room_id);
					room.setStatus("Available");
					JDBCRoom jdbc1 = new JDBCRoom();
					boolean result1 = jdbc1.update1(room);
					
					
					//*******************Update Booking Status**************
					BookingLibs booking=new BookingLibs();
					booking.setBooking_ID(Integer.parseInt(bookingidtxt.getText()));
					booking.setBooking_Status("Inactive");
					JDBCBilling jdbc5=new JDBCBilling();
					boolean result5=jdbc5.update(booking);
					
					
					
					

					// ***********************Billing Insert****************
					BillingLibs billing = new BillingLibs();
					
		
					billing.setBooking_ID(Integer.parseInt(bookingidtxt.getText()));
					billing.setName(nametxt.getText());
					billing.setVAT(13);
					billing.setService_Charge(500);
					billing.setRoom_Price(Integer.parseInt(roompricetxt.getText()));
					billing.setService_Price(Integer.parseInt(servicepricetxt.getText()));
					billing.setRestaurant_Price(Integer.parseInt(foodpricetxt.getText()));
					billing.setBar_Price(Integer.parseInt(drinktxt.getText()));
					billing.setTotal_Bill(Double.parseDouble(totalbilltxt.getText()));
					billing.setBilling_Status(billingstatustxt.getSelectedItem().toString());
                    billing.setDiscount(Long.parseLong(discounttxt.getText()));
					

					Global.currentBilling2 = billing;

					JDBCBilling jdbc = new JDBCBilling();
					boolean result = jdbc.insertCorporate(billing);
					update();

				}

				new CorporateInvoice();

			
			}
		});

		JButton clearbtn = new JButton("Clear");
		clearbtn.setFocusable(false);
		clearbtn.setBounds(1200, 120, 200, 35);
		clearbtn.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		clearbtn.setFont(new Font("Verdana", Font.BOLD, 18));
		clearbtn.setForeground(Color.white);
		clearbtn.setBackground(new Color(106, 101, 101));
		south.add(clearbtn);
		clearbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nametxt.setText(null);
				noofdaystxt.setText(null);
				foodpricetxt.setText(null);
				drinktxt.setText(null);
				roomratetxt.setText(null);
				roompricetxt.setText(null);
				servicepricetxt.setText(null);
				foodpricetxt.setText(null);
				totalbilltxt.setText(null);

			}

		});
		
		update();

		frame.setVisible(true);

	}

	
	
	 private void update() {
		 JDBCBilling jdbc = new JDBCBilling();
			ArrayList Billing = jdbc.view_all2();
			model.setRowCount(0);
			if (Billing.size() > 0) {
	            for (int i = 0; i < Billing.size(); i++) {
	            	BillingLibs2 tmp_person = (BillingLibs2) Billing.get(i);
	                
	                Vector tmpPerson = new Vector();
	                
	                tmpPerson.add(tmp_person.getName());
	                tmpPerson.add(tmp_person.getRoom_Status());
	                tmpPerson.add(tmp_person.getRoom_Rate());
	                tmpPerson.add(tmp_person.getCheckIn());
	                tmpPerson.add(tmp_person.getCheckOut());
	                tmpPerson.add(tmp_person.getService_Price());
	                tmpPerson.add(tmp_person.getDrink_Amount());
	                tmpPerson.add(tmp_person.getItem_Amount());
	                tmpPerson.add(tmp_person.getRoom_ID());
	                tmpPerson.add(tmp_person.getBooking_ID());
	                tmpPerson.add(tmp_person.getCredit_Number());
	               
	                
	                model.addRow(tmpPerson);
	            }
	        }
	    }

	@Override
	public void mouseClicked(MouseEvent e) {

		try {

			int h1 = table1.getSelectedRow();

			TableModel model = table1.getModel();
			
			String bookingid=model.getValueAt(h1, 9).toString();
			bookingidtxt.setText(bookingid);


			String name = model.getValueAt(h1, 0).toString();
			nametxt.setText(name);

			String drinkamount = model.getValueAt(h1, 6).toString();
			drinktxt.setText(drinkamount);

			String roomid = model.getValueAt(h1, 8).toString();
			roomidtxt.setText(roomid);

			Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(h1, 3));
			c1.setDate(date);

			Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(h1, 4));
			c2.setDate(date2);

			String roomprice = model.getValueAt(h1, 2).toString();
			roomratetxt.setText(roomprice);

			String serviceprice = model.getValueAt(h1, 5).toString();
			servicepricetxt.setText(serviceprice);

			String foodprice = model.getValueAt(h1, 7).toString();
			foodpricetxt.setText(foodprice);
			
			String credit = model.getValueAt(h1, 10).toString();
			credittxt.setText(credit);

			String fromdate = ((JTextField) c1.getDateEditor().getUiComponent()).getText();
			String todate = ((JTextField) c2.getDateEditor().getUiComponent()).getText();

			LocalDate fday = LocalDate.parse(fromdate);
			LocalDate tday = LocalDate.parse(todate);

			Long day_gap = ChronoUnit.DAYS.between(fday, tday);
			noofdaystxt.setText(String.valueOf(day_gap));
			
			int rate=Integer.parseInt(roomratetxt.getText());			
			int days=Integer.parseInt(noofdaystxt.getText());			
			int result=rate*days;		
			roompricetxt.setText(String.valueOf(result));
			
			

		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
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
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new CorporateBilling();
	}

}
