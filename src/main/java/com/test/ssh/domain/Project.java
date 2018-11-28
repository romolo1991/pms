package com.test.ssh.domain;

import java.util.Date;

public class Project {
    private String projectId;
    private String projectName;
    private String projectType;
    private String projectScale;
    private char isSponsor;
    private String leader;
    private int hostGroup;
    private String projectManager;
    private double efficiency;
    private double functionPoint;
    private double workload;
    private String startTime;
    private String endTime;
    private char isDelete;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectScale() {
        return projectScale;
    }

    public void setProjectScale(String projectScale) {
        this.projectScale = projectScale;
    }

    public char getIsSponsor() {
        return isSponsor;
    }

    public void setIsSponsor(char isSponsor) {
        this.isSponsor = isSponsor;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public int getHostGroup() {
        return hostGroup;
    }

    public void setHostGroup(int hostGroup) {
        this.hostGroup = hostGroup;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }

    public double getFunctionPoint() {
        return functionPoint;
    }

    public void setFunctionPoint(double functionPoint) {
        this.functionPoint = functionPoint;
    }

    public double getWorkload() {
        return workload;
    }

    public void setWorkload(double workload) {
        this.workload = workload;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public char getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(char isDelete) {
        this.isDelete = isDelete;
    }
}
