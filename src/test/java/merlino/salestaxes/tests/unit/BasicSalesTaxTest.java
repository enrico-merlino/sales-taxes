package merlino.salestaxes.tests.unit;

import merlino.salestaxes.BasicSalesTax;
import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BasicSalesTaxTest
{
    private BigDecimal ONE_TENTH = new BigDecimal("0.10");

    @Test
    public void shouldApplySalesTaxDependingOnName()
    {
        assertThat(new BasicSalesTax().taxFor(ONE), is(ONE_TENTH));
    }
}
