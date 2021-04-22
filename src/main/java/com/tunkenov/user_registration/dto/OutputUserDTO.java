package com.tunkenov.user_registration.dto;

import java.util.Objects;

public class OutputUserDTO {

    private Long id;
    private String firstName;
    private String lastName;

    public OutputUserDTO(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutputUserDTO outputUserDTO = (OutputUserDTO) o;
        return Objects.equals(firstName, outputUserDTO.firstName) && Objects.equals(lastName, outputUserDTO.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "UserDTO{first_name='" + firstName + '\'' + ", last_Name='" + lastName + '\'' + '}';
    }
}
