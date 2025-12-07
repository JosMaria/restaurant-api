package org.lievasoft.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.lievasoft.entity.Ticket;

@ApplicationScoped
public class TicketRepository implements PanacheRepository<Ticket> {

    @Transactional
    public void create(Ticket ticketToPersist) {
        this.persist(ticketToPersist);
    }
}
