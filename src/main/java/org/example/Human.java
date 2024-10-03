package org.example;

class Human implements Comparable<Human> {
    private String firstName;
    private String lastName;
    private int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Human other) {
        return this.firstName.compareTo(other.firstName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", Age: " + age;
    }
}