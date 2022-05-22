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
import java.sql.Date;

@Data
@Entity
@Table(name = "schedule")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class ShiftSchedule {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private Integer doctor_id;
    private String doctor_name;
//    private Integer doctor_capacity;
//    private Integer DoctorState;
    private Integer time1;
    private Integer time2;
    private Integer time3;
    private Integer time4;

    /*@Column注解用来标识实体类中属性与数据表中字段的对应关系*/
    /*@Transient :在实体类（pojo）属性上使用、表示数据库表中没有这个字段就忽略。*/

//    public Integer getDoctorState() {return DoctorState;}
//    public void setDoctorState(Integer doctorState) {DoctorState = doctorState;}
//    public Integer getDoctor_capacity() {return doctor_capacity;}
//    public void setDoctor_capacity(Integer doctor_capacity) {this.doctor_capacity = doctor_capacity;}

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Integer doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public Integer getTime1() {
        return time1;
    }

    public void setTime1(Integer time1) {
        this.time1 = time1;
    }

    public Integer getTime2() {
        return time2;
    }

    public void setTime2(Integer time2) {
        this.time2 = time2;
    }
    public Integer getTime3() {
        return time3;
    }

    public void setTime3(Integer time3) {
        this.time3 = time3;
    }
    public Integer getTime4() {
        return time4;
    }

    public void setTime4(Integer time4) {
        this.time4 = time4;
    }
}
