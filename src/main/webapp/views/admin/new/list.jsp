<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/api-admin-new" var="APIurl"/>
<c:url value="/admin-new" var="Homeurl"/>
<body>
<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">Tables</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                <li class="breadcrumb-item active">Tables</li>
            </ol>
            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-table me-1"></i>
                    DataTable News
                    <a class="btn btn-primary" href="<%=request.getContextPath()%>/admin-new-add" role="button">ADD NEW</a>
                    <a class="btn btn-primary" id="btnDelete" role="button">DELETE</a>
                </div>
                <div class="card-body">
                    <table id="datatablesSimple">
                        <thead>
                        <tr>
                            <th><input type="checkbox" id="checkAll" value=""></th>
                            <th>STT</th>
                            <th>Category</th>
                            <th>Title</th>
                            <th>Short Description</th>
                            <th>Thumbmail</th>
                            <th>Content</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th><input type="checkbox" id="check-all" value=""></th>
                            <th>STT</th>
                            <th>Category</th>
                            <th>Title</th>
                            <th>Short Description</th>
                            <th>Thumbmail</th>
                            <th>Content</th>
                            <th>Action</th>
                        </tr>
                        </tfoot>
                        <tbody>
                        <% int i = 1; %>
                        <c:forEach var="item" items="${model.listResult}">
                            <tr>
                                <td><input type="checkbox" id="check-${item.id}" value="${item.id}"></td>
                                <td>${i = i + 1}</td>
                                <td>${item.categoryId}</td>
                                <td>${item.title}</td>
                                <td>${item.shortDescription}</td>
                                <td><img src="<c:url value="/template/admin/assets/img/${item.thumbmail}"/> " height="100px" width="100px"/></td>
                                <td>${item.content}</td>
                                <td>
                                    <a class="nav-link" data-toggle="tooltip" title="Edit" href="${pageContext.request.contextPath}/admin-new-edit?id=<c:out value='${item.id}'/>">
                                        <div class="sb-nav-link-icon"><i class="fas fa-edit"></i></div>
                                    </a>
                                    <a class="nav-link" data-toggle="tooltip" title="Delete" href="${pageContext.request.contextPath}/admin-new-delete?id=<c:out value='${item.id}'/>">
                                        <div class="sb-nav-link-icon"><i class="fas fa-trash-alt"></i></div>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </main>
</div>
<script>
    $('#btnDelete').click(function () {
        var data = {};
        var ids = $('tbody input[type = checkbox]:checked').map(function () {
           return $(this).val();
        }).get();
        data['ids'] = ids;
        deleteNew(data);
    });
    function deleteNew(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
                window.location = "${Homeurl}";
            },
            error: function (error) {
                console.log(error);
            }
        });
    }
</script>
</body>