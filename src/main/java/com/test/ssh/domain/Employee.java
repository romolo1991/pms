package com.test.ssh.domain;

public class Employee {
    private String employeeId;
    private String employeeName;
    private String entryTime;
    private int department;
    private int groupOfEmployee;
    private char groupLeader;
    private char isDelete;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getGroupOfEmployee() {
        return groupOfEmployee;
    }

    public void setGroupOfEmployee(int groupOfEmployee) {
        this.groupOfEmployee = groupOfEmployee;
    }

    public char getGroupLeader() {
        return groupLeader;
    }

    public void setGroupLeader(char groupLeader) {
        this.groupLeader = groupLeader;
    }

    public char getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(char isDelete) {
        this.isDelete = isDelete;
    }
}
