package merlino.salestaxes;

import java.math.BigDecimal;

public class Origin implements Taxable {
    public static final Origin NATIONAL = new Origin(new Exempt());
    public static final Origin IMPORTED = new Origin(new ImportDuty());

    private Taxable _taxable;

    public Origin(Taxable taxable)
    {
        _taxable = taxable;
    }

    @Override
    public BigDecimal taxFor(BigDecimal basePrice) {
        return _taxable.taxFor(basePrice);
    }
}
