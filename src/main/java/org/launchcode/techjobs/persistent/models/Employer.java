package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Employer extends AbstractEntity {

    @NotBlank(message = "Location cannot be empty")
    @Size(max = 255, message = "Location cannot be longer than 255 characters")
    private String location;

    // other specific fields for Employer

    // no-arg constructor required for Hibernate
    public Employer() {
        super();  // calling the no-arg constructor of the superclass
    }

    // public accessor methods
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
