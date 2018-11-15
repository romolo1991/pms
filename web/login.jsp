<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Crabbe
  Date: 2018/11/12
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/self.css">
    <script src="js/jquery-3.0.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
    <div>
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"><span class="firstFont">TestWebSet</span></a>
                </div>
            </div>
        </nav>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-offset-3 col-md-6">
                <s:form action="employee_login" namespace="/" method="POST" cssClass="form-horizontal">
                    <span class="heading">用户登录</span>
                    <div class="form-group">
                        <input class="form-control" type="text" name="name" placeholder="用户名">
                        <i class="fa fa-user"></i>
                    </div>
                    <div class="form-group">
                        <input class="form-control" type="password" name="password" placeholder="密码">
                        <i class="fa fa-key"></i>
                    </div>
                    <div class="form-group">
                        <input type="submit" name="login" value="提交" class="btn btn-default">
                    </div>
                </s:form>
            </div>
        </div>
    </div>
    <h4><s:actionerror/></h4>
</body>
</html>
