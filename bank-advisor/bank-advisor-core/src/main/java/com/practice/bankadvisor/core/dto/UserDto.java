package com.practice.bankadvisor.core.dto;

import com.practice.bankadvisor.core.domain.FamilySituation;
import com.practice.bankadvisor.core.domain.ProfessionalSituation;

import java.time.LocalDate;
import java.util.Objects;

public class UserDto {
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private String gender;
    private FamilySituation famillySituation;
    private ProfessionalSituation professionalSituation;
    private String registrationNumber;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id) &&
                Objects.equals(firstname, userDto.firstname) &&
                Objects.equals(lastname, userDto.lastname) &&
                Objects.equals(birthday, userDto.birthday) &&
                Objects.equals(gender, userDto.gender) &&
                famillySituation == userDto.famillySituation &&
                professionalSituation == userDto.professionalSituation &&
                Objects.equals(registrationNumber, userDto.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, birthday, gender, famillySituation, professionalSituation, registrationNumber);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", famillySituation=" + famillySituation +
                ", professionalSituation=" + professionalSituation +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }
}
