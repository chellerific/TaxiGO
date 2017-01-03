
package taxi;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the taxi package. 
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

    private final static QName _GetadmininfoResponse_QNAME = new QName("http://service/", "getadmininfoResponse");
    private final static QName _Getadmininfo_QNAME = new QName("http://service/", "getadmininfo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: taxi
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Getadmininfo }
     * 
     */
    public Getadmininfo createGetadmininfo() {
        return new Getadmininfo();
    }

    /**
     * Create an instance of {@link GetadmininfoResponse }
     * 
     */
    public GetadmininfoResponse createGetadmininfoResponse() {
        return new GetadmininfoResponse();
    }

    /**
     * Create an instance of {@link Admininfo }
     * 
     */
    public Admininfo createAdmininfo() {
        return new Admininfo();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Getadmininfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getadmininfo")
    public JAXBElement<Getadmininfo> createGetadmininfo(Getadmininfo value) {
        return new JAXBElement<Getadmininfo>(_Getadmininfo_QNAME, Getadmininfo.class, null, value);
    }

}
