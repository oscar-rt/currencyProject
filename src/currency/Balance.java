/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currency;

import java.util.Comparator;

/**
 *
 * @author Oscar
 */
public class Balance {
    
    public Currency currency;
    public double balance;
    
    public Balance(Currency currency, double balance){
        this.currency = currency;
        this.balance = balance;
    }
    
    public static class BalanceComparator implements Comparator<Balance>{            
        @Override
        public int compare(Balance o1, Balance o2) {
            double o1o2 = o1.currency.exchangeRates.get(o2);
            double o2o1 = o2.currency.exchangeRates.get(o1);
            if(o1o2 > o2o1) return -1;
            if(o2o1 < o1o2) return 1;
            return 0;
        }
     }
}
