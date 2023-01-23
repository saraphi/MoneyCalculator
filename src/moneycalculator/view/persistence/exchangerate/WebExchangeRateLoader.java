package moneycalculator.view.persistence.exchangerate;

import moneycalculator.view.persistence.exchangerate.ExchangeRateLoader;
import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;

import java.io.IOException;
import java.io.InputStream;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class WebExchangeRateLoader implements ExchangeRateLoader {
    
    @Override
    public ExchangeRate load(Currency from, Currency to) {
        return new ExchangeRate(from, to, readExchangeRate(from.getCode(), to.getCode()));
    }
    
    private double readExchangeRate(String from, String to) {
        String line = "";
        try {
            line = readURL(new URL("https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/" + from + "/" + to + ".json"));
        } catch (MalformedURLException e) {
            System.out.println("ExchangeRateLoader :: readExchangeRate, MalformedURL" + e.getMessage());
        } catch (IOException e) {
            System.out.println("ExchangeRateLoader :: readURL, IO" + e.getMessage());
        }
        
        return Double.parseDouble(getData(line));
    }
    
    private String readURL(URL url) throws IOException {
        InputStream inputStream = url.openStream();
        byte[] buffer = new byte[1024];
        
        int length = 0;
        int readBytes;
        
        while ((readBytes = inputStream.read(buffer)) >= 0) length += readBytes;
        
        String line = new String(buffer, 1, length);
        return line;
    }
    
    private String getData(String line) {
        return line.split(": ")[2].substring(0, line.split(": ")[2].indexOf("}") - 1);
    }
}