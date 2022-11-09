package persistence;

import persistence.interfaces.Loader;
import model.Currency;
import model.ExchangeRate;

import java.io.IOException;
import java.io.InputStream;

import java.net.MalformedURLException;
import java.net.URL;

public class ExchangeRateLoader implements Loader<ExchangeRate> {

    private Currency from;
    private Currency to;
    
    public void setCurrencies(Currency from, Currency to) {
        this.from = from;
        this.to = to;
    }
    
    @Override
    public ExchangeRate load() {
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
        int lenght = inputStream.read(buffer);
        String line = new String(buffer, 1, lenght);
        return line;
    }
    
    private String getData(String line) {
        String[] split = line.split(",");
        return split[1].substring(split[1].indexOf(":") + 1, split[1].indexOf("}") - 1);
    }
}