package lv.polarisit.salarycalc.common;

import lv.polarisit.salarycalc.entities.employees.Employee;
import lv.polarisit.salarycalc.services.EmployeeService;
import org.assertj.core.util.Lists;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class EmployeeControllerTest {

    private static Employee employee;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;


    @BeforeAll
    static void initEmployee() {
        employee = new Employee(1, new Date(1995, 12, 6),
                "Foo", "Bar", "F", new Date(2021, 2, 1), "salary", Lists.newArrayList());
    }

    @Test
    public void testGetAll() throws Exception {
        Mockito.when(employeeService.getAllEmployees()).thenReturn(Lists.newArrayList(this.employee));
        mockMvc.perform(get("/employees/all")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].first_name", Matchers.equalTo("Foo")));
    }

    @Test
    public void testGetSalaries() throws Exception {
        List<Map<String, String>> failingList = new ArrayList<>();
        Map<String, String> employeeOutput = new HashMap<>();
        employeeOutput.put("emp_no", String.valueOf(this.employee.getId()));
        employeeOutput.put("first_name", this.employee.getFirstName());
        employeeOutput.put("last_name", this.employee.getLastName());
        employeeOutput.put("salary", String.valueOf(0));

        failingList.add(employeeOutput);
        Mockito.when(employeeService.getAllEmployeesSalaries()).thenReturn(failingList);

        mockMvc.perform(get("/employees/salaries")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].salary", Matchers.equalTo("0")));
    }

}
