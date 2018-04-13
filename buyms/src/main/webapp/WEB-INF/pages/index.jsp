<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bootstrap 附加导航（Affix）插件</title>
    <jsp:include page="inc.jsp"></jsp:include>
</head>
<body data-spy="scroll" data-target="#myScrollspy">
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <h3>
                h3. 这是一套可视化布局系统.
            </h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4">
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
        <div class="col-md-8">
            <ul class="thumbnails">
                <li class="col-md-4">
                    <div class="thumbnail">
                        <img alt="300x200" src="${ctx}/img/a.jpg" />
                        <div class="caption">
                            <h3>
                                冯诺尔曼结构
                            </h3>
                            <p>
                                也称普林斯顿结构，是一种将程序指令存储器和数据存储器合并在一起的存储器结构。程序指令存储地址和数据存储地址指向同一个存储器的不同物理位置。
                            </p>
                            <p>
                                <a class="btn btn-primary" href="#">浏览</a> <a class="btn" href="#">分享</a>
                            </p>
                        </div>
                    </div>
                </li>
                <li class="col-md-4">
                    <div class="thumbnail">
                        <img alt="300x200" src="${ctx}/img/a.jpg" />
                        <div class="caption">
                            <h3>
                                哈佛结构
                            </h3>
                            <p>
                                哈佛结构是一种将程序指令存储和数据存储分开的存储器结构，它的主要特点是将程序和数据存储在不同的存储空间中，进行独立编址。
                            </p>
                            <p>
                                <a class="btn btn-primary" href="#">浏览</a> <a class="btn" href="#">分享</a>
                            </p>
                        </div>
                    </div>
                </li>
                <li class="col-md-4">
                    <div class="thumbnail">
                        <img alt="300x200" src="${ctx}/img/a.jpg" />
                        <div class="caption">
                            <h3>
                                改进型哈佛结构
                            </h3>
                            <p>
                                改进型的哈佛结构具有一条独立的地址总线和一条独立的数据总线，两条总线由程序存储器和数据存储器分时复用，使结构更紧凑。
                            </p>
                            <p>
                                <a class="btn btn-primary" href="#">浏览</a> <a class="btn" href="#">分享</a>
                            </p>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
