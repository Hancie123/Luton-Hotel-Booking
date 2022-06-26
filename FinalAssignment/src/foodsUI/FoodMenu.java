package foodsUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import Libs.MaterialTabbed;



public class FoodMenu {
	
	JFrame frame;
	MaterialTabbed tab;
	
	public FoodMenu() {
		frame=new JFrame("Foods Menu");
		frame.setSize(360,750);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
		frame.setResizable(false);
		
		
		JPanel north=new JPanel();
		north.setLayout(null);
		north.setPreferredSize(new Dimension(100,120));
		north.setBackground(new Color(21,159,133));
		frame.add(north,BorderLayout.NORTH);
		
		JLabel title=new JLabel("Luton Hotel System",JLabel.CENTER);
		title.setBounds(50,10,250,35);
		title.setFont(new Font("Times New Roman", Font.BOLD,29));
		title.setForeground(Color.white);
		north.add(title);
		
		JLabel subtitle=new JLabel("New Baneshwor, Kathmandu",JLabel.CENTER);
		subtitle.setBounds(50,40,250,35);
		subtitle.setFont(new Font("Times New Roman", Font.PLAIN,17));
		subtitle.setForeground(Color.white);
		north.add(subtitle);
		
		JLabel subtitle1=new JLabel("Email:luton@gmail.com",JLabel.CENTER);
		subtitle1.setBounds(50,60,250,35);
		subtitle1.setFont(new Font("Times New Roman", Font.PLAIN,17));
		subtitle1.setForeground(Color.white);
		north.add(subtitle1);
		
		JLabel subtitle2=new JLabel("Tel: 534788",JLabel.CENTER);
		subtitle2.setBounds(50,80,250,35);
		subtitle2.setFont(new Font("Times New Roman", Font.PLAIN,17));
		subtitle2.setForeground(Color.white);
		north.add(subtitle2);
		
		//************************Center Panel************************************
		
		tab = new MaterialTabbed();
		tab.setPreferredSize(new Dimension(1000, 80));
		tab.setFont(new Font("Verdana", Font.BOLD, 15));
		frame.add(tab, BorderLayout.CENTER);
		
		JPanel center=new JPanel();
		center.setLayout(null);
		center.setPreferredSize(new Dimension(100,120));
		center.setBackground(new Color(106,101,101));
		tab.add("Menu-1",center);
		
		JPanel center1=new JPanel();
		center1.setLayout(null);
		center1.setPreferredSize(new Dimension(100,120));
		center1.setBackground(new Color(106,101,101));
		tab.add("Menu-2",center1);
		
		JLabel menutitlelbl=new JLabel("Menu Items-1",JLabel.CENTER);
		menutitlelbl.setBounds(50,10,250,35);
		menutitlelbl.setFont(new Font("Brush Script MT", Font.BOLD,30));
		menutitlelbl.setForeground(Color.white);
		center.add(menutitlelbl);
		
		JSeparator j1=new JSeparator();
		j1.setBounds(10,45,320,10);
		center.add(j1);
		
		JLabel item1 = new JLabel("     --------------------------Rs: 40");
		item1.setForeground(Color.white);
		item1.setIcon(new javax.swing.ImageIcon(getClass().getResource("noodles.png")));
        item1.setBounds(10,50,450,80);
        item1.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item1);
        
        JLabel item2 = new JLabel("     --------------------------Rs: 80");
        item2.setIcon(new javax.swing.ImageIcon(getClass().getResource("spaguetti.png")));
        item2.setBounds(10,120,450,80);
        item2.setForeground(Color.white);
        item2.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item2);
        
        JLabel item3 = new JLabel("     --------------------------Rs: 120");
        item3.setIcon(new javax.swing.ImageIcon(getClass().getResource("rice.png")));
        item3.setBounds(10,190,450,80);
        item3.setForeground(Color.white);
        item3.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item3);
        
        JLabel item4 = new JLabel("     --------------------------Rs: 30");
        item4.setIcon(new javax.swing.ImageIcon(getClass().getResource("curry.png")));
        item4.setBounds(10,260,450,80);
        item4.setForeground(Color.white);
        item4.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item4);
        
        JLabel item5 = new JLabel("     --------------------------Rs: 100");
        item5.setForeground(Color.white);
        item5.setIcon(new javax.swing.ImageIcon(getClass().getResource("chicken-leg.png")));
        item5.setBounds(10,330,450,80);
        item5.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item5);
        
        JLabel item6 = new JLabel("     --------------------------Rs: 200");
        item6.setIcon(new javax.swing.ImageIcon(getClass().getResource("fruits.png")));
        item6.setBounds(10,400,450,80);
        item6.setForeground(Color.white);
        item6.setFont(new Font("Times New Roman",Font.BOLD,18));
        center.add(item6);
        
        JLabel menutitlelbl1=new JLabel("Menu Items-2",JLabel.CENTER);
		menutitlelbl1.setBounds(50,10,250,35);
		menutitlelbl1.setFont(new Font("Brush Script MT", Font.BOLD,30));
		menutitlelbl1.setForeground(Color.white);
		center1.add(menutitlelbl1);
		
		JSeparator j2=new JSeparator();
		j2.setBounds(10,45,320,10);
		center1.add(j2);
        
        JLabel item7 = new JLabel("     --------------------------Rs: 60");
        item7.setForeground(Color.white);
        item7.setIcon(new javax.swing.ImageIcon(getClass().getResource("cola.png")));
        item7.setBounds(10,50,450,80);
        item7.setFont(new Font("Times New Roman",Font.BOLD,18));
        center1.add(item7);
        
        JLabel item8 = new JLabel("     --------------------------Rs: 60");
        item8.setForeground(Color.white);
        item8.setIcon(new javax.swing.ImageIcon(getClass().getResource("soda.png")));
        item8.setBounds(10,120,450,80);
        item8.setFont(new Font("Times New Roman",Font.BOLD,18));
        center1.add(item8);
        
        
        JLabel item9 = new JLabel("     --------------------------Rs: 350");
        item9.setForeground(Color.white);
        item9.setIcon(new javax.swing.ImageIcon(getClass().getResource("beer.png")));
        item9.setBounds(10,190,450,80);
        item9.setFont(new Font("Times New Roman",Font.BOLD,18));
        center1.add(item9);
		
		
		//************************South Panel******************************
		
		JPanel south=new JPanel();
		south.setLayout(null);
		south.setPreferredSize(new Dimension(100,40));
		south.setBackground(new Color(21,159,133));
		frame.add(south,BorderLayout.SOUTH);
		
		JLabel thanklbl=new JLabel("Thank you visit again!",JLabel.CENTER);
		thanklbl.setBounds(50,0,250,35);
		thanklbl.setFont(new Font("Times New Roman", Font.PLAIN,17));
		thanklbl.setForeground(Color.white);
		south.add(thanklbl);
		
		frame.setVisible(true);
		
		
	}

	public static void main(String[] args) {
		new FoodMenu();

	}

}
