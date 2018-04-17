<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>海淘管理平台</title>
    <jsp:include page="../inc.jsp"></jsp:include>
    <script>
        function operateFormatter(value, row, index) {
            var href = "${ctx}/shopRecord/edit?id="+row.id;
            return [
                '<button type="button" class="btn btn-warning" style="margin-right:10px;">删除</button>',
                '<button type="button" class="btn btn-info" style="margin-right:10px;" href="'+href+'" data-toggle="modal" data-target="#editModal">修改</button>'
            ].join('');
        }
        $(function () {
            //1.初始化Table
            var oTable = new TableInit();
            oTable.Init();
        });
        var TableInit = function () {
            var oTableInit = new Object();
            //初始化Table
            oTableInit.Init = function () {
                $('#shopRecordTable').bootstrapTable({
                    url: '${ctx}/shopRecord/bootstrapTable',         //请求后台的URL（*）
                    method: 'get',                      //请求方式（*）
                    toolbar: '#toolbar',                //工具按钮用哪个容器
                    striped: true,                      //是否显示行间隔色
                    cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                    pagination: true,                   //是否显示分页（*）
                    sortable: false,                     //是否启用排序
                    locale: "zh-CN",
                    sortOrder: "asc",                   //排序方式
                    queryParams: oTableInit.queryParams,//传递参数（*）
                    sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                    pageNumber:1,                       //初始化加载第一页，默认第一页
                    pageSize: 10,                       //每页的记录行数（*）
                    pageList: [10, 25, 50],        //可供选择的每页的行数（*）
                    search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                    strictSearch: true,                //按钮-翻转显示
                    showColumns: false,                  //是否显示所有的列
                    showRefresh: false,                  //是否显示刷新按钮
                    minimumCountColumns: 2,             //最少允许的列数
                    clickToSelect: true,                //是否启用点击选中行
                    height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                    uniqueId: "id",                     //每一行的唯一标识，一般为主键列
                    showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
                    cardView: false,                    //是否显示详细视图
                    detailView: false,                   //是否显示父子表
                    columns: [{
                        field: 'SerialNumber',
                        title: '序号',
                        width : '20',
                        formatter: function (value, row, index) {
                            return index+1;
                        }
                    },{
                        field: 'goodName',
                        title: '商品名称'
                    }, {
                        field: 'money',
                        title: '金额'
                    }, {
                        field: 'moneyType',
                        title: '币种'
                    }, {
                        field: 'shopObject',
                        title: '受骗对象'
                    }, {
                        field: 'shopTime',
                        title: '购买时间'
                    }, {
                        field: 'website',
                        title: '网站'
                    }, {
                        field: 'creatorName',
                        title: '创建人'
                    }, {
                            field: 'operate',
                            title: '操作',
                            align: 'center',
                            width : 160,
                            /*events: operateEvents,*/
                            formatter: operateFormatter
                        }]
                });
            };

            //得到查询的参数
            oTableInit.queryParams = function (params) {
                var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                    limit: params.limit,   //页面大小
                    offset: params.offset,  //页码
                };
                return temp;
            };
            return oTableInit;
        };
        var ButtonInit = function () {
            var oInit = new Object();
            var postdata = {};

            oInit.Init = function () {
                //初始化页面上面的按钮事件
            };

            return oInit;
        };
    </script>
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

                        <button href="${ctx}/shopRecord/edit" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#addModal">添加</button>

                    </div>
                </div>
            </nav>
            <!-- 模态框（Modal） -->
            <div class="modal fade" id="addModal"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content" style="width: 55%;margin: 20% auto">
                    </div>
                </div><!-- /.modal -->
            </div>
            <div class="modal fade" id="editModal"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content" style="width: 55%;margin: 20% auto">
                    </div>
                </div><!-- /.modal -->
            </div>
            <div style="padding-right: 15px;padding-left: 15px">
                <table id="shopRecordTable"></table>
            </div>

        </div>
    </div>
</div>
</body>
</html>
