<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <title>天研项目管理系统（Beta版）</title>
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

<body class="layui-layout-body">

<div id="LAY_app">
    <div class="layui-layout layui-layout-admin">

        <!-- 头部区域 -->
        <div class="layui-header">
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item layadmin-flexible" lay-unselect>
                    <a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
                        <i class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
                    </a>
                </li>

                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;" layadmin-event="refresh" title="刷新">
                        <i class="layui-icon layui-icon-refresh-3"></i>
                    </a>
                </li>
            </ul>
            <ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="fullscreen">
                        <i class="layui-icon layui-icon-screen-full"></i>
                    </a>
                </li>
                <li class="layui-nav-item" lay-unselect style="margin-right: 5px">
                    <a href="javascript:;">
                        <i class="layui-icon layui-icon-user"></i>
                        <cite><s:property value="#session.user.userName"/></cite>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a lay-href="set/user/info.html">基本资料</a></dd>
                        <dd><a lay-href="set/user/password.html">修改密码</a></dd>
                        <hr>
                        <dd layadmin-event="logout" style="text-align: center;"><a>退出</a></dd>
                    </dl>
                </li>

        <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-unselect>
          <a href="javascript:;" layadmin-event="more"><i class="layui-icon layui-icon-more-vertical"></i></a>
        </li>
      </ul>
    </div>

    <!-- 侧边菜单 -->
    <div class="layui-side layui-side-menu">
      <div class="layui-side-scroll">
        <div class="layui-logo" lay-href="mainPage.jsp">
          <span>PMS</span>
        </div>

        <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">


          <li data-name="project" class="layui-nav-item">
            <a href="javascript:;" lay-tips="项目" lay-direction="2">
              <i class="layui-icon layui-icon-project"></i>
              <cite>项目</cite>
            </a>
            <dl class="layui-nav-child">
              <dd>
                <a lay-href="html/projects.html">项目简介</a>
              </dd>
              <dd data-name="workload">
                <a lay-href="html/element.html">工作量详情</a>
              </dd>
              <dd data-name="workload">
                <a lay-href="html/element.html">工作量管理</a>
              </dd>

            </dl>
          </li>

          <li data-name="performance" class="layui-nav-item">
            <a href="javascript:;" lay-tips="绩效" lay-direction="2">
              <i class="layui-icon layui-icon-performance"></i>
              <cite>绩效</cite>
            </a>
            <dl class="layui-nav-child">
              <dd><a lay-href="performance/performance.html">部门绩效</a></dd>
              <dd><a lay-href="performance/performance.html">职能组绩效</a></dd>
              <dd><a lay-href="performance/performance.html">人员绩效</a></dd>
            </dl>
          </li>

          <li data-name="user" class="layui-nav-item">
            <a href="javascript:;" lay-tips="用户" lay-direction="2">
              <i class="layui-icon layui-icon-user"></i>
              <cite>管理</cite>
            </a>
            <dl class="layui-nav-child">
              <dd>
                <a lay-href="html/manage/department.html">部门管理</a>
              </dd>
              <dd>
                <a lay-href="user/administrators/list.html">职能组管理</a>
              </dd>
              <dd>
                <a lay-href="user/administrators/role.html">职员管理</a>
              </dd>
            </dl>
          </li>
          <li data-name="set" class="layui-nav-item">
            <a href="javascript:;" lay-tips="设置" lay-direction="2">
              <i class="layui-icon layui-icon-set"></i>
              <cite>设置</cite>
            </a>
            <dl class="layui-nav-child">
              <dd class="layui-nav-itemed">
                <a href="javascript:;">我的设置</a>
                <dl class="layui-nav-child">
                  <dd><a lay-href="set/user/info.html">基本资料</a></dd>
                  <dd><a lay-href="set/user/password.html">修改密码</a></dd>
                  <dd><a lay-href="">登陆授权</a></dd>
                </dl>
              </dd>
            </dl>
          </li>
        </ul>
      </div>
    </div>

    <!-- 页面标签 -->
      <div class="layadmin-pagetabs" id="LAY_app_tabs">
          <div class="layui-icon layadmin-tabs-control layui-icon-prev" layadmin-event="leftPage"></div>
          <div class="layui-icon layadmin-tabs-control layui-icon-next" layadmin-event="rightPage"></div>
          <div class="layui-icon layadmin-tabs-control layui-icon-down">
              <ul class="layui-nav layadmin-tabs-select" lay-filter="layadmin-pagetabs-nav">
                  <li class="layui-nav-item" lay-unselect>
                      <a href="javascript:;"></a>
                      <dl class="layui-nav-child layui-anim-fadein">
                          <dd layadmin-event="closeThisTabs"><a href="javascript:;">关闭当前标签页</a></dd>
                          <dd layadmin-event="closeOtherTabs"><a href="javascript:;">关闭其它标签页</a></dd>
                          <dd layadmin-event="closeAllTabs"><a href="javascript:;">关闭全部标签页</a></dd>
                      </dl>
                  </li>
              </ul>
          </div>
          <div class="layui-tab" lay-unauto lay-allowClose="true" lay-filter="layadmin-layout-tabs">
              <ul class="layui-tab-title" id="LAY_app_tabsheader">
                  <li lay-id="mainPage.jsp" lay-attr="mainPage.jsp" class="layui-this"><i class="layui-icon layui-icon-home"></i></li>
              </ul>
          </div>
      </div>


    <!-- 主体内容 -->
    <div class="layui-body" id="LAY_app_body">
        <div class="layadmin-tabsbody-item layui-show">
            <iframe src="mainPage.jsp" frameborder="0" class="layadmin-iframe"></iframe>
        </div>
    </div>

    <!-- 辅助元素，一般用于移动设备下遮罩 -->
    <div class="layadmin-body-shade" layadmin-event="shade"></div>
  </div>
</div>

</body>
</html>