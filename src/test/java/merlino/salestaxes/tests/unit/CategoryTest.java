package merlino.salestaxes.tests.unit;

import merlino.salestaxes.Category;
import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.TEN;
import static java.math.BigDecimal.ZERO;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CategoryTest {
    @Test
    public void shouldNotApplyTaxOnExemptCategories() {
        assertThat(Category.BOOKS.taxFor(TEN), is(ZERO));
        assertThat(Category.FOOD.taxFor(TEN), is(ZERO));
        assertThat(Category.MEDICAL.taxFor(TEN), is(ZERO));
    }

    @Test
    public void shouldApplyTaxOnTaxableCategories() {
        assertThat(Category.ENTERTAINMENT.taxFor(new BigDecimal("20.34")), is(new BigDecimal("2.05")));
        assertThat(Category.FASHION.taxFor(new BigDecimal("542.15")), is(new BigDecimal("54.25")));
    }
}
