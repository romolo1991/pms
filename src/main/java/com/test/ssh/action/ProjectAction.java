package com.test.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.test.ssh.domain.Project;
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

    @Override
    public Project getModel() {
        return project;
    }

    public String getProjects(){
        List<Project> projects = projectService.getProjects(project.getProjectId(), project.getProjectName(), project.getHostGroup(), project.getProjectType(), project.getProjectScale(), project.getStartTime(), project.getEndTime(), page, limit);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        if (projects != null){
            result.put("count", projectService.getProjectCount(project.getProjectId(), project.getProjectName(), project.getHostGroup(), project.getProjectType(), project.getProjectScale(), project.getStartTime(), project.getEndTime()));
        }else{
            result.put("count", 0);
        }
        JSONArray array = JSONArray.fromObject(projects);
        result.put("data", array);
        backJson = JSONObject.fromObject(result);
        return SUCCESS;
    }

    public String addProject(){
        //测试数据
        project.setLeader("0");
        project.setHostGroup(0);
        project.setProjectManager("0");

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

    public JSONObject getBackJson() {
        return backJson;
    }

    public void setBackJson(JSONObject backJson) {
        this.backJson = backJson;
    }
}
