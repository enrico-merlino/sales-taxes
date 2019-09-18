package merlino.salestaxes;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static java.math.BigDecimal.ZERO;

public class BigDecimalUtils
{
    public static BigDecimal sum(Stream<BigDecimal> values)
    {
        return values.reduce(ZERO, (a, b) -> a.add(b));
    }

    public static String format(BigDecimal value)
    {
        return String.format("%,.2f", value);
    }
}
