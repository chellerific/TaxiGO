
package taxi;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "DatabaseService", targetNamespace = "http://service/", wsdlLocation = "http://localhost:8080/TaxiGOServer/DatabaseService?wsdl")
public class DatabaseService_Service
    extends Service
{

    private final static URL DATABASESERVICE_WSDL_LOCATION;
    private final static WebServiceException DATABASESERVICE_EXCEPTION;
    private final static QName DATABASESERVICE_QNAME = new QName("http://service/", "DatabaseService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/TaxiGOServer/DatabaseService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        DATABASESERVICE_WSDL_LOCATION = url;
        DATABASESERVICE_EXCEPTION = e;
    }

    public DatabaseService_Service() {
        super(__getWsdlLocation(), DATABASESERVICE_QNAME);
    }

    public DatabaseService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), DATABASESERVICE_QNAME, features);
    }

    public DatabaseService_Service(URL wsdlLocation) {
        super(wsdlLocation, DATABASESERVICE_QNAME);
    }

    public DatabaseService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, DATABASESERVICE_QNAME, features);
    }

    public DatabaseService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DatabaseService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns DatabaseService
     */
    @WebEndpoint(name = "DatabaseServicePort")
    public DatabaseService getDatabaseServicePort() {
        return super.getPort(new QName("http://service/", "DatabaseServicePort"), DatabaseService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DatabaseService
     */
    @WebEndpoint(name = "DatabaseServicePort")
    public DatabaseService getDatabaseServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service/", "DatabaseServicePort"), DatabaseService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (DATABASESERVICE_EXCEPTION!= null) {
            throw DATABASESERVICE_EXCEPTION;
        }
        return DATABASESERVICE_WSDL_LOCATION;
    }

}