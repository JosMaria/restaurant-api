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

    private int quantity;
    private boolean toGo = false;

    public Order() {}

    public Order(Food food, int quantity, boolean toGo) {
        this.food = food;
        this.quantity = quantity;
        this.toGo = toGo;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
