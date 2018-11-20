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
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="css/demo.css" />
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="css/component.css" />
    <script type="text/javascript">
        if (navigator.userAgent.toLowerCase().indexOf("chrome") >= 0) {
            $(window).load(function(){
                $('input:-webkit-autofill').each(function(){
                    var text = $(this).val();
                    var name = $(this).attr('name');
                    $(this).after(this.outerHTML).remove();
                    $('input[name=' + name + ']').val(text);
                });
            });
        }
    </script>
</head>
<body>
    <div class="container demo-1">
        <div class="content">
            <div id="large-header" class="large-header">
                <canvas id="demo-canvas"></canvas>
                <div class="logo_box">
                    <h3>Welcome</h3>
                    <form action="employee_login" namespace="/" method="POST">
                        <div class="input_outer">
                            <span class="user"></span>
                            <input name="name" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
                        </div>
                        <div class="input_outer">
                            <span class="pwd"></span>
                            <input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
                        </div>
                        <div class="mb2">

                                <input class="act-but submit"  type="submit" name="login" style="color: #FFFFFF" value="登录">
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div><!-- /container -->
        <script src="js/TweenLite.min.js"></script>
        <script src="js/EasePack.min.js"></script>
        <script src="js/rAF.js"></script>
        <script src="js/demo-1.js"></script>
        <div style="text-align:center;">
    </div>

</body>
</html>