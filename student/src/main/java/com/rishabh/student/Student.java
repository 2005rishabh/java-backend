package com.rishabh.student;

import org.hibernate.id.IntegralDataTypeHolder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Table(name = "student")
@Entity(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, updatable = false, columnDefinition = "TEXT")
    private String firstName;

    @Column(name = "first_name", nullable = false, updatable = false, columnDefinition = "TEXT")
    private String lastName;

    @Column(name = "email", nullable = false, updatable = false, unique = true)
    private String email;

    @Column(name = "age", nullable = false)
    private Integer age;

}
