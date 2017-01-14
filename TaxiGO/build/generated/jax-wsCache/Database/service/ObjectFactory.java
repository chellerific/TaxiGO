
package service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service package. 
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

    private final static QName _AddoperatorResponse_QNAME = new QName("http://service/", "addoperatorResponse");
    private final static QName _Getadmininfo_QNAME = new QName("http://service/", "getadmininfo");
    private final static QName _Getbookings_QNAME = new QName("http://service/", "getbookings");
    private final static QName _GetadmininfoResponse_QNAME = new QName("http://service/", "getadmininfoResponse");
    private final static QName _Getpriceinfo_QNAME = new QName("http://service/", "getpriceinfo");
    private final static QName _UpdatePriceResponse_QNAME = new QName("http://service/", "updatePriceResponse");
    private final static QName _GetpriceinfoResponse_QNAME = new QName("http://service/", "getpriceinfoResponse");
    private final static QName _UpdatePrice_QNAME = new QName("http://service/", "updatePrice");
    private final static QName _AddoperatorloginResponse_QNAME = new QName("http://service/", "addoperatorloginResponse");
    private final static QName _Addoperator_QNAME = new QName("http://service/", "addoperator");
    private final static QName _Addoperatorlogin_QNAME = new QName("http://service/", "addoperatorlogin");
    private final static QName _GetbookingsResponse_QNAME = new QName("http://service/", "getbookingsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdatePriceResponse }
     * 
     */
    public UpdatePriceResponse createUpdatePriceResponse() {
        return new UpdatePriceResponse();
    }

    /**
     * Create an instance of {@link Getpriceinfo }
     * 
     */
    public Getpriceinfo createGetpriceinfo() {
        return new Getpriceinfo();
    }

    /**
     * Create an instance of {@link GetadmininfoResponse }
     * 
     */
    public GetadmininfoResponse createGetadmininfoResponse() {
        return new GetadmininfoResponse();
    }

    /**
     * Create an instance of {@link Getadmininfo }
     * 
     */
    public Getadmininfo createGetadmininfo() {
        return new Getadmininfo();
    }

    /**
     * Create an instance of {@link Getbookings }
     * 
     */
    public Getbookings createGetbookings() {
        return new Getbookings();
    }

    /**
     * Create an instance of {@link AddoperatorResponse }
     * 
     */
    public AddoperatorResponse createAddoperatorResponse() {
        return new AddoperatorResponse();
    }

    /**
     * Create an instance of {@link Addoperator }
     * 
     */
    public Addoperator createAddoperator() {
        return new Addoperator();
    }

    /**
     * Create an instance of {@link Addoperatorlogin }
     * 
     */
    public Addoperatorlogin createAddoperatorlogin() {
        return new Addoperatorlogin();
    }

    /**
     * Create an instance of {@link GetbookingsResponse }
     * 
     */
    public GetbookingsResponse createGetbookingsResponse() {
        return new GetbookingsResponse();
    }

    /**
     * Create an instance of {@link AddoperatorloginResponse }
     * 
     */
    public AddoperatorloginResponse createAddoperatorloginResponse() {
        return new AddoperatorloginResponse();
    }

    /**
     * Create an instance of {@link UpdatePrice }
     * 
     */
    public UpdatePrice createUpdatePrice() {
        return new UpdatePrice();
    }

    /**
     * Create an instance of {@link GetpriceinfoResponse }
     * 
     */
    public GetpriceinfoResponse createGetpriceinfoResponse() {
        return new GetpriceinfoResponse();
    }

    /**
     * Create an instance of {@link Admininfo }
     * 
     */
    public Admininfo createAdmininfo() {
        return new Admininfo();
    }

    /**
     * Create an instance of {@link Taxioperator }
     * 
     */
    public Taxioperator createTaxioperator() {
        return new Taxioperator();
    }

    /**
     * Create an instance of {@link Bookings }
     * 
     */
    public Bookings createBookings() {
        return new Bookings();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddoperatorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addoperatorResponse")
    public JAXBElement<AddoperatorResponse> createAddoperatorResponse(AddoperatorResponse value) {
        return new JAXBElement<AddoperatorResponse>(_AddoperatorResponse_QNAME, AddoperatorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Getadmininfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getadmininfo")
    public JAXBElement<Getadmininfo> createGetadmininfo(Getadmininfo value) {
        return new JAXBElement<Getadmininfo>(_Getadmininfo_QNAME, Getadmininfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Getbookings }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getbookings")
    public JAXBElement<Getbookings> createGetbookings(Getbookings value) {
        return new JAXBElement<Getbookings>(_Getbookings_QNAME, Getbookings.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetadmininfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getadmininfoResponse")
    public JAXBElement<GetadmininfoResponse> createGetadmininfoResponse(GetadmininfoResponse value) {
        return new JAXBElement<GetadmininfoResponse>(_GetadmininfoResponse_QNAME, GetadmininfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Getpriceinfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getpriceinfo")
    public JAXBElement<Getpriceinfo> createGetpriceinfo(Getpriceinfo value) {
        return new JAXBElement<Getpriceinfo>(_Getpriceinfo_QNAME, Getpriceinfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "updatePriceResponse")
    public JAXBElement<UpdatePriceResponse> createUpdatePriceResponse(UpdatePriceResponse value) {
        return new JAXBElement<UpdatePriceResponse>(_UpdatePriceResponse_QNAME, UpdatePriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetpriceinfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getpriceinfoResponse")
    public JAXBElement<GetpriceinfoResponse> createGetpriceinfoResponse(GetpriceinfoResponse value) {
        return new JAXBElement<GetpriceinfoResponse>(_GetpriceinfoResponse_QNAME, GetpriceinfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "updatePrice")
    public JAXBElement<UpdatePrice> createUpdatePrice(UpdatePrice value) {
        return new JAXBElement<UpdatePrice>(_UpdatePrice_QNAME, UpdatePrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddoperatorloginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addoperatorloginResponse")
    public JAXBElement<AddoperatorloginResponse> createAddoperatorloginResponse(AddoperatorloginResponse value) {
        return new JAXBElement<AddoperatorloginResponse>(_AddoperatorloginResponse_QNAME, AddoperatorloginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Addoperator }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addoperator")
    public JAXBElement<Addoperator> createAddoperator(Addoperator value) {
        return new JAXBElement<Addoperator>(_Addoperator_QNAME, Addoperator.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Addoperatorlogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addoperatorlogin")
    public JAXBElement<Addoperatorlogin> createAddoperatorlogin(Addoperatorlogin value) {
        return new JAXBElement<Addoperatorlogin>(_Addoperatorlogin_QNAME, Addoperatorlogin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetbookingsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getbookingsResponse")
    public JAXBElement<GetbookingsResponse> createGetbookingsResponse(GetbookingsResponse value) {
        return new JAXBElement<GetbookingsResponse>(_GetbookingsResponse_QNAME, GetbookingsResponse.class, null, value);
    }

}
