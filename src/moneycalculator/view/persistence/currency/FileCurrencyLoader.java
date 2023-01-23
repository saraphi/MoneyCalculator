package moneycalculator.view.persistence.currency;

import moneycalculator.view.persistence.currency.CurrencyLoader;
import moneycalculator.model.Currency;

import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FileCurrencyLoader implements CurrencyLoader {

    private final String fileName;

    public FileCurrencyLoader(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    public List<Currency> load() {
        List<Currency> currencies = new ArrayList<>();
        
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "utf-8"));
            
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                currencies.add(currencyOf(line));
            }
            
            reader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("CurrencyLoader :: loadCurrencies, FileNotFound" + e.getMessage());
        } catch (IOException e) {
            System.out.println("CurrencyLoader :: loadCurrencies, IO" + e.getMessage());
        } 
        
        return currencies;
    }
    
    private Currency currencyOf(String line) {
        String[] split = line.split(",");
        return new Currency(split[0], split[1], split[2]);
    }
}