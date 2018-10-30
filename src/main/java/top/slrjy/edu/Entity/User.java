package top.slrjy.edu.Entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;

@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;
    @NotBlank (message = "用户名不能为空")
    @Column(name = "name")
    private String name;
    @NotBlank(message = "电话不能为空")
    @Length(min = 6, max = 32,message = "电话长度不对")
    @Column(name = "telNumber")
    private String telNumber;

    @Column(name = "address")
    private String address;

    @Column( name = "room")
    private String room;
    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}