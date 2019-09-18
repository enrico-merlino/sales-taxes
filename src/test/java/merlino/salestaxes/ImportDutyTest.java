package merlino.salestaxes;

import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ImportDutyTest
{
    private BigDecimal ONE_TWENTIETH = new BigDecimal("0.05");

    @Test
    public void shouldApplySalesTaxDependingOnName()
    {
        assertThat(new ImportDuty().taxFor(ONE), is(ONE_TWENTIETH));
    }
}
