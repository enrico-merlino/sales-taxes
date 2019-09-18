package merlino.salestaxes;

import org.junit.Test;

import java.math.BigDecimal;

import static java.util.Arrays.stream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BigDecimalUtilsTest
{
    @Test
    public void shouldSumValues()
    {
        BigDecimal[] values = {
                new BigDecimal("11.23"),
                new BigDecimal("-3.45"),
                new BigDecimal("10.10")
        };

        assertThat(BigDecimalUtils.sum(stream(values)), is(new BigDecimal("17.88")));
    }
}
