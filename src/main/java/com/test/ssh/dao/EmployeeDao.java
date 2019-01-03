package com.test.ssh.dao;

import com.test.ssh.domain.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeDao {
    List getEmployees(Employee employee, int page, int limit);

    Employee getEmployeeById(String employeeId);

    String delEmployeeByIds(ArrayList<String> employeeIds);

    String addEmployee(Employee employee);

    String importEmployees(List<Employee> employeeList);

    int getEmployeesCount(Employee employee);
}
