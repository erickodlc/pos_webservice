/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import db.tables.Aisles;
import db.tables.Categories;
import db.tables.Products;
import db.tables.SoldProducts;
import db.tables.Vendors;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.pos.satlujwe.PosGW.PosGWProduct;

import objects.Aisle;
import objects.Category;
import objects.Product;
import objects.SoldItem;
import objects.Vendor;

/**
 *
 * @author ETDelacruz
 */
public class InventoryManager {
    
    private DBFactory dbf;
    private Connection conn;
    private ResultSet rs;
    private Statement stmt;
    private PreparedStatement pstmt;
    
    private ArrayList<Product> inventory, searchResult;
    private ArrayList<Aisle> aisles;
    private ArrayList<Category> categories;
    private ArrayList<Vendor> vendors;
    
    private PosGWProduct[] inventorylist;
    
    public InventoryManager(){
        dbf = new DBFactory();
    }
    
    public ArrayList<Aisle> getAisleList(){
        
        aisles = null;
        conn = dbf.getConn();
        
        if(conn != null){
            aisles = new ArrayList();
            
            try {
                stmt = conn.createStatement();
            
                rs = stmt.executeQuery(Aisles.GET_ALL_AISLES);
               
                while(rs.next()){
                    Aisle aisle = new Aisle();
                    aisle.setAisleid(rs.getInt(Aisles.AISLEID));
                    aisle.setAisleName(rs.getString(Aisles.AISLENAME));
                    aisle.setCreatedAt(rs.getDate(Aisles.CREATEDAT));
                    aisle.setUpdateAt(rs.getDate(Aisles.UPDATEDAT));
                    aisles.add(aisle);
                }
                
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(InventoryManager.class.getName() +" : "+ex.toString());
            }
            return aisles;
        }
        return null;
    }
    
   public ArrayList<Vendor> getVendorList(){
        
        vendors = null;
        conn = dbf.getConn();
        
        if(conn != null){
            vendors = new ArrayList();
            
            try {
                stmt = conn.createStatement();
            
                rs = stmt.executeQuery(Vendors.GET_ALL_VENDORS);
                while(rs.next()){
                    Vendor vendor = new Vendor();
                    vendor.setVendorId(rs.getInt(Vendors.VENDORID));
                    vendor.setVendorName(rs.getString(Vendors.VENDORNAME));
                    vendor.setCreatedAt(rs.getDate(Vendors.CREATEDAT));
                    vendor.setUpdateAt(rs.getDate(Vendors.UPDATEDAT));
                    vendors.add(vendor);
                }
                
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(InventoryManager.class.getName() +" : "+ex.toString());
            }
            return vendors;
        }
        return null;
    }
        
  public ArrayList<Category> getCategories(){
        
        categories = null;
        conn = dbf.getConn();
        
        if(conn != null){
            categories = new ArrayList();
            
            try {
                stmt = conn.createStatement();
            
                rs = stmt.executeQuery(Categories.GET_ALL_CATEGORIES);
                while(rs.next()){
                    Category category = new Category();
                    category.setAisleId(rs.getInt(Categories.AISLEID));
                    category.setCategoryId(rs.getInt(Categories.CATID));
                    category.setCategoryName(rs.getString(Categories.CATNAME));
                    category.setCreatedAt(rs.getDate(Categories.CREATEDAT));
                    category.setUpdateAt(rs.getDate(Categories.UPDATEDAT));
                    categories.add(category);
                }
                
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(InventoryManager.class.getName() +" : "+ex.toString());
            }
            return categories;
        }
        return null;
    }
    
    public ArrayList<Product> getInventory(){
        
        inventory = null;
        conn = dbf.getConn();
        
        if(conn != null){
            inventory = new ArrayList<Product>();
            
            try {
                stmt = conn.createStatement();
            
                rs = stmt.executeQuery(Products.ALL_PRODUCTS);
                while(rs.next()){
                    Product prod = new Product();
                    prod.setID(rs.getInt(Products.ID));
                    prod.setPRODUCT_NAME(rs.getString(Products.PRODUCT_NAME));
                    prod.setPRODUCT_IMG(rs.getString(Products.PRODUCT_IMG));
                    prod.setAISLE(rs.getInt(Products.AISLE));
                    prod.setCOUPON(rs.getString(Products.COUPON));
                    prod.setITEM_CODE(rs.getString(Products.ITEM_CODE));
                    prod.setSKU(rs.getString(Products.SKU));
                    prod.setPERISHABLE(rs.getString(Products.PERISHABLE));
                    prod.setQUANTITY_OFF_FLOOR(rs.getInt(Products.QUANTITY_OFF_FLOOR));
                    prod.setQUANTITY_ON_FLOOR(rs.getInt(Products.QUANTITY_ON_FLOOR));
                    prod.setVENDOR(rs.getInt(Products.VENDOR));
                    prod.setRETAIL_PRICE(rs.getDouble(Products.RETAIL_PRICE));
                    prod.setPURCHASE_PRICE(rs.getDouble(Products.PURCHASE_PRICE));
                    prod.setSUB_CATEGORY(rs.getString(Products.SUB_CATEGORY));
                    prod.setSHELF_LIFE_OFF_FLOOR(rs.getInt(Products.SHELF_LIFE_OFF_FLOOR));
                    prod.setSHELF_LIFE_ON_FLOOR(rs.getInt(Products.SHELF_LIFE_ON_FLOOR));
                    prod.setTAXABLE(rs.getString(Products.TAXABLE));
                    prod.setCREATED_AT(rs.getDate(Products.CREATED_AT));
                    prod.setREMARKS(rs.getString(Products.REMARKS));
                    inventory.add(prod);
                }
                
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(InventoryManager.class.getName() +" : "+ex.toString());
            }
            return inventory;
        }
        
        return null;
    }
    
    public ArrayList<Product> getInventory(String inventorySpace){
        
        inventory = null;
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
            inventory = new ArrayList<Product>();
            
            try {
            	
            	System.out.println("Before Inventory Query");
                stmt = conn.createStatement();
            
                rs = stmt.executeQuery(Products.ALL_PRODUCTS);
                while(rs.next()){
                    Product prod = new Product();
                    prod.setID(rs.getInt(Products.ID));
                    prod.setPRODUCT_NAME(rs.getString(Products.PRODUCT_NAME));
                    prod.setPRODUCT_IMG(rs.getString(Products.PRODUCT_IMG));
                    prod.setAISLE(rs.getInt(Products.AISLE));
                    prod.setCOUPON(rs.getString(Products.COUPON));
                    prod.setITEM_CODE(rs.getString(Products.ITEM_CODE));
                    prod.setSKU(rs.getString(Products.SKU));
                    prod.setPERISHABLE(rs.getString(Products.PERISHABLE));
                    prod.setQUANTITY_OFF_FLOOR(rs.getInt(Products.QUANTITY_OFF_FLOOR));
                    prod.setQUANTITY_ON_FLOOR(rs.getInt(Products.QUANTITY_ON_FLOOR));
                    prod.setVENDOR(rs.getInt(Products.VENDOR));
                    prod.setRETAIL_PRICE(rs.getDouble(Products.RETAIL_PRICE));
                    prod.setPURCHASE_PRICE(rs.getDouble(Products.PURCHASE_PRICE));
                    prod.setSUB_CATEGORY(rs.getString(Products.SUB_CATEGORY));
                    prod.setSHELF_LIFE_OFF_FLOOR(rs.getInt(Products.SHELF_LIFE_OFF_FLOOR));
                    prod.setSHELF_LIFE_ON_FLOOR(rs.getInt(Products.SHELF_LIFE_ON_FLOOR));
                    prod.setTAXABLE(rs.getString(Products.TAXABLE));
                    prod.setCREATED_AT(rs.getDate(Products.CREATED_AT));
                    prod.setREMARKS(rs.getString(Products.REMARKS));
                    inventory.add(prod);
                }
                
                System.out.println("After Inventory Query");
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(InventoryManager.class.getName() +" : "+ex.toString());
            }
            return inventory;
        }
        
        return null;
    }
    
    
    public boolean updateInventory(String itemCode, double stock){
    
        conn = dbf.getConn();
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(Products.UPDATE_PRODUCT_STOCK);
                pstmt.setDouble(1, stock);
                pstmt.setString(2, itemCode);
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(InventoryManager.class.getName() +" : "+ex.toString());
            }
        
        }
        
        return false;
    }
    
    public boolean updateInventory(String itemCode, double stock, String inventorySpace){
        
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(Products.UPDATE_PRODUCT_STOCK);
                pstmt.setDouble(1, stock);
                pstmt.setString(2, itemCode);
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(InventoryManager.class.getName() +" : "+ex.toString());
            }
        
        }
        
        return false;
    }
    
    
    
    public ArrayList<Product> searchInventoryByName(String searchString){
        
        searchResult = null;
        conn = dbf.getConn();
        String query = null;
        
        /*
        switch(caseNum){
            case 1: query = Products.SEARCH_PRODUCT_BY_AISLE; break;
            case 2: query = Products.SEARCH_PRODUCT_BY_CATEGORY; break;
            case 3: query = Products.SEARCH_PRODUCT_BY_VENDOR; break;
            case 4: query = Products.SEARCH_PRODUCT_BY_NAME; break;
            case 5: query = Products.SEARCH_PRODUCT_BY_NAME_AISLE; break;
            case 6: query = Products.SEARCH_PRODUCT_BY_NAME_CAT; break;
            case 7: query = Products.SEARCH_PRODUCT_BY_NAME_VENDOR; break;
            case 8: query = Products.SEARCH_PRODUCT_BY_AISLE_CAT; break;
            case 9: query = Products.SEARCH_PRODUCT_BY_AISLE_VENDOR; break;
            case 10: query = Products.SEARCH_PRODUCT_BY_CAT_VENDOR; break;
            case 11: query = Products.SEARCH_PRODUCT_BY_AISLE_CAT_VENDOR; break;
            case 12: query = Products.SEARCH_PRODUCT_BY_NAME_VENDOR_AISLE; break;
            case 13: query = Products.SEARCH_PRODUCT_BY_NAME_CAT_AISLE; break;
            case 14: query = Products.SEARCH_PRODUCT_BY_NAME_VENDOR_CAT; break;
            case 15: query = Products.SEARCH_PRODUCT_BY_NAME_VENDOR_AISLE_CAT; break;
            default: query = Products.ALL_PRODUCTS; break;
        }
        */
        
        if(conn != null){
            searchResult = new ArrayList();
            
            try {
                pstmt = conn.prepareStatement(Products.SEARCH_PRODUCT_BY_NAME);
                pstmt.setString(1, "%"+searchString+"%");
                /*searchString = searchString
                .replace("!", "!!")
                .replace("%", "!%")
                .replace("_", "!_")
                .replace("[", "![");
                pstmt.setString(1, "%" +searchString+ "%");*/
                
                
                rs = pstmt.executeQuery();
                while(rs.next()){
                    Product prod = new Product();
                    prod.setID(rs.getInt(Products.ID));
                    prod.setPRODUCT_NAME(rs.getString(Products.PRODUCT_NAME));
                    prod.setPRODUCT_IMG(rs.getString(Products.PRODUCT_IMG));
                    prod.setAISLE(rs.getInt(Products.AISLE));
                    prod.setCOUPON(rs.getString(Products.COUPON));
                    prod.setITEM_CODE(rs.getString(Products.ITEM_CODE));
                    prod.setSKU(rs.getString(Products.SKU));
                    prod.setPERISHABLE(rs.getString(Products.PERISHABLE));
                    prod.setQUANTITY_OFF_FLOOR(rs.getInt(Products.QUANTITY_OFF_FLOOR));
                    prod.setQUANTITY_ON_FLOOR(rs.getInt(Products.QUANTITY_ON_FLOOR));
                    prod.setVENDOR(rs.getInt(Products.VENDOR));
                    prod.setRETAIL_PRICE(rs.getDouble(Products.RETAIL_PRICE));
                    prod.setPURCHASE_PRICE(rs.getDouble(Products.PURCHASE_PRICE));
                    prod.setSUB_CATEGORY(rs.getString(Products.SUB_CATEGORY));
                    prod.setSHELF_LIFE_OFF_FLOOR(rs.getInt(Products.SHELF_LIFE_OFF_FLOOR));
                    prod.setSHELF_LIFE_ON_FLOOR(rs.getInt(Products.SHELF_LIFE_ON_FLOOR));
                    prod.setTAXABLE(rs.getString(Products.TAXABLE));
                    prod.setCREATED_AT(rs.getDate(Products.CREATED_AT));
                    prod.setREMARKS(rs.getString(Products.REMARKS));
                    searchResult.add(prod);
                }
                
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(InventoryManager.class.getName() +" : "+ex.toString());
            }
            return searchResult;
        }
        
        return null;
    }
    
    public boolean insertSold(SoldItem si){
    
        conn = dbf.getConn();
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(SoldProducts.INSERT_SOLD_LOG);
                pstmt.setInt(1, si.getId());
                pstmt.setString(2, si.getInvoiceNum());
                pstmt.setString(3, si.getProdName());
                pstmt.setString(4, si.getItemCode());
                pstmt.setString(5, si.getSku());
                pstmt.setDouble(6, si.getPurchasePrice());
                pstmt.setInt(7, si.getQty());
                pstmt.setString(8, si.getRemarks());
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(InventoryManager.class.getName() +" : "+ex.toString());
            }
        
        }
        
        return false;
    }
    
    public boolean insertSold(SoldItem si, String inventorySpace){
        
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(SoldProducts.INSERT_SOLD_LOG);
                pstmt.setInt(1, si.getId());
                pstmt.setString(2, si.getInvoiceNum());
                pstmt.setString(3, si.getProdName());
                pstmt.setString(4, si.getItemCode());
                pstmt.setString(5, si.getSku());
                pstmt.setDouble(6, si.getPurchasePrice());
                pstmt.setInt(7, si.getQty());
                pstmt.setString(8, si.getRemarks());
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(InventoryManager.class.getName() +" : "+ex.toString());
            }
        
        }
        
        return false;
    }
    
}
