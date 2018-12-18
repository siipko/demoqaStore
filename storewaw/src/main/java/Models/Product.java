package Models;

import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;
    private int amount;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
        amount = 1;
    }

    public void addOneProduct() {
        amount++;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public BigDecimal getProductCost() {
        return price.multiply(new BigDecimal(amount));
    }

}
