package com.test.ssh.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Project {
    private String projectId;
    private String projectName;
    private String projectType;
    private String leader;
    private int hostGroup;
    private String projectManager;
    private double efficiency;
    private double functionPoint;
    private double workload;
    private String startTime;
    private String endTime;
    private String isDelete;

    @Id
    @Column(name = "projectId")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "projectName")
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Basic
    @Column(name = "projectType")
    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    @Basic
    @Column(name = "leader")
    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    @Basic
    @Column(name = "hostGroup")
    public int getHostGroup() {
        return hostGroup;
    }

    public void setHostGroup(int hostGroup) {
        this.hostGroup = hostGroup;
    }

    @Basic
    @Column(name = "projectManager")
    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    @Basic
    @Column(name = "efficiency")
    public double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }

    @Basic
    @Column(name = "functionPoint")
    public double getFunctionPoint() {
        return functionPoint;
    }

    public void setFunctionPoint(double functionPoint) {
        this.functionPoint = functionPoint;
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
    @Column(name = "startTime")
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "endTime")
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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

        Project project = (Project) o;

        if (hostGroup != project.hostGroup) return false;
        if (Double.compare(project.efficiency, efficiency) != 0) return false;
        if (Double.compare(project.functionPoint, functionPoint) != 0) return false;
        if (Double.compare(project.workload, workload) != 0) return false;
        if (projectId != null ? !projectId.equals(project.projectId) : project.projectId != null) return false;
        if (projectName != null ? !projectName.equals(project.projectName) : project.projectName != null) return false;
        if (projectType != null ? !projectType.equals(project.projectType) : project.projectType != null) return false;
        if (leader != null ? !leader.equals(project.leader) : project.leader != null) return false;
        if (projectManager != null ? !projectManager.equals(project.projectManager) : project.projectManager != null)
            return false;
        if (startTime != null ? !startTime.equals(project.startTime) : project.startTime != null) return false;
        if (endTime != null ? !endTime.equals(project.endTime) : project.endTime != null) return false;
        if (isDelete != null ? !isDelete.equals(project.isDelete) : project.isDelete != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = projectId != null ? projectId.hashCode() : 0;
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        result = 31 * result + (projectType != null ? projectType.hashCode() : 0);
        result = 31 * result + (leader != null ? leader.hashCode() : 0);
        result = 31 * result + hostGroup;
        result = 31 * result + (projectManager != null ? projectManager.hashCode() : 0);
        temp = Double.doubleToLongBits(efficiency);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(functionPoint);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(workload);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (isDelete != null ? isDelete.hashCode() : 0);
        return result;
    }
}
