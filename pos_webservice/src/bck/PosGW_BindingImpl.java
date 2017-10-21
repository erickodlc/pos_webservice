/**
 * PosGW_BindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package bck;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

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

public class PosGW_BindingImpl implements com.pos.satlujwe.PosGW.PosGW_PortType{
	
	ClockerManager clocker = new ClockerManager();
	InventoryManager inventory = new InventoryManager();
	TransactionManager transactions = new TransactionManager();
	UserValidation uservalidation = new UserValidation();
	
    public com.pos.satlujwe.PosGW.CreateTKResponse TK_Create(com.pos.satlujwe.PosGW.CreateTKRequest parameters) throws java.rmi.RemoteException {
    	CreateTKResponse ctrkresponse = new CreateTKResponse();
    	ctrkresponse.setIsSuccess(clocker.createNewTimeKeeping(parameters.getInventorySpace()));
    	
    	return ctrkresponse;
    }

    public com.pos.satlujwe.PosGW.InsertTRResponse TK_InsertTR(com.pos.satlujwe.PosGW.InsertTRRequest parameters) throws java.rmi.RemoteException {
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
    	UpdateTRResponse utrresponse = new UpdateTRResponse();
    	utrresponse.setIsSuccess(clocker.updateTimeRecord(parameters.getEntryID(), parameters.getInventorySpace()));
    	
        return utrresponse;
    }

    public com.pos.satlujwe.PosGW.InsertBRResponse TK_InsertBR(com.pos.satlujwe.PosGW.InsertBRRequest parameters) throws java.rmi.RemoteException {
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
    	UpdateBRResponse ubrresponse = new UpdateBRResponse();
    	ubrresponse.setIsSuccess(clocker.updateBreakRecord(parameters.getEntryID(), parameters.getInventorySpace()));
    	
        return ubrresponse;
    }

    public com.pos.satlujwe.PosGW.GetEntryRJResponse TK_GetRJEntry(com.pos.satlujwe.PosGW.GetEntryRJRequest parameters) throws java.rmi.RemoteException {
    	GetEntryRJResponse gerjresponse = new GetEntryRJResponse();
    	gerjresponse.setEntryID(clocker.getEntryRecordJob(parameters.getUserID(), parameters.getInventorySpace()));
    	
        return gerjresponse;
    }

    public com.pos.satlujwe.PosGW.GetEntryRBResponse TK_GetEntryRB(com.pos.satlujwe.PosGW.GetEntryRBRequest parameters) throws java.rmi.RemoteException {
    	GetEntryRBResponse gerbresponse = new GetEntryRBResponse();
    	gerbresponse.setEntryID(clocker.getEntryRecordBreak(parameters.getUserID(), parameters.getInventorySpace()));
    	
        return gerbresponse;
    }

    public com.pos.satlujwe.PosGW.PosGWProduct[] getInventory(com.pos.satlujwe.PosGW.GetInventoryRequest parameters) throws java.rmi.RemoteException {
    	
    	ArrayList<Product> inv = inventory.getInventory(parameters.getInventorySpace());
    	PosGWProduct[] inventorylist = new PosGWProduct[inv.size()];
    	
    	for(int i = 0; i < inv.size(); i++){
    		inventorylist[i] = new PosGWProduct();
    		inventorylist[i].setAisle(inv.get(i).getAISLE());
    		inventorylist[i].setCoupon(inv.get(i).getCOUPON());
    		inventorylist[i].setCreatedAt(inv.get(i).getCREATED_AT().toString());
    		inventorylist[i].setID(inv.get(i).getID());
    		inventorylist[i].setItemCode(inv.get(i).getITEM_CODE());
    		inventorylist[i].setPerishable(inv.get(i).getPERISHABLE());
    		inventorylist[i].setProductIMG(inv.get(i).getPRODUCT_IMG());
    		inventorylist[i].setProductName(inv.get(i).getPRODUCT_NAME());
    		inventorylist[i].setPurchasePrice(BigDecimal.valueOf(inv.get(i).getPURCHASE_PRICE()));
    		inventorylist[i].setQtyOnFloor(inv.get(i).getQUANTITY_ON_FLOOR());
    		inventorylist[i].setQtyOffFloor(inv.get(i).getQUANTITY_OFF_FLOOR());
    		inventorylist[i].setRemarks(inv.get(i).getREMARKS());
    		inventorylist[i].setRetailPrice(BigDecimal.valueOf(inv.get(i).getRETAIL_PRICE()));
    		inventorylist[i].setShelfLifeOffFloor(inv.get(i).getSHELF_LIFE_OFF_FLOOR());
    		inventorylist[i].setShelfLifeOnFloor(inv.get(i).getSHELF_LIFE_ON_FLOOR());
    		inventorylist[i].setSKU(inv.get(i).getSKU());
    		inventorylist[i].setSubCategory(inv.get(i).getSUB_CATEGORY());
    		inventorylist[i].setTaxable(inv.get(i).getTAXABLE());
    		inventorylist[i].setUpdatedAt(inv.get(i).getUPDATED_AT().toString());
    		inventorylist[i].setVendor(inv.get(i).getVENDOR());
    	}
    	
        return inventorylist;
    }

    public com.pos.satlujwe.PosGW.UpdateInventoryResponse updateInventory(com.pos.satlujwe.PosGW.UpdateInventoryRequest parameters) throws java.rmi.RemoteException {
    	
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
    	si.setSoldDate(new Date(parameters.getItemsSold().getSoldDate()));
    	
    	isresponse.setIsSuccess(inventory.insertSold(si, parameters.getInventorySpace()));
    	
        return isresponse;
    }

    public com.pos.satlujwe.PosGW.MakeSaleResponse makeSale(com.pos.satlujwe.PosGW.MakeSaleRequest parameters) throws java.rmi.RemoteException {
    	
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
    	trans.setTimeStamp(new Date(parameters.getSale().getTimeStamp()));
    	trans.setTotalAmount(parameters.getSale().getTotalAmount().doubleValue());
    	trans.setType(parameters.getSale().getType());
    	trans.setVat(parameters.getSale().getVAT());
    	trans.setWasHeld(parameters.getSale().getWasHeld());
    	trans.setYear(parameters.getSale().getYear());
    	
    	msResponse.setIsSuccess(transactions.makeSale(trans, items));
    	
    	
        return msResponse;
    }

    public com.pos.satlujwe.PosGW.CheckHeldTResponse checkHeld(com.pos.satlujwe.PosGW.CheckHeldTRequest parameters) throws java.rmi.RemoteException {
    	
    	CheckHeldTResponse chresponse = new CheckHeldTResponse();
    	chresponse.setIsSuccess(transactions.checkHeldTransactions(parameters.getInventorySpace()));
    	
        return chresponse;
    }

    public com.pos.satlujwe.PosGW.CheckExistingHeldTResponse checkExistingHeld(com.pos.satlujwe.PosGW.CheckExistingHeldTRequest parameters) throws java.rmi.RemoteException {
    	
    	CheckExistingHeldTResponse cehtresponse = new CheckExistingHeldTResponse();
    	cehtresponse.setIsSuccess(transactions.checkifHeldTransactionExisting(parameters.getHeldID(), parameters.getInventorySpace()));
    	
        return cehtresponse;
    }

    public com.pos.satlujwe.PosGW.InsertHeldTResponse insertHeld(com.pos.satlujwe.PosGW.InsertHeldTRequest parameters) throws java.rmi.RemoteException {
    	
    	InsertHeldTResponse ihtresponse = new InsertHeldTResponse();
    	HoldTransaction ht = new HoldTransaction();
    	ht.setCreatedAt(new Date(parameters.getHeldTrans().getCreatedAt()));
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
    	
    	
    	ArrayList<HoldTransaction> pending = transactions.getHeldTransactions(parameters.getInventorySpace());
    	PosGWHoldTransaction[] held = new PosGWHoldTransaction[pending.size()];
    	for (int i = 0; i < pending.size(); i++){
    		held[i] = new PosGWHoldTransaction();
    		
    		held[i].setCreatedAt(pending.get(i).getCreatedAt().toString());
    		held[i].setHeldID(pending.get(i).getheldID());
    		held[i].setID(pending.get(i).getId());
    		held[i].setInvoiceNum(pending.get(i).getInvoice());
    		held[i].setLoggedby(pending.get(i).getLoggedBy());
    		held[i].setSoldAt(pending.get(i).getClosedAt().toString());
    		held[i].setStatus(pending.get(i).getStatus());
    		held[i].setUserID(pending.get(i).getUserid());
    		
    	}
    	
        return held;
    }

    public com.pos.satlujwe.PosGW.PosGWHoldItem[] getHeldItems(com.pos.satlujwe.PosGW.GetHeldItemsRequest parameters) throws java.rmi.RemoteException {
    	
    	ArrayList<HeldItems> items = new ArrayList<HeldItems>();
    	PosGWHoldItem[] helditems = new PosGWHoldItem[items.size()];
    	
    	for (int i = 0; i < items.size(); i++){
    		
    		helditems[i] = new PosGWHoldItem();
    		helditems[i].setHeldID(items.get(i).getHeldID());
    		
    	}
    	
        return null;
    }

    public com.pos.satlujwe.PosGW.InsertHeldItemResponse insertHeldItems(com.pos.satlujwe.PosGW.InsertHeldItemRequest parameters) throws java.rmi.RemoteException {
        return null;
    }

    public com.pos.satlujwe.PosGW.CancelTransactionResponse cancelTransaction(com.pos.satlujwe.PosGW.CancelTransactionRequest parameters) throws java.rmi.RemoteException {
        return null;
    }

    public com.pos.satlujwe.PosGW.OpenCancelledTResponse openCancelled(com.pos.satlujwe.PosGW.OpenCancelledTRequest parameters) throws java.rmi.RemoteException {
        return null;
    }

    public com.pos.satlujwe.PosGW.ClosePendingTResponse closePending(com.pos.satlujwe.PosGW.ClosePendingTRequest parameters) throws java.rmi.RemoteException {
        return null;
    }

    public com.pos.satlujwe.PosGW.CheckUserResponse userValidation(com.pos.satlujwe.PosGW.CheckUserRequest parameters) throws java.rmi.RemoteException {
        return null;
    }

}
