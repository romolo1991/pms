package com.test.ssh.action;

import com.opensymphony.xwork2.ActionContext;
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

    public String login(){
        Employee returnEmployee = employeeService.login(employee);
        if (returnEmployee == null){
            this.addActionError("用户名或密码错误！");
            return "failed";
        }else{
            ActionContext.getContext().getSession().put("user", returnEmployee);
            return "success";
        }
    }

    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
