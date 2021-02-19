package com.chen.salarycalc.entities.salaries;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "salaries")
public class Salary {

    @EmbeddedId
    @JsonProperty("salary_pk")
    private SalaryId salaryId;

    @Column(name = "salary")
    private int salary;

    @Column(name = "to_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    @JsonProperty("to_date")
    private Date toDate;

}
