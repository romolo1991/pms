<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<body>

<s:iterator value="departmentList">
    <option value="<s:property value="departmentId"/>"><s:property value="departmentName"/></option>
</s:iterator>

</body>
</html>