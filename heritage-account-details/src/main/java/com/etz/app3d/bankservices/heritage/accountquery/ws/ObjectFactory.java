//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.12.04 at 11:24:10 AM WAT 
//


package com.etz.app3d.bankservices.heritage.accountquery.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.etz.app3d.bankservices.heritage.accountquery.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AuthHeader_QNAME = new QName("http://tempuri.org/", "AuthHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.etz.app3d.bankservices.heritage.accountquery.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AuthHeader }
     * 
     */
    public AuthHeader createAuthHeader() {
        return new AuthHeader();
    }

    /**
     * Create an instance of {@link ETranzHBCMobileAuthentication }
     * 
     */
    public ETranzHBCMobileAuthentication createETranzHBCMobileAuthentication() {
        return new ETranzHBCMobileAuthentication();
    }

    /**
     * Create an instance of {@link ETranzHBCMobileAuthenticationResponse }
     * 
     */
    public ETranzHBCMobileAuthenticationResponse createETranzHBCMobileAuthenticationResponse() {
        return new ETranzHBCMobileAuthenticationResponse();
    }

    /**
     * Create an instance of {@link ETranzHBCRemittanceUIResponse }
     * 
     */
    public ETranzHBCRemittanceUIResponse createETranzHBCRemittanceUIResponse() {
        return new ETranzHBCRemittanceUIResponse();
    }

    /**
     * Create an instance of {@link FetchAccountDetailWithIdResponse }
     * 
     */
    public FetchAccountDetailWithIdResponse createFetchAccountDetailWithIdResponse() {
        return new FetchAccountDetailWithIdResponse();
    }

    /**
     * Create an instance of {@link FetchAccountDetailWithId }
     * 
     */
    public FetchAccountDetailWithId createFetchAccountDetailWithId() {
        return new FetchAccountDetailWithId();
    }

    /**
     * Create an instance of {@link ETranzHBCRemittanceUI }
     * 
     */
    public ETranzHBCRemittanceUI createETranzHBCRemittanceUI() {
        return new ETranzHBCRemittanceUI();
    }

    /**
     * Create an instance of {@link FetchAccountDetail }
     * 
     */
    public FetchAccountDetail createFetchAccountDetail() {
        return new FetchAccountDetail();
    }

    /**
     * Create an instance of {@link FetchAccountDetailResponse }
     * 
     */
    public FetchAccountDetailResponse createFetchAccountDetailResponse() {
        return new FetchAccountDetailResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "AuthHeader")
    public JAXBElement<AuthHeader> createAuthHeader(AuthHeader value) {
        return new JAXBElement<AuthHeader>(_AuthHeader_QNAME, AuthHeader.class, null, value);
    }

}
