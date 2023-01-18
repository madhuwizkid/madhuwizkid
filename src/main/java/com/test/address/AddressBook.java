package com.test.address;

import java.time.LocalDate;
import java.util.Objects;

public class AddressBook {
    private String name;
    private String gender;
    private LocalDate dob;

    public AddressBook(String name, String gender, LocalDate dob) {
        this.name = name.trim();
        this.gender = gender;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBook that = (AddressBook) o;
        return name.equals(that.name) &&
               gender.equals(that.gender) &&
               dob.equals(that.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, dob);
    }

}
