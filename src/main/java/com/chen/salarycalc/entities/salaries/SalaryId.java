package com.chen.salarycalc.entities.salaries;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SalaryId implements Serializable {

    @Column(name = "emp_no")
    @JsonProperty("emp_no")
    private int employeeNumber;

    @Column(name = "from_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    @JsonProperty("from_date")
    private Date fromDate;

}

