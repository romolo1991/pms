package com.test.ssh.dao;

import com.test.ssh.domain.Employee;
import com.test.ssh.domain.modelResult.EmployeeResult;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeDao {
    List<EmployeeResult> getEmployees(Employee employee,int page,int limit);

    String delEmployeeByIds(ArrayList<String> employeeIds);
}
