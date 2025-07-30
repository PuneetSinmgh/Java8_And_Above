package java8.src.streamapi.minidomain.model;

import java.util.Objects;

public class Address {
    String city;
    String country;
    // ctor/getters/toString...


    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Address address)) return false;
        return Objects.equals(city, address.city) && Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country);
    }
}
