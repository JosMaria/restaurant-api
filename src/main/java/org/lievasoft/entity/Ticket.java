package org.lievasoft.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isPaid;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Waiter waiter;

    @OneToMany(mappedBy = "ticket")
    private Set<Order> orders;
}
