package com.test.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.test.ssh.domain.Employee;
import com.test.ssh.service.EmployeeService;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{

    private Employee employee = new Employee();

    private EmployeeService employeeService;

    @Override
    public Employee getModel() {
        return employee;
    }

    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
