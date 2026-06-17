package org.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "persons")
@Getter@Setter
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    PassPort passPort = new PassPort();

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, PassPort passPort) {
        this.name = name;
        this.passPort = passPort;
    }

    public void setPassPort(PassPort passPort) {
        this.passPort = passPort;
        if(passPort != null) {
            passPort.setPerson(this);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passPort=" + passPort +
                '}';
    }
}
