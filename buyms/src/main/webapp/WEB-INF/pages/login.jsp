<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>海淘记录管理</title>
    <jsp:include page="inc.jsp"></jsp:include>

    <script>
        $(document).ready(function () {
            document.onkeydown = function (event) {
                if (event.keyCode == 13) //回车键的键值为13
                    $('#btnLogin').click();
            };
        });
        var keyStr = "ABCDEFGHIJKLMNOP" + "QRSTUVWXYZabcdef" + "ghijklmnopqrstuv"
            + "wxyz0123456789+/" + "=";

        function encode64(input) {
            var output = "";
            var chr1, chr2, chr3 = "";
            var enc1, enc2, enc3, enc4 = "";
            var i = 0;
            do {
                chr1 = input.charCodeAt(i++);
                chr2 = input.charCodeAt(i++);
                chr3 = input.charCodeAt(i++);
                enc1 = chr1 >> 2;
                enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
                enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
                enc4 = chr3 & 63;
                if (isNaN(chr2)) {
                    enc3 = enc4 = 64;
                } else if (isNaN(chr3)) {
                    enc4 = 64;
                }
                output = output + keyStr.charAt(enc1) + keyStr.charAt(enc2)
                    + keyStr.charAt(enc3) + keyStr.charAt(enc4);
                chr1 = chr2 = chr3 = "";
                enc1 = enc2 = enc3 = enc4 = "";
            } while (i < input.length);

            return output;
        }

        // base64加密结束
        function submitForm() {
            $.ajax({
                url: "${ctx}/login/login",
                type: "post",
                data: $("#infoForm").serialize(),
                dataType: "json",
                beforeSend: function () {

                },
                error: function () {

                },
                complete: function () {
                },
                success: function (data) {
                    if(data.success == true){
                        window.location.href='${ctx}/login/index';
                    }else{
                        alert(data.msg);
                    }
                }
            });
        }

        function checkForm() {
            var empPattern = /^\s*$/;
            var username = $('#inputUsername').val();
            var password = $("#inputPassword").val();
            if (empPattern.test(username) || empPattern.test(password)) {
                alert('用户名或者密码不能为空');
                return;
            }
            $("#password").val(encode64(password));
            submitForm();
        }

    </script>
</head>
<body>
<div class="row">
    <div class="col-md-7" style="text-align: center">

    </div>
    <div class="col-md-4" style="margin-top: 200px">
        <form class="form-horizontal" id="infoForm">
            <div class="form-group">
                <label for="inputUsername" class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-5">
                    <input type="text" name="username" class="form-control" id="inputUsername" placeholder="username">
                    <input type="hidden" name="password" id="password"/>
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-5">
                    <input type="password" class="form-control" id="inputPassword" placeholder="Password">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="button" id="btnLogin" class="btn btn-default" onclick="checkForm()">登录</button>
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
<div class="col-md-1"></div>
</div>

</body>
</html>
