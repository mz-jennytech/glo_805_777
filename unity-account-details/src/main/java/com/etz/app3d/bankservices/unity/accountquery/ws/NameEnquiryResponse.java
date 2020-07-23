
package com.etz.app3d.bankservices.unity.accountquery.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="NameEnquiryResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "nameEnquiryResult"
})
@XmlRootElement(name = "NameEnquiryResponse")
public class NameEnquiryResponse {

    @XmlElement(name = "NameEnquiryResult")
    protected String nameEnquiryResult;

    /**
     * Gets the value of the nameEnquiryResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameEnquiryResult() {
        return nameEnquiryResult;
    }

    /**
     * Sets the value of the nameEnquiryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameEnquiryResult(String value) {
        this.nameEnquiryResult = value;
    }

}
