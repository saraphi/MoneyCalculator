package persistence;

// refactorizar el nombre

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Currency;
import model.ExchangeRate;

public class ExchangeRateLoaderFromWebService implements ExchangeRateLoader {
    
    /*
     * https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/" 
     * + from + "/" + to + ".json", where form and to are the base and 
     * destination currency codes of the exchange rate.
     */
    @Override
    public ExchangeRate exchangerateLoader(Currency from, Currency to) throws IOException, MalformedURLException {
        return new ExchangeRate(from, to, read(from.getCode(), to.getCode()));
    }    

    private double read(String from, String to) throws MalformedURLException, IOException {
        String line = read(new URL("https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/" + from + "/" + to + ".json"));
        return Double.parseDouble(getStringRateFromJSONFile(line));
    }
   
    private String read(URL url) throws IOException {
        InputStream inputStream = url.openStream();
        byte[] buffer = new byte[1024];
        int lenght = inputStream.read(buffer);
        return new String(buffer, 1, lenght);
    }

    private String getStringRateFromJSONFile(String line) {
        String[] split = line.split(",");
        return split[1].substring(split[1].indexOf(":") + 1, split[1].indexOf(")") - 1);
    }
}