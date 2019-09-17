package merlino.salestaxes;

import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CategoryTest
{
    private BigDecimal ONE_TENTH = new BigDecimal("0.10");

    @Test
    public void shouldApplySalesTaxDependingOnName() {
        assertThat(Category.BOOKS.taxFor(ONE), is(ZERO));
        assertThat(Category.FOOD.taxFor(ONE), is(ZERO));
        assertThat(Category.OTHER.taxFor(ONE), is(ONE_TENTH));
    }
}
