/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currency;

import java.util.ArrayList;

/**
 *
 * @author Oscar
 */
public class Wallet {
    
    public Economy economy;
    public ArrayList<Balance> balance;
    public ArrayList<Currency> displayCurrency;
    
    public Wallet(Economy economy, ArrayList<Currency> display){
        economy.wPointers.add(this);
        this.economy = economy;
        this.displayCurrency = display;
    }
    
    public void setBalance(ArrayList<Balance> startingBalance){
        this.balance = startingBalance;
    }
    
    public void updateBalance(ArrayList<Balance> transaction){
        for(Balance tran : transaction){
            boolean nomatch = true;
            for(Balance balance : this.balance){
                if(balance.currency.equals(tran.currency)){
                    nomatch = false;
                    balance.balance += tran.balance;
                }
            }
            if(nomatch){
                this.balance.add(tran);
            }
        }
    }
    
    public void printAsDisplay(){
        displayCurrency.sort(new Economy.CurrencyComparator());
        Currency base = displayCurrency.get(displayCurrency.size() - 1);
        double value = 0;
        for(Balance balance : this.balance){
            if(balance.currency.equals(base)){
                value += balance.balance;
            }
            else{
                double multiplier = 1/base.exchangeRates.get(balance.currency);
                double modifiedBalance = balance.balance * multiplier;
                value += modifiedBalance;
            }
        }
        
        for(Currency currency : displayCurrency){
            if(currency != base){
            double divisor = currency.exchangeRates.get(base);
            System.out.println(currency.currencyName + " : " + Math.floor(value/divisor));
            value = value % divisor;
            }
            else{
            System.out.println(currency.currencyName + " : " + value);
            }
        }
    }
    
    public void printBalanceTotals(){
        System.out.println();
        String displayTotal = "";
        for(Currency currency: displayCurrency){
            displayTotal += getTotalForCurrency(currency);
        }
        
        System.out.println(displayTotal);
    }
    
    private String getTotalForCurrency(Currency currency){
        String totalCur  = "";
        
        double curAsBalance = 0;
        
        for(Balance balance : this.balance){
            if(balance.currency.equals(currency)){
                curAsBalance += balance.balance;
            }
            else{
                double multiplier = balance.currency.exchangeRates.get(currency);
                double modifiedBalance = balance.balance * multiplier;
                curAsBalance += modifiedBalance;
            }
        }
        
        double roundedResult = Math.round(curAsBalance);
        
        return "T: " +  currency.currencyName + " : " + roundedResult + "  |";
    }
    
    
}
