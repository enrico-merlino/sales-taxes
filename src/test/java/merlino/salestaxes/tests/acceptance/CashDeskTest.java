package merlino.salestaxes.tests.acceptance;

import merlino.salestaxes.CashDesk;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CashDeskTest
{
    @Test
    public void shouldApplyBasicSalesTaxOnCorrectCategories()
    {
        CashDesk cashDesk = new CashDesk()
                .add("book", "12.49")
                .add("music CD", "14.99")
                .add("chocolate bar", "0.85");

        assertThat(cashDesk.receipt(), is(String.join("\n",
                "1 book: 12.49",
                "1 music CD: 16.49",
                "1 chocolate bar: 0.85",
                "Sales Taxes: 1.50",
                "Total: 29.83")));
    }

    @Test
    public void shouldApplyImportDutyOnImportedGoods()
    {
        CashDesk cashDesk = new CashDesk()
                .add("imported box of chocolates", "10.00")
                .add("imported bottle of perfume", "47.50");

        assertThat(cashDesk.receipt(), is(String.join("\n",
                "1 imported box of chocolates: 10.50",
                        "1 imported bottle of perfume: 54.65",
                        "Sales Taxes: 7.65",
                        "Total: 65.15")));
    }

    @Test
    public void shouldApplyTaxesOnMixedGoods()
    {
        CashDesk cashDesk = new CashDesk()
                .add("imported bottle of perfume", "27.99")
                .add("bottle of perfume", "18.99")
                .add("packet of headache pills", "9.75")
                .add("imported box of chocolates", "11.25");

        assertThat(cashDesk.receipt(), is(String.join("\n",
                "1 imported bottle of perfume: 32.19",
                "1 bottle of perfume: 20.89",
                "1 packet of headache pills: 9.75",
                "1 imported box of chocolates: 11.85",
                "Sales Taxes: 6.70",
                "Total: 74.68")));
    }
}
