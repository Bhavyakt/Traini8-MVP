package com.project.traini8.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Entity  // Marks this class as a database entity (table)
@Data // Generates getters, setters, equals, hashcode, toString
@NoArgsConstructor // Generates a no-args constructor
@AllArgsConstructor // Generates a constructor with all fields
@Table(name = "training_centers")  // Sets table name in database

public class TrainingCenter {
    @Id // Marks this field as the Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generates a unique ID
    private Long id;

    @NotBlank(message= "Center name is required") // Ensures that centerName is not empty.
    @Size(max = 40,message ="Center Name must be less than 40 characters") // Limits the name to 40 characters.
    private String centerName;


    @NotBlank(message= "Center code is required")
    @Size(min = 12, max = 12, message = "Center Code must be exactly 12 characters")
    private String centerCode;


    @Embedded // Embeds Address class into TrainingCenter
    private Address address;

    private Integer studentCapacity;

    @ElementCollection // Creates a separate table for storing list elements
    private List<String> coursesOffered;

    private Instant createdOn;

    @Email(message = "Invalid email format")
    private String contactEmail;

    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number")
    private String contactPhone;

    @PrePersist // Runs before inserting data into the database
    public void prePersist()
    {
        this.createdOn= Instant.now();
    }


}
