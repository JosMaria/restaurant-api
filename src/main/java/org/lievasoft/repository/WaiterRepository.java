package org.lievasoft.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.lievasoft.entity.Waiter;

import static io.quarkus.panache.common.Parameters.with;

@ApplicationScoped
public class WaiterRepository implements PanacheRepositoryBase<Waiter, String> {

    @Transactional
    public void create(Waiter waiter) {
        this.persist(waiter);
    }

    public boolean isRegisteredNumber(String phoneNumber) {
        var parameters = with("number", phoneNumber);
        return find("phoneNumber = :number", parameters).count() > 0;
    }
}
