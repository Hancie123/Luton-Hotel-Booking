package EmployeesUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

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
import javax.swing.table.TableModel;

import Libs.EmployeesLibs;
import Libs.JDBCEmployees;

public class manageEmployees implements ActionListener, MouseListener {
	JFrame frame;
	JLabel nameid, namelbl, agelbl, emaillbl, mobilelbl, addresslbl, departmentlbl, monthlysalarylbl, staffSearch;
	JTextField nameidtxt, nametxt, agetxt, emailtxt, mobiletxt, addresstxt, departmenttxt, monthlysalarytxt;
	JPanel north, subnorth, center;
	JTextField staffsearchtxt;
	JButton staffsearchbtn, addbtn, updatebtn, deletebtn, clearbtn, refreshbtn;
	JComboBox departmentCombo;
	JTable table;
	DefaultTableModel dm;
	JScrollPane scroll;

	public manageEmployees() {
		frame = new JFrame("Manage Employees Record");
		frame.setSize(1050, 700);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
		frame.setLayout(new BorderLayout());

		north = new JPanel();
		north.setBackground(new Color(21, 159, 123));
		north.setPreferredSize(new Dimension(100, 270));
		north.setLayout(null);
		frame.add(north, BorderLayout.NORTH);

		subnorth = new JPanel();
		subnorth.setBackground(new Color(99, 110, 114));
		subnorth.setBounds(0, 0, 1050, 60);
		subnorth.setLayout(null);
		north.add(subnorth);

		staffSearch = new JLabel("Search:");
		staffSearch.setBounds(20, 10, 100, 35);
		staffSearch.setFont(new Font("Verdana", Font.BOLD, 20));
		staffSearch.setForeground(Color.white);
		subnorth.add(staffSearch);

		staffsearchtxt = new JTextField();
		staffsearchtxt.setBounds(120, 10, 200, 35);
		staffsearchtxt.setFont(new Font("Verdana", Font.PLAIN, 20));
		staffsearchtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		subnorth.add(staffsearchtxt);

		staffsearchbtn = new JButton("Search");
		staffsearchbtn.setBounds(330, 10, 100, 35);
		staffsearchbtn.setForeground(Color.white);
		staffsearchbtn.setBackground(new Color(21, 159, 133));
		staffsearchbtn.setFont(new Font("Verdana", Font.PLAIN, 20));
		staffsearchbtn.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		staffsearchbtn.addActionListener(this);
		subnorth.add(staffsearchbtn);

		clearbtn = new JButton("Clear");
		clearbtn.setBounds(450, 10, 100, 35);
		clearbtn.setForeground(Color.white);
		clearbtn.setBackground(new Color(21, 159, 133));
		clearbtn.setFont(new Font("Verdana", Font.PLAIN, 20));
		clearbtn.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				nameidtxt.setText("");
				nametxt.setText("");
				agetxt.setText("");
				mobiletxt.setText("");
				;
				emailtxt.setText("");
				addresstxt.setText("");
				monthlysalarytxt.setText("");
				departmentCombo.setSelectedIndex(0);

			}

		});
		subnorth.add(clearbtn);

		nameid = new JLabel("ID:");
		nameid.setBounds(20, 70, 100, 35);
		nameid.setForeground(Color.white);
		nameid.setFont(new Font("Verdana", Font.PLAIN, 20));
		north.add(nameid);

		nameidtxt = new JTextField();
		nameidtxt.setEditable(false);
		nameidtxt.setBounds(130, 70, 220, 35);
		nameidtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		nameidtxt.setFont(new Font("Verdana", Font.PLAIN, 20));
		north.add(nameidtxt);

		namelbl = new JLabel("Name:");
		namelbl.setBounds(20, 120, 100, 35);
		namelbl.setForeground(Color.white);
		namelbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		north.add(namelbl);

		nametxt = new JTextField();
		nametxt.setBounds(130, 120, 220, 35);
		nametxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		nametxt.setFont(new Font("Verdana", Font.PLAIN, 20));
		north.add(nametxt);

		agelbl = new JLabel("Age:");
		agelbl.setBounds(20, 170, 100, 35);
		agelbl.setForeground(Color.white);
		agelbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		north.add(agelbl);

		agetxt = new JTextField();
		agetxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		agetxt.setBounds(130, 170, 220, 35);
		agetxt.setFont(new Font("Verdana", Font.PLAIN, 20));
		north.add(agetxt);

		mobilelbl = new JLabel("Mobile No:");
		mobilelbl.setBounds(20, 220, 150, 35);
		mobilelbl.setForeground(Color.white);
		mobilelbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		north.add(mobilelbl);

		mobiletxt = new JTextField();
		mobiletxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		mobiletxt.setBounds(130, 220, 220, 35);
		mobiletxt.setFont(new Font("Verdana", Font.PLAIN, 20));
		north.add(mobiletxt);

		emaillbl = new JLabel("Email:");
		emaillbl.setBounds(380, 70, 100, 35);
		emaillbl.setForeground(Color.white);
		emaillbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		north.add(emaillbl);

		emailtxt = new JTextField();
		emailtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		emailtxt.setBounds(520, 70, 220, 35);
		emailtxt.setFont(new Font("Verdana", Font.PLAIN, 20));
		north.add(emailtxt);

		addresslbl = new JLabel("Address:");
		addresslbl.setBounds(380, 120, 100, 35);
		addresslbl.setForeground(Color.white);
		addresslbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		north.add(addresslbl);

		addresstxt = new JTextField();
		addresstxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		addresstxt.setBounds(520, 120, 220, 35);
		addresstxt.setFont(new Font("Verdana", Font.PLAIN, 20));
		north.add(addresstxt);

		monthlysalarylbl = new JLabel("Salary:");
		monthlysalarylbl.setBounds(380, 170, 100, 35);
		monthlysalarylbl.setForeground(Color.white);
		monthlysalarylbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		north.add(monthlysalarylbl);

		monthlysalarytxt = new JTextField();
		monthlysalarytxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		monthlysalarytxt.setBounds(520, 170, 220, 35);
		monthlysalarytxt.setFont(new Font("Verdana", Font.PLAIN, 20));
		north.add(monthlysalarytxt);

		departmentlbl = new JLabel("Department:");
		departmentlbl.setBounds(380, 220, 150, 35);
		departmentlbl.setForeground(Color.white);
		departmentlbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		north.add(departmentlbl);

		Object[] data = { "Cleaner", "Bar Staff", "Laundry", "Gym Instructor", "Swimming Instructor", "Kitchen Staff",
				"Cheff", "Plumber" };
		departmentCombo = new JComboBox(data);
		departmentCombo.setBounds(520, 220, 220, 35);
		departmentCombo.setFont(new Font("Verdana", Font.PLAIN, 20));
		north.add(departmentCombo);

		addbtn = new JButton("Add");
		addbtn.setBounds(800, 70, 150, 35);
		addbtn.setBackground(new Color(99, 110, 114));
		addbtn.setForeground(Color.white);
		addbtn.setFont(new Font("Verdana", Font.PLAIN, 20));
		addbtn.addActionListener(this);
		north.add(addbtn);

		updatebtn = new JButton("Update");
		updatebtn.addActionListener(this);
		updatebtn.setBounds(800, 120, 150, 35);
		updatebtn.setBackground(new Color(99, 110, 114));
		updatebtn.setForeground(Color.white);
		updatebtn.setFont(new Font("Verdana", Font.PLAIN, 20));
		north.add(updatebtn);

		deletebtn = new JButton("Delete");
		deletebtn.addActionListener(this);
		deletebtn.setBounds(800, 170, 150, 35);
		deletebtn.setBackground(new Color(99, 110, 114));
		deletebtn.setForeground(Color.white);
		deletebtn.setFont(new Font("Verdana", Font.PLAIN, 20));
		north.add(deletebtn);

		refreshbtn = new JButton("Refresh");
		refreshbtn.addActionListener(this);
		refreshbtn.setBounds(800, 220, 150, 35);
		refreshbtn.setBackground(new Color(99, 110, 114));
		refreshbtn.setForeground(Color.white);
		refreshbtn.setFont(new Font("Verdana", Font.PLAIN, 20));
		north.add(refreshbtn);
		refreshbtn.addActionListener(this);
		
		
		dm = new DefaultTableModel();
		dm.addColumn("ID");
		dm.addColumn("Name");
		dm.addColumn("Age");
		dm.addColumn("Mobile");
		dm.addColumn("Email");
		dm.addColumn("Address");
		dm.addColumn("Salary");
		dm.addColumn("Department");

		table = new JTable(dm);
		table.setRowHeight(18);
		table.setFont(new Font("Verdana", Font.PLAIN, 14));
		table.setSelectionBackground(Color.black);
		table.setSelectionForeground(Color.white);
		table.addMouseListener(this);
		JTableHeader d1 = table.getTableHeader();
		d1.setBackground(Color.black);
		d1.setForeground(Color.white);
		d1.setFont(new Font("Verdana", Font.PLAIN, 15));

		JDBCEmployees jdbc = new JDBCEmployees();
		ArrayList select = jdbc.select_all();
		if (select.size() > 0) {
			for (int i = 0; i < select.size(); i++) {
				
				EmployeesLibs employees = (EmployeesLibs) select.get(i);
				
				Object[] tmp = { employees.getID(),
						employees.getName(), 
						employees.getAge(),
                        employees.getMobile(),
						employees.getEmail(),
						employees.getAddress(), 
						employees.getSalary(),
						employees.getDepartment()

				};
				dm.addRow(tmp);
			}
		}
		
		JScrollPane scroll = new JScrollPane(table);
		frame.add(scroll, BorderLayout.CENTER);
		frame.setVisible(true);
	}

	public void clearTable() {
		int rowsToRemove = table.getRowCount();
		if (rowsToRemove > 0) {
			for (int i = 0; i < rowsToRemove; i++) {
				dm.removeRow(i);
			}
		}
	}

	public void updateTable() {
		
		dm = new DefaultTableModel();
		dm.addColumn("ID");
		dm.addColumn("Name");
		dm.addColumn("Age");
		dm.addColumn("Mobile");
		dm.addColumn("Email");
		dm.addColumn("Address");
		dm.addColumn("Salary");
		dm.addColumn("Department");

		table = new JTable(dm);
		table.setRowHeight(18);
		table.setFont(new Font("Verdana", Font.PLAIN, 14));
		table.setSelectionBackground(Color.black);
		table.setSelectionForeground(Color.white);
		table.addMouseListener(this);
		JTableHeader d1 = table.getTableHeader();
		d1.setBackground(Color.black);
		d1.setForeground(Color.white);
		d1.setFont(new Font("Verdana", Font.PLAIN, 15));

		JDBCEmployees jdbc = new JDBCEmployees();
		ArrayList select = jdbc.select_all();
		dm.setRowCount(0);
		if (select.size() > 0) {
			for (int i = 0; i < select.size(); i++) {
				EmployeesLibs employees = (EmployeesLibs) select.get(i);
				Object[] tmp = { employees.getID(), employees.getName(), employees.getAge(), employees.getMobile(),
						employees.getEmail(), employees.getAddress(), employees.getSalary(), employees.getDepartment()

				};
				dm.addRow(tmp);
			}
		}
		
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == refreshbtn) {
			
			updateTable();
			
		} else if (ae.getSource() == addbtn) {

			EmployeesLibs employees = new EmployeesLibs();

			employees.setName(nametxt.getText());
			employees.setAge(Integer.parseInt(agetxt.getText()));
			employees.setMobile(Long.parseLong(mobiletxt.getText()));
			employees.setEmail(emailtxt.getText());
			employees.setAddress(addresstxt.getText());
			employees.setSalary(Long.parseLong(monthlysalarytxt.getText()));
			employees.setDepartment(departmentCombo.getSelectedItem().toString());

			JDBCEmployees jdbc = new JDBCEmployees();
			boolean result = jdbc.insert(employees);
			if (result == true) {

				JOptionPane.showMessageDialog(null, "Recorded");
			} else {
				JOptionPane.showMessageDialog(null, "Error");
			}
		} else if (ae.getSource() == staffsearchbtn) {

			EmployeesLibs employees = new EmployeesLibs();

			int Id = Integer.parseInt(staffsearchtxt.getText());

			JDBCEmployees jdbc = new JDBCEmployees();
			employees = jdbc.search(Id);
			if (employees.getID() > 0) {

				int id = employees.getID();
				nameidtxt.setText(Integer.toString(id));

				String name = employees.getName();
				nametxt.setText(name);

				int age = employees.getAge();
				agetxt.setText(Integer.toString(age));

				long mobile = employees.getMobile();
				mobiletxt.setText(Long.toString(mobile));

				String email = employees.getEmail();
				emailtxt.setText(email);

				String address = employees.getAddress();
				addresstxt.setText(address);

				long salary = employees.getSalary();
				monthlysalarytxt.setText(Long.toString(salary));

				String department = employees.getDepartment();

				if (department.equals("Cleaner")) {
					departmentCombo.setSelectedIndex(0);
				} else if (department.equals("Bar Staff")) {
					departmentCombo.setSelectedIndex(1);
				} else if (department.equals("Laundry")) {
					departmentCombo.setSelectedIndex(2);
				} else if (department.equals("Gym Instructor")) {
					departmentCombo.setSelectedIndex(3);
				} else if (department.equals("Swimming Instructor")) {
					departmentCombo.setSelectedIndex(4);
				} else if (department.equals("Kitchen Staff")) {
					departmentCombo.setSelectedIndex(5);
				} else if (department.equals("Cheff")) {
					departmentCombo.setSelectedIndex(6);
				} else if (department.equals("Plumber")) {
					departmentCombo.setSelectedIndex(7);
				}

			}

		} else if (ae.getSource() == deletebtn) {

			int id = Integer.parseInt(nameidtxt.getText());
			JDBCEmployees jdbc = new JDBCEmployees();
			boolean result = jdbc.delete(id);
			if (result == true) {
				JOptionPane.showMessageDialog(null, "The data is deleted successfully");
			} else {
				JOptionPane.showMessageDialog(null, "Error");
			}
		} else if (ae.getSource() == updatebtn) {

			EmployeesLibs employees = new EmployeesLibs();
			employees.setID(Integer.parseInt(nameidtxt.getText()));
			employees.setName(nametxt.getText());
			employees.setAge(Integer.parseInt(agetxt.getText()));
			employees.setMobile(Long.parseLong(mobiletxt.getText()));
			employees.setEmail(emailtxt.getText());
			employees.setAddress(addresstxt.getText());
			employees.setSalary(Long.parseLong(monthlysalarytxt.getText()));
			employees.setDepartment(departmentCombo.getSelectedItem().toString());

			JDBCEmployees jdbc = new JDBCEmployees();
			boolean result = jdbc.update(employees);
			if (result == true) {
				JOptionPane.showMessageDialog(null, "Data has been updated!");
			} else {
				JOptionPane.showMessageDialog(null, "Error to update data");
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int h1 = table.getSelectedRow();

		TableModel model = table.getModel();

		String id1 = model.getValueAt(h1, 0).toString();
		nameidtxt.setText(id1);

		String name = table.getValueAt(h1, 1).toString();
		nametxt.setText(name);

		String age = table.getValueAt(h1, 2).toString();
		agetxt.setText(age);

		String mobile = table.getValueAt(h1, 3).toString();
		mobiletxt.setText(mobile);

		String email = model.getValueAt(h1, 4).toString();
		emailtxt.setText(email);

		String address = model.getValueAt(h1, 5).toString();
		addresstxt.setText(address);

		String salary = model.getValueAt(h1, 6).toString();
		monthlysalarytxt.setText(salary);

		String department = model.getValueAt(h1, 7).toString();
		departmentCombo.setSelectedItem(department);

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
		new manageEmployees();

	}

}
