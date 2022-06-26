package Trial;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.swing.JTextField;

/**
 *
 * @author ccs
 */
public class Demo2 extends javax.swing.JFrame {
   // private boolean dif;

    /**
     * Creates new form Day
     */
    public Demo2() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                        
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        fromdate01 = new com.toedter.calendar.JDateChooser();
        todate01 = new com.toedter.calendar.JDateChooser();
        btn01 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btn02 = new javax.swing.JButton();
        txt2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fromdate02 = new com.toedter.calendar.JDateChooser();
        todate02 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fromdate01.setDateFormatString("MM/dd/yyyy");
        fromdate01.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(fromdate01, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 160, 30));

        todate01.setDateFormatString("MM/dd/yyyy");
        todate01.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(todate01, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 160, 30));

        btn01.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        btn01.setText("Day Diff");
        btn01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn01ActionPerformed(evt);
            }
        });
        jPanel1.add(btn01, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 160, 30));

        jLabel5.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 204));
        jLabel5.setText("Difference Between Two Dates");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 2));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 440, 60));

        jLabel3.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        jLabel3.setText("From");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        jLabel4.setText("To");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 160, 30));

        btn02.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        btn02.setText("Day Diff");
        btn02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn02ActionPerformed(evt);
            }
        });
        jPanel1.add(btn02, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 150, 30));
        jPanel1.add(txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 150, 30));

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 2));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 440, 130));

        fromdate02.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(fromdate02, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 150, 30));

        todate02.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(todate02, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 150, 30));

        jLabel7.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        jLabel7.setText("From");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jLabel8.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        jLabel8.setText("To");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, -1, -1));

        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 2));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 440, 170));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>                      

    private void btn01ActionPerformed(java.awt.event.ActionEvent evt) {                                    
   
         try {  
   SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
                        Date firstDate = fromdate01.getDate();
                        Date secondDate = todate01.getDate();

                        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
                        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

                       jTextField1.setText(String.valueOf(diff));

  } catch (Exception e) {
   e.printStackTrace();
  }
    }                                  

    private void btn02ActionPerformed(java.awt.event.ActionEvent evt) {                                    
   
                String fromdate=((JTextField)fromdate02.getDateEditor().getUiComponent()).getText();
                String todate=((JTextField)todate02.getDateEditor().getUiComponent()).getText();
             
                LocalDate fday=LocalDate.parse(fromdate);
                LocalDate tday=LocalDate.parse(todate);
             
                Long day_gap=ChronoUnit.DAYS.between(fday, tday);
                txt2.setText(String.valueOf(day_gap));
     
     
     
     
     
    }                                  

 
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Demo2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Demo2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Demo2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Demo2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Demo2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                  
    private javax.swing.JButton btn01;
    private javax.swing.JButton btn02;
    private com.toedter.calendar.JDateChooser fromdate01;
    private com.toedter.calendar.JDateChooser fromdate02;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private com.toedter.calendar.JDateChooser todate01;
    private com.toedter.calendar.JDateChooser todate02;
    private javax.swing.JTextField txt2;
    // End of variables declaration                
}