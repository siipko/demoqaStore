package Models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    List<Product> products;

    public Order() {
        this.products = new ArrayList<Product>();
    }

    public Product getProduct(int i) {
        return products.get(i);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product productToAdd) {
        for (Product product : products) {
            if (product.getName().equals(productToAdd.getName())) {
                product.addOneProduct();
                return;
            }
        }
        products.add(productToAdd);
    }

    public BigDecimal getTotalOrderCost() {
        BigDecimal totalOrderCost = new BigDecimal(0);
        for (Product product : products) {
            totalOrderCost = totalOrderCost.add(product.getProductCost());
        }
        return totalOrderCost;
    }

    public int getAmountOfProducts() {
        int amountOfProducts = 0;
        for (Product product : products) {
            amountOfProducts += product.getAmount();
        }
        return amountOfProducts;
    }
}
