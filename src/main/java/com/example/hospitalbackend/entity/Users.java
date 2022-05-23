package com.example.hospitalbackend.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
@Data
@Entity
@Table(name="users")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})        //不太理解
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "username", nullable = false, length = 6)
    private String username;
    @Basic
    @Column(name = "password", nullable = false, length = 10)
    private String password;
    @Basic
    @Column(name = "identity", nullable = false)
    private int identity;
    @Basic
    @Column(name = "Gender", nullable = false)
    private int Gender;
    @Basic
    @Column(name = "tel", nullable = false, length = 11)
    private String tel;
    @Basic
    @Column(name = "mail", nullable = false, length = 255)
    private String mail;
    @Basic
    @Column(name = "weiyue", nullable = true)
    private Integer weiyue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public Integer getGender() {
        return Gender;
    }


    public void setGender(Integer gender) {
        this.Gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getWeiyue() {
        return weiyue;
    }

    public void setWeiyue(Integer weiyue) {
        this.weiyue = weiyue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id && identity == users.identity && Objects.equals(username, users.username) && Objects.equals(password, users.password) && Objects.equals(Gender, users.Gender) && Objects.equals(tel, users.tel) && Objects.equals(mail, users.mail) && Objects.equals(weiyue, users.weiyue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, identity, Gender, tel, mail, weiyue);
    }
}
