package persistence;

import java.io.IOException;
import java.net.MalformedURLException;
import model.Currency;
import model.ExchangeRate;

public interface ExchangeRateLoader {
    
    public ExchangeRate exchangerateLoader(Currency from, Currency to) throws IOException, MalformedURLException ;
}
