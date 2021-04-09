package org.rest.repository.entity;

import javax.persistence.*;

@Entity
@Table(schema = "fruit", name ="FRUIT")
public class Fruit extends ModelObject{

    @SequenceGenerator(
            name="fruitSeq",
            sequenceName = "FRUIT_SEQ",
            schema = "fruit",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fruitSeq")
    @Id
    @Column(name ="ID", nullable = false)
    private Integer id;

    private String name;
    private String price;

    public void setId(Integer id) {
        this.id = id;
    }

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

    @Override
    public Integer getId() {
        return this.id;
    }
}
