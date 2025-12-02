package org.lievasoft.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.lievasoft.entity.Food;
import org.lievasoft.enums.Proportion;
import org.lievasoft.exception.FoodNotFoundException;
import org.lievasoft.metric.MetricService;

import static io.quarkus.panache.common.Parameters.with;

@ApplicationScoped
public class FoodRepository implements PanacheRepository<Food> {

    private final MetricService metric;

    public FoodRepository(MetricService metric) {
        this.metric = metric;
    }

    @Transactional
    public void create(Food food) {
        metric.measureInsert(() -> this.persist(food));
    }

    @Transactional
    public Food updatePrice(long foodId, double price) {
        int updateRows = update("price = :price WHERE id = :id",
                with("price", price).and("id", foodId));

        if (updateRows == 0) throw new FoodNotFoundException(foodId);

        return findById(foodId);
    }

    public boolean exists(String name, Proportion proportion) {
        return find(
                "name = :name AND proportion = :proportion",
                with("name", name).and("proportion", proportion)
        ).count() > 0;
    }
}
