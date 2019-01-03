package com.test.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.test.ssh.domain.modelResult.EfficiencyResult;
import com.test.ssh.service.EfficiencyService;
import com.test.ssh.utils.StringUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.json.annotations.JSON;

import java.util.*;

public class EfficiencyAction extends ActionSupport {
    private EfficiencyService efficiencyService;
    //前端传入参数
    private String employeeId;
    private String employeeEntryTime;
    private String startMonth;
    private String endMonth;
    private int page = 1;
    private int limit = 10;

    //后台返回结果
    private JSONObject getPersonEfficiencyJson;


    public String getPersonEfficiency() {
        Map<String, Object> result = new HashMap<String, Object>();
        List<EfficiencyResult> efficiencyList = new ArrayList();
        JSONArray array = new JSONArray();
        result.put("code", 0);
        if (StringUtils.isNotEmpty(employeeId) && StringUtils.isNotEmpty(employeeEntryTime)) {
            List<String> monthList = efficiencyService.getMonths(startMonth, endMonth, 0, 0, employeeId);
            Iterator<String> iterator = monthList.iterator();
            while (iterator.hasNext()) {
                String month = iterator.next();
                EfficiencyResult efficiencyResult = efficiencyService.getEmployeePerf(employeeId, employeeEntryTime, month);
                efficiencyList.add(efficiencyResult);
            }
            array = JSONArray.fromObject(efficiencyList);
            result.put("msg", "error");
            result.put("count", monthList.size());
            result.put("data", array);
        } else {
            result.put("msg", "人员或入职日期为空！");
            result.put("count", 0);
            result.put("data", array);
        }
        setGetPersonEfficiencyJson(JSONObject.fromObject(result));
        return SUCCESS;


    }


    public void setEfficiencyService(EfficiencyService efficiencyService) {
        this.efficiencyService = efficiencyService;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public String getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(String endMonth) {
        this.endMonth = endMonth;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public JSONObject getGetPersonEfficiencyJson() {
        return getPersonEfficiencyJson;
    }

    public void setGetPersonEfficiencyJson(JSONObject getPersonEfficiencyJson) {
        this.getPersonEfficiencyJson = getPersonEfficiencyJson;
    }

    public String getEmployeeEntryTime() {
        return employeeEntryTime;
    }

    public void setEmployeeEntryTime(String employeeEntryTime) {
        this.employeeEntryTime = employeeEntryTime;
    }
}
