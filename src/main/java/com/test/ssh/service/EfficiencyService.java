package com.test.ssh.service;

import com.test.ssh.domain.modelResult.EfficiencyResult;

import java.util.List;

public interface EfficiencyService {
    EfficiencyResult getEmployeePerf(String employeeId, String employeeEntryTime, String month);

    List<String> getMonths(String startMonth, String endMonth, String employeeId);
}
