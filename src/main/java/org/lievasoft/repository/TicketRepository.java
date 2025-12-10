//package org.lievasoft.repository;
//
//import io.quarkus.hibernate.orm.panache.PanacheRepository;
//import jakarta.enterprise.context.ApplicationScoped;
//import jakarta.persistence.EntityNotFoundException;
//import jakarta.transaction.Transactional;
//import org.lievasoft.entity.Ticket;
//
//import static io.quarkus.panache.common.Parameters.with;
//
//@ApplicationScoped
//public class TicketRepository implements PanacheRepository<Ticket> {
//
//    @Transactional
//    public void create(Ticket ticketToPersist) {
//        this.persist(ticketToPersist);
//    }
//
//    @Transactional
//    public void updateIsPaid(long id, boolean isPaid) {
//        String statement = "isPaid = :isPaid WHERE id = :id";
//        int updatedRows = update(statement, with("isPaid", isPaid).and("id", id));
//
//        if (updatedRows == 0) throw new EntityNotFoundException(Ticket.class.getName());
//    }
//}
