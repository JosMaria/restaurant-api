package org.lievasoft.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
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

    @Transactional
    public Food updatePrice(String foodId, double price) {
        var conditional = "price = :price WHERE id = :id";
        var parameters = with("price", price).and("id", foodId);
        int updateRows = update(conditional, parameters);

        if (updateRows == 0) throw new FoodNotFoundException(foodId);
        else return findById(foodId);
    }
}
