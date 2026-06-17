package org.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "passports")
@Getter
@Setter
@NoArgsConstructor
public class PassPort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "passport_number", nullable = false)
    private String passportNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", unique = true)
    private Person person;

    public PassPort(String passport_number) {
        this.passportNumber = passport_number;
    }

    public PassPort(String passport_number, Person person) {
        this.passportNumber = passport_number;
        this.person = person;
    }

    @Override
    public String toString() {
        return "PassPort{" +
                "id=" + id +
                ", passport_number='" + passportNumber + '\'' +
                ", person=" + person +
                '}';
    }
}
