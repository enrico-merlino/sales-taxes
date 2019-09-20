package merlino.salestaxes.tests.acceptance;

import merlino.salestaxes.*;
import org.junit.Test;
import org.junit.experimental.categories.Categories;

import static merlino.salestaxes.Category.*;
import static merlino.salestaxes.Origin.IMPORTED;
import static merlino.salestaxes.Origin.NATIONAL;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CashDeskTest
{
    @Test
    public void shouldApplyBasicSalesTaxOnCorrectCategories()
    {
        Catalog catalog = new Catalog(
                new Product("book", BOOKS, NATIONAL),
                new Product("chocolate bar", FOOD, NATIONAL),
                new Product("music CD", ENTERTAINMENT, NATIONAL));

        CashDesk cashDesk = new CashDesk(catalog)
                .add(1, "book", "12.49")
                .add(1, "music CD", "14.99")
                .add(1, "chocolate bar", "0.85");

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
        Catalog catalog = new Catalog(
                new Product("imported box of chocolates", FOOD, IMPORTED),
                new Product("imported bottle of perfume", FASHION, IMPORTED));

        CashDesk cashDesk = new CashDesk(catalog)
                .add(1, "imported box of chocolates", "10.00")
                .add(1, "imported bottle of perfume", "47.50");

        assertThat(cashDesk.receipt(), is(String.join("\n",
                "1 imported box of chocolates: 10.50",
                        "1 imported bottle of perfume: 54.65",
                        "Sales Taxes: 7.65",
                        "Total: 65.15")));
    }

    @Test
    public void shouldApplyTaxesOnMixedGoods()
    {
        Catalog catalog = new Catalog(
                new Product("imported box of chocolates", FOOD, IMPORTED),
                new Product("imported bottle of perfume", FASHION, IMPORTED),
                new Product("bottle of perfume", FASHION, NATIONAL),
                new Product("packet of headache pills", MEDICAL, NATIONAL));

        CashDesk cashDesk = new CashDesk(catalog)
                .add(1, "imported bottle of perfume", "27.99")
                .add(1, "bottle of perfume", "18.99")
                .add(1, "packet of headache pills", "9.75")
                .add(1, "imported box of chocolates", "11.25");

        assertThat(cashDesk.receipt(), is(String.join("\n",
                "1 imported bottle of perfume: 32.19",
                "1 bottle of perfume: 20.89",
                "1 packet of headache pills: 9.75",
                "1 imported box of chocolates: 11.85",
                "Sales Taxes: 6.70",
                "Total: 74.68")));
    }

    @Test
    public void shouldConsiderQuantities()
    {
        Catalog catalog = new Catalog(
                new Product("imported bottle of perfume", FASHION, IMPORTED));

        CashDesk cashDesk = new CashDesk(catalog)
                .add(2, "imported bottle of perfume", "10.99");

        assertThat(cashDesk.receipt(), is(String.join("\n",
                "2 imported bottle of perfume: 25.28",
                "Sales Taxes: 3.30",
                "Total: 25.28")));
    }
}
