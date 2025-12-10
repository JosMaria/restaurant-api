package org.lievasoft.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.lievasoft.entity.Waiter;

import static io.quarkus.panache.common.Parameters.with;

@ApplicationScoped
public class WaiterRepository implements PanacheRepository<Waiter> {

    @Transactional
    public void create(Waiter waiter) {
        this.persist(waiter);
    }

    public boolean exists(long id) {
        return find("id = :id", with("id", id))
                .count() > 0;
    }

    public boolean isRegisteredNumber(String phoneNumber) {
        return find(
                "phoneNumber = :number",
                with("number", phoneNumber)
        ).count() > 0;
    }
}
