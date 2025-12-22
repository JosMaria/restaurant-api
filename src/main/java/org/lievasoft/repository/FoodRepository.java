package org.lievasoft.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.lievasoft.entity.Food;
import org.lievasoft.enums.Proportion;
import org.lievasoft.exception.FoodNotFoundException;

import static io.quarkus.panache.common.Parameters.with;

@ApplicationScoped
public class FoodRepository implements PanacheRepositoryBase<Food, String> {

    public boolean exists(String name, Proportion proportion) {
        var conditional = "name = :name AND proportion = :proportion";
        var parameters = with("name", name).and("proportion", proportion);
        return find(conditional, parameters).count() > 0;
    }

    @Transactional
    public void create(Food food) {
        this.persist(food);
    }

    public boolean exists(String id) {
        return find("id = :id", with("id", id)).count() > 0;
    }

    @Transactional
    public Food updatePrice(String foodId, double price) {
        int updateRows = update("price = :price WHERE id = :id",
                with("price", price).and("id", foodId));

        if (updateRows == 0) throw new FoodNotFoundException(foodId);

        return findById(foodId);
    }
}
