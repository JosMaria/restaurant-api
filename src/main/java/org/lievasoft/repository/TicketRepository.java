package org.lievasoft.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.lievasoft.entity.Ticket;

@ApplicationScoped
public class TicketRepository implements PanacheRepository<Ticket> {

}
