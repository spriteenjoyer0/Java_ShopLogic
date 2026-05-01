package task06.task06;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum Category {
    private final String displayName;
    private final double margin;
    private final double vatRate;
    private final int defaultWarrantyMonths;

    Category(String displayName, double margin, double vatRate, int defaultWarrantyMonths) {
        this.displayName = displayName;
        this.margin = margin;
        this.vatRate = vatRate;
        this.defaultWarrantyMonths = defaultWarrantyMonths;
    }

    public String getDisplayName() { return displayName; }
    public double getMargin() { return margin; }
    public double getVatRate() { return vatRate; }
    public int getDefaultWarrantyMonths() { return defaultWarrantyMonths; }

    public abstract String getDescription();
    public abstract boolean requiresWarranty();
    public abstract int getDefaultWarrantyPeriod();

    public BigDecimal calculateSellingPrice(BigDecimal purchasePrice) {
        BigDecimal priceWithMargin = purchasePrice.multiply(BigDecimal.valueOf(1 + margin));
        BigDecimal grossPrice = priceWithMargin.multiply(BigDecimal.valueOf(1 + vatRate));
        return grossPrice.setScale(2, RoundingMode.HALF_UP);
}
    public BigDecimal calculateVAT(BigDecimal sellingPrice) {
        BigDecimal netPrice = sellingPrice.divide(BigDecimal.valueOf(1 + vatRate), 2, RoundingMode.HALF_UP);
        return sellingPrice.subtract(netPrice);
    }
    public void  displayInfo(){
        System.out.printf("%-15s | Margin: %1.f% | VAT: %1.f% | Warranty: %d months | %s%n",displayName,margin*100,defaultWarrantyMonths, getDescription());


    }

    }

