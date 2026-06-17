package org.example.jpa;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("TRUCK")
@Setter
@Getter
public class Truck extends Vehicle{
    private double payloadCapacity;
}
