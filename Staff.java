package com.lifecare.Lifecare.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "staff")
public class Staff { 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false) 

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "mobileno") 
    private long mobileNo; 

    @Column(name = "address")
    private String address;

    @Column(name = "department") 
    private String department; 

    @Column(name = "room_no") 
    private int roomNo; 

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
