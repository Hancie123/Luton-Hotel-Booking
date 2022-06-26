package ManagerUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Libs.Global;
import Libs.JDBCServices;
import Libs.ServicesLibs;

public class ServicesGUI implements ActionListener,ItemListener {

	JFrame frame;
	JTextField  pricetxt;
	JComboBox servicestxt,roomidtxt;
	JButton insertbtn;
	DefaultTableModel dm;
	JTable table;
	JScrollPane scroll;
	

	// Default Constructor
	public ServicesGUI() {
		frame = new JFrame("Our Services");
		frame.setSize(1300, 750);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		

		// ******************NORTH Panel******************************
		JPanel north = new JPanel();
		north.setLayout(null);
		north.setPreferredSize(new Dimension(100, 100));
		north.setBackground(new Color(21, 159, 133));
		frame.add(north, BorderLayout.NORTH);

		JLabel titlelbl = new JLabel("Luton Hotel Extra Services", SwingConstants.CENTER);
		titlelbl.setFont(new Font("Tahoma", Font.BOLD, 35));
		titlelbl.setForeground(Color.white);
		titlelbl.setBounds(350, 30, 500, 35);
		north.add(titlelbl);

		// ******************CENTER Panel******************************
		JPanel center = new JPanel();
		center.setLayout(new BorderLayout());
		center.setPreferredSize(new Dimension(100, 250));
		frame.add(center, BorderLayout.CENTER);

		// ******************CENTER-NORTH Panel******************************
		JPanel north1 = new JPanel();
		north1.setLayout(new BorderLayout());
		north1.setPreferredSize(new Dimension(100, 250));
		center.add(north1, BorderLayout.NORTH);

		JLabel img = new JLabel();
		img.setIcon(new javax.swing.ImageIcon(getClass().getResource("Frame1.png")));
		img.setFont(new Font("Tahoma", Font.BOLD, 35));
		img.setForeground(Color.white);
		img.setPreferredSize(new Dimension(600, 450));
		north1.add(img);
		
		//***********************Center-CENTER Panel*******************
		dm=new DefaultTableModel();
		dm.addColumn("Booking ID");
		dm.addColumn("Services ID");
		dm.addColumn("Service Types");
		dm.addColumn("Price");
		
		table=new JTable(dm);
		table.setFont(new Font("Tahoma",Font.PLAIN,16));
		table.setSelectionBackground(Color.black);
		table.setSelectionForeground(Color.white);
		
		JTableHeader h1=table.getTableHeader();
		h1.setFont(new Font("Tahoma",Font.BOLD,16));
		h1.setBackground(Color.black);
		h1.setForeground(Color.white);
		
		JDBCServices jdbc=new JDBCServices();
		ArrayList select=jdbc.select_all();
		if(select.size()>0) {
			for(int i=0; i<select.size();i++) {
				ServicesLibs services=(ServicesLibs) select.get(i);
				Object[] tmp= {
					services.getBooking_ID(),
					services.getServices_ID(),
					services.getServices_Type(),
					services.getServices_Price()
				};
				
				dm.addRow(tmp);
				
				
			}
		}
		
		
		scroll=new JScrollPane(table);
		center.add(scroll,BorderLayout.CENTER);
		

		// *********************West Panel**************************
		JPanel west = new JPanel();
		west.setLayout(null);
		west.setPreferredSize(new Dimension(400, 250));
		west.setBackground(new Color(106, 101, 101));
		frame.add(west, BorderLayout.WEST);
		
		//West panel image
		JLabel img1 = new JLabel();
		img1.setIcon(new javax.swing.ImageIcon(getClass().getResource("customer1.png")));
		img1.setFont(new Font("Tahoma", Font.BOLD, 35));
		img1.setForeground(Color.white);
		img1.setBounds(140,10,128,128);
		west.add(img1);
		
		//west panel title
		JLabel titlelbl1 = new JLabel("Luton Hotel");
		titlelbl1.setFont(new Font("Tahoma", Font.BOLD, 20));
		titlelbl1.setForeground(Color.white);
		titlelbl1.setBounds(140,140,128,30);
		west.add(titlelbl1);
		
		//JSeparator for title
		JSeparator j1=new JSeparator();
		j1.setBounds(10,170,380,10);
		west.add(j1);
		
		JLabel roomidlbl = new JLabel("Booking-ID: ");
		roomidlbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		roomidlbl.setForeground(Color.white);
		roomidlbl.setBounds(30,200,128,30);
		west.add(roomidlbl);
		
		pricetxt = new JTextField();
		pricetxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pricetxt.setBorder(BorderFactory.createLineBorder(Color.white));
		pricetxt.setBounds(140,310,200,30);
		west.add(pricetxt);
		
		
		roomidtxt = new JComboBox();
		roomidtxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		roomidtxt.setBorder(BorderFactory.createLineBorder(Color.white));
		roomidtxt.setBounds(140,200,200,30);
		west.add(roomidtxt);
		
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
				
				roomidtxt.addItem(rst1.getString("Booking_ID"));
				
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		
		
		JLabel roomserviceslbl = new JLabel("Services: ");
		roomserviceslbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		roomserviceslbl.setForeground(Color.white);
		roomserviceslbl.setBounds(30,260,128,30);
		west.add(roomserviceslbl);
		
		
		servicestxt = new JComboBox();
		for (int i = 0; i < Global.SERVICE_TYPES.length; i++) {
			servicestxt.addItem(Global.SERVICE_TYPES[i]);
		}
		servicestxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		servicestxt.setBorder(BorderFactory.createLineBorder(Color.white));
		servicestxt.setBounds(140,260,200,30);
		servicestxt.addItemListener(this);
		west.add(servicestxt);
		
		
		JLabel pricelbl = new JLabel("Price: ");
		pricelbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pricelbl.setForeground(Color.white);
		pricelbl.setBounds(30,310,128,30);
		west.add(pricelbl);
		
		
		insertbtn = new JButton("Order");
		insertbtn.setBackground(new Color(21,159,133));
		insertbtn.setFocusable(false);
		insertbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		insertbtn.setForeground(Color.white);
		insertbtn.setBounds(130,390,128,30);
		insertbtn.addActionListener(this);
		west.add(insertbtn);

		frame.setVisible(true);
	}
	
	@Override
	public void itemStateChanged(ItemEvent ie) {
		if(ie.getSource()==servicestxt) {
			int index=servicestxt.getSelectedIndex();
			pricetxt.setText(Double.toString(Global.SERVICE_PRICE[index]));
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==insertbtn) {
			
			ServicesLibs services=new ServicesLibs();
			
			services.setBooking_ID(Integer.parseInt(roomidtxt.getSelectedItem().toString()));
			services.setServices_Type(servicestxt.getSelectedItem().toString());
			services.setServices_Price(Double.parseDouble(pricetxt.getText()));
			
			
			JDBCServices jdbc=new JDBCServices();
			boolean result=jdbc.insert(services);
			if(result==true) {
				
				
				ImageIcon i = new ImageIcon(getClass().getResource("5-stars.png"));
				JOptionPane.showMessageDialog(null, "Service added Successfully!", "Luton Hotel System", JOptionPane.WIDTH, i);
			}
			else {
				ImageIcon i = new ImageIcon(getClass().getResource("5-stars.png"));
				JOptionPane.showMessageDialog(null, "Error Ocurred!", "Luton Hotel System", JOptionPane.WIDTH, i);
				
			}
		}
		
	}

	public static void main(String[] args) {
		new ServicesGUI();

	}

	

}
