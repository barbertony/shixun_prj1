<html>
<#include  "common/header.ftl">

<body>
<div id="wrapper" class="toggled">

    <#--边栏sidebar-->
    <#include "common/nav.ftl">

    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>类目id</th>
                            <th>名字</th>
                            <th>type</th>
                            <th>父类</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list categorylist as category>
                            <tr>
                                <td>${category.id}</td>
                                <td>${category.name}</td>
                                <td>${category.status}</td>
                                <td>${category.parentId}</td>
                                <td>${category.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                <td>${category.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                <td><a href="/user/category/update/${category.id}">修改</a></td>
                                <td><a href="/user/category/delete/${category.id}" onclick='return confirm("确定要删除吗?")'>删除</a></td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>