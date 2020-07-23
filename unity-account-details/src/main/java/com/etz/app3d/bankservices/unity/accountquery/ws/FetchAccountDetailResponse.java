
package com.etz.app3d.bankservices.unity.accountquery.ws;

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
 *         &lt;element name="fetchAccountDetailResult" type="{http://unitybankng.com/}ArrayOfAccountDetail" minOccurs="0"/>
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
    "fetchAccountDetailResult"
})
@XmlRootElement(name = "fetchAccountDetailResponse")
public class FetchAccountDetailResponse {

    protected ArrayOfAccountDetail fetchAccountDetailResult;

    /**
     * Gets the value of the fetchAccountDetailResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAccountDetail }
     *     
     */
    public ArrayOfAccountDetail getFetchAccountDetailResult() {
        return fetchAccountDetailResult;
    }

    /**
     * Sets the value of the fetchAccountDetailResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAccountDetail }
     *     
     */
    public void setFetchAccountDetailResult(ArrayOfAccountDetail value) {
        this.fetchAccountDetailResult = value;
    }

}
