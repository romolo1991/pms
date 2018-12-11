package com.test.ssh.domain.modelResult;

import com.test.ssh.domain.Groupofdepartment;

public class GroupResult extends Groupofdepartment {

    private int groupId;
    private String groupName;
    private String introduction;
    private int department;
    private String isDelete;
    private String remark1;
    private String remark2;

    //新添字段

    private String departmentName;



    public GroupResult(Groupofdepartment groupofdepartment){

        this.groupId = groupofdepartment.getGroupId();

    }

}
