package prototype;

import java.util.ArrayList;
import java.util.List;

public class Order implements ICloneable<Order> {
    public List<Product> products = new ArrayList<>();
    public double shippingCost;
    public double discount;
    public String paymentMethod;

    public void addProduct(Product p) { products.add(p); }

    public Order clone() {
        Order copy = new Order();
        for (Product p : products) copy.addProduct(p.clone());
        copy.shippingCost = this.shippingCost;
        copy.discount = this.discount;
        copy.paymentMethod = this.paymentMethod;
        return copy;
    }

    public void showOrder() {
        System.out.println("Order:");
        for (Product p : products) System.out.println("- " + p.name + " $" + p.price);
        System.out.println("Shipping: $" + shippingCost + ", Discount: $" + discount + ", Payment: " + paymentMethod + "\n");
    }
}
