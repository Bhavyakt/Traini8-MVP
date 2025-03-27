package com.project.traini8.model;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable  // Indicates that this class will be embedded in another entity
@Data
@NoArgsConstructor@AllArgsConstructor
public class Address {
    @NotBlank(message = "Detailed address is required")
    private String detailedAddress;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "Pincode is required")
    private String pincode;

}
