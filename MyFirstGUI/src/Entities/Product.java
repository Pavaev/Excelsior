package Entities;

/**
 * Created by Daniel Shchepetov on 13.11.2015.
 */
public class Product {
    private int price;
    private String name;
    private int id;
    private int weight;
    private String manufacturer;
    private String category;

public Product(String name, int price, String category, int weight, String manufacturer){
    this.name = name;
    this.price = price;
    this.category = category;
    this.weight = weight;
    this.manufacturer = manufacturer;
}

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
