package com.practice.bankadvisor.core.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_seq_id", allocationSize = 1)
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private String gender;
    @Column(name = "FAMILY_SITUATION")
    @Enumerated(EnumType.STRING)
    private FamilySituation famillySituation;
    @Column(name = "PROFESSIONAL_SITUATION")
    @Enumerated(EnumType.STRING)
    private ProfessionalSituation professionalSituation;
    @Column(name = "REGISTRATION_NUMBER")
    private String registrationNumber;
    @ManyToMany(mappedBy = "users")
    private List<Portfolio> portfolios = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public FamilySituation getFamillySituation() {
        return famillySituation;
    }

    public void setFamillySituation(FamilySituation famillySituation) {
        this.famillySituation = famillySituation;
    }

    public ProfessionalSituation getProfessionalSituation() {
        return professionalSituation;
    }

    public void setProfessionalSituation(ProfessionalSituation professionalSituation) {
        this.professionalSituation = professionalSituation;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public List<Portfolio> getPortfolios() {
        return portfolios;
    }

    public void setPortfolios(List<Portfolio> portfolios) {
        this.portfolios = portfolios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(firstname, user.firstname) &&
                Objects.equals(lastname, user.lastname) &&
                Objects.equals(birthday, user.birthday) &&
                Objects.equals(gender, user.gender) &&
                famillySituation == user.famillySituation &&
                professionalSituation == user.professionalSituation &&
                Objects.equals(registrationNumber, user.registrationNumber) &&
                Objects.equals(portfolios, user.portfolios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, birthday, gender, famillySituation, professionalSituation, registrationNumber, portfolios);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", famillySituation=" + famillySituation +
                ", professionalSituation=" + professionalSituation +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", portfolios=" + portfolios +
                '}';
    }
}
