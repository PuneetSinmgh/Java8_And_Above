package java8.src.streamapi.minidomain.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Person {

    String id;
    String name;
    LocalDate dob;              // date of birth
    Address address;
    List<Order> orders;


    public Person(String id, String name, LocalDate dob, Address address, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.orders = orders;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(dob, person.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dob);
    }
}
