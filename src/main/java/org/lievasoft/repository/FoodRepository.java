package org.lievasoft.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.lievasoft.entity.Food;
import org.lievasoft.enums.Proportion;

@ApplicationScoped
public class FoodRepository implements PanacheRepository<Food> {

    @Transactional
    public void create(Food food) {
        this.persist(food);
    }

    public boolean exists(String name, Proportion proportion) {
        return find(
                "name = :name AND proportion = :proportion",
                Parameters.with("name", name).and("proportion", proportion)
        ).count() > 0;
    }
}
