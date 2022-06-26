package Trial;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import Libs.FileTypeFilter;

public class GenerateBill  {
	
	JLabel label;
	JFrame frame;
	JButton btn, btn1;
	JLabel name, password;
	JTextField nametxt,pricetxt;
	
	JButton savebtn,closebtn;
	
	
	public GenerateBill() {
		frame =new JFrame();
		frame.setTitle("Dilasha");
		frame.setSize(750,250);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridLayout(3,2));
		frame.getContentPane().setBackground(new Color(160,147,147));
		
		name=new JLabel("Product:",JLabel.CENTER);
		password=new JLabel("Price",JLabel.CENTER);
		
		nametxt=new JTextField();
		pricetxt=new JTextField();
		
		savebtn=new JButton("Bill");
		savebtn.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				 String value1=nametxt.getText();
				  
			     String value2=pricetxt.getText();
			     int val2=Integer.parseInt(value2);

			     int total=val2;
			     JFileChooser dialog = new JFileChooser(new File("c:\\"));
			     FileFilter pdfFilter = new FileTypeFilter(".pdf", "PDF Documents");			    
			     dialog.addChoosableFileFilter(pdfFilter);
			     dialog.setSelectedFile(new File("Bill"+".pdf"));
			     int dialogResult = dialog.showSaveDialog(null);
			     if (dialogResult==JFileChooser.APPROVE_OPTION){
			         String filePath = dialog.getSelectedFile().getPath();
			         try{

			             Document myDocument = new Document();
			             PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath));
			             myDocument.open();

			             myDocument.add(new Paragraph("PAY SLIP",FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD)));
			             myDocument.add(new Paragraph(new Date().toString()));
			             myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
			             myDocument.add((new Paragraph("Meal Details",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD))));
			             myDocument.add((new Paragraph("Name of Food: " +value1 + " ",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN))));
			             myDocument.add((new Paragraph("Price of Food: " +value2 + " ",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN))));
			            
			             myDocument.add((new Paragraph("Total Amount:  "+total,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN))));
			             myDocument.newPage();
			             myDocument.close();
			             JOptionPane.showMessageDialog(null,"Bill generated successfully ");
			         }
			         catch(Exception e)
			         {
			             JOptionPane.showMessageDialog(null,e);
			         }
			     }
			 }//GEN-LAS
					
				
		});
		closebtn=new JButton("Close");
		
		frame.add(name);
		frame.add(nametxt);
		frame.add(password);
		frame.add(pricetxt);
		frame.add(closebtn);
		frame.add(savebtn);
		
		
		
		
		
		
		
		
		frame.setVisible(true);
		
		
	}
	
	

		
	
	public static void main(String[] args) {
		new GenerateBill();

	}




	


	
	
		
	}


