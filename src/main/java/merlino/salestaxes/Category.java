package merlino.salestaxes;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class Category
{
    private static final BigDecimal ONE_TENTH = new BigDecimal("0.10");

    public static final Category BOOKS = new Category("books", ZERO);
    public static final Category FOOD = new Category("food", ZERO);
    public static final Category MULTIMEDIA = new Category("multimedia", ONE_TENTH);

    String _name;
    private BigDecimal _taxPercent;

    private Category(String name, BigDecimal taxPercent)
    {
        _name = name;
        _taxPercent = taxPercent;
    }

    public BigDecimal taxFor(BigDecimal basePrice)
    {
        return _taxPercent.multiply(basePrice);
    }
}
