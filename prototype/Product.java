package prototype;

public class Product implements ICloneable<Product> {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product clone() {
        return new Product(this.name, this.price);
    }
}
