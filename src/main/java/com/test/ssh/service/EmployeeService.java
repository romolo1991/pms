package com.test.ssh.service;

import com.test.ssh.domain.Employee;
import com.test.ssh.domain.modelResult.EmployeeResult;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService{
    List<EmployeeResult> getEmployees(Employee employee, int page, int limit);

    String delEmployeeByIds(ArrayList<String> employeeIds);
}
