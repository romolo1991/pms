package com.test.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.test.ssh.domain.Employee;
import com.test.ssh.domain.modelResult.EmployeeResult;
import com.test.ssh.service.EmployeeService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {

    //前端传入参数
    private Employee employee = new Employee();
    private int page = 1;
    private int limit = 10;

    private ArrayList<String> employeeIds;

    //后台返回结果
    private JSONObject getEmployeesJson;
    private JSONObject delEmployeesJson;

    private EmployeeService employeeService;

    @Override
    public Employee getModel() {
        return employee;
    }

    //获取职员信息
    public String getEmployees() {
        List<EmployeeResult> employeeResults = employeeService.getEmployees(employee, page, limit);
        Map<String, Object> result = new HashMap<String, Object>();
        JSONArray array = new JSONArray();
        if (employeeResults != null && employeeResults.size() > 0) {
            array = JSONArray.fromObject(employeeResults);
            result.put("code", 0);
            result.put("msg", "success");
            result.put("data", array);
        } else {
            result.put("code", 0);
            result.put("msg", "error");
            result.put("data", array);
        }
        setGetEmployeesJson(JSONObject.fromObject(result));
        return SUCCESS;
    }

    //删除职员信息
    public String delEmployees() {
        Map<String, String> result = new HashMap<String, String>();
        String backMsg = employeeService.delEmployeeByIds(employeeIds);
        result.put("msg", backMsg);
        setDelEmployeesJson(JSONObject.fromObject(result));
        if (backMsg.equals("success"))
            return SUCCESS;
        else
            return ERROR;
    }


    //

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
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

    public JSONObject getGetEmployeesJson() {
        return getEmployeesJson;
    }

    public void setGetEmployeesJson(JSONObject getEmployeesJson) {
        this.getEmployeesJson = getEmployeesJson;
    }

    public void setDelEmployeesJson(JSONObject delEmployeesJson) {
        this.delEmployeesJson = delEmployeesJson;
    }

    public JSONObject getDelEmployeesJson() {
        return delEmployeesJson;
    }
    
    public ArrayList<String> getEmployeeIds() {
        return employeeIds;
    }


    public void setEmployeeIds(ArrayList<String> employeeIds) {
        this.employeeIds = employeeIds;
    }

}
