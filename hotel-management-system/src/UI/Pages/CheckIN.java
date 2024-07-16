/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package UI.Pages;


import UI.LoginPage.dbConnector;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;
import org.joda.time.Days;
import org.joda.time.LocalDate;


/**
 *
 * @author hp
 */
public class CheckIN extends javax.swing.JInternalFrame {
     
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    Connection con;
    final List<Object[]> originalData = new ArrayList<>();
    dbConnector dbc = new dbConnector();
    JPanel discountPanel = new JPanel();
    JTextField discountField = new JTextField(10);


    public CheckIN() throws SQLException {
        initComponents();
        
        displayData();
        storeOriginalData();
        ComboBoxUpdate();
        PriceUpdate();
        
        jTable1.setDefaultEditor(Object.class, null);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
         discountField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
        
                char c = e.getKeyChar();
                String discountInput = discountField.getText();
                if (!Character.isDigit(c) || discountInput.length() == 3) {
                    e.consume();
                }
            }
        });
        discountPanel.add(new JLabel("Enter Discount: "));
        discountPanel.add(discountField);
    }
    
    /* 
    public void ResizeImage() {
    // Load the image from the provided path
    ImageIcon icon = new ImageIcon("src/images/refresh(1).png");
    Image image = icon.getImage();

    // Scale the image to the button's size
    Image scaledImage = image.getScaledInstance(jButton1.getWidth(), jButton1.getHeight(), Image.SCALE_SMOOTH);
    ImageIcon scaledIcon = new ImageIcon(scaledImage);
    
    jButton1.setIcon(scaledIcon);
        
    }
    */

    private void storeOriginalData() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            Object[] rowData = new Object[model.getColumnCount()];
            for (int j = 0; j < model.getColumnCount(); j++) {
                rowData[j] = model.getValueAt(i, j);
            }
            originalData.add(rowData);
        }
    }

    
    private void ComboBoxUpdate() throws SQLException{
    ctype.removeAllItems();
    rs = dbc.getData("select * from types");
    
    ctype.addItem("All");   
    while(rs.next()){
        ctype.addItem(rs.getString("type"));    
    }   
}
    private void PriceUpdate() throws SQLException{
    String item = (String) ctype.getSelectedItem();
    if(!"All".equalsIgnoreCase(item)){
        rs = dbc.getData("select * from types where type='"+item+"'");
        while(rs.next()){
                String iprice = rs.getString("type_price");
                rprice1.setText(iprice);
        }
    }
}
    private void displayData(){
        String avail = "Available";
        try{
            rs = dbc.getData("SELECT* FROM room where status='"+avail+"'");
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            jTable1.removeColumn(jTable1.getColumnModel().getColumn(4));
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        }
    }
    
    private void displayData(String roomtype){
        String avail = "Available";
        try{
            rs = dbc.getData("SELECT* FROM room where status='"+avail+"' and roomtype='"+roomtype+"'");
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            jTable1.removeColumn(jTable1.getColumnModel().getColumn(4));
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        }
    }
    
   private int getDays(){
       LocalDate from = LocalDate.fromDateFields(checkIN.getDate());
       LocalDate to = LocalDate.fromDateFields(checkOUT.getDate());
       int days = Days.daysBetween(from, to).getDays();
       if (days==0){
           days = 1;
       }
       return days;
   }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        govtype = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        fullname = new javax.swing.JTextField();
        Ccnum = new javax.swing.JTextField();
        rtprice = new javax.swing.JTextField();
        govnum = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        rtotal = new javax.swing.JTextField();
        roomnum = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        checkOUT = new com.toedter.calendar.JDateChooser();
        checkIN = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        ctype = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        advance = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rprice1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        noOfdays = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        discountB = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        advanceB = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel12.setText("Room Number:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei", 0, 11)); // NOI18N
        jLabel2.setText("Price/Night:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jLabel11.setFont(new java.awt.Font("Microsoft YaHei", 0, 11)); // NOI18N
        jLabel11.setText("Full Name:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 0, 11)); // NOI18N
        jLabel1.setText("Contact Number:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel15.setFont(new java.awt.Font("Microsoft YaHei", 0, 11)); // NOI18N
        jLabel15.setText("Government ID:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 410, -1));

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel3.setText("Available Rooms:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 19, -1, 20));

        jLabel5.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        jLabel5.setText("/ Check IN");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        govtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Driver License", "Phil Health", "NBI", "Passport", "National ID", " " }));
        jPanel1.add(govtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 250, 20));

        jLabel18.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jLabel18.setText("BREAKDOWN:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));
        jPanel1.add(fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 250, -1));

        Ccnum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CcnumKeyTyped(evt);
            }
        });
        jPanel1.add(Ccnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 250, -1));

        rtprice.setEditable(false);
        rtprice.setBackground(new java.awt.Color(255, 255, 255));
        rtprice.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        rtprice.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(rtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 445, 70, -1));
        jPanel1.add(govnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 250, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 150, 10));

        rtotal.setEditable(false);
        rtotal.setBackground(new java.awt.Color(255, 255, 255));
        rtotal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rtotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rtotal.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(rtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 513, 100, 20));

        roomnum.setEditable(false);
        roomnum.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        roomnum.setOpaque(true);
        jPanel1.add(roomnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 120, 20));

        jButton4.setBackground(new java.awt.Color(89, 168, 105));
        jButton4.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Allocate");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, 120, 50));

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei", 0, 11)); // NOI18N
        jLabel4.setText("Room Type:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei", 0, 11)); // NOI18N
        jLabel7.setText("Check IN date:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei", 0, 11)); // NOI18N
        jLabel8.setText("Check OUT date:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        checkOUT.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jPanel1.add(checkOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 250, 23));

        checkIN.setBackground(new java.awt.Color(255, 255, 255));
        checkIN.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jPanel1.add(checkIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 250, 23));

        jLabel19.setFont(new java.awt.Font("Microsoft YaHei", 0, 11)); // NOI18N
        jLabel19.setText("Address:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));
        jPanel1.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 250, -1));

        ctype.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        ctype.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                ctypePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                ctypePopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel1.add(ctype, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 110, 23));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh(1).png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, -1, 70));

        jTextField1.setForeground(new java.awt.Color(153, 153, 153));
        jTextField1.setText("Search");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 17, 130, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel10.setText("total");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 445, -1, -1));

        advance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                advanceKeyTyped(evt);
            }
        });
        jPanel1.add(advance, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 120, -1));

        jLabel6.setText("Advance Payment:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 383, -1, -1));

        rprice1.setEditable(false);
        rprice1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(rprice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 110, 23));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        jLabel13.setText("/Days");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 515, -1, -1));

        noOfdays.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        noOfdays.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        noOfdays.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(noOfdays, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 513, 30, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Discount");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, -1, 23));

        jLabel14.setText("Discount");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 211, -1, -1));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField2.setText("No");
        jTextField2.setBorder(null);
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 211, 30, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel16.setText("advance payment");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 466, -1, -1));

        discountB.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        discountB.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel1.add(discountB, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 493, 70, 10));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setText("-");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel21.setText("discount");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 488, -1, -1));

        advanceB.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel1.add(advanceB, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 70, 10));

        jButton2.setText("Generate");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 418, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        jTextField1.setText("");
    }//GEN-LAST:event_jTextField1FocusGained

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        
       roomnum.setText("");
       fullname.setText("");
       Ccnum.setText("");
       ctype.setSelectedItem(0);
       checkIN.setDate(null);
       checkOUT.setDate(null);
       address.setText("");
       rprice1.setText("");
       advance.setText("");
       govnum.setText("");
       rtprice.setText("");
       rtotal.setText("");
       advanceB.setText("");
       discountB.setText("");
       discountField.setText("");

       displayData();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void ctypePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_ctypePopupMenuWillBecomeVisible
        String type = ctype.getItemAt(ctype.getSelectedIndex());

        if (type.equalsIgnoreCase("All")) {
            displayData();
        } else {
            try {
                PriceUpdate();
                displayData(type);
            } catch (SQLException ex) {
                Logger.getLogger(CheckIN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_ctypePopupMenuWillBecomeVisible

    private void ctypePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_ctypePopupMenuWillBecomeInvisible
        String type = ctype.getItemAt(ctype.getSelectedIndex());

        if(type.equalsIgnoreCase("All")){
            displayData();
        }else{
            try {
                PriceUpdate();
                displayData(type);
            } catch (SQLException ex) {
                Logger.getLogger(CheckIN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ctypePopupMenuWillBecomeInvisible

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //ordered by sql hierarchy
         String rnum = roomnum.getText();
         String fname = fullname.getText();
         String cnum = Ccnum.getText();
         String add = address.getText();
         String govt = govtype.getItemAt(govtype.getSelectedIndex());
         String govn = govnum.getText();
         String occupied = "Occupied";
         String Stat = "Checked IN";
         java.util.Date checkInDate = checkIN.getDate();
         java.util.Date checkOutDate = checkOUT.getDate();
         
         String advanceField = advance.getText().trim();
         String discountInput = discountField.getText().trim();
         String advanceBreakdown = advanceB.getText().trim();
         String discountBreakdown = discountB.getText().trim();
         String finalTotalCalculation = rtotal.getText().trim();
         
            if(advanceField.isEmpty()){
                advanceB.setText("0");
            }else{
                advanceB.setText(advanceField);
            }
            if(discountInput.isEmpty()){
                discountField.setText("0");
                discountB.setText("0");
            }else{
                discountB.setText(discountInput);
            }
         
         if(fname.isEmpty() || cnum.isEmpty() || add.isEmpty() || govn.isEmpty() || checkInDate==null || checkOutDate==null){
            JOptionPane.showMessageDialog( null, "Please Fill All Fields.", "Try Again", JOptionPane.ERROR_MESSAGE);       
         }else if(rnum.isEmpty()){
             JOptionPane.showMessageDialog( null, "Select a Room. Click a row from the Table.", "Try Again", JOptionPane.ERROR_MESSAGE);
         }else if(advanceBreakdown.isEmpty() || discountBreakdown.isEmpty() || finalTotalCalculation.isEmpty()){
             JOptionPane.showMessageDialog( null, "Please click the generate button before proceeding.", "Try Again", JOptionPane.ERROR_MESSAGE);
         }else if(checkInDate.after(checkOutDate)){
             JOptionPane.showMessageDialog( null, "Invalid check in date!", "Try Again", JOptionPane.ERROR_MESSAGE);
         }else{           
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String datein = sdf.format(checkIN.getDate());
            String dateout = sdf.format(checkOUT.getDate());
                       
            int roomPrice = Integer.parseInt(rprice1.getText());
            int advancePayment = Integer.parseInt(advanceBreakdown);
            int totalRoomPrice = roomPrice * getDays();
            int pendingAmount = totalRoomPrice - advancePayment;      
            
            double inputDiscount = Double.parseDouble(discountBreakdown);
            double totalPrice = Double.parseDouble(String.valueOf(pendingAmount));
            double discountValue = totalPrice * (inputDiscount / 100);
            
            int finalDiscountValue = (int) Math.ceil(discountValue);
            int finalPrice = pendingAmount - finalDiscountValue;

            discountB.setText(String.valueOf(finalDiscountValue));
            rtprice.setText(String.valueOf(totalRoomPrice));
            rtotal.setText(String.valueOf(finalPrice));
            noOfdays.setText(String.valueOf(getDays()));
                 
            int discount = Integer.parseInt(discountField.getText());
             
            int result = JOptionPane.showConfirmDialog(null,"Sure? Allocate room?", "CONFIRMATION",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
             switch (result) {
                 case JOptionPane.YES_OPTION -> {
                     int sulod = dbc.insertData("INSERT INTO client(roomno, Fullname, Cnumber, Address, GovType, GovID, CheckIN, CheckOUT, Rprice, Paid, Discount, TOTAL, Stat)"
                    + "VALUES('"+rnum+"', '"+fname+"', '"+cnum+"', '"+add+"', '"+govt+"', '"+govn+"', '"+datein+"', '"+dateout+"', '"+roomPrice+"', '"+advancePayment+"', '"+discount+"', '"+finalPrice+"', '"+Stat+"')");
                    
                     if(sulod == 1){
                     JOptionPane.showMessageDialog( null, "Allocated Successfully!");
                     dbc.updateData("UPDATE room set status='"+occupied+"' WHERE roomnumber ='"+rnum+"'");
                     }
                     
                     displayData();
                 }
                 case JOptionPane.NO_OPTION -> System.out.println("You Selected No");
                 case JOptionPane.CLOSED_OPTION -> System.out.println("You Closed the prompt");
                 default -> {}
             }
         }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       int rowindex = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        roomnum.setText(""+model.getValueAt(rowindex, 0));
        
//        if (rowindex != -1) {
//            // Get the value from the selected row's second column (index 1)
//            String value = (String) model.getValueAt(rowindex, 1);
//            // Set the selected item in the combo box
//            ctype.setSelectedItem(value);
//        }
        rprice1.setText(""+model.getValueAt(rowindex, 2));

        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void CcnumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CcnumKeyTyped
       char c = evt.getKeyChar();

        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_CcnumKeyTyped

    private void advanceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_advanceKeyTyped
       char c = evt.getKeyChar();

        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_advanceKeyTyped

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    String filterText = jTextField1.getText().toLowerCase();

    // Remove all rows from the model
    model.setRowCount(0);

    // Add the original rows back to the model
    for (Object[] row : originalData) {
            boolean matches = false;
            for (Object cell : row) {
                if (cell.toString().toLowerCase().contains(filterText)) {
                    matches = true;
                    break;
                }
            }
            if (matches) {
                model.addRow(row);
            }
    }

    // Apply the filter
//    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
//    jTable1.setRowSorter(sorter);
//    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + filterText));
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int result = JOptionPane.showConfirmDialog(null, discountPanel, "Discount Percentage", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        String input = discountField.getText().trim();
        
        if (result == JOptionPane.OK_OPTION && !input.isEmpty()) {
                int discountInt = Integer.parseInt(input);
                
                if(discountInt > 100){
                    JOptionPane.showMessageDialog(null, "Discount should not exceed 100.", "Try Again", JOptionPane.ERROR_MESSAGE);
                    discountField.setText("");
                }else{
                    System.out.println("Discount input: " + input);

                    jTextField2.setText(input + "%");
                    if (!rtprice.getText().trim().isEmpty() && !advanceB.getText().trim().isEmpty()) {
                        String advancePaymentTxt = advance.getText().trim();
                        String discountBreakdownTxt = discountField.getText().trim();
                        int roomPrice = Integer.parseInt(rprice1.getText());
                        int advancePayment = Integer.parseInt(advancePaymentTxt);
                        int totalRoomPrice = roomPrice * getDays();
                        int pendingAmount = totalRoomPrice - advancePayment;

                        double inputDiscount = Double.parseDouble(discountBreakdownTxt);
                        double totalPrice = Double.parseDouble(String.valueOf(pendingAmount));
                        double discountValue = totalPrice * (inputDiscount / 100);
                        
                        int finalDiscountValue = (int) Math.ceil(discountValue);
                        int finalPrice = pendingAmount - finalDiscountValue;

                        discountB.setText(String.valueOf(finalDiscountValue));
                        rtotal.setText(String.valueOf(finalPrice));
                    }
                }
                
                    
                
       }else{ 
            System.out.println("Cancelled or empty"); 
            discountField.setText("0");
            discountB.setText("0");
            jTextField2.setText("No");
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        java.util.Date checkInDate = checkIN.getDate();
        java.util.Date checkOutDate = checkOUT.getDate();     
        String advanceField = advance.getText().trim();
        String discountInput = discountField.getText().trim();
        
        
        if(checkInDate!=null && checkOutDate!=null && !rprice1.getText().trim().isEmpty() && checkOutDate.after(checkInDate)){
            int rp = Integer.parseInt(rprice1.getText());
            int totalRoomPrice = rp * getDays();
            rtprice.setText(String.valueOf(totalRoomPrice));
            noOfdays.setText(String.valueOf(getDays()));
         }
            if(advanceField.isEmpty()){
                advanceB.setText("0");
            }else{
                advanceB.setText(advanceField);
            }
            if(discountInput.isEmpty()){
                discountB.setText("0");
            }else{
                discountB.setText(discountInput);
            }
            
        if(!rtprice.getText().trim().isEmpty() && !advanceB.getText().trim().isEmpty() && !discountB.getText().trim().isEmpty()){
            String advancePaymentTxt = advance.getText().trim();
            if(discountField.getText().trim().isEmpty()){
                discountField.setText("0");
            }
            String discountBreakdownTxt = discountField.getText().trim();
            int roomPrice = Integer.parseInt(rprice1.getText());
            int advancePayment = Integer.parseInt(advancePaymentTxt);
            int totalRoomPrice = roomPrice * getDays();
            int pendingAmount = totalRoomPrice - advancePayment;      
            
            double inputDiscount = Double.parseDouble(discountBreakdownTxt);
            double totalPrice = Double.parseDouble(String.valueOf(pendingAmount));
            double discountValue = totalPrice * (inputDiscount / 100);
            
            int finalDiscountValue = (int) Math.ceil(discountValue);
            int finalPrice = pendingAmount - finalDiscountValue;
            
            discountB.setText(String.valueOf(finalDiscountValue));
            rtotal.setText(String.valueOf(finalPrice));
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        jTextField1.setText("Search");
    }//GEN-LAST:event_jTextField1FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Ccnum;
    private javax.swing.JTextField address;
    private javax.swing.JTextField advance;
    private javax.swing.JLabel advanceB;
    private com.toedter.calendar.JDateChooser checkIN;
    private com.toedter.calendar.JDateChooser checkOUT;
    public javax.swing.JComboBox<String> ctype;
    private javax.swing.JLabel discountB;
    private javax.swing.JTextField fullname;
    private javax.swing.JTextField govnum;
    private javax.swing.JComboBox<String> govtype;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField noOfdays;
    private javax.swing.JTextField roomnum;
    private javax.swing.JTextField rprice1;
    private javax.swing.JTextField rtotal;
    private javax.swing.JTextField rtprice;
    // End of variables declaration//GEN-END:variables

   
}
