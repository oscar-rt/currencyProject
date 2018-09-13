
package currency;

import java.util.HashMap;

/**
 *
 * @author Oscar
 */
public class Currency {
    
    public String currencyName;
    public HashMap<Currency, Double> exchangeRates;
        
    public Currency(String currencyName){
        this.currencyName = currencyName;
        this.exchangeRates = new HashMap<>();
    }
    
    public void addTradingPair(Currency quote, Double rate){
        if(!this.exchangeRates.containsKey(quote)){
            this.exchangeRates.put(quote, rate);
        }
    }
}
