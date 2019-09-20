package merlino.salestaxes;

import java.math.BigDecimal;

public class Exempt implements Taxable {
    @Override
    public BigDecimal taxFor(BigDecimal basePrice) {
        return BigDecimal.ZERO;
    }
}
