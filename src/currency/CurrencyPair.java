/*
 * When creating a new currency, the base should be any already existing currency. 
 * The quote MUST be the new currency.
 */
package currency;

/**
 *
 * @author Oscar
 */
public class CurrencyPair {
    
    public Currency base;
    public Currency quote; 
    public double exchangeRate;
    
    public CurrencyPair(Currency base, Currency quote, double exchangeRate){
        this.base = base;
        this.quote = quote;
        this.exchangeRate = exchangeRate;
        
        base.addTradingPair(quote, exchangeRate);
        quote.addTradingPair(base, (double)1/exchangeRate);
    }
}
