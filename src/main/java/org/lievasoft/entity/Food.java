package org.lievasoft.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;
import org.lievasoft.enums.Proportion;
import org.lievasoft.resource.dto.food.PriceUpdateResponse;

@Entity
@Table(
        name = "foods",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "proportion"})}
)
@NamedNativeQuery(
        name = "Food.findPrice",
        query = """
                    SELECT id, price, name, proportion
                    FROM foods
                    WHERE id = :foodId
                """,
        resultSetMapping = "FoodPriceMapping"
)
@SqlResultSetMapping(
        name = "FoodPriceMapping",
        classes = @ConstructorResult(
                targetClass = PriceUpdateResponse.class,
                columns = {
                        @ColumnResult(name = "id", type = String.class),
                        @ColumnResult(name = "price", type = Double.class),
                        @ColumnResult(name = "name", type = String.class),
                        @ColumnResult(name = "proportion", type = Proportion.class)
                }
        )
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
