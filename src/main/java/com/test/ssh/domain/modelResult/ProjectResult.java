package com.test.ssh.domain.modelResult;

import com.test.ssh.domain.Project;

public class ProjectResult {

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

    private String projectTypeName;

    private String leaderName;
    private String hostGroupName;
    private String projectManagerName;

    public ProjectResult(Project project){
        projectId = project.getProjectId();
        projectName = project.getProjectName();
        projectType = project.getProjectType();
        projectTypeName = NameFromProjectType();
        leader = project.getLeader();
        hostGroup = project.getHostGroup();
        projectManager = project.getProjectManager();
        efficiency = project.getEfficiency();
        functionPoint = project.getFunctionPoint();
        workload = project.getWorkload();
        startTime = project.getStartTime();
        endTime = project.getEndTime();
        isDelete = project.getIsDelete();
    }

    public String NameFromProjectType(){
        if ("00".equals(projectType)){
            return "项目主办";
        }else if ("01".equals(projectType)){
            return "项目协办";
        }else if ("02".equals(projectType)){
            return "专项";
        }else {
            return "项目类型解析错误";
        }
    }

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

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getProjectTypeName() {
        return projectTypeName;
    }

    public void setProjectTypeName(String projectTypeName) {
        this.projectTypeName = projectTypeName;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getHostGroupName() {
        return hostGroupName;
    }

    public void setHostGroupName(String hostGroupName) {
        this.hostGroupName = hostGroupName;
    }

    public String getProjectManagerName() {
        return projectManagerName;
    }

    public void setProjectManagerName(String projectManagerName) {
        this.projectManagerName = projectManagerName;
    }
}
