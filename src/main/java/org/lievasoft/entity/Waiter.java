package org.lievasoft.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "waiters")
public class Waiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100)
    private String lastname;

    //TODO: not null
    @Column(name = "phone_number", length = 10)
    private String phoneNumber;

    public Waiter() {
    }

    public Waiter(String name, String lastname, String phoneNumber) {
        this.name = name;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
