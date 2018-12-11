<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<body>

<s:iterator value="groupofdepartmentList">
    <option value="<s:property value="groupId"/> "><s:property value="groupName"/></option>
</s:iterator>

</body>
</html>