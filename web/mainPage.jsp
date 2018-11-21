<%--
  Created by IntelliJ IDEA.
  User: Crabbe
  Date: 2018/11/21
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mainPage</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="WebTemplate/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="WebTemplate/layuiadmin/style/admin.css" media="all">

    <script src="WebTemplate/layuiadmin/layui/layui.js"></script>
    <script>
        layui.config({
            base: 'WebTemplate/layuiadmin/' //静态资源所在路径
        }).extend({
            index: 'lib/index' //主入口模块
        }).use('index');
    </script>
</head>
<body>
    <div class="layui-fluid">
        <div class="layui-row layui-col-space12">
            <div class="layui-col-md8">
                <div class="layui-card">
                    <div class="layui-card-header">您好</div>
                    <div class="layui-card-body">
                        <fieldset class="layui-elem-field">
                            <legend>欢迎</legend>
                            <div class="layui-field-box layui-text">
                                欢迎来到PMS系统。接下来应该说一些欢迎的话语，并对这个系统是干嘛的进行介绍。总而言之，我不会写。
                            </div>
                        </fieldset>
                    </div>
                </div>
            </div>
            <div class="layui-col-md4">
                <div class="layui-card">
                    <div class="layui-card-header">版本信息</div>
                    <div class="layui-card-body layui-text">
                        <table class="layui-table">
                            <colgroup>
                                <col width="100">
                                <col>
                            </colgroup>
                            <tbody>
                                <tr>
                                    <td>当前版本</td>
                                    <td>1.0.0</td>
                                </tr>
                                <tr>
                                    <td>基于框架</td>
                                    <td>
                                        <script type="text/html" template>
                                        layui-v{{ layui.v }}
                                        </script>
                                    </td>
                                </tr>
                                <tr>
                                    <td>主要特点</td>
                                    <td>没啥特点</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
