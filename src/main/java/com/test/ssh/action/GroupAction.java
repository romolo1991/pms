package com.test.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.test.ssh.domain.Groupofdepartment;
import com.test.ssh.service.GroupService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAction extends ActionSupport implements ModelDriven<Groupofdepartment> {

    private Groupofdepartment group = new Groupofdepartment();

    private int page = 1;
    private int limit = 10;
    private JSONObject backJson;

    private GroupService groupService;

    @Override
    public Groupofdepartment getModel() {
        return group;
    }

    private List<Groupofdepartment> groupofdepartmentList;

    public String getGroupsByDept() {
        List<Groupofdepartment> groupofdepartmentList = new ArrayList<Groupofdepartment>();
        if (group.getDepartment() != 0) {
            groupofdepartmentList = groupService.getGroupByDept(group.getDepartment());
        }
        Groupofdepartment groupofdepartment = new Groupofdepartment();
        groupofdepartment.setGroupId(0);
        groupofdepartment.setGroupName("请选择职能组");
        groupofdepartmentList.add(0, groupofdepartment);

        setGroupofdepartmentList(groupofdepartmentList);
        return SUCCESS;
    }

    public String getGroups() {
        List<Groupofdepartment> groupList = groupService.getGroups(group, page, limit);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        if (groupList != null){
            result.put("count", groupService.getGroupCount(group));
        }else {
            result.put("count", 0);
        }
        JSONArray array = JSONArray.fromObject(groupList);
        result.put("data", array);
        backJson = JSONObject.fromObject(result);
        return SUCCESS;
    }

    public void setGroup(Groupofdepartment groupofdepartment) {
        this.group = groupofdepartment;
    }

    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    public List<Groupofdepartment> getGroupofdepartmentList() {
        return groupofdepartmentList;
    }

    public void setGroupofdepartmentList(List<Groupofdepartment> groupofdepartmentList) {
        this.groupofdepartmentList = groupofdepartmentList;
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

    public JSONObject getBackJson() {
        return backJson;
    }

    public void setBackJson(JSONObject backJson) {
        this.backJson = backJson;
    }
}
