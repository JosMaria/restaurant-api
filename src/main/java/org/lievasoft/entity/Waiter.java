package org.lievasoft.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "waiters")
public class Waiter {

    @Id
    @UuidGenerator
    private String id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50)
    private String lastname;

    @Column(name = "phone_number", length = 10)
    private String phoneNumber;

    public Waiter() {
    }

    public Waiter(String name, String lastname, String phoneNumber) {
        this.name = name;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
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
