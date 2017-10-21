/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import db.tables.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import objects.User;
import utils.Password;


/**
 *
 * @author ETDelacruz
 */
public class UserValidation {
    
    private DBFactory dbf;
    private Connection conn;
    private ResultSet rs;
    private Statement stmt;
    private PreparedStatement pstmt;
    
    
    public UserValidation(){
        dbf = new DBFactory();
    }
    
    public boolean checkIfUserExisting(String user, String password){
    
        conn = dbf.getConn();
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(Users.GET_USER_DETAILS);
                pstmt.setString(1, user);
                pstmt.setString(2, Password.getEncryptedPw(password));
                rs = pstmt.executeQuery();
                
                if(rs.next()){
                    User account = new User();
                    account.setUserid(rs.getInt(Users.ID));
                    account.setFirstname(rs.getString(Users.FIRSTNAME));
                    account.setLastname(rs.getString(Users.LASTNAME));
                    account.setUsername(rs.getString(Users.USERNAME));
                    account.setPassword(rs.getString(Users.PASSWORD));
                    account.setEmail(rs.getString(Users.EMAIL));
                    account.setRole(rs.getString(Users.ROLE));
                    account.setActivationKey(rs.getString(Users.ACT_KEY));
                    account.setResetKey(rs.getString(Users.RESET_KEY));
                    account.setEmailStatus(rs.getString(Users.EMAIL_STATUS));
                    account.setUserStat(rs.getString(Users.USER_STATUS));
                    account.setDateCreated(rs.getString(Users.DATE_CREATED));
                    //Main.lcontrol.setCurrentUser(account);
                    pstmt.close();
                    conn.close();
                    
                    return true;
                }
                
            } catch (SQLException ex) {
                //Main.control.showErrorMessage(UserValidation.class.getName() +" : "+ex.toString());
            }
        }
        
        return false;
    }
    
    public User getUserIfExisting(String user, String password, String inventorySpace){
        
        conn = dbf.getConn(inventorySpace);
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(Users.GET_USER_DETAILS);
                pstmt.setString(1, user);
                pstmt.setString(2, Password.getEncryptedPw(password));
                rs = pstmt.executeQuery();
                
                if(rs.next()){
                    User account = new User();
                    account.setUserid(rs.getInt(Users.ID));
                    account.setFirstname(rs.getString(Users.FIRSTNAME));
                    account.setLastname(rs.getString(Users.LASTNAME));
                    account.setUsername(rs.getString(Users.USERNAME));
                    account.setPassword(rs.getString(Users.PASSWORD));
                    account.setEmail(rs.getString(Users.EMAIL));
                    account.setRole(rs.getString(Users.ROLE));
                    account.setActivationKey(rs.getString(Users.ACT_KEY));
                    account.setResetKey(rs.getString(Users.RESET_KEY));
                    account.setEmailStatus(rs.getString(Users.EMAIL_STATUS));
                    account.setUserStat(rs.getString(Users.USER_STATUS));
                    account.setDateCreated(rs.getString(Users.DATE_CREATED));
                    //Main.lcontrol.setCurrentUser(account);
                    pstmt.close();
                    conn.close();
                    
                    return account;
                }
                
            } catch (SQLException ex) {
                //Main.control.showErrorMessage(UserValidation.class.getName() +" : "+ex.toString());
            }
        }
        
        return null;
    }
    
}
