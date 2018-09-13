/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currency;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Oscar
 */
public class App {
    
    public static void main(String [ ] args){
        Economy defaultEconomy = Default.getKingkillerCealdishEconomy();
        
        defaultEconomy.printEconomy();
        ArrayList<Currency> displayCur = new ArrayList<>(
                Arrays.asList(
                    defaultEconomy.currencies.get(0),
                    defaultEconomy.currencies.get(1),
                    defaultEconomy.currencies.get(2),
                    defaultEconomy.currencies.get(3),
                    defaultEconomy.currencies.get(4)
                )
        );
        Wallet myWallet = new Wallet(defaultEconomy, displayCur);
        ArrayList<Balance> startBalance = new ArrayList<>(
            Arrays.asList(new Balance(defaultEconomy.currencies.get(0), 100),
                          new Balance(defaultEconomy.currencies.get(1), 0),
                          new Balance(defaultEconomy.currencies.get(2), 0)
            )
        );
        myWallet.setBalance(startBalance);
        
        myWallet.printBalanceTotals();
        myWallet.printAsDisplay();

        
        ArrayList<Balance> newBalance = new ArrayList<>(
            Arrays.asList(new Balance(defaultEconomy.currencies.get(0), 0),
                          new Balance(defaultEconomy.currencies.get(1), 0),
                          new Balance(defaultEconomy.currencies.get(3), -1)
            )
        );
        
        myWallet.updateBalance(newBalance);
        myWallet.printBalanceTotals();
        myWallet.printAsDisplay();
    }
}
