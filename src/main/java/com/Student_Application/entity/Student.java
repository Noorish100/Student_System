package com.Student_Application.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    @Size(min = 3, message = "First name must be at least 3 characters long")
    private String firstName;

    @Column(nullable = false, length = 50)
    @Size(min = 3, message = "Last name must be at least 3 characters long")
    private String lastName;

    @Column(nullable = false)
    private LocalDate dob;

    @Column(nullable = false)
    @Pattern(regexp = "A|B|C", message = "Section must be A, B, or C")
    private String section;

    @Column(nullable = false)
    @Pattern(regexp = "M|F", message = "Gender must be M or F")
    private String gender;

    @Min(value = 0, message = "Marks cannot be less than 0")
    @Max(value = 100, message = "Marks cannot be more than 100")
    private Integer marks1;

    @Min(value = 0, message = "Marks cannot be less than 0")
    @Max(value = 100, message = "Marks cannot be more than 100")
    private Integer marks2;

    @Min(value = 0, message = "Marks cannot be less than 0")
    @Max(value = 100, message = "Marks cannot be more than 100")
    private Integer marks3;

    private Integer total;
    private Double average;
    private String result;

    // Getters and Setters

    @PrePersist
    @PreUpdate
    public void calculateTotalAndAverage() {
        if (marks1 != null && marks2 != null && marks3 != null) {
            this.total = marks1 + marks2 + marks3;
            this.average = total / 3.0;
            this.result = (marks1 >= 35 && marks2 >= 35 && marks3 >= 35) ? "Pass" : "Fail";
        }
    }
}

