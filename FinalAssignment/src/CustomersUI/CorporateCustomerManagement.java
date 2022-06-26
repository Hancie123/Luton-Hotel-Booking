package CustomersUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import Libs.CustomerLibs;
import Libs.CustomerLibs2;
import Libs.JDBCCorporateCustomer;
import Libs.JDBCCustomer;
import Libs.MaterialTabbed;


public class CorporateCustomerManagement implements ActionListener,MouseListener {

	protected static final Color COLOR2 = null;
	JFrame frame;
	JTextField nametxt, mobiletxt, emailtxt, addresstxt, usernametxt, credittxt,customeridtxt;
	JComboBox titlebox, genderCombo, roleCombo;
	JPasswordField passwordtxt;
	JDateChooser DOBtxt;
	

	DefaultTableModel model;
	JTable table;
	JScrollPane scroll;
	JTextField searchtxt;

	JButton insertbtn, updatebtn, search, deletebtn,clearbtn,refreshbtn;
	Object[]columnsName;
	ArrayList<CustomerLibs>select;

	public CorporateCustomerManagement() {
		frame = new JFrame("Corporate Customer Management");
		frame.setSize(1290, 750);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo 100px.png")));

		JPanel north = new JPanel();
		north.setBackground(new Color(21, 159, 133));
		north.setPreferredSize(new Dimension(100, 70));
		north.setLayout(null);
		frame.add(north, BorderLayout.NORTH);

		JLabel titlelbl = new JLabel("Corporate Customer Management", JLabel.CENTER);
		titlelbl.setFont(new Font("Times New Roman", Font.BOLD, 35));
		titlelbl.setBounds(700, 20, 600, 40);
		titlelbl.setForeground(Color.white);
		north.add(titlelbl);

		searchtxt = new JTextField();
		searchtxt.setBounds(30, 20, 200, 35);
		searchtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		searchtxt.setFont(new Font("Times New Roman", Font.BOLD, 18));
		north.add(searchtxt);
		
		clearbtn = new JButton("Clear");
		clearbtn.setFocusable(false);
		clearbtn.setBounds(370, 20, 100, 35);
		clearbtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		clearbtn.setBackground(new Color(106, 101, 101));
		clearbtn.setForeground(Color.WHITE);
		north.add(clearbtn);
		clearbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				customeridtxt.setText(null);
				titlebox.setSelectedIndex(0);
				nametxt.setText(null);
				genderCombo.setSelectedIndex(0);
				DOBtxt.setCalendar(null);
				mobiletxt.setText(null);
				emailtxt.setText(null);
				addresstxt.setText(null);
				usernametxt.setText(null);
				passwordtxt.setText(null);
				credittxt.setText(null);
				roleCombo.setSelectedIndex(0);
				
			}
			
		});

		search = new JButton("Search");
		search.setFocusable(false);
		search.setBounds(250, 20, 100, 35);
		search.setFont(new Font("Times New Roman", Font.BOLD, 18));
		search.setBackground(new Color(106, 101, 101));
		search.setForeground(Color.WHITE);
		north.add(search);
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == search) {

				

					CustomerLibs search = new CustomerLibs();

					int h3 = Integer.parseInt(searchtxt.getText());

					JDBCCorporateCustomer jdbc1 = new JDBCCorporateCustomer();
					search = jdbc1.search(h3);
					if (search.getCustomer_ID() > 0) {
						

						int idd = search.getCustomer_ID();
						customeridtxt.setText(Integer.toString(idd));

						String title = search.getTitle();
						titlebox.setSelectedItem(title);

						String Name = search.getName();
						nametxt.setText(Name);
						
						String gender=search.getGender();
						genderCombo.setSelectedItem(gender);
						
						String date1=search.getDOB();					
						Date date2 = null;
						try {
							date2 = new SimpleDateFormat("yyyy-MM-dd"). parse(date1);
						} catch (ParseException e1) {
							
							e1.printStackTrace();
						} 
						DOBtxt. setDate(date2);
						
						
						
						String mobile1 = search.getMobile();
						mobiletxt.setText(mobile1);
						
						String email = search.getEmail();
						emailtxt.setText(email);
						
						String address =search.getAddress();
						addresstxt.setText(address);
						
						String username = search.getUsername();
						usernametxt.setText(username);
						
						String password = search.getPassword();
						passwordtxt.setText(password);
						
						String credit=search.getCredit_Number();
						credittxt.setText(credit);
						
						
						String role = search.getRole();
						if (role.equals("Customer")) {
							roleCombo.setSelectedIndex(0);
						}
						
						
						

					}

				}

			}

		});

		JPanel south = new JPanel();
		south.setBackground(new Color(21, 159, 133));
		south.setPreferredSize(new Dimension(100, 20));
		frame.add(south, BorderLayout.SOUTH);

		MaterialTabbed tab = new MaterialTabbed();
		tab.setBackground(Color.blue);
		tab.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tab.setTabPlacement(JTabbedPane.BOTTOM);

		frame.add(tab, BorderLayout.CENTER);

		JPanel ManageCustomer = new JPanel();
		ManageCustomer.setLayout(new BorderLayout());
		tab.add("Manage Customers", ManageCustomer);

		JPanel ManageCustomerNorth = new JPanel();
		ManageCustomerNorth.setPreferredSize(new Dimension(100, 270));
		ManageCustomerNorth.setBackground(new Color(106, 101, 101));
		ManageCustomerNorth.setLayout(null);
		ManageCustomer.add(ManageCustomerNorth, BorderLayout.NORTH);
		
		JLabel customeridlbl = new JLabel("Customer ID: ");
		customeridlbl.setBounds(10, 20, 180, 30);
		customeridlbl.setForeground(Color.white);
		customeridlbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		ManageCustomerNorth.add(customeridlbl);

		customeridtxt = new JTextField();
		customeridtxt.setEditable(false);
		customeridtxt.setBounds(150, 20, 200, 30);
		customeridtxt.setFont(new Font("Verdana", Font.PLAIN, 20));
		ManageCustomerNorth.add(customeridtxt);

		JLabel titlelbl1 = new JLabel("Title: ");
		titlelbl1.setBounds(10, 70, 230, 25);
		titlelbl1.setForeground(Color.white);
		titlelbl1.setFont(new Font("Verdana", Font.PLAIN, 20));
		ManageCustomerNorth.add(titlelbl1);

		String title1[] = { "Mr.", "Mrs.", "Miss." };
		titlebox = new JComboBox(title1);
		titlebox.setBounds(150, 70, 200, 30);
		titlebox.setFont(new Font("Verdana", Font.PLAIN, 20));
		ManageCustomerNorth.add(titlebox);

		JLabel Namelbl = new JLabel("Name: ");
		Namelbl.setForeground(Color.white);
		Namelbl.setBounds(10, 120, 230, 25);
		Namelbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		ManageCustomerNorth.add(Namelbl);

		nametxt = new JTextField();
		nametxt.setBounds(150, 120, 200, 30);
		nametxt.setFont(new Font("Verdana", Font.PLAIN, 20));
		ManageCustomerNorth.add(nametxt);

		JLabel Genderlbl = new JLabel("Gender: ");
		Genderlbl.setForeground(Color.white);
		Genderlbl.setBounds(10, 170, 230, 25);
		Genderlbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		ManageCustomerNorth.add(Genderlbl);

		String G1[] = { "Male", "Female", "Other" };
		genderCombo = new JComboBox(G1);
		genderCombo.setBounds(150, 170, 200, 30);
		genderCombo.setFont(new Font("Verdana", Font.PLAIN, 20));
		ManageCustomerNorth.add(genderCombo);

		JLabel DOBlbl = new JLabel("DOB: ");
		DOBlbl.setForeground(Color.white);
		DOBlbl.setBounds(10, 220, 230, 25);
		DOBlbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		ManageCustomerNorth.add(DOBlbl);

		DOBtxt = new JDateChooser();
		DOBtxt.setDateFormatString("yyyy-MM-dd");
		DOBtxt.setBounds(150, 220, 200, 30);
		DOBtxt.setFont(new Font("Verdana", Font.PLAIN, 20));
		ManageCustomerNorth.add(DOBtxt);

		JLabel Mobilelbl = new JLabel("Mobile No: ");
		Mobilelbl.setBounds(380, 20, 230, 30);
		Mobilelbl.setForeground(Color.white);
		Mobilelbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		ManageCustomerNorth.add(Mobilelbl);

		mobiletxt = new JTextField();
		mobiletxt.setBounds(500, 20, 200, 30);
		mobiletxt.setFont(new Font("Verdana", Font.PLAIN, 20));
		ManageCustomerNorth.add(mobiletxt);

		JLabel Emaillbl = new JLabel("Email: ");
		Emaillbl.setForeground(Color.white);
		Emaillbl.setBounds(380, 70, 230, 30);
		Emaillbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		ManageCustomerNorth.add(Emaillbl);

		emailtxt = new JTextField();
		emailtxt.setBounds(500, 70, 200, 30);
		emailtxt.setFont(new Font("Verdana", Font.PLAIN, 20));
		ManageCustomerNorth.add(emailtxt);

		JLabel Addresslbl = new JLabel("Address: ");
		Addresslbl.setForeground(Color.white);
		Addresslbl.setBounds(380, 120, 230, 30);
		Addresslbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		ManageCustomerNorth.add(Addresslbl);

		addresstxt = new JTextField();
		addresstxt.setBounds(500, 120, 200, 30);
		addresstxt.setFont(new Font("Verdana", Font.PLAIN, 20));
		ManageCustomerNorth.add(addresstxt);

		JLabel Usernamelbl = new JLabel("Username: ");
		Usernamelbl.setForeground(Color.white);
		Usernamelbl.setBounds(380, 170, 230, 30);
		Usernamelbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		ManageCustomerNorth.add(Usernamelbl);

		usernametxt = new JTextField();
		usernametxt.setBounds(500, 170, 200, 30);
		usernametxt.setFont(new Font("Verdana", Font.PLAIN, 20));
		ManageCustomerNorth.add(usernametxt);

		JLabel Passwordlbl = new JLabel("Password: ");
		Passwordlbl.setForeground(Color.white);
		Passwordlbl.setBounds(380, 220, 230, 25);
		Passwordlbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		ManageCustomerNorth.add(Passwordlbl);

		passwordtxt = new JPasswordField();
		passwordtxt.setBounds(500, 220, 200, 30);
		passwordtxt.setFont(new Font("Verdana", Font.PLAIN, 20));
		ManageCustomerNorth.add(passwordtxt);

		JLabel Creditlbl = new JLabel("Credit No: ");
		Creditlbl.setForeground(Color.white);
		Creditlbl.setBounds(730, 20, 230, 30);
		Creditlbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		ManageCustomerNorth.add(Creditlbl);

		credittxt = new JTextField();
		credittxt.setBounds(850, 20, 200, 30);
		credittxt.setFont(new Font("Verdana", Font.PLAIN, 20));
		ManageCustomerNorth.add(credittxt);

		JLabel Rolelbl = new JLabel("Role: ");
		Rolelbl.setForeground(Color.white);
		Rolelbl.setBounds(730, 70, 230, 25);
		Rolelbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		ManageCustomerNorth.add(Rolelbl);

		Object[] R1 = { "Corp Client"};
		roleCombo = new JComboBox(R1);
		roleCombo.setBounds(850, 70, 200, 30);
		roleCombo.setFont(new Font("Verdana", Font.PLAIN, 20));
		ManageCustomerNorth.add(roleCombo);

		insertbtn = new JButton("Insert");
		insertbtn.addActionListener(this);
		insertbtn.setBounds(1100, 20, 150, 30);
		insertbtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		insertbtn.setBackground(new Color(21, 159, 133));
		insertbtn.setForeground(Color.white);
		insertbtn.setFocusable(false);
		ManageCustomerNorth.add(insertbtn);

		updatebtn = new JButton("Update");
		updatebtn.addActionListener(this);
		updatebtn.setBounds(1100, 60, 150, 30);
		updatebtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		updatebtn.setBackground(new Color(21, 159, 133));
		updatebtn.setForeground(Color.white);
		updatebtn.setFocusable(false);
		ManageCustomerNorth.add(updatebtn);

		
		
		
		//*********************************Customer Table*********************
		columnsName = new Object[11];
		columnsName[0] = "Customer ID";
		columnsName[1] = "Title";
		columnsName[2] = "Name";
		columnsName[3] = "Gender";
		columnsName[4] = "DOB";
		columnsName[5] = "Mobile No";
		columnsName[6] = "Email";
		columnsName[7] = "Address";
		columnsName[8] = "Username";
		columnsName[9] = "Password";
		columnsName[10] = "Credit Number";
		

		table = new JTable();
		table.addMouseListener(this);
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(columnsName);
		
		table.setGridColor(Color.white);
		table.setRowHeight(25);
		JTableHeader h1 = table.getTableHeader();
		h1.setBackground(Color.black);
		h1.setForeground(Color.white);
		h1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        table.setSelectionBackground(Color.black);
        table.setSelectionForeground(Color.white);

		update();
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(400,20,500,400);
		ManageCustomer.add(scroll, BorderLayout.CENTER);

		JPanel update = new JPanel();
		tab.add("Update", update);

		frame.setVisible(true);

	}
	 private void update() {
		 JDBCCorporateCustomer jdbc = new JDBCCorporateCustomer();
			ArrayList select = jdbc.select_all();
			model.setRowCount(0);
			if (select.size() > 0) {
	            for (int i = 0; i < select.size(); i++) {
	                CustomerLibs tmp_person = (CustomerLibs) select.get(i);
	                
	                Vector tmpPerson = new Vector();
	                
	                tmpPerson.add(tmp_person.getCustomer_ID());
	                tmpPerson.add(tmp_person.getTitle());
	                tmpPerson.add(tmp_person.getName());
	                tmpPerson.add(tmp_person.getGender());
	                tmpPerson.add(tmp_person.getDOB());
	                tmpPerson.add(tmp_person.getMobile());
	                tmpPerson.add(tmp_person.getEmail());
	                tmpPerson.add(tmp_person.getAddress());
	                tmpPerson.add(tmp_person.getUsername());
	                tmpPerson.add(tmp_person.getPassword());
	                tmpPerson.add(tmp_person.getCredit_Number());
	               
	                
	                model.addRow(tmpPerson);
	            }
	        }
	    }

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == insertbtn) {

			if (nametxt.getText().trim().isEmpty() || addresstxt.getText().trim().isEmpty()
					|| mobiletxt.getText().trim().isEmpty() || emailtxt.getText().trim().isEmpty()
					|| usernametxt.getText().trim().isEmpty() || passwordtxt.getText().trim().isEmpty()
					|| credittxt.getText().trim().isEmpty()) {
				ImageIcon i2 = new ImageIcon(getClass().getResource("5-stars.png"));
				JOptionPane.showMessageDialog(null, "Please fill all the details!", "Luton Hotel System",
						JOptionPane.WIDTH, i2);
			}

			else {

				// save
				String title = titlebox.getSelectedItem().toString();
				String name = nametxt.getText();
				String gender = genderCombo.getSelectedItem().toString();
				String DOB = ((JTextField) DOBtxt.getDateEditor().getUiComponent()).getText();
				String mobile = mobiletxt.getText();
				String email = emailtxt.getText();
				String address = addresstxt.getText();
				String username = usernametxt.getText();
				String password = passwordtxt.getText();
				String credit = credittxt.getText();
				String role = roleCombo.getSelectedItem().toString();

				CustomerLibs customer = new CustomerLibs();

				customer.setTitle(title);
				customer.setName(name);
				customer.setGender(gender);
				customer.setDOB(DOB);
				customer.setMobile(mobile);
				customer.setEmail(email);
				customer.setAddress(address);
				customer.setUsername(username);
				customer.setPassword(password);
				customer.setCredit_Number(credit);
				customer.setRole(role);

				JDBCCorporateCustomer jdbc = new JDBCCorporateCustomer();
				boolean result = jdbc.insert(customer);
				if (result == true) {
					update();

					ImageIcon i = new ImageIcon(getClass().getResource("5-stars.png"));
					JOptionPane.showMessageDialog(null, "You have registered your account successfully!",

							"Luton Hotel System", JOptionPane.WIDTH, i);
				}

				else {
					ImageIcon i = new ImageIcon(getClass().getResource("5-stars.png"));
					JOptionPane.showMessageDialog(null, "Error Occured!", "Luton Hotel System", JOptionPane.WIDTH, i);
				}

			}
		}
		else if(ae.getSource()==updatebtn) {
			CustomerLibs customer = new CustomerLibs();
			
			int ID=Integer.parseInt(customeridtxt.getText());
			String title = titlebox.getSelectedItem().toString();
			String name = nametxt.getText();
			String gender = genderCombo.getSelectedItem().toString();
			String DOB = ((JTextField) DOBtxt.getDateEditor().getUiComponent()).getText();
			String mobile = mobiletxt.getText();
			String email = emailtxt.getText();
			String address = addresstxt.getText();
			String username = usernametxt.getText();
			String password = passwordtxt.getText();
			String credit = credittxt.getText();
			String role = roleCombo.getSelectedItem().toString();

			
            customer.setCustomer_ID(ID);
			customer.setTitle(title);
			customer.setName(name);
			customer.setGender(gender);
			customer.setDOB(DOB);
			customer.setMobile(mobile);
			customer.setEmail(email);
			customer.setAddress(address);
			customer.setUsername(username);
			customer.setPassword(password);
			customer.setCredit_Number(credit);
			customer.setRole(role);

			JDBCCorporateCustomer jdbc3 = new JDBCCorporateCustomer();
			boolean result1 = jdbc3.update(customer);
			if (result1 == true) {
				update();
				ImageIcon i = new ImageIcon(getClass().getResource("5-stars.png"));
				JOptionPane.showMessageDialog(null, "The Record is Updated", "Customer Management", JOptionPane.WIDTH, i);
			} else {
				ImageIcon i = new ImageIcon(getClass().getResource("5-stars.png"));
				JOptionPane.showMessageDialog(null, "Error Occured!", "Customer Management", JOptionPane.WIDTH, i);
			}
			
			
		}
		

	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource()==table) {
			
			try {
				
				int tab=table.getSelectedRow();
								
				TableModel tab1=table.getModel();
				
				
				
				String custoid=tab1.getValueAt(tab, 0).toString();
				customeridtxt.setText(custoid);
				
				String title=tab1.getValueAt(tab, 1).toString();
				titlebox.setSelectedItem(title);
				
				String namefield=tab1.getValueAt(tab, 2).toString();
				nametxt.setText(namefield);
				
				String gender=tab1.getValueAt(tab, 3).toString();
				genderCombo.setSelectedItem(gender);
				
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(tab, 4));
				DOBtxt.setDate(date);
				
				String mobile=tab1.getValueAt(tab, 5).toString();
				mobiletxt.setText(mobile);
				
				String email=tab1.getValueAt(tab, 6).toString();
				emailtxt.setText(email);
				
				String address=tab1.getValueAt(tab, 7).toString();
				addresstxt.setText(address);
				
				String username=tab1.getValueAt(tab, 8).toString();
				usernametxt.setText(username);
				
				String password=tab1.getValueAt(tab, 9).toString();
				passwordtxt.setText(password);
				
				String credit=tab1.getValueAt(tab, 10).toString();
				credittxt.setText(credit);
				
				
				
			}
			
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		
		
		
		
		
		}}

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
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public static void main(String[] args) {

		new CorporateCustomerManagement();
	}

}
