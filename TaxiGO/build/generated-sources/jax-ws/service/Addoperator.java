
package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addoperator complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addoperator">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="operator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="baserate" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="priceperkm" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="weekendfee" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="rating" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addoperator", propOrder = {
    "operator",
    "baserate",
    "priceperkm",
    "weekendfee",
    "rating"
})
public class Addoperator {

    protected String operator;
    protected double baserate;
    protected double priceperkm;
    protected double weekendfee;
    protected int rating;

    /**
     * Gets the value of the operator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Sets the value of the operator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperator(String value) {
        this.operator = value;
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

    /**
     * Gets the value of the rating property.
     * 
     */
    public int getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     */
    public void setRating(int value) {
        this.rating = value;
    }

}
