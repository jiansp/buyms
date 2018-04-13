<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bootstrap 附加导航（Affix）插件</title>
    <jsp:include page="inc.jsp"></jsp:include>
</head>
<body>
<div class="row">
    <div class="col-md-6">
        <img alt="100x100" src="img/a.jpg" class="img-rounded" />
    </div>
    <div class="col-md-6">
        <form class="form-horizontal">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputEmail3" placeholder="username">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Sign in</button>
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
