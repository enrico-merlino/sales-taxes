package merlino.salestaxes.tests.unit;

import merlino.salestaxes.Exempt;
import org.junit.Test;

import static java.math.BigDecimal.ZERO;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ExemptTest
{
    @Test
    public void shouldNotApplyTaxOnExentCategories() {
        assertThat(new Exempt().taxFor(null), is(ZERO));
    }
}
