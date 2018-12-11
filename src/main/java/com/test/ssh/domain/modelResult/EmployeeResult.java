package com.test.ssh.domain.modelResult;

import com.test.ssh.domain.Employee;

public class EmployeeResult extends Employee {
    private String employeeId;
    private String employeeName;
    private String employeeNameSpell;
    private String entryTime;
    private int department;
    private int groupOfEmployee;
    private String groupLeader;
    private String isDelete;

    //添加字段
    private String departmentName;
    private String groupName;
    private String groupLeaderStr;

    public EmployeeResult() {
    }

    public EmployeeResult(String employeeId, String employeeName, String employeeNameSpell, String entryTime,
                          int department, int groupOfEmployee, String groupLeader, String isDelete,
                          String departmentName, String groupName, String groupLeaderStr) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeNameSpell = employeeNameSpell;
        this.entryTime = entryTime;
        this.department = department;
        this.groupOfEmployee = groupOfEmployee;
        this.groupLeader = groupLeader;
        this.isDelete = isDelete;


        this.departmentName = departmentName;
        this.groupName = groupName;
        this.groupLeaderStr = groupLeaderStr;
    }

    @Override
    public String getEmployeeId() {
        return employeeId;
    }

    @Override
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String getEmployeeName() {
        return employeeName;
    }

    @Override
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String getEmployeeNameSpell() {
        return employeeNameSpell;
    }

    @Override
    public void setEmployeeNameSpell(String employeeNameSpell) {
        this.employeeNameSpell = employeeNameSpell;
    }

    @Override
    public String getEntryTime() {
        return entryTime;
    }

    @Override
    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    @Override
    public int getDepartment() {
        return department;
    }

    @Override
    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public int getGroupOfEmployee() {
        return groupOfEmployee;
    }

    @Override
    public void setGroupOfEmployee(int groupOfEmployee) {
        this.groupOfEmployee = groupOfEmployee;
    }

    @Override
    public String getGroupLeader() {
        return groupLeader;
    }

    @Override
    public void setGroupLeader(String groupLeader) {
        this.groupLeader = groupLeader;
    }

    @Override
    public String getIsDelete() {
        return isDelete;
    }

    @Override
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupLeaderStr() {
        return groupLeaderStr;
    }

    public void setGroupLeaderStr(String groupLeaderStr) {
        this.groupLeaderStr = groupLeaderStr;
    }
}
