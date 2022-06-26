package Trial;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import com.toedter.calendar.JDateChooser;

public class Dashboard {

	JFrame frame;
	JTextField t1;
	JButton btn;
	JDateChooser checkin;

	public Dashboard() {
		frame = new JFrame("Hancie e-Learning Studio");
		frame.setSize(650, 450);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		t1 = new JTextField();
		t1.setBounds(200, 100, 200, 35);
		t1.setBorder(new MatteBorder(0, 0, 2, 0, Color.red));
		t1.setBackground(new Color(255, 255, 255));
		frame.add(t1);
		
		Date date=new Date();
		
		
		checkin = new JDateChooser();
		checkin.setMinSelectableDate(date);
        checkin.setDateFormatString("yyyy-MM-dd");
		checkin.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
		checkin.setFont(new Font("Verdana",Font.PLAIN,15));
		checkin.setBounds(200,150,200,30);
		frame.add(checkin);

		btn = new JButton("Check");
		btn.setBounds(200, 200, 200, 35);
		btn.setBackground(new Color(21, 159, 133));
		btn.setForeground(Color.white);
		btn.setFont(new Font("Verdana", Font.PLAIN, 18));
		frame.add(btn);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int booking = Integer.parseInt(t1.getText());
				
				String date=((JTextField)checkin.getDateEditor().getUiComponent()).getText();
				Connection conn;
				PreparedStatement pstat;
				String sql = "SELECT * FROM booking WHERE Customer_ID='" + booking + "'";
				String sql1 = "SELECT * FROM booking WHERE CheckIn='" + date + "'";
				ResultSet rs;
				try {

					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database", "root", "");

					pstat = conn.prepareStatement(sql);
					

					rs = pstat.executeQuery();
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Already Exists");
					} else {
						JOptionPane.showMessageDialog(null, "Not Exists");
					}

				} catch (Exception ex) {

				}
				

			}

		});

		frame.setVisible(true);

	}

	public static void main(String[] args) {

		new Dashboard();
	}
}
