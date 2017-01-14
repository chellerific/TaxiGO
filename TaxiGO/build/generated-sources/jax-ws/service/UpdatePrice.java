
package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updatePrice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updatePrice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="company" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="baserate" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="priceperkm" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="weekendfee" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updatePrice", propOrder = {
    "company",
    "baserate",
    "priceperkm",
    "weekendfee"
})
public class UpdatePrice {

    protected String company;
    protected double baserate;
    protected double priceperkm;
    protected double weekendfee;

    /**
     * Gets the value of the company property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the value of the company property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompany(String value) {
        this.company = value;
    }

    /**
     * Gets the value of the baserate property.
     * 
     */
    public double getBaserate() {
        return baserate;
    }

    /**
     * Sets the value of the baserate property.
     * 
     */
    public void setBaserate(double value) {
        this.baserate = value;
    }

    /**
     * Gets the value of the priceperkm property.
     * 
     */
    public double getPriceperkm() {
        return priceperkm;
    }

    /**
     * Sets the value of the priceperkm property.
     * 
     */
    public void setPriceperkm(double value) {
        this.priceperkm = value;
    }

    /**
     * Gets the value of the weekendfee property.
     * 
     */
    public double getWeekendfee() {
        return weekendfee;
    }

    /**
     * Sets the value of the weekendfee property.
     * 
     */
    public void setWeekendfee(double value) {
        this.weekendfee = value;
    }

}
