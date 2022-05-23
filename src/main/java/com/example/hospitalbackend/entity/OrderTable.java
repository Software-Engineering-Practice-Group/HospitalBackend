package com.example.hospitalbackend.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "orders")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class OrderTable {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.sql.Date date;
    private Integer user_id;
    private Integer doctor_id;
    private Integer state;
    private String info;
    private Integer process;
    private Integer time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        Date utilDate = new java.util.Date(date.getTime());
        return utilDate;
    }

    public void setDate(Date date) {
        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
        this.date = sqlStartDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void setDoctor_id(Integer doctor_id) {
        this.doctor_id = doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getInfo() {
        return info;
    }

    public Integer getTime() {return time;}

    public void setInfo(String info) {
        this.info = info;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
