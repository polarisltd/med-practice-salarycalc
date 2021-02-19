package com.chen.salarycalc.entities.employees;

import com.chen.salarycalc.entities.salaries.Salary;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "emp_no")
    @JsonProperty("emp_no")
    private int id;

    @Column(name = "birth_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    @JsonProperty("birth_date")
    private Date birthDate;

    @Column(name = "first_name")
    @JsonProperty("first_name")
    private String firstName;

    @Column(name = "last_name")
    @JsonProperty("last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "hire_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    @JsonProperty("hire_date")
    private Date hireDate;

    @Column(name = "emp_type")
    private String type;

    @OneToMany(targetEntity = Salary.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_no", insertable=false, updatable=false)
    private List<Salary> salaries;
}
