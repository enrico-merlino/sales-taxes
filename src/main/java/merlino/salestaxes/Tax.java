package merlino.salestaxes;

import java.math.BigDecimal;

public interface Tax
{
    BigDecimal taxFor(BigDecimal basePrice);
}
