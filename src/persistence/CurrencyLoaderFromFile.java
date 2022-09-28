package persistence;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;
import model.Currency;

public class CurrencyLoaderFromFile implements CurrencyLoader {

    private final String fileName;
    
    public CurrencyLoaderFromFile(String fileName) {
        this.fileName = fileName;
    } 
    
    @Override
    public List<Currency> loadCurrencies() {
        List<Currency> currencies = new ArrayList<>();
        
        try {
            // BufferedReader reader = new BufferedReader(new FileReader(new File(this.fileName)));
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(this.fileName), "utf-8"));
            IteratorReader iteratorReader = new IteratorReader(reader);
            
            //iteratorReader.iterator().
            
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                currencies.add(currencyOf(line));
            }
            
            reader.close();
            
        // esto no es adecuado. en el mundo profesional se usa log4java? or something like that
        } catch (FileNotFoundException ex) {
            System.out.println("CurrencyLoaderFromFile :: loadCurrencies, FileNotFound" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("CurrencyLoaderFromFile :: loadCurrencies, IO" + ex.getMessage());
        }
        
        return currencies;
    }

    private Currency currencyOf(String line) {
        String[] split = line.split(",");
        return new Currency(split[0], split[1], split[2].charAt(0));
    }
}
