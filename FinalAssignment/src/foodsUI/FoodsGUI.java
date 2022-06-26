package foodsUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Libs.FoodLibs;
import Libs.Global;
import Libs.JDBCFoods;

public class FoodsGUI implements ActionListener{
	   JFrame frame;
	   JLabel date;
	   JTextField customeridtxt, roomidtxt,totalamounttxt;
	   JCheckBox item01,item02,item03,item04,item05,item06,item07,item08,item09;
	   JButton foodmenubtn,orderbtn;
	   
	public FoodsGUI() {
		
		frame=new JFrame("Order Foods");
		frame.setSize(1150,750);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
		frame.setLayout(new BorderLayout());
		
		
		
		//****************************North Panel********************************
		JPanel north=new JPanel();
		north.setLayout(null);
		north.setBackground(new Color(21,159,133));
		north.setPreferredSize(new Dimension(100,170));
		north.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Order food Items", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frame.add(north,BorderLayout.NORTH);
		
		JLabel lbl_date = new JLabel("Date: ");
        lbl_date.setBounds(920,30,60,30);
        lbl_date.setFont(new Font("Verdana",Font.PLAIN,18));
        lbl_date.setForeground(Color.white);
        north.add(lbl_date);
        
        date = new JLabel("");
        date.setBounds(980,30,160,30);
        date.setFont(new Font("Verdana",Font.PLAIN,18));
        date.setForeground(Color.white);
        north.add(date);
        curDate();
        
        JLabel Customerlbl = new JLabel("Customer No: ");
        Customerlbl.setBounds(20,50,150,30);
        Customerlbl.setFont(new Font("Times New Roman",Font.BOLD,18));
        Customerlbl.setForeground(Color.white);
        north.add(Customerlbl);
        
        JLabel Roomlbl = new JLabel("Room No: ");
        Roomlbl.setBounds(20,100,150,30);
        Roomlbl.setFont(new Font("Times New Roman",Font.BOLD,18));
        Roomlbl.setForeground(Color.white);
        north.add(Roomlbl);
		
        customeridtxt = new JTextField();
        customeridtxt.setEditable(false);
        //customeridtxt.setText(Integer.toString(Global.currentUser.getCustomer_ID()));
        customeridtxt.setBorder(BorderFactory.createLineBorder(Color.white));
        customeridtxt.setBounds(150,50,250,30);
        customeridtxt.setFont(new Font("Times New Roman",Font.BOLD,18));
        north.add(customeridtxt);
        
        roomidtxt = new JTextField();
        roomidtxt.setBorder(BorderFactory.createLineBorder(Color.white));
        roomidtxt.setBounds(150,100,250,30);
        roomidtxt.setFont(new Font("Times New Roman",Font.BOLD,18));
        north.add(roomidtxt);
        
            
        JLabel welcomelbl = new JLabel("Welcome: ");
        welcomelbl.setBounds(920,70,150,30);
        welcomelbl.setFont(new Font("Times New Roman",Font.BOLD,18));
        welcomelbl.setForeground(Color.white);
        north.add(welcomelbl);
        
        JLabel welcomelbl1 = new JLabel();
        //welcomelbl1.setText(Global.currentUser.getName());
        welcomelbl1.setBounds(1005,70,200,30);
        welcomelbl1.setFont(new Font("Times New Roman",Font.BOLD,18));
        welcomelbl1.setForeground(Color.white);
        north.add(welcomelbl1);
        
        foodmenubtn = new JButton("View Menu");
        foodmenubtn.setBounds(920,120,150,30);
        foodmenubtn.setFocusable(false);
        foodmenubtn.setBackground(new Color(106,101,101));
        foodmenubtn.setFont(new Font("Times New Roman",Font.BOLD,18));
        foodmenubtn.setForeground(Color.white);
        north.add(foodmenubtn);
        foodmenubtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new FoodMenu();
				
			}
        	
        	
        });
		
        //********************************Center Panel**************************************
        JPanel center=new JPanel();
		center.setLayout(null);
		center.setPreferredSize(new Dimension(100,170));
		frame.add(center,BorderLayout.CENTER);
		
		//**************Noddles***********************
		JLabel item1 = new JLabel();
		item1.setIcon(new javax.swing.ImageIcon(getClass().getResource("noodles.png")));
		item1.setBounds(40,50,150,80);
		item1.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item1);
        
        item01 = new JCheckBox("Nooodles");         
        item01.setBounds(25,125,150,20);
        item01.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item01);
        
        
        //********************Pasta******************************
        JLabel item2 = new JLabel();
        item2.setIcon(new javax.swing.ImageIcon(getClass().getResource("spaguetti.png")));
        item2.setBounds(225,50,150,80);
        item2.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item2);
        
        item02 = new JCheckBox("Pasta");      
        item02.setBounds(220,125,150,20);
        item02.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item02);
        
        
        //***********************Rice****************************
        JLabel item3 = new JLabel();
        item3.setIcon(new javax.swing.ImageIcon(getClass().getResource("rice.png")));
        item3.setBounds(410,50,150,80);
        item3.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item3);
        
        item03 = new JCheckBox("Rice");      
        item03.setBounds(420,125,150,20);
        item03.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item03);
        
        //********************Curry**********************************
        JLabel item4 = new JLabel();
        item4.setIcon(new javax.swing.ImageIcon(getClass().getResource("curry.png")));
        item4.setBounds(595,50,150,80);
        item4.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item4);
        
        item04 = new JCheckBox("Curry");      
        item04.setBounds(600,125,150,20);
        item04.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item04);
        
        //***********************Chicken*******************************
        JLabel item5 = new JLabel();
        item5.setIcon(new javax.swing.ImageIcon(getClass().getResource("chicken-leg.png")));
        item5.setBounds(780,50,150,80);
        item5.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item5);
        
        
        item05 = new JCheckBox("Chicken");      
        item05.setBounds(775,125,150,20);
        item05.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item05);
        
        //****************************Fruits************************8
        JLabel item6 = new JLabel();
        item6.setIcon(new javax.swing.ImageIcon(getClass().getResource("fruits.png")));
        item6.setBounds(965,50,150,80);
        item6.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item6);
        
        item06 = new JCheckBox("Fruits");      
        item06.setBounds(960,125,150,20);
        item06.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item06);
        
        //******************Coke*******************88
        JLabel item7 = new JLabel();
        item7.setIcon(new javax.swing.ImageIcon(getClass().getResource("cola.png")));
        item7.setBounds(40,220,150,80);
        item7.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item7);
               
        item07 = new JCheckBox("Coke");      
        item07.setBounds(40,300,150,20);
        item07.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item07);
        
        
        //*********************Sprite***********************
        JLabel item8 = new JLabel();
        item8.setIcon(new javax.swing.ImageIcon(getClass().getResource("soda.png")));
        item8.setBounds(225,220,150,80);
        item8.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item8);
        
        item08 = new JCheckBox("Sprite");      
        item08.setBounds(225,300,150,20);
        item08.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item08);
        
        //************************Beer******************************
        JLabel item9 = new JLabel();
        item9.setIcon(new javax.swing.ImageIcon(getClass().getResource("beer.png")));
        item9.setBounds(410,220,150,80);
        item9.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item9);
        
        item09 = new JCheckBox("Beer");      
        item09.setBounds(410,300,150,20);
        item09.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item09);
        
        
        
        
        
        
        
        
        //****************************South Panel***************************
        JPanel south=new JPanel();
		south.setLayout(null);
		south.setBackground(new Color(21,159,133));
		south.setPreferredSize(new Dimension(100,170));
		south.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Billing", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frame.add(south,BorderLayout.SOUTH);
		
		
		
		JButton calculatebtn = new JButton("Calculator Total: ");
		calculatebtn.setBounds(700,50,180,30);
		calculatebtn.setFocusable(false);
		calculatebtn.setBackground(new Color(106,101,101));
		calculatebtn.setFont(new Font("Times New Roman",Font.BOLD,18));
		calculatebtn.setForeground(Color.white);
        south.add(calculatebtn);
        calculatebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int total;
				int subtotal=0;
				int subtotal1=0;
				
				
				if(item01.isSelected()) {
					subtotal=subtotal+40;
				}
				if(item02.isSelected()) {
					subtotal=subtotal+80;
				}
				if(item03.isSelected()) {
					subtotal=subtotal+120;
				}
				if(item04.isSelected()) {
					subtotal=subtotal+30;
				}
				if(item05.isSelected()) {
					subtotal=subtotal+100;
				}
				if(item06.isSelected()) {
					subtotal=subtotal+200;
				}
				if(item07.isSelected()) {
					subtotal=subtotal+60;
				}
				if(item08.isSelected()) {
					subtotal=subtotal+60;
				}
				if(item09.isSelected()) {
					subtotal=subtotal+350;
				}
				
				total=subtotal;
				totalamounttxt.setText(Integer.toString(total));
			}
			
			
        	
        });
        
       
        totalamounttxt = new JTextField();
        totalamounttxt.setBorder(BorderFactory.createLineBorder(Color.white));
        totalamounttxt.setBounds(900,50,200,30);
        totalamounttxt.setFont(new Font("Times New Roman",Font.BOLD,18));
        south.add(totalamounttxt);
        
        orderbtn = new JButton("Order: ");
        orderbtn.addActionListener(this);
        orderbtn.setBounds(900,100,200,30);
        orderbtn.setFocusable(false);
        orderbtn.setBackground(new Color(106,101,101));
        orderbtn.setFont(new Font("Times New Roman",Font.BOLD,18));
        orderbtn.setForeground(Color.white);
        south.add(orderbtn);
		
		frame.setVisible(true);
		
		
		
	}
	
	public void curDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY/MM/dd");
        LocalDateTime today = LocalDateTime.now();
        date.setText(dtf.format(today));

    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==orderbtn) {
			
			FoodLibs food=new FoodLibs();
			
			food.setTotal_Amount(Long.parseLong(totalamounttxt.getText()));
			food.setRoom_ID(Integer.parseInt(roomidtxt.getText()));
			food.setRegistration_ID(Integer.parseInt(customeridtxt.getText()));
			
			JDBCFoods jdbc=new JDBCFoods();
			boolean result=jdbc.insert(food);
			if(result==true) {
				
				ImageIcon i=new ImageIcon(getClass().getResource("5-stars.png"));
				JOptionPane.showMessageDialog(null, "The data is being recorded!","Luton Hotel System",JOptionPane.WIDTH,i);
			}
			else {
				ImageIcon i=new ImageIcon(getClass().getResource("5-stars.png"));
				JOptionPane.showMessageDialog(null, "Error Ocurred!","Luton Hotel System",JOptionPane.WIDTH,i);
			}
			
		}
		
	}
	
	
	public static void main(String[]args) {
		new FoodsGUI();
	}
	

}
