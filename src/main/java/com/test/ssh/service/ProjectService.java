package com.test.ssh.service;

import com.test.ssh.domain.Project;

import java.util.List;

public interface ProjectService {
    public List<Project> getProjects(String projectId, String projectName, int hostGroup, char isSponsor, String projectScale, String startTime, String endTime, int page, int limit);
    public int getProjectCount (String projectId, String projectName, int hostGroup, char isSponsor, String projectScale, String startTime, String endTime);
    public String addProject(Project project);
    public String delProject(String projectId);
}
