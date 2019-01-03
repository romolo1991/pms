package com.test.ssh.domain;

import javax.persistence.*;

@Entity
public class JobassignmentEntity {
    private int assignmentId;
    private String project;
    private double workload;
    private String monthOfAssignment;
    private String employee;
    private String isDelete;

    @Id
    @Column(name = "assignmentId")
    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    @Basic
    @Column(name = "project")
    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    @Basic
    @Column(name = "workload")
    public double getWorkload() {
        return workload;
    }

    public void setWorkload(double workload) {
        this.workload = workload;
    }

    @Basic
    @Column(name = "monthOfAssignment")
    public String getMonthOfAssignment() {
        return monthOfAssignment;
    }

    public void setMonthOfAssignment(String monthOfAssignment) {
        this.monthOfAssignment = monthOfAssignment;
    }

    @Basic
    @Column(name = "employee")
    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    @Basic
    @Column(name = "isDelete")
    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobassignmentEntity that = (JobassignmentEntity) o;

        if (assignmentId != that.assignmentId) return false;
        if (Double.compare(that.workload, workload) != 0) return false;
        if (project != null ? !project.equals(that.project) : that.project != null) return false;
        if (monthOfAssignment != null ? !monthOfAssignment.equals(that.monthOfAssignment) : that.monthOfAssignment != null)
            return false;
        if (employee != null ? !employee.equals(that.employee) : that.employee != null) return false;
        if (isDelete != null ? !isDelete.equals(that.isDelete) : that.isDelete != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = assignmentId;
        result = 31 * result + (project != null ? project.hashCode() : 0);
        temp = Double.doubleToLongBits(workload);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (monthOfAssignment != null ? monthOfAssignment.hashCode() : 0);
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        result = 31 * result + (isDelete != null ? isDelete.hashCode() : 0);
        return result;
    }
}
