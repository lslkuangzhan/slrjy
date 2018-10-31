package top.slrjy.edu.Entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Table(name = "login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;
    @NotBlank(message = "用户名不能为空")
    private String account;
    @NotBlank(message = "电话不能为空")
    @Length(min = 6, max = 32,message = "电话长度不对")
    private String password;
    @NotBlank(message = "角色不能为空")
    private String role;

    @NotBlank (message = "用户名不能为空")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "电话不能为空")
    @Length(min = 6, max = 32,message = "电话长度不对")
    private String telNumber;

    private String address;


    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
