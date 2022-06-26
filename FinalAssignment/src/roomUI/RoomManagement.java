package roomUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Libs.JDBCCustomer;
import Libs.CustomerLibs2;
import Libs.Global;
import Libs.JDBCRoom;
import Libs.Room;

public class RoomManagement implements ActionListener, ItemListener{
	JFrame frame;
	JLabel RoomIdlbl, typelbl, ratelbl, statuslbl,Searchlbl;
	JTextField RoomIdtxt,ratetxt; 
	JPanel north, subnorth, center;
	JTextField searchtxt;
	JButton searchbtn, addbtn, updatebtn, deletebtn,clearbtn;
	JComboBox statuscombo,typecombo;
	JTable table;
	JScrollPane scrollPane;
	DefaultTableModel modeltable;
	
	
	public RoomManagement()  {
		frame=new JFrame("Manage Rooms Record");
		frame.setSize(1050,700);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
		frame.setLayout(new BorderLayout());
		
		north=new JPanel();
		north.setBackground(new Color(21,159,123));
		north.setPreferredSize(new Dimension(100,220));
		north.setLayout(null);
		frame.add(north,BorderLayout.NORTH);
		
		subnorth=new JPanel();
		subnorth.setBackground(new Color(99, 110, 114));
		subnorth.setBounds(0,0,1050,60);
		subnorth.setLayout(null);
		north.add(subnorth);
		
		Searchlbl=new JLabel("Search:");
		Searchlbl.setBounds(20,10,100,35);
		Searchlbl.setFont(new Font("Verdana", Font.BOLD,20));
		Searchlbl.setForeground(Color.white);
		subnorth.add(Searchlbl);
		
		searchtxt=new JTextField();
		searchtxt.setBounds(120,10,200,35);
		searchtxt.setFont(new Font("Verdana", Font.PLAIN,20));
		searchtxt.setBorder(BorderFactory.createLineBorder(Color.white,1));
		subnorth.add(searchtxt);
		
		searchbtn=new JButton("Search");
		searchbtn.setBounds(330,10,100,35);
		searchbtn.setForeground(Color.white);
		searchbtn.setBackground(new Color(21,159,133));
		searchbtn.setFont(new Font("Verdana", Font.PLAIN,20));
		searchbtn.setBorder(BorderFactory.createLineBorder(Color.white,1));
		searchbtn.addActionListener(this);
		subnorth.add(searchbtn);
		
		
		
		RoomIdlbl=new JLabel("ID:");
		RoomIdlbl.setBounds(20,90,100,35);
		RoomIdlbl.setForeground(Color.white);
		RoomIdlbl.setFont(new Font("Verdana", Font.PLAIN,20));
		north.add(RoomIdlbl);
		
		RoomIdtxt=new JTextField();
		RoomIdtxt.setEditable(false);
		RoomIdtxt.setBounds(130,90,220,35);
		RoomIdtxt.setBorder(BorderFactory.createLineBorder(Color.white,1));
		RoomIdtxt.setFont(new Font("Verdana", Font.PLAIN,20));
		north.add(RoomIdtxt);
		
		typelbl=new JLabel("Type:");
		typelbl.setBounds(20,150,100,35);
		typelbl.setForeground(Color.white);
		typelbl.setFont(new Font("Verdana", Font.PLAIN,20));
		north.add(typelbl);
		
	
		typecombo = new JComboBox();
		for (int i = 0; i < Global.ROOM_TYPES.length; i++) {
			typecombo.addItem(Global.ROOM_TYPES[i]);
		}
		typecombo.setFont(new Font("Verdana", Font.PLAIN, 17));
		typecombo.addItemListener(this);
		typecombo.setBounds(130, 150, 220, 35);
		//set rate
		
		north.add(typecombo);
		
		
		ratelbl=new JLabel("Rate:");
		ratelbl.setBounds(380,90,100,35);
		ratelbl.setForeground(Color.white);
		ratelbl.setFont(new Font("Verdana", Font.PLAIN,20));
		north.add(ratelbl);
		
		ratetxt=new JTextField();
		ratetxt.setBorder(BorderFactory.createLineBorder(Color.white,1));
		ratetxt.setBounds(520,90,220,35);
		ratetxt.setFont(new Font("Verdana", Font.PLAIN,20));
		north.add(ratetxt);
		
		statuslbl=new JLabel("Status:");
		statuslbl.setBounds(380,150,100,35);
		statuslbl.setForeground(Color.white);
		statuslbl.setFont(new Font("Verdana", Font.PLAIN,20));
		north.add(statuslbl);
		
		statuscombo = new JComboBox();
		for (int i = 0; i < Global.ROOM_STATUS.length; i++) {
			statuscombo.addItem(Global.ROOM_STATUS[i]);
		}
		statuscombo.setFont(new Font("Verdana", Font.PLAIN, 17));
		statuscombo.setBounds(520, 150, 220, 35);
		north.add(statuscombo);
		
		
		
		
		addbtn=new JButton("Add");
		addbtn.setBounds(800,70,150,35);
		addbtn.setBackground(new Color(99, 110, 114));
		addbtn.setForeground(Color.white);
		addbtn.setFont(new Font("Verdana", Font.PLAIN,20));
		addbtn.addActionListener(this);
		north.add(addbtn);
		
		updatebtn=new JButton("Update");
		updatebtn.setBounds(800,120,150,35);
		updatebtn.setBackground(new Color(99, 110, 114));
		updatebtn.setForeground(Color.white);
		updatebtn.setFont(new Font("Verdana", Font.PLAIN,20));
		updatebtn.addActionListener(this);
		north.add(updatebtn);
		
		deletebtn=new JButton("Delete");
		deletebtn.setBounds(800,170,150,35);
		deletebtn.setBackground(new Color(99, 110, 114));
		deletebtn.setForeground(Color.white);
		deletebtn.setFont(new Font("Verdana", Font.PLAIN,20));
		north.add(deletebtn);
		
		clearbtn=new JButton("Clear");
		clearbtn.setBounds(450,10,100,35);
		clearbtn.setForeground(Color.white);
		clearbtn.setBackground(new Color(21,159,133));
		clearbtn.setFont(new Font("Verdana", Font.PLAIN,20));
		clearbtn.setBorder(BorderFactory.createLineBorder(Color.white,1));
		clearbtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			RoomIdtxt.setText("");
			typecombo.setSelectedIndex(0);
			ratetxt.setText("");
			statuscombo.setSelectedIndex(0);
			
		}
	
		});
		subnorth.add(clearbtn);
		
		
		modeltable = new DefaultTableModel();
		table = new JTable(modeltable);
		JTableHeader h1=table.getTableHeader();
		h1.setBackground(Color.black);
		h1.setForeground(Color.white);
		h1.setFont(new Font("Verdana", Font.BOLD,15));
		table.setFont(new Font("Verdana", Font.PLAIN,16));
		table.setRowHeight(20);
		table.setSelectionBackground(Color.BLACK);
		table.setSelectionForeground(Color.white);
		
		modeltable.addColumn("Room ID");
		modeltable.addColumn("Roo Type");
		modeltable.addColumn("Room Rate");
		modeltable.addColumn("Room Status");
		
		JDBCRoom jdbc2 = new JDBCRoom();
		ArrayList room = jdbc2.select_all();
		if(room.size()>0) {
			for(int i=0; i<room.size(); i++) {
				Room p = (Room) room.get(i);
				Object []tmp= {p.getId(), 
								p.getType(), 
								p.getRate(),
								p.getStatus(),
								};
				modeltable.addRow(tmp);
			}
		}
		scrollPane = new JScrollPane(table);
		frame.add(scrollPane, BorderLayout.CENTER);

		frame.setVisible(true);

	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==addbtn) {

			Room room = new Room();
			
			room.setType(typecombo.getSelectedItem().toString());
			room.setRate(Double.parseDouble(ratetxt.getText()));
			room.setStatus(statuscombo.getSelectedItem().toString());

			JDBCRoom jdbc = new JDBCRoom();
			boolean result = jdbc.insert(room);
			if (result == true) {

				JOptionPane.showMessageDialog(null, "Record saved");
			} else {
				JOptionPane.showMessageDialog(null, "Error");
			}

		}
	
	else if (ae.getSource() == searchbtn) {

		Room room = new Room();
		int rid=Integer.parseInt(searchtxt.getText());
		

		JDBCRoom jdbc = new JDBCRoom();
		room =jdbc.search(rid);
		if (room.getId() >0) {
			String type=room.getType();
			
			int roomid =room.getId();
			RoomIdtxt.setText(Integer.toString(roomid));
			
			if (type.equals("Single")) {
			typecombo.setSelectedIndex(0);
			
			}
			else if (type.equals("Double")) {
				typecombo.setSelectedIndex(1);
				}
			else if (type.equals("Deluxe")) {
				typecombo.setSelectedIndex(2);
				}
			
			double rate=room.getRate();
			ratetxt.setText(Double.toString(rate));
			
			String status=room.getStatus();
			if (status.equals("Available")) {
				statuscombo.setSelectedIndex(0);
				}
				else if (status.equals("Booked")) {
					statuscombo.setSelectedIndex(1);
					
				}
			
			JOptionPane.showMessageDialog(null, "Record Searched");
		} else {
			JOptionPane.showMessageDialog(null, "Error");
		}

		}
if (ae.getSource() == updatebtn) {
			
			//get room info
			Room room =new Room();
			room.setId(Integer.parseInt(RoomIdtxt.getText()));
			room.setType(typecombo.getSelectedItem().toString());
			room.setRate(Double.parseDouble(ratetxt.getText()));
			room.setStatus(statuscombo.getSelectedItem().toString());
			
			//send to middleware
			JDBCRoom jdbc=new JDBCRoom();
			boolean result=jdbc.update(room);
			if(result==true) {
				JOptionPane.showMessageDialog(null, "Updated room");
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Error");
			}
			
		}
	}
	@Override
	public void itemStateChanged(ItemEvent ie) {
		if(ie.getSource()==typecombo) {
			int index=typecombo.getSelectedIndex();
			ratetxt.setText(Double.toString(Global.ROOM_PRICE[index]));
		}
		
	}
	public static void main(String[] args) {
		new RoomManagement();

	}

}
