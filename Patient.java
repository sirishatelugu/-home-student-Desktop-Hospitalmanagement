package com.lifecare.Lifecare.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "patients") // Change "doctors" to "patients"
public class Patient { // Change "Doctor" to "Patient"

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

    @Column(name = "HealthIssue") // Change "Specialization" to "HealthIssue"
    private String healthIssue; // Change "specialization" to "problem"

    @Column(name = "Room_No")
    private int roomno;

    public Patient() {

    }

    public Patient(long id, String firstName, int age, String gender, long mobileno, String address, String healthIssue, int roomno) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.age = age;
        this.gender = gender;
        this.mobileno = mobileno;
        this.address = address;
        this.healthIssue = healthIssue;
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

    public String getHealthIssue() {
        return healthIssue;
    }

    public void setHealthIssue(String healthIssue) {
        this.healthIssue = healthIssue;
    }

    public int getRoomno() {
        return roomno;
    }

    public void setRoomno(int roomno) {
        this.roomno = roomno;
    }
}
