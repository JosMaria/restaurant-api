package org.lievasoft.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.lievasoft.entity.Food;
import org.lievasoft.enums.Proportion;

import static io.quarkus.panache.common.Parameters.with;

@ApplicationScoped
public class FoodRepository implements PanacheRepository<Food> {

    @Transactional
    public void create(Food food) {
        this.persist(food);
    }

    @Transactional
    public Food updatePrice(long foodId, double price) {
        int updateRows = update("price = :price WHERE id = :id",
                with("price", price).and("id", foodId));

        if (updateRows == 0)
            throw new EntityNotFoundException("Food with id " + foodId + " not found");

        return findById(foodId);
    }

    public boolean exists(String name, Proportion proportion) {
        return find(
                "name = :name AND proportion = :proportion",
                with("name", name).and("proportion", proportion)
        ).count() > 0;
    }
}
