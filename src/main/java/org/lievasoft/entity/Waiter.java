package org.lievasoft.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "waiters")
public class Waiter {

    @Id
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100)
    private String lastname;

    @Column(name = "phone_number", length = 10)
    private String phoneNumber;
}
