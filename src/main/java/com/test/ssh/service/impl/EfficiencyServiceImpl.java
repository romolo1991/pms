package com.test.ssh.service.impl;

import com.test.ssh.dao.EfficiencyDao;
import com.test.ssh.domain.modelResult.EfficiencyResult;
import com.test.ssh.service.EfficiencyService;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import sun.security.ssl.Debug;

import java.math.BigDecimal;
import java.util.List;

public class EfficiencyServiceImpl implements EfficiencyService {

    private EfficiencyDao efficiencyDao;

    public void setEfficiencyDao(EfficiencyDao efficiencyDao) {
        this.efficiencyDao = efficiencyDao;
    }

    @Override
    public EfficiencyResult getEmployeePerf(String employeeId, String employeeEntryTime, String month) {
        EfficiencyResult efficiencyResult = new EfficiencyResult();
        List list = efficiencyDao.getEmployeePerf(employeeId, month);
        if (list.size() > 0) {
            employeeEntryTime = employeeEntryTime.substring(0, 7);
            double normalworkload = getNormalworkload(employeeEntryTime, month);

            double specialItem = 0;
            double project = 0;
            double humanSurplus = 0;
            double efficiency = 0;
            double workLoad = 0;
            double Fp = 0;
            for (int i = 0; i < list.size(); i++) {
                Object[] objects = (Object[]) list.get(i);
                workLoad += Double.valueOf(objects[1].toString());
                if ("02".equals(objects[0].toString())) {
                    specialItem += Double.valueOf(objects[1].toString());
                } else {
                    project += Double.valueOf(objects[1].toString());
                    Fp += Double.valueOf(objects[1].toString()) * Double.valueOf(objects[2].toString());
                }
            }
            humanSurplus = normalworkload - (specialItem + project);
            efficiency = Fp / (normalworkload - specialItem);

            efficiency = new BigDecimal(efficiency).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            Fp = new BigDecimal(Fp).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

            efficiencyResult.setMonth(month);
            efficiencyResult.setTotalPeople(String.valueOf(normalworkload));
            efficiencyResult.setSpecialItem(String.valueOf(specialItem));
            efficiencyResult.setProject(String.valueOf(project));
            efficiencyResult.setHumanSurplus(String.valueOf(humanSurplus));
            efficiencyResult.setEfficiency(String.valueOf(efficiency));
            efficiencyResult.setWorkLoad(String.valueOf(workLoad));
            efficiencyResult.setFp(String.valueOf(Fp));
        }
        return efficiencyResult;
    }

    // param (2018-02,2018-08)
    // result (一人一个月正常工作量  转正1，未转正0.5)
    private double getNormalworkload(String employeeEntryTime, String month) {
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM");
        double normalworkload = 0;
        try {
            DateTime entryTime = format.parseDateTime(employeeEntryTime);
            DateTime queryMonth = format.parseDateTime(month);
            int months = Months.monthsBetween(entryTime, queryMonth).getMonths();
            normalworkload = (months >= 6) ? 1 : 0.5;
        } catch (Exception e) {
            Debug.println("---EfficiencyServiceImpl---getEmployeePerf", "日期转换出错");
        }
        return normalworkload;
    }

    @Override
    public List<String> getMonths(String startMonth, String endMonth, int departmentId, int groupId, String employeeId) {
        return efficiencyDao.getMonths(startMonth, endMonth, departmentId, groupId, employeeId);
    }


}
