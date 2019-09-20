package merlino.salestaxes;

import java.math.BigDecimal;

public interface Taxable {
    BigDecimal taxFor(BigDecimal basePrice);
}
