package billing;

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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import Libs.Global;


public class Invoice {
	JFrame frame;
	JPanel north, up, down, center;
	

	public Invoice() {
		frame = new JFrame("Invoice");
		frame.setSize(750, 650);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));

		// ************center panel********
		center = new JPanel();
		center.setPreferredSize(new Dimension(100, 150));
		center.setLayout(new BorderLayout());
		frame.add(center, BorderLayout.CENTER);

		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);

		JMenu menu = new JMenu("Print");
		menubar.add(menu);

		JMenuItem print = new JMenuItem("Print Invoice");
		menu.add(print);
		print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				PrinterJob job = PrinterJob.getPrinterJob();
				job.setJobName("Print Data");

				job.setPrintable(new Printable() {
					public int print(Graphics pg, PageFormat pf, int pageNum) {
						pf.setOrientation(PageFormat.LANDSCAPE);
						if (pageNum > 0) {
							return Printable.NO_SUCH_PAGE;
						}

						Graphics2D g2 = (Graphics2D) pg;
						g2.translate(pf.getImageableX(), pf.getImageableY());
						g2.scale(0.85, 0.70);

						center.print(g2);

						return Printable.PAGE_EXISTS;

					}
				});
				boolean ok = job.printDialog();
				if (ok) {
					try {

						job.print();
					} catch (PrinterException ex) {
						ex.printStackTrace();
					}
				}

			}

		});

		// ************north panel********
		north = new JPanel();
		north.setLayout(null);
		north.setPreferredSize(new Dimension(100, 180));
		center.add(north, BorderLayout.NORTH);

	

		SimpleDateFormat simpledate = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String currentDate = simpledate.format(date);

		

		// *******title******
		JLabel namelbl = new JLabel("LUTON HOTEL");
		namelbl.setFont(new Font("Tahoma", Font.BOLD, 35));
		namelbl.setBounds(250, 5, 250, 25);
		north.add(namelbl);

		// *****email******
		JLabel emaillbl = new JLabel("E-mail : lutonhotel@gmail.com");
		emaillbl.setFont(new Font("Arial", Font.PLAIN, 15));
		emaillbl.setBounds(270, 35, 250, 15);
		north.add(emaillbl);

		// ******contact*****
        JLabel contactlbl = new JLabel("Contact : 9855036545");
        contactlbl.setFont(new Font("Arial", Font.PLAIN, 15));
        contactlbl.setBounds(290, 55, 200, 15);
		north.add(contactlbl);
		
		// ******contact*****
        JLabel addresslbl = new JLabel("Luton Hotel, England");
        addresslbl.setFont(new Font("Arial", Font.PLAIN, 15));
        addresslbl.setBounds(295, 75, 200, 15);
        north.add(addresslbl);

		


		// ********center panel*********
		JPanel center1 = new JPanel();
		center1.setLayout(null);
		center.add(center1, BorderLayout.CENTER);
		
		JLabel currentdatelbl = new JLabel("Date:");
		currentdatelbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		currentdatelbl.setBounds(20, 160, 230, 20);
		north.add(currentdatelbl);
		
		JLabel datelbl = new JLabel();
		datelbl.setText(currentDate);
		datelbl.setFont(new Font("Arial", Font.BOLD, 18));
		datelbl.setBounds(80, 162, 200, 20);
		north.add(datelbl);
		
		JLabel bookinglbl = new JLabel("Booking ID:");
		bookinglbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		bookinglbl.setBounds(20, 20, 230, 20);
		center1.add(bookinglbl);
		
		JLabel bookingtxtlbl = new JLabel("Hancie");
		bookingtxtlbl.setText(Integer.toString(Global.currentBilling.getBooking_ID()));
		bookingtxtlbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		bookingtxtlbl.setBounds(150, 20, 230, 20);
		center1.add(bookingtxtlbl);

		JLabel invoiceno = new JLabel("Invoice No:");
		invoiceno.setFont(new Font("Verdana", Font.PLAIN, 18));
		invoiceno.setBounds(500, 70, 230, 20);
		center1.add(invoiceno);

		Random rand=new Random();
		int random=(int) (Math.random()*9900+1);
		
		JLabel invoicenolbl = new JLabel();
		invoicenolbl.setText(String.valueOf(random));
		invoicenolbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		invoicenolbl.setBounds(610, 70, 230, 20);
		center1.add(invoicenolbl);
		
		JLabel status = new JLabel("Status:");
		status.setFont(new Font("Verdana", Font.PLAIN, 18));
		status.setBounds(500, 20, 230, 20);
		center1.add(status);
		
		JLabel statuslbl = new JLabel();
		statuslbl.setText(Global.currentBilling.getBilling_Status());
		statuslbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		statuslbl.setBounds(570, 20, 230, 20);
		center1.add(statuslbl);

		JLabel custname = new JLabel("Customer Name:");
		custname.setFont(new Font("Verdana", Font.PLAIN, 18));
		custname.setBounds(20, 60, 230, 20);
		center1.add(custname);

		JLabel custnamelbl = new JLabel();
		custnamelbl.setText(Global.currentBilling.getName());
		custnamelbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		custnamelbl.setBounds(190, 60, 230, 20);
		center1.add(custnamelbl);

		JSeparator sep1 = new JSeparator();
		sep1.setFont(new Font("Verdana", Font.PLAIN, 18));
		sep1.setBounds(10, 100, 710, 20);
		center1.add(sep1);

		JLabel snlbl = new JLabel("S.No");
		snlbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		snlbl.setBounds(20, 110, 230, 20);
		center1.add(snlbl);

		JLabel description = new JLabel("Description");
		description.setFont(new Font("Verdana", Font.PLAIN, 18));
		description.setBounds(240, 110, 230, 20);
		center1.add(description);

		JLabel amountlbl = new JLabel("Amount");
		amountlbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		amountlbl.setBounds(600, 110, 230, 20);
		center1.add(amountlbl);

		// ***************Separator******************
		JSeparator sep2 = new JSeparator();
		sep2.setFont(new Font("Verdana", Font.PLAIN, 18));
		sep2.setBounds(10, 150, 710, 20);
		center1.add(sep2);

		JLabel onelbl = new JLabel("1.");
		onelbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		onelbl.setBounds(30, 170, 230, 20);
		center1.add(onelbl);

		JLabel roomlbl = new JLabel("Room Amount");
		roomlbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		roomlbl.setBounds(240, 170, 230, 20);
		center1.add(roomlbl);

		JLabel roomamount = new JLabel("1200");
		roomamount.setText(Integer.toString(Global.currentBilling.getRoom_Price()));
		roomamount.setFont(new Font("Verdana", Font.PLAIN, 18));
		roomamount.setBounds(600, 170, 230, 20);
		center1.add(roomamount);

		JLabel twolbl = new JLabel("2.");
		twolbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		twolbl.setBounds(30, 200, 230, 20);
		center1.add(twolbl);

		JLabel drinkslbl = new JLabel("Drinks Amount");
		drinkslbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		drinkslbl.setBounds(240, 200, 230, 20);
		center1.add(drinkslbl);

		JLabel drinksamount = new JLabel();
		drinksamount.setText(Integer.toString(Global.currentBilling.getBar_Price()));
		drinksamount.setFont(new Font("Verdana", Font.PLAIN, 18));
		drinksamount.setBounds(600, 200, 230, 20);
		center1.add(drinksamount);

		JLabel threelbl = new JLabel("3.");
		threelbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		threelbl.setBounds(30, 230, 230, 20);
		center1.add(threelbl);

		JLabel foodlbl = new JLabel("Food Amount");
		foodlbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		foodlbl.setBounds(240, 230, 230, 20);
		center1.add(foodlbl);

		JLabel foodamount = new JLabel();
		foodamount.setText(Integer.toString(Global.currentBilling.getRestaurant_Price()));
		foodamount.setFont(new Font("Verdana", Font.PLAIN, 18));
		foodamount.setBounds(600, 230, 230, 20);
		center1.add(foodamount);

		JLabel fourlbl = new JLabel("4.");
		fourlbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		fourlbl.setBounds(30, 260, 230, 20);
		center1.add(fourlbl);

		JLabel servicelbl = new JLabel("Service Amount");
		servicelbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		servicelbl.setBounds(240, 260, 230, 20);
		center1.add(servicelbl);

		JLabel serviceamount = new JLabel();
		serviceamount.setText(Integer.toString(Global.currentBilling.getService_Price()));
		serviceamount.setFont(new Font("Verdana", Font.PLAIN, 18));
		serviceamount.setBounds(600, 260, 230, 20);
		center1.add(serviceamount);

		// ***************Separator******************
		JSeparator sep3 = new JSeparator();
		sep3.setFont(new Font("Verdana", Font.PLAIN, 18));
		sep3.setBounds(10, 290, 710, 20);
		center1.add(sep3);
		
		JLabel totalbill = new JLabel("Total Amount:");
		totalbill.setFont(new Font("Verdana", Font.PLAIN, 18));
		totalbill.setBounds(480, 300, 230, 20);
		center1.add(totalbill);
		
		JLabel totalbilllbl = new JLabel();
		totalbilllbl.setText(Double.toString(Global.currentBilling.getTotal_Bill()));
		totalbilllbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		totalbilllbl.setBounds(620, 300, 230, 20);
		center1.add(totalbilllbl);
		
		
		JLabel thanklbl = new JLabel("Thank you and visit again!");	
		thanklbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		thanklbl.setBounds(240, 370, 300, 25);
		center1.add(thanklbl);
		
		

		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new Invoice();
	}

}