package com.test.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.test.ssh.domain.Employee;
import com.test.ssh.domain.Groupofdepartment;
import com.test.ssh.domain.Project;
import com.test.ssh.domain.modelResult.ProjectResult;
import com.test.ssh.service.EmployeeService;
import com.test.ssh.service.GroupService;
import com.test.ssh.service.ProjectService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectAction extends ActionSupport implements ModelDriven<Project> {

    private Project project = new Project();

    private int page = 1;
    private int limit = 10;
    private ArrayList<String> projectIds = new ArrayList<String>();
    private JSONObject backJson;

    private ProjectService projectService;
    private EmployeeService employeeService;
    private GroupService groupService;

    @Override
    public Project getModel() {
        return project;
    }

    public String getProjects(){
        List<Project> projects = projectService.getProjects(project.getProjectId(), project.getProjectName(), project.getHostGroup(), project.getProjectType(), project.getStartTime(), project.getEndTime(), page, limit);
        List<ProjectResult> projectResults = new ArrayList<ProjectResult>();
        for (int i=0;i<projects.size();i++){
            Project projectNow = projects.get(i);
            ProjectResult projectResult = new ProjectResult(projectNow);
            projectResult.setLeaderName(getNameFromEmployeeId(projectNow.getLeader()));
            projectResult.setHostGroupName(getNameFromGroupId(projectNow.getHostGroup()));
            projectResult.setProjectManagerName(getNameFromEmployeeId(projectNow.getProjectManager()));
            projectResults.add(projectResult);
        }
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        if (projects != null){
            result.put("count", projectService.getProjectCount(project.getProjectId(), project.getProjectName(), project.getHostGroup(), project.getProjectType(), project.getStartTime(), project.getEndTime()));
        }else{
            result.put("count", 0);
        }
        JSONArray array = JSONArray.fromObject(projectResults);
        result.put("data", array);
        backJson = JSONObject.fromObject(result);
        return SUCCESS;
    }

    public String addProject(){
        project.setIsDelete("0");
        String back = projectService.addProject(project);
        if (back.equals("success")){
            Map<String, String> result = new HashMap<String, String>();
            result.put("msg", "success");
            backJson = JSONObject.fromObject(result);
            return SUCCESS;
        }else{
            return "fail";
        }
    }

    public String delProject(){
        Map<String, String> result = new HashMap<String, String>();
        for (int i=0;i<projectIds.size();i++){
            String back = projectService.delProject(projectIds.get(i));
            if (!back.equals("success")){
                result.put("msg", "fail");
                backJson = JSONObject.fromObject(result);
                return "fail";
            }
        }
        result.put("msg", "success");
        backJson = JSONObject.fromObject(result);
        return SUCCESS;
    }

    public String getNameFromGroupId(int groupId){
        Groupofdepartment hostGroupofdepartment = groupService.getGroupById(groupId);
        if (hostGroupofdepartment != null){
            return hostGroupofdepartment.getGroupName();
        }else{
            return "职能组信息获取失败";
        }
    }

    public String getNameFromEmployeeId(String employeeId){
        Employee leaderEmployee = employeeService.getEmployeeById(employeeId);
        if (leaderEmployee != null){
            return leaderEmployee.getEmployeeName();
        }else{
            return "人员信息获取失败";
        }
    }

    public void setProject(Project project){
        this.project = project;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public int getLimit() {
        return limit;
    }

    public ArrayList<String> getProjectIds() {
        return projectIds;
    }

    public void setProjectIds(ArrayList<String> projectIds) {
        this.projectIds = projectIds;
    }

    public void setProjectService(ProjectService projectService){
        this.projectService = projectService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    public JSONObject getBackJson() {
        return backJson;
    }

    public void setBackJson(JSONObject backJson) {
        this.backJson = backJson;
    }
}
