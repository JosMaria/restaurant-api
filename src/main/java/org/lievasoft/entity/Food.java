package org.lievasoft.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;
import org.lievasoft.enums.Proportion;

@Entity
@Table(
        name = "foods",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "proportion"})}
)
public class Food {

    @Id
    @UuidGenerator
    private String id;

    @Column(nullable = false, length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Proportion proportion;

    private Double price;

    public Food() {
    }

    public Food(String name, Proportion proportion, double price) {
        this.name = name;
        this.proportion = proportion;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Proportion getProportion() {
        return proportion;
    }

    public Double getPrice() {
        return price;
    }
}
