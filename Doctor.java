package com.lifecare.Lifecare.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "doctors") // Change "patients" to "doctors"
public class Doctor { // Change "Patient" to "Doctor"

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "Age")
    private int age;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "contactnumber")
    private long mobileno;

    @Column(name = "Address")
    private String address;

    @Column(name = "Specialization") // Change "HealthIssue" to "Specialization"
    private String specialization; // Change "problem" to "specialization"

    @Column(name = "Room_No")
    private int roomno;

    public Doctor() {

    }

    public Doctor(long id, String firstName, int age, String gender, long mobileno, String address, String specialization, int roomno) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.age = age;
        this.gender = gender;
        this.mobileno = mobileno;
        this.address = address;
        this.specialization = specialization;
        this.roomno = roomno;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getMobileno() {
        return mobileno;
    }

    public void setMobileno(long mobileno) {
        this.mobileno = mobileno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getRoomno() {
        return roomno;
    }

    public void setRoomno(int roomno) {
        this.roomno = roomno;
    }
}
