package org.lievasoft.entity;

import jakarta.persistence.*;
import org.lievasoft.enums.Proportion;

import java.util.Set;

@Entity
@Table(name = "foods", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "proportion"})})
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

    @OneToMany(mappedBy = "food")
    private Set<Order> orders;
}
