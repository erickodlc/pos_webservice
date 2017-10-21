/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;


import config.Constant;
import db.tables.HeldItem;
import db.tables.Hold;
import db.tables.Products;
import db.tables.SoldProducts;
import db.tables.Transactions;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.CartItem;
import objects.HeldItems;
import objects.HoldTransaction;
import objects.Product;
import objects.SoldItem;
import objects.Transaction;

/**
 *
 * @author ETDelacruz
 */
public class TransactionManager {
    
    private DBFactory dbf;
    private Connection conn;
    private ResultSet rs;
    private Statement stmt;
    private PreparedStatement pstmt, insertLog, updateInventory;
    
    private ArrayList<HoldTransaction> pending;
    private ArrayList<HeldItems> pendingItems;
    
    private InventoryManager im;
    
    public TransactionManager(){
    	
        dbf = new DBFactory();
        im = new InventoryManager();
        pending = new ArrayList<HoldTransaction>();
        pendingItems = new ArrayList<HeldItems>();
    }
    
    public boolean makeSale(Transaction t, ArrayList<CartItem> items){
    
        conn = dbf.getConn();
        
        if(conn != null){
            try {
                //System.out.println("Enter try!");
                conn.setAutoCommit(false);
                pstmt = conn.prepareStatement(Transactions.INSERT_TRANS);
                updateInventory = conn.prepareStatement(Products.UPDATE_PRODUCT_STOCK);
                
                
                pstmt.setString(1, t.getInvoiceNum());
                pstmt.setString(2, t.getCashier());
                pstmt.setString(3, t.getName());
                pstmt.setString(4, t.getType());
                pstmt.setString(5, t.getWasHeld());
                pstmt.setDouble(6, t.getTotalAmount());
                pstmt.setDouble(7, t.getChange());
                pstmt.setDouble(8, t.getSubTotal());
                pstmt.setDouble(9, t.getCashTendered());
                pstmt.setString(10, t.getMonth());
                pstmt.setString(11, t.getYear());
                pstmt.setString(12, t.getVat());
                pstmt.setDouble(13, t.getBalance());
                pstmt.executeUpdate(); //insert transaction
                //pstmt.close();

                //System.out.println("Done with trans!");
                
                //pstmt = conn.prepareStatement(SoldProducts.INSERT_SOLD_LOG);    
                int newStock;
                if(!t.isHasBalance()){
                    for (CartItem it: items){
                        for(Product p: im.getInventory()){
                            if(it.getItemCode().equalsIgnoreCase(p.getITEM_CODE())){
                                newStock = p.getQUANTITY_ON_FLOOR() - it.getQuantity();

                                updateInventory.setDouble(1, newStock);
                                updateInventory.setString(2, it.getItemCode());
                                updateInventory.addBatch(); // update inventory
                                //System.out.println("updated inventory!");
                                //System.out.println("before insert sold log!");

                                /*pstmt.setInt(1, p.getID());
                                pstmt.setString(2, t.getInvoiceNum());
                                pstmt.setString(3, p.getPRODUCT_NAME());
                                pstmt.setString(4, p.getITEM_CODE());
                                pstmt.setString(5, p.getSKU());
                                pstmt.setDouble(6, it.getTotalPrice());
                                pstmt.setInt(7, it.getQuantity());
                                pstmt.setString(8, Main.lcontrol.getCurrentUser().getUsername());
                                pstmt.addBatch(); //insert sold product log*/

                                //System.out.println("inserted sold log!");
                                break;
                            }
                        }
                    }
                }
                //System.out.println("before update inventory!");
                updateInventory.executeBatch();
                updateInventory.clearBatch();
                updateInventory.close();
                pstmt.close();

                
                conn.commit(); // save changes
                conn.setAutoCommit(true);

                conn.close();
                return true;
            } catch (SQLException ex) {
                try {
                    conn.rollback();
                    return false;
                } catch (SQLException ex1) {
                    //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex1.getMessage());
                    Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex1);
                }
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    public boolean makeSale(Transaction t, ArrayList<CartItem> items, String inventorySpace){
        
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
            try {
                //System.out.println("Enter try!");
                conn.setAutoCommit(false);
                pstmt = conn.prepareStatement(Transactions.INSERT_TRANS);
                updateInventory = conn.prepareStatement(Products.UPDATE_PRODUCT_STOCK);
                
                
                pstmt.setString(1, t.getInvoiceNum());
                pstmt.setString(2, t.getCashier());
                pstmt.setString(3, t.getName());
                pstmt.setString(4, t.getType());
                pstmt.setString(5, t.getWasHeld());
                pstmt.setDouble(6, t.getTotalAmount());
                pstmt.setDouble(7, t.getChange());
                pstmt.setDouble(8, t.getSubTotal());
                pstmt.setDouble(9, t.getCashTendered());
                pstmt.setString(10, t.getMonth());
                pstmt.setString(11, t.getYear());
                pstmt.setString(12, t.getVat());
                pstmt.setDouble(13, t.getBalance());
                pstmt.executeUpdate(); //insert transaction
                //pstmt.close();

                //System.out.println("Done with trans!");
                
                //pstmt = conn.prepareStatement(SoldProducts.INSERT_SOLD_LOG);    
                int newStock;
                if(!t.isHasBalance()){
                    for (CartItem it: items){
                        for(Product p: im.getInventory()){
                            if(it.getItemCode().equalsIgnoreCase(p.getITEM_CODE())){
                                newStock = p.getQUANTITY_ON_FLOOR() - it.getQuantity();

                                updateInventory.setDouble(1, newStock);
                                updateInventory.setString(2, it.getItemCode());
                                updateInventory.addBatch(); // update inventory
                                //System.out.println("updated inventory!");
                                //System.out.println("before insert sold log!");

                                /*pstmt.setInt(1, p.getID());
                                pstmt.setString(2, t.getInvoiceNum());
                                pstmt.setString(3, p.getPRODUCT_NAME());
                                pstmt.setString(4, p.getITEM_CODE());
                                pstmt.setString(5, p.getSKU());
                                pstmt.setDouble(6, it.getTotalPrice());
                                pstmt.setInt(7, it.getQuantity());
                                pstmt.setString(8, Main.lcontrol.getCurrentUser().getUsername());
                                pstmt.addBatch(); //insert sold product log*/

                                //System.out.println("inserted sold log!");
                                break;
                            }
                        }
                    }
                }
                //System.out.println("before update inventory!");
                updateInventory.executeBatch();
                updateInventory.clearBatch();
                updateInventory.close();
                pstmt.close();

                
                conn.commit(); // save changes
                conn.setAutoCommit(true);

                conn.close();
                return true;
            } catch (SQLException ex) {
                try {
                    conn.rollback();
                    return false;
                } catch (SQLException ex1) {
                    //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex1.getMessage());
                    Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex1);
                }
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    
    
    
    public boolean checkHeldTransactions(){
    
        conn = dbf.getConn();
        
        if(conn != null){
            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(Hold.GET_ALL_HELD_TODAY);
                if(rs.next()){
                    stmt.close();
                    conn.close();
                    return true;
                }
                
                stmt.close();
                conn.close();
                return false;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    public boolean checkHeldTransactions(String inventorySpace){
        
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(Hold.GET_ALL_HELD_TODAY);
                if(rs.next()){
                    stmt.close();
                    conn.close();
                    return true;
                }
                
                stmt.close();
                conn.close();
                return false;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    
    public boolean checkifHeldTransactionExisting(String heldID){
    
        conn = dbf.getConn();
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(Hold.GET_HELD);
                pstmt.setString(1, heldID);
                rs = pstmt.executeQuery();
                if(rs.next()){
                    pstmt.close();
                    conn.close();
                    return true;
                }
                
                
                conn.close();
                return false;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    public boolean checkifHeldTransactionExisting(String heldID, String inventorySpace){
        
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(Hold.GET_HELD);
                pstmt.setString(1, heldID);
                rs = pstmt.executeQuery();
                if(rs.next()){
                    pstmt.close();
                    conn.close();
                    return true;
                }
                
                
                conn.close();
                return false;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    
    public boolean insertHeldTransaction(HoldTransaction hi){
    
        conn = dbf.getConn();
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(Hold.INSERT_HELD);
                pstmt.setString(1, hi.getUserid());
                pstmt.setString(2, hi.getInvoice());
                pstmt.setString(3, hi.getheldID());
                pstmt.setString(4, hi.getLoggedBy());
                pstmt.setString(5, hi.getStatus());
                pstmt.executeUpdate();
                
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    public boolean insertHeldTransaction(HoldTransaction hi, String inventorySpace){
        
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(Hold.INSERT_HELD);
                pstmt.setString(1, hi.getUserid());
                pstmt.setString(2, hi.getInvoice());
                pstmt.setString(3, hi.getheldID());
                pstmt.setString(4, hi.getLoggedBy());
                pstmt.setString(5, hi.getStatus());
                pstmt.executeUpdate();
                
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    public ArrayList<HoldTransaction> getHeldTransactions(){
    
        this.pending.clear();
        
        conn = dbf.getConn();
            
        if(conn != null){
         
            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(Hold.GET_ALL_HELD_TODAY);
                while(rs.next()){
                    HoldTransaction ht = new HoldTransaction();
                    ht.setheldID(rs.getString(Hold.HELDID));
                    ht.setInvoice(rs.getString(Hold.INVOICE));
                    ht.setCreatedAt(rs.getTimestamp(Hold.CREATEDAT));
                    ht.setLoggedBy(rs.getString(Hold.LOGGED));
                    ht.setUserid(rs.getString(Hold.USERID));
                    ht.setStatus(rs.getString(Hold.STATUS));
                    this.pending.add(ht);
                }
                
                stmt.close();
                conn.close();
                return this.pending;
                } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.toString());
            }
                
            
        }
        
        return null;
    }
    
    public ArrayList<HoldTransaction> getHeldTransactions(String inventorySpace){
        
        this.pending.clear();
        
        System.out.println("Before Query");
        conn = dbf.getConn(inventorySpace);
            
        if(conn != null){
         
            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(Hold.GET_ALL_HELD_TODAY);
                while(rs.next()){
                    HoldTransaction ht = new HoldTransaction();
                    ht.setheldID(rs.getString(Hold.HELDID));
                    ht.setInvoice(rs.getString(Hold.INVOICE));
                    ht.setCreatedAt(rs.getTimestamp(Hold.CREATEDAT));
                    ht.setLoggedBy(rs.getString(Hold.LOGGED));
                    ht.setUserid(rs.getString(Hold.USERID));
                    ht.setStatus(rs.getString(Hold.STATUS));
                    this.pending.add(ht);
                }
                
                stmt.close();
                conn.close();
                return this.pending;
                } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.toString());
            }
                
            
        }
        System.out.println("Empty Query");
        
        return null;
    }
    
    
    public ArrayList<HeldItems> getHeldItems(String heldID){
    
        this.pendingItems.clear();
        
        conn = dbf.getConn();
        
        if(conn != null){
         
            try {
                pstmt = conn.prepareStatement(HeldItem.GET_HELD_ITEM);
                pstmt.setString(1, heldID);
                rs = pstmt.executeQuery();
                while(rs.next()){
                    HeldItems hi = new HeldItems();
                    hi.setItemCode(rs.getString(HeldItem.ITEMCODE));
                    hi.setHeldID(rs.getString(HeldItem.HELDID));
                    hi.setQty(rs.getInt(HeldItem.QTY));
                    hi.setStatus(rs.getString(HeldItem.STATUS));
                    
                    this.pendingItems.add(hi);
                }
                pstmt.close();
                conn.close();
                return this.pendingItems;
                } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.toString());
            }
                
            
        }
        
        return null;
    }
    
    
    public ArrayList<HeldItems> getHeldItems(String heldID, String inventorySpace){
        
        this.pendingItems.clear();
        
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
         
            try {
                pstmt = conn.prepareStatement(HeldItem.GET_HELD_ITEM);
                pstmt.setString(1, heldID);
                rs = pstmt.executeQuery();
                while(rs.next()){
                    HeldItems hi = new HeldItems();
                    hi.setItemCode(rs.getString(HeldItem.ITEMCODE));
                    hi.setHeldID(rs.getString(HeldItem.HELDID));
                    hi.setQty(rs.getInt(HeldItem.QTY));
                    hi.setStatus(rs.getString(HeldItem.STATUS));
                    hi.setCreatedAt(rs.getTimestamp(HeldItem.CREATEDAT));
                    
                    this.pendingItems.add(hi);
                }
                pstmt.close();
                conn.close();
                return this.pendingItems;
                } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.toString());
            }
                
            
        }
        
        return null;
    }
    
    
    public boolean insertHeldItem(HeldItems hi){
    
        conn = dbf.getConn();
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(HeldItem.INSERT_HELD_ITEM);
                pstmt.setString(1, hi.getHeldID());
                pstmt.setString(2, hi.getItemCode());
                pstmt.setInt(3, hi.getQty());
                pstmt.setString(4, hi.getStatus());
                pstmt.executeUpdate();
                
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    
    public boolean insertHeldItem(HeldItems hi, String inventorySpace){
        
        conn = dbf.getConn();
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(HeldItem.INSERT_HELD_ITEM);
                pstmt.setString(1, hi.getHeldID());
                pstmt.setString(2, hi.getItemCode());
                pstmt.setInt(3, hi.getQty());
                pstmt.setString(4, hi.getStatus());
                pstmt.executeUpdate();
                
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    public boolean cancelTransaction(String heldID){
    
        conn = dbf.getConn();
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(Hold.CANCEL_HELD);
                pstmt.setString(1, heldID);
                pstmt.executeUpdate();
                
                pstmt = conn.prepareStatement(HeldItem.CANCEL_HELD_ITEM);
                pstmt.setString(1, heldID);
                pstmt.executeUpdate();
                
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    
    public boolean cancelTransaction(String heldID, String inventorySpace){
        
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(Hold.CANCEL_HELD);
                pstmt.setString(1, heldID);
                pstmt.executeUpdate();
                
                pstmt = conn.prepareStatement(HeldItem.CANCEL_HELD_ITEM);
                pstmt.setString(1, heldID);
                pstmt.executeUpdate();
                
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    
    public boolean openCancelledTransaction(String heldID){
    
        conn = dbf.getConn();
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(Hold.SET_TO_PENDING);
                pstmt.setString(1, heldID);
                pstmt.executeUpdate();
                
                pstmt = conn.prepareStatement(HeldItem.SET_TO_PENDING_ITEM);
                pstmt.setString(1, heldID);
                pstmt.executeUpdate();
                
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    public boolean openCancelledTransaction(String heldID, String inventorySpace){
        
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(Hold.SET_TO_PENDING);
                pstmt.setString(1, heldID);
                pstmt.executeUpdate();
                
                pstmt = conn.prepareStatement(HeldItem.SET_TO_PENDING_ITEM);
                pstmt.setString(1, heldID);
                pstmt.executeUpdate();
                
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    public boolean closePendingTransaction(String heldID){
    
        conn = dbf.getConn();
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(Hold.SET_TO_CLOSED);
                pstmt.setString(1, heldID);
                pstmt.executeUpdate();
                
                pstmt = conn.prepareStatement(HeldItem.SET_TO_CLOSED_ITEM);
                pstmt.setString(1, heldID);
                pstmt.executeUpdate();
                
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    public boolean closePendingTransaction(String heldID, String inventorySpace){
        
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(Hold.SET_TO_CLOSED);
                pstmt.setString(1, heldID);
                pstmt.executeUpdate();
                
                pstmt = conn.prepareStatement(HeldItem.SET_TO_CLOSED_ITEM);
                pstmt.setString(1, heldID);
                pstmt.executeUpdate();
                
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
}
