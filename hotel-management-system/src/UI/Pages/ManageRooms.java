/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package UI.Pages;

import UI.LoginPage.dbConnector;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author hp
 */
public class ManageRooms extends javax.swing.JInternalFrame {

    String roomnum;
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    Connection con;
    
    dbConnector dbc = new dbConnector();
    public ManageRooms() throws SQLException {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        jTable1.setDefaultEditor(Object.class, null);
        jTable2.setDefaultEditor(Object.class, null);
        
        displayData();
        displayData2();
        
    }
    
    private void displayData(){
        try{
            rs = dbc.getData("SELECT* FROM room");
           jTable1.setModel(DbUtils.resultSetToTableModel(rs));
           jTable1.removeColumn(jTable1.getColumnModel().getColumn(4));
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        }
    }
   private void displayData2(){
        try{
            rs = dbc.getData("SELECT* FROM types");
           jTable2.setModel(DbUtils.resultSetToTableModel(rs));
           jTable2.removeColumn(jTable2.getColumnModel().getColumn(2));
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        }
    }
   
   private void ComboBoxUpdate() throws SQLException{
    ctype.removeAllItems();
    rs = dbc.getData("select * from types");
    while(rs.next()){
        ctype.addItem(rs.getString("type"));    
    }
}
   
    private void PriceUpdate() throws SQLException{
    String item = (String) ctype.getSelectedItem();
    rs = dbc.getData("select * from types where type='"+item+"'");
    
    while(rs.next()){
            String iprice = rs.getString("type_price");
            txtprice.setText(iprice);
    }
}
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        roomno = new javax.swing.JTextField();
        txtprice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        ctype = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        price = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        type = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(875, 540));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 470, 340));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel2.setText("Room Number");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 130, 20));

        roomno.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jPanel1.add(roomno, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 240, 30));

        txtprice.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        txtprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpriceKeyTyped(evt);
            }
        });
        jPanel1.add(txtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 240, 240, 30));

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel5.setText("Price:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 180, -1));

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei UI", 2, 10)); // NOI18N
        jLabel7.setText("Double Click a row for Update or Delete");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 240, 32));

        jButton2.setBackground(new java.awt.Color(89, 168, 105));
        jButton2.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Add Room");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 320, 120, 50));

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
        jPanel1.add(ctype, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 240, 30));

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel3.setText("Room Type");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 260, 20));

        jLabel6.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        jLabel6.setText("/ Manage Rooms");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        jButton4.setBackground(new java.awt.Color(237, 162, 0));
        jButton4.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Update");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, 120, 50));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 423, 240, 10));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh(1).png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, -1, -1));

        jTabbedPane1.addTab("Rooms", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 470, 340));

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel4.setText("Room Type");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 70, 20));

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel8.setText("Price");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 60, 20));

        jButton3.setBackground(new java.awt.Color(90, 168, 105));
        jButton3.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Add Type");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 120, 50));

        price.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                priceKeyTyped(evt);
            }
        });
        jPanel2.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 240, 30));

        jLabel9.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        jLabel9.setText("/ Manage Room Type");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        jButton5.setBackground(new java.awt.Color(236, 162, 0));
        jButton5.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Update");
        jButton5.setBorderPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 120, 50));

        type.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jPanel2.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 240, 30));

        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei UI", 2, 10)); // NOI18N
        jLabel11.setText("Double Click a row for Update or Delete");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, 240, 32));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 240, 10));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh(1).png"))); // NOI18N
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, -1, -1));

        jTabbedPane1.addTab("Room Type", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if(evt.getClickCount() == 2){
            String check=JOptionPane.showInputDialog(this,"Type 'Delete' to remove selected row permanently.\n"
                + "Type 'Update' to configure selected row.");
            
            if(check == null){
                evt.consume();
            }
            
            else if(check.equalsIgnoreCase("delete")){
                DefaultTableModel dmodel=(DefaultTableModel) jTable1.getModel();
                int rows=jTable1.getSelectedRow();
                roomnum=(String) dmodel.getValueAt(rows,0);
                String s1=(String) dmodel.getValueAt(rows,3);
                if(s1.equalsIgnoreCase("occupied"))
                JOptionPane.showMessageDialog(this,"Sorry Room is Occupied So unable to delete it");
                else{

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plasabas_db", "root", "");
                        pst = con.prepareStatement("delete from room where roomnumber=?");
                        pst.setString(1, roomnum);
                        pst.executeUpdate();
                        displayData();
                    }
                    catch(Exception e){}
                }
            }
            else if(check.equalsIgnoreCase("update")){
                DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
                int row=jTable1.getSelectedRow();
                
                roomno.setText(""+model.getValueAt(row, 0));
                String s2 = (String.valueOf(model.getValueAt(row, 2)));
                String s3=(String) model.getValueAt(row,3);

                if(s3.equalsIgnoreCase("occupied"))
                JOptionPane.showMessageDialog(this,"Sorry Room is Occupied So unable to Update it");
                else{

 
                    ctype.setSelectedItem(model.getValueAt(row, 1));
                    txtprice.setText(s2);

                }
            }

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(roomno.getText().equals("")){
            JOptionPane.showMessageDialog(this, "All Field is Required");
            roomno.requestFocus();
        }
        else if(txtprice.getText().equals("")){
            JOptionPane.showMessageDialog(this, "All Field is Required");
            txtprice.requestFocus();
        }
        else{

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plasabas_db", "root", "");
                pst=con.prepareStatement("select * from room where roomnumber=?");
                pst.setString(1, roomno.getText());
                rs=pst.executeQuery();
                if(rs.next()){
                    JOptionPane.showMessageDialog( null, "Room Number Already Exists.", "Try Again", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    String room = roomno.getText();
                    String type = ctype.getItemAt(ctype.getSelectedIndex());
                    int pric = Integer.parseInt(txtprice.getText());
                    String avail = "Available";

                    int result = dbc.insertData("INSERT INTO room(roomnumber,roomtype,price,status)"
                        + "VALUES('"+room+"', '"+type+"','"+pric+"', '"+avail+"')");
                    if(result == 1){
                        JOptionPane.showMessageDialog( null, "Room Added Successfully!");
                    }
                    displayData();
                    txtprice.setText("");
                    roomno.setText("");

                }

            } catch (ClassNotFoundException | HeadlessException |SQLException ex) {
                System.out.println("Error:" + ex.getMessage());
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int roomprice =  Integer.parseInt(txtprice.getText());
        String avail = "Available";
        dbc.updateData("UPDATE room SET roomtype= '"+ctype.getSelectedItem().toString()+"', price= '"+roomprice+"', status= '"+avail+"' "
            + "WHERE roomnumber='"+roomno.getText()+"' ");

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        if(evt.getClickCount() == 2){
            String check=JOptionPane.showInputDialog(this,"Type 'Delete' to remove selected row permanently.\n"
                + "Type 'Update' to configure selected row.");
            
            if(check == null){
                evt.consume();
            }
            
            else if(check.equalsIgnoreCase("delete")){
                DefaultTableModel dmodel=(DefaultTableModel) jTable2.getModel();
                int rows=jTable2.getSelectedRow();
                String s1 =(String) dmodel.getValueAt(rows,0);
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plasabas_db", "root", "");
                    pst = con.prepareStatement("delete from types where type=?");
                    pst.setString(1, s1);
                    pst.executeUpdate();
                    displayData2();
                }
                catch(ClassNotFoundException | SQLException ex){}
            }
            else if(check.equalsIgnoreCase("update")){
                DefaultTableModel model=(DefaultTableModel) jTable2.getModel();
                int row=jTable1.getSelectedRow();
                String s1 =(String) model.getValueAt(row,0);
                String s2 = (String.valueOf(model.getValueAt(row, 1)));
                
                type.setText(s1);
                price.setText(s2);
                type.setEditable(false);
            }

        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(type.getText().equals("")){
            JOptionPane.showMessageDialog(this, "All Field is Required");
            type.requestFocus();
        }else if(price.getText().equals("")){
            JOptionPane.showMessageDialog(this, "All Field is Required");
            type.requestFocus();
        }else{
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plasabas_db", "root", "");
                pst=con.prepareStatement("select * from types where type=?");
                pst.setString(1, type.getText());
                rs=pst.executeQuery();

                if(rs.next()){
                    JOptionPane.showMessageDialog( null, "Redundant Room Type.", "Try Again", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    String rtype = type.getText();
                    int pric=Integer.parseInt(price.getText());

                    int result = dbc.insertData("INSERT INTO types(type,type_price)"
                        + "VALUES('"+rtype+"', '"+pric+"')");
                    if(result == 1){
                        JOptionPane.showMessageDialog( null, "Room Added Successfully!");
                    }
                    displayData();
                    txtprice.setText("");
                    roomno.setText("");
                }
            } catch (ClassNotFoundException | HeadlessException |SQLException ex) {
                System.out.println("Error:" + ex.getMessage());
            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int typeprice =  Integer.parseInt(price.getText());
        dbc.updateData("UPDATE types SET type= '"+type.getText()+"', price= '"+typeprice+"' "
            + "WHERE roomnumber='"+roomno.getText()+"' ");
        type.setEditable(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
       displayData();
  
       roomno.setText("");
       ctype.setSelectedItem("");
       price.setText("");
        
       try {
            ComboBoxUpdate();
            PriceUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ManageRooms.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txtpriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpriceKeyTyped
        char c = evt.getKeyChar();

        if(!Character.isDigit(c)){
            evt.consume();
        }

    }//GEN-LAST:event_txtpriceKeyTyped

    private void priceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceKeyTyped
        char c = evt.getKeyChar();

        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_priceKeyTyped

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        type.setText("");
        price.setText("");
        
        displayData2();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void ctypePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_ctypePopupMenuWillBecomeVisible
        try {
            PriceUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ManageRooms.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ctypePopupMenuWillBecomeVisible

    private void ctypePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_ctypePopupMenuWillBecomeInvisible
        try {
            PriceUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ManageRooms.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ctypePopupMenuWillBecomeInvisible


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> ctype;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField price;
    public javax.swing.JTextField roomno;
    public javax.swing.JTextField txtprice;
    private javax.swing.JTextField type;
    // End of variables declaration//GEN-END:variables
}
