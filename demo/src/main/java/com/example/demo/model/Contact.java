package com.example.demo.model;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    Long id;

    @Column(nullable = false)
    String firstName;

    @Column(nullable = false)
    String lastName;

    @Column
    String email;

    @Column
    String phone;

    @Column
    String address;

    @CreationTimestamp
    @Column
    Timestamp created;

    @UpdateTimestamp
    @Column
    Timestamp updated;
}
