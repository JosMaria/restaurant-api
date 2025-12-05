package org.lievasoft.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "ticket_id")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(nullable = false, name = "food_id")
    private Food food;

    private boolean toGo = false;
    private int quantity;

    public Order(boolean toGo, int quantity) {
        this.toGo = toGo;
        this.quantity = quantity;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
