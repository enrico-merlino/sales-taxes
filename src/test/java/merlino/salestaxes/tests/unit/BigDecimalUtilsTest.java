package merlino.salestaxes.tests.unit;

import merlino.salestaxes.BigDecimalUtils;
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

    @Test
    public void shouldFormat()
    {
        assertThat(BigDecimalUtils.format(new BigDecimal("236.456")), is("236.46"));
        assertThat(BigDecimalUtils.format(new BigDecimal("-100")), is("-100.00"));
        assertThat(BigDecimalUtils.format(new BigDecimal("99.9")), is("99.90"));
    }
}
