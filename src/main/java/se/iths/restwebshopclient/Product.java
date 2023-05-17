package se.iths.restwebshopclient;

public class Product {
    Long id;
    String name;
    Category category;
    Double price;

    public Product() {

    }

    public Product(String name, Category category, Double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + ", Namn: " + getName() + ", Pris: " + getPrice() + "\n";
    }

}