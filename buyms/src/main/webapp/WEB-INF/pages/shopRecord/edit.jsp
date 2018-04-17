<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%--<jsp:include page="inc.jsp"></jsp:include> 不能加我艹，老子查了一下午--%>
<script>
    $(function(){
        $('#datetimepicker').datetimepicker();
    })
    function save() {
        $.ajax({
            url: "${ctx}/shopRecord/save",
            type: "post",
            data: $("#infoForm").serialize(),
            dataType: "json",
            error: function () {
                alert("系统错误");
            },
            success: function (data) {
                if(data.success == true){
                    alert(data.msg);
                    $('#editModal').modal('hide');
                }else{
                    alert(data.msg);
                }
            }
        });
    }
</script>
<div>
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">编辑</h4>
    </div>
    <div class="modal-body">
        <form class="bs-example bs-example-form" role="form" id="infoForm" name="infoForm" >
            <input type="hidden" value="${obj.id}" name="id" />
            <div class="input-group">
                <span class="input-group-addon">商品名称</span>
                <input type="text" class="form-control" name="goodName" value="${obj.goodName}">
            </div>
            <br>
            <div class="input-group">
                <span class="input-group-addon">购买时间</span>
                <input type="text" name="shopTime" value="${obj.shopTime}" class="form-control" id="datetimepicker" data-date-format="yyyy-mm-dd hh:ii">
            </div>
            <br>

            <div class="input-group">
                <span class="input-group-addon">受骗对象</span>
                <input type="text" class="form-control" name="shopObject" value="${obj.shopObject}" >
            </div>

            <br>
            <div class="input-group">
                <div class="input-group-btn">
                    <button type="button" class="btn btn-default
                        dropdown-toggle" data-toggle="dropdown"><span class="moneyType">${obj.moneyType eq null || ""?"币种":obj.moneyType}</span>
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="javascript:$('.moneyType').text('人民币');$('#moneyType').val('人民币');">人民币</a>
                        </li>
                        <li>
                            <a href="javascript:$('.moneyType').text('美元');$('#moneyType').val('美元');">美元</a>
                        </li>
                        <li>
                            <a href="javascript:$('.moneyType').text('日元');$('#moneyType').val('日元');">日元</a>
                        </li>
                        <li>
                            <a href="javascript:$('.moneyType').text('欧元');$('#moneyType').val('欧元');">欧元</a>
                        </li>
                    </ul>
                </div><!-- /btn-group -->
                <input type="number" class="form-control" name="money" value="${obj.money}" >
                <input type="hidden" id="moneyType" name="moneyType" value="${obj.moneyType}" />
            </div><!-- /input-group -->
            <br>
            <div class="input-group">
                <span class="input-group-addon">网站</span>
                <input type="text" class="form-control" name="website" value="${obj.website}">
            </div>
        </form>
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="save()">保存</button>
    </div>
</div>
