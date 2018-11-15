package com.test.ssh.service.impl;

import com.test.ssh.dao.EmployeeDao;
import com.test.ssh.domain.Employee;
import com.test.ssh.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Override
    public Employee login(Employee employee) {
        return employeeDao.login(employee);
    }

    public void setEmployeeDao(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }
}
