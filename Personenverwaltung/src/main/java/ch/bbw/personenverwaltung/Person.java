package ch.bbw.personenverwaltung;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Person {
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastname;
    private String email;
    @Temporal(TemporalType.DATE)
    private LocalDate birthdate;
    private char gender;

    public Person(Long id, String name, String lastname, String email, LocalDate birthdate, char gender) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    public Person() {this(0L, "", "", "", LocalDate.now(), 'x');}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
