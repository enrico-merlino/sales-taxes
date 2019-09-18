package merlino.salestaxes;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class Category extends Tax
{
    private static final BigDecimal ONE_TENTH = new BigDecimal("0.10");

    public static final Category BOOKS = new Category("books", ZERO);
    public static final Category FOOD = new Category("food", ZERO);
    public static final Category OTHER = new Category("other", ONE_TENTH);

    private BigDecimal _taxPercent;

    private Category(String id, BigDecimal taxPercent)
    {
        _taxPercent = taxPercent;
    }

    @Override
    protected BigDecimal TaxPercent()
    {
        return _taxPercent;
    }
}
