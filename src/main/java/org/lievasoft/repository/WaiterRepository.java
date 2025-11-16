package org.lievasoft.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.lievasoft.entity.Waiter;

@ApplicationScoped
public class WaiterRepository implements PanacheRepository<Waiter> {

    @Transactional
    public Waiter create(Waiter waiter) {
        this.persist(waiter);
        return waiter;
    }
}
