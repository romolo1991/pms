package com.test.ssh.service.impl;

import com.test.ssh.dao.ProjectDao;
import com.test.ssh.domain.Project;
import com.test.ssh.service.ProjectService;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    private ProjectDao projectDao;

    @Override
    public List<Project> getProjects(String projectId, String projectName, String projectType, String projectScale, String startTime, String endTime, int page, int limit) {
        return projectDao.getProjects(projectId, projectName, projectType, projectScale, startTime, endTime, page, limit);
    }

    public int getProjectCount (String projectId, String projectName, String projectType, String projectScale, String startTime, String endTime){
        return projectDao.getProjectCount(projectId, projectName, projectType, projectScale, startTime, endTime);
    }

    @Override
    public String addProject(Project project) {
        return projectDao.addProject(project);
    }

    @Override
    public String delProject(String projectId) {
        return projectDao.delProject(projectId);
    }

    public void setProjectDao(ProjectDao projectDao){
        this.projectDao = projectDao;
    }
}
