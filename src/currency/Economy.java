
package currency;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Oscar
 */
public class Economy {
    
    ArrayList<Wallet> wPointers;
    Currency base;
    ArrayList<Currency> currencies;
    String name;
    
    public Economy(Currency base, String economyName){
        this.currencies = new ArrayList<>();
        this.currencies.add(base);
        this.base = base;
        this.wPointers = new ArrayList<>();
        this.name = economyName;
    }
    
    public ArrayList<Currency> getCurrencyPool(){
        return this.currencies;
    }
    
    public void addCurrency(CurrencyPair currencyPair){
        if(this.currencies.contains(currencyPair.quote)){
            System.out.println("Hey, there's already a currency called " + currencyPair.quote.currencyName + ".");
        }
        else{
            this.currencies.add(currencyPair.quote);
            updateEconomy();
            sortCurrencies();
            updateWallets();
        }
    }

    private void updateEconomy() {
        int pairNumber = this.currencies.size() - 1;
        for(Currency currency : this.currencies){
            if(currency.exchangeRates.size() < pairNumber){
                checkTradingPairs(currency);
            }
        }
    }

    private void checkTradingPairs(Currency currency) {
        for(Currency compareCurrency : this.currencies){
            if(!compareCurrency.equals(currency)){
                if(!currency.exchangeRates.containsKey(compareCurrency)){
                    updateTradingPair(currency, compareCurrency);
                }
            }
        }
    }
    
    /*
    
    A-x-C
    B-y-C
    A->C= A * x 
    C->B =C / y
    A->B= A * x / y
    //How the function below works, essentially.
    */
    
    private void updateTradingPair(Currency currency, Currency compareCurrency) {
        for(Currency cIterator : this.currencies){
            if(currency.exchangeRates.containsKey(cIterator)
            && compareCurrency.exchangeRates.containsKey(cIterator)){
                double x = currency.exchangeRates.get(cIterator);
                double y = compareCurrency.exchangeRates.get(cIterator);
                currency.exchangeRates.put(compareCurrency, x/y);
                compareCurrency.exchangeRates.put(currency, y/x);
                break;
            }
        }
    }
    
    public void printEconomy(){
        for(Currency currency : this.currencies){
            System.out.println("=======" + currency.currencyName + "============");
            for(Currency cIterator : this.currencies){
                if(!currency.equals(cIterator)){
                    System.out.println(cIterator.currencyName + " : " + currency.exchangeRates.get(cIterator));
                }
            }
        }
        System.out.println("\n\n");
    }
    
    public void sortCurrencies(){
        this.currencies.sort(new CurrencyComparator());
    }

    private void updateWallets() {
        if(!this.wPointers.isEmpty()){
            for(Wallet wallet : this.wPointers){
                wallet.economy = this;
            }
        }
    }
    
    static class CurrencyComparator implements Comparator<Currency>{            
        @Override
        public int compare(Currency o1, Currency o2) {
            double o1o2 = o1.exchangeRates.get(o2);
            double o2o1 = o2.exchangeRates.get(o1);
            if(o1o2 > o2o1) return -1;
            if(o2o1 < o1o2) return 1;
            return 0;
        }
     }

}
