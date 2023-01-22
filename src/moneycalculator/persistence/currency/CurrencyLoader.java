package moneycalculator.persistence.currency;

import java.util.List;
import moneycalculator.model.Currency;

public interface CurrencyLoader {
    
    List<Currency> load();
}
