package tech.araopj.fitcheck.mvvm.model;

import java.util.Objects;
import tech.araopj.fitcheck.mvvm.view.MainActivity;

public class UserProfile {

    private int id;
    private String name;
    private byte age;
    private double height; // in meters
    private double weight; // in kilograms
    private Gender gender;

    public UserProfile() {
    }

    @SuppressWarnings("unchecked")
    public UserProfile(String name, byte age, double height, double weight, Gender gender) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.id = MainActivity.getService().getNewId((Class<UserProfile>) getClass());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    // methods to calculate BMI (Body Mass Index) and BMR (Basal Metabolic Rate)
    public double calculateBMI() {
        return weight / (height * height);
    }

    public double calculateBMR() {
        if (gender.equals(Gender.MALE)) {
            return 88.362 + (13.397 * weight) + (4.799 * height * 100) - (5.677 * age);
        } else {
            return 447.593 + (9.247 * weight) + (3.098 * height * 100) - (4.330 * age);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return age == that.age && Double.compare(that.height, height) == 0 && Double.compare(that.weight, weight) == 0 && Objects.equals(name, that.name) && gender == that.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, height, weight, gender);
    }

    public int getId() {
        return id;
    }
}
