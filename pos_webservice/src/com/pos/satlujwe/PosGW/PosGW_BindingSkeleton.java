/**
 * PosGW_BindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pos.satlujwe.PosGW;

public class PosGW_BindingSkeleton implements com.pos.satlujwe.PosGW.PosGW_PortType, org.apache.axis.wsdl.Skeleton {
    private com.pos.satlujwe.PosGW.PosGW_PortType impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "CreateTKRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">CreateTKRequest"), com.pos.satlujwe.PosGW.CreateTKRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("TK_Create", _params, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "CreateTKResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">CreateTKResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "TK_Create"));
        _oper.setSoapAction("http://www.examples.com/PosGW/TK_Create");
        _myOperationsList.add(_oper);
        if (_myOperations.get("TK_Create") == null) {
            _myOperations.put("TK_Create", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("TK_Create")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "InsertTRRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertTRRequest"), com.pos.satlujwe.PosGW.InsertTRRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("TK_InsertTR", _params, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "InsertTRResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertTRResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "TK_InsertTR"));
        _oper.setSoapAction("http://www.examples.com/PosGW/TK_InsertTR");
        _myOperationsList.add(_oper);
        if (_myOperations.get("TK_InsertTR") == null) {
            _myOperations.put("TK_InsertTR", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("TK_InsertTR")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "UpdateTRRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">UpdateTRRequest"), com.pos.satlujwe.PosGW.UpdateTRRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("TK_UpdateTR", _params, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "UpdateTRResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">UpdateTRResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "TK_UpdateTR"));
        _oper.setSoapAction("http://www.examples.com/PosGW/TK_UpdateTR");
        _myOperationsList.add(_oper);
        if (_myOperations.get("TK_UpdateTR") == null) {
            _myOperations.put("TK_UpdateTR", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("TK_UpdateTR")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "InsertBRRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertBRRequest"), com.pos.satlujwe.PosGW.InsertBRRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("TK_InsertBR", _params, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "InsertBRResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertBRResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "TK_InsertBR"));
        _oper.setSoapAction("http://www.examples.com/PosGW/TK_InsertBR");
        _myOperationsList.add(_oper);
        if (_myOperations.get("TK_InsertBR") == null) {
            _myOperations.put("TK_InsertBR", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("TK_InsertBR")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "UpdateBRRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">UpdateBRRequest"), com.pos.satlujwe.PosGW.UpdateBRRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("TK_UpdateBR", _params, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "UpdateBRResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">UpdateBRResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "TK_UpdateBR"));
        _oper.setSoapAction("http://www.examples.com/PosGW/TK_UpdateBR");
        _myOperationsList.add(_oper);
        if (_myOperations.get("TK_UpdateBR") == null) {
            _myOperations.put("TK_UpdateBR", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("TK_UpdateBR")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "GetEntryRJRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetEntryRJRequest"), com.pos.satlujwe.PosGW.GetEntryRJRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("TK_GetRJEntry", _params, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "GetEntryRJResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetEntryRJResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "TK_GetRJEntry"));
        _oper.setSoapAction("http://www.examples.com/PosGW/TK_GetRJEntry");
        _myOperationsList.add(_oper);
        if (_myOperations.get("TK_GetRJEntry") == null) {
            _myOperations.put("TK_GetRJEntry", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("TK_GetRJEntry")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "GetEntryRBRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetEntryRBRequest"), com.pos.satlujwe.PosGW.GetEntryRBRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("TK_GetEntryRB", _params, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "GetEntryRBResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetEntryRBResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "TK_GetEntryRB"));
        _oper.setSoapAction("http://www.examples.com/PosGW/TK_GetEntryRB");
        _myOperationsList.add(_oper);
        if (_myOperations.get("TK_GetEntryRB") == null) {
            _myOperations.put("TK_GetEntryRB", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("TK_GetEntryRB")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "GetInventoryRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetInventoryRequest"), com.pos.satlujwe.PosGW.GetInventoryRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getInventory", _params, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "GetInventoryResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetInventoryResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "GetInventory"));
        _oper.setSoapAction("http://www.examples.com/PosGW/GetInventory");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getInventory") == null) {
            _myOperations.put("getInventory", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getInventory")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "UpdateInventoryRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">UpdateInventoryRequest"), com.pos.satlujwe.PosGW.UpdateInventoryRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("updateInventory", _params, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "UpdateInventoryResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">UpdateInventoryResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "UpdateInventory"));
        _oper.setSoapAction("http://www.examples.com/PosGW/UpdateInventory");
        _myOperationsList.add(_oper);
        if (_myOperations.get("updateInventory") == null) {
            _myOperations.put("updateInventory", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("updateInventory")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "SearchInventoryRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">SearchInventoryRequest"), com.pos.satlujwe.PosGW.SearchInventoryRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("searchInventory", _params, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "SearchInventoryResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">SearchInventoryResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "SearchInventory"));
        _oper.setSoapAction("http://www.examples.com/PosGW/SearchInventory");
        _myOperationsList.add(_oper);
        if (_myOperations.get("searchInventory") == null) {
            _myOperations.put("searchInventory", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("searchInventory")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "InsertSoldRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertSoldRequest"), com.pos.satlujwe.PosGW.InsertSoldRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("insertSold", _params, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "InsertSoldResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertSoldResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "InsertSold"));
        _oper.setSoapAction("http://www.examples.com/PosGW/InsertSold");
        _myOperationsList.add(_oper);
        if (_myOperations.get("insertSold") == null) {
            _myOperations.put("insertSold", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("insertSold")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "MakeSaleRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">MakeSaleRequest"), com.pos.satlujwe.PosGW.MakeSaleRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("makeSale", _params, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "MakeSaleResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">MakeSaleResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "MakeSale"));
        _oper.setSoapAction("http://www.examples.com/PosGW/MakeSale");
        _myOperationsList.add(_oper);
        if (_myOperations.get("makeSale") == null) {
            _myOperations.put("makeSale", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("makeSale")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "CheckHeldTRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">CheckHeldTRequest"), com.pos.satlujwe.PosGW.CheckHeldTRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("checkHeld", _params, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "CheckHeldTResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">CheckHeldTResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "CheckHeld"));
        _oper.setSoapAction("http://www.examples.com/PosGW/CheckHeld");
        _myOperationsList.add(_oper);
        if (_myOperations.get("checkHeld") == null) {
            _myOperations.put("checkHeld", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("checkHeld")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "CheckExistingHeldTRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">CheckExistingHeldTRequest"), com.pos.satlujwe.PosGW.CheckExistingHeldTRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("checkExistingHeld", _params, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "CheckExistingHeldTResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">CheckExistingHeldTResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "CheckExistingHeld"));
        _oper.setSoapAction("http://www.examples.com/PosGW/CheckExistingHeld");
        _myOperationsList.add(_oper);
        if (_myOperations.get("checkExistingHeld") == null) {
            _myOperations.put("checkExistingHeld", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("checkExistingHeld")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "InsertHeldTRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertHeldTRequest"), com.pos.satlujwe.PosGW.InsertHeldTRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("insertHeld", _params, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "InsertHeldTResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertHeldTResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "InsertHeld"));
        _oper.setSoapAction("http://www.examples.com/PosGW/InsertHeld");
        _myOperationsList.add(_oper);
        if (_myOperations.get("insertHeld") == null) {
            _myOperations.put("insertHeld", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("insertHeld")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "GetHeldTRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetHeldTRequest"), com.pos.satlujwe.PosGW.GetHeldTRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getHeld", _params, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "GetHeldTResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetHeldTResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "GetHeld"));
        _oper.setSoapAction("http://www.examples.com/PosGW/GetHeld");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getHeld") == null) {
            _myOperations.put("getHeld", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getHeld")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "GetHeldItemsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetHeldItemsRequest"), com.pos.satlujwe.PosGW.GetHeldItemsRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getHeldItems", _params, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "GetHeldItemsResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetHeldItemsResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "GetHeldItems"));
        _oper.setSoapAction("http://www.examples.com/PosGW/GetHeldItems");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getHeldItems") == null) {
            _myOperations.put("getHeldItems", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getHeldItems")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "InsertHeldItemRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertHeldItemRequest"), com.pos.satlujwe.PosGW.InsertHeldItemRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("insertHeldItems", _params, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "InsertHeldItemResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertHeldItemResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "InsertHeldItems"));
        _oper.setSoapAction("http://www.examples.com/PosGW/InsertHeldItems");
        _myOperationsList.add(_oper);
        if (_myOperations.get("insertHeldItems") == null) {
            _myOperations.put("insertHeldItems", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("insertHeldItems")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "CancelTransactionRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">CancelTransactionRequest"), com.pos.satlujwe.PosGW.CancelTransactionRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("cancelTransaction", _params, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "CancelTransactionResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">CancelTransactionResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "CancelTransaction"));
        _oper.setSoapAction("http://www.examples.com/PosGW/CancelTransaction");
        _myOperationsList.add(_oper);
        if (_myOperations.get("cancelTransaction") == null) {
            _myOperations.put("cancelTransaction", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("cancelTransaction")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "OpenCancelledTRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">OpenCancelledTRequest"), com.pos.satlujwe.PosGW.OpenCancelledTRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("openCancelled", _params, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "OpenCancelledTResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">OpenCancelledTResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "OpenCancelled"));
        _oper.setSoapAction("http://www.examples.com/PosGW/OpenCancelled");
        _myOperationsList.add(_oper);
        if (_myOperations.get("openCancelled") == null) {
            _myOperations.put("openCancelled", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("openCancelled")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "ClosePendingTRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">ClosePendingTRequest"), com.pos.satlujwe.PosGW.ClosePendingTRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("closePending", _params, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "ClosePendingTResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">ClosePendingTResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "ClosePending"));
        _oper.setSoapAction("http://www.examples.com/PosGW/ClosePending");
        _myOperationsList.add(_oper);
        if (_myOperations.get("closePending") == null) {
            _myOperations.put("closePending", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("closePending")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "CheckUserRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">CheckUserRequest"), com.pos.satlujwe.PosGW.CheckUserRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("userValidation", _params, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "CheckUserResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">CheckUserResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "UserValidation"));
        _oper.setSoapAction("http://www.examples.com/PosGW/UserValidation");
        _myOperationsList.add(_oper);
        if (_myOperations.get("userValidation") == null) {
            _myOperations.put("userValidation", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("userValidation")).add(_oper);
    }

    public PosGW_BindingSkeleton() {
        this.impl = new com.pos.satlujwe.PosGW.PosGW_BindingImpl();
    }

    public PosGW_BindingSkeleton(com.pos.satlujwe.PosGW.PosGW_PortType impl) {
        this.impl = impl;
    }
    public com.pos.satlujwe.PosGW.CreateTKResponse TK_Create(com.pos.satlujwe.PosGW.CreateTKRequest parameters) throws java.rmi.RemoteException
    {
        com.pos.satlujwe.PosGW.CreateTKResponse ret = impl.TK_Create(parameters);
        return ret;
    }

    public com.pos.satlujwe.PosGW.InsertTRResponse TK_InsertTR(com.pos.satlujwe.PosGW.InsertTRRequest parameters) throws java.rmi.RemoteException
    {
        com.pos.satlujwe.PosGW.InsertTRResponse ret = impl.TK_InsertTR(parameters);
        return ret;
    }

    public com.pos.satlujwe.PosGW.UpdateTRResponse TK_UpdateTR(com.pos.satlujwe.PosGW.UpdateTRRequest parameters) throws java.rmi.RemoteException
    {
        com.pos.satlujwe.PosGW.UpdateTRResponse ret = impl.TK_UpdateTR(parameters);
        return ret;
    }

    public com.pos.satlujwe.PosGW.InsertBRResponse TK_InsertBR(com.pos.satlujwe.PosGW.InsertBRRequest parameters) throws java.rmi.RemoteException
    {
        com.pos.satlujwe.PosGW.InsertBRResponse ret = impl.TK_InsertBR(parameters);
        return ret;
    }

    public com.pos.satlujwe.PosGW.UpdateBRResponse TK_UpdateBR(com.pos.satlujwe.PosGW.UpdateBRRequest parameters) throws java.rmi.RemoteException
    {
        com.pos.satlujwe.PosGW.UpdateBRResponse ret = impl.TK_UpdateBR(parameters);
        return ret;
    }

    public com.pos.satlujwe.PosGW.GetEntryRJResponse TK_GetRJEntry(com.pos.satlujwe.PosGW.GetEntryRJRequest parameters) throws java.rmi.RemoteException
    {
        com.pos.satlujwe.PosGW.GetEntryRJResponse ret = impl.TK_GetRJEntry(parameters);
        return ret;
    }

    public com.pos.satlujwe.PosGW.GetEntryRBResponse TK_GetEntryRB(com.pos.satlujwe.PosGW.GetEntryRBRequest parameters) throws java.rmi.RemoteException
    {
        com.pos.satlujwe.PosGW.GetEntryRBResponse ret = impl.TK_GetEntryRB(parameters);
        return ret;
    }

    public com.pos.satlujwe.PosGW.PosGWProduct[] getInventory(com.pos.satlujwe.PosGW.GetInventoryRequest parameters) throws java.rmi.RemoteException
    {
        com.pos.satlujwe.PosGW.PosGWProduct[] ret = impl.getInventory(parameters);
        return ret;
    }

    public com.pos.satlujwe.PosGW.UpdateInventoryResponse updateInventory(com.pos.satlujwe.PosGW.UpdateInventoryRequest parameters) throws java.rmi.RemoteException
    {
        com.pos.satlujwe.PosGW.UpdateInventoryResponse ret = impl.updateInventory(parameters);
        return ret;
    }

    public com.pos.satlujwe.PosGW.SearchInventoryResponse searchInventory(com.pos.satlujwe.PosGW.SearchInventoryRequest parameters) throws java.rmi.RemoteException
    {
        com.pos.satlujwe.PosGW.SearchInventoryResponse ret = impl.searchInventory(parameters);
        return ret;
    }

    public com.pos.satlujwe.PosGW.InsertSoldResponse insertSold(com.pos.satlujwe.PosGW.InsertSoldRequest parameters) throws java.rmi.RemoteException
    {
        com.pos.satlujwe.PosGW.InsertSoldResponse ret = impl.insertSold(parameters);
        return ret;
    }

    public com.pos.satlujwe.PosGW.MakeSaleResponse makeSale(com.pos.satlujwe.PosGW.MakeSaleRequest parameters) throws java.rmi.RemoteException
    {
        com.pos.satlujwe.PosGW.MakeSaleResponse ret = impl.makeSale(parameters);
        return ret;
    }

    public com.pos.satlujwe.PosGW.CheckHeldTResponse checkHeld(com.pos.satlujwe.PosGW.CheckHeldTRequest parameters) throws java.rmi.RemoteException
    {
        com.pos.satlujwe.PosGW.CheckHeldTResponse ret = impl.checkHeld(parameters);
        return ret;
    }

    public com.pos.satlujwe.PosGW.CheckExistingHeldTResponse checkExistingHeld(com.pos.satlujwe.PosGW.CheckExistingHeldTRequest parameters) throws java.rmi.RemoteException
    {
        com.pos.satlujwe.PosGW.CheckExistingHeldTResponse ret = impl.checkExistingHeld(parameters);
        return ret;
    }

    public com.pos.satlujwe.PosGW.InsertHeldTResponse insertHeld(com.pos.satlujwe.PosGW.InsertHeldTRequest parameters) throws java.rmi.RemoteException
    {
        com.pos.satlujwe.PosGW.InsertHeldTResponse ret = impl.insertHeld(parameters);
        return ret;
    }

    public com.pos.satlujwe.PosGW.PosGWHoldTransaction[] getHeld(com.pos.satlujwe.PosGW.GetHeldTRequest parameters) throws java.rmi.RemoteException
    {
        com.pos.satlujwe.PosGW.PosGWHoldTransaction[] ret = impl.getHeld(parameters);
        return ret;
    }

    public com.pos.satlujwe.PosGW.PosGWHoldItem[] getHeldItems(com.pos.satlujwe.PosGW.GetHeldItemsRequest parameters) throws java.rmi.RemoteException
    {
        com.pos.satlujwe.PosGW.PosGWHoldItem[] ret = impl.getHeldItems(parameters);
        return ret;
    }

    public com.pos.satlujwe.PosGW.InsertHeldItemResponse insertHeldItems(com.pos.satlujwe.PosGW.InsertHeldItemRequest parameters) throws java.rmi.RemoteException
    {
        com.pos.satlujwe.PosGW.InsertHeldItemResponse ret = impl.insertHeldItems(parameters);
        return ret;
    }

    public com.pos.satlujwe.PosGW.CancelTransactionResponse cancelTransaction(com.pos.satlujwe.PosGW.CancelTransactionRequest parameters) throws java.rmi.RemoteException
    {
        com.pos.satlujwe.PosGW.CancelTransactionResponse ret = impl.cancelTransaction(parameters);
        return ret;
    }

    public com.pos.satlujwe.PosGW.OpenCancelledTResponse openCancelled(com.pos.satlujwe.PosGW.OpenCancelledTRequest parameters) throws java.rmi.RemoteException
    {
        com.pos.satlujwe.PosGW.OpenCancelledTResponse ret = impl.openCancelled(parameters);
        return ret;
    }

    public com.pos.satlujwe.PosGW.ClosePendingTResponse closePending(com.pos.satlujwe.PosGW.ClosePendingTRequest parameters) throws java.rmi.RemoteException
    {
        com.pos.satlujwe.PosGW.ClosePendingTResponse ret = impl.closePending(parameters);
        return ret;
    }

    public com.pos.satlujwe.PosGW.CheckUserResponse userValidation(com.pos.satlujwe.PosGW.CheckUserRequest parameters) throws java.rmi.RemoteException
    {
        com.pos.satlujwe.PosGW.CheckUserResponse ret = impl.userValidation(parameters);
        return ret;
    }

}
