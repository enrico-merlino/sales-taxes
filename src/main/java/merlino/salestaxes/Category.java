package merlino.salestaxes;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class Category implements Tax
{
    private static final BigDecimal ONE_TENTH = new BigDecimal("0.10");

    public static final Category BOOKS = new Category("books", ZERO);
    public static final Category FOOD = new Category("food", ZERO);
    public static final Category OTHER = new Category("other", ONE_TENTH);

    String _id;
    private BigDecimal _taxPercent;

    private Category(String id, BigDecimal taxPercent)
    {
        _id = id;
        _taxPercent = taxPercent;
    }

    @Override
    public BigDecimal taxFor(BigDecimal basePrice)
    {
        return _taxPercent.multiply(basePrice);
    }

    public String id()
    {
        return _id;
    }
}
