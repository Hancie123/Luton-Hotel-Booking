package Trial;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import Libs.CustomerLibs;
import Libs.JDBCCustomer;

class Demo {

	
	JTextField searchField;
	JButton btn;
	JTable table;
	DefaultTableModel modeltable;
	TableRowSorter sorter;
	

	Demo() {
		JFrame frame = new JFrame();
		frame.setTitle("Hancie e-Learning Studio");
		frame.setLayout(null);
		frame.setSize(1000, 500);
		frame.setLocationRelativeTo(null);

        
		
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
		
		modeltable.addColumn("ID");
		modeltable.addColumn("Title");
		modeltable.addColumn("Name");
		modeltable.addColumn("Gender");
		modeltable.addColumn("DOB");
		modeltable.addColumn("Mobile");
		
		
		sorter = new TableRowSorter<>(modeltable);
		table.setRowSorter(sorter);
		
		JDBCCustomer jdbc2 = new JDBCCustomer();
		ArrayList select = jdbc2.select_all();
		if(select.size()>0) {
			for(int i=0; i<select.size(); i++) {
				CustomerLibs p = (CustomerLibs) select.get(i);
				Object []tmp= {p.getCustomer_ID(), 
								p.getTitle(), 
								p.getName(),
								p.getGender(),	
								p.getDOB(),
								p.getMobile()							
								
								
															
								

				};
				modeltable.addRow(tmp);
			}
		}
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10,50,950,400);
		frame.add(scrollPane, BorderLayout.CENTER);
		
		searchField=new JTextField();
		searchField.setFont(new Font("Times New Roman",Font.PLAIN,18));
		searchField.setBounds(210,10,200,30);
		frame.add(searchField);
		
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

	public static void main(String args[]) {
		new Demo();
	}
}