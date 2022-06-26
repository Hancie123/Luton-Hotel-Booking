package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
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
import javax.swing.table.TableRowSorter;

import Libs.BookingHistoryLibs;
import Libs.CustomerLibs;
import Libs.CustomerLibs2;
import Libs.JDBCBooking2;
import Libs.JDBCCustomer;


public class BookingHistoryGUI {
	
	JFrame frame;
	JLabel customer;
	 JTable table;
	 JButton btn;
	 JScrollPane scrollPane;
	 DefaultTableModel modeltable;
	 JTextField searchField;
	 TableRowSorter sorter;
	public BookingHistoryGUI() {
		frame=new JFrame("BOOKING HISTORY");
		frame.setSize(1350,700);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new BorderLayout());
		
		JPanel north=new JPanel();
		north.setBackground(new Color(21, 159, 133));
		north.setPreferredSize(new Dimension(100,80));
		north.setLayout(null);
		frame.getContentPane().add(north, BorderLayout.NORTH);
		
		customer=new JLabel("BOOKING HISTORY", SwingConstants.CENTER);
		customer.setBounds(400,20,600,35);
		customer.setForeground(Color.white);
		customer.setFont(new Font("Verdana", Font.BOLD, 30));
		north.add(customer);
		
		JLabel searchlbl=new JLabel("Search Customers: ");
		searchlbl.setBounds(10,20,210,35);
		searchlbl.setForeground(Color.white);
		searchlbl.setFont(new Font("Verdana", Font.BOLD, 18));
		north.add(searchlbl);
		
		searchField=new JTextField();
		searchField.setBorder(BorderFactory.createLineBorder(Color.white,1));
		searchField.setFont(new Font("Times New Roman",Font.PLAIN,18));
		searchField.setBounds(210,20,200,30);
		north.add(searchField);
		
		
		
		btn=new JButton("Print");
		btn.setBackground(new Color(106,101,101));
		btn.setForeground(Color.white);
		btn.setFocusable(false);
		btn.setBounds(1100,20,100,35);
		north.add(btn);
		btn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			
			PrinterJob job = PrinterJob.getPrinterJob();
            job.setJobName("Print Data");
            
            job.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf, int pageNum){
                    pf.setOrientation(PageFormat.LANDSCAPE);
                 if(pageNum > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.47,0.47);
                
                scrollPane.print(g2);
         
               
                return Printable.PAGE_EXISTS;
                         
                
            }
    });
            boolean ok = job.printDialog();
        if(ok){
        try{
            
        job.print();
        }
        catch (PrinterException ex){
	ex.printStackTrace();
}
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
		table.setSelectionBackground(Color.BLACK);
		table.setSelectionForeground(Color.white);
		table.setGridColor(Color.white);
		modeltable.addColumn("Customer ID");
		modeltable.addColumn("Name");
		modeltable.addColumn("Booking ID");
		modeltable.addColumn("Check In");
		modeltable.addColumn("Check Out");
		modeltable.addColumn("Booking Type");
		modeltable.addColumn("Booking Status");
		
		
		sorter = new TableRowSorter<>(modeltable);
		table.setRowSorter(sorter);
		
		JDBCBooking2 jdbc2 = new JDBCBooking2();
		ArrayList bookinghistory = jdbc2.bookinghistory();
		if(bookinghistory.size()>0) {
			for(int i=0; i<bookinghistory.size(); i++) {
				BookingHistoryLibs p = (BookingHistoryLibs) bookinghistory.get(i);
				Object []tmp= {p.getCustomer_ID(), 
								p.getName(), 
								p.getBooking_ID(),	
								p.getCheckIn(),
								p.getCheckOut(),							
								p.getBooking_Type(),
								p.getBooking_Status()
								
								
															
								

				};
				modeltable.addRow(tmp);
			}
		}
		scrollPane = new JScrollPane(table);
		frame.add(scrollPane, BorderLayout.CENTER);
		
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
		
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		new BookingHistoryGUI();
		

	}
}
