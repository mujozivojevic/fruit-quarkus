package org.rest.services.model;

public class FruitDto {
    private Integer id;
    private String name;
    private String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getId() {return this.id;}

    public void setId(Integer id) {this.id = id;}
}
