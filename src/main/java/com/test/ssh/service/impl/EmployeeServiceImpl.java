package com.test.ssh.service.impl;

import com.test.ssh.dao.EmployeeDao;
import com.test.ssh.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }
}
