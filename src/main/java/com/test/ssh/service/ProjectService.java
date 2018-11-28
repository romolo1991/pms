package com.test.ssh.service;

import com.test.ssh.domain.Project;

import java.util.List;

public interface ProjectService {
    public List<Project> getProjects(String projectId, String projectName, String projectType, String projectScale, String startTime, String endTime);
}
