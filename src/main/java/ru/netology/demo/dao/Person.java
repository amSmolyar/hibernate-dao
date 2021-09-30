package ru.netology.demo.dao;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(schema = "netology", name = "persons")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Size(max = 100)
    @Cascade(value = CascadeType.MERGE)
    private String name;

    @Column(nullable = false)
    @Size(max = 100)
    @Cascade(value = CascadeType.MERGE)
    private String surname;

    @Column(nullable = false)
    @Min(0)
    @Max(100)
    @Cascade(value = CascadeType.MERGE)
    private Integer age;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "city_of_living", nullable = false)
    @Size(max = 100)
    private String cityOfLiving;

}