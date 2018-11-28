package com.test.ssh.dao;

import com.test.ssh.domain.Project;

import java.util.Date;
import java.util.List;

public interface ProjectDao {
    public List<Project> getProjects(String projectId, String projectName, String projectType, String projectScale, String startTime, String endTime);
}
