
package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for taxioperator complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="taxioperator">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="baserate" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="operator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="priceperkm" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="rating" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="weekendfee" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "taxioperator", propOrder = {
    "baserate",
    "operator",
    "priceperkm",
    "rating",
    "weekendfee"
})
public class Taxioperator {

    protected double baserate;
    protected String operator;
    protected double priceperkm;
    protected int rating;
    protected Double weekendfee;

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

    /**
     * Gets the value of the weekendfee property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getWeekendfee() {
        return weekendfee;
    }

    /**
     * Sets the value of the weekendfee property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWeekendfee(Double value) {
        this.weekendfee = value;
    }

}
