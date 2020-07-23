
package com.etz.app3d.bankservices.unity.accountquery.ws;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.unitybankng package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.unitybankng
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NameEnquiry }
     * 
     */
    public NameEnquiry createNameEnquiry() {
        return new NameEnquiry();
    }

    /**
     * Create an instance of {@link NameEnquiryResponse }
     * 
     */
    public NameEnquiryResponse createNameEnquiryResponse() {
        return new NameEnquiryResponse();
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
     * Create an instance of {@link ArrayOfAccountDetail }
     * 
     */
    public ArrayOfAccountDetail createArrayOfAccountDetail() {
        return new ArrayOfAccountDetail();
    }

    /**
     * Create an instance of {@link AccountDetail }
     * 
     */
    public AccountDetail createAccountDetail() {
        return new AccountDetail();
    }

    /**
     * Create an instance of {@link ArrayOfAccounts }
     * 
     */
    public ArrayOfAccounts createArrayOfAccounts() {
        return new ArrayOfAccounts();
    }

    /**
     * Create an instance of {@link Accounts }
     * 
     */
    public Accounts createAccounts() {
        return new Accounts();
    }

}
