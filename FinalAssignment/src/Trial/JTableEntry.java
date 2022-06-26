package Trial;




import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class JTableEntry extends JFrame{
              JTextField JT_fname,JT_lname,JT_age,JT_id;
              JButton btn_add;
              JTable table = new JTable();
              JScrollPane pane;
              Object[] cols = null;
 public JTableEntry(){   

     JT_id = new JTextField(20);
     JT_fname = new JTextField(20);
     JT_lname = new JTextField(20);
     JT_age = new JTextField(20);
     JT_id.setBounds(130,20,150,20);
     JT_fname.setBounds(130, 50, 150, 20);
     JT_lname.setBounds(130, 80, 150, 20);
     JT_age.setBounds(130, 110, 150, 20);
     btn_add = new JButton("ADD");
     btn_add.setBounds(300, 80, 100, 20);

       cols = new String[]{"id","fname","lname","age"};

            DefaultTableModel model = (DefaultTableModel) table.getModel();

            model.setColumnIdentifiers(cols);

      //Add A Row To JTable From JTextfields
       btn_add.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {

              model.addRow(new Object[]{
                               JT_id.getText(),JT_fname.getText(),
                               JT_lname.getText(),JT_age.getText()
                                       });
        }
 });
     
       
       
     pane = new JScrollPane(table);
     pane.setBounds(100,150,300,300);

       
     setLayout(null);
  
     add(pane);
     add(JT_id);
     add(JT_fname);
     add(JT_lname);
     add(JT_age);
     add(btn_add);
     
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setVisible(true);
     Color c = Color.decode("#bdb76b");
     getContentPane().setBackground(c);
     setLocationRelativeTo(null);
     setSize(500,500);
    
 }
   public static void main(String[] args){
       new  JTableEntry();
   }
}