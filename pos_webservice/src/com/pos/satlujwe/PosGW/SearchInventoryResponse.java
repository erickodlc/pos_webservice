/**
 * SearchInventoryResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pos.satlujwe.PosGW;

public class SearchInventoryResponse  implements java.io.Serializable {
    private java.lang.String inventorySpace;

    private com.pos.satlujwe.PosGW.PosGWProduct productSearched;

    public SearchInventoryResponse() {
    }

    public SearchInventoryResponse(
           java.lang.String inventorySpace,
           com.pos.satlujwe.PosGW.PosGWProduct productSearched) {
           this.inventorySpace = inventorySpace;
           this.productSearched = productSearched;
    }


    /**
     * Gets the inventorySpace value for this SearchInventoryResponse.
     * 
     * @return inventorySpace
     */
    public java.lang.String getInventorySpace() {
        return inventorySpace;
    }


    /**
     * Sets the inventorySpace value for this SearchInventoryResponse.
     * 
     * @param inventorySpace
     */
    public void setInventorySpace(java.lang.String inventorySpace) {
        this.inventorySpace = inventorySpace;
    }


    /**
     * Gets the productSearched value for this SearchInventoryResponse.
     * 
     * @return productSearched
     */
    public com.pos.satlujwe.PosGW.PosGWProduct getProductSearched() {
        return productSearched;
    }


    /**
     * Sets the productSearched value for this SearchInventoryResponse.
     * 
     * @param productSearched
     */
    public void setProductSearched(com.pos.satlujwe.PosGW.PosGWProduct productSearched) {
        this.productSearched = productSearched;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchInventoryResponse)) return false;
        SearchInventoryResponse other = (SearchInventoryResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.inventorySpace==null && other.getInventorySpace()==null) || 
             (this.inventorySpace!=null &&
              this.inventorySpace.equals(other.getInventorySpace()))) &&
            ((this.productSearched==null && other.getProductSearched()==null) || 
             (this.productSearched!=null &&
              this.productSearched.equals(other.getProductSearched())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getInventorySpace() != null) {
            _hashCode += getInventorySpace().hashCode();
        }
        if (getProductSearched() != null) {
            _hashCode += getProductSearched().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchInventoryResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">SearchInventoryResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inventorySpace");
        elemField.setXmlName(new javax.xml.namespace.QName("", "InventorySpace"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productSearched");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ProductSearched"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "PosGWProduct"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
