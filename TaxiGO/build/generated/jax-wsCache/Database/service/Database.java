
package service;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Database", targetNamespace = "http://service/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Database {


    /**
     * 
     * @param password
     * @param phone
     * @param operator
     * @param email
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addoperatorlogin", targetNamespace = "http://service/", className = "service.Addoperatorlogin")
    @ResponseWrapper(localName = "addoperatorloginResponse", targetNamespace = "http://service/", className = "service.AddoperatorloginResponse")
    @Action(input = "http://service/Database/addoperatorloginRequest", output = "http://service/Database/addoperatorloginResponse")
    public String addoperatorlogin(
        @WebParam(name = "operator", targetNamespace = "")
        String operator,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "email", targetNamespace = "")
        String email,
        @WebParam(name = "phone", targetNamespace = "")
        String phone);

    /**
     * 
     * @param operator
     * @return
     *     returns service.Taxioperator
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getpriceinfoforoperator", targetNamespace = "http://service/", className = "service.Getpriceinfoforoperator")
    @ResponseWrapper(localName = "getpriceinfoforoperatorResponse", targetNamespace = "http://service/", className = "service.GetpriceinfoforoperatorResponse")
    @Action(input = "http://service/Database/getpriceinfoforoperatorRequest", output = "http://service/Database/getpriceinfoforoperatorResponse")
    public Taxioperator getpriceinfoforoperator(
        @WebParam(name = "operator", targetNamespace = "")
        String operator);

    /**
     * 
     * @return
     *     returns java.util.List<service.Admininfo>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getadmininfo", targetNamespace = "http://service/", className = "service.Getadmininfo")
    @ResponseWrapper(localName = "getadmininfoResponse", targetNamespace = "http://service/", className = "service.GetadmininfoResponse")
    @Action(input = "http://service/Database/getadmininfoRequest", output = "http://service/Database/getadmininfoResponse")
    public List<Admininfo> getadmininfo();

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<service.Bookings>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getbookings", targetNamespace = "http://service/", className = "service.Getbookings")
    @ResponseWrapper(localName = "getbookingsResponse", targetNamespace = "http://service/", className = "service.GetbookingsResponse")
    @Action(input = "http://service/Database/getbookingsRequest", output = "http://service/Database/getbookingsResponse")
    public List<Bookings> getbookings(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @return
     *     returns java.util.List<service.Taxioperator>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getpriceinfo", targetNamespace = "http://service/", className = "service.Getpriceinfo")
    @ResponseWrapper(localName = "getpriceinfoResponse", targetNamespace = "http://service/", className = "service.GetpriceinfoResponse")
    @Action(input = "http://service/Database/getpriceinfoRequest", output = "http://service/Database/getpriceinfoResponse")
    public List<Taxioperator> getpriceinfo();

    /**
     * 
     * @param baserate
     * @param priceperkm
     * @param weekendfee
     * @param company
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updatePrice", targetNamespace = "http://service/", className = "service.UpdatePrice")
    @ResponseWrapper(localName = "updatePriceResponse", targetNamespace = "http://service/", className = "service.UpdatePriceResponse")
    @Action(input = "http://service/Database/updatePriceRequest", output = "http://service/Database/updatePriceResponse")
    public String updatePrice(
        @WebParam(name = "company", targetNamespace = "")
        String company,
        @WebParam(name = "baserate", targetNamespace = "")
        double baserate,
        @WebParam(name = "priceperkm", targetNamespace = "")
        double priceperkm,
        @WebParam(name = "weekendfee", targetNamespace = "")
        double weekendfee);

    /**
     * 
     * @param baserate
     * @param priceperkm
     * @param weekendfee
     * @param rating
     * @param operator
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addoperator", targetNamespace = "http://service/", className = "service.Addoperator")
    @ResponseWrapper(localName = "addoperatorResponse", targetNamespace = "http://service/", className = "service.AddoperatorResponse")
    @Action(input = "http://service/Database/addoperatorRequest", output = "http://service/Database/addoperatorResponse")
    public String addoperator(
        @WebParam(name = "operator", targetNamespace = "")
        String operator,
        @WebParam(name = "baserate", targetNamespace = "")
        double baserate,
        @WebParam(name = "priceperkm", targetNamespace = "")
        double priceperkm,
        @WebParam(name = "weekendfee", targetNamespace = "")
        double weekendfee,
        @WebParam(name = "rating", targetNamespace = "")
        int rating);

    /**
     * 
     * @param password
     * @param phone
     * @param reported
     * @param email
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addCustomer", targetNamespace = "http://service/", className = "service.AddCustomer")
    @ResponseWrapper(localName = "addCustomerResponse", targetNamespace = "http://service/", className = "service.AddCustomerResponse")
    @Action(input = "http://service/Database/addCustomerRequest", output = "http://service/Database/addCustomerResponse")
    public String addCustomer(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "email", targetNamespace = "")
        String email,
        @WebParam(name = "phone", targetNamespace = "")
        String phone,
        @WebParam(name = "reported", targetNamespace = "")
        boolean reported);

    /**
     * 
     * @param date
     * @param companyname
     * @param price
     * @param origin
     * @param destination
     * @param time
     * @param customer
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addBooking", targetNamespace = "http://service/", className = "service.AddBooking")
    @ResponseWrapper(localName = "addBookingResponse", targetNamespace = "http://service/", className = "service.AddBookingResponse")
    @Action(input = "http://service/Database/addBookingRequest", output = "http://service/Database/addBookingResponse")
    public String addBooking(
        @WebParam(name = "companyname", targetNamespace = "")
        String companyname,
        @WebParam(name = "customer", targetNamespace = "")
        String customer,
        @WebParam(name = "origin", targetNamespace = "")
        String origin,
        @WebParam(name = "destination", targetNamespace = "")
        String destination,
        @WebParam(name = "price", targetNamespace = "")
        double price,
        @WebParam(name = "date", targetNamespace = "")
        String date,
        @WebParam(name = "time", targetNamespace = "")
        String time);

    /**
     * 
     * @return
     *     returns java.util.List<service.Taxiinfo>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getOperators", targetNamespace = "http://service/", className = "service.GetOperators")
    @ResponseWrapper(localName = "getOperatorsResponse", targetNamespace = "http://service/", className = "service.GetOperatorsResponse")
    @Action(input = "http://service/Database/getOperatorsRequest", output = "http://service/Database/getOperatorsResponse")
    public List<Taxiinfo> getOperators();

    /**
     * 
     * @return
     *     returns java.util.List<service.Clientinfo>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getclients", targetNamespace = "http://service/", className = "service.Getclients")
    @ResponseWrapper(localName = "getclientsResponse", targetNamespace = "http://service/", className = "service.GetclientsResponse")
    @Action(input = "http://service/Database/getclientsRequest", output = "http://service/Database/getclientsResponse")
    public List<Clientinfo> getclients();

    /**
     * 
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "reportuser", targetNamespace = "http://service/", className = "service.Reportuser")
    @ResponseWrapper(localName = "reportuserResponse", targetNamespace = "http://service/", className = "service.ReportuserResponse")
    @Action(input = "http://service/Database/reportuserRequest", output = "http://service/Database/reportuserResponse")
    public String reportuser(
        @WebParam(name = "username", targetNamespace = "")
        String username);

    /**
     * 
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "removeuser", targetNamespace = "http://service/", className = "service.Removeuser")
    @ResponseWrapper(localName = "removeuserResponse", targetNamespace = "http://service/", className = "service.RemoveuserResponse")
    @Action(input = "http://service/Database/removeuserRequest", output = "http://service/Database/removeuserResponse")
    public String removeuser(
        @WebParam(name = "username", targetNamespace = "")
        String username);

}
