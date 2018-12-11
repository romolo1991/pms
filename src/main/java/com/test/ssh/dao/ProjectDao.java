package com.test.ssh.dao;

import com.test.ssh.domain.Project;

import java.util.List;

public interface ProjectDao {
     List<Project> getProjects(String projectId, String projectName, String projectType, String projectScale, String startTime, String endTime, int page, int limit);
     int getProjectCount (String projectId, String projectName, String projectType, String projectScale, String startTime, String endTime);
     String addProject(Project project);
     String delProject(String projectId);
}
