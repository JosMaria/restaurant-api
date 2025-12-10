package org.lievasoft.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.lievasoft.enums.Proportion;

@Entity
@Table(
        name = "foods",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "proportion"})}
)
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Long getId() {
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
