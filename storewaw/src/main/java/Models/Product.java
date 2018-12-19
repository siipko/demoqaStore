package Models;

import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private int quantity;

    public Product(String name, BigDecimal price) {
        this(name, price, 1);
    }

    public Product(String name, BigDecimal price, int quantity) {
        this(name, price, quantity, price.multiply(new BigDecimal(quantity)));
    }

    public Product(String name, BigDecimal price, int quantity, BigDecimal totalPrice) {
        this.name = name.replace("–", "-");
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public void addOneProduct() {
        quantity++;
        totalPrice = price.multiply(new BigDecimal(quantity));
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

}
