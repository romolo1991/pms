package com.test.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.test.ssh.domain.modelResult.GroupResult;
import com.test.ssh.domain.Groupofdepartment;
import com.test.ssh.service.GroupService;

import java.util.ArrayList;
import java.util.List;

public class GroupAction extends ActionSupport implements ModelDriven<Groupofdepartment> {

    private Groupofdepartment group = new Groupofdepartment();

    private GroupService groupService;

    @Override
    public Groupofdepartment getModel() {
        return group;
    }

    private List<Groupofdepartment> groupofdepartmentList;

    public String getGroupsByDept() {
        List<Groupofdepartment> groupofdepartmentList = groupService.getGroups(this.group);
        if (groupofdepartmentList==null||groupofdepartmentList.size()<=0){
            groupofdepartmentList=new ArrayList<Groupofdepartment>();
        }
        Groupofdepartment groupofdepartment = new Groupofdepartment();
        groupofdepartment.setGroupId(0);
        groupofdepartment.setGroupName("请选择职能组");
        groupofdepartmentList.add(0, groupofdepartment);
        setGroupofdepartmentList(groupofdepartmentList);

//        GroupResult groupResult = new GroupResult(groupofdepartment);
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
}
