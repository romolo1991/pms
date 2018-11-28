package com.test.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.test.ssh.domain.Project;
import com.test.ssh.service.ProjectService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectAction extends ActionSupport implements ModelDriven<Project> {

    private Project project = new Project();

    private int page = 1;
    private int limit = 30;
    private JSONObject projectsJson;

    private ProjectService projectService;

    @Override
    public Project getModel() {
        return project;
    }

    public String getProjects(){
        System.out.println(limit);
        List<Project> projects = projectService.getProjects(project.getProjectId(), project.getProjectName(), project.getProjectType(), project.getProjectScale(), project.getStartTime(), project.getEndTime());
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count", projects.size());
        JSONArray array = JSONArray.fromObject(projects);
        result.put("data", array);
        projectsJson = JSONObject.fromObject(result);
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

    public void setProjectService(ProjectService projectService){
        this.projectService = projectService;
    }

    public JSONObject getProjectsJson() {
        return projectsJson;
    }

    public void setProjectsJson(JSONObject projectsJson) {
        this.projectsJson = projectsJson;
    }
}
