package persistence.interfaces;

import java.util.List;
import model.Currency;

public interface CurrencyLoader {
    
    List<Currency> load();
}
