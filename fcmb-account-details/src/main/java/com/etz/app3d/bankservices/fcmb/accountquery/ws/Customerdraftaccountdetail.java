//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.11.12 at 04:29:39 PM WAT 
//


package com.etz.app3d.bankservices.fcmb.accountquery.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vforacid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vusername" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vpasswd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "vforacid",
    "vusername",
    "vpasswd"
})
@XmlRootElement(name = "customerdraftaccountdetail")
public class Customerdraftaccountdetail {

    protected String vforacid;
    protected String vusername;
    protected String vpasswd;

    /**
     * Gets the value of the vforacid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVforacid() {
        return vforacid;
    }

    /**
     * Sets the value of the vforacid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVforacid(String value) {
        this.vforacid = value;
    }

    /**
     * Gets the value of the vusername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVusername() {
        return vusername;
    }

    /**
     * Sets the value of the vusername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVusername(String value) {
        this.vusername = value;
    }

    /**
     * Gets the value of the vpasswd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVpasswd() {
        return vpasswd;
    }

    /**
     * Sets the value of the vpasswd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVpasswd(String value) {
        this.vpasswd = value;
    }

}