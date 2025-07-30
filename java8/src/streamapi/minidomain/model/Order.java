package java8.src.streamapi.minidomain.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Order {
    String orderId;
    LocalDate placedAt;
    List<OrderItem> items;
    // ctor/getters/toString...


    public Order(String orderId, LocalDate placedAt, List<OrderItem> items) {
        this.orderId = orderId;
        this.placedAt = placedAt;
        this.items = items;
    }

    public String getOrderId() {
        return orderId;
    }

    public LocalDate getPlacedAt() {
        return placedAt;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setPlacedAt(LocalDate placedAt) {
        this.placedAt = placedAt;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Order order)) return false;
        return Objects.equals(orderId, order.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(orderId);
    }
}
