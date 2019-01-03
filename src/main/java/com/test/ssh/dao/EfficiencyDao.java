package com.test.ssh.dao;

import java.util.List;

public interface EfficiencyDao {
    List getEmployeePerf(String employeeId, String month);

    List<String> getMonths(String startMonth, String endMonth, int departmentId, int groupId, String employeeId);
}
