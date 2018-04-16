<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Bootstrap 附加导航（Affix）插件</title>
    <jsp:include page="../inc.jsp"></jsp:include>
</head>
<body data-spy="scroll" data-target="#myScrollspy">
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12" style=" background-color: #3A70C9;">
            <h3 style="color: white;font-family: '微软雅黑'">
                海淘管理平台
            </h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3" style="height: 91%;background-color: #afd9ee">
            <ul class="nav nav-list">
                <li class="nav-header">
                    列表标题
                </li>
                <li class="active">
                    <a href="#">首页</a>
                </li>
                <li>
                    <a href="#">库</a>
                </li>
                <li>
                    <a href="#">应用</a>
                </li>
                <li class="nav-header">
                    功能列表
                </li>
                <li>
                    <a href="#">资料</a>
                </li>
                <li>
                    <a href="#">设置</a>
                </li>
                <li class="divider">
                </li>
                <li>
                    <a href="#">帮助</a>
                </li>
            </ul>
        </div>
        <div class="col-md-9" style="padding-left: 0px;padding-right: 0px">
            <nav class="navbar navbar-default" role="navigation">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">记录列表</a>
                    </div>
                    <div>

                        <form class="navbar-form navbar-left" role="search">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Search">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Search">
                            </div>

                            <button type="button" class="btn btn-default">查询</button>
                        </form>

                        <button href="${ctx}/shopRecord/edit" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#editModal">添加</button>
                        <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#editModal">
                            修改
                        </button>
                        <button type="button" class="btn btn-default navbar-btn">
                            删除
                        </button>
                        <button type="button" class="btn btn-default navbar-btn">
                            查看
                        </button>
                    </div>
                </div>
            </nav>
            <!-- 模态框（Modal） -->
            <div class="modal fade" id="editModal"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content" style="width: 55%;margin: 20% auto">
                    </div>
                </div><!-- /.modal -->
            </div>
            <div style="padding-right: 15px;padding-left: 15px">
                <table class="table table-hover">
                    <caption>悬停表格布局</caption>
                    <thead>
                    <tr>
                        <th>名称</th>
                        <th>城市</th>
                        <th>邮编</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Tanmay</td>
                        <td>Bangalore</td>
                        <td>560001</td>
                    </tr>
                    <tr>
                        <td>Sachin</td>
                        <td>Mumbai</td>
                        <td>400003</td>
                    </tr>
                    <tr>
                        <td>Uma</td>
                        <td>Pune</td>
                        <td>411027</td>
                    </tr>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>
</body>
</html>
