package com.test.ssh.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    private String employeeId;
    private String employeeName;
    private String employeeNameSpell;
        private String entryTime;
    private int department;
    private int groupOfEmployee;
    private String groupLeader;
    private String isDelete;
    private String remark1;
    private String remark2;

    @Id
    @Column(name = "employeeId")
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "employeeName")
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Basic
    @Column(name = "employeeNameSpell")
    public String getEmployeeNameSpell() {
        return employeeNameSpell;
    }

    public void setEmployeeNameSpell(String employeeNameSpell) {
        this.employeeNameSpell = employeeNameSpell;
    }

    @Basic
    @Column(name = "entryTime")
    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    @Basic
    @Column(name = "department")
    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Basic
    @Column(name = "groupOfEmployee")
    public int getGroupOfEmployee() {
        return groupOfEmployee;
    }

    public void setGroupOfEmployee(int groupOfEmployee) {
        this.groupOfEmployee = groupOfEmployee;
    }

    @Basic
    @Column(name = "groupLeader")
    public String getGroupLeader() {
        return groupLeader;
    }

    public void setGroupLeader(String groupLeader) {
        this.groupLeader = groupLeader;
    }

    @Basic
    @Column(name = "isDelete")
    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @Basic
    @Column(name = "remark1")
    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    @Basic
    @Column(name = "remark2")
    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (department != employee.department) return false;
        if (groupOfEmployee != employee.groupOfEmployee) return false;
        if (employeeId != null ? !employeeId.equals(employee.employeeId) : employee.employeeId != null) return false;
        if (employeeName != null ? !employeeName.equals(employee.employeeName) : employee.employeeName != null)
            return false;
        if (employeeNameSpell != null ? !employeeNameSpell.equals(employee.employeeNameSpell) : employee.employeeNameSpell != null)
            return false;
        if (entryTime != null ? !entryTime.equals(employee.entryTime) : employee.entryTime != null) return false;
        if (groupLeader != null ? !groupLeader.equals(employee.groupLeader) : employee.groupLeader != null)
            return false;
        if (isDelete != null ? !isDelete.equals(employee.isDelete) : employee.isDelete != null) return false;
        if (remark1 != null ? !remark1.equals(employee.remark1) : employee.remark1 != null) return false;
        if (remark2 != null ? !remark2.equals(employee.remark2) : employee.remark2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId != null ? employeeId.hashCode() : 0;
        result = 31 * result + (employeeName != null ? employeeName.hashCode() : 0);
        result = 31 * result + (employeeNameSpell != null ? employeeNameSpell.hashCode() : 0);
        result = 31 * result + (entryTime != null ? entryTime.hashCode() : 0);
        result = 31 * result + department;
        result = 31 * result + groupOfEmployee;
        result = 31 * result + (groupLeader != null ? groupLeader.hashCode() : 0);
        result = 31 * result + (isDelete != null ? isDelete.hashCode() : 0);
        result = 31 * result + (remark1 != null ? remark1.hashCode() : 0);
        result = 31 * result + (remark2 != null ? remark2.hashCode() : 0);
        return result;
    }
}
