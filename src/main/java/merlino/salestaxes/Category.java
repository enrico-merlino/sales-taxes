package merlino.salestaxes;

import java.math.BigDecimal;

public class Category implements Taxable {
    public static final Category BOOKS = new Category(new Exempt());
    public static final Category FOOD = new Category(new Exempt());
    public static final Category MEDICAL = new Category(new Exempt());
    public static final Category ENTERTAINMENT = new Category(new BasicSalesTax());
    public static final Category FASHION = new Category(new BasicSalesTax());

    private Taxable _taxable;

    public Category(Taxable taxable)
    {
        _taxable = taxable;
    }

    @Override
    public BigDecimal taxFor(BigDecimal basePrice) {
        return _taxable.taxFor(basePrice);
    }
}
