package org.lievasoft.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.lievasoft.entity.Waiter;

@ApplicationScoped
public class WaiterRepository implements PanacheRepository<Waiter> {

    @Transactional
    public void create(Waiter waiter) {
        this.persist(waiter);
    }

    public boolean isRegisteredNumber(String phoneNumber) {
        return find(
                "phoneNumber = :number",
                Parameters.with("number", phoneNumber)
        ).count() > 0;
    }
}
