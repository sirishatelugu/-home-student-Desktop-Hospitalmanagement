package com.lifecare.Lifecare.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "staff") // Change "patients" to "staff"
public class Staff { // Change "Patient" to "Staff"

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false) // Change "first_name" to "name"
    private String name; // Change "firstName" to "name"

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "mobileno") // Change "contactnumber" to "mobileno"
    private long mobileNo; // Change "mobileno" to "mobileNo"

    @Column(name = "address")
    private String address;

    @Column(name = "department") // Change "HealthIssue" to "department"
    private String department; // Change "healthIssue" to "department"

    @Column(name = "room_no") // Change "Room_No" to "room_no"
    private int roomNo; // Change "roomno" to "roomNo"

    public Staff() {

    }

    public Staff(Long id, String name, int age, String gender, long mobileNo, String address, String department, int roomNo) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.mobileNo = mobileNo;
        this.address = address;
        this.department = department;
        this.roomNo = roomNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }
}
