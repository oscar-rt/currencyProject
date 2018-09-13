/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currency;

/**
 *
 * @author Oscar
 */
public class Default {
    
    public static Economy getDNDEconomy(){
        
        Currency platinum = new Currency("Platinum");
        Currency gold = new Currency("Gold");
        Currency electrum = new Currency("Electrum");
        Currency silver = new Currency("Silver");
        Currency copper = new Currency("Copper");
        
        Economy dndEcon = new Economy(gold, "Dungeons and Dragons");
        CurrencyPair goldPlatinum = new CurrencyPair(gold, platinum, (double)1/10);
        dndEcon.addCurrency(goldPlatinum);
        CurrencyPair goldElectrum = new CurrencyPair(gold, electrum, 2);
        dndEcon.addCurrency(goldElectrum);
        CurrencyPair electrumSilver = new CurrencyPair(electrum, silver, 5);
        dndEcon.addCurrency(electrumSilver);
        CurrencyPair silverBronze = new CurrencyPair(silver, copper, 10);
        dndEcon.addCurrency(silverBronze);
        
        return dndEcon;
    }
    
    public static Economy getKingkillerCealdishEconomy(){
        
        Currency goldMark = new Currency("Gold Mark");
        Currency silverTalent = new Currency("Silver Talent");
        Currency copperJot = new Currency("Copper Jot");
        Currency ironDrab = new Currency("Iron Drab");
        Currency shim = new Currency("Shim");
        
        Economy cealdishEcon = new Economy(silverTalent, "Kingkiller Cealdish Economy");
        CurrencyPair goldPlatinum = new CurrencyPair(silverTalent, goldMark, (double)1/10);
        cealdishEcon.addCurrency(goldPlatinum);
        CurrencyPair goldElectrum = new CurrencyPair(silverTalent, copperJot, 10);
        cealdishEcon.addCurrency(goldElectrum);
        CurrencyPair electrumSilver = new CurrencyPair(copperJot, ironDrab, 10);
        cealdishEcon.addCurrency(electrumSilver);
        CurrencyPair silverBronze = new CurrencyPair(ironDrab, shim, 11);
        cealdishEcon.addCurrency(silverBronze);
        
        return cealdishEcon;
    }
    
    public static Economy getKingkillerVintishEconomy(){
        
        
        
        return null;
    }
    
    public static Economy getKingkillerCommonwealthEconomy(){
        
        
        
        return null;
    }
    
    public static Economy getKingkillerAturanEconomy(){
        
        
        
        return null;
    }
}
