package ru.netology.demo.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(schema = "netology", name = "persons")
public class Person implements Serializable {
    @Id
    @Column(nullable = false)
    @Size(max = 100)
    @Cascade(value = CascadeType.MERGE)
    private String name;

    @Id
    @Column(nullable = false)
    @Size(max = 100)
    @Cascade(value = CascadeType.MERGE)
    private String surname;

    @Id
    @Column(nullable = false)
    @Min(0)
    @Max(100)
    @Cascade(value = CascadeType.MERGE)
    private int age;

    @Column(nullable = false, unique = true)
    private String phone_number;

    @Column(nullable = false)
    @Size(max = 100)
    private String city_of_living;

}
