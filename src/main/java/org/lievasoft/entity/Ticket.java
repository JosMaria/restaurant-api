package org.lievasoft.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Waiter waiter;
}
