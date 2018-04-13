<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bootstrap 附加导航（Affix）插件</title>
    <jsp:include page="inc.jsp"></jsp:include>
</head>
<body>
<div class="row">
    <div class="col-md-6">
        <img alt="140x140" src="img/a.jpg" class="img-rounded" />
    </div>
    <div class="col-md-6">
        <form class="form-horizontal">
            <div class="control-group">
                <label class="control-label" for="inputEmail">邮箱</label>
                <div class="controls">
                    <input id="inputEmail" type="text" />
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputPassword">密码</label>
                <div class="controls">
                    <input id="inputPassword" type="password" />
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <label class="checkbox"><input type="checkbox" /> Remember me</label> <button type="submit" class="btn">登陆</button>
                </div>
            </div>
        </form>
        <div class="alert alert-info">
            <button type="button" class="close" data-dismiss="alert">×</button>
            <h4>
                提示!
            </h4> <strong>警告!</strong> 请注意你的个人隐私安全.
        </div>
    </div>
</div>

</body>
</html>
