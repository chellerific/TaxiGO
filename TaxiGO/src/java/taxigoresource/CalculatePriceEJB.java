/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxigoresource;

import java.text.DecimalFormat;
import javax.ejb.Stateless;
import service.Taxiinfo;
import service.Taxioperator;

/**
 *
 * @author Sara
 */
@Stateless
public class CalculatePriceEJB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public double calculatePrice(Taxioperator taxi, double distance) {
        double baseRate = taxi.getBaserate();
        double pricePerKm = taxi.getPriceperkm();
        
        double price = Double.parseDouble(new DecimalFormat("##.##")
                .format(baseRate + (pricePerKm * distance))
                .replace(",", "."));
        
        return price;
    }
    
}
