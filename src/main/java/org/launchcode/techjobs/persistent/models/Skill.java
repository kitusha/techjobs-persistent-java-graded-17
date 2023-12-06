package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Skill extends AbstractEntity {

    @NotBlank(message = "Description cannot be empty")
    @Size(max = 1000, message = "Description cannot be longer than 1000 characters")
    private String description;

    @ManyToMany(mappedBy = "skills")
    private Set<Job> jobs = new HashSet<>();

    // no-arg constructor required for Hibernate
    public Skill() {
        super();  // calling the no-arg constructor of the superclass
    }

    // public accessor methods
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }
}
