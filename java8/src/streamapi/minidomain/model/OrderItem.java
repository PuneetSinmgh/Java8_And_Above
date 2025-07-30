package java8.src.streamapi.minidomain.model;

import java.util.List;
import java.util.Objects;

public class OrderItem {
    String sku;
    String title;
    int quantity;
    double unitPrice;
    List<String> tags; // e.g. ["electronics","sale"]
    // ctor/getters/toString...


    public OrderItem(String sku, String title, int quantity, double unitPrice, List<String> tags) {
        this.sku = sku;
        this.title = title;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.tags = tags;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OrderItem orderItem)) return false;
        return Double.compare(unitPrice, orderItem.unitPrice) == 0 && Objects.equals(sku, orderItem.sku) && Objects.equals(title, orderItem.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, title, unitPrice);
    }
}
