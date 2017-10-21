/**
 * PosGW_BindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pos.satlujwe.PosGW;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import javax.jws.WebService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.pos.satlujwe.PosGW.CancelTransactionRequest;
import com.pos.satlujwe.PosGW.CancelTransactionResponse;
import com.pos.satlujwe.PosGW.CheckExistingHeldTRequest;
import com.pos.satlujwe.PosGW.CheckExistingHeldTResponse;
import com.pos.satlujwe.PosGW.CheckHeldTRequest;
import com.pos.satlujwe.PosGW.CheckHeldTResponse;
import com.pos.satlujwe.PosGW.CheckUserRequest;
import com.pos.satlujwe.PosGW.CheckUserResponse;
import com.pos.satlujwe.PosGW.ClosePendingTRequest;
import com.pos.satlujwe.PosGW.ClosePendingTResponse;
import com.pos.satlujwe.PosGW.CreateTKRequest;
import com.pos.satlujwe.PosGW.CreateTKResponse;
import com.pos.satlujwe.PosGW.GetEntryRBRequest;
import com.pos.satlujwe.PosGW.GetEntryRBResponse;
import com.pos.satlujwe.PosGW.GetEntryRJRequest;
import com.pos.satlujwe.PosGW.GetEntryRJResponse;
import com.pos.satlujwe.PosGW.GetHeldItemsRequest;
import com.pos.satlujwe.PosGW.GetHeldTRequest;
import com.pos.satlujwe.PosGW.GetInventoryRequest;
import com.pos.satlujwe.PosGW.InsertBRRequest;
import com.pos.satlujwe.PosGW.InsertBRResponse;
import com.pos.satlujwe.PosGW.InsertHeldItemRequest;
import com.pos.satlujwe.PosGW.InsertHeldItemResponse;
import com.pos.satlujwe.PosGW.InsertHeldTRequest;
import com.pos.satlujwe.PosGW.InsertHeldTResponse;
import com.pos.satlujwe.PosGW.InsertSoldRequest;
import com.pos.satlujwe.PosGW.InsertSoldResponse;
import com.pos.satlujwe.PosGW.InsertTRRequest;
import com.pos.satlujwe.PosGW.InsertTRResponse;
import com.pos.satlujwe.PosGW.MakeSaleRequest;
import com.pos.satlujwe.PosGW.MakeSaleResponse;
import com.pos.satlujwe.PosGW.OpenCancelledTRequest;
import com.pos.satlujwe.PosGW.OpenCancelledTResponse;
import com.pos.satlujwe.PosGW.PosGWHoldItem;
import com.pos.satlujwe.PosGW.PosGWHoldTransaction;
import com.pos.satlujwe.PosGW.PosGWProduct;
import com.pos.satlujwe.PosGW.PosGW_PortType;
import com.pos.satlujwe.PosGW.SearchInventoryRequest;
import com.pos.satlujwe.PosGW.SearchInventoryResponse;
import com.pos.satlujwe.PosGW.UpdateBRRequest;
import com.pos.satlujwe.PosGW.UpdateBRResponse;
import com.pos.satlujwe.PosGW.UpdateInventoryRequest;
import com.pos.satlujwe.PosGW.UpdateInventoryResponse;
import com.pos.satlujwe.PosGW.UpdateTRRequest;
import com.pos.satlujwe.PosGW.UpdateTRResponse;

import db.ClockerManager;
import db.DBFactory;
import db.InventoryManager;
import db.TransactionManager;
import db.UserValidation;
import objects.CartItem;
import objects.HeldItems;
import objects.HoldTransaction;
import objects.Product;
import objects.SoldItem;
import objects.Transaction;
import objects.User;
import utils.POSCalendar;

//@WebService(serviceName = "PosGW_Port", portName = "PosGW_Port", endpointInterface = "com.pos.satlujwe.PosGW.PosGW_PortType",
//targetNamespace = "http://satlujwe.pos.com/PosGW", wsdlLocation = "WEB-INF/wsdl/PosGW_Port.wsdl")

public class PosGW_BindingImpl implements com.pos.satlujwe.PosGW.PosGW_PortType{
	
	private static final Log log = LogFactory.getLog(PosGW_BindingImpl.class);
	
    public com.pos.satlujwe.PosGW.CreateTKResponse TK_Create(com.pos.satlujwe.PosGW.CreateTKRequest parameters) throws java.rmi.RemoteException {
    	
    	ClockerManager clocker = new ClockerManager();
    	CreateTKResponse ctrkresponse = new CreateTKResponse();
    	log.debug("before TimeKeeping");
    	ctrkresponse.setIsSuccess(clocker.createNewTimeKeeping(parameters.getInventorySpace()));
    	log.debug("After TimeKeeping");
    	return ctrkresponse;
    }

    public com.pos.satlujwe.PosGW.InsertTRResponse TK_InsertTR(com.pos.satlujwe.PosGW.InsertTRRequest parameters) throws java.rmi.RemoteException {
    	ClockerManager clocker = new ClockerManager();
    	InsertTRResponse itrresponse = new InsertTRResponse();
    	User user = new User();
    	user.setUserid(parameters.getCurrentUser().getUserID());
    	user.setFirstname(parameters.getCurrentUser().getFirstName());
    	user.setLastname(parameters.getCurrentUser().getLastName());
    	user.setUsername(parameters.getCurrentUser().getUsername());
    	
    	itrresponse.setIsSuccess(clocker.insertNewTimeRecord(user, parameters.getInventorySpace()));
    	
        return itrresponse;
    }

    public com.pos.satlujwe.PosGW.UpdateTRResponse TK_UpdateTR(com.pos.satlujwe.PosGW.UpdateTRRequest parameters) throws java.rmi.RemoteException {
    	ClockerManager clocker = new ClockerManager();
    	UpdateTRResponse utrresponse = new UpdateTRResponse();
    	utrresponse.setIsSuccess(clocker.updateTimeRecord(parameters.getEntryID(), parameters.getInventorySpace()));
    	
        return utrresponse;
    }

    public com.pos.satlujwe.PosGW.InsertBRResponse TK_InsertBR(com.pos.satlujwe.PosGW.InsertBRRequest parameters) throws java.rmi.RemoteException {
    	ClockerManager clocker = new ClockerManager();
    	InsertBRResponse ibrresponse = new InsertBRResponse();
    	User user = new User();
    	user.setUserid(parameters.getCurrentUser().getUserID());
    	user.setFirstname(parameters.getCurrentUser().getFirstName());
    	user.setLastname(parameters.getCurrentUser().getLastName());
    	user.setUsername(parameters.getCurrentUser().getUsername());
    	ibrresponse.setIsSuccess(clocker.insertNewBreakRecord(user, parameters.getInventorySpace()));
    	
        return ibrresponse;
    }

    public com.pos.satlujwe.PosGW.UpdateBRResponse TK_UpdateBR(com.pos.satlujwe.PosGW.UpdateBRRequest parameters) throws java.rmi.RemoteException {
    	ClockerManager clocker = new ClockerManager();
    	UpdateBRResponse ubrresponse = new UpdateBRResponse();
    	ubrresponse.setIsSuccess(clocker.updateBreakRecord(parameters.getEntryID(), parameters.getInventorySpace()));
    	
        return ubrresponse;
    }

    public com.pos.satlujwe.PosGW.GetEntryRJResponse TK_GetRJEntry(com.pos.satlujwe.PosGW.GetEntryRJRequest parameters) throws java.rmi.RemoteException {
    	ClockerManager clocker = new ClockerManager();
    	GetEntryRJResponse gerjresponse = new GetEntryRJResponse();
    	gerjresponse.setEntryID(clocker.getEntryRecordJob(parameters.getUserID(), parameters.getInventorySpace()));
    	
        return gerjresponse;
    }

    public com.pos.satlujwe.PosGW.GetEntryRBResponse TK_GetEntryRB(com.pos.satlujwe.PosGW.GetEntryRBRequest parameters) throws java.rmi.RemoteException {
    	ClockerManager clocker = new ClockerManager();
    	GetEntryRBResponse gerbresponse = new GetEntryRBResponse();
    	gerbresponse.setEntryID(clocker.getEntryRecordBreak(parameters.getUserID(), parameters.getInventorySpace()));
    	
        return gerbresponse;
    }

    public com.pos.satlujwe.PosGW.PosGWProduct[] getInventory(com.pos.satlujwe.PosGW.GetInventoryRequest parameters) throws java.rmi.RemoteException {
    	InventoryManager inventory = new InventoryManager();
    	ArrayList<Product> inv = inventory.getInventory(parameters.getInventorySpace());
    	System.out.println("Before conversion");
    	PosGWProduct[] inventorylist = new PosGWProduct[inv.size()];
    	
    	for(int i = 0; i < inv.size(); i++){
    		//System.out.println("Iteration");
    		inventorylist[i] = new PosGWProduct();
    		inventorylist[i].setAisle(inv.get(i).getAISLE());
    		//System.out.println("After Aisle");
    		inventorylist[i].setCoupon(inv.get(i).getCOUPON());
    		//System.out.println("After Coupon");
    		inventorylist[i].setCreatedAt(inv.get(i).getCREATED_AT().toString());
    		//System.out.println("After Created At");
    		inventorylist[i].setID(inv.get(i).getID());
    		//System.out.println("After ID");
    		inventorylist[i].setItemCode(inv.get(i).getITEM_CODE());
    		//System.out.println("After Item Code");
    		inventorylist[i].setPerishable(inv.get(i).getPERISHABLE());
    		//System.out.println("After Perishable");
    		inventorylist[i].setProductIMG(inv.get(i).getPRODUCT_IMG());
    		//System.out.println("After product image");
    		inventorylist[i].setProductName(inv.get(i).getPRODUCT_NAME());
    		//System.out.println("After product name");
    		inventorylist[i].setPurchasePrice(BigDecimal.valueOf(inv.get(i).getPURCHASE_PRICE()));
    		//System.out.println("After purchase price");
    		inventorylist[i].setQtyOnFloor(inv.get(i).getQUANTITY_ON_FLOOR());
    		//System.out.println("After Qty on flr");
    		inventorylist[i].setQtyOffFloor(inv.get(i).getQUANTITY_OFF_FLOOR());
    		//System.out.println("After Qty Off Flr");
    		inventorylist[i].setRemarks(inv.get(i).getREMARKS());
    		//System.out.println("After Remarts");
    		inventorylist[i].setRetailPrice(BigDecimal.valueOf(inv.get(i).getRETAIL_PRICE()));
    		//System.out.println("After retail price");
    		inventorylist[i].setShelfLifeOffFloor(inv.get(i).getSHELF_LIFE_OFF_FLOOR());
    		//System.out.println("After shelf life off flr");
    		inventorylist[i].setShelfLifeOnFloor(inv.get(i).getSHELF_LIFE_ON_FLOOR());
    		//System.out.println("After shelf life on flr");
    		inventorylist[i].setSKU(inv.get(i).getSKU());
    		//System.out.println("After SKU");
    		inventorylist[i].setSubCategory(inv.get(i).getSUB_CATEGORY());
    		//System.out.println("After sub cat");
    		inventorylist[i].setTaxable(inv.get(i).getTAXABLE());
    		//System.out.println("After taxable");
    		inventorylist[i].setUpdatedAt("");
    		//System.out.println("After updated at");
    		inventorylist[i].setVendor(inv.get(i).getVENDOR());
    		//System.out.println("After vendor");
    		//System.out.println(i + " : " + inv.get(i).getPRODUCT_NAME());
    		
    	}
    	
        return inventorylist;
    }

    public com.pos.satlujwe.PosGW.UpdateInventoryResponse updateInventory(com.pos.satlujwe.PosGW.UpdateInventoryRequest parameters) throws java.rmi.RemoteException {
    	InventoryManager inventory = new InventoryManager();
    	UpdateInventoryResponse uiresponse = new UpdateInventoryResponse();
    	uiresponse.setIsSuccess(inventory.updateInventory(parameters.getItemCode(), parameters.getStock().intValue(), parameters.getInventorySpace()));
    	
        return uiresponse;
    }

    public com.pos.satlujwe.PosGW.SearchInventoryResponse searchInventory(com.pos.satlujwe.PosGW.SearchInventoryRequest parameters) throws java.rmi.RemoteException {
    	
    	//SearchInventoryResponse siresponse = new SearchInventoryResponse();
    	//Product prod = inventory.searchInventoryByName("");
    	
        return null;
    }

    public com.pos.satlujwe.PosGW.InsertSoldResponse insertSold(com.pos.satlujwe.PosGW.InsertSoldRequest parameters) throws java.rmi.RemoteException {
    	InventoryManager inventory = new InventoryManager();
    	InsertSoldResponse isresponse = new InsertSoldResponse();
    	
    	SoldItem si = new SoldItem();
    	si.setId(parameters.getItemsSold().getID());
    	si.setInvoiceNum(parameters.getItemsSold().getInvoiceNum());
    	si.setItemCode(parameters.getItemsSold().getItemCode());
    	si.setProdName(parameters.getItemsSold().getProdName());
    	si.setPurchasePrice(parameters.getItemsSold().getPurchasePrice().doubleValue());
    	si.setQty(parameters.getItemsSold().getQty());
    	si.setRemarks(parameters.getItemsSold().getRemarks());
    	si.setSku(parameters.getItemsSold().getSku());
    	//si.setSoldDate(new Date(parameters.getItemsSold().getSoldDate()));
    	
    	isresponse.setIsSuccess(inventory.insertSold(si, parameters.getInventorySpace()));
    	
        return isresponse;
    }

    public com.pos.satlujwe.PosGW.MakeSaleResponse makeSale(com.pos.satlujwe.PosGW.MakeSaleRequest parameters) throws java.rmi.RemoteException {
    	
    	TransactionManager transactions = new TransactionManager();
    	MakeSaleResponse msResponse = new MakeSaleResponse();
    	
    	ArrayList<CartItem> items = new ArrayList<CartItem>();
    	Transaction trans = new Transaction();
    	
    	for (int i = 0; i < parameters.getItems().length; i++){
    		
    		CartItem item = new CartItem();
    		item.setItemCode(parameters.getItems(i).getItemCode());
    		item.setOrderNo(parameters.getItems(i).getOrderNo());
    		item.setQuantity(parameters.getItems(i).getQty());
    		item.setTotalPrice(parameters.getItems(i).getTotalPrice().doubleValue());
    		items.add(item);
    	}
    	
    	trans.setBalance(parameters.getSale().getBalance().doubleValue());
    	trans.setCashier(parameters.getSale().getCashier());
    	trans.setCashTendered(parameters.getSale().getCashTendered().doubleValue());
    	trans.setChange(parameters.getSale().getChange().doubleValue());
    	//trans.setHasBalance(parameters.getSale().get);
    	trans.setId(parameters.getSale().getID());
    	trans.setInvoiceNum(parameters.getSale().getInvoiceNum());
    	trans.setMonth(parameters.getSale().getMonth());
    	trans.setName(parameters.getSale().getName());
    	trans.setSubTotal(parameters.getSale().getSubTotal().doubleValue());
    	//trans.setTimeStamp(new Date(parameters.getSale().getTimeStamp()));
    	trans.setTotalAmount(parameters.getSale().getTotalAmount().doubleValue());
    	trans.setType(parameters.getSale().getType());
    	trans.setVat(parameters.getSale().getVAT());
    	trans.setWasHeld(parameters.getSale().getWasHeld());
    	trans.setYear(parameters.getSale().getYear());
    	
    	msResponse.setIsSuccess(transactions.makeSale(trans, items));
    	
    	
        return msResponse;
    }

    public com.pos.satlujwe.PosGW.CheckHeldTResponse checkHeld(com.pos.satlujwe.PosGW.CheckHeldTRequest parameters) throws java.rmi.RemoteException {
    	
    	TransactionManager transactions = new TransactionManager();
    	CheckHeldTResponse chresponse = new CheckHeldTResponse();
    	chresponse.setIsSuccess(transactions.checkHeldTransactions(parameters.getInventorySpace()));
    	
        return chresponse;
    }

    public com.pos.satlujwe.PosGW.CheckExistingHeldTResponse checkExistingHeld(com.pos.satlujwe.PosGW.CheckExistingHeldTRequest parameters) throws java.rmi.RemoteException {
    	
    	TransactionManager transactions = new TransactionManager();
    	CheckExistingHeldTResponse cehtresponse = new CheckExistingHeldTResponse();
    	cehtresponse.setIsSuccess(transactions.checkifHeldTransactionExisting(parameters.getHeldID(), parameters.getInventorySpace()));
    	
        return cehtresponse;
    }

    public com.pos.satlujwe.PosGW.InsertHeldTResponse insertHeld(com.pos.satlujwe.PosGW.InsertHeldTRequest parameters) throws java.rmi.RemoteException {
    	
    	TransactionManager transactions = new TransactionManager();
    	InsertHeldTResponse ihtresponse = new InsertHeldTResponse();
    	HoldTransaction ht = new HoldTransaction();
    	//ht.setCreatedAt(new Date(parameters.getHeldTrans().getCreatedAt()));
    	ht.setheldID(parameters.getHeldTrans().getHeldID());
    	ht.setId(parameters.getHeldTrans().getID());
    	ht.setInvoice(parameters.getHeldTrans().getInvoiceNum());
    	ht.setLoggedBy(parameters.getHeldTrans().getLoggedby());
    	ht.setStatus(parameters.getHeldTrans().getStatus());
    	ht.setUserid(parameters.getHeldTrans().getUserID());
    	
    	ihtresponse.setIsSuccess(transactions.insertHeldTransaction(ht, parameters.getInventorySpace()));
    	
        return ihtresponse;
    }

    public com.pos.satlujwe.PosGW.PosGWHoldTransaction[] getHeld(com.pos.satlujwe.PosGW.GetHeldTRequest parameters) throws java.rmi.RemoteException {
    	
    	TransactionManager transactions = new TransactionManager();
    	System.out.println("Before get held trans");
    	ArrayList<HoldTransaction> pending = transactions.getHeldTransactions(parameters.getInventorySpace());
    	System.out.println("After get held trans");
    	PosGWHoldTransaction[] held = new PosGWHoldTransaction[pending.size()];
    	for (int i = 0; i < pending.size(); i++){
    		held[i] = new PosGWHoldTransaction();
    		
    		held[i].setCreatedAt(POSCalendar.DatetoString(pending.get(i).getCreatedAt()));
    		System.out.println("Before created at");
    		held[i].setHeldID(pending.get(i).getheldID());
    		System.out.println("Before held id");
    		held[i].setID(pending.get(i).getId());
    		System.out.println("Before id");
    		held[i].setInvoiceNum(pending.get(i).getInvoice());
    		System.out.println("Before invoice num");
    		held[i].setLoggedby(pending.get(i).getLoggedBy());
    		System.out.println("Before logged by");
    		held[i].setSoldAt("");
    		System.out.println("Before sold at");
    		held[i].setStatus(pending.get(i).getStatus());
    		System.out.println("Before status");
    		held[i].setUserID(pending.get(i).getUserid());
    		System.out.println("Before user id");
    		
    	}
    	
        return held;
    }

    public com.pos.satlujwe.PosGW.PosGWHoldItem[] getHeldItems(com.pos.satlujwe.PosGW.GetHeldItemsRequest parameters) throws java.rmi.RemoteException {
    	
    	TransactionManager transactions = new TransactionManager();
    	ArrayList<HeldItems> items = transactions.getHeldItems(parameters.getHeldID(), parameters.getInventorySpace());
    	PosGWHoldItem[] helditems = new PosGWHoldItem[items.size()];
    	
    	for (int i = 0; i < items.size(); i++){
    		
    		helditems[i] = new PosGWHoldItem();
    		helditems[i].setCreatedAt(POSCalendar.DatetoString(items.get(i).getCreatedAt()));
    		helditems[i].setHeldID(items.get(i).getHeldID());
    		helditems[i].setItemCode(items.get(i).getItemCode());
    		helditems[i].setQty(items.get(i).getQty());
    		helditems[i].setStatus(items.get(i).getStatus());
    		
    	}
    	
        return helditems;
    }

    public com.pos.satlujwe.PosGW.InsertHeldItemResponse insertHeldItems(com.pos.satlujwe.PosGW.InsertHeldItemRequest parameters) throws java.rmi.RemoteException {
        
    	TransactionManager transactions = new TransactionManager();
    	InsertHeldItemResponse ihiresponse = new InsertHeldItemResponse();
    	HeldItems hi = new HeldItems();
    	//hi.setCreatedAt(new Date(parameters.getHeldItem().getCreatedAt()));
    	hi.setHeldID(parameters.getHeldItem().getHeldID());
    	hi.setItemCode(parameters.getHeldItem().getItemCode());
    	hi.setQty(parameters.getHeldItem().getQty());
    	hi.setStatus(parameters.getHeldItem().getStatus());
    	
    	ihiresponse.setIsSuccess(transactions.insertHeldItem(hi, parameters.getInventorySpace()));
    	
    	return ihiresponse;
    }

    public com.pos.satlujwe.PosGW.CancelTransactionResponse cancelTransaction(com.pos.satlujwe.PosGW.CancelTransactionRequest parameters) throws java.rmi.RemoteException {
    	
    	TransactionManager transactions = new TransactionManager();
    	CancelTransactionResponse ctresponse = new CancelTransactionResponse();
    	ctresponse.setIsSuccess(transactions.cancelTransaction(parameters.getHeldID(), parameters.getInventorySpace()));
    	
        return ctresponse;
    }

    public com.pos.satlujwe.PosGW.OpenCancelledTResponse openCancelled(com.pos.satlujwe.PosGW.OpenCancelledTRequest parameters) throws java.rmi.RemoteException {
    	
    	TransactionManager transactions = new TransactionManager();
    	OpenCancelledTResponse ocresponse = new OpenCancelledTResponse();
    	ocresponse.setIsSuccess(transactions.openCancelledTransaction(parameters.getHeldID(), parameters.getInventorySpace()));
    	
        return ocresponse;
    }

    public com.pos.satlujwe.PosGW.ClosePendingTResponse closePending(com.pos.satlujwe.PosGW.ClosePendingTRequest parameters) throws java.rmi.RemoteException {
    	
    	TransactionManager transactions = new TransactionManager();
    	ClosePendingTResponse cpresponse = new ClosePendingTResponse();
    	cpresponse.setIsSuccess(transactions.closePendingTransaction(parameters.getHeldID(), parameters.getInventorySpace()));
    	
        return cpresponse;
    }

    public com.pos.satlujwe.PosGW.CheckUserResponse userValidation(com.pos.satlujwe.PosGW.CheckUserRequest parameters) throws java.rmi.RemoteException {
    	
    	UserValidation uservalidation = new UserValidation();
    	CheckUserResponse curesponse = new CheckUserResponse();
    	User user = uservalidation.getUserIfExisting(parameters.getUserName(), parameters.getPassword(), parameters.getInventorySpace());
    	if(user != null){
    		PosGWUser puser = new PosGWUser();
    		puser.setActivationKey(user.getActivationKey());
    		puser.setDateCreated(user.getDateCreated());
    		puser.setEmail(user.getEmail());
    		puser.setEmailStatus(user.getEmailStatus());
    		puser.setFirstName(user.getFirstname());
    		puser.setLastName(user.getLastname());
    		puser.setPassword(user.getPassword());
    		puser.setResetKey(user.getResetKey());
    		puser.setRole(user.getRole());
    		puser.setUserID(user.getUserid());
    		puser.setUsername(user.getUsername());
    		puser.setUserStatus(user.getUserStat());
    		curesponse.setUser(puser);
    	}
    	
        return curesponse;
    }

}
