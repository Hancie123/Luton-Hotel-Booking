package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
          
public class AboutUs {
	JFrame frame;
	JPanel panel, panel1, panel2;
	JLabel background, developer, image1;
	JTextArea article;
	
	public AboutUs() {
		
		frame=new JFrame();
		frame.setTitle("About Us");
		frame.setResizable(false);
		frame.setSize(850,500);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setLayout(new BorderLayout());
		
		panel=new JPanel();
		panel.setBackground(new Color(33, 230, 193));
		panel.setPreferredSize(new Dimension(0,80));
		frame.add(panel, BorderLayout.NORTH);
		
		JLabel label=new JLabel("About Us", SwingConstants.CENTER);
		label.setPreferredSize(new Dimension(300,80));
		label.setFont(new Font("Verdana", Font.BOLD, 25));
		panel.add(label);
		
		panel1=new JPanel();
		panel1.setBackground(new Color(40, 199, 250));
		panel1.setPreferredSize(new Dimension(400,50));
		frame.add(panel1, BorderLayout.WEST);
		
		panel2=new JPanel();
		panel2.setBackground(new Color(255,255,255));
		panel2.setPreferredSize(new Dimension(400,50));
		panel2.setLayout(null);
		frame.add(panel2, BorderLayout.CENTER);
		
		
		
		background=new JLabel("");
		Image img1=new ImageIcon(this.getClass().getResource("About us page-pana.png")).getImage();
		background.setIcon(new ImageIcon(img1));
		background.setBounds(0,0,550,550);
		panel1.add(background);
		
		developer=new JLabel("DEVELOPERS");
		developer.setFont(new Font("Tahoma",Font.BOLD, 19));
		developer.setBounds(160,10,150,35);
		panel2.add(developer);
		
		JLabel member=new JLabel("Members:");
		member.setFont(new Font("Tahoma",Font.BOLD, 19));
		member.setBounds(10,60,150,35);
		panel2.add(member);
		
		JLabel hancie=new JLabel("Hancie Phago");
		hancie.setFont(new Font("Tahoma",Font.PLAIN, 19));
		hancie.setBounds(110,60,150,35);
		panel2.add(hancie);
		
		JLabel nishav=new JLabel("Nishav Rayamajhi");
		nishav.setFont(new Font("Tahoma",Font.PLAIN, 19));
		nishav.setBounds(110,80,250,35);
		panel2.add(nishav);
		
		JLabel nikita=new JLabel("Nikita Thapa");
		nikita.setFont(new Font("Tahoma",Font.PLAIN, 19));
		nikita.setBounds(110,100,250,35);
		panel2.add(nikita);
		
		JLabel Loman=new JLabel("Loman Gurung");
		Loman.setFont(new Font("Tahoma",Font.PLAIN, 19));
		Loman.setBounds(110,120,250,35);
		panel2.add(Loman);
		
		JLabel Nidaan=new JLabel("Nidaan Maharjan");
		Nidaan.setFont(new Font("Tahoma",Font.PLAIN, 19));
		Nidaan.setBounds(110,140,250,35);
		panel2.add(Nidaan);
		
		
		
		
		
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new AboutUs();

	}

}
