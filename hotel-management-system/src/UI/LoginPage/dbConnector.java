/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI.LoginPage;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class dbConnector {
    private Connection connect;
    
    public dbConnector(){
            try{
                connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/plasabas_db", "root", "");
            }catch(SQLException ex) {
                System.out.println("Can't connect to database:"+ex.getMessage());
            }
    }
    
    public ResultSet getData(String sql)throws SQLException{
        Statement stmt = connect.createStatement();
        ResultSet rslt = stmt.executeQuery(sql);
        return rslt;
    }
    
    public int insertData(String sql){
        int result;
        try{
            PreparedStatement pst = connect.prepareStatement(sql);
            pst.executeUpdate();
            System.out.println("Data inserted successfully");
            pst.close();
            result=1;
        }catch(SQLException ex){
            System.out.println("Connection Error: "+ex);
            result=0;
        }
        return result;
    }
    
    public void updateData(String sql){
        try{
            try (PreparedStatement pst = connect.prepareStatement(sql)) {
                int rowsUpdated = pst.executeUpdate();
                if (rowsUpdated > 0){
                    JOptionPane.showMessageDialog(null, "Data Updated Successfully!");
                }else{
                    JOptionPane.showMessageDialog(null, "Data Failed to Update");
                }
            }
        }catch(SQLException ex){
            System.out.println("Connection Error: "+ex);   
            }  
    }
    
    public int deleteData(String sql){
        int result;
        try {
            PreparedStatement pst = connect.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data deleted successfully!");
            pst.close();
            result=1;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data failed to delete.");
            System.out.println("Date failed to update: "+ e);
            result=0;
        }
        return result;
    }
    
}