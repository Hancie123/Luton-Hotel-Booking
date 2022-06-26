package roomUI;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import Libs.JDBCCustomer;
import Libs.JDBCRoom;
import Libs.Room;



public class roomDetails {
	
	JFrame frame;
	JLabel customer;
	 JTable table;
	 JButton btn;
	 JScrollPane scrollPane;
	 DefaultTableModel modeltable;
	public roomDetails() {
		frame=new JFrame("ROOM DETAILS");
		frame.setSize(1250,700);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new BorderLayout());
		
		JPanel north=new JPanel();
		north.setBackground(new Color(21, 159, 133));
		north.setPreferredSize(new Dimension(100,80));
		north.setLayout(new FlowLayout());
		frame.getContentPane().add(north, BorderLayout.NORTH);
		
		customer=new JLabel("ROOM DETAILS", SwingConstants.CENTER);
		customer.setPreferredSize(new Dimension(300,70));
		customer.setForeground(Color.white);
		customer.setFont(new Font("Verdana", Font.BOLD, 18));
		north.add(customer);
		
		btn=new JButton("Print");
		north.add(btn);
		btn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			
		
		
		
		MessageFormat h1=new MessageFormat("Item Report");

		try {table.print(JTable.PrintMode.NORMAL, h1, null);

		}
		catch (Exception e) {

		JOptionPane.showMessageDialog(null,"Hello");

		}
		}
		
		
		});
		modeltable = new DefaultTableModel();
		table = new JTable(modeltable);
		JTableHeader h1=table.getTableHeader();
		h1.setBackground(Color.black);
		h1.setForeground(Color.white);
		h1.setFont(new Font("Verdana", Font.BOLD,15));
		table.setFont(new Font("Verdana", Font.PLAIN,16));
		table.setRowHeight(20);
		table.setColumnSelectionAllowed(true);
		table.setSelectionBackground(Color.BLACK);
		table.setSelectionForeground(Color.white);
		
		modeltable.addColumn("ID");
		modeltable.addColumn("Type");
		modeltable.addColumn("Rate");
		modeltable.addColumn("Status");
		
		
		
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

	public static void main(String[] args) {
		new roomDetails();
		

	}
}
