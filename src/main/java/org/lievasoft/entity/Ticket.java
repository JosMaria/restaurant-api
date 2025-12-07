package org.lievasoft.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_paid")
    private boolean isPaid;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Waiter waiter;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.PERSIST)
    private final List<Order> orders = new ArrayList<>();

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    public Ticket() {}

    public Ticket(Waiter waiter) {
        this.waiter = waiter;
    }

    public void addOrders(List<Order> orders) {
        this.orders.addAll(orders);
        orders.forEach(order -> order.setTicket(this));
    }

    @PrePersist
    private void onCreated() {
        createdAt = LocalDateTime.now();
    }
}
