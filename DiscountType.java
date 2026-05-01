package task06.task06;

import java.math.BigDecimal;

public enum DiscountType {
    NONE(0),
    SALE_5(5),
    SALE_10(10),
    SALE_15(15),
    SALE_20(20),
    SALE_30(30),
    SALE_50(50),
    SALE_70(70);
    private int  discountPercent;
    DiscountType(int discountPercent){
        this.discountPercent=discountPercent;
    }
    public int getDiscountPercent(){
        return discountPercent;
    }
    public BigDecimal applyDiscount(int discountPercent){
        if(this.discountPercent==0){
            return price;
        }
        BigDecimal multiplier = BigDecimal.valueOf(1 - discountPercent/100.0);
        return
    }
    @Override
        public String toString() {
            if (discountPercent == 0) {
                return "No discount";
            }
            return "-" + discountPercent + "%";
    }
}
