package com.tunkenov.user_registration.dto;

import java.util.Objects;

public class UserDTO {
    private Long id;
    private String first_name;
    private String last_Name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(first_name, userDTO.first_name) && Objects.equals(last_Name, userDTO.last_Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first_name, last_Name);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "first_name='" + first_name + '\'' +
                ", last_Name='" + last_Name + '\'' +
                '}';
    }
}
