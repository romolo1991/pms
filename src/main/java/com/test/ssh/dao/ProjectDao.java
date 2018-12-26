package com.test.ssh.dao;

import com.test.ssh.domain.Project;

import java.util.List;

public interface ProjectDao {
    public List<Project> getProjects(String projectId, String projectName, int hostGroup, String projectType, String projectScale, String startTime, String endTime, int page, int limit);
    public int getProjectCount (String projectId, String projectName, int hostGroup, String projectType, String projectScale, String startTime, String endTime);
    public String addProject(Project project);
    public String delProject(String projectId);
}
