package ru.job4j.oop;

import java.util.Objects;

public final class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int price() {
        return price - discount();
    }

    public int discount() {
        return 0;
    }

    public String label() {
        return name + " " + price();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return price == product.price && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}