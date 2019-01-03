package com.test.ssh.service.impl;

import com.test.ssh.dao.EmployeeDao;
import com.test.ssh.domain.Employee;
import com.test.ssh.domain.modelResult.EmployeeResult;
import com.test.ssh.service.EmployeeService;
import com.test.ssh.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<EmployeeResult> getEmployees(Employee employee, int page, int limit) {
        //姓名和拼写切换
        String employeeName = employee.getEmployeeName();
        if (StringUtils.isNotEmpty(employeeName)) {
            boolean isAllLetter = true;
            char[] chars = employeeName.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] < 'A' || chars[i] > 'z' || ('Z' < chars[i] && chars[i] < 'a')) {
                    isAllLetter = false;
                    break;
                }
            }
            if (isAllLetter) {
                employee.setEmployeeNameSpell(employeeName.toUpperCase());
                employee.setEmployeeName(null);
            }
        }
        //查询职员数据
        List resultList = employeeDao.getEmployees(employee, page, limit);
        //结果转译拼装employeeResult
        if (resultList != null) {
            for (int i = 0; i < resultList.size(); i++) {
                EmployeeResult employeeResult = new EmployeeResult();
                Object[] objects = (Object[]) resultList.get(i);
                int j = 0;
                employeeResult.setEmployeeId(objects[j++].toString());
                employeeResult.setEmployeeName(objects[j++].toString());
                employeeResult.setEmployeeNameSpell(objects[j++].toString());
                employeeResult.setEntryTime(objects[j++].toString());
                employeeResult.setDepartment(Integer.valueOf(objects[j++].toString()));
                employeeResult.setGroupOfEmployee(Integer.valueOf(objects[j++].toString()));
                employeeResult.setGroupLeader(objects[j++].toString());
                employeeResult.setIsDelete(objects[j++].toString());
                employeeResult.setDepartmentName(objects[j++].toString());
                employeeResult.setGroupName(objects[j++].toString());
                employeeResult.setGroupLeaderStr(employeeResult.getGroupLeader().equals("1") ? "是" : "否");
                resultList.set(i, employeeResult);
            }
        }
        return resultList;
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        return employeeDao.getEmployeeById(employeeId);
    }

    @Override
    public String delEmployeeByIds(ArrayList<String> employeeIds) {
        return employeeDao.delEmployeeByIds(employeeIds);
    }

    @Override
    public String addEmployee(Employee employee) {
        Employee employeeParam = new Employee();
        employeeParam.setEmployeeId(employee.getEmployeeId());
        List<EmployeeResult> resultList = getEmployees(employeeParam, 1, 10);
        if (resultList != null && resultList.size() > 0) {
            return "职员ID已经被注册！请确认后重试";
        } else {
            String employeeNameSpell = StringUtils.getPinYin(employee.getEmployeeName());
            employee.setEmployeeNameSpell(employeeNameSpell);
            employee.setIsDelete("0");
            return employeeDao.addEmployee(employee);
        }
    }

    @Override
    public String importEmployees(List<Employee> employeeList) {
        return employeeDao.importEmployees(employeeList);
    }

    @Override
    public int getEmployeesCount(Employee employee) {
        //姓名和拼写切换
        String employeeName = employee.getEmployeeName();
        if (StringUtils.isNotEmpty(employeeName)) {
            boolean isAllLetter = true;
            char[] chars = employeeName.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] < 'A' || chars[i] > 'z') {
                    isAllLetter = false;
                    break;
                }
            }
            if (isAllLetter) {
                employee.setEmployeeNameSpell(employeeName.toUpperCase());
                employee.setEmployeeName(null);
            }
        }
        return employeeDao.getEmployeesCount(employee);
    }


}
