//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.12.04 at 11:24:10 AM WAT 
//


package com.etz.app3d.bankservices.heritage.accountquery.ws;

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
 *         &lt;element name="eTranzHBCMobileAuthenticationResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "eTranzHBCMobileAuthenticationResult"
})
@XmlRootElement(name = "eTranzHBCMobileAuthenticationResponse")
public class ETranzHBCMobileAuthenticationResponse {

    protected String eTranzHBCMobileAuthenticationResult;

    /**
     * Gets the value of the eTranzHBCMobileAuthenticationResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getETranzHBCMobileAuthenticationResult() {
        return eTranzHBCMobileAuthenticationResult;
    }

    /**
     * Sets the value of the eTranzHBCMobileAuthenticationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setETranzHBCMobileAuthenticationResult(String value) {
        this.eTranzHBCMobileAuthenticationResult = value;
    }

}
