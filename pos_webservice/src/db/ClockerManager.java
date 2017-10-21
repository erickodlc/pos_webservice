/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import config.Constant;
import db.tables.TimeKeeping;
import objects.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.POSCalendar;

/**
 *
 * @author ETDelacruz
 */
public class ClockerManager {
    
    private DBFactory dbf;
    private Connection conn;
    private ResultSet rs;
    private Statement stmt;
    private PreparedStatement pstmt;
    
    
    public ClockerManager(){
        dbf = new DBFactory();
    }
    
    public boolean createNewTimeKeeping (){
    
        conn = dbf.getConn();
        
        if(conn != null){
        
            String sql = TimeKeeping.CREATE_TIMEKEEP_TODAY;
            sql = sql.replace("{YYYYMMDD}", POSCalendar.getYYYYMMDD());
            
            try {
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                stmt.close();
                conn.close();
                
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(ClockerManager.class.getName()).log(Level.SEVERE, null, ex);
               
            }
            
        }
        
        return false;
    }
    
    public boolean createNewTimeKeeping (String inventorySpace){
        
        conn = dbf.getConn(inventorySpace);
        
       
        if(conn != null){
        
            String sql = TimeKeeping.CREATE_TIMEKEEP_TODAY;
            sql = sql.replace("{YYYYMMDD}", POSCalendar.getYYYYMMDD());
            try {
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                stmt.close();
                conn.close();
                
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(ClockerManager.class.getName()).log(Level.SEVERE, null, ex);
               
            }
            
        }
        
        return false;
    }
    
    public boolean insertNewTimeRecord(User user){
    
        conn = dbf.getConn();
        
        if(conn != null){
            
            String sql = TimeKeeping.TIME_IN;
            sql = sql.replace("{YYYYMMDD}", POSCalendar.getYYYYMMDD());
            
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, user.getUserid());
                pstmt.setString(2, user.getFirstname());
                pstmt.setString(3, user.getLastname());
                pstmt.setString(4, user.getUsername());
                pstmt.setString(5, Constant.RECORD_TYPE_JOB);
                
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
                
                return true;
            } catch (SQLException ex) {
                
                Logger.getLogger(ClockerManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return false;
    }
    
    public boolean insertNewTimeRecord(User user, String inventorySpace){
        
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
            
            String sql = TimeKeeping.TIME_IN;
            sql = sql.replace("{YYYYMMDD}", POSCalendar.getYYYYMMDD());
            
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, user.getUserid());
                pstmt.setString(2, user.getFirstname());
                pstmt.setString(3, user.getLastname());
                pstmt.setString(4, user.getUsername());
                pstmt.setString(5, Constant.RECORD_TYPE_JOB);
                
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
                
                return true;
            } catch (SQLException ex) {
                
                Logger.getLogger(ClockerManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return false;
    }
    
    
    public boolean updateTimeRecord(int entry_id, String inventorySpace){
    
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
            String sql = TimeKeeping.TIME_OUT;
            sql = sql.replace("{YYYYMMDD}", POSCalendar.getYYYYMMDD());
            
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "end of shift");
                pstmt.setInt(2, entry_id);
                pstmt.setString(3, Constant.RECORD_TYPE_JOB);
               
                
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
                
                return true;
            } catch (SQLException ex) {
                
                Logger.getLogger(ClockerManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return false;
    }
    
    
    public boolean updateTimeRecord(int entry_id){
        
        conn = dbf.getConn();
        
        if(conn != null){
            String sql = TimeKeeping.TIME_OUT;
            sql = sql.replace("{YYYYMMDD}", POSCalendar.getYYYYMMDD());
            
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "end of shift");
                pstmt.setInt(2, entry_id);
                pstmt.setString(3, Constant.RECORD_TYPE_JOB);
               
                
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
                
                return true;
            } catch (SQLException ex) {
                
                Logger.getLogger(ClockerManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return false;
    }
    
    
    public boolean insertNewBreakRecord(User user, String inventorySpace){
    
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
            String sql = TimeKeeping.START_BREAK;
            sql = sql.replace("{YYYYMMDD}", POSCalendar.getYYYYMMDD());
            
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, user.getUserid());
                pstmt.setString(2, user.getFirstname());
                pstmt.setString(3, user.getLastname());
                pstmt.setString(4, user.getUsername());
                pstmt.setString(5, Constant.RECORD_TYPE_BREAK);
                
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
                
                return true;
            } catch (SQLException ex) {
                
                Logger.getLogger(ClockerManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return false;
    }
    
    
    public boolean insertNewBreakRecord(User user){
        
        conn = dbf.getConn();
        
        if(conn != null){
            String sql = TimeKeeping.START_BREAK;
            sql = sql.replace("{YYYYMMDD}", POSCalendar.getYYYYMMDD());
            
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, user.getUserid());
                pstmt.setString(2, user.getFirstname());
                pstmt.setString(3, user.getLastname());
                pstmt.setString(4, user.getUsername());
                pstmt.setString(5, Constant.RECORD_TYPE_BREAK);
                
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
                
                return true;
            } catch (SQLException ex) {
                
                Logger.getLogger(ClockerManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return false;
    }
    
    
     public boolean updateBreakRecord(int entry_id){
    
        conn = dbf.getConn();
        
        if(conn != null){
            String sql = TimeKeeping.END_BREAK;
            sql = sql.replace("{YYYYMMDD}", POSCalendar.getYYYYMMDD());
            
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "end of break");
                pstmt.setInt(2, entry_id);
                pstmt.setString(3, Constant.RECORD_TYPE_BREAK);
               
                
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
                
                return true;
            } catch (SQLException ex) {
                
                Logger.getLogger(ClockerManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return false;
    }
     
     
     public boolean updateBreakRecord(int entry_id, String inventorySpace){
    	    
         conn = dbf.getConn(inventorySpace);
         
         if(conn != null){
             String sql = TimeKeeping.END_BREAK;
             sql = sql.replace("{YYYYMMDD}", POSCalendar.getYYYYMMDD());
             
             try {
                 pstmt = conn.prepareStatement(sql);
                 pstmt.setString(1, "end of break");
                 pstmt.setInt(2, entry_id);
                 pstmt.setString(3, Constant.RECORD_TYPE_BREAK);
                
                 
                 pstmt.executeUpdate();
                 pstmt.close();
                 conn.close();
                 
                 return true;
             } catch (SQLException ex) {
                 
                 Logger.getLogger(ClockerManager.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         
         return false;
     }
     
    public int getEntryRecordJob(int userid){
        
        int id = 0;
        conn = dbf.getConn();
        
        if(conn != null){
            String sql = TimeKeeping.GET_RECORD_TODAY;
            sql = sql.replace("{YYYYMMDD}", POSCalendar.getYYYYMMDD());
            
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, userid);
                pstmt.setString(2, Constant.RECORD_TYPE_JOB);
                rs = pstmt.executeQuery();
                if(rs.next()){
                    id = rs.getInt(TimeKeeping.ID);
                }
                
                rs.close();
                pstmt.close();
                conn.close();
                
                return id;
            } catch (SQLException ex) {
                Logger.getLogger(ClockerManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return id;
    } 
    
    
    public int getEntryRecordJob(int userid, String inventorySpace){
        
        int id = 0;
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
            String sql = TimeKeeping.GET_RECORD_TODAY;
            sql = sql.replace("{YYYYMMDD}", POSCalendar.getYYYYMMDD());
            
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, userid);
                pstmt.setString(2, Constant.RECORD_TYPE_JOB);
                rs = pstmt.executeQuery();
                if(rs.next()){
                    id = rs.getInt(TimeKeeping.ID);
                }
                
                rs.close();
                pstmt.close();
                conn.close();
                
                return id;
            } catch (SQLException ex) {
                Logger.getLogger(ClockerManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return id;
    } 
    
    public int getEntryRecordBreak(int userid){
        
        int id = 0;
        conn = dbf.getConn();
        
        if(conn != null){
            String sql = TimeKeeping.GET_RECORD_TODAY;
            sql = sql.replace("{YYYYMMDD}", POSCalendar.getYYYYMMDD());
            
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, userid);
                pstmt.setString(2, Constant.RECORD_TYPE_BREAK);
                rs = pstmt.executeQuery();
                if(rs.next()){
                    id = rs.getInt(TimeKeeping.ID);
                }
                
                rs.close();
                pstmt.close();
                conn.close();
                
                return id;
            } catch (SQLException ex) {
                Logger.getLogger(ClockerManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return id;
    } 
    
    public int getEntryRecordBreak(int userid, String inventorySpace){
        
        int id = 0;
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
            String sql = TimeKeeping.GET_RECORD_TODAY;
            sql = sql.replace("{YYYYMMDD}", POSCalendar.getYYYYMMDD());
            
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, userid);
                pstmt.setString(2, Constant.RECORD_TYPE_BREAK);
                rs = pstmt.executeQuery();
                if(rs.next()){
                    id = rs.getInt(TimeKeeping.ID);
                }
                
                rs.close();
                pstmt.close();
                conn.close();
                
                return id;
            } catch (SQLException ex) {
                Logger.getLogger(ClockerManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return id;
    } 
     
    
}
