import singleton.ConfigurationManager;
import builder.*;
import prototype.*;

public class Main {
    public static void main(String[] args) throws Exception {

        // --- Singleton Test ---
        ConfigurationManager config1 = ConfigurationManager.getInstance();
        config1.set("url", "https://example.com");
        ConfigurationManager config2 = ConfigurationManager.getInstance();
        System.out.println("Singleton test: " + (config1 == config2)); // true
        System.out.println("URL: " + config2.get("url"));

        // --- Builder Test ---
        ReportDirector director = new ReportDirector();

        TextReportBuilder textBuilder = new TextReportBuilder();
        director.constructReport(textBuilder);
        textBuilder.getReport().show();

        HtmlReportBuilder htmlBuilder = new HtmlReportBuilder();
        director.constructReport(htmlBuilder);
        htmlBuilder.getReport().show();

        // --- Prototype Test ---
        Product p1 = new Product("Book", 12.5);
        Product p2 = new Product("Pen", 1.5);

        Order originalOrder = new Order();
        originalOrder.addProduct(p1);
        originalOrder.addProduct(p2);
        originalOrder.shippingCost = 5;
        originalOrder.discount = 2;
        originalOrder.paymentMethod = "Credit Card";

        Order clonedOrder = originalOrder.clone();
        clonedOrder.products.get(0).name = "Notebook"; // меняем только клонированный заказ

        System.out.println("Original Order:");
        originalOrder.showOrder();

        System.out.println("Cloned Order:");
        clonedOrder.showOrder();
    }
}
